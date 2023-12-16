--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 12.2

-- Started on 2020-05-21 04:23:54

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

DROP DATABASE "library-auth-server";
--
-- TOC entry 2815 (class 1262 OID 68282)
-- Name: library-auth-server; Type: DATABASE; Schema: -; Owner: admin_library
--

CREATE DATABASE "library-auth-server" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';


ALTER DATABASE "library-auth-server" OWNER TO admin_library;

\connect -reuse-previous=on "dbname='library-auth-server'"

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
-- TOC entry 197 (class 1259 OID 68285)
-- Name: auth; Type: TABLE; Schema: public; Owner: admin_library
--

CREATE TABLE public.auth (
    user_id integer NOT NULL,
    username character varying NOT NULL,
    password character varying NOT NULL,
    active boolean NOT NULL,
    roles character varying NOT NULL,
    permissions character varying NOT NULL
);


ALTER TABLE public.auth OWNER TO admin_library;

--
-- TOC entry 196 (class 1259 OID 68283)
-- Name: auth_user_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_library
--

CREATE SEQUENCE public.auth_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auth_user_id_seq OWNER TO admin_library;

--
-- TOC entry 2816 (class 0 OID 0)
-- Dependencies: 196
-- Name: auth_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_library
--

ALTER SEQUENCE public.auth_user_id_seq OWNED BY public.auth.user_id;


--
-- TOC entry 2686 (class 2604 OID 68288)
-- Name: auth user_id; Type: DEFAULT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.auth ALTER COLUMN user_id SET DEFAULT nextval('public.auth_user_id_seq'::regclass);


--
-- TOC entry 2688 (class 2606 OID 68293)
-- Name: auth auth_pk; Type: CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.auth
    ADD CONSTRAINT auth_pk PRIMARY KEY (user_id);


-- Completed on 2020-05-21 04:23:54

--
-- PostgreSQL database dump complete
--

