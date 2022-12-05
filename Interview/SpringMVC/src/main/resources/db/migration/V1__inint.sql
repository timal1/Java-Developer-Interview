create table if not exists students (
    id                bigserial primary key,
    name              varchar(50),
    age               int
);

insert into students (name, age) values ('Анна', 17), ('Сергей', 17),
                                           ('Юрий', 18), ('Алекс', 19),
                                           ('Елена', 20), ('Егор', 18),
                                           ('Максим', 17), ('Дима', 16);
