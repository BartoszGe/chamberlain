CREATE TABLE PERMISSION
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    type                VARCHAR(45) CHARACTER SET utf8  NOT NULL,
    CONSTRAINT pk_permission PRIMARY KEY (id)
);

CREATE TABLE USER
(
    id                  BIGINT AUTO_INCREMENT            NOT NULL,
    login               VARCHAR(255) CHARACTER SET utf8  NOT NULL,
    name                VARCHAR(255) CHARACTER SET utf8  NOT NULL,
    surname             VARCHAR(255) CHARACTER SET utf8  NOT NULL,
    permission_id       BIGINT                           NOT NULL,
    CONSTRAINT pk_person PRIMARY KEY (id),
    FOREIGN KEY (permission_id) REFERENCES PERMISSION (id)
);
