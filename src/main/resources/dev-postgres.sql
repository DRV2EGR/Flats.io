-- NEED TO CREATE PROJECT ---------------

INSERT INTO roles (id, name) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN'),
(3, 'ROLE_SELLER');
(4, 'ROLE_REALTOR');

INSERT INTO flat_order_type (id, name) VALUES
(1, 'TYPE_SALE'),
(2, 'TYPE_RENT'),
(3, 'TYPE_DAILY_RENT');

-----------------------------------------------

INSERT INTO users (id, first_name, second_name, last_name, username, email, password, phone_number, role_id) VALUES
(1, 'John', 'Frederick', 'Smith', 'john_the_admin', 'j_smith@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 2),
(2, 'Денис', 'Даниилович', 'Воробьев', 'vorobiev.d.d', 'vorobievd.d@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 2),
(3, 'Александр', 'Михайлович', 'Богданов', 'bogdanov.a.m', 'bogdanov.a.m@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 3),
(4, 'Владимир ', 'Даниилович', 'Блинов', 'blinov.v.d', 'vorobievdd@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 1),
(5, 'Ксения', 'Владимировна', 'Вдовина', 'vdovina.k.v', 'vorobievdd@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 1),
(6, 'Михаил', 'Владиславович', 'Голованов', 'golovanov', 'golovanov.m.v@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 3),
(7, 'Иван', 'Иванович', 'Ивванов', 'ivanov', 'ivanov.m.v@rosatom.ru', '$2y$12$6G7v5bApu2ZRH7W.HV8NHuJs0W4pDQ3xMmXZSW1k03Dfvzk78lkaO', '+7000', 1);

INSERT INTO flats (id, country, town, street, house_nom, floor, price, description, flat_order_type_id, user_id) VALUES
(1, 'Россия', 'Москва', 'Красный казанец', 12, 10, 7000000, 'описание 1', 1, 2),
(2, 'Россия', 'Москва', 'Ивановское шоссе', 12, 10, 15000000, 'описание 2', 1, 2),
(3, 'Россия', 'Москва', 'Виноградова', 12, 10, 7854202.45, 'описание 3', 2, 2);

INSERT INTO flats_images (id, img_url, flat_id) VALUES
(1, 'http://img-fotki.yandex.ru/get/9300/102699435.9d8/0_b88f4_8fa30144_L.jpg', 2),
(2, 'https://anapacity.com/content/images/adygeya-10.jpg', 2);
