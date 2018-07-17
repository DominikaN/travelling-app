CREATE TABLE public."user"
(
    id bigserial PRIMARY KEY,
    name varchar NOT NULL,
    nickname varchar UNIQUE
)