-- // insert_data
-- Migration SQL that makes the change goes here.
INSERT INTO country (country_id, name, part_country_id) VALUES
  (1, 'Россия', NULL),
  (2, 'Санкт-Петербург', 1),
  (3, 'Пушкин', 2),
  (4, 'Казахстан', NULL);

INSERT INTO complex (complex_id, name, country_id, address, part_complex_id) VALUES
  (1, 'Царское село', 2, 'Царскосельская улица', NULL),
  (2, 'Екатерининский парк', 1, NULL, 1);

INSERT INTO monument_type (monument_type_id, name, description) VALUES
  (1, 'Здание', 'Обособленное здание: дом, дворец и т. п.'),
  (2, 'Скульптура', 'Скульптура, памятник и т. п.'),
  (3, 'Ансамбль', 'Группа изолированных или объединенных памятников, строений и сооружений; парк, садб сквер, бульвар'),
  (4, 'Достопримечательное место', 'Памятные места, ландшафты, исторические поселения и т. п.');

INSERT INTO monument (monument_id, name, monument_type_id, description, complex_id, part_monument_id) VALUES
  (1, 'Эрмитажная аллея', 3, 'Аллея, соединяющая Екатерининский дворец с Эрмитажем. Вдоль нее установлены скульптуры героев античной мифологии', 2, NULL),
  (2, 'Парадный подъезд', 3, NULL, 2, NULL),
  (3, 'Галатея', 2, 'Галатея на дельфине с развевающимся над головой шарфом', 2, 1),
  (4, 'Геракл', 2, NULL, 2, 1),
  (5, 'Слава', 2, NULL, 2, 2);

INSERT INTO event_type (event_type_id, name, description) VALUES
  (1, 'Заказ', NULL),
  (2, 'Создание', 'Постройка, установка памятника'),
  (3, 'Переезд', NULL),
  (4, 'Реставрация', NULL),
  (5, 'Фотосъемка', NULL),
  (6, 'Проверка', NULL),
  (7, 'Наблюдение', NULL),
  (8, 'Запись', NULL),
  (9, 'Плановые работы', NULL);

INSERT INTO event (event_id, name, event_type_id, start_date, finit_date, part_event_id) VALUES
  (1, 'Подготовка к зиме', 9, '2009-10-01 10:00', '2009-10-17 17:00', NULL),
  (2, 'Заказ', 1, '1723-01-01 00:00', '1723-01-01 00:00', NULL),
  (3, 'Создание', 2, '1723-01-01 00:00', '1725-01-01 00:00', NULL),
  (4, 'Прибытие в Петербург', 3, '1725-01-01 00:00', '1725-01-01 00:00', NULL),
  (5, 'Установка в Летнем Саду', 3, '1725-01-01 00:00', '1725-01-01 00:00', NULL),
  (6, 'Установка в Царском Селе', 3, '1743-01-01 00:00', '1743-01-01 00:00', NULL),
  (7, 'Наблюдение', 7, '2009-06-26 00:00', '2009-06-28 00:00', NULL),
  (8, 'Фотосъёмка', 5, '2009-06-26 18:20', '2009-06-26 18:40', 7),
  (9, 'Описание наблюдений', 8, '2009-06-28 10:00', '2009-06-28 12:00', 7),
  (10, 'Наблюдение', 7, '2009-06-30 00:00', '2009-07-31 00:00', NULL),
  (11, 'Фотосъёмка', 5, '2009-07-30 15:10', '2009-07-30 15:35', 10),
  (12, 'Описание наблюдений', 8, '2009-07-30 15:10', '2009-07-30 15:35', 10);

INSERT INTO role(role_id, name) VALUES
  (1, 'Архитектор'),
  (2, 'Скульптор'),
  (3, 'Реставратор'),
  (4, 'Проверяющий'),
  (5, 'Наблюдаемый'),
  (6, 'Изменяемый'),
  (7, 'Заказчик'),
  (8, 'Исполнитель');

INSERT INTO complex_event (complex_event_id, complex_id, event_id, role_id) VALUES
  (1, 2, 1, 8);

INSERT INTO monument_event (monument_event_id, monument_id, event_id, role_id) VALUES
  (1, 5, 2, 6),
  (2, 5, 3, 6),
  (3, 5, 4, 6),
  (4, 5, 5, 6),
  (5, 5, 6, 6),
  (6, 5, 7, 5),
  (7, 5, 8, 5),
  (8, 5, 9, 5),
  (9, 5, 10, 5),
  (10, 5, 11, 5),
  (11, 5, 12, 5);

INSERT INTO photo_set (photo_set_id, description, event_id, part_photo_set_id) VALUES
  (1, 'Съемка скульптуры', 8, NULL);

-- //@UNDO
-- SQL to undo the change goes here.
TRUNCATE bio_destruction_event;
TRUNCATE bio_destruction;
TRUNCATE bio_destructor;
TRUNCATE bio_property;
TRUNCATE bio_class;
TRUNCATE photo;
TRUNCATE photo_set;
TRUNCATE document_event;
TRUNCATE document;
TRUNCATE document_type;
TRUNCATE file;
TRUNCATE monument_event;
TRUNCATE complex_event;
TRUNCATE material_event;
TRUNCATE material_data;
TRUNCATE material_property;
TRUNCATE material;
TRUNCATE participant;
TRUNCATE person;
TRUNCATE role;
TRUNCATE event;
TRUNCATE event_type;
TRUNCATE monument;
TRUNCATE monument_type;
TRUNCATE complex;
TRUNCATE country;
