INSERT INTO users (username, password, enabled)
VALUES
    ('user', '$2a$12$FOB7BQZ7j7yQwzFACwsmUuE984VYi79FItIGOjOilNcXpgdWjDFaS', TRUE),
    ('admin', '$2a$12$FOB7BQZ7j7yQwzFACwsmUuE984VYi79FItIGOjOilNcXpgdWjDFaS', TRUE);


INSERT INTO authorities (username, authority)
VALUES
    ('user', 'ROLE_USER'),
    ('admin', 'ROLE_USER'),
    ('admin', 'ROLE_ADMIN');
