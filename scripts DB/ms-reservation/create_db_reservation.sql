--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 13.0

-- Started on 2020-11-05 23:07:23

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

SET default_tablespace = '';

--
-- TOC entry 197 (class 1259 OID 68273)
-- Name: reservation; Type: TABLE; Schema: public; Owner: admin_library
--

CREATE TABLE public.reservation (
    reservation_id integer NOT NULL,
    create_reservation_date timestamp without time zone NOT NULL,
    soon_disponibility_date date,
    end_of_priority date,
    customer_id integer NOT NULL,
    customer_email character varying NOT NULL,
    customer_firstname character varying NOT NULL,
    customer_lastname character varying NOT NULL,
    book_id integer NOT NULL,
    book_title character varying NOT NULL,
    "position" integer
);


ALTER TABLE public.reservation OWNER TO admin_library;

--
-- TOC entry 196 (class 1259 OID 68271)
-- Name: reservation_reservation_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_library
--

CREATE SEQUENCE public.reservation_reservation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_reservation_id_seq OWNER TO admin_library;

--
-- TOC entry 2817 (class 0 OID 0)
-- Dependencies: 196
-- Name: reservation_reservation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_library
--

ALTER SEQUENCE public.reservation_reservation_id_seq OWNED BY public.reservation.reservation_id;


--
-- TOC entry 2686 (class 2604 OID 68276)
-- Name: reservation reservation_id; Type: DEFAULT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.reservation ALTER COLUMN reservation_id SET DEFAULT nextval('public.reservation_reservation_id_seq'::regclass);


--
-- TOC entry 2811 (class 0 OID 68273)
-- Dependencies: 197
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: admin_library
--

COPY public.reservation (reservation_id, create_reservation_date, soon_disponibility_date, end_of_priority, customer_id, customer_email, customer_firstname, customer_lastname, book_id, book_title, "position") FROM stdin;
\.


--
-- TOC entry 2818 (class 0 OID 0)
-- Dependencies: 196
-- Name: reservation_reservation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admin_library
--

SELECT pg_catalog.setval('public.reservation_reservation_id_seq', 5, true);


-- Completed on 2020-11-05 23:07:23

--
-- PostgreSQL database dump complete
--

