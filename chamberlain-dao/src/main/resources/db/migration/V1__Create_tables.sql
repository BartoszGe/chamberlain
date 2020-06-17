CREATE TABLE product_table
(
    id                  BIGINT AUTO_INCREMENT   NOT NULL,
    name                VARCHAR(255)            NOT NULL,
    price               DOUBLE                  NOT NULL,
    type                VARCHAR(255)            NOT NULL,
    measureType         VARCHAR(255)            NOT NULL,
    description         TEXT                    NOT NULL,
    CONSTRAINT pk_product_table PRIMARY KEY (id)
);
