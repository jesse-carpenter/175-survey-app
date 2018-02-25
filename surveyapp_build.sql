-- SCHEMA: surveyapp

-- DROP SCHEMA surveyapp ;

CREATE SCHEMA surveyapp
    AUTHORIZATION postgres;
	

-- Table: surveyapp.questions

-- DROP TABLE surveyapp.questions;

CREATE TABLE surveyapp.questions
(
    question character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    category character varying(25) COLLATE pg_catalog."default" NOT NULL,
    id integer NOT NULL DEFAULT nextval('surveyapp.question_bank_id_seq'::regclass),
    likert boolean NOT NULL DEFAULT true,
    CONSTRAINT question_bank_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE surveyapp.questions
    OWNER to postgres;
	

-- Table: surveyapp.answers

-- DROP TABLE surveyapp.answers;

CREATE TABLE surveyapp.answers
(
    text_response character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    likert_response numeric(3,1) NOT NULL,
    user_id character varying(25) COLLATE pg_catalog."default" NOT NULL,
    id integer NOT NULL DEFAULT nextval('surveyapp.answers_id_seq'::regclass),
    category character varying(25) COLLATE pg_catalog."default" NOT NULL,
    q_id integer NOT NULL,
    response_date date NOT NULL DEFAULT CURRENT_DATE,
    CONSTRAINT answers_pkey PRIMARY KEY (id),
    CONSTRAINT answers_fkey FOREIGN KEY (q_id)
        REFERENCES surveyapp.questions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE surveyapp.answers
    OWNER to postgres;
	
	
	
