CREATE TABLE persoana(
                         id         INT PRIMARY KEY,
                         first_name VARCHAR(100) NOT NULL,
                         last_name  VARCHAR(100) NOT NULL,
                         email      VARCHAR(100) NOT NULL UNIQUE,
                         gender     CHAR,
                         adresa_id  INT,
                         FOREIGN KEY (adresa_id) REFERENCES adresa (id)
);