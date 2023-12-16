--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 12.2

-- Started on 2020-05-21 04:34:08

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
-- TOC entry 2822 (class 0 OID 68297)
-- Dependencies: 197
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: admin_library
--

INSERT INTO public.address (address_id, housenumber, street, postcode, city) VALUES (1, '1', 'rue principal', '77777', 'Ocland');
INSERT INTO public.address (address_id, housenumber, street, postcode, city) VALUES (2, '3', 'rue des pots', '77777', 'Ocland');


--
-- TOC entry 2824 (class 0 OID 68308)
-- Dependencies: 199
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: admin_library
--

INSERT INTO public.customer (customer_id, last_name, first_name, address_id, email, phone_number, registration_date, update_date, user_id) VALUES (1, 'batch', 'bacth', 1, 'mc.ocform@gmail.com', '7777777777', '2020-05-15 02:37:35', '2020-05-15 02:37:39', 1);
INSERT INTO public.customer (customer_id, last_name, first_name, address_id, email, phone_number, registration_date, update_date, user_id) VALUES (2, 'Coz', 'Mickael', 2, 'coz.mickael@gmail.com', '0123456789', '2020-05-15 02:38:15', '2020-05-15 02:38:18', 2);


--
-- TOC entry 2832 (class 0 OID 0)
-- Dependencies: 196
-- Name: address_address_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin_library
--

SELECT pg_catalog.setval('public.address_address_id_seq', 1, false);


--
-- TOC entry 2833 (class 0 OID 0)
-- Dependencies: 198
-- Name: customer_customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin_library
--

SELECT pg_catalog.setval('public.customer_customer_id_seq', 1, false);


-- Completed on 2020-05-21 04:34:08

--
-- PostgreSQL database dump complete
--

