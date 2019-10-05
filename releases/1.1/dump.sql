--
-- PostgreSQL database dump
--

-- Dumped from database version 10.10 (Ubuntu 10.10-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.10 (Ubuntu 10.10-0ubuntu0.18.04.1)

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
-- Name: bjj_database; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE bjj_database WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE bjj_database OWNER TO postgres;

\connect bjj_database

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
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: app_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.app_user (
    id bigint NOT NULL,
    code character varying(255),
    inserted_at timestamp without time zone,
    updated_at timestamp without time zone,
    password character varying(255),
    username character varying(255),
    role_id bigint
);


ALTER TABLE public.app_user OWNER TO postgres;

--
-- Name: day_range; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.day_range (
    id bigint NOT NULL,
    code character varying(255),
    inserted_at timestamp without time zone,
    updated_at timestamp without time zone,
    ending_date date,
    starting_date date
);


ALTER TABLE public.day_range OWNER TO postgres;

--
-- Name: day_range_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.day_range_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.day_range_id_seq OWNER TO postgres;

--
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id bigint NOT NULL,
    code character varying(255),
    inserted_at timestamp without time zone,
    updated_at timestamp without time zone,
    name character varying(8)
);


ALTER TABLE public.role OWNER TO postgres;

--
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_id_seq OWNER TO postgres;

--
-- Name: tag; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tag (
    id bigint NOT NULL,
    code character varying(255),
    inserted_at timestamp without time zone,
    updated_at timestamp without time zone,
    description character varying(255),
    name character varying(255)
);


ALTER TABLE public.tag OWNER TO postgres;

--
-- Name: tag_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tag_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tag_id_seq OWNER TO postgres;

--
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_id_seq OWNER TO postgres;

--
-- Name: video; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.video (
    source character varying(31) NOT NULL,
    id bigint NOT NULL,
    code character varying(255),
    inserted_at timestamp without time zone,
    updated_at timestamp without time zone,
    description character varying(255),
    name character varying(255),
    uuid character varying(255),
    source_id character varying(255)
);


ALTER TABLE public.video OWNER TO postgres;

--
-- Name: video_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.video_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.video_id_seq OWNER TO postgres;

--
-- Name: video_tag; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.video_tag (
    video_id bigint NOT NULL,
    tag_id bigint NOT NULL
);


ALTER TABLE public.video_tag OWNER TO postgres;

--
-- Name: week_arrangement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.week_arrangement (
    id bigint NOT NULL,
    code character varying(255),
    inserted_at timestamp without time zone,
    updated_at timestamp without time zone,
    description character varying(255),
    name character varying(255),
    day_range_id bigint
);


ALTER TABLE public.week_arrangement OWNER TO postgres;

--
-- Name: week_arrangement_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.week_arrangement_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.week_arrangement_id_seq OWNER TO postgres;

--
-- Name: week_arrangement_tag_association; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.week_arrangement_tag_association (
    week_arrangement_id bigint NOT NULL,
    tag_id bigint NOT NULL
);


ALTER TABLE public.week_arrangement_tag_association OWNER TO postgres;

--
-- Name: week_arrangement_video_association; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.week_arrangement_video_association (
    week_arrangement_id bigint NOT NULL,
    video_id bigint NOT NULL
);


ALTER TABLE public.week_arrangement_video_association OWNER TO postgres;

--
-- Data for Name: app_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.app_user (id, code, inserted_at, updated_at, password, username, role_id) FROM stdin;
4	\N	2019-10-02 00:13:48.880086	2019-10-02 00:13:48.880127	$2a$10$G3YBIRRKvqq0pTk84N2f4eI6RRjvqIAEaU/HtbFto2VPI0zIRd0pq	daskalos	1
\.


--
-- Data for Name: day_range; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.day_range (id, code, inserted_at, updated_at, ending_date, starting_date) FROM stdin;
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (id, code, inserted_at, updated_at, name) FROM stdin;
1	role.admin	\N	\N	ADMIN
2	rolde.user	\N	\N	USER
\.


--
-- Data for Name: tag; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tag (id, code, inserted_at, updated_at, description, name) FROM stdin;
\.


--
-- Data for Name: video; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.video (source, id, code, inserted_at, updated_at, description, name, uuid, source_id) FROM stdin;
\.


--
-- Data for Name: video_tag; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.video_tag (video_id, tag_id) FROM stdin;
\.


--
-- Data for Name: week_arrangement; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.week_arrangement (id, code, inserted_at, updated_at, description, name, day_range_id) FROM stdin;
\.


