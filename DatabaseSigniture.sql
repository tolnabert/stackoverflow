-- CREATE TABLE IF NOT EXISTS test (
--     test VARCHAR(5)
-- );

DROP TABLE IF EXISTS "users", questions, answers;

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
    title         VARCHAR(150)  NOT NULL,
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
    FOREIGN KEY (question_id) REFERENCES questions (question_id) ON DELETE CASCADE ,
    submission_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Users
INSERT INTO "users"(user_name, user_password)
VALUES ('Norbi', 'asdasd0'),
       ('Gergő', 'asdasd1'),
       ('Peti', 'asdasd2');

-- Questions
INSERT INTO questions (title, description, user_id)
VALUES ('How to defeat a coding bug with a lightsaber?', 'I''m facing difficulties battling bugs. Any tips using the force?', 1),
       ('Best practices for optimizing the Death Star database?', 'Working on a project with slow database queries. Any tips for intergalactic optimization?', 2),
       ('What are the latest trends in intergalactic machine learning?', 'I want to stay updated with the latest developments in ML across galaxies. Any recommendations from the dark side?', 3);

-- Answers
INSERT INTO answers(message, question_id, user_id)
VALUES ('Use the Force to find the bug and strike it down with your lightsaber.', 1, 3),
       ('Consider building Death Star indexes for faster query performance in the galaxy.', 2, 2),
       ('Check out the latest Sith research papers and attend dark side conferences for ML trends.', 3, 1);

-- Additional Answers
INSERT INTO answers(message, question_id, user_id)
VALUES ('Try using Jedi mind tricks to debug your code.', 1, 2),
       ('Use the power of the dark side to force choke unnecessary database queries.', 2, 3),
       ('Explore the dark web for Sith-approved online courses on ML advancements.', 3, 2),
       ('Consider attending coding meetups on Tatooine for networking and inspiration.', 1, 1),
       ('Optimize your queries by using the Force for proper indexing and avoiding unnecessary joins.', 2, 1),
       ('Join the Dark Side communities on social media to engage with Sith lords and enthusiasts.', 3, 3);
