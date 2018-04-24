-- // add_foreign_keys
-- Migration SQL that makes the change goes here.

-- COUNTRY ->> PART_COUNTRY
ALTER TABLE country ADD CONSTRAINT country__part_country_fkey FOREIGN KEY (part_country_id) REFERENCES country(country_id);

-- COMPLEX ->> COUNTRY
ALTER TABLE complex ADD CONSTRAINT complex__country_fkey FOREIGN KEY (country_id) REFERENCES country(country_id);
-- COMPLEX ->> PART_COMPLEX
ALTER TABLE complex ADD CONSTRAINT complex__part_complex_fkey FOREIGN KEY (part_complex_id) REFERENCES complex(complex_id);

-- MONUMENT ->> MONUMENT_TYPE
ALTER TABLE monument ADD CONSTRAINT monument__monument_type_fkey FOREIGN KEY (monument_type_id) REFERENCES monument_type(monument_type_id);
-- MONUMENT ->> COMPLEX
ALTER TABLE monument ADD CONSTRAINT monument__complex_fkey FOREIGN KEY (complex_id) REFERENCES complex(complex_id);
-- MONUMENT ->> PART_MONUMENT
ALTER TABLE monument ADD CONSTRAINT monument__part_monument_fkey FOREIGN KEY (part_monument_id) REFERENCES monument(monument_id);

-- EVENT ->> EVENT_TYPE
ALTER TABLE event ADD CONSTRAINT event__event_type_fkey FOREIGN KEY (event_type_id) REFERENCES event_type(event_type_id);
-- EVENT ->> PART_EVENT
ALTER TABLE event ADD CONSTRAINT event__part_event_fkey FOREIGN KEY (part_event_id) REFERENCES event(event_id);

-- PARTICIPANT ->> PERSON
ALTER TABLE participant ADD CONSTRAINT participant__person_fkey FOREIGN KEY (person_id) REFERENCES person(person_id);
-- PARTICIPANT ->> EVENT
ALTER TABLE participant ADD CONSTRAINT participant__event_fkey FOREIGN KEY (event_id) REFERENCES event(event_id);
-- PARTICIPANT ->> ROLE
ALTER TABLE participant ADD CONSTRAINT participant__role_fkey FOREIGN KEY (role_id) REFERENCES role(role_id);

-- MATERIAL ->> PART_MATERIAL
ALTER TABLE material ADD CONSTRAINT material__part_material_fkey FOREIGN KEY (part_material_id) REFERENCES material(material_id);

-- MATERIAL_PROPERTY ->> PART_MATERIAL_PROPERTY
ALTER TABLE material_property ADD CONSTRAINT material_prop__part_material_prop_fkey
	FOREIGN KEY (part_material_property_id) REFERENCES material_property(material_property_id);

-- MATERIAL_DATA ->> MATERIAL
ALTER TABLE material_data ADD CONSTRAINT material_data__material_fkey FOREIGN KEY (material_id) REFERENCES material(material_id);
-- MATERIAL_DATA ->> MATERIAL_PROPERTY
ALTER TABLE material_data ADD CONSTRAINT material_data__material_prop_fkey
	FOREIGN KEY (material_property_id) REFERENCES material_property(material_property_id);

-- MATERIAL_EVENT ->> MATERIAL
ALTER TABLE material_event ADD CONSTRAINT material_event__material_fkey FOREIGN KEY (material_id) REFERENCES material(material_id);
-- MATERIAL_EVENT ->> EVENT
ALTER TABLE material_event ADD CONSTRAINT material_event__event_fkey FOREIGN KEY (event_id) REFERENCES event(event_id);

-- COMPLEX_EVENT ->> COMPLEX
ALTER TABLE complex_event ADD CONSTRAINT complex_event__complex_fkey FOREIGN KEY (complex_id) REFERENCES complex(complex_id);
-- COMPLEX_EVENT ->> EVENT
ALTER TABLE complex_event ADD CONSTRAINT complex_event__event_fkey FOREIGN KEY (event_id) REFERENCES event(event_id);
-- COMPLEX_EVENT ->> ROLE
ALTER TABLE complex_event ADD CONSTRAINT complex_event__role_fkey FOREIGN KEY (role_id) REFERENCES role(role_id);

-- MONUMENT_EVENT ->> MONUMENT
ALTER TABLE monument_event ADD CONSTRAINT monument_event__monument_fkey FOREIGN KEY (monument_id) REFERENCES monument(monument_id);
-- MONUMENT_EVENT ->> EVENT
ALTER TABLE monument_event ADD CONSTRAINT monument_event__event_fkey FOREIGN KEY (event_id) REFERENCES event(event_id);
-- MONUMENT_EVENT ->> ROLE
ALTER TABLE monument_event ADD CONSTRAINT monument_event__role_fkey FOREIGN KEY (role_id) REFERENCES role(role_id);