--
-- Data for Name: week_arrangement_tag_association; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.week_arrangement_tag_association (week_arrangement_id, tag_id) FROM stdin;
\.


--
-- Data for Name: week_arrangement_video_association; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.week_arrangement_video_association (week_arrangement_id, video_id) FROM stdin;
\.


--
-- Name: day_range_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.day_range_id_seq', 32, true);


--
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_id_seq', 1, false);


--
-- Name: tag_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tag_id_seq', 2, true);


--
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_id_seq', 4, true);


--
-- Name: video_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.video_id_seq', 2, true);


--
-- Name: week_arrangement_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.week_arrangement_id_seq', 6, true);


--
-- Name: app_user app_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT app_user_pkey PRIMARY KEY (id);


--
-- Name: day_range day_range_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.day_range
    ADD CONSTRAINT day_range_pkey PRIMARY KEY (id);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: tag tag_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tag
    ADD CONSTRAINT tag_pkey PRIMARY KEY (id);


--
-- Name: video video_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.video
    ADD CONSTRAINT video_pkey PRIMARY KEY (id);


--
-- Name: week_arrangement week_arrangement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.week_arrangement
    ADD CONSTRAINT week_arrangement_pkey PRIMARY KEY (id);


--
-- Name: week_arrangement_tag_association week_arrangement_tag_association_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.week_arrangement_tag_association
    ADD CONSTRAINT week_arrangement_tag_association_pkey PRIMARY KEY (week_arrangement_id, tag_id);


--
-- Name: week_arrangement_video_association week_arrangement_video_association_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.week_arrangement_video_association
    ADD CONSTRAINT week_arrangement_video_association_pkey PRIMARY KEY (week_arrangement_id, video_id);


--
-- Name: day_range_id_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX day_range_id_index ON public.day_range USING btree (id);


--
-- Name: role_id_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX role_id_index ON public.role USING btree (id);


--
-- Name: tag_id_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX tag_id_index ON public.tag USING btree (id);


--
-- Name: user_id_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX user_id_index ON public.app_user USING btree (id);


--
-- Name: video_id_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX video_id_index ON public.video USING btree (id);


--
-- Name: week_arrangement_index; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX week_arrangement_index ON public.week_arrangement USING btree (id);


--
-- Name: app_user fk49hx9nj6onfot1fxtonj986ab; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.app_user
    ADD CONSTRAINT fk49hx9nj6onfot1fxtonj986ab FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- Name: video_tag fk7a7a4rx1y3tr2ycwuqcrf580b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.video_tag
    ADD CONSTRAINT fk7a7a4rx1y3tr2ycwuqcrf580b FOREIGN KEY (video_id) REFERENCES public.video(id);


--
-- Name: week_arrangement_tag_association fk7rjx7rroqqo912wxvywjmpepq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.week_arrangement_tag_association
    ADD CONSTRAINT fk7rjx7rroqqo912wxvywjmpepq FOREIGN KEY (week_arrangement_id) REFERENCES public.week_arrangement(id);


--
-- Name: week_arrangement_tag_association fkigde2jswt6qoeiuggcfcryos3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.week_arrangement_tag_association
    ADD CONSTRAINT fkigde2jswt6qoeiuggcfcryos3 FOREIGN KEY (tag_id) REFERENCES public.tag(id);


--
-- Name: week_arrangement_video_association fkjqk6ddbuureu8htr8due9i4gk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.week_arrangement_video_association
    ADD CONSTRAINT fkjqk6ddbuureu8htr8due9i4gk FOREIGN KEY (week_arrangement_id) REFERENCES public.week_arrangement(id);


--
-- Name: video_tag fkoimfmujed58aojuxdekx4csml; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.video_tag
    ADD CONSTRAINT fkoimfmujed58aojuxdekx4csml FOREIGN KEY (tag_id) REFERENCES public.tag(id);


--
-- Name: week_arrangement fkpnkr2hwb9a1l3d5js23qh7y9o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.week_arrangement
    ADD CONSTRAINT fkpnkr2hwb9a1l3d5js23qh7y9o FOREIGN KEY (day_range_id) REFERENCES public.day_range(id);


--
-- Name: week_arrangement_video_association fkr3nvn07sch7unaqlpi15y2l8q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.week_arrangement_video_association
    ADD CONSTRAINT fkr3nvn07sch7unaqlpi15y2l8q FOREIGN KEY (video_id) REFERENCES public.video(id);


--
-- PostgreSQL database dump complete
--

