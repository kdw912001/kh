-- DAY 10

--DDL
--테이블 무결성 제약조건 (CONSTRAINT)

--1. NOT NULL
--컬럼에 값이 반드시 기록되어야 할 때 설정함 (웹에서의 필수입력항목을 뜻함)
--컬럼 레벨에서만 설정할 수 있음.

CREATE TABLE TESTNN (
    NNID NUMBER(5) NOT NULL, --컬럼레벨
    NN_NAME VARCHAR2(20)
);

-- 값 기록 테스트
INSERT INTO TESTNN (NNID, NN_NAME)
VALUES (NULL, NULL);  --ERROR
-- NNID 에 NOT NULL 제약조건 위배됨.

INSERT INTO TESTNN -- 컬럼명이 생략되면, 테이블의 모든 컬럼에 값 기록해야 함
VALUES (1, NULL); --테이블의 컬럼 생성 순서와 자료형 맞춰서 값 기록 나열함

SELECT * FROM TESTNN;

INSERT INTO TESTNN (NN_NAME)
VALUES ('ORACLE'); --생략된 컬럼은 자동 NULL 처리됨 >> 에러

--테이블 레벨 적용
CREATE TABLE TESTNN2 (
    NN_ID NUMBER(5) CONSTRAINT T2_NNID NOT NULL,
    NN_NAME VARCHAR2(10)--,
    --테이블 레벨
    --[CONTRAINT 제약조건이름,] 제약조건 종류 (적용할 컬럼명)
    --CONSTRAINT T2_NNNAME NOT NULL (NN_NAME)  >> ERROR
);

--2. UNIQUE
--해당 컬럼의 중복값(같은 값) 입력을 막겠다는 의미의 제약조건임
--설정하면 같은 값은 두 번 기록 못 하는 컬럼이 됨
--컬럼레벨, 테이블레벨 둘 다 설정할 수 있음
--복합키로 설정할 수 있음.

CREATE TABLE TESTUN (
    UN_ID CHAR(3) UNIQUE,
    UN_NAME VARCHAR2(10) NOT NULL
);

--기록 테스트
INSERT INTO TESTUN VALUES ('AAA','ORACLE');
INSERT INTO TESTUN VALUES ('AAA','JAVA'); --제약조건 위배됨 >> 에러
INSERT INTO TESTUN VALUES ('AAB','JAVA');

SELECT * FROM TESTUN;

CREATE TABLE TESTUN2(
    UN_ID CHAR(3) CONSTRAINT T2_UNID UNIQUE,
    UN_NAME VARCHAR2(10) CONSTRAINT T2_UNNAME NOT NULL
);

CREATE TABLE TESTUN3 (
    UN_ID CHAR(3),
    UN_NAME VARCHAR2(10) NOT NULL,
    CONSTRAINT T3_UNID UNIQUE (UN_ID)
);

--3. PRIMARY KEY
--테이블에서 한 행의 정보를 찾기위해 쓸 수 있는 값이 기록된 컬럼에 적용함.
--ㅜNOT NULL + UNIQUE
--한 테이블에 한번만 사용할 수 있음.

CREATE TABLE TESTPK(
    PK_ID NUMBER PRIMARY KEY, 
    PK_NAME VARCHAR2(15) NOT NULL,
    PK_DATE DATE
);

-- 기록 테스트
INSERT INTO TESTPK VALUES (1, '홍길동', '15/03/12');
INSERT INTO TESTPK VALUES (NULL, '박문수', SYSDATE); --에러 : NOTNULL 제약조건 위배
INSERT INTO TESTPK VALUES (1, '박문수', SYSDATE); --에러 : UNIQUE 제약조건 위배됨
INSERT INTO TESTPK VALUES (2, '박문수', SYSDATE);

SELECT * FROM TESTPK;

--테이블당 한 번만 설정할 수 있음
CREATE TABLE TESTPK2 (
    PID NUMBER PRIMARY KEY, 
    PNAME VARCHAR2(15) PRIMARY KEY
); --ERROR

