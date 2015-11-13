CREATE TABLE authout
(
  data_id uuid NOT NULL,
  data_description character varying(100) NOT NULL,
  CONSTRAINT yourapp_data_pk PRIMARY KEY (data_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE authout
  OWNER TO postgres;