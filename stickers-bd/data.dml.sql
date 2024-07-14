DELETE FROM stickers;
DELETE FROM sizes;
DELETE FROM aspects;

INSERT INTO sizes(name)
	VALUES ('Small'),('Medium'),('Big');
	
INSERT INTO aspects(name)
	VALUES('Matte'),('Glossy');
	
INSERT INTO stickers(name, description, image_url, price, created_at, size_id,aspect_id)
	VALUES('ET', 'From the film', 'https://shop.stick-avenue.com/1196-medium_default/et.jpg','2.66', now(),(
		SELECT id FROM sizes WHERE name = 'Small'
		),(
		SELECT id FROM aspects WHERE name = 'Matte'
		)),
	('Stuart Little', 'For kids', 'https://ih1.redbubble.net/image.2811356742.8294/st,small,507x507-pad,600x600,f8f8f8.jpg','3.66', now(),(
		SELECT id FROM sizes WHERE name = 'Small'
		),(
		SELECT id FROM aspects WHERE name = 'Glossy'
		)),
	('Iron Man', 'Marvel', 'https://www.art-deco-stickers.fr/17437-large_default/stickers-iron-man-avengers.jpg','1.56', now(),(
		SELECT id FROM sizes WHERE name = 'Medium'
		),(
		SELECT id FROM aspects WHERE name = 'Matte'
		)),
	('Batman', 'DC comics', 'https://lezebre.lu/images/detailed/14/18576-batman-vetement-logo.png','4.80', now(),(
		SELECT id FROM sizes WHERE name = 'Big'
		),(
		SELECT id FROM aspects WHERE name = 'Matte'
		)),
	('Gucci', 'Fashion', 'https://passion-stickers.com/675-large_default/stickers-gucci.jpg','0.99', now(),(
		SELECT id FROM sizes WHERE name = 'Small'
		),(
		SELECT id FROM aspects WHERE name = 'Glossy'
		)),
	('Lacoste', 'Fashion', 'https://passion-stickers.com/4350-large_default/lacoste.jpg','1.32', now(),(
		SELECT id FROM sizes WHERE name = 'Medium'
		),(
		SELECT id FROM aspects WHERE name = 'Matte'
		)),
	('Zanzibar', 'Travel', 'https://ih1.redbubble.net/image.589733260.0157/st,small,507x507-pad,600x600,f8f8f8.u3.jpg','2.56', now(),(
		SELECT id FROM sizes WHERE name = 'Small'
		),(
		SELECT id FROM aspects WHERE name = 'Matte'
		)),
	('Japon', 'Travel', 'https://i.pinimg.com/originals/d9/29/18/d9291882166d6cae24f44a32f866878f.jpg','2.78', now(),(
		SELECT id FROM sizes WHERE name = 'Small'
		),(
		SELECT id FROM aspects WHERE name = 'Matte'
		)),
	('Fiat', 'Cars', 'https://media.cdnws.com/_i/46016/4377/2868/80/stickers-fiat-ref16-autocollant-voiture-sticker-auto-autocollants-decals-sponsors-racing-tuning-sport-logo-copie-min.jpeg','3.45', now(),(
		SELECT id FROM sizes WHERE name = 'Small'
		),(
		SELECT id FROM aspects WHERE name = 'Matte'
		)),
	('Ferrari', 'Cars', 'https://lezebre.lu/images/detailed/79/Ferrari_logo_4.png','2.66', now(),(
		SELECT id FROM sizes WHERE name = 'Small'
		),(
		SELECT id FROM aspects WHERE name = 'Matte'
		));
