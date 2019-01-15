--DAY 11

--데이터 딕셔너리
--사용자가 소유한 테이블 객체 정보 : USER_TALES
SELECT * FROM USER_TABLES;

--사용자가 만든 제약조건 정보 : USER_CONSTRAINTS
SELECT * FROM USER_CONSTRAINTS;

--사용자가 만든 시퀀스 정보 : USER_SEQUENCES
SELECT * FROM USER_SEQUENCES;--아직 만든게 없으니 데이터가 없음

--사용자가 만든 인덱스 정보 : USER_INDEXES
SELECT * FROM USER_INDEXES;--기본적으로 생성되어 있는게 있음

--사용자가 만든 뷰 정보 : USER_VIEWS
SELECT * FROM USER_VIEWS; --시퀀스처럼 아직 정보가 없음

--사용자가 만든 테이블, 뷰, 시퀀스 정보 : USER_CATALOG
SELECT * FROM USER_CATALOG;

--현재 사용자가 접근할 수 있는 모든 테이블 정보 : ALL_TABLES
SELECT * FROM ALL_TABLES;

--DBA (데이터베이스 관리자)가 접근할 수 있는 테이블 조회 : DBA_TABLES
SELECT * FROM DBA_TABLES; -- SYSTEM 계정으로 로그온해서 조회 가능함

-- 사용자가 만든 모든 객체 정보 : USER_OBJECTS
SELECT * FROM USER_OBJECTS;

-- **************************************
-- DDL
-- CREATE, ALTER, DROP
-- 테이블 : CREATE TABLE, ALTER TABLE, DROP TABLE
-- 뷰 : CREATE VIEW, DROP VIEW
-- 시퀀스 : CREATE SEQUENCE, ALTER SEQUENCE, DROP SEQUENCE

-- 테이블 수정
-- 컬럼 추가/삭제, 제약조건 추가/삭제
-- 컬럼 자료형 변경, DEFAULT 값 변경
-- 테이블명, 컬럼명, 제약조건이름 변경

-- 컬럼 추가
-- 테이블 작성시 컬럼 설정과 동일하게 작성하면 됨
ALTER TABLE DCOPY
ADD (LNAME VARCHAR2(40));

SELECT * FROM DCOPY;

ALTER TABLE DCOPY
ADD (CNAME VARCHAR2(30) DEFAULT '한국');

DESC DCOPY;

SELECT * FROM DCOPY;

-- 제약조건 추가
CREATE TABLE EMP2
AS
SELECT * FROM EMPLOYEE;

ALTER TABLE  EMP2
ADD PRIMARY KEY (EMP_);

ALTER TABLE EMP2
ADD CONSTRAINT E2_UNENO UNIQUE (EMP_NO);

-- NOT NULL 제약조건은 ADD로 추가할 수 없음
-- 컬럼이 현재 NULL 을 사용할 수 있는 상태에서 NULL을 사용 못하게 바꾸는 것임
-- 추가가 아니라 변경임. MODIFY 사용해야 함
ALTER TABLE EMP2
ADD NOT NULL (HIRE_DATE); -- ERROR

ALTER TABLE EMP2
MODIFY (HIRE_DATE NOT NULL
);


-- 제약조건 삭제
-- 1개 삭제일 때
ALTER TABLE CONSTRAINT_EMP
DROP CONSTRAINT CHK;

-- 여러 개 삭제일 때
ALTER TABLE CONSTRAINT_EMP
DROP CONSTRAINT FKJID
DROP CONSTRAINT FKMID
DROP CONSTRAINT FKDID;

--데이터 딕셔너리를 통해 삭제 확인
SELECT TABLE_NAME, CONSTRAINT_NAME
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'CONSTRATINT_EMP';

-- NOT NULL 제약조건은 삭제가 아니라 NULL로 변경함
-- DROP 이 아니라 MODIFY 사용함
ALTER TABLE CONSTRAINT_EMP
MODIFY (ENAME NULL, ENO NULL);

-- 테이블의 컬럼을 관리하는 데이터 딕셔너리 : USER_TAB_COLS
SELECT * FROM USER_TAB_COLS;

DESC USER_TAB_COLS;

SELECT TABLE_NAME, COLUMN_NAME, NULLABLE
FROM USER_TAB_COLS
WHERE TABLE_NAME = 'CONSTRAINT_EMP';

