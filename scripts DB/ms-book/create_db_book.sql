--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 12.2

-- Started on 2020-05-21 04:30:49

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

DROP DATABASE "library-ms-book";
--
-- TOC entry 2874 (class 1262 OID 66322)
-- Name: library-ms-book; Type: DATABASE; Schema: -; Owner: admin_library
--

CREATE DATABASE "library-ms-book" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';


ALTER DATABASE "library-ms-book" OWNER TO admin_library;

\connect -reuse-previous=on "dbname='library-ms-book'"

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
-- TOC entry 201 (class 1259 OID 66341)
-- Name: author; Type: TABLE; Schema: public; Owner: admin_library
--

CREATE TABLE public.author (
    author_id integer NOT NULL,
    last_name character varying NOT NULL,
    first_name character varying NOT NULL
);


ALTER TABLE public.author OWNER TO admin_library;

--
-- TOC entry 200 (class 1259 OID 66339)
-- Name: author_author_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_library
--

CREATE SEQUENCE public.author_author_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.author_author_id_seq OWNER TO admin_library;

--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 200
-- Name: author_author_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_library
--

ALTER SEQUENCE public.author_author_id_seq OWNED BY public.author.author_id;


--
-- TOC entry 205 (class 1259 OID 66363)
-- Name: book; Type: TABLE; Schema: public; Owner: admin_library
--

CREATE TABLE public.book (
    book_id integer NOT NULL,
    edition_id integer NOT NULL,
    title character varying NOT NULL,
    author_id integer NOT NULL,
    isbn character varying NOT NULL,
    summary character varying NOT NULL,
    cover_id integer NOT NULL,
    stock integer
);


ALTER TABLE public.book OWNER TO admin_library;

--
-- TOC entry 204 (class 1259 OID 66361)
-- Name: book_book_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_library
--

CREATE SEQUENCE public.book_book_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.book_book_id_seq OWNER TO admin_library;

--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 204
-- Name: book_book_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_library
--

ALTER SEQUENCE public.book_book_id_seq OWNED BY public.book.book_id;


--
-- TOC entry 208 (class 1259 OID 66380)
-- Name: categories_of_books; Type: TABLE; Schema: public; Owner: admin_library
--

CREATE TABLE public.categories_of_books (
    category_id integer NOT NULL,
    book_id integer NOT NULL
);


ALTER TABLE public.categories_of_books OWNER TO admin_library;

--
-- TOC entry 199 (class 1259 OID 66333)
-- Name: category; Type: TABLE; Schema: public; Owner: admin_library
--

CREATE TABLE public.category (
    category_id integer NOT NULL,
    label character varying(20) NOT NULL
);


ALTER TABLE public.category OWNER TO admin_library;

--
-- TOC entry 198 (class 1259 OID 66331)
-- Name: category_category_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_library
--

CREATE SEQUENCE public.category_category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.category_category_id_seq OWNER TO admin_library;

--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 198
-- Name: category_category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_library
--

ALTER SEQUENCE public.category_category_id_seq OWNED BY public.category.category_id;


--
-- TOC entry 207 (class 1259 OID 66374)
-- Name: copy; Type: TABLE; Schema: public; Owner: admin_library
--

CREATE TABLE public.copy (
    copy_id integer NOT NULL,
    book_id integer NOT NULL,
    available boolean NOT NULL
);


ALTER TABLE public.copy OWNER TO admin_library;

--
-- TOC entry 206 (class 1259 OID 66372)
-- Name: copy_copy_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_library
--

CREATE SEQUENCE public.copy_copy_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.copy_copy_id_seq OWNER TO admin_library;

--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 206
-- Name: copy_copy_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_library
--

ALTER SEQUENCE public.copy_copy_id_seq OWNED BY public.copy.copy_id;


--
-- TOC entry 203 (class 1259 OID 66352)
-- Name: cover; Type: TABLE; Schema: public; Owner: admin_library
--

CREATE TABLE public.cover (
    cover_id integer NOT NULL,
    name character varying NOT NULL,
    url character varying NOT NULL
);


ALTER TABLE public.cover OWNER TO admin_library;

--
-- TOC entry 202 (class 1259 OID 66350)
-- Name: cover_cover_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_library
--

CREATE SEQUENCE public.cover_cover_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cover_cover_id_seq OWNER TO admin_library;

--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 202
-- Name: cover_cover_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_library
--

ALTER SEQUENCE public.cover_cover_id_seq OWNED BY public.cover.cover_id;


--
-- TOC entry 197 (class 1259 OID 66325)
-- Name: edition; Type: TABLE; Schema: public; Owner: admin_library
--

