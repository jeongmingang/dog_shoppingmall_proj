select user(), database ();

SELECT id, kind, price, image, country
	, height, weight, content, readcount FROM dog;

SELECT id, kind, price, image, country
	, height, weight, content, readcount FROM dog
	WHERE id=1;

INSERT INTO shoppingmall.dog
(kind, price, image, country, height, weight, content, readcount) values
('푸들', 1000, 'pu.jpg', '프랑스', 1, 20, '털이 많다', 0);

INSERT INTO dog VALUES(dog_seq.nextval,?,?,?,?,?,?,?,?);

UPDATE dog SET readcount = readcount + 1 WHERE id=1;

