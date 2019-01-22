-- ���ν���, �Լ�, ��Ű��, Ŀ��, Ʈ����

-- ���ν��� (PROCEDURE)
-- PLSQL ������ �����ϴ� ��ü
-- �������Ͽ� ������ �� ���� : �ݺ� ��� ��������, �Լ�(�޼ҵ�)�� ���¸� ����

-- ���ν��� ��ü ����
-- CREATE OR REPLACE PROCEDURE ���ν����̸�(�Ű����� ��� �ڷ���,...)
-- PLSQL ���� �ۼ�
-- END;/

-- ���ν��� ����
-- EXEC[UTE] ���ν����̸�(���ް�, ........);

-- ���ν��� ����
-- DROP PROCEDURE ���ν����̸�;

SELECT * FROM EMP_COPY;

-- ���ν��� ��ü ����� : �Ű������� ���� ���ν���
CREATE OR REPLACE PROCEDURE DEL_ALL
IS
BEGIN
    DELETE FROM EMP_COPY;
    COMMIT;
END;
/

-- ���ν��� ����
EXECUTE DEL_ALL;

-- Ȯ��
SELECT * FROM EMP_COPY;

-- ���ν��� ���� ������ ��ųʸ� ��ȸ
DESC USER_SOURCE;

SELECT NAME, TEXT FROM USER_SOURCE;

-- �Ű������� �ִ� ���ν��� �����
-- �̿��� ���� ���̺� �����
CREATE TABLE EMPCPY
AS
SELECT * FROM EMPLOYEE;

-- �����̸� ���� �޾Ƽ�, �ش� ������ ���� �����ϴ� ���ν���
CREATE OR REPLACE PROCEDURE 
    DEL_ENAME (VENAME IN EMPCPY.EMP_NAME%TYPE)
IS
BEGIN
    DELETE FROM EMPCPY WHERE EMP_NAME LIKE VENAME;
    COMMIT;
END;
/

-- ���ν��� ����
EXEC DEL_ENAME('��%');

-- ��� Ȯ��
SELECT * FROM EMPCPY;

-- IN ���, OUT ��� �Ű������� �ִ� ���ν��� �����
-- ����� ����� �����ϸ�, �ش� ����� �����̸�, �޿�, �����ڵ� �޾Ƽ� ��� ó��
CREATE OR REPLACE PROCEDURE SEL_EMPID(
        VEMPID IN EMPLOYEE.EMP_ID%TYPE,
        VENAME OUT EMPLOYEE.EMP_NAME%TYPE,
        VSAL OUT EMPLOYEE.SALARY%TYPE,
        VJOB OUT EMPLOYEE.JOB_ID%TYPE)
IS
BEGIN
    SELECT EMP_NAME, SALARY, JOB_ID
    INTO VENAME, VSAL, VJOB
    FROM EMPLOYEE
    WHERE EMP_ID = VEMPID;
END;
/

-- ���ν����� �������� �� ���� ���� �����ϱ� : ���ε庯��
VARIABLE VAR_ENAME VARCHAR2(20);
VARIABLE VAR_SAL NUMBER;
VARIABLE VAR_JOB CHAR(2);

EXECUTE SEL_EMPID('&���', :VAR_ENAME, :VAR_SAL, :VAR_JOB);

-- ���ε庯���� ���� �� Ȯ��
PRINT VAR_ENAME;
PRINT VAR_SAL;
PRINT VAR_JOB;

-- �ǽ�
-- DEPARTMENT ���̺� ������ DEPT_COPY ���̺� �����
-- ���࿡ �����ϸ� ���̺� �����ϰ� �ٽ� ����� ��
DROP TABLE DEPT_COPY CASCADE CONSTRAINTS;

CREATE TABLE DEPT_COPY
AS
SELECT * FROM DEPARTMENT;


-- �μ���ȣ�� ���޹޾�, �ش� �μ��� �����ϴ� ���ν��� : DEL_DEPTID
CREATE OR REPLACE PROCEDURE DEL_DEPTID (
        VDID IN DEPT_COPY.DEPT_ID%TYPE)
IS
BEGIN
    DELETE FROM DEPT_COPY
    WHERE DEPT_ID = VDID;
    COMMIT;
END;
/

-- ����, Ȯ��
EXECUTE DEL_DEPTID('&�μ���ȣ');

