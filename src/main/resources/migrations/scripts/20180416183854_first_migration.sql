-- // First migration.
-- Migration SQL that makes the change goes here.

-- MONUMENT
CREATE TABLE monument (
  monument_id       SERIAL8      NOT NULL,
  name              VARCHAR(100) NOT NULL,
  complex_id        BIGINT,
  part_monument_id  BIGINT,
  PRIMARY KEY (monument_id)
);

INSERT INTO monument (name, complex_id) VALUES ('TestName1', 1);
INSERT INTO monument (name, complex_id) VALUES ('TestName2', 2);
INSERT INTO monument (name, complex_id) VALUES ('TestName3', 3);

-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE monument;
