INSERT INTO users (username, password, enabled)
VALUES ('user', '$2a$12$FOB7BQZ7j7yQwzFACwsmUuE984VYi79FItIGOjOilNcXpgdWjDFaS', TRUE),
       ('admin', '$2a$12$FOB7BQZ7j7yQwzFACwsmUuE984VYi79FItIGOjOilNcXpgdWjDFaS', TRUE);


INSERT INTO authorities (username, authority)
VALUES ('user', 'ROLE_USER'),
       ('admin', 'ROLE_USER'),
       ('admin', 'ROLE_ADMIN');

INSERT INTO movies (category, description, summary, title, year)
VALUES ('horror', 'a snappy movie', 'snap', 'Jaws', 1979),
       ('crime', 'family drama', 'family drama', 'The Godfather', 1972),
       ('sf comedy', 'sf comedy', 'mars attacks', 'Mars Attacks', 1996),
       ('future tech', 'artificial intelligence', 'blade runner descr', 'Blade Runner 2049', 2017),
       ('fantasy', 'destroying a ring', 'first part of a journey to the land of Mordor', 'The Lord of the rings', 2001),
       ('anime', 'dystopia', 'akira summary', 'Akira', 1988);

insert into tickets (cinema, date, time, movieid, username)
VALUES (1, '12-12-2022', '20:00', 1, 'admin'),
       (2, '12-12-2022', '20:00', 1, 'admin'),
       (3, '02-01-2023', '19:00', 6, 'user'),
       (4, '15-01-2023', '23:00', 3, 'user');