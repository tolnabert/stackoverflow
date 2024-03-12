-- CREATE TABLE IF NOT EXISTS test (
--     test VARCHAR(5)
-- );

CREATE TABLE IF NOT EXISTS "user"
(
    user_id       SERIAL PRIMARY KEY,
    user_name     VARCHAR(15) UNIQUE NOT NULL,
    user_password VARCHAR(15)        NOT NULL,
    register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS question
(
    question_id   SERIAL PRIMARY KEY,
    title         VARCHAR(15)  NOT NULL,
    description   VARCHAR(250) NOT NULL,
    user_id       SMALLINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user" (user_id),
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS answer
(
    answer_id       SERIAL PRIMARY KEY,
    message         VARCHAR(250),
    user_id         SMALLINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user" (user_id),
    question_id     SMALLINT NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question (question_id),
    submission_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO "user"(user_name, user_password)
VALUES ('Norbi', 'asdasd0'),
       ('Gergő', 'asdasd1'),
       ('Peti', 'asdasd2');

INSERT INTO question(title, description, user_id)
VALUES ('question1', 'I have a problem', 1),
       ('question2', 'I have a really big problem', 2),
       ('question3', 'If I have a problem then it is your problem as well', 3);

INSERT INTO answer(message, question_id, user_id)
VALUES ('just leave it', 1, 3),
       ('have you tried restart?', 2, 2),
       ('ok who cares', 3, 1);