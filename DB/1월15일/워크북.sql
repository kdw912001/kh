--1.
CREATE TABLE TB_CATEGORY(
    NAME VARCHAR2(10),
    USE_YN CHAR(1) DEFAULT 'Y'
);

--2
CREATE TABLE TB_CLASS_TYPE(
    NO VARCHAR2(5) PRIMARY KEY,
    NAME VARCHAR2(10)
);

--3
ALTER TABLE TB_CATEGORY
MODIFY(NAME PRIMARY KEY);

--4
ALTER TABLE TB_CLASS_TYPE
MODIFY(NAME NOT NULL);

--5
ALTER TABLE TB_CLASS_TYPE
MODIFY(NO VARCHAR2(10), NAME VARCHAR2(20));

ALTER TABLE TB_CATEGORY
MODIFY(NAME VARCHAR2(20));

--6
DESC TB_CLASS_TYPE;
DESC TB_CATEGORY;

ALTER TABLE TB_CLASS_TYPE
RENAME COLUMN NO TO CLASS_TYPE_NO;

ALTER TABLE TB_CLASS_TYPE
RENAME COLUMN NAME TO CLASS_TYPE_NAME;

ALTER TABLE TB_CATEGORY
RENAME COLUMN NAME TO CATEGORY_NAME;
 
--7
DESC TB_CLASS_TYPE;
DESC TB_CATEGORY;

ALTER TABLE TB_CLASS_TYPE
RENAME COLUMN CLASS_TYPE_NO TO PK_CLASS_TYPE_NO;

ALTER TABLE TB_CATEGORY
RENAME COLUMN CATEGORY_NAME TO PK_CATEGORY_NAME;

--8
INSERT INTO TB_CATEGORY VALUES ('공학','Y');
INSERT INTO TB_CATEGORY VALUES ('자연과학','Y');
INSERT INTO TB_CATEGORY VALUES ('의학','Y');
INSERT INTO TB_CATEGORY VALUES ('예체능','Y');
INSERT INTO TB_CATEGORY VALUES ('인문사회','Y');
COMMIT;

--9
ALTER TABLE TB_DEPARTMENT
MODIFY CATEGORY REFERENCES tb_category.pk_category_name;