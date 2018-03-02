-- SCHEMA: surveyapp

-- DROP SCHEMA surveyapp ;

CREATE SCHEMA surveyapp
    AUTHORIZATION postgres;

-- Table: surveyapp.answer

-- DROP TABLE surveyapp.answer;

CREATE TABLE surveyapp.answer
(
    text_response character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    likert_response numeric(3,1) NOT NULL,
    user_id character varying(25) COLLATE pg_catalog."default" NOT NULL,
    id integer NOT NULL DEFAULT nextval('surveyapp.answers_id_seq'::regclass),
    category character varying(25) COLLATE pg_catalog."default" NOT NULL,
    question_id integer NOT NULL,
    response_date date NOT NULL DEFAULT CURRENT_DATE,
    CONSTRAINT answers_pkey PRIMARY KEY (id),
    CONSTRAINT answers_fkey FOREIGN KEY (question_id)
        REFERENCES surveyapp.question (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE surveyapp.answer
    OWNER to postgres;

-- Table: surveyapp.question

-- DROP TABLE surveyapp.question;

CREATE TABLE surveyapp.question
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

ALTER TABLE surveyapp.question
    OWNER to postgres;

-- Table: surveyapp.survey

-- DROP TABLE surveyapp.survey;

CREATE TABLE surveyapp.survey
(
    id bigint NOT NULL DEFAULT nextval('surveyapp.survey_id_seq'::regclass),
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT survey_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE surveyapp.survey
    OWNER to postgres;


-- Table: surveyapp.survey_question

-- DROP TABLE surveyapp.survey_question;

CREATE TABLE surveyapp.survey_question
(
    question_id integer NOT NULL,
    survey_id bigint NOT NULL,
    CONSTRAINT fk573vicrl6b0e4d2jdg3wpvuhy FOREIGN KEY (survey_id)
        REFERENCES surveyapp.survey (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk5lv7wm7wabdwpw24px1lcepo7 FOREIGN KEY (question_id)
        REFERENCES surveyapp.question (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkb6cox6fvsxtym2pv8il6mryt5 FOREIGN KEY (question_id)
        REFERENCES surveyapp.question (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE surveyapp.survey_question
    OWNER to postgres;