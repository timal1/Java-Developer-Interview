create table if not exists students (
    id                  bigserial primary key,
    name               varchar(50),
    mark               int
);

insert into students (name, mark) values ('Анна', 5), ('Сергей', 4),
                                           ('Юрий', 4), ('Алекс', 5),
                                           ('Елена', 2), ('Егор', 4),
                                           ('Максим', 3), ('Дима', 3);