-- DOCUMENT ->> DOCUMENT_TYPE
ALTER TABLE document ADD CONSTRAINT document__document_type_fkey FOREIGN KEY (document_type_id) REFERENCES document_type(document_type_id);
-- DOCUMENT ->> NEXT_DOCUMENT
ALTER TABLE document ADD CONSTRAINT document__next_doc_fkey FOREIGN KEY (next_document_id) REFERENCES document(document_id);
-- DOCUMENT ->> LAST_DOCUMENT
ALTER TABLE document ADD CONSTRAINT document__last_doc_fkey FOREIGN KEY (last_document_id) REFERENCES document(document_id);

-- DOCUMENT_EVENT ->> DOCUMENT
ALTER TABLE document_event ADD CONSTRAINT document_event__document_fkey FOREIGN KEY (document_id) REFERENCES document(document_id);
-- DOCUMENT_EVENT ->> EVENT
ALTER TABLE document_event ADD CONSTRAINT document_event__event_fkey FOREIGN KEY (event_id) REFERENCES event(event_id);

-- PHOTO_SET ->> EVENT
ALTER TABLE photo_set ADD CONSTRAINT photo_set__event_fkey FOREIGN KEY (event_id) REFERENCES event(event_id);
-- PHOTO_SET ->> PART_PHOTO_SET
ALTER TABLE photo_set ADD CONSTRAINT photo_set__part_photo_set_fkey FOREIGN KEY (part_photo_set_id) REFERENCES photo_set(photo_set_id);

-- PHOTO ->> PHOTO_SET
ALTER TABLE photo ADD CONSTRAINT photo__photo_set_fkey FOREIGN KEY (photo_set_id) REFERENCES photo_set(photo_set_id);
-- PHOTO ->> DOCUMENT
ALTER TABLE photo ADD CONSTRAINT photo__document_fkey FOREIGN KEY (document_id) REFERENCES document(document_id);

-- BIO_CLASS ->> PART_BIO_CLASS
ALTER TABLE bio_class ADD CONSTRAINT bio_class__part_bio_class_fkey FOREIGN KEY (part_bio_class_id) REFERENCES bio_class(bio_class_id);

-- BIO_PROPERTIES ->> BIO_CLASS
ALTER TABLE bio_property ADD CONSTRAINT bio_prop__bio_class_fkey FOREIGN KEY (bio_class_id) REFERENCES bio_class(bio_class_id);
-- BIO_PROPERTIES ->> DOCUMENT
ALTER TABLE bio_property ADD CONSTRAINT bio_prop__document_fkey FOREIGN KEY (document_id) REFERENCES document(document_id);

-- BIO_DESTRUCTOR ->> BIO_CLASS
ALTER TABLE bio_destructor ADD CONSTRAINT bio_destructor__bio_class_fkey
	FOREIGN KEY (bio_class_id) REFERENCES bio_class(bio_class_id);
-- BIO_DESTRUCTOR ->> DOCUMENT
ALTER TABLE bio_destructor ADD CONSTRAINT bio_destructor__document_fkey
	FOREIGN KEY (document_id) REFERENCES document(document_id);

-- BIO_DESTRUCTION ->> DOCUMENT
ALTER TABLE bio_destruction ADD CONSTRAINT bio_destruction__document_fkey
	FOREIGN KEY (document_id) REFERENCES document(document_id);
-- BIO_DESTRUCTION ->> PART_BIO_DESTRUCTION
ALTER TABLE bio_destruction ADD CONSTRAINT bio_destruction__part_bio_destruction_fkey
	FOREIGN KEY (part_bio_destruction_id) REFERENCES bio_destruction(bio_destruction_id);

-- BIO_DESTRUCTION_CAUSE ->> BIO_DESTRUCTION
ALTER TABLE bio_destruction_cause ADD CONSTRAINT bio_destruction_cause__bio_destruction_fkey
	FOREIGN KEY (bio_destruction_id) REFERENCES bio_destruction(bio_destruction_id);
-- BIO_DESTRUCTION_CAUSE ->> BIO_DESTRUCTOR
ALTER TABLE bio_destruction_cause ADD CONSTRAINT bio_destruction_cause__bio_destructor_fkey
	FOREIGN KEY (bio_destructor_id) REFERENCES bio_destructor(bio_destructor_id);

