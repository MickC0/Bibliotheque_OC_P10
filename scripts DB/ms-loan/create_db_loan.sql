--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 12.2

-- Started on 2020-05-21 04:35:31

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

DROP DATABASE "library-ms-loan";
--
-- TOC entry 2816 (class 1262 OID 68257)
-- Name: library-ms-loan; Type: DATABASE; Schema: -; Owner: admin_library
--

CREATE DATABASE "library-ms-loan" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';


ALTER DATABASE "library-ms-loan" OWNER TO admin_library;

\connect -reuse-previous=on "dbname='library-ms-loan'"

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
-- TOC entry 197 (class 1259 OID 68260)
-- Name: loan; Type: TABLE; Schema: public; Owner: admin_library
--

CREATE TABLE public.loan (
    loan_id integer NOT NULL,
    begin_loan_date date NOT NULL,
    ending_loan_date date NOT NULL,
    extend_loan_date date NOT NULL,
    return_loan_date date,
    extend boolean DEFAULT false NOT NULL,
    loan_status character varying NOT NULL,
    customer_id integer NOT NULL,
    copy_id integer NOT NULL,
    book_id integer NOT NULL
);


ALTER TABLE public.loan OWNER TO admin_library;

--
-- TOC entry 196 (class 1259 OID 68258)
-- Name: loan_loan_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_library
--

CREATE SEQUENCE public.loan_loan_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.loan_loan_id_seq OWNER TO admin_library;

--
-- TOC entry 2817 (class 0 OID 0)
-- Dependencies: 196
-- Name: loan_loan_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_library
--

ALTER SEQUENCE public.loan_loan_id_seq OWNED BY public.loan.loan_id;


--
-- TOC entry 2686 (class 2604 OID 68263)
-- Name: loan loan_id; Type: DEFAULT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.loan ALTER COLUMN loan_id SET DEFAULT nextval('public.loan_loan_id_seq'::regclass);


--
-- TOC entry 2689 (class 2606 OID 68269)
-- Name: loan loan_pk; Type: CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.loan
    ADD CONSTRAINT loan_pk PRIMARY KEY (loan_id);


-- Completed on 2020-05-21 04:35:31

--
-- PostgreSQL database dump complete
--

