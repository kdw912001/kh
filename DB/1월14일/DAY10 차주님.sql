-- DAY10

-- DDL 
-- ���̺� ���Ἲ �������� (CONSTRAINT)

-- 1. NOT NULL
-- �÷��� ���� �ݵ�� ��ϵǾ�� �� �� ������ (�������� �ʼ��Է��׸��� ����)
-- �÷� ���������� ������ �� ����.

CREATE TABLE TESTNN (
    NNID  NUMBER(5)  NOT NULL,  -- �÷� ����
    NN_NAME VARCHAR2(20)
);

-- �� ��� �׽�Ʈ
INSERT INTO TESTNN (NNID, NN_NAME)
VALUES (NULL, NULL);  -- ERROR
-- NNID �� NOT NULL �������� �����.

INSERT INTO TESTNN -- �÷����� �����Ǹ�, ���̺��� ��� �÷��� �� ����ؾ� ��
VALUES (1, NULL);  -- ���̺��� �÷� ���� ������ �ڷ��� ���缭 �� ��� ������

SELECT * FROM TESTNN;

INSERT INTO TESTNN (NN_NAME)
VALUES ('ORACLE');  -- ������ �÷��� �ڵ� NULL ó���� >> ����

-- ���̺� ���� ���� 
CREATE TABLE TESTNN2 (
    NN_ID NUMBER(5) CONSTRAINT T2_NNID NOT NULL,
    NN_NAME VARCHAR2(10)--,
    -- ���̺� ����
    -- [CONSTRAINT ���������̸�] ������������ (������ �÷���)
   -- CONSTRAINT T2_NNNAME NOT NULL (NN_NAME)  >> ERROR
);


-- 2. UNIQUE
-- �ش� �÷��� �ߺ���(������) �Է��� ���ڴٴ� �ǹ��� ����������
-- �����ϸ� ���� ���� �ι� ��� �� �ϴ� �÷��� ��
-- �÷�����, ���̺��� �� �� ������ �� ����
-- ����Ű�ε� ������ �� ����.

CREATE TABLE TESTUN (
    UN_ID  CHAR(3)  UNIQUE,
    UN_NAME VARCHAR2(10) NOT NULL
);

-- ��� �׽�Ʈ
INSERT INTO TESTUN VALUES ('AAA', 'ORACLE');
INSERT INTO TESTUN VALUES ('AAA', 'JAVA');  -- �������� ����� >> ����
INSERT INTO TESTUN VALUES ('AAB', 'JAVA');

SELECT * FROM TESTUN;

CREATE TABLE TESTUN2 (
    UN_ID  CHAR(3)  CONSTRAINT T2_UNID UNIQUE,
    UN_NAME VARCHAR2(10) CONSTRAINT T2_UNNAME NOT NULL
);

CREATE TABLE TESTUN3 (
    UN_ID  CHAR(3),
    UN_NAME VARCHAR2(10) NOT NULL,
    CONSTRAINT T3_UNID UNIQUE (UN_ID)
);

-- 3. PRIMARY KEY
-- ���̺��� �� ���� ������ ã������ �� �� �ִ� ���� ��ϵ� �÷��� ������.
-- NOT NULL + UNIQUE
-- �� ���̺� �� ���� ����� �� ����.

CREATE TABLE TESTPK (
    PK_ID  NUMBER  PRIMARY KEY,
    PK_NAME VARCHAR2(15)  NOT NULL,
    PK_DATE  DATE
);

-- ��� �׽�Ʈ
INSERT INTO TESTPK VALUES (1, 'ȫ�浿', '15/03/12');
INSERT INTO TESTPK VALUES (NULL, '�ڹ���', SYSDATE);  -- ���� : NOT NULL �������� ����
INSERT INTO TESTPK VALUES (1, '�ڹ���', SYSDATE);  -- ���� : UNIQUE �������� �����
INSERT INTO TESTPK VALUES (2, '�ڹ���', SYSDATE);

