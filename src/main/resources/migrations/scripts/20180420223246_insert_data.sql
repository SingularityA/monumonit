-- // insert_data
-- Migration SQL that makes the change goes here.
INSERT INTO country (name, part_country_id) VALUES
  ('Россия', NULL),
  ('Санкт-Петербург', 1),
  ('Пушкин', 2),
  ('Казахстан', NULL);

INSERT INTO complex (name, country_id, address, part_complex_id) VALUES
  ('Царское село', 2, 'Царскосельская улица', NULL),
  ('Екатерининский парк', 1, NULL, 1);

INSERT INTO monument_type (name, description) VALUES
  ('Здание', 'Обособленное здание: дом, дворец и т. п.'),
  ('Скульптура', 'Скульптура, памятник и т. п.'),
  ('Ансамбль', 'Группа изолированных или объединенных памятников, строений и сооружений; парк, садб сквер, бульвар'),
  ('Достопримечательное место', 'Памятные места, ландшафты, исторические поселения и т. п.');

INSERT INTO monument (name, monument_type_id, description, complex_id, part_monument_id) VALUES
  ('Эрмитажная аллея', 3, 'Аллея, соединяющая Екатерининский дворец с Эрмитажем. Вдоль нее установлены скульптуры героев античной мифологии', 2, NULL),
  ('Парадный подъезд', 3, NULL, 2, NULL),
  ('Галатея', 2, 'Галатея на дельфине с развевающимся над головой шарфом', 2, 1),
  ('Геракл', 2, NULL, 2, 1);

INSERT INTO event_type (name, description) VALUES
  ('Заказ', NULL),
  ('Создание', 'Постройка, установка памятника'),
  ('Переезд', NULL),
  ('Реставрация', NULL),
  ('Фотосъемка', NULL),
  ('Проверка', NULL),
  ('Наблюдение', NULL),
  ('Запись', NULL),
  ('Плановые работы', NULL);

INSERT INTO event (name, event_type_id, start_date, finit_date, part_event_id) VALUES
  ('Подготовка к зиме', 9, '2009-10-01 10:00', '2009-10-17 17:00', NULL),
  ('Заказ', 1, '1723-01-01 00:00', '1723-01-01 00:00', NULL),
  ('Создание', 2, '1723-01-01 00:00', '1725-01-01 00:00', NULL),
  ('Прибытие в Петербург', 3, '1725-01-01 00:00', '1725-01-01 00:00', NULL),
  ('Установка в Летнем Саду', 3, '1725-01-01 00:00', '1725-01-01 00:00', NULL),
  ('Установка в Царском Селе', 3, '1743-01-01 00:00', '1743-01-01 00:00', NULL),
  ('Наблюдение', 7, '2009-06-26 00:00', '2009-06-28 00:00', NULL),
  ('Фотосъёмка', 5, '2009-06-26 18:20', '2009-06-26 18:40', 7),
  ('Описание наблюдений', 8, '2009-06-28 10:00', '2009-06-28 12:00', 7),
  ('Наблюдение', 7, '2009-06-30 00:00', '2009-07-31 00:00', NULL),
  ('Фотосъёмка', 5, '2009-07-30 15:10', '2009-07-30 15:35', 10),
  ('Описание наблюдений', 8, '2009-07-30 15:10', '2009-07-30 15:35', 10);


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