-- BIO_DESTRUCTION_EVENT ->> BIO_DESTRUCTION
ALTER TABLE bio_destruction_event ADD CONSTRAINT bio_destruction_event__bio_destruction_fkey
	FOREIGN KEY (bio_destruction_id) REFERENCES bio_destruction(bio_destruction_id);
-- BIO_DESTRUCTION_EVENT ->> EVENT
ALTER TABLE bio_destruction_event ADD CONSTRAINT bio_destruction_event__event_fkey
	FOREIGN KEY (event_id) REFERENCES event(event_id);

-- //@UNDO
-- SQL to undo the change goes here.
ALTER TABLE bio_destruction_event DROP CONSTRAINT bio_destruction_event__event_fkey;
ALTER TABLE bio_destruction_event DROP CONSTRAINT bio_destruction_event__bio_destruction_fkey;

ALTER TABLE bio_destruction_cause DROP CONSTRAINT bio_destruction_cause__bio_destructor_fkey;
ALTER TABLE bio_destruction_cause DROP CONSTRAINT bio_destruction_cause__bio_destruction_fkey;

ALTER TABLE bio_destruction DROP CONSTRAINT bio_destruction__part_bio_destruction_fkey;
ALTER TABLE bio_destruction DROP CONSTRAINT bio_destruction__document_fkey;

ALTER TABLE bio_destructor DROP CONSTRAINT bio_destructor__document_fkey;
ALTER TABLE bio_destructor DROP CONSTRAINT bio_destructor__bio_class_fkey;

ALTER TABLE bio_property DROP CONSTRAINT bio_prop__document_fkey;
ALTER TABLE bio_property DROP CONSTRAINT bio_prop__bio_class_fkey;

ALTER TABLE bio_class DROP CONSTRAINT bio_class__part_bio_class_fkey;

ALTER TABLE photo DROP CONSTRAINT photo__document_fkey;
ALTER TABLE photo DROP CONSTRAINT photo__photo_set_fkey;

ALTER TABLE photo_set DROP CONSTRAINT photo_set__part_photo_set_fkey;
ALTER TABLE photo_set DROP CONSTRAINT photo_set__event_fkey;

ALTER TABLE document_event DROP CONSTRAINT document_event__event_fkey;
ALTER TABLE document_event DROP CONSTRAINT document_event__document_fkey;

ALTER TABLE document DROP CONSTRAINT document__last_doc_fkey;
ALTER TABLE document DROP CONSTRAINT document__next_doc_fkey;
ALTER TABLE document DROP CONSTRAINT document__document_type_fkey;

ALTER TABLE monument_event DROP CONSTRAINT monument_event__role_fkey;
ALTER TABLE monument_event DROP CONSTRAINT monument_event__event_fkey;
ALTER TABLE monument_event DROP CONSTRAINT monument_event__monument_fkey;

ALTER TABLE complex_event DROP CONSTRAINT complex_event__role_fkey;
ALTER TABLE complex_event DROP CONSTRAINT complex_event__event_fkey;
ALTER TABLE complex_event DROP CONSTRAINT complex_event__complex_fkey;

ALTER TABLE material_event DROP CONSTRAINT material_event__event_fkey;
ALTER TABLE material_event DROP CONSTRAINT material_event__material_fkey;

ALTER TABLE material_data DROP CONSTRAINT material_data__material_prop_fkey;
ALTER TABLE material_data DROP CONSTRAINT material_data__material_fkey;

ALTER TABLE material_property DROP CONSTRAINT material_prop__part_material_prop_fkey;

ALTER TABLE material DROP CONSTRAINT material__part_material_fkey;

ALTER TABLE participant DROP CONSTRAINT participant__role_fkey;
ALTER TABLE participant DROP CONSTRAINT participant__event_fkey;
ALTER TABLE participant DROP CONSTRAINT participant__person_fkey;

ALTER TABLE event DROP CONSTRAINT event__part_event_fkey;
ALTER TABLE event DROP CONSTRAINT event__event_type_fkey;

ALTER TABLE monument DROP CONSTRAINT monument__part_monument_fkey;
ALTER TABLE monument DROP CONSTRAINT monument__complex_fkey;
ALTER TABLE monument DROP CONSTRAINT monument__monument_type_fkey;

ALTER TABLE complex DROP CONSTRAINT complex__part_complex_fkey;
ALTER TABLE complex DROP CONSTRAINT complex__country_fkey;

ALTER TABLE country DROP CONSTRAINT country__part_country_fkey;
