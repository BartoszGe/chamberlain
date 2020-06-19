CREATE TABLE product_type
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    name                VARCHAR(255) CHARACTER SET utf8 NOT NULL,
    CONSTRAINT pk_product_type_table PRIMARY KEY (id)
);

CREATE TABLE product
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    name                VARCHAR(255) CHARACTER SET utf8 NOT NULL,
    type_id             BIGINT                          NOT NULL,
    price               DOUBLE                          NOT NULL,
    amount              INTEGER DEFAULT 0               NOT NULL,
    measureType         VARCHAR(255) CHARACTER SET utf8 NOT NULL,
    description         TEXT CHARACTER SET utf8         NOT NULL,
    CONSTRAINT pk_product_table PRIMARY KEY (id),
    FOREIGN KEY (type_id) REFERENCES product_type (id)
);

CREATE TABLE product_request
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    product_name        VARCHAR(255) CHARACTER SET utf8 NOT NULL,
    CONSTRAINT pk_product_request PRIMARY KEY (id)
);

CREATE TABLE service_order
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    price               DOUBLE                          NOT NULL,
    delivery_time       DATETIME                        NOT NULL,
    delivery_place      VARCHAR(512)                    NOT NULL,
    CONSTRAINT pk_service_order PRIMARY KEY (id)
);
