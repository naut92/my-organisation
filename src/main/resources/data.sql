INSERT INTO department (depart_name) VALUES
    ('department1'),
    ('department2'),
    ('department3'),
    ('department4');

INSERT INTO position (department_id, position_name) VALUES
(1, 'pos1'),
(2, 'pos3'),
(3, 'pos2'),
(4, 'pos2'),
(2, 'pos3'),
(4, 'pos4'),
(1, 'pos2');

INSERT INTO employee (department_id, position_id, firstname, lastname, email, pass) VALUES
    (1, 2, 'user1-fn', 'user1-ln', 'email1@email.com', '12A34'),
    (3, 1, 'user2-fn', 'user2-ln', 'email2@email.com', '12A34'),
    (2, 2, 'user3-fn', 'user3-ln', 'email3@email.com', '$2a$10$SAa58uRBRVZmL/HD6qjALOmmRyxN.1f71XpsjM6LtLnCAeJCyGJ0G'),
    (4, 4, 'user4-fn', 'user4-ln', 'email4@email.com', '12A34'),
    (1, 4, 'user5-fn', 'user5-ln', 'email5@email.com', '12A34'),
    (2, 3, 'user6-fn', 'user6-ln', 'email6@email.com', '12A34'),
    (3, 1, 'user7-fn', 'user7-ln', 'email7@email.com', '12A34');



