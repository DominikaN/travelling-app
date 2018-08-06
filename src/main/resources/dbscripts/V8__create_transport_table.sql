CREATE TABLE public."transport"
(
id serial NOT NULL PRIMARY KEY,
transport_type VARCHAR NOT NULL,
transport_price double NOT NULL,
transport_destination VARCHAR NOT NULL
)