--컬럼레벨에서 설정 
CREATE TABLE TESTPK2(
    PID NUMBER CONSTRAINT P2_PID PRIMARY KEY,
    PNAME VARCHAR2(15),
    PDATE DATE
);

--테이블 레벨에서 설정
CREATE TABLE TESTPK3(
    PID NUMBER,
    PNAME VARCHAR2(15),
    PDATE DATE,
    CONSTRAINT T3_PID PRIMARY KEY (PID)
);

--4. CHECK
--컬럼에 기록되는 값에 대한조건 설정을 하는 제약조건임.
--CHECK (컬럼명 연산자 비교값)
--비교값은 고정값이어야 함. 바뀌는 값이면 에러남.

CREATE TABLE TESTCHK(
    C_NAME VARCHAR2(15) CONSTRAINT TCK_NAME NOT NULL,
    C_PRICE NUMBER(5) CHECK (C_PRICE BETWEEN 1 AND 99999),
    C_LEVEL CHAR(1) CHECK (C_LEVEL IN ('A','B','C'))
);

INSERT INTO TESTCHK VALUES('갤럭시 S9', 65000, 'A');
INSERT INTO TESTCHK VALUES('LG G7', 125000, 'A');--ERROR : CHECK 제약조건 위배됨.
INSERT INTO TESTCHK VALUES('LG G7', 0, 'A'); --ERROR : CHECK 제약조건 위배됨
INSERT INTO TESTCHK VALUES('LG G7', 65300, 'D'); --ERROR : CHECK 제약조건 위배됨

SELECT * FROM TESTCHK;

CREATE TABLE TESTCHK2 (
    C_NAME VARCHAR2(15) PRIMARY KEY,
    C_PRICE NUMBER(5) CHECK (C_PRICE >= 1 AND C_PRICE <= 99999),
    C_LEVEL CHAR(1) CHECK (C_LEVEL = 'A' OR C_LEVEL = 'B' OR C_LEVEL = 'C'),
    --C_DATE DATE CHECK (C_DATE < SYSDATE)
    --비교값은 반드시 리터럴(값) 사용, 바뀌는 값은 사용 못 함
    --C_DATE DATE CHECK (C_DATE < TO_DATE('16/01/01','RR/MM/DD')) --이게 맞는데 DEVELOPER 툴에 의한 버그로 인해 에러가 남.
    C_DATE DATE CHECK (C_DATE < TO_DATE('16/01/01','YYYY/MM/DD')) --'YYYY'형태만 생성 됨 >> BUG
);

CREATE TABLE CONSTRAINT_EMP(
    EID CHAR(3) CONSTRAINT PKEID PRIMARY KEY,
    ENAME VARCHAR2(20) CONSTRAINT NENAME NOT NULL,
    ENO CHAR(14) CONSTRAINT NENO NOT NULL CONSTRAINT UENO UNIQUE,
    EMAIL VARCHAR2(25) CONSTRAINT UEMAIL UNIQUE,
    PHONE VARCHAR2(12),
    HIRE_DATE DATE DEFAULT SYSDATE,
    JID CHAR(2) CONSTRAINT FKJID REFERENCES JOB ON DELETE SET NULL,
    SALARY NUMBER,
    BONUS_PCT NUMBER,
    MARRIAGE CHAR(1) DEFAULT 'N' CONSTRAINT CHK CHECK (MARRIAGE IN ('Y','N')),
    MID CHAR(3) CONSTRAINT FKMID REFERENCES CONSTRAINT_EMP ON DELETE SET NULL,
    DID CHAR(2),
    CONSTRAINT FKDID FOREIGN KEY (DID) REFERENCES DEPARTMENT ON DELETE CASCADE
);

--5. FOREIGN KEY
-- 외래키, 외부키 
-- 다른 테이블에서 제공하는 값만 사용할 수 있는 컬럼을 의미함
-- 제공되지 않는 값 사용하면 에러 남.