SELECT * FROM DEPT_COPY;

-- �ǽ� : �����̸� ���޹޾�, �ش� ���� ���� �����ϴ� ���ν��� : DEL_ENAME
-- EMP_COPY ���̺� ��� : �����ϸ� �����ϰ� ���� ����
DROP TABLE EMP_COPY CASCADE CONSTRAINTS;

CREATE TABLE EMP_COPY
AS
SELECT * FROM EMPLOYEE;

CREATE OR REPLACE PROCEDURE DEL_ENAME(
        VENAME IN EMP_COPY.EMP_NAME%TYPE)
IS
BEGIN
    DELETE FROM EMP_COPY
    WHERE EMP_NAME = VENAME;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE(VENAME || ' ������ ����Ͽ����ϴ�.');
END;
/

SET SERVEROUTPUT ON;
EXEC DEL_ENAME('&�����');

SELECT * FROM EMP_COPY;

-- ****************************************************
-- �Լ� (FUNCTION)
-- ���ν����� �ٸ� ���� RETURN �����
-- ����� ���޹޾�, �� ������ ���ʽ��� ����ؼ� �����ϴ� �Լ� : BONUS_CALC
-- ���ʽ��� �޿��� 2��� ��� ó����
CREATE OR REPLACE FUNCTION BONUS_CALC (
        VEMPID IN EMPLOYEE.EMP_ID%TYPE)
RETURN NUMBER
IS
    VSAL  EMPLOYEE.SALARY%TYPE;
    RESULT NUMBER;
BEGIN
    SELECT SALARY
    INTO VSAL
    FROM EMPLOYEE
    WHERE EMP_ID = VEMPID;
    
    RESULT := VSAL * 2;
    RETURN RESULT;
END;
/

-- ���� ���� ���ϰ� ���� ���ε� ���� ������
VARIABLE BONUS NUMBER;

EXEC :BONUS := BONUS_CALC('&���');

PRINT BONUS;

-- **************************************************
-- ��Ű�� (PACKAGE)
-- ���ν����� �Լ��� ���� ��� �����ϴ� ��ü
-- ���� ���� HEAD �� ������ ���� BODY �� ���� ���� �ۼ��ؾ� ��
-- �ڹٷ� ���ϸ� HEAD�� �������̽���, 
-- BODY �� �������̽� ��ӹ޾� �߻�޼ҵ� �������̵� ó���� �����η� �񱳵�.

-- ��Ű�� ���� : HEAD ����
CREATE OR REPLACE PACKAGE PMEMBER
IS
    -- ��Ű���� ���� ���ν����� �Լ� ������
    PROCEDURE DEL_DEPTNO(DELNO  DEPT_COPY.DEPT_ID%TYPE);
    FUNCTION CAL_BONUS(VENAME EMPLOYEE.EMP_NAME%TYPE)
    RETURN NUMBER;
END;
/

-- ��Ű�� ������ : BODY
-- ��Ű�� �ȿ� ����� ���ν����� �Լ��� ���� ������
CREATE OR REPLACE PACKAGE BODY PMEMBER
IS
    -- ���ν��� ���� : �μ���ȣ ���޹޾� �μ� ����
    PROCEDURE DEL_DEPTNO(DELNO  DEPT_COPY.DEPT_ID%TYPE)
    IS
    BEGIN
        DELETE FROM DEPT_COPY
        WHERE DEPT_ID = DELNO;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE(DELNO || '�� �μ��� �����Ǿ����ϴ�.');
    END;
    
    -- �Լ� ���� : ����� �Է¹޾� ���ʽ� ��� ����
    FUNCTION CAL_BONUS(VENAME EMPLOYEE.EMP_NAME%TYPE)
    RETURN NUMBER
    IS
        VSAL EMPLOYEE.SALARY%TYPE;
        RESULT NUMBER;
    BEGIN
        SELECT SALARY INTO VSAL
        FROM EMPLOYEE
        WHERE EMP_NAME = VENAME;
        
        RESULT := VSAL * 2;
        RETURN RESULT;
    END;
END;
/

-- ���� Ȯ��
SET SERVEROUTPUT ON;

-- ���ν��� ����
EXEC PMEMBER.DEL_DEPTNO('&�μ���ȣ');

