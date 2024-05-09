create schema yb_admin_template;
use yb_admin_template;

create table user
(
    id       int auto_increment
        primary key,
    username varchar(50)  null,
    password varchar(500) null,
    enabled  tinyint(1)   null,
    roles    varchar(50)  null
);

INSERT INTO user (id, username, password, enabled, roles) VALUES (1, 'user', '123456', 1, 'ROLE_USER');
INSERT INTO user (id, username, password, enabled, roles) VALUES (2, 'admin', '123456', 1, 'ROLE_ADMIN');
