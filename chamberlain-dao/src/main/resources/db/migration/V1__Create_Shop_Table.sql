CREATE TABLE PRODUCT_TYPE
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    name                VARCHAR(255) CHARACTER SET utf8 NOT NULL,
    CONSTRAINT pk_product_type_table PRIMARY KEY (id)
);

CREATE TABLE PRODUCT
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    name                VARCHAR(255) CHARACTER SET utf8 NOT NULL,
    type_id             BIGINT                          NOT NULL,
    price               DOUBLE                          NOT NULL,
    amount              INTEGER DEFAULT 0               NOT NULL,
    measure_type        VARCHAR(255) CHARACTER SET utf8 NOT NULL,
    description         TEXT CHARACTER SET utf8         NOT NULL,
    is_deprecated       boolean DEFAULT FALSE           NOT NULL,
    CONSTRAINT pk_product_table PRIMARY KEY (id),
    FOREIGN KEY (type_id) REFERENCES PRODUCT_TYPE (id)
);

CREATE TABLE PRODUCT_REQUEST
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    product_name        VARCHAR(255) CHARACTER SET utf8 NOT NULL,
    CONSTRAINT pk_product_request PRIMARY KEY (id)
);

CREATE TABLE ORDER_SERVICE
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    price               DOUBLE                          NOT NULL,
    delivery_time       DATETIME                        NOT NULL,
    delivery_place      VARCHAR(512)                    NOT NULL,
    delivery_problem    TEXT,
    is_finalized        BOOLEAN                         NOT NULL,
    CONSTRAINT pk_service_order PRIMARY KEY (id)
);

CREATE TABLE PRODUCT_X_ORDER
(
    id                  BIGINT AUTO_INCREMENT           NOT NULL,
    product_id          BIGINT                          NOT NULL,
    amount              INTEGER                         NOT NULL,
    order_service_id    BIGINT                          NOT NULL,
    CONSTRAINT pk_productOrder PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES PRODUCT (id),
    FOREIGN KEY (order_service_id) REFERENCES ORDER_SERVICE (id)
)