-- �Լ� ����
VARIABLE BONUS NUMBER;
EXEC :BONUS := PMEMBER.CAL_BONUS('&�����');
PRINT BONUS;


-- ****************************************************
-- Ŀ�� (CURSOR)
-- SELECT �������� ���� ��� (RESULT SET)�� ���� ������� ������ ���� ���� ��
-- ������� �ϳ��� �ٷ���� �� �� ����ϴ� ��ü��
-- �ڹ��� ArrayList �� index(����) �� ����� ������.

-- �ǽ� : Ŀ���� ���̺��� ��� ������ ��ȸ�ϱ�
SET SERVEROUTPUT ON;
DECLARE
    V_DEPT DEPARTMENT%ROWTYPE;
    CURSOR C1 IS SELECT * FROM DEPARTMENT;
BEGIN
    DBMS_OUTPUT.PUT_LINE('�μ���ȣ   �μ���   ������ȣ');
    DBMS_OUTPUT.PUT_LINE('--------------------------------');
    OPEN C1;
    LOOP
        FETCH C1 INTO V_DEPT.DEPT_ID, V_DEPT.DEPT_NAME, V_DEPT.LOC_ID;
        EXIT WHEN C1%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(V_DEPT.DEPT_ID || '  ' || V_DEPT.DEPT_NAME
                        || '  ' || V_DEPT.LOC_ID);
    END LOOP;
    CLOSE C1;
END;
/

-- ***************************************************
-- Ʈ���� (TRIGGER)
-- Ư�� ���̺� DML �� ������ �Ǹ�, �ڵ����� ����Ǵ� �̺�Ʈ ��ü

-- ���� �غ�
SET SERVEROUTPUT ON;

-- ���̺� ������ ������ EMPCPY ���̺� �����
DROP TABLE EMPCPY CASCADE CONSTRAINTS;

CREATE TABLE EMPCPY
AS
SELECT EMP_ID, EMP_NAME, DEPT_ID
FROM EMPLOYEE
WHERE 1 = 0;

SELECT * FROM EMPCPY;

DESC EMPCPY;

-- �ǽ� : EMPCPY ���̺� INSERT �� ������ �ǰ� ����, �ڵ����� ����Ǵ� 
-- Ʈ���� �ۼ� : TR_WELCOME
-- ��º�(�ܼ�)�� '�Ի縦 ȯ���մϴ�.' ��µǰ� ��
CREATE OR REPLACE TRIGGER TR_WELCOME
AFTER INSERT ON EMPCPY
BEGIN
    DBMS_OUTPUT.PUT_LINE('�Ի縦 ȯ���մϴ�.');
END;
/

-- Ʈ���� ���� : �ڵ� ����
INSERT INTO EMPCPY
VALUES ('777', 'ȫ�浿', '90');

SELECT * FROM EMPCPY;

-- �ǽ� : ��� ���̺�(EMP03)�� �ԷµǴ� ��������� �ڵ����� �޿����̺�(SALARY)��
-- �ش� ����� ���� �޿������� �ڵ����� ��ϵǰ� �ϴ� Ʈ���� �ۼ�
-- TR_SALARY 

-- ���� ���̺� �����
CREATE TABLE EMP03 (
    EMPNO  NUMBER(4)  PRIMARY KEY,
    ENAME  VARCHAR2(15),
    SAL  NUMBER(7, 2)
);

CREATE TABLE SALARY (
    NO  NUMBER  PRIMARY KEY,
    EMPNO  NUMBER(4),
    SAL  NUMBER(7, 2)
);

CREATE SEQUENCE SAL_SEQ
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;


CREATE OR REPLACE TRIGGER TR_SALARY
AFTER INSERT ON EMP03
FOR EACH ROW
BEGIN
    INSERT INTO SALARY
    VALUES (SAL_SEQ.NEXTVAL, :NEW.EMPNO, :NEW.SAL);
END;
/

-- Ȯ��
INSERT INTO EMP03
VALUES (8000, 'ȫ���', 3000);

SELECT * FROM EMP03;
SELECT * FROM SALARY;

/* *******************************************
���� ) ���̺� �����
1. ��ǰ ���̺� �����
2. �԰� ���̺� �����
3. �԰� ���̺� ��ǰ�� �԰�Ǹ�, ��ǰ ���̺��� ��� ������ �ڵ����� ����ǰ� ��
4. �Է�, ����, ������ ����Ǹ�, ��� ��ȭ�� �ֵ��� Ʈ���� �ۼ���
*/

