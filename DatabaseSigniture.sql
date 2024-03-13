-- CREATE TABLE IF NOT EXISTS test (
--     test VARCHAR(5)
-- );

DROP TABLE IF EXISTS "users";
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS answers;

CREATE TABLE IF NOT EXISTS "users"
(
    user_id       SERIAL PRIMARY KEY,
    user_name     VARCHAR(15) UNIQUE NOT NULL,
    user_password VARCHAR(15)        NOT NULL,
    register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS questions
(
    question_id   SERIAL PRIMARY KEY,
    title         VARCHAR(15)  NOT NULL,
    description   VARCHAR(250) NOT NULL,
    user_id       SMALLINT     NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "users" (user_id),
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS answers
(
    answer_id       SERIAL PRIMARY KEY,
    message         VARCHAR(250),
    user_id         SMALLINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "users" (user_id),
    question_id     SMALLINT NOT NULL,
    FOREIGN KEY (question_id) REFERENCES questions (question_id),
    submission_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO "users"(user_name, user_password)
VALUES ('Norbi', 'asdasd0'),
       ('Gergő', 'asdasd1'),
       ('Peti', 'asdasd2');

INSERT INTO questions (title, description, user_id)
VALUES ('question1', 'I have a problem', 1),
       ('question2', 'I have a really big problem', 2),
       ('question3', 'If I have a problem then it is your problem as well', 3);

INSERT INTO answers(message, question_id, user_id)
VALUES ('just leave it', 1, 3),
       ('have you tried restart?', 2, 2),
       ('ok who cares', 3, 1);