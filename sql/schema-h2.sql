
CREATE TABLE countries (
    country_id          INTEGER                             NOT NULL            AUTO_INCREMENT,
    code                VARCHAR(256)                        NOT NULL,
    description         VARCHAR(256)                        NOT NULL,
    PRIMARY KEY         (country_id)
);

CREATE TABLE cities (
    city_id             INTEGER                             NOT NULL            AUTO_INCREMENT,
    code                VARCHAR(256)                        NOT NULL,
    country_id          INTEGER                             NOT NULL,
    description         VARCHAR(256)                        NOT NULL,
    PRIMARY KEY         (city_id),
    FOREIGN KEY         (country_id)                        REFERENCES          countries(country_id)
);

CREATE TABLE places (
    place_id            INTEGER                             NOT NULL            AUTO_INCREMENT,
    address             VARCHAR(256)                        NOT NULL,
    city_id             INTEGER                             NOT NULL,
    edifice             VARCHAR(256)                        NOT NULL,
    floor               VARCHAR(256)                        NOT NULL,
    name                VARCHAR(256)                        NOT NULL,
    type                VARCHAR(256)                        NOT NULL,
    PRIMARY KEY         (place_id),
    FOREIGN KEY         (city_id)                           REFERENCES          cities(city_id)
);

CREATE TABLE responsibles (
    responsible_id      INTEGER                             NOT NULL            AUTO_INCREMENT,
    nickname            VARCHAR(256)                        NOT NULL,
    PRIMARY KEY         (responsible_id)
);

CREATE TABLE tasks (
    task_id             INTEGER                             NOT NULL            AUTO_INCREMENT,
    due_date            TIMESTAMP WITH TIME ZONE            NOT NULL,
    identifier          VARCHAR(256)                        NOT NULL,
    place_id            INTEGER                             NOT NULL,
    responsible_id      INTEGER                             NOT NULL,
    start_date          TIMESTAMP WITH TIME ZONE            NOT NULL,
    PRIMARY KEY         (task_id),
    FOREIGN KEY         (place_id)                          REFERENCES          places(place_id),
    FOREIGN KEY         (responsible_id)                    REFERENCES          responsibles(responsible_id)
);
