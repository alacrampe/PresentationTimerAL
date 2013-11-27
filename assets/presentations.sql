DROP TABLE IF EXISTS presentation;
CREATE TABLE presentation (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	name VARCHAR(100),
);
DROP TABLE IF EXISTS task;
CREATE TABLE task (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	person_id INTEGER,
	presentation_id INTEGER,
	name VARCHAR(100),
	timelength INTEGER
);
DROP TABLE IF EXISTS person;
CREATE TABLE person (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	name VARCHAR(100)
);