CREATE TABLE public.edition (
    edition_id integer NOT NULL,
    label character varying(20) NOT NULL
);


ALTER TABLE public.edition OWNER TO admin_library;

--
-- TOC entry 196 (class 1259 OID 66323)
-- Name: edition_edition_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_library
--

CREATE SEQUENCE public.edition_edition_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.edition_edition_id_seq OWNER TO admin_library;

--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 196
-- Name: edition_edition_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_library
--

ALTER SEQUENCE public.edition_edition_id_seq OWNED BY public.edition.edition_id;


--
-- TOC entry 2724 (class 2604 OID 66344)
-- Name: author author_id; Type: DEFAULT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.author ALTER COLUMN author_id SET DEFAULT nextval('public.author_author_id_seq'::regclass);


--
-- TOC entry 2726 (class 2604 OID 66366)
-- Name: book book_id; Type: DEFAULT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.book ALTER COLUMN book_id SET DEFAULT nextval('public.book_book_id_seq'::regclass);


--
-- TOC entry 2723 (class 2604 OID 66336)
-- Name: category category_id; Type: DEFAULT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.category ALTER COLUMN category_id SET DEFAULT nextval('public.category_category_id_seq'::regclass);


--
-- TOC entry 2727 (class 2604 OID 66377)
-- Name: copy copy_id; Type: DEFAULT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.copy ALTER COLUMN copy_id SET DEFAULT nextval('public.copy_copy_id_seq'::regclass);


--
-- TOC entry 2725 (class 2604 OID 66355)
-- Name: cover cover_id; Type: DEFAULT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.cover ALTER COLUMN cover_id SET DEFAULT nextval('public.cover_cover_id_seq'::regclass);


--
-- TOC entry 2722 (class 2604 OID 66328)
-- Name: edition edition_id; Type: DEFAULT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.edition ALTER COLUMN edition_id SET DEFAULT nextval('public.edition_edition_id_seq'::regclass);


--
-- TOC entry 2733 (class 2606 OID 66349)
-- Name: author author_pk; Type: CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pk PRIMARY KEY (author_id);


--
-- TOC entry 2737 (class 2606 OID 66371)
-- Name: book book_pk; Type: CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pk PRIMARY KEY (book_id);


--
-- TOC entry 2741 (class 2606 OID 66384)
-- Name: categories_of_books categories_of_books_pk; Type: CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.categories_of_books
    ADD CONSTRAINT categories_of_books_pk PRIMARY KEY (category_id, book_id);


--
-- TOC entry 2731 (class 2606 OID 66338)
-- Name: category category_pk; Type: CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pk PRIMARY KEY (category_id);


--
-- TOC entry 2739 (class 2606 OID 66379)
-- Name: copy copy_pk; Type: CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.copy
    ADD CONSTRAINT copy_pk PRIMARY KEY (copy_id);


--
-- TOC entry 2735 (class 2606 OID 66360)
-- Name: cover cover_pk; Type: CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.cover
    ADD CONSTRAINT cover_pk PRIMARY KEY (cover_id);


--
-- TOC entry 2729 (class 2606 OID 66330)
-- Name: edition edition_pk; Type: CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.edition
    ADD CONSTRAINT edition_pk PRIMARY KEY (edition_id);


--
-- TOC entry 2743 (class 2606 OID 66395)
-- Name: book author_book_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT author_book_fk FOREIGN KEY (author_id) REFERENCES public.author(author_id);


--
-- TOC entry 2745 (class 2606 OID 66410)
-- Name: copy book_book_copy_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.copy
    ADD CONSTRAINT book_book_copy_fk FOREIGN KEY (book_id) REFERENCES public.book(book_id);


--
-- TOC entry 2747 (class 2606 OID 66405)
-- Name: categories_of_books book_categories_of_books_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.categories_of_books
    ADD CONSTRAINT book_categories_of_books_fk FOREIGN KEY (book_id) REFERENCES public.book(book_id);


--
-- TOC entry 2746 (class 2606 OID 66390)
-- Name: categories_of_books category_categories_of_books_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.categories_of_books
    ADD CONSTRAINT category_categories_of_books_fk FOREIGN KEY (category_id) REFERENCES public.category(category_id);


--
-- TOC entry 2742 (class 2606 OID 66385)
-- Name: book edition_book_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT edition_book_fk FOREIGN KEY (edition_id) REFERENCES public.edition(edition_id);


--
-- TOC entry 2744 (class 2606 OID 66400)
-- Name: book image_book_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_library
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT image_book_fk FOREIGN KEY (cover_id) REFERENCES public.cover(cover_id) ON DELETE CASCADE;


-- Completed on 2020-05-21 04:30:49

--
-- PostgreSQL database dump complete
--