--컬럼레벨에서 설정
--[CONSTRAINT 이름] REFERENCES 참조테이블명 (참조할 컬럼명)
--테이블 레벨에서 설정
--[CONSTRAINT 이름] FOREIGN KEY (적용할 컬럼명) REFERENCES 참조테이블 [(참조컬럼명)]
--NULL 은 사용할 수 있음

CREATE TABLE TESTFK (
    EMP_ID CHAR(3) REFERENCES EMPLOYEE,
    --참조컬럼명이 생략되면 PRIMARY KEY 컬럼이 자동 연결됨.
    DEPT_ID CHAR(2) CONSTRAINT TFK_DID REFERENCES DEPARTMENT (DEPT_ID),
    JOB_ID CHAR(2),
    --테이블레벨
    CONSTRAINT TFK_JID FOREIGN KEY (JOB_ID) REFERENCES JOB (JOB_ID)
);

--기록테스트
--연결된 테이블의 연결된 컬럼에 기록되어 있는 값만 사용할 수 있음.
INSERT INTO TESTFK VALUES ('300', NULL, NULL); --제공되지 않는 값 사용, 에러
                                                --'300'이 없기 때문에 에러
INSERT INTO TESTFK VALUES ('100', NULL, NULL); --OK
INSERT INTO TESTFK VALUES ('200', '70', NULL); --제공되지 않는 부서코드 사용, 에러
INSERT INTO TESTFK VALUES ('200', '90', NULL); --OK
INSERT INTO TESTFK VALUES ('124', '80', 'J9'); --제공되지 않는 직급코드 사용, 에러
INSERT INTO TESTFK VALUES ('124', '80', 'J7'); --OK

SELECT * FROM TESTFK;

--외래키 제약조건에서 PARENT KEY 가 될 수 있는 컬럼은
--PRIMARY KEY 또는 UNIQUE 제약조건이 설정된 컬럼만 참조컬럼이 될 수 있음.
CREATE TABLE NOPK (
    ID CHAR(3),
    NAME VARCHAR2(10)
);

CREATE TABLE TESTFK2(
    FID CHAR(3) REFERENCES NOPK (ID), --ERROR
      --참조하는 테이블의 컬럼명이 UNIQUE조건을 갖고 있거나 PRIMARY KEY여야 함.
    FNAME VARCHAR2(10)
);

CREATE TABLE TESTUN5 (
    ID CHAR(3) UNIQUE,
    NAME VARCHAR2(10)
);

CREATE TABLE TESTFK2(

    FID CHAR(3) REFERENCES TESTUN5 (ID), 
    FNAME VARCHAR2(10)
);

--복합키 설정 관련
--여러 개의 컬럼을 묶어서 UNIQUE 제약조건이나 PRIMARY KEY 제약조건을 
--설정한 복합키를 참조할 경우
CREATE TABLE TEST_COMPLEX (
    ID NUMBER,
    NAME VARCHAR2(10),
    UNIQUE (ID, NAME)
);

INSERT INTO TEST_COMPLEX VALUES (100, 'ORACLE');
INSERT INTO TEST_COMPLEX VALUES (NULL, NULL);
INSERT INTO TEST_COMPLEX VALUES (100, 'JAVA'); 
--복합키로 설정한 경우 (ID,NAME)을 한 묶음으로 판단하기 때문에 하나만 중복되어도 INSERT 함
INSERT INTO TEST_COMPLEX VALUES (NULL, NULL);
--다 NULL은 UNIQUE 제약조건에서 예외이기 때문에 계속 INSERT 가능
INSERT INTO TEST_COMPLEX VALUES (NULL, 'JAVA');
INSERT INTO TEST_COMPLEX VALUES (NULL, 'JAVA'); --ERROR
--하나만 NULL일 경우는 중복 확인함.
INSERT INTO TEST_COMPLEX VALUES (100, 'JAVA'); --ERROR

SELECT * FROM TEST_COMPLEX;

--복합키를 참조키로 설정할 경우
CREATE TABLE TESTFK4 (
    ID NUMBER,
    NAME VARCHAR2(10),
    PRICE NUMBER,
    FOREIGN KEY (ID, NAME) REFERENCES TEST_COMPLEX (ID, NAME)
);

--복합키로 설정된 참조컬럼은 따로 외래키 설정을 할 수 없음 : 에러
CREATE TABLE TESTFK5 (
    ID NUMBER REFERENCES TEST_COMPLEX (ID),
    NAME VARCHAR2(10) REFERENCES TEST_COMPLEX (NAME),
    PRICE NUMBER--,
    --FOREIGN KEY (ID) REFERENCES TEST_COMPLEX (ID, NAME) --ERROR
); --ERROR

--외래키가 설정된 컬럼에 값이 사용 중이면, 부모키는 절대 삭제할 수 없음.
DELETE FROM DEPARTMENT
WHERE DEPT_ID = '90';
--EMPLOYEE 테이블에 DEPT_ID 컬럼에 '90'이 사용되고 있음 : CHILD RECORD

--FOREIGN KEY 제약조건 설정시 삭제옵션을 추가 할 수 있음 : DELETION OPTION
--기본은 자식레코드가 존재하면 부모키는 삭제 불가능임 (RESTRICTED)
--ON DELETE SET NULL, ON DELETE CASCADE

--ON DELETE SET NULL 추가
--부모키가 삭제될 때 자식 레코드 값을 NULL 로 바꿈
CREATE TABLE PRODUCT_STATE (
    PSTATE CHAR(1) PRIMARY KEY,
    PCOMMENT VARCHAR2(10)
);

INSERT INTO PRODUCT_STATE VALUES ('A', '최고급');
INSERT INTO PRODUCT_STATE VALUES ('B', '보통');
INSERT INTO PRODUCT_STATE VALUES ('C', '저급');

SELECT * FROM PRODUCT_STATE;

CREATE TABLE PRODUCT (
    PNAME VARCHAR2(20) PRIMARY KEY,
    PPRICE NUMBER CHECK (PPRICE > 0),
    PSTATE CHAR(1) REFERENCES PRODUCT_STATE ON DELETE SET NULL
);

INSERT INTO PRODUCT VALUES ('갤럭시', 653000, 'A');
INSERT INTO PRODUCT VALUES ('G7', 740000, 'B');
INSERT INTO PRODUCT VALUES ('맥북', 2500000,'C');

SELECT * FROM PRODUCT;

-- 삭제 테스트
DELETE FROM PRODUCT_STATE
WHERE PSTATE = 'A';

COMMIT;--삭제 이후 COMMIT을 해야 적용 됨.

SELECT * FROM PRODUCT; --NULL
SELECT * FROM PRODUCT_STATE; --'A'값을 가지고 있던 행이 삭제됨

--ON DELETE CASCADE
-- 제공되는 부모키가 삭제되면, 제공값을 사용하는 자식 레코드도 함께 삭제됨.
CREATE TABLE PRODUCT2(
    PNAME VARCHAR2(20) PRIMARY KEY,
    PPRICE NUMBER,
    PSTATE CHAR(1) REFERENCES PRODUCT_STATE (PSTATE) ON DELETE CASCADE
);

INSERT INTO PRODUCT2 VALUES ('맥북', 2500000, 'B');
INSERT INTO PRODUCT2 VALUES ('맥에어', 1250000, 'C');

SELECT * FROM PRODUCT2;

--부모키 테스트
DELETE FROM PRODUCT_STATE
WHERE PSTATE = 'B';

COMMIT;

SELECT * FROM PRODUCT_STATE; --'B'값을 가지고 있던 행이 삭제됨.
SELECT * FROM PRODUCT2; --부모 'B'를 지우면 자식의 'B'를 가지고 있던 행이 삭제 됨(CASCADE)

CREATE TABLE TABLE_SUBQUERY1
AS SELECT EMP_ID, EMP_NAME, SALARY, DEPT_NAME, JOB_TITLE
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT USING (DEPT_ID)
    LEFT JOIN JOB USING (JOB_ID);
    
SELECT * FROM TABLE_SUBQUERY1;

--DESCRIBE 테이블명;
--DESC 테이블명;
--테이블의 구조를 확인하는 명령어
DESC TABLE_SUBQUERY1;

--직원 테이블에서 90번 부서에 소속된 직원 정보만 따로 EMP_COPY90 테이블에 저장
CREATE TABLE EMP_COPY90
AS 
SELECT *
FROM EMPLOYEE
WHERE DEPT_ID = '90';

SELECT * FROM EMP_COPY90;

DESC EMP_COPY90;

-- 복사본 테이블 만들기
CREATE TABLE EMP_COPY
AS SELECT * FROM EMPLOYEE;

SELECT * FROM EMP_COPY;

DESC EMP_COPY;
--서브쿼리를 이용해서 기존 테이블을 복사할 경우,
--컬럼명, 자료형, NOT NULL 제약조건, 값은 그대로 복사됨.
--나머지 제약조건들은 복사되지 않음.

--제약조건 관련 데이터딕셔너리 확인
--USER_CONSTRAINTS
SELECT * FROM USER_CONSTRAINTS;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'EMP_COPY';


--실습 1
--사번, 이름, 급여, 직급명, 부서명, 근무지역명, 소속국가명 조회
--조회 결과를 EMP_LIST 테이블에 저장함

CREATE TABLE EMP_LIST
AS
SELECT EMP_ID, EMP_NAME, SALARY 급여, JOB_TITLE, DEPT_NAME, LOC_DESCRIBE, COUNTRY_NAME
FROM EMPLOYEE
LEFT JOIN JOB USING(JOB_ID)
LEFT JOIN DEPARTMENT USING (DEPT_ID)
LEFT JOIN LOCATION ON (LOC_ID = LOCATION_ID)
LEFT JOIN COUNTRY USING(COUNTRY_ID);

SELECT * FROM EMP_LIST;

DESC EMP_LIST;

--실습 2
--EMPLOYEE 테이블에서 남자 직원의 정보만 조회해서
--EMP_MAN 테이블에 저장함.
CREATE TABLE EMP_MAN
AS
SELECT *
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1)IN ('1','3');

SELECT * FROM EMP_MAN;

DESC EMP_MAN;

--실습 3
--여자직원의 정보만 조회해서, EMP_FEMAIL 테이블에 저장함
CREATE TABLE EMP_FEMAIL
AS
SELECT * FROM EMPLOYEE WHERE SUBSTR(EMP_NO,8,1) IN('2','4');

SELECT * FROM EMP_FEMAIL;

DESC EMP_FEMAIL;

--실습 4
--부서별 직원 명단을 정리해서 PART_LIST 테이블에 저장함
--DEPT_NAME, JOB_TITLE, EMP_NAME, EMP_ID 로 컬럼 구성함.

CREATE TABLE PART_LIST
AS
SELECT DEPT_NAME, JOB_TITLE, EMP_NAME, EMP_ID
FROM DEPARTMENT
LEFT JOIN EMPLOYEE USING (DEPT_ID)
LEFT JOIN JOB USING (JOB_ID)
ORDER BY DEPT_NAME;

SELECT * FROM PART_LIST;

COMMENT ON COLUMN PART_LIST.DEPT_NAME IS '부서명';
COMMENT ON COLUMN PART_LIST.JOB_TITLE IS '직급명';
COMMENT ON COLUMN PART_LIST.EMP_NAME IS '사원명';
COMMENT ON COLUMN PART_LIST.DEPT_ID IS '사번';

DESC PART_LIST;

-- 실습 : 제약조건이 설정된 테이블 만들기
-- 테이블명 : PHONEBOOK
-- 컬럼명 :  ID  CHAR(3) 기본키(저장이름 : PK_PBID)
--         PNAME      VARCHAR2(20)  널 사용못함.
--                                 (NN_PBNAME) 
--         PHONE      VARCHAR2(15)  널 사용못함
--                                 (NN_PBPHONE)
--                                 중복값 입력못함
--                                 (UN_PBPHONE)
--         ADDRESS    VARCHAR2(100) 기본값 지정함
--                                 '서울시 구로구'
-- NOT NULL을 제외하고, 모두 테이블 레벨에서 지정함.
CREATE TABLE PHONEBOOK(
    ID CHAR(3),-- CONSTRAINT RAPK_PBID PRIMARY KEY,
    PNAME VARCHAR2(20) CONSTRAINT NN_PBNAME NOT NULL,
    PHONE VARCHAR2(15) CONSTRAINT NN_PBPHONE NOT NULL,
    ADDRESS VARCHAR2(100) DEFAULT '서울시 구로구',
    CONSTRAINT RAPK_PBID PRIMARY KEY (ID),
    CONSTRAINT UN_PBPHONE UNIQUE (PHONE)
);

INSERT INTO PHONEBOOK VALUES('A01','홍길동','010-1234-5678',DEFAULT);
SELECT * FROM PHONEBOOK;

DESC PHONEBOOK;


--DAY11
-- 데이터 딕셔너리 (데이터 사전)
-- 사용자가 생성한 모든 객체정보는 테이블 단위로 저장되고 있음
-- 예를 들면, 사용자가 설정한 제약조건도 저장되고 있음.
-- USER_CONSTRAINTS
DESC USER_CONSTRAINTS;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'PHONEBOOK';

--CONSTRAINT TYPE
--P : PRIMARY KEY
--U : UNIQUE
--C : CHECK, NOT NULL
--R : FOREIGN KEY

-- 서브쿼리를 사용해서 테이블을 만들 때, 데이터는 복사하지 않고
-- 테이블 구조만 복사하고자 할 때
-- 서브쿼리의 WHERE 절에 WHERE 1 = 0 하면 됨

CREATE TABLE DEPT_COPY
AS
SELECT * FROM DEPARTMENT
WHERE 1 = 0;

SELECT * FROM DEPT_COPY;

DESC DEPT_COPY;

-- 서브쿼리로 새 테이블을 만들 때, 서브쿼리의 컬럼명을 사용하지 않고
-- 새 테이블에서 컬럼명을 다르게 구성할 수도 있다.

CREATE TABLE JOB_COPY (직급코드, 직급명, 최저급여, 최고급여) 
--JOB_COPY의 컬럼명을 다르게 구성할 수 있음.
--단, 서브쿼리가 SELECT한 컬럼 모두 변경해줘야 함.
AS
SELECT * FROM JOB;

DESC JOB_COPY;

SELECT * FROM JOB_COPY;

-- 두번째 방법
CREATE TABLE DCOPY
AS
SELECT DEPT_ID AS DID, DEPT_NAME AS DNAME, LOC_ID LID
FROM DEPARTMENT;

DESC DCOPY;

SELECT * FROM DCOPY;

--서브쿼리로 테이블을 만들 때, 컬럼명을 바꾸면서 제약조건도 추가할 수 있음
--외래키 설정(FOREIGN KEY) 제약조건은 추가할 수 없음

CREATE TABLE TSUB3 (
    EID PRIMARY KEY, 
    ENAME, 
    SALARY CHECK (SALARY > 2000000),--에러 : 급여에 2백만보다 작은 값이 존재함 
    DID, --REFERENCES DEPARTMENT, --FOREIGN KEY 제약조건을 사용할 수 없음 
    JTITLE --NOT NULL) -- 에러 : 서브쿼리 결과에 NULL 이 존재함
    )
AS
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_ID, JOB_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT USING (DEPT_ID)
LEFT JOIN JOB USING (JOB_ID);

--해결
CREATE TABLE TSUB3 (
    EID PRIMARY KEY, 
    ENAME, 
    SALARY CHECK (SALARY > 2000000),
    DID,
    JTITLE NOT NULL
    )
AS
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_ID, NVL(JOB_TITLE, '미정')
FROM EMPLOYEE
LEFT JOIN DEPARTMENT USING (DEPT_ID)
LEFT JOIN JOB USING (JOB_ID)
WHERE SALARY > 2000000;

SELECT * FROM TSUB3;
