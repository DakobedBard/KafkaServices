-- the password hash is generated by BCrypt Calculator Generator(https://www.dailycred.com/article/bcrypt-calculator)
--INSERT INTO USERS (id, username, password, first_name, last_name, email, phone_number, enabled, last_password_reset_date) VALUES (1, 'user@example.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Fan', 'Jin', 'user@example.com', '+1234567890', true, '2017-10-01 21:58:58.508-07');
--INSERT INTO USERS (id, username, password, first_name, last_name, email, phone_number, enabled, last_password_reset_date) VALUES (2, 'admin@example.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Jing', 'Xiao', 'admin@example.com', '+0987654321', true, '2017-10-01 18:57:58.508-07');
$2a$10$rjdF8Y0KS.9mdZhQ5WtqHuMT.Y14MMzBD6dlU5rZbxiV8XdkMJN/q

INSERT INTO USERS (id, username, password, first_name, last_name, email, phone_number, enabled, last_password_reset_date) VALUES (1, 'user@example.com', '$2a$10$rjdF8Y0KS.9mdZhQ5WtqHuMT.Y14MMzBD6dlU5rZbxiV8XdkMJN/q', 'Fan', 'Jin', 'user@example.com', '+1234567890', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (id, username, password, first_name, last_name, email, phone_number, enabled, last_password_reset_date) VALUES (2, 'admin@example.com', '1234', 'Jing', 'Xiao', 'admin@example.com', '+0987654321', true, '2017-10-01 18:57:58.508-07');


INSERT INTO AUTHORITY (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);
