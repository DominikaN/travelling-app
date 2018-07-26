CREATE TABLE public."flight"
(
    id serial PRIMARY KEY,
    flight_number varchar NOT NULL UNIQUE,
    airlines varchar NOT NULL,
    number_of_transfers INT NOT NULL
)