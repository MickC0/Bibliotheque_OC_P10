--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 12.2

-- Started on 2020-05-21 04:36:14

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
-- TOC entry 2812 (class 0 OID 68260)
-- Dependencies: 197
-- Data for Name: loan; Type: TABLE DATA; Schema: public; Owner: admin_library
--

INSERT INTO public.loan (loan_id, begin_loan_date, ending_loan_date, extend_loan_date, return_loan_date, extend, loan_status, customer_id, copy_id, book_id) VALUES (2, '2020-03-13', '2020-04-10', '2020-05-08', NULL, false, 'En retard', 2, 21, 7);
INSERT INTO public.loan (loan_id, begin_loan_date, ending_loan_date, extend_loan_date, return_loan_date, extend, loan_status, customer_id, copy_id, book_id) VALUES (3, '2020-03-01', '2020-03-29', '2020-04-26', NULL, true, 'Prolongé', 2, 62, 16);
INSERT INTO public.loan (loan_id, begin_loan_date, ending_loan_date, extend_loan_date, return_loan_date, extend, loan_status, customer_id, copy_id, book_id) VALUES (4, '2020-02-01', '2020-02-29', '2020-03-28', NULL, true, 'En retard', 2, 32, 10);
INSERT INTO public.loan (loan_id, begin_loan_date, ending_loan_date, extend_loan_date, return_loan_date, extend, loan_status, customer_id, copy_id, book_id) VALUES (5, '2020-03-05', '2020-04-02', '2020-04-30', '2020-03-12', false, 'Rendu', 2, 10, 4);
INSERT INTO public.loan (loan_id, begin_loan_date, ending_loan_date, extend_loan_date, return_loan_date, extend, loan_status, customer_id, copy_id, book_id) VALUES (1, '2020-04-04', '2020-05-02', '2020-05-30', NULL, true, 'Prolongé', 2, 2, 1);
INSERT INTO public.loan (loan_id, begin_loan_date, ending_loan_date, extend_loan_date, return_loan_date, extend, loan_status, customer_id, copy_id, book_id) VALUES (6, '2020-05-05', '2020-06-02', '2020-06-30', '2020-05-07', false, 'Rendu', 2, 5, 2);
INSERT INTO public.loan (loan_id, begin_loan_date, ending_loan_date, extend_loan_date, return_loan_date, extend, loan_status, customer_id, copy_id, book_id) VALUES (7, '2020-05-07', '2020-06-04', '2020-07-02', '2020-05-07', false, 'Rendu', 2, 5, 2);
INSERT INTO public.loan (loan_id, begin_loan_date, ending_loan_date, extend_loan_date, return_loan_date, extend, loan_status, customer_id, copy_id, book_id) VALUES (8, '2020-05-21', '2020-06-18', '2020-07-16', NULL, false, 'En cours', 2, 5, 2);
INSERT INTO public.loan (loan_id, begin_loan_date, ending_loan_date, extend_loan_date, return_loan_date, extend, loan_status, customer_id, copy_id, book_id) VALUES (11, '2020-05-21', '2020-06-18', '2020-07-16', '2020-05-21', false, 'Rendu', 2, 5, 2);
INSERT INTO public.loan (loan_id, begin_loan_date, ending_loan_date, extend_loan_date, return_loan_date, extend, loan_status, customer_id, copy_id, book_id) VALUES (10, '2020-05-21', '2020-06-18', '2020-07-16', '2020-05-21', false, 'Rendu', 2, 5, 2);
INSERT INTO public.loan (loan_id, begin_loan_date, ending_loan_date, extend_loan_date, return_loan_date, extend, loan_status, customer_id, copy_id, book_id) VALUES (9, '2020-05-21', '2020-06-18', '2020-07-16', '2020-05-21', false, 'Rendu', 2, 5, 2);


--
-- TOC entry 2819 (class 0 OID 0)
-- Dependencies: 196
-- Name: loan_loan_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin_library
--

SELECT pg_catalog.setval('public.loan_loan_id_seq', 11, true);


-- Completed on 2020-05-21 04:36:14

--
-- PostgreSQL database dump complete
--

