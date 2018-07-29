CREATE TABLE public.user_item
(
id serial PRIMARY KEY,
user_id bigint REFERENCES public.user(id),
item_id bigint REFERENCES public.item(id)
)