CREATE TABLE person
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    name                VARCHAR(255)                    NOT NULL,
    surname             VARCHAR(255)                    NOT NULL,
    CONSTRAINT pk_person PRIMARY KEY (id)
);
