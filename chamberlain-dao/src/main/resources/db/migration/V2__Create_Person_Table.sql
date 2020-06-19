CREATE TABLE permission
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    type                VARCHAR(45)                     NOT NULL,
    CONSTRAINT pk_permission PRIMARY KEY (id)
);

CREATE TABLE user
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    login               VARCHAR(255)                    NOT NULL,
    name                VARCHAR(255)                    NOT NULL,
    surname             VARCHAR(255)                    NOT NULL,
    permission_id      BIGINT                          NOT NULL,
    CONSTRAINT pk_person PRIMARY KEY (id),
    FOREIGN KEY (permission_id) REFERENCES permission (id)
);
