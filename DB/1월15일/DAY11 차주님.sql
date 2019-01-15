-- DAY11

-- ������ ��ųʸ�
-- ����ڰ� ������ ���̺� ��ü ���� : USER_TABLES
SELECT * FROM USER_TABLES;

-- ����ڰ� ���� �������� ���� : USER_CONSTRAINTS
SELECT * FROM USER_CONSTRAINTS;

-- ����ڰ� ���� ������ ���� : USER_SEQUENCES
SELECT * FROM USER_SEQUENCES;

-- ����ڰ� ���� �ε��� ���� : USER_INDEXES
SELECT * FROM USER_INDEXES;

-- ����ڰ� ���� �� ���� : USER_VIEWS
SELECT * FROM USER_VIEWS;

-- ����ڰ� ���� ���̺�, ��, ������ ���� : USER_CATALOG
SELECT * FROM USER_CATALOG;

-- ���� ����ڰ� ������ �� ��� ���̺� ���� : ALL_TABLES
SELECT * FROM ALL_TABLES;

-- DBA(�����ͺ��̽� ������)�� ������ �� �ִ� ���̺� ��ȸ : DBA_TABLES
SELECT * FROM DBA_TABLES;  -- SYSTEM �������� �α׿��ؼ� ��ȸ ������

-- ����ڰ� ���� ��� ��ü ���� : USER_OBJECTS
SELECT * FROM USER_OBJECTS;

-- *******************************************
-- DDL
-- CREATE, ALTER, DROP
-- ���̺� : CREATE TABLE, ALTER TABLE, DROP TABLE
-- �� : CREATE VIEW, DROP VIEW
-- ������ : CREATE SEQUENCE, ALTER SEQUENCE, DROP SEQUENCE


-- ���̺� ����
-- �÷� �߰�/����, �������� �߰�/����
-- �÷� �ڷ��� ����, DEFAULT �� ����
-- ���̺��, �÷���, ���������̸� ����

-- �÷� �߰�
-- ���̺� �ۼ��� �÷� ������ �����ϰ� �ۼ��ϸ� ��
ALTER TABLE DCOPY
ADD (LNAME  VARCHAR2(40));

DESC DCOPY;

SELECT * FROM DCOPY;

ALTER TABLE DCOPY
ADD (CNAME  VARCHAR2(30) DEFAULT '�ѱ�');

DESC DCOPY;

SELECT * FROM DCOPY;

-- �������� �߰�
CREATE TABLE EMP2
AS
SELECT * FROM EMPLOYEE;

ALTER TABLE EMP2
ADD PRIMARY KEY (EMP_ID);

ALTER TABLE EMP2
ADD CONSTRAINT E2_UNENO UNIQUE (EMP_NO);

-- NOT NULL ���������� ADD �� �߰��� �� ����
-- �÷��� ���� NULL �� ����� �� �ִ� ���¿��� NULL �� ��� �� �ϰ� �ٲٴ� ����
-- �߰��� �ƴ϶� ������. MODIFY ����ؾ� ��
ALTER TABLE EMP2
ADD NOT NULL (HIRE_DATE);  -- ERROR

ALTER TABLE EMP2
MODIFY (HIRE_DATE NOT NULL);

-- �÷� �ڷ��� ����
CREATE TABLE EMP4
AS
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE;

SELECT * FROM EMP4;

DESC EMP4;

ALTER TABLE EMP4
MODIFY (EMP_ID VARCHAR2(5),
         EMP_NAME CHAR(20));

-- ���� ��ϵ� �÷��� �ٸ� �ڷ������� �ٲ� �� ����
ALTER TABLE EMP4
MODIFY (HIRE_DATE  CHAR(8));  -- ERROR

-- ���ڿ� �ڷ��� ����ÿ� ũ�⸦ ���̸� �� ��
ALTER TABLE EMP4 
MODIFY (EMP_NAME CHAR(15));  -- ERROR

-- DEFAULT �� ����
CREATE TABLE EMP5 (
    EMP_ID  CHAR(3),
    EMP_NAME VARCHAR2(20),
    ADDR1  VARCHAR2(20)  DEFAULT '����',
    ADDR2  VARCHAR2(100)
);

INSERT INTO EMP5
VALUES ('A10', '������', DEFAULT, 'û�㵿');

