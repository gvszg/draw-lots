CREATE TABLE IF NOT EXISTS guests (
    id          BIGSERIAL PRIMARY KEY,
    username    varchar(128) NOT NULL,
    age         integer NOT NULL,
    create_time timestamp NOT NULL DEFAULT current_timestamp,
    update_time timestamp NOT NULL DEFAULT current_timestamp
);

CREATE index "index_age_on_guests" ON guests USING btree (age);