drop TABLE IF EXISTS noise;

CREATE TABLE noise (
  id char(36) NOT NULL,
  noise_name char(36) NOT NULL,
  noise_type char(36) NOT NULL,
  CONSTRAINT noise_PK PRIMARY KEY (id,noise_name)
);