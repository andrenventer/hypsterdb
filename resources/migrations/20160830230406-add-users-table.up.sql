DROP TABLE IF EXISTS guestbook;

CREATE TABLE guestbook
(id SERIAL PRIMARY KEY,
 name VARCHAR(30),
 message VARCHAR(200),
 timestamp TIMESTAMP);

GRANT ALL PRIVILEGES ON guestbook TO hypster;
