-- // First migration.
-- Migration SQL that makes the change goes here.

-- COUNTRY
CREATE TABLE country (
  country_id       SERIAL8      NOT NULL,
  name             VARCHAR(100) NOT NULL,
  part_country_id  BIGINT,
  PRIMARY KEY(country_id),
  CONSTRAINT country_self_ref_constraint CHECK (part_country_id != country_id)
);

-- COMPLEX
CREATE TABLE complex (
  complex_id       SERIAL8      NOT NULL,
  name             VARCHAR(100) NOT NULL,
  country_id       BIGINT       NOT NULL,
  address          VARCHAR(200),
  part_complex_id  BIGINT,
  PRIMARY KEY(complex_id),
  CONSTRAINT complex_self_ref_constraint CHECK (part_complex_id != complex_id)
);

-- MONUMENT_TYPE
CREATE TABLE monument_type (
  monument_type_id  SERIAL       NOT NULL,
  name              VARCHAR(100) NOT NULL,
  description       VARCHAR(200),
  PRIMARY KEY(monument_type_id)
);

-- MONUMENT
CREATE TABLE monument (
  monument_id       SERIAL8      NOT NULL,
  name              VARCHAR(100) NOT NULL,
  monument_type_id  INTEGER      NOT NULL,
  description       VARCHAR(200),
  complex_id        BIGINT,
  part_monument_id  BIGINT,
  PRIMARY KEY(monument_id),
  CONSTRAINT monument_self_ref_constraint CHECK (part_monument_id != monument_id)
);

-- EVENT_TYPE
CREATE TABLE event_type (
  event_type_id  SERIAL       NOT NULL,
  name           VARCHAR(100) NOT NULL,
  description    VARCHAR(400),
  PRIMARY KEY(event_type_id)
);

-- EVENT
CREATE TABLE event (
  event_id       SERIAL8      NOT NULL,
  name           VARCHAR(200) NOT NULL,
  event_type_id  INTEGER      NOT NULL,
  start_date     TIMESTAMP,
  finit_date     TIMESTAMP,
  part_event_id  BIGINT,
  PRIMARY KEY(event_id)
);

-- ROLE
CREATE TABLE role (
  role_id      SERIAL       NOT NULL,
  name         VARCHAR(100) NOT NULL,
  description  VARCHAR(200),
  PRIMARY KEY(role_id)
);

-- PERSON
CREATE TABLE person (
  person_id     SERIAL8      NOT NULL,
  full_name     VARCHAR(100) NOT NULL,
  first_name    VARCHAR(20)  NOT NULL,
  last_name     VARCHAR(20)  NOT NULL,
  pattern_name  VARCHAR(20),
  second_name   VARCHAR(20),
  birth_date    DATE         NOT NULL,
  death_date    DATE,
  PRIMARY KEY(person_id)
);

-- PARTICIPANT
CREATE TABLE participant (
  person_id  BIGINT  NOT NULL,
  event_id   BIGINT  NOT NULL,
  role_id    INTEGER NOT NULL,
  UNIQUE(person_id, event_id, role_id)
);

-- MATERIAL
CREATE TABLE material (
  material_id       SERIAL8      NOT NULL,
  name              VARCHAR(100) NOT NULL,
  part_material_id  BIGINT,
  is_base           BOOLEAN,
  PRIMARY KEY(material_id),
  CONSTRAINT material_self_ref_constraint CHECK (part_material_id != material_id)
);

-- MATERIAL_PROPERTY
CREATE TABLE material_property (
  material_property_id       SERIAL8      NOT NULL,
  name                       VARCHAR(100) NOT NULL,
  part_material_property_id  BIGINT,
  is_abstract                BOOLEAN,
  PRIMARY KEY(material_property_id),
  CONSTRAINT material_property_self_ref_constraint CHECK (part_material_property_id != material_property_id)
);

-- MATERIAL_DATA
CREATE TABLE material_data (
  material_data_id      SERIAL8      NOT NULL,
  material_id           BIGINT       NOT NULL,
  material_property_id  BIGINT       NOT NULL,
  value                 VARCHAR(100) NOT NULL,
  PRIMARY KEY(material_data_id),
  UNIQUE(material_id, material_property_id)
);

-- MATERIAL_EVENT
CREATE TABLE material_event (
  material_id  BIGINT NOT NULL,
  event_id     BIGINT NOT NULL,
  UNIQUE(material_id, event_id)
);

-- COMPLEX_EVENT
CREATE TABLE complex_event (
  complex_id  BIGINT  NOT NULL,
  event_id    BIGINT  NOT NULL,
  role_id     INTEGER NOT NULL,
  UNIQUE(complex_id, event_id, role_id)
);

-- MONUMENT_EVENT
CREATE TABLE monument_event (
  monument_id  BIGINT  NOT NULL,
  event_id     BIGINT  NOT NULL,
  role_id      INTEGER NOT NULL,
  UNIQUE(monument_id, event_id, role_id)
);