SELECT * FROM TESTPK;

-- ���̺�� �� ���� ������ �� ����
CREATE TABLE TESTPK2 (
    PID  NUMBER  PRIMARY KEY,
    PNAME VARCHAR2(15)  PRIMARY KEY  
);  -- ERROR

-- �÷��������� ����
CREATE TABLE TESTPK2 (
    PID NUMBER  CONSTRAINT P2_PID PRIMARY KEY,
    PNAME VARCHAR2(15),
    PDATE  DATE
);

-- ���̺������� ����
CREATE TABLE TESTPK3 (
    PID NUMBER,
    PNAME VARCHAR2(15),
    PDATE  DATE,
    CONSTRAINT T3_PID PRIMARY KEY (PID)
);

-- 4. CHECK
-- �÷��� ��ϵǴ� ���� ���� ���� ������ �ϴ� ����������.
-- CHECK (�÷��� ������ �񱳰�)
-- �񱳰��� �������̾�� ��. �ٲ�� ���̸� ������.

CREATE TABLE TESTCHK (
    C_NAME VARCHAR2(15)  CONSTRAINT TCK_NAME NOT NULL,
    C_PRICE NUMBER(5) CHECK (C_PRICE BETWEEN 1 AND 99999),
    C_LEVEL CHAR(1) CHECK (C_LEVEL IN ('A', 'B', 'C'))
);

INSERT INTO TESTCHK VALUES ('������ S9', 65000, 'A');
INSERT INTO TESTCHK VALUES ('LG G7', 125000, 'A');  -- ERROR : CHECK �������� �����
INSERT INTO TESTCHK VALUES ('LG G7', 0, 'A');  -- ERROR : CHECK �������� �����
INSERT INTO TESTCHK VALUES ('LG G7', 65300, 'D');  -- ERROR : CHECK �������� �����

SELECT * FROM TESTCHK;

CREATE TABLE TESTCHK2 (
    C_NAME  VARCHAR2(15)  PRIMARY KEY,
    C_PRICE  NUMBER(5)  CHECK (C_PRICE >= 1 AND C_PRICE <= 99999),
    C_LEVEL  CHAR(1)  CHECK (C_LEVEL = 'A' OR C_LEVEL = 'B' OR C_LEVEL = 'C'),
    --C_DATE  DATE  CHECK (C_DATE < SYSDATE)
    -- �񱳰��� �ݵ�� ���ͷ�(��) ���, �ٲ�� ���� ��� �� ��
    --C_DATE  DATE  CHECK (C_DATE < TO_DATE('16/01/01', 'RR/MM/DD'))  -- OK
    C_DATE  DATE  CHECK (C_DATE < TO_DATE('16/01/01', 'YYYY/MM/DD'))  -- BUG
);


-- 5. FOREIGN KEY
-- �ܷ�Ű, �ܺ�Ű
-- �ٸ� ���̺��� �����ϴ� ���� ����� �� �ִ� �÷��� �ǹ���
-- �������� �ʴ� �� ����ϸ� ������

-- �÷��������� ����
-- [CONSTRAINT �̸�] REFERENCES �������̺�� [(������ �÷���)]
-- ���̺������� ����
-- [CONSTRAINT �̸�] FOREIGN KEY (������ �÷���) REFERENCES �������̺� [(�����÷���)]
-- NULL �� ����� �� ����

CREATE TABLE TESTFK (
    EMP_ID  CHAR(3) REFERENCES EMPLOYEE,
    -- �����÷����� �����Ǹ� PRIMARY KEY �÷��� �ڵ� �����
    DEPT_ID  CHAR(2) CONSTRAINT TFK_DID REFERENCES DEPARTMENT (DEPT_ID),
    JOB_ID  CHAR(2),
    -- ���̺���
    CONSTRAINT TFK_JID FOREIGN KEY (JOB_ID) REFERENCES JOB (JOB_ID)
);

