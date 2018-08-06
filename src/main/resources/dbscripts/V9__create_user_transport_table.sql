CREATE TABLE public.user_transport
(
id serial PRIMARY KEY,
user_id bigint REFERENCES public.user(id),
transport_id bigint REFERENCES public.transport(id)
)