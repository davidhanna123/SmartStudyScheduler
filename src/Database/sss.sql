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

--CREATE TABLE main.calendars(
--	id SERIAL PRIMARY KEY,
--	userName TEXT,
--	years INT[]
--)

CREATE TABLE main.events(
	id SERIAL PRIMARY KEY,
	title TEXT,
	description TEXT,
	startingTime INT,
	duration INT,
	eventDate DATE
);

-- reminders
CREATE TABLE main.reminders (
	id SERIAL PRIMARY KEY,  
	title VARCHAR(255),
	reminder_date DATE, 
	reminder_time TIME, 
	offset_minutes INT, 
	message TEXT,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE main.assignments(
	title TEXT,
	course TEXT,
	duration INT,
	eventDate DATE
);

CREATE TABLE main.homework(
	title TEXT,
	course TEXT,
	duration INT
);