-- ��� �׽�Ʈ
-- ����� ���̺��� ����� �÷��� ��ϵǾ� �ִ� ���� ����� �� ����.
INSERT INTO TESTFK VALUES ('300', NULL, NULL);  -- �������� �ʴ� �� ���, ����
INSERT INTO TESTFK VALUES ('100', NULL, NULL);  -- OK
INSERT INTO TESTFK VALUES ('200', '70', NULL);  -- �������� �ʴ� �μ��ڵ� ���, ����
INSERT INTO TESTFK VALUES ('200', '90', NULL);  -- OK
INSERT INTO TESTFK VALUES ('124', '80', 'J9');  -- �������� �ʴ� �����ڵ� ���, ����
INSERT INTO TESTFK VALUES ('124', '80', 'J7');  -- OK

SELECT * FROM TESTFK;

-- �ܷ�Ű �������ǿ��� PARENT KEY �� �� �� �ִ� �÷���
-- PRIMARY KEY �Ǵ� UNIQUE ���������� ������ �÷��� �����÷��� �� �� ����.
CREATE TABLE NOPK (
    ID  CHAR(3),
    NAME VARCHAR2(10)
);

CREATE TABLE TESTFK2 (
    FID CHAR(3)  REFERENCES NOPK (ID), -- ERROR
    FNAME VARCHAR2(10)
);

CREATE TABLE TESTUN5 (
    ID CHAR(3) UNIQUE,
    NAME VARCHAR2(10)
);

CREATE TABLE TESTFK2 (
    FID CHAR(3)  REFERENCES TESTUN5 (ID), 
    FNAME VARCHAR2(10)
);


-- ����Ű ���� ����
-- ���� ���� �÷��� ��� UNIQUE ���������̳� PRIMARY KEY ����������
-- ������ ����Ű�� ������ ���
CREATE TABLE TEST_COMPLEX (
    ID  NUMBER,
    NAME VARCHAR2(10),
    UNIQUE (ID, NAME)
);

INSERT INTO TEST_COMPLEX VALUES (100, 'ORACLE');
INSERT INTO TEST_COMPLEX VALUES (NULL, NULL);
INSERT INTO TEST_COMPLEX VALUES (100, 'JAVA');
INSERT INTO TEST_COMPLEX VALUES (NULL, NULL);
INSERT INTO TEST_COMPLEX VALUES (NULL, 'JAVA');
INSERT INTO TEST_COMPLEX VALUES (NULL, 'JAVA');  -- ERROR
INSERT INTO TEST_COMPLEX VALUES (100, 'JAVA');  -- ERROR

SELECT * FROM TEST_COMPLEX;

-- ����Ű�� ����Ű�� ������ ���
CREATE TABLE TESTFK4 (
    ID  NUMBER,
    NAME VARCHAR2(10),
    PRICE NUMBER,
    FOREIGN KEY (ID, NAME) REFERENCES TEST_COMPLEX (ID, NAME)
);

-- ����Ű�� ������ �����÷��� ���� �ܷ�Ű ������ �� �� ���� : ����
CREATE TABLE TESTFK5 (
    ID  NUMBER REFERENCES TEST_COMPLEX (ID),
    NAME VARCHAR2(10) REFERENCES TEST_COMPLEX (NAME),
    PRICE NUMBER--,
    --FOREIGN KEY (ID) REFERENCES TEST_COMPLEX (ID, NAME)
);  -- ERROR

-- �ܷ�Ű�� ������ �÷��� ���� ��� ���̸�, �θ�Ű�� ���� ������ �� ����.
DELETE FROM DEPARTMENT
WHERE DEPT_ID = '90';  -- ���� �� �� : ����
-- EMPLOYEE ���̺� DEPT_ID �÷��� '90'�� ���ǰ� ���� : CHILD RECORD

