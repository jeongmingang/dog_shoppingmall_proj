desc dog;

INSERT INTO shoppingmall.dog
(kind, price, image, country, height, weight, content, readcount) values
('푸들', 1000, 'pu.jpg', '프랑스', 1, 20, '털이 많다', 0),
('불독', 2000, 'bul.jpg', '독일', 1, 20, '못 생겼다', 0),
('진돗개', 3000, 'jin.jpg', '대한민국', 1, 20, '용감하다', 0),
('허스키', 4000, 'h.jpg', '북극', 1, 20, '하얀색털에 멋지다', 0);

select * from dog;
