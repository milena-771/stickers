DROP TABLE IF EXISTS stickers;
DROP TABLE IF EXISTS sizes; 
DROP TABLE IF EXISTS aspects; 

CREATE TABLE sizes (
 id SERIAL PRIMARY KEY,
 name varchar(200) UNIQUE NOT NULL

);


CREATE TABLE aspects (
 id SERIAL PRIMARY KEY,
 name varchar(200) UNIQUE NOT NULL
);


CREATE TABLE stickers (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) UNIQUE NOT NULL,
	description VARCHAR(1000) NOT NULL,
	image_url VARCHAR(300) NOT NULL,
	price float NOT NULL,
	created_at TIMESTAMP NOT NULL,
	size_id INTEGER,
	CONSTRAINT fk_size_id
    	FOREIGN KEY (size_id)
    	REFERENCES sizes(id),
	aspect_id INTEGER,
	CONSTRAINT fk_aspect_id
    	FOREIGN KEY (aspect_id)
    	REFERENCES aspects(id)
	
);