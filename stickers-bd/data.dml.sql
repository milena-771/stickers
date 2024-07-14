DELETE FROM stickers;
DELETE FROM sizes;
DELETE FROM aspects;

INSERT INTO sizes(name)
	VALUES ('Small'),('Medium'),('Big');
	
INSERT INTO aspects(name)
	VALUES('Matte'),('Glossy');
	
INSERT INTO stickers(name, description, image_url, price, created_at, size_id,aspect_id)
	VALUES('Vue', 'Javascript framework', 'https://commons.wikimedia.org/wiki/File:Vue.js_Logo_2.svg','2.66', now(),(
		SELECT id FROM sizes WHERE name = 'Small'
		),(
		SELECT id FROM aspects WHERE name = 'Matte'
		)),
	('Spring', 'Java framework', 'https://www.data-transitionnumerique.com/wp-content/uploads/2022/07/OG-Spring.png','3.66', now(),(
		SELECT id FROM sizes WHERE name = 'Small'
		),(
		SELECT id FROM aspects WHERE name = 'Glossy'
		)),
	('Java', 'POO', 'https://clipground.com/images/java-logo-png-2.png','1.56', now(),(
		SELECT id FROM sizes WHERE name = 'Medium'
		),(
		SELECT id FROM aspects WHERE name = 'Matte'
		));
