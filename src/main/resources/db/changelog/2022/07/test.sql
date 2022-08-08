-- liquibase formatted sql

-- changeset APPLAUDO:1659058906444-1
CREATE TABLE address
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    address1   VARCHAR(255)          NULL,
    address2   VARCHAR(255)          NULL,
    country_id BIGINT                NULL,
    state_id   BIGINT                NULL,
    city_id    BIGINT                NULL,
    user_id    BIGINT                NULL,
    CONSTRAINT pk_address PRIMARY KEY (id)
);

-- changeset APPLAUDO:1659058906444-2
CREATE TABLE cart
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    total   DECIMAL               NULL,
    user_id BIGINT                NULL,
    CONSTRAINT pk_cart PRIMARY KEY (id)
);

-- changeset APPLAUDO:1659058906444-3
CREATE TABLE cart_item
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    cart_id    BIGINT                NULL,
    product_id BIGINT                NULL,
    quantity   INT                   NOT NULL,
    user_id    BIGINT                NULL,
    CONSTRAINT pk_cartitem PRIMARY KEY (id)
);

-- changeset APPLAUDO:1659058906444-4
CREATE TABLE city
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255)          NULL,
    state_id BIGINT                NULL,
    CONSTRAINT pk_city PRIMARY KEY (id)
);

-- changeset APPLAUDO:1659058906444-5
CREATE TABLE country
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    CONSTRAINT pk_country PRIMARY KEY (id)
);

-- changeset APPLAUDO:1659058906444-6
CREATE TABLE credit_card
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    number   VARCHAR(255)          NULL,
    cvv      VARCHAR(255)          NULL,
    balance  DOUBLE                NOT NULL,
    exp_date datetime              NULL,
    user_id  BIGINT                NULL,
    CONSTRAINT pk_creditcard PRIMARY KEY (id)
);

-- changeset APPLAUDO:1659058906444-7
CREATE TABLE delivery_data
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    address_id   BIGINT                NULL,
    order_id     BIGINT                NULL,
    track_number VARCHAR(255)          NULL,
    status_id    INT                   NULL,
    CONSTRAINT pk_deliverydata PRIMARY KEY (id)
);

-- changeset APPLAUDO:1659058906444-8
CREATE TABLE `order`
(
    id_order  BIGINT AUTO_INCREMENT NOT NULL,
    status_id INT                   NULL,
    date      datetime              NULL,
    total     DECIMAL               NULL,
    user_id   BIGINT                NULL,
    CONSTRAINT pk_order PRIMARY KEY (id_order)
);

-- changeset APPLAUDO:1659058906444-9
CREATE TABLE order_item
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    quantity   INT                   NOT NULL,
    product_id BIGINT                NULL,
    order_id   BIGINT                NULL,
    CONSTRAINT pk_orderitem PRIMARY KEY (id)
);

-- changeset APPLAUDO:1659058906444-10
CREATE TABLE payment_details
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    amount    DECIMAL               NULL,
    date      datetime              NULL,
    status_id INT                   NULL,
    order_id  BIGINT                NULL,
    CONSTRAINT pk_paymentdetails PRIMARY KEY (id)
);

-- changeset APPLAUDO:1659058906444-11
CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)          NULL,
    price         DECIMAL               NULL,
    stock         INT                   NOT NULL,
    category_id   INT                   NULL,
    `description` VARCHAR(255)          NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

-- changeset APPLAUDO:1659058906444-12
CREATE TABLE state
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255)          NULL,
    country_id BIGINT                NULL,
    CONSTRAINT pk_state PRIMARY KEY (id)
);

-- changeset APPLAUDO:1659058906444-13
CREATE TABLE user
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    first_name   VARCHAR(255)          NULL,
    last_name    VARCHAR(255)          NULL,
    phone_number VARCHAR(255)          NULL,
    email        VARCHAR(255)          NULL,
    password     VARCHAR(255)          NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

-- changeset APPLAUDO:1659058906444-14
ALTER TABLE user
    ADD CONSTRAINT uc_c98819d926c5f99f2d57497f0 UNIQUE (email);

-- changeset APPLAUDO:1659058906444-15
ALTER TABLE address
    ADD CONSTRAINT FK_ADDRESS_ON_CITY FOREIGN KEY (city_id) REFERENCES city (id);

-- changeset APPLAUDO:1659058906444-16
ALTER TABLE address
    ADD CONSTRAINT FK_ADDRESS_ON_COUNTRY FOREIGN KEY (country_id) REFERENCES country (id);

-- changeset APPLAUDO:1659058906444-17
ALTER TABLE address
    ADD CONSTRAINT FK_ADDRESS_ON_STATE FOREIGN KEY (state_id) REFERENCES state (id);

-- changeset APPLAUDO:1659058906444-18
ALTER TABLE address
    ADD CONSTRAINT FK_ADDRESS_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

-- changeset APPLAUDO:1659058906444-19
ALTER TABLE cart_item
    ADD CONSTRAINT FK_CARTITEM_ON_CART FOREIGN KEY (cart_id) REFERENCES cart (id);

-- changeset APPLAUDO:1659058906444-20
ALTER TABLE cart_item
    ADD CONSTRAINT FK_CARTITEM_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

-- changeset APPLAUDO:1659058906444-21
ALTER TABLE cart_item
    ADD CONSTRAINT FK_CARTITEM_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

-- changeset APPLAUDO:1659058906444-22
ALTER TABLE cart
    ADD CONSTRAINT FK_CART_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

-- changeset APPLAUDO:1659058906444-23
ALTER TABLE city
    ADD CONSTRAINT FK_CITY_ON_STATE FOREIGN KEY (state_id) REFERENCES state (id);

-- changeset APPLAUDO:1659058906444-24
ALTER TABLE credit_card
    ADD CONSTRAINT FK_CREDITCARD_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

-- changeset APPLAUDO:1659058906444-25
ALTER TABLE delivery_data
    ADD CONSTRAINT FK_DELIVERYDATA_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id);

-- changeset APPLAUDO:1659058906444-26
ALTER TABLE delivery_data
    ADD CONSTRAINT FK_DELIVERYDATA_ON_ORDER FOREIGN KEY (order_id) REFERENCES `order` (id_order);

-- changeset APPLAUDO:1659058906444-27
ALTER TABLE order_item
    ADD CONSTRAINT FK_ORDERITEM_ON_ORDER FOREIGN KEY (order_id) REFERENCES `order` (id_order);

-- changeset APPLAUDO:1659058906444-28
ALTER TABLE order_item
    ADD CONSTRAINT FK_ORDERITEM_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

-- changeset APPLAUDO:1659058906444-29
ALTER TABLE `order`
    ADD CONSTRAINT FK_ORDER_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

-- changeset APPLAUDO:1659058906444-30
ALTER TABLE payment_details
    ADD CONSTRAINT FK_PAYMENTDETAILS_ON_ORDER FOREIGN KEY (order_id) REFERENCES `order` (id_order);

-- changeset APPLAUDO:1659058906444-31
ALTER TABLE state
    ADD CONSTRAINT FK_STATE_ON_COUNTRYID FOREIGN KEY (country_id) REFERENCES country (id);

