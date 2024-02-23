DROP TABLE drivers_license IF EXISTS;
DROP TABLE man IF EXISTS;

CREATE TABLE man
(
    id                 INTEGER     NOT NULL IDENTITY,
    name               VARCHAR(50) NOT NULL,
    drivers_license_id INTEGER     NOT NULL
);
CREATE UNIQUE INDEX person_name ON man (name);
CREATE UNIQUE INDEX person_drivers_license_id ON man (drivers_license_id);

CREATE TABLE drivers_license
(
    id             INTEGER NOT NULL IDENTITY,
    license_number INTEGER NOT NULL
);
CREATE UNIQUE INDEX drivers_license_license_number ON drivers_license (license_number);