-- FILE
CREATE TABLE file (
  file_id         SERIAL8      NOT NULL,
  name            VARCHAR(100) NOT NULL,
  file_path       VARCHAR(250) NOT NULL,
  content_type    VARCHAR(100),
  PRIMARY KEY (file_id),
  UNIQUE(file_id, file_path)
);

-- DOCUMENT_TYPE
CREATE TABLE document_type (
  document_type_id    SERIAL       NOT NULL,
  name                VARCHAR(100) NOT NULL,
  -- example, form
  document_id         BIGINT,
  PRIMARY KEY (document_type_id)
);

-- DOCUMENT
CREATE TABLE document (
  document_id       SERIAL8   NOT NULL,
  creation_time     TIMESTAMP NOT NULL,
  last_edit_time    TIMESTAMP NOT NULL,
  bin_data_id       BIGINT    NOT NULL,
  version           VARCHAR(100),
  document_type_id  INTEGER   NOT NULL,
  next_document_id  BIGINT,
  last_document_id  BIGINT,
  description       VARCHAR(500),
  PRIMARY KEY (document_id)
);

-- DOCUMENT_EVENT
CREATE TABLE document_event (
  document_id  BIGINT NOT NULL,
  event_id     BIGINT NOT NULL,
  UNIQUE(document_id, event_id)
);

-- PHOTO_SET
CREATE TABLE photo_set (
  photo_set_id       SERIAL8 NOT NULL,
  description        VARCHAR(500),
  event_id           BIGINT  NOT NULL,
  part_photo_set_id  BIGINT,
  PRIMARY KEY (photo_set_id),
  CONSTRAINT photo_set_self_ref_constraint CHECK (part_photo_set_id != photo_set_id)
);

-- PHOTO
CREATE TABLE photo (
  photo_id         SERIAL8 NOT NULL,
  document_id      BIGINT,
  camera           VARCHAR(100),
  objective        VARCHAR(100),
  exposition       VARCHAR(100),
  filter           VARCHAR(100),
  shoot_condition  VARCHAR(500),
  photo_set_id     BIGINT,
  PRIMARY KEY (photo_id)
);

-- BIO_CLASS
CREATE TABLE bio_class (
  bio_class_id       SERIAL8      NOT NULL,
  name               VARCHAR(100) NOT NULL,
  latin_name         VARCHAR(100) NOT NULL,
  part_bio_class_id  BIGINT,
  PRIMARY KEY (bio_class_id),
  CONSTRAINT bio_class_self_ref_constraint CHECK (part_bio_class_id != bio_class_id)
);

-- BIO_PROPERTIES
CREATE TABLE bio_property (
  bio_class_id  BIGINT NOT NULL,
  document_id   BIGINT NOT NULL,
  UNIQUE(bio_class_id, document_id)
);

-- BIO_DESTRUCTOR
CREATE TABLE bio_destructor (
  bio_destructor_id  SERIAL8 NOT NULL UNIQUE,
  bio_class_id       BIGINT  NOT NULL UNIQUE,
  document_id        BIGINT,
  hazard             INTEGER NOT NULL,
  PRIMARY KEY (bio_destructor_id),
  UNIQUE(bio_destructor_id, bio_class_id)
);

-- BIO_DESTRUCTION
CREATE TABLE bio_destruction (
  bio_destruction_id       SERIAL8      NOT NULL,
  name                     VARCHAR(100) NOT NULL,
  document_id              BIGINT,
  danger                   INTEGER      NOT NULL,
  part_bio_destruction_id  BIGINT,
  PRIMARY KEY (bio_destruction_id),
  CONSTRAINT bio_destruction_self_ref_constraint CHECK (part_bio_destruction_id != bio_destruction_id)
);

-- BIO_DESTRUCTION_CAUSE
CREATE TABLE bio_destruction_cause (
  bio_destruction_id  BIGINT NOT NULL,
  bio_destructor_id   BIGINT NOT NULL,
  UNIQUE(bio_destruction_id, bio_destructor_id)
);

-- BIO_DESTRUCTION_EVENT
CREATE TABLE bio_destruction_event (
  bio_destruction_id  BIGINT NOT NULL,
  event_id            BIGINT NOT NULL,
  UNIQUE(bio_destruction_id, event_id)
);

-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE bio_destruction_event;
DROP TABLE bio_destruction_cause;
DROP TABLE bio_destruction;
DROP TABLE bio_destructor;
DROP TABLE bio_property;
DROP TABLE bio_class;
DROP TABLE photo;
DROP TABLE photo_set;
DROP TABLE document_event;
DROP TABLE document;
DROP TABLE document_type;
DROP TABLE file;
DROP TABLE monument_event;
DROP TABLE complex_event;
DROP TABLE material_event;
DROP TABLE material_data;
DROP TABLE material_property;
DROP TABLE material;
DROP TABLE participant;
DROP TABLE person;
DROP TABLE role;
DROP TABLE event;
DROP TABLE event_type;
DROP TABLE monument;
DROP TABLE monument_type;
DROP TABLE complex;
DROP TABLE country;