--테이블의 컬럼별 제약조건을 관리하는 딕셔너리 : USER_CONS_COLUMNS
CREATE TABLE TB_EXAM(
    COL1 CHAR(3) PRIMARY KEY,
    ENAME VARCHAR2(20), 
    FOREIGN KEY (COL1) REFERENCES EMPLOYEE
);

SELECT CONSTRAINT_NAME AS 이름, 
    CONSTRAINT_TYPE AS 유형,
    COLUMN_NAME AS 컬럼,
    R_CONSTRAINT_NAME AS 참조,
    DELETE_RULE AS 삭제규칙
FROM USER_CONSTRAINTS
JOIN USER_CONS_COLUMNS USING (CONSTRAINT_NAME, TABLE_NAME)
WHERE TABLE_NAME = 'TB_EXAM';

SELECT * FROM USER_CONSTRAINTS;

-- 이름 바꾸기
-- 컬럼명, 제약조건이름, 테이블명

--컬럼명 바꾸기
ALTER TABLE TB_EXAM
RENAME COLUMN COL1 TO EMPID;

DESC TB_EXAM;

--제약조건 이름 바꾸기
ALTER TABLE TB_EXAM
RENAME CONSTRAINTS  SYS_C007379 TO PK_EID;

ALTER TABLE TB_EXAM
RENAME CONSTRAINTS  SYS_C007380 TO FK_EID;

--테이블 바꾸기
ALTER TABLE TB_EXAM RENAME TO TB_SAMPLE1;
--또는
RENAME TB_SAMPLE1 TO TB_SAMPLE;

-- 테이블 삭제하기
-- DROP TABLE 테이블명;
-- FOREIGN KEY 제약조건에 의해 참조되고 있는 테이블은 삭제 불가
CREATE TABLE DEPT2 (
    DID CHAR(2) PRIMARY KEY,
    DNMAE VARCHAR2(10)
);

CREATE TABLE EMP6(
    EID CHAR(3) PRIMARY KEY,
    ENAME VARCHAR2(10),
    DID CHAR(2) REFERENCES DEPT2
);

-- 참조 테이블은 삭제 못함
DROP TABLE DEPT2; --ERROR
-- 삭제하려면 DEPT2에 대한 REFERENCES 제약조건을 함께 삭제하면 가능함
DROP TABLE DEPT2 CASCADE CONSTRAINTS;

-- 데이터 딕셔너리를 통해 삭제 확인
SELECT TABLE_NAME
FROM USER_TABLES
WHERE TABLE_NAME LIKE 'D%';

--*****************************************
-- DML (Data Manipulation Language : 데이터 조작어)
-- INSERT 문, UPDATE 문, DELETE 문
-- 테이블에 데이터를 추가하거나, 기록된 데이터를 수정하거나,
-- 기록된 행을 삭제하는 구문임.
-- INSERT 문 : 새로운 행을 추가함 (행 갯수 증가됨)
-- UPDATE 문 : 데이터를 변경함 (행 갯수 변화 없음)
-- DELETE 문 : 해당 데이터를 포함한 행을 삭제함 (행 갯수가 줄어듦)
-- TRUNCATE 문 : 테이블의 모든 행을 삭제함

/*
UPDATE 테이블명
SET 컬럼명 = 변경할 값, 컬럼명 = 변경할 값, ......
WHERE 컬럼명 비교연산자 비교값;
*/

SELECT * FROM DCOPY;
DROP TABLE DCOPY;

CREATE TABLE DCOPY
AS
SELECT * FROM DEPARTMENT;

SELECT * FROM DCOPY;

UPDATE DCOPY
SET DEPT_NAME = '인사팀';
--WHERE 절에 생략되면 컬럼 전체의 값이 변경됨

ROLLBACK; -- 방금 실행한 DML 구문 실행 취소됨.

UPDATE DCOPY
SET DEPT_NAME = '인사팀'
WHERE DEPT_ID = '10';

SELECT * FROM DCOPY;

-- UPDATE 문에 서브쿼리 사용할 수 있음
-- SET 절과 WHERE 절에서 사용할 수 있음
-- SET 컬럼명 = (서브쿼리)
-- WHERE 컬럼명 비교연산자 (서브쿼리)