-- 1. ���̺� �����, ���� ������ ���
CREATE TABLE ��ǰ (
    ��ǰ�ڵ�  CHAR(4)  CONSTRAINT PK_��ǰ  PRIMARY KEY,
    ��ǰ��  VARCHAR2(15) NOT NULL,
    ������  VARCHAR2(15),
    �Һ��ڰ���  NUMBER,
    ������  NUMBER  DEFAULT 0
);

INSERT INTO ��ǰ VALUES ('A001', '���콺', 'LG', 1000, DEFAULT);
INSERT INTO ��ǰ VALUES ('A002', 'Ű����', '�Ｚ', 2000, 0);
INSERT INTO ��ǰ VALUES ('A003', '�����', 'HP', 10000, DEFAULT);

COMMIT;

SELECT * FROM ��ǰ;

CREATE TABLE �԰� (
    �԰��ȣ NUMBER PRIMARY KEY,
    ��ǰ�ڵ� CHAR(4)  REFERENCES ��ǰ (��ǰ�ڵ�),
    �԰����� DATE,
    �԰���� NUMBER,
    �԰�ܰ� NUMBER,
    �԰�ݾ� NUMBER
);


-- ������ ����
CREATE SEQUENCE �԰�_SEQ
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

-- ���ν��� ���� : �԰� ���̺� �� �Է��ϴ� ���ν���
CREATE OR REPLACE PROCEDURE SP_PRO_INSERT(CODE CHAR,
        SU NUMBER, WON NUMBER)
IS
BEGIN
    INSERT INTO �԰�
    VALUES (�԰�_SEQ.NEXTVAL, CODE, SYSDATE, SU, WON, SU * WON);
    COMMIT;
END;
/

-- 1. �Է� Ʈ����
-- �԰� ���̺� ��ǰ�� �ԷµǾ��� �� ��ǰ ���̺��� �������� �����ǰ� ó��
CREATE OR REPLACE TRIGGER TR_PRODUCT_INSERT
AFTER INSERT ON �԰�
FOR EACH ROW
BEGIN
    UPDATE ��ǰ
    SET ������ = ������ + :NEW.�԰����
    WHERE ��ǰ�ڵ� = :NEW.��ǰ�ڵ�;   
END;
/

-- 2. ���� Ʈ����
-- �԰� ���̺��� ��ǰ�� ��������� ����Ǿ��� �� ������ ����
-- ���� ���, �԰�� ��ǰ�� ������ 15���� 10���� �����ϸ�, 
-- ��ǰ ���̺��� �������� 25���� 20���� ����ǰ� �ؾ���
CREATE OR REPLACE TRIGGER TR_PRODUCT_UPDATE
AFTER UPDATE ON �԰�
FOR EACH ROW
BEGIN
    UPDATE ��ǰ
    SET ������ = ������ - :OLD.�԰���� + :NEW.�԰����
    WHERE ��ǰ�ڵ� = :OLD.��ǰ�ڵ�;
END;
/

-- ���� Ʈ����
-- �԰� ���̺��� ���� �����ϸ�, ������ ���� ������ŭ ��ǰ ���̺��� ��������
-- ����
CREATE OR REPLACE TRIGGER TR_PRODUCT_DELETE
AFTER DELETE ON �԰�
FOR EACH ROW
BEGIN
    UPDATE ��ǰ
    SET ������ = ������ - :OLD.�԰����
    WHERE ��ǰ�ڵ� = :OLD.��ǰ�ڵ�;    
END;
/

-- ���ν����� ����Ͽ� INSERT ����
EXEC SP_PRO_INSERT('A002', 20, 3000);

SELECT * FROM �԰�;
SELECT * FROM ��ǰ;

EXEC SP_PRO_INSERT('A002', 10, 3000);

-- ���� Ȯ��
UPDATE �԰�
SET �԰���� = 15
WHERE �԰��ȣ = 2;

SELECT * FROM �԰�;
SELECT * FROM ��ǰ;

-- ���� Ȯ��
DELETE FROM �԰�
WHERE �԰��ȣ = 4;

SELECT * FROM �԰�;
SELECT * FROM ��ǰ;
