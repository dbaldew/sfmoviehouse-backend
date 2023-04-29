INSERT INTO users (username, password, enabled)
VALUES ('user', '$2a$12$FOB7BQZ7j7yQwzFACwsmUuE984VYi79FItIGOjOilNcXpgdWjDFaS', TRUE),
       ('admin', '$2a$12$FOB7BQZ7j7yQwzFACwsmUuE984VYi79FItIGOjOilNcXpgdWjDFaS', TRUE);


INSERT INTO authorities (username, authority)
VALUES ('user', 'ROLE_USER'),
       ('admin', 'ROLE_USER'),
       ('admin', 'ROLE_ADMIN');

INSERT INTO movies (category, description, summary, title, year)
VALUES ('horror', 'When a killer shark unleashes chaos on a beach community off Cape Cod, it''s up to a local sheriff, a marine biologist, and an old seafarer to hunt the beast down.', 'Jaws summary', 'Jaws', 1979),
       ('sf comedy', 'Earth is invaded by Martians with unbeatable weapons and a cruel sense of humor.', 'Mars attacks summary', 'Mars Attacks', 1996),
       ('future tech', 'Young Blade Runner K''s discovery of a long-buried secret leads him to track down former Blade Runner Rick Deckard, who''s been missing for thirty years.', 'Blade Runner summary', 'Blade Runner 2049', 2017),
       ('fantasy', 'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.', 'The Lord of the Rings: The Fellowship of the Ring summary', 'The Lord of the Rings: The Fellowship of the Ring', 2001),
       ('anime', 'A secret military project endangers Neo-Tokyo when it turns a biker gang member into a rampaging psychic psychopath who can only be stopped by a teenager, his gang of biker friends and a group of psychics.', 'Akira summary', 'Akira', 1988);

insert into tickets (cinema, date, time, movieid, username)
VALUES (1, '12-12-2022', '20:00', 1, 'admin'),
       (2, '12-12-2022', '20:00', 1, 'admin'),
       (3, '02-01-2023', '19:00', 4, 'user'),
       (4, '15-01-2023', '23:00', 3, 'user');