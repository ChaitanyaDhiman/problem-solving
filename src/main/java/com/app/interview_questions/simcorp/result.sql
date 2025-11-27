-- Create the table
CREATE TABLE metrics (
    id INT,
    batch VARCHAR(50),
    name VARCHAR(50),
    output INT,
    "user" VARCHAR(50),
    date DATE
);

-- Insert the data
INSERT INTO metrics (id, batch, name, output, "user", date) VALUES
(2, 'abc', 'Yahoo', 120, 'test', '2024-05-02'),
(3, 'abc', 'Google', 130, 'test', '2024-05-02'),
(4, 'abc', 'TATA', 130, 'test', '2024-05-02'),
(5, 'xyz', 'Yahoo', 123, 'test', '2024-05-03'),
(6, 'xyz', 'Google', 133, 'test', '2024-05-03'),
(7, 'xyz', 'Apple', 133, 'test', '2024-05-03'),
(8, 'def', 'Yahoo', 125, 'dev', '2024-05-04'),
(9, 'def', 'Google', 135, 'dev', '2024-05-04');

-- Query to get the maximum output for each batch
SELECT name, MAX(date)
FROM metrics
GROUP BY name;

-- Query to get latest result from batch = 'Google' with user = 'test'
SELECT *
FROM metrics
WHERE name = 'Google' AND "user" = 'test'
ORDER BY date DESC, id DESC
LIMIT 1;

-- Query to get latest results for all names for user "test"
SELECT DISTINCT ON (name) *
FROM metrics
WHERE "user" = 'test'
ORDER BY name, date DESC, id DESC;