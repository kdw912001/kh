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
ADD CONSTRAINT FK_DEPARTMENT_CATEGORY FOREIGN KEY (CATEGORY) REFERENCES TB_CATEGORY(PK_CATEGORY_NAME);

ALTER TABLE TB_DEPARTMENT
RENAME COLUMN CATEGORY TO FK_DEPARTMENT_CATEGORY;

ALTER TABLE TB_DEPARTMENT
RENAME COLUMN FK_DEPARTMENT_CATEGORY TO CATEGORY;

--ALTER TABLE orders 
--ADD (CONSTRAINT fk_orders1) FOREIGN KEY (customer_sid) REFERENCES customer(sid);

--10
--시스템계정에서 GRANT CREATE VIEW TO homework;
CREATE OR REPLACE VIEW VW_학생일반정보(학번,학생이름,주소)
AS
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
FROM TB_STUDENT;

SELECT * FROM VW_학생일반정보;

--11
CREATE VIEW VW_지도면담(학생이름, 학과이름, 지도교수이름)
AS
SELECT STUDENT_NAME, DEPARTMENT_NAME, PROFESSOR_NAME
FROM TB_STUDENT
LEFT JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
LEFT JOIN TB_PROFESSOR ON (PROFESSOR_NO = COACH_PROFESSOR_NO)
ORDER BY 2;

SELECT * FROM "VW_지도면담";

--12
CREATE VIEW VW_학과별학생수
AS
SELECT DEPARTMENT_NAME, COUNT(*) STUDENT_COUNT
FROM TB_STUDENT
LEFT JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
GROUP BY DEPARTMENT_NAME;

SELECT * FROM VW_학과별학생수;

--13
CREATE OR REPLACE VIEW VW_학생일반정보(학번,학생이름,주소)
AS
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
FROM TB_STUDENT
WITH CHECK OPTION;

UPDATE VW_학생일반정보
SET 학생이름 = '김동욱'
WHERE 학번 = 'A213046';

SELECT * FROM VW_학생일반정보;

--학번이 'A213046'인 학생 확인
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO = 'A213046';

--14
CREATE OR REPLACE VIEW VW_학생일반정보(학번,학생이름,주소)
AS
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
FROM TB_STUDENT
WITH READ ONLY;

--15 2006년~2009년
SELECT CLASS_NO 과목번호, CLASS_NAME 과목이름, CNT 누적수강생수
FROM (SELECT CLASS_NO, COUNT(*) CNT
        FROM TB_GRADE
        WHERE SUBSTR(TERM_NO, 1, 4) BETWEEN '2006' AND '2009'
        GROUP BY CLASS_NO
        ORDER BY 2 DESC) INLV
JOIN TB_CLASS USING (CLASS_NO)
WHERE ROWNUM <= 3
ORDER BY 3 DESC, 1;
