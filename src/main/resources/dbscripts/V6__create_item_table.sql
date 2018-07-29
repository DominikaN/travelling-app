CREATE TABLE public."item"
(
id serial PRIMARY KEY,
itemName VARCHAR NOT NULL,
numberOfItems int NOT NULL,
isAvailable BOOLEAN NOT NULL
)