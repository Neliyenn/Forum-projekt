ALTER TABLE POST
    ALTER COLUMN create_date SET DEFAULT CURRENT_TIMESTAMP;

--Uzytkownicy
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
   (1, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'user1@mail.com', 'user1', 'User', 'Surname1', 1);

INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
    (2, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'user2@gmail.com', 'user2', 'User', 'Surname2', 1);

INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
    (3, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'user3@mail.com', 'user3', 'User', 'Surname3', 1);


--Role
INSERT INTO ROLE (user_id, role)
VALUES (1, 'ROLE_ADMIN');

INSERT INTO ROLE (role_id, role)
VALUES (2, 'ROLE_USER');


--Role, Uzytkownicy
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 1)

INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 2)

INSERT INTO USER_ROLE (user_id, role_id)
VALUES (2, 2)

INSERT INTO USER_ROLE (user_id, role_id)
VALUES (3, 2)


--Posty
INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (1, 1, 'Title 1',
        'Lorem ipsum',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (2, 1, 'Title 2',
        'Lorem ipsum',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (3, 1, 'Title 3',
        'Lorem ipsum',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (4, 1, 'Title 4',
        'Lorem ipsum',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (5, 1, 'Title 5',
        'Lorem ipsum',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (6, 1, 'Title 6',
        'Lorem ipsum',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (7, 2, 'Title 7',
        'Lorem ipsum',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (8, 2, 'Title 8',
        'Lorem ipsum',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (9, 2, 'Title 9',
        'Lorem ipsum',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (10, 2, 'Title 10',
        'Lorem ipsum',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (11, 3, 'Title 11',
        'Lorem ipsum',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (12, 3, 'Title 12',
        'Lorem ipsum',  CURRENT_TIMESTAMP());


--Komentarze
INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (1, 1, 'Lorem ipsum', CURRENT_TIMESTAMP());

INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (1, 2, 'Lorem ipsum', CURRENT_TIMESTAMP());

INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (1, 3, 'Lorem ipsum', CURRENT_TIMESTAMP());

INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (6, 1, 'Lorem ipsum', CURRENT_TIMESTAMP());

INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (6, 2, 'Lorem ipsum', CURRENT_TIMESTAMP());

INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (6, 3, 'Lorem ipsum', CURRENT_TIMESTAMP());