INSERT INTO EMP5
VALUES ('B10', '�̺���', DEFAULT, '���絿');

SELECT * FROM EMP5;


ALTER TABLE EMP5
MODIFY (ADDR1  DEFAULT '���');

-- DEFAULT ���� ���� ���� �����
INSERT INTO EMP5
VALUES ('C10', '�ӽ¿�', DEFAULT, '�д� ȿ�ڵ�');

SELECT * FROM EMP5;


-- �÷� ����
ALTER TABLE DCOPY
DROP COLUMN CNAME;

DESC DCOPY;

SELECT * FROM DCOPY;

ALTER TABLE DCOPY
DROP (LNAME);


-- ���� ���� �÷� ������
ALTER TABLE DCOPY
DROP (DNAME, LID);

SELECT * FROM DCOPY;

-- ���̺��� �ּ� �� ���� �÷��� ������ ��
-- ������ �÷��� ���� �� ��
ALTER TABLE DCOPY
DROP COLUMN DID;  -- ERROR

-- ���������� ���� �÷��� �⺻ ���� �� ��
ALTER TABLE DEPARTMENT
DROP (DEPT_ID);  -- ERROR

CREATE TABLE TB1 (
    PK  NUMBER  PRIMARY KEY,
    FK  NUMBER  REFERENCES TB1,
    COL1  NUMBER,
    CHECK (PK > 0 AND COL1 > 0)
);

ALTER TABLE TB1
DROP (PK);  -- ERROR

-- �������ǵ� �Բ� ����(CASCADE)�ϸ� ������
ALTER TABLE TB1
DROP (PK)  CASCADE CONSTRAINTS;

DESC TB1;

ALTER TABLE TB1
DROP (COL1) CASCADE CONSTRAINTS;

CREATE TABLE CONST_EMP (
  ENAME VARCHAR2(20) CONSTRAINT NENAME NOT NULL,
  ENO   VARCHAR2(14)  CONSTRAINT NENO NOT NULL,
  MARRIAGE CHAR(1) DEFAULT 'N',
  EID CHAR(3),
  EMAIL VARCHAR2(30),
  JID CHAR(2),
  MID CHAR(3),
  DID CHAR(2),
  CONSTRAINT CHK CHECK (MARRIAGE IN ('N', 'Y')),
  CONSTRAINT PKEID PRIMARY KEY (EID),
  CONSTRAINT UENO UNIQUE (ENO),
  CONSTRAINT UEMAIL UNIQUE (EMAIL),
  CONSTRAINT FKJID FOREIGN KEY (JID) REFERENCES JOB (JOB_ID) ON DELETE SET NULL,
  CONSTRAINT FKMID FOREIGN KEY (MID) REFERENCES CONST_EMP ON DELETE SET NULL,
  CONSTRAINT FKDID FOREIGN KEY (DID) REFERENCES DEPARTMENT ON DELETE CASCADE
);

-- �������� ����
-- 1�� ������ ��
ALTER TABLE CONST_EMP
DROP CONSTRAINT CHK;

-- ���� �� ������ ��
ALTER TABLE CONST_EMP
DROP CONSTRAINT FKJID
DROP CONSTRAINT FKMID
DROP CONSTRAINT FKDID;

-- ������ ��ųʸ��� ���� ���� Ȯ��
SELECT TABLE_NAME, CONSTRAINT_NAME
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'CONST_EMP';

-- NOT NULL ���������� ������ �ƴ϶� NULL �� ������
-- DROP �� �ƴ϶� MODIFY �����
ALTER TABLE CONST_EMP
MODIFY (ENAME NULL, ENO NULL);

-- ���̺��� �÷��� �����ϴ� ������ ��ųʸ� : USER_TAB_COLS
SELECT * FROM USER_TAB_COLS;

DESC USER_TAB_COLS;

SELECT TABLE_NAME, COLUMN_NAME, NULLABLE
FROM USER_TAB_COLS
WHERE TABLE_NAME = 'CONST_EMP';

-- ���̺��� �÷��� ���������� �����ϴ� ��ųʸ� : USER_CONS_COLUMNS
CREATE TABLE TB_EXAM (
    COL1  CHAR(3)  PRIMARY KEY,
    ENAME  VARCHAR2(20),
    FOREIGN KEY (COL1) REFERENCES EMPLOYEE
);

