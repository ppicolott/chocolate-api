CREATE DATABASE chocolatedb;

CREATE TABLE DEVEDORES(
uuid            VARCHAR(50) NOT NULL,
name            VARCHAR(150) NOT NULL,
qtd             INT DEFAULT 0
);

select * from devedores;