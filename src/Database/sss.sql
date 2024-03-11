--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Data for Name: test; Type: TABLE DATA; Schema: public; Owner: yadon
--

COPY public.test (id, username) FROM stdin;
\.


--
-- Name: test_id_seq; Type: SEQUENCE SET; Schema: public; Owner: yadon
--

SELECT pg_catalog.setval('public.test_id_seq', 1, false);


--
-- PostgreSQL database dump complete
--


CREATE TABLE main.years (
    id SERIAL PRIMARY KEY,
    currentYear INT,
    calendarId INT REFERENCES main.calendars(id)
);

CREATE TABLE main.months (
	id SERIAL PRIMARY KEY,
	monthName TEXT,
	monthNumber INT,
	numOfDays INT,
	yearNumber INT, 
	yearId INT REFERENCES main.years(id)
);

CREATE TABLE main.days (
	id SERIAL PRIMARY KEY,
	dayOfWeek TEXT,
	dayNumber INT, --dayNumber used instead OF date because date IS already a database datatype
	monthId INT REFERENCES main.months(id)
);

CREATE TABLE main.hours(
	id SERIAL PRIMARY KEY, 
	timeNumber INT,
	minuteModifier DOUBLE 
	dayId INT REFERENCES main.days(id);
)

CREATE TABLE main.reminders (
	id SERIAL PRIMARY KEY,  
	title VARCHAR(255),
	reminder_date DATE, 
	reminder_time TIME, 
	offset_minutes INT, 
	message TEXT,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);




