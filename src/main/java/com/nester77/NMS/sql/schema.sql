CREATE TABLE IF NOT EXISTS users
(
    id                  BIGSERIAL PRIMARY KEY  NOT NULL,
    user_name           CHARACTER VARYING(100) NOT NULL,
    password            CHARACTER VARYING(150) NOT NULL,
    role                CHARACTER VARYING(50)  NOT NULL,
    is_active           BOOLEAN                NOT NULL DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS notices
(
    id                  BIGSERIAL PRIMARY KEY NOT NULL,
    number              VARCHAR(30) NOT NULL,
    title               VARCHAR(500) NOT NULL
);

CREATE TABLE IF NOT EXISTS log_entries
(
    id                  BIGSERIAL PRIMARY KEY NOT NULL,
    creator_id          BIGINT REFERENCES users (id),
    notice_id           BIGINT REFERENCES notices (id),
    description         VARCHAR(500),
    status              CHARACTER VARYING(60),
    FOREIGN KEY (creator_id) REFERENCES users (id),
    FOREIGN KEY (notice_id) REFERENCES notices (id)
);

CREATE TABLE IF NOT EXISTS tasks
(
    id                  BIGSERIAL PRIMARY KEY NOT NULL,
    create_time         TIMESTAMP,
    creator_id          BIGINT REFERENCES users (id),
    description         VARCHAR(300),
    log_entry_id        BIGINT REFERENCES log_entries (id),
    executor_id         BIGINT REFERENCES users (id),
    end_time            TIMESTAMP,
    conclusion          VARCHAR(500),
    status              CHARACTER VARYING(60),
    FOREIGN KEY (creator_id) REFERENCES users (id),
    FOREIGN KEY (executor_id) REFERENCES users (id),
    FOREIGN KEY (log_entry_id) REFERENCES log_entries (id)
);