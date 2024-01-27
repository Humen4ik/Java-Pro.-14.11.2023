create table if not exists Homework(
	id serial primary key,
	name VARCHAR(50) not null,
	description VARCHAR(50) not null
);

create table if not exists Lesson(
	id serial primary key,
	name VARCHAR(50) not null,
	updatedAt date not null,
	homework_id INT not null,
	foreign key(homework_id)
	references Homework(id)
);

create table if not exists Schedule(
	id serial primary key,
	name VARCHAR(50) not null,
	updatedAt date not null,
	lessond_id int not null,
	foreign key(lessond_id)
	references Lesson(id)
);

create table if not exists Lesson_Schedule(
	schedule_id int references Schedule(id),
	lesson_id int references Lesson(id)
);