-- FOREIGN KEY �������� ������ �����ɼ��� �߰��� �� ���� : DELETION OPTION
-- �⺻�� �ڽķ��ڵ尡 �����ϸ� �θ�Ű�� ���� �Ұ����� (RESTRICTED)
-- ON DELETE SET NULL, ON DELETE CASCADE 

-- ON DELETE SET NULL �߰�
-- �θ�Ű�� ������ �� �ڽ� ���ڵ� ���� NULL �� �ٲ�
CREATE TABLE PRODUCT_STATE (
    PSTATE  CHAR(1)  PRIMARY KEY,
    PCOMMENT  VARCHAR2(10)
);

INSERT INTO PRODUCT_STATE VALUES ('A', '�ְ��');
INSERT INTO PRODUCT_STATE VALUES ('B', '����');
INSERT INTO PRODUCT_STATE VALUES ('C', '����');

SELECT * FROM PRODUCT_STATE;

CREATE TABLE PRODUCT (
    PNAME  VARCHAR2(20)  PRIMARY KEY,
    PPRICE  NUMBER  CHECK (PPRICE > 0),
    PSTATE  CHAR(1) REFERENCES PRODUCT_STATE ON DELETE SET NULL
);

INSERT INTO PRODUCT VALUES ('������', 653000, 'A');
INSERT INTO PRODUCT VALUES ('G7', 740000, 'B');
INSERT INTO PRODUCT VALUES ('�ƺ�', 2500000, 'C');

SELECT * FROM PRODUCT;

-- ���� �׽�Ʈ
DELETE FROM PRODUCT_STATE
WHERE PSTATE = 'A';

COMMIT;

SELECT * FROM PRODUCT;
SELECT * FROM PRODUCT_STATE;

-- ON DELETE CASCADE
-- �����Ǵ� �θ�Ű�� �����Ǹ�, �������� ����ϴ� �ڽ� ���ڵ嵵 �Բ� ������
CREATE TABLE PRODUCT2 (
    PNAME VARCHAR2(20)  PRIMARY KEY,
    PPRICE  NUMBER,
    PSTATE  CHAR(1) REFERENCES PRODUCT_STATE (PSTATE) ON DELETE CASCADE
);

INSERT INTO PRODUCT2 VALUES ('�ߺ�', 2500000, 'B');
INSERT INTO PRODUCT2 VALUES ('�ƿ���', 1250000, 'C');

SELECT * FROM PRODUCT2;

-- �θ�Ű ����
DELETE FROM PRODUCT_STATE
WHERE PSTATE = 'B';

COMMIT;

-- ���� ������ �� Ȯ��
SELECT * FROM PRODUCT_STATE;
SELECT * FROM PRODUCT2;


-- ***********************************************
-- ���������� ����ؼ� �� ���̺��� ���� �� ����

CREATE TABLE TABLE_SUBQUERY1
AS 
SELECT EMP_ID, EMP_NAME, SALARY, DEPT_NAME, JOB_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT USING (DEPT_ID)
LEFT JOIN JOB USING (JOB_ID);

SELECT * FROM TABLE_SUBQUERY1;

-- DESCRIBE ���̺��;
-- DESC ���̺��;
-- ���̺��� ������ Ȯ���ϴ� ��ɾ�
DESC TABLE_SUBQUERY1;

-- ���� ���̺��� 90�� �μ��� �Ҽӵ� ���� ������ ���� EMP_COPY90 ���̺� ����
CREATE TABLE EMP_COPY90
AS
SELECT * FROM EMPLOYEE
WHERE DEPT_ID = '90';

SELECT * FROM EMP_COPY90;

DESC EMP_COPY90;

-- ���纻 ���̺� �����
CREATE TABLE EMP_COPY
AS SELECT * FROM EMPLOYEE;

SELECT * FROM EMP_COPY;

DESC EMP_COPY;
-- ���������� �̿��ؼ� ���� ���̺��� ������ ���,
-- �÷���, �ڷ���, NOT NULL ��������, ���� �״�� �����.
-- ������ �������ǵ��� ������� ����.

