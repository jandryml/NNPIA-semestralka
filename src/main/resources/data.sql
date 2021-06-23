INSERT INTO roles(role_type) VALUES('ROLE_USER');
INSERT INTO roles(role_type) VALUES('ROLE_MODERATOR');
INSERT INTO roles(role_type) VALUES('ROLE_ADMIN');

insert into users (email, password, username)
values ('admin@test.com', '$2a$10$53bKsVslGbkcyfEerTZ2GOoXGA/xDDORiYH6DIeIhFjTbJZKt6MEC', 'admin');

insert into user_roles (user_id, roles_id) values  (1,1);
insert into user_roles (user_id, roles_id) values  (1,2);
insert into user_roles (user_id, roles_id) values  (1,3);
