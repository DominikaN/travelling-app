ALTER table public.flight ADD column origin varchar NOT NULL;
ALTER table public.flight ADD column destination varchar NOT NULL;
ALTER table public.flight DROP column number_of_transfers;