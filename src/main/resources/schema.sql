CREATE TABLE IF NOT EXISTS taskTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title varchar(50) NOT NULL,
    status varchar(50) NOT NULL,
    localDateTime DATE
);