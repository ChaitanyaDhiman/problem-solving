package com.app;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Main {
    public static void main(String[] args) {
        runAllInPackage("com.app");
    }

    private static void runAllInPackage(String pkg) {
        List<String> classNames = new ArrayList<>();
        String path = pkg.replace('.', '/');
        try {
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(path);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    String dirPath = decode(url.getPath());
                    findClassesInDirectory(new File(dirPath), pkg, classNames);
                } else if ("jar".equals(protocol)) {
                    try {
                        JarURLConnection conn = (JarURLConnection) url.openConnection();
                        JarFile jf = conn.getJarFile();
                        Enumeration<JarEntry> entries = jf.entries();
                        while (entries.hasMoreElements()) {
                            JarEntry entry = entries.nextElement();
                            String name = entry.getName();
                            if (name.startsWith(path) && name.endsWith(".class") && !entry.isDirectory()) {
                                String cn = name.replace('/', '.').replace(".class", "");
                                classNames.add(cn);
                            }
                        }
                    } catch (Exception ignored) {
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to scan package: " + e);
            return;
        }

        for (String cn : classNames) {
            if (cn.equals(Main.class.getName())) continue; // skip self
            try {
                Class<?> cls = Class.forName(cn);
                if (cls.isInterface() || java.lang.reflect.Modifier.isAbstract(cls.getModifiers())) {
                    continue;
                }

                // Try public static main(String[])
                try {
                    Method main = cls.getMethod("main", String[].class);
                    if (java.lang.reflect.Modifier.isStatic(main.getModifiers())) {
                        System.out.println("Invoking main of " + cn);
                        try {
                            main.invoke(null, (Object) new String[0]);
                        } catch (Exception ex) {
                            System.err.println("Invocation error for " + cn + ": " + ex.getCause());
                        }
                        continue;
                    }
                } catch (NoSuchMethodException ignored) {
                }

                // Try Runnable
                if (Runnable.class.isAssignableFrom(cls)) {
                    try {
                        Runnable r = (Runnable) cls.getDeclaredConstructor().newInstance();
                        System.out.println("Running Runnable " + cn);
                        r.run();
                    } catch (Exception ex) {
                        System.err.println("Failed to run Runnable " + cn + ": " + ex);
                    }
                    continue;
                }

                System.out.println("No runnable entry point for " + cn);
            } catch (Throwable t) {
                System.err.println("Could not load " + cn + ": " + t);
            }
        }
    }

    private static void findClassesInDirectory(File dir, String pkg, List<String> out) {
        if (!dir.exists() || !dir.isDirectory()) return;
        File[] files = dir.listFiles();
        if (files == null) return;
        for (File f : files) {
            if (f.isDirectory()) {
                findClassesInDirectory(f, pkg + "." + f.getName(), out);
            } else if (f.getName().endsWith(".class")) {
                String name = f.getName();
                out.add(pkg + "." + name.substring(0, name.length() - 6));
            }
        }
    }

    private static String decode(String s) {
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return s;
        }
    }
}