-- �������� ���� �����͵�ųʸ� Ȯ��
-- USER_CONSTRAINTS
SELECT * FROM USER_CONSTRAINTS;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'EMP_COPY';

-- �ǽ� 1
-- ���, �̸�, �޿�, ���޸�, �μ���, �ٹ�������, �Ҽӱ����� ��ȸ
-- ��ȸ ����� EMP_LIST ���̺� ������
CREATE TABLE EMP_LIST
AS 
SELECT EMP_ID, EMP_NAME, SALARY, JOB_TITLE, 
        DEPT_NAME, LOC_DESCRIBE, COUNTRY_NAME
FROM EMPLOYEE
LEFT JOIN JOB USING (JOB_ID)
LEFT JOIN DEPARTMENT USING (DEPT_ID)
LEFT JOIN LOCATION ON (LOC_ID = LOCATION_ID)
LEFT JOIN COUNTRY USING (COUNTRY_ID);

SELECT * FROM EMP_LIST;

-- �ǽ� 2
-- EMPLOYEE ���̺��� ���� ������ ������ ��ȸ�ؼ�
-- EMP_MAN ���̺� ������.
CREATE TABLE EMP_MAN
AS
SELECT * FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1', '3');

SELECT * FROM EMP_MAN;

-- �ǽ� 3
-- ���� ������ ������ ��ȸ�ؼ�, EMP_FEMAIL ���̺� ������.
CREATE TABLE EMP_FEMAIL
AS
SELECT * FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('2', '4');

SELECT * FROM EMP_FEMAIL;

-- �ǽ� 4
-- �μ��� ���� ����� �����ؼ� PART_LIST ���̺� ������
-- DEPT_NAME, JOB_TITLE, EMP_NAME, EMP_ID �� �÷� ������
-- �÷��� �ּ� �ޱ� : �μ���, ���޸�, �����, ���
CREATE TABLE PART_LIST
AS
SELECT DEPT_NAME, JOB_TITLE, EMP_NAME, EMP_ID
FROM EMPLOYEE
LEFT JOIN DEPARTMENT USING (DEPT_ID)
LEFT JOIN JOB USING (JOB_ID) 
ORDER BY DEPT_NAME;

SELECT * FROM PART_LIST;

COMMENT ON COLUMN PART_LIST.DEPT_NAME IS '�μ���';
COMMENT ON COLUMN PART_LIST.JOB_TITLE IS '���޸�';
COMMENT ON COLUMN PART_LIST.EMP_NAME IS '�����';
COMMENT ON COLUMN PART_LIST.EMP_ID IS '���';


-- �ǽ� : ���������� ������ ���̺� �����
-- ���̺�� : PHONEBOOK
-- �÷��� :  ID  CHAR(3) �⺻Ű(�����̸� : PK_PBID)
--         PNAME      VARCHAR2(20)  �� ������.
--                                 (NN_PBNAME) 
--         PHONE      VARCHAR2(15)  �� ������
--                                 (NN_PBPHONE)
--                                 �ߺ��� �Է¸���
--                                 (UN_PBPHONE)
--         ADDRESS    VARCHAR2(100) �⺻�� ������
--                                 '����� ���α�'

-- NOT NULL�� �����ϰ�, ��� ���̺� �������� ������.

CREATE TABLE PHONEBOOK (
       ID    CHAR(3),
       PNAME VARCHAR2(20) CONSTRAINT NN_PBNAME NOT NULL,
       PHONE VARCHAR2(15) CONSTRAINT NN_PBPHONE NOT NULL,
       ADDRESS VARCHAR2(100) DEFAULT '����� ���α�',
       CONSTRAINT PK_PBID PRIMARY KEY (ID),
       CONSTRAINT UN_PBPHONE UNIQUE (PHONE)       
);

INSERT INTO PHONEBOOK
VALUES ('A01', 'ȫ�浿', '010-1234-5678', DEFAULT);

SELECT * FROM PHONEBOOK;