-- 심하균의 직급코드와 급여를 성해교 직원관 같은 값으로 변경하시오
UPDATE EMPLOYEE
SET JOB_ID = (SELECT JOB_ID FROM EMPLOYEE
                WHERE EMP_NAME = '성해교'),
    SALARY = (SELECT SALARY FROM EMPLOYEE
                WHERE EMP_NAME = '성해교')
WHERE EMP_NAME = '심하균';

--다중열 단일행 서브쿼리로 변경하면
UPDATE EMPLOYEE
SET (JOB_ID, SALARY) = (SELECT JOB_ID, SALARY
                        FROM EMPLOYEE
                        WHERE EMP_NAME = '성해교')
WHERE EMP_NAME = '심하균';

--확인
SELECT EMP_NAME, JOB_ID, SALARY
FROM EMPLOYEE
WHERE EMP_NAME IN ('심하균', '성해교');

--취소
ROLLBACK;

-- DEFAULT 가 설정된 컬럼값을 변경할 때,
-- 변경할 값 대신에 DEFAULT 키워드 사용해도 됨
SELECT EMP_ID, EMP_NAME, MARRIAGE
FROM EMPLOYEE
WHERE EMP_ID = '210';

UPDATE EMPLOYEE
SET MARRIAGE = DEFAULT
WHERE EMP_ID = '210';

ROLLBACK;

-- WHERE 절에서도 서브쿼리 사용할 수 있음

-- 해외영업2팀 직원들의 보너스포인트를 0.3으로 변경하시오.
UPDATE EMPLOYEE
SET BONUS_PCT = 0.3
WHERE DEPT_ID = (SELECT DEPT_ID FROM DEPARTMENT
                 WHERE DEPT_NAME = '해외영업2팀');
                 
--확인
SELECT EMP_NAME, DEPT_ID, BONUS_PCT
FROM EMPLOYEE
WHERE DEPT_ID = (SELECT DEPT_ID FROM DEPARTMENT
                WHERE DEPT_NAME = '해외영업2팀');
                
ROLLBACK;

-- ******************
-- INSERT 문
-- 테이블에 새 행을 추가하는 구문임
-- 새로운 데이터 기록 저장시 사용
/*
INSERT INTO 테이블명 [(컬럼명, 컬럼명, ....)]
VALUES (기록할 값, 기록할 값, ....);
*/

CREATE TABLE DEPT3 (
    DEPTID CHAR(2),
    DEPTNAME VARCHAR2(20)
);

SELECT COUNT(*) FROM DEPT3; -- 0개

INSERT INTO DEPT3
VALUES ('10','회계팀');

SELECT COUNT(*) FROM DEPT3; -- 1개

INSERT INTO DEPT3
VALUES ('20', '인사팀');

SELECT COUNT(*) FROM DEPT3; -- 2개

SELECT * FROM DEPT3;

COMMIT; -- 저장 완료함

INSERT INTO EMPLOYEE (EMP_ID, EMP_NO, EMP_NAME, EMAIL, PHONE,
                    HIRE_DATE, JOB_ID, SALARY, BONUS_PCT,
                    MARRIAGE, MGR_ID, DEPT_ID)
VALUES ('900', '811122-1458712', '오윤하', 'oyuha@kh.org','01012345678',
        DEFAULT, 'J7', 3000000, NULL, DEFAULT, '176', '90');
        
SELECT * FROM EMPLOYEE;

ROLLBACK;

-- 컬럼명 생략되면, 테이블의 전체 행에 값 기록해야 함
-- 컬럼 갯수와 값 갯수 같아야 함.
-- 컬럼 생성 순서와 값 기록 순서도 같아야 함.
INSERT INTO EMPLOYEE
VALUES ('777','이병언','811122-1475214','leebj@kh.org','01012345678',
        SYSDATE, 'J6', 3500000, NULL, DEFAULT, NULL, NULL);
        
-- 서브쿼리를 이용해서 INSERT 할 수 있다.
-- VALUES 사용하지 않는다.

CREATE TABLE EMP (
    EMP_ID CHAR (3),
    EMP_NAME VARCHAR2(20),
    DEPT_NAME VARCHAR2(20)
);

INSERT INTO EMP
(SELECT EMP_ID, EMP_NAME, DEPT_NAME
 FROM EMPLOYEE
 LEFT JOIN DEPARTMENT USING (DEPT_ID));
 
 SELECT * FROM EMP;
 
 ROLLBACK;