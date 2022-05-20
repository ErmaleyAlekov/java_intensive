INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
 VALUES ('Alex', '123', '1', '1,2');
INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
 VALUES ('Igor', '321', '2', '1,2');
INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
 VALUES ('Anton', '456', '3', '3,2');
INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
 VALUES ('Olya', '123123dsfdf', '4', '4,2');
INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
 VALUES ('Masha', '1231231dfsdf','5', '5,1');
INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
 VALUES ('Alex2', '123', '6', '1,2');
INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
 VALUES ('Igor2', '321', '7', '1,2');
INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
 VALUES ('Anton2', '456', '8', '3,2');
INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
 VALUES ('Olya2', '123123dsfdf', '12', '4,2');
INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
 VALUES ('Masha2', '1231231dfsdf','13', '5,1');
 INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
  VALUES ('Alex3', '123', '14', '1');
 INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
  VALUES ('Igor3', '321', '15', '2');
 INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
  VALUES ('Anton3', '456', '16', '3');
 INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
  VALUES ('Olya3', '123123dsfdf', '17', '4');
 INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
  VALUES ('Masha3', '1231231dfsdf','18', '5');
INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
  VALUES ('Alex4', '123', '119', '23');
 INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
  VALUES ('Igor4', '321', '25', '26');
 INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
  VALUES ('Anton4', '456', '21', '42');
 INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
  VALUES ('Olya4', '123123dsfdf', '54', '32');
 INSERT INTO Chat.Users (login, password, createdrooms, allrooms)
  VALUES ('Masha4', '1231231dfsdf','45', '38');

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