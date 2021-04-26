-- 개
DROP TABLE IF EXISTS shoppingmall.Dog RESTRICT;

-- 개_쇼핑몰
DROP SCHEMA IF EXISTS shoppingmall;

-- 개_쇼핑몰
CREATE SCHEMA shoppingmall;

-- 개
CREATE TABLE shoppingmall.Dog (
	id        INT          NOT NULL COMMENT '아이디', -- 아이디
	kind      VARCHAR(20)  NOT NULL COMMENT '개종류', -- 개종류
	price     INT          NOT NULL COMMENT '가격', -- 가격
	image     VARCHAR(20)  NOT NULL COMMENT '개이미지', -- 개이미지
	country   VARCHAR(20)  NOT NULL COMMENT '원산지', -- 원산지
	height    INT          NULL     COMMENT '개신장', -- 개신장
	weight    INT          NULL     COMMENT '개체중', -- 개체중
	content   VARCHAR(400) NULL     COMMENT '개설명', -- 개설명
	readcount INT          NULL     COMMENT '조회수' -- 조회수
)
COMMENT '개';

-- 개
ALTER TABLE shoppingmall.Dog
	ADD CONSTRAINT PK_Dog -- 개 기본키
		PRIMARY KEY (
			id -- 아이디
		);

ALTER TABLE shoppingmall.Dog
	MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT COMMENT '아이디';
	