SELECT CONSTRAINT_NAME AS �̸�,
        CONSTRAINT_TYPE AS ����,
        COLUMN_NAME AS �÷�,
        R_CONSTRAINT_NAME AS ����,
        DELETE_RULE AS ������Ģ
FROM USER_CONSTRAINTS
JOIN USER_CONS_COLUMNS USING (CONSTRAINT_NAME, TABLE_NAME)
WHERE TABLE_NAME = 'TB_EXAM';

-- �̸� �ٲٱ�
-- �÷���, ���������̸�, ���̺��

-- �÷��� �ٲٱ�
ALTER TABLE TB_EXAM
RENAME COLUMN COL1 TO EMPID;

DESC TB_EXAM;

-- �������� �̸� �ٲٱ�
ALTER TABLE TB_EXAM
RENAME CONSTRAINTS SYS_C007168 TO PK_EID;

ALTER TABLE TB_EXAM
RENAME CONSTRAINTS SYS_C007169 TO FK_EID;

-- ���̺� �ٲٱ�
ALTER TABLE TB_EXAM RENAME TO TB_SMAPLE1;
-- �Ǵ�
RENAME TB_SMAPLE1 TO TB_SAMPLE;

-- ���̺� �����ϱ�
-- DROP TABLE ���̺��;
-- FOREIGN KEY �������ǿ� ���� �����ǰ� �ִ� ���̺��� ���� �Ұ�����.
CREATE TABLE DEPT2 (
    DID  CHAR(2)  PRIMARY KEY,
    DNAME  VARCHAR2(10)
);

CREATE TABLE EMP6 (
    EID  CHAR(3)  PRIMARY KEY,
    ENAME  VARCHAR2(10),
    DID  CHAR(2) REFERENCES DEPT2
);

-- ���� ���̺��� ���� �� ��
DROP TABLE DEPT2;  -- ERROR
-- �����Ϸ��� DEPT2�� ���� REFERENCES ���������� �Բ� �����ϸ� ������
DROP TABLE DEPT2 CASCADE CONSTRAINTS;

-- ������ ��ųʸ��� ���� ���� Ȯ��
SELECT TABLE_NAME
FROM USER_TABLES
WHERE TABLE_NAME LIKE 'D%';


-- ****************************************************
-- DML (Data Manipulation Language : ������ ���۾�)
-- INSERT ��, UPDATE ��, DELETE ��
-- ���̺� �����͸� �߰��ϰų�, ��ϵ� �����͸� �����ϰų�, 
-- ��ϵ� ���� �����ϴ� ������.
-- INSERT �� : ���ο� ���� �߰��� (�� ���� ������)
-- UPDATE �� : �����͸� ������ (�� ���� ��ȭ����)
-- DELETE �� : �ش� �����͸� ������ ���� ������ (�� ������ �پ��)
-- TRUNCATE �� : ���̺��� ��� ���� ������

-- UPDATE ��
/*
UPDATE ���̺��
SET �÷��� = ������ ��, �÷��� = ������ ��, .....
WHERE �÷��� �񱳿����� �񱳰�;
*/

SELECT * FROM DCOPY;
DROP TABLE DCOPY;

CREATE TABLE DCOPY
AS
SELECT * FROM DEPARTMENT;

SELECT * FROM DCOPY;

UPDATE DCOPY
SET DEPT_NAME = '�λ���';
-- WHERE ���� �����Ǹ� �÷� ��ü�� ���� �����

ROLLBACK;  -- ��� ������ DML ���� ���� ��ҵ�.

UPDATE DCOPY
SET DEPT_NAME = '�λ���'
WHERE DEPT_ID = '10';

SELECT * FROM DCOPY;

-- UPDATE ���� �������� ����� �� ����
-- SET ���� WHERE ������ ����� �� ����
-- SET �÷��� = (��������) 
-- WHERE �÷��� �񱳿����� (��������)

-- ���ϱ��� �����ڵ�� �޿��� ���ر� ������ ���� ������ �����Ͻÿ�.
UPDATE EMPLOYEE
SET JOB_ID = (SELECT JOB_ID FROM EMPLOYEE
               WHERE EMP_NAME = '���ر�'),
    SALARY = (SELECT SALARY FROM EMPLOYEE
               WHERE EMP_NAME = '���ر�')
WHERE EMP_NAME = '���ϱ�';

-- ���߿� ������ ���������� �����ϸ�
UPDATE EMPLOYEE
SET (JOB_ID, SALARY) = (SELECT JOB_ID, SALARY
                        FROM EMPLOYEE
                        WHERE EMP_NAME = '���ر�')
WHERE EMP_NAME = '���ϱ�';

-- Ȯ��
SELECT EMP_NAME, JOB_ID, SALARY
FROM EMPLOYEE
WHERE EMP_NAME IN ('���ϱ�', '���ر�');

-- ���
ROLLBACK;

-- DEFAULT �� ������ �÷����� ������ ��, 
-- ������ �� ��ſ� DEFAULT Ű���� ����ص� ��
SELECT EMP_ID, EMP_NAME, MARRIAGE
FROM EMPLOYEE
WHERE EMP_ID = '210';

UPDATE EMPLOYEE
SET MARRIAGE = DEFAULT
WHERE EMP_ID = '210';

ROLLBACK;

-- WHERE �������� �������� ����� �� ����

-- �ؿܿ���2�� �������� ���ʽ�����Ʈ�� 0.3���� �����Ͻÿ�.
UPDATE EMPLOYEE
SET BONUS_PCT = 0.3
WHERE DEPT_ID = (SELECT DEPT_ID FROM DEPARTMENT
                   WHERE DEPT_NAME = '�ؿܿ���2��');

-- Ȯ��
SELECT EMP_NAME, DEPT_ID, BONUS_PCT
FROM EMPLOYEE
WHERE DEPT_ID = (SELECT DEPT_ID FROM DEPARTMENT
                    WHERE DEPT_NAME = '�ؿܿ���2��');

ROLLBACK;


-- ********************
-- INSERT ��
-- ���̺� �� ���� �߰��ϴ� ������
-- ���ο� ������ ��� ����� ���
/*
INSERT INTO ���̺�� [(�÷���, �÷���, ....)]
VALUES (����� ��, ����� ��, ....);
*/

CREATE TABLE DEPT3 (
    DEPTID  CHAR(2),
    DEPTNAME  VARCHAR2(20)
);

SELECT COUNT(*) FROM DEPT3;  -- 0��

INSERT INTO DEPT3
VALUES ('10', 'ȸ����');

SELECT COUNT(*) FROM DEPT3;  -- 1��

INSERT INTO DEPT3
VALUES ('20', '�λ���');

SELECT COUNT(*) FROM DEPT3; -- 2��

SELECT * FROM DEPT3;

COMMIT;  -- ���� �Ϸ���

INSERT INTO EMPLOYEE (EMP_ID, EMP_NO, EMP_NAME, EMAIL, PHONE,
                        HIRE_DATE, JOB_ID, SALARY, BONUS_PCT, 
                        MARRIAGE, MGR_ID, DEPT_ID)
VALUES ('900', '811122-1458712', '������', 'oyuha@kh.org', '01012345678',
         DEFAULT, 'J7', 3000000, NULL, DEFAULT, '176', '90');

SELECT * FROM EMPLOYEE;

ROLLBACK;

-- �÷��� �����Ǹ�, ���̺��� ��ü �࿡ �� ����ؾ� ��
-- �÷� ������ �� ���� ���ƾ� ��.
-- �÷� ���� ������ �� ��� ������ ���ƾ� ��
INSERT INTO EMPLOYEE
VALUES ('777', '�̺���', '811122-1475214', 'leebh@kh.org',
        '01012345678', SYSDATE, 'J6', 3500000, NULL, 
        DEFAULT, NULL, NULL);

-- ���������� �̿��ؼ� INSERT �� �� �ִ�.
-- VALUES ������� �ʴ´�.

CREATE TABLE EMP (
    EMP_ID CHAR(3),
    EMP_NAME VARCHAR2(20),
    DEPT_NAME VARCHAR2(20)
);

INSERT INTO EMP
(SELECT EMP_ID, EMP_NAME, DEPT_NAME
 FROM EMPLOYEE
 LEFT JOIN DEPARTMENT USING (DEPT_ID));

SELECT * FROM EMP;












