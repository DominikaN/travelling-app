CREATE TABLE public.user_flight(
	id bigserial PRIMARY KEY,
	user_id bigint REFERENCES public.user(id),
	flight_id bigint REFERENCES public.flight(id)
);