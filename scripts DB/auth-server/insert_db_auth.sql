--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 12.2

-- Started on 2020-05-21 04:29:15

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
-- TOC entry 2811 (class 0 OID 68285)
-- Dependencies: 197
-- Data for Name: auth; Type: TABLE DATA; Schema: public; Owner: admin_library
--

INSERT INTO public.auth (user_id, username, password, active, roles, permissions) VALUES (1, 'mc.ocform@gmail.com', '$2a$10$uHS0iRVkWg6Nhk/E8HlFZOsfN6lJ19hNZXVjw0MueDBN2APXa9i6q', true, 'BATCH', 'READ,WRITE,UPDATE,DELETE');
INSERT INTO public.auth (user_id, username, password, active, roles, permissions) VALUES (2, 'coz.mickael@gmail.com', '$2a$10$gGwLEHgYgT9rEkEf7.i6Gu7N0G.TluyIam7iwPmjjiE.29duT1DO.', true, 'ADMIN', 'READ,WRITE,UPDATE,DELETE');


--
-- TOC entry 2818 (class 0 OID 0)
-- Dependencies: 196
-- Name: auth_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin_library
--

SELECT pg_catalog.setval('public.auth_user_id_seq', 1, false);


-- Completed on 2020-05-21 04:29:15

--
-- PostgreSQL database dump complete
--

