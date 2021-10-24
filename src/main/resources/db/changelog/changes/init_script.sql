CREATE TABLE currencies (
     id    BIGSERIAL PRIMARY KEY,
     name   character varying(3) NOT NULL UNIQUE
);

INSERT INTO currencies (name)
values ('RUB'),('USD'),('EUR');

CREATE TABLE products (
    id          BIGSERIAL PRIMARY KEY,
    name        character varying(250) NOT NULL,
    description character varying(250) NOT NULL,
    price   float4 NOT NULL DEFAULT 0,
    currency_id   integer NOT NULL,
    CONSTRAINT product_to_currency FOREIGN KEY(currency_id) REFERENCES currencies (id)
);