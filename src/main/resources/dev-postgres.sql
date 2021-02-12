INSERT INTO roles (id, name) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN'),
(3, 'ROLE_INITIATOR'),
(4, 'ROLE_CURATOR'),
(5, 'ROLE_INVESTOR');

INSERT INTO users (id, first_name, second_name, last_name, username, email, password, phone_number, role_id) VALUES
(1, 'John', 'Frederick', 'Smith', 'john_the_admin', 'j_smith@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 2),
(2, 'Денис', 'Даниилович', 'Воробьев', 'vorobiev.d.d', 'vorobievd.d@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 2),
(3, 'Александр', 'Михайлович', 'Богданов', 'bogdanov.a.m', 'bogdanov.a.m@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 3),
(4, 'Владимир ', 'Даниилович', 'Блинов', 'blinov.v.d', 'vorobievdd@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 4),
(5, 'Ксения', 'Владимировна', 'Вдовина', 'vdovina.k.v', 'vorobievdd@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 5),
(6, 'Михаил', 'Владиславович', 'Голованов', 'golovanov', 'golovanov.m.v@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 3),
(7, 'Иван', 'Иванович', 'Ивванов', 'ivanov', 'ivanov.m.v@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 4);

INSERT INTO flats (id, country, town, street, house_nom, floor, description, user_id) VALUES
(1, 'Россия', 'Москва', 'Красный казанец', 12, 10, 'описание 1', 2),
(2, 'Россия', 'Москва', 'Ивановское шоссе', 12, 10, 'описание 2', 2),
(3, 'Россия', 'Москва', 'Виноградова', 12, 10, 'описание 3', 2);