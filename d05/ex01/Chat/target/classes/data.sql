INSERT INTO Chat.Users (login, password)
 VALUES ('Alex', '123');
INSERT INTO Chat.Users (login, password)
 VALUES ('Igor', '321');
INSERT INTO Chat.Users (login, password)
 VALUES ('Anton', '456');
INSERT INTO Chat.Users (login, password)
 VALUES ('Olya', '123123dsfdf');
INSERT INTO Chat.Users (login, password)
 VALUES ('Masha', '1231231dfsdf');

INSERT INTO Chat.Rooms (name, owner)
 VALUES ('Home room', 1);
INSERT INTO Chat.Rooms (name, owner)
 VALUES ('Just chilling', 2);
INSERT INTO Chat.Rooms (name, owner)
 VALUES ('Friendly room', 3);
INSERT INTO Chat.Rooms (name, owner)
 VALUES ('Trolling room', 4);
INSERT INTO Chat.Rooms (name, owner)
 VALUES ('Test room', 5);

INSERT INTO Chat.Messages (author, room, text, timestamp)
 VALUES (1, 1, 'Hello', '2022-01-01 00:00:01');
INSERT INTO Chat.Messages (author, room, text, timestamp)
VALUES (2, 3, 'piupiupiu', '2021-01-01 00:00:01');
INSERT INTO Chat.Messages (author, room, text, timestamp)
VALUES (5, 3, 'blablabla', '2091-01-01 00:00:02');
INSERT INTO Chat.Messages (author, room, text, timestamp)
VALUES (4, 4, '12345', '2022-01-01 00:00:04');
INSERT INTO Chat.Messages (author, room, text, timestamp)
VALUES (5, 5, 'sdsfsdfsdfsdffd', '2022-03-11 00:00:05');