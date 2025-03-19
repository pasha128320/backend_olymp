ВСЕМ ПРИВЕТ КОРОЧЕ

У МЕНЯ СОЗДАНО 3 КЛАССА: Animal, Worker, IllnessDiary
Первый класс соединен вторичным ключом с Worker, а так же с IllnessDiary
Animal{
PK animal_id bigint,
worker_id bigint FK (Worker)
name character varying(255)
},
Worker{
PK worker_id bigint,
first_name character varying(255),
last_name character varying(255)
},
IllnessDiary{
PK illness_diary bigint,
animal_id bigint FK(Animal),
diagnosis character varying(255)
}

ну вот как то так :)
