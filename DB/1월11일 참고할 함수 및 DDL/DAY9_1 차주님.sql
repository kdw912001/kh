-- DAY9_1

-- DDL (Data Definition Language) : ������ ���Ǿ�
-- CREATE, ALTER, DROP 
-- �����ͺ��̽� ��ü ����� �����ϰ� �����ϴ� ����
-- ���̺�(TABLE), ��(VIEW), �ε���(INDEX), ������(SEQUENCE),
-- �����(USER), ��(ROLE), ���ν���(PROCEDURE), �Լ�(FUNCTION),
-- Ʈ����(TRIGGER), ���Ǿ�(SYNONYM) 

-- ���̺� �����
/*
CREATE TABLE ���̺�� (
    �÷���  �ڷ���(������)  DEFAULT �⺻��  ��������,
    �÷���  �ڷ���(������),
    ....,
    �÷��� ������ ��������
);
*/

DROP TABLE TEST;

CREATE TABLE TEST2 (
    ID  NUMBER(5),
    NAME CHAR(10),
    ADDRESS VARCHAR2(50)
);

-- ���̺� ���� Ȯ�� : DESC / DESCRIBE ���̺��;
DESC TEST2;

SELECT * FROM TEST2;

INSERT INTO TEST2 (ID, NAME, ADDRESS)
VALUES (12345, 'ȫ�浿', '����� ������ ���ﵿ 77');

SELECT * FROM TEST2;

INSERT INTO TEST2
VALUES (11111, '�̼���', '�泲 �뿵�� 5959');

SELECT * FROM TEST2;

INSERT INTO TEST2 (ID, NAME)
VALUES (33333, '������');

SELECT * FROM TEST2;

INSERT INTO TEST2
VALUES (1212, '������', NULL);

SELECT * FROM TEST2;


-- ******************
CREATE TABLE ORDERS (
    ORDERNO  CHAR(4),
    CUSTNO   CHAR(4),
    ORDERDATE DATE DEFAULT SYSDATE,
    SHIPDATE  DATE,
    SHIPADDRESS  VARCHAR2(40),
    QUANTITY  NUMBER
);

COMMENT ON COLUMN ORDERS.ORDERNO IS '�ֹ���ȣ';
COMMENT ON COLUMN ORDERS.CUSTNO IS '����ȣ';
COMMENT ON COLUMN ORDERS.ORDERDATE IS '�ֹ�����';
COMMENT ON COLUMN ORDERS.SHIPDATE IS '�������';
COMMENT ON COLUMN ORDERS.SHIPADDRESS IS '����ּ�';
COMMENT ON COLUMN ORDERS.QUANTITY IS '�ֹ�����';
    
/*
  �������� ������ ������ ���̺� : NOTICE
  �÷� : 
  �۹�ȣ(����), ������(�������� 30����Ʈ), �ۼ��ھ��̵�(�������� 15����Ʈ), 
  �ۼ���¥(��¥), �ۼ�����(�������� 2000����Ʈ), ÷�����ϰ�θ�(�������� 50����Ʈ)
  �÷��� : 
  NOTICE_NO, NOTICE_TITLE, NOTICE_WRITER, NOTICE_DATE, 
  NOTICE_CONTENT, FILE_PATH
  �ۼ���¥�� �⺻���� SYSDATE
*/

CREATE TABLE NOTICE(
  NOTICE_NO   NUMBER,
  NOTICE_TITLE   VARCHAR2(30),
  NOTICE_WRITER   VARCHAR2(15),
  NOTICE_DATE   DATE DEFAULT SYSDATE,
  NOTICE_CONTENT   VARCHAR2(2000),
  FILE_PATH   VARCHAR2(50)
);

-- ù��° �� �߰� : 
--1, 'ù��° ������', 'user01', '�ȳ��ϼ���. ���������� �˷��帳�ϴ�.'
INSERT INTO NOTICE
VALUES (1, 'ù��° ������', 'user01', DEFAULT, 
        '�ȳ��ϼ���. ���������� �˷��帳�ϴ�.', NULL);

--  �ι�° �� �߰� : 
-- �۹�ȣ�� ���� ū �� + 1, '�ι�° ������', 'user02', '�˸��ϴ�. �ι�°'
INSERT INTO NOTICE
VALUES ((SELECT MAX(NOTICE_NO) FROM NOTICE) + 1, 
        '�ι�° ������', 'user02', DEFAULT, '�˸��ϴ�. �ι�° �������Դϴ�.',
        NULL);

SELECT * FROM NOTICE;

-- DML (Data Manipulation Language) : ������ ���۾�
-- INSERT, UPDATE, DELETE, TRUNCATE
-- ���̺� �����͸� �߰� ����ϰų�, ��ϵ� ���� �����ϰų�
-- ���� �����ϴ� ����

/*

*/


CREATE TABLE DEPT ( 
    DEPT_ID CHAR(2) ,
    DEPT_NAME VARCHAR2(30) 
);

SELECT COUNT(*) FROM DEPT;  -- 0

INSERT INTO DEPT VALUES ('20', 'ȸ����');

SELECT COUNT(*) FROM DEPT;  -- 1

INSERT INTO DEPT VALUES ('10', '�λ���');

SELECT COUNT(*) FROM DEPT; -- 2

SELECT * FROM DEPT;










