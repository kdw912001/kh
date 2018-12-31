-- DAY2 ��������

/*
����Ŭ �ڷ���
 - NUMBER(����, �Ǽ�����), VARCHAR2(�������� ���ڿ�),
   CHAR(�������� ���ڿ�), DATE(��¥, �ð�), LONG(�������̹��ڿ�)
   
 - NUMBER : �⺻�� ��������. �⺻�ڸ����� 7��.
   NUMBER(�ڸ���) => NUMBER(12) : ������ �ִ� 12�ڸ�� ���
   NUMBER(�ִ����ڸ���, �Ҽ����Ʒ� �ڸ���) : �Ǽ��� ���� ���
     => NUMBER(10, 2) : �Ǽ��� ���� �ִ� 10�ڸ����� ���
                        �Ҽ��� �Ʒ� �ڸ����� 2°�ڸ����� ��ϰ���
 - CHAR(�����ڸ���) : ������ ���ڹ���Ʈ �����ŭ�� ���ڸ� �����.
    CHAR(10) : ������ 10����Ʈ �����.
            ����, 5����Ʈ�� ����ϸ� ������ ����Ʈ�� ���鹮�ڷ� ä��.
 - VARCHAR2(�ִ��ϱ��ڹ���Ʈ��) : ������ ����Ʈ������ ������ ���ڸ� �����
    VARCHAR2(15) : �ִ� 15����Ʈ �̳��� ���ڷ� �����.
            10����Ʈ ����ϸ� �״�� 10����Ʈ�� ����ũ����.
 - DATE : ��¥�� �ð� ó����
    ����, ��, ��, ��, ��, ��, ��, ����/����, ���� ó��
    �ѱ����� ���� ������ YY/MM/DD ��
    ������ ���� ������ DD/MON/YY ��
*/

-- ��¥ ���� Ȯ��
SELECT SYSDATE
FROM DUAL;

-- ����Ŭ �����ͺ��̽� ȯ�漳�� ���� �� Ȯ���ϱ�
SELECT * 
FROM V$NLS_PARAMETERS;

-- �ѱ� ����Ʈ ũ�� Ȯ���ϱ�
SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ'), LENGTHB('��')
FROM DUAL;

-- ��¥ ������ ��� ������
SELECT SYSDATE + 100 FROM DUAL;  -- ���ú��� 100�� ���� ��¥ ��ȸ
SELECT SYSDATE - 300 FROM DUAL;  -- ���� ���� 300�� ���� ��¥ ��ȸ

SELECT SYSDATE - HIRE_DATE  -- ���� - �Ի��� : ��¥��(�ٹ��ϼ�)
FROM EMPLOYEE;

SELECT SYSDATE + 120 / 24 FROM DUAL;
-- ���ݺ��� 120�ð� ���� ��¥ ��ȸ

-- SELECT �� **********************************************
-- DQL(Data Query Language)
-- �����ͺ��̽��� ���̺��� ���·� ��ϵ� �����͸� ��ȸ�� �� ����ϴ� ������

-- ��� 1
-- ���� ���̺�(EMPLOYEE)���� ���(EMP_ID), �����(EMP_NAME), 
-- ��ȭ��ȣ(PHONE) �÷��� ��ȸ
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE;

-- ��� 2
-- ���� ���̺��� ������ ����� 100��(������ �Ѽ��� ��) ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE MGR_ID = '100';


-- ��� 3
-- ���� ���̺��� �Ѽ��� ����(����� 100��)�� ������ �ް� �ִ� ���� ��ȸ
-- ���, �̸�, ��ȭ��ȣ, �μ��ڵ� ��ȸ
SELECT EMP_ID, EMP_NAME, PHONE, DEPT_ID
FROM EMPLOYEE
WHERE MGR_ID = '100';

-- ��� 4
-- ���� ���̺�� �μ� ���̺�(DEPARTMENT)���� ���� ��ȸ
-- ���, �̸�, �޿�, �μ���  ��ȸ
select emp_id, emp_name, salary, dept_name
from employee
join department using (dept_id)
where dept_id = '50'
order by emp_name asc;

-- SELECT ���� ���� ***************************************
/*
�⺻����
SELECT * | [DISTINCT] ��ȸ�� �÷��� | ���� [AS] ��Ī(ALIAS)
FROM ��ȸ�� ����� ���̺��;
*/

-- * : ��� �÷� (���̺��� ���� �÷� ���� ��)
SELECT * 
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ���, �����, �޿� ������ ��ȸ�� ���
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;

-- DISTINCT �÷���
-- ���� ���̺� ���� �����ڵ带 ��ȸ�� ���
SELECT JOB_ID
FROM EMPLOYEE;

SELECT DISTINCT JOB_ID
FROM EMPLOYEE;
-- DISTINCT �� SELECT ���� �� 1���� ����� �� ����

SELECT DISTINCT JOB_ID, DISTINCT DEPT_ID
FROM EMPLOYEE;  -- ERROR

SELECT DISTINCT JOB_ID, DEPT_ID
FROM EMPLOYEE;

-- SELECT ���� ������ ����� ���� ����
SELECT 23 + 31 / 5
FROM DUAL;  -- DUMMY(����) ���̺�

-- ���� ���̺��� ���, �����, �޿�, 1��ġ �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, SALARY * 12
FROM EMPLOYEE;

-- ���� ���̺��� ���, �����, �޿�, ���ʽ�����Ʈ, 
-- ���ʽ�����Ʈ�� ����� ���� ��ȸ
-- ���� : (�޿� + (�޿� * ���ʽ�����Ʈ)) * 12
SELECT EMP_ID, EMP_NAME, SALARY, BONUS_PCT,
       (SALARY + (SALARY * BONUS_PCT)) * 12
FROM EMPLOYEE;
-- ��갪�� NULL �� ������, ����� NULL �� ��.

-- ���Ŀ� �Լ� ����� �� ����
-- �÷��� ���� NULL �� ��쿡 �ٸ� ������ �ٲٴ� �Լ� 
-- NVL(�÷���, �ٲܰ�)
SELECT EMP_ID, EMP_NAME, SALARY, BONUS_PCT,
        (SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12
FROM EMPLOYEE;

-- SELECT ���� ������ �÷��� �Ǵ� ���� �ڿ� ��Ī(ALIAS) ����� ���� ����
-- ��Ī�� �ݵ�� "��Ī"�� ����� �ϴ� ��� : ��Ī�� �����̳� ����, ��ȣ���� ���
SELECT EMP_ID ���, EMP_NAME �̸�, SALARY AS "�޿�(��)",
        SALARY * 12 AS "1��޿�", BONUS_PCT "���ʽ� ����Ʈ",
        (SALARY + (SALARY * NVL(BONUS_PCT, 0))) * 12 "���ʽ�����Ʈ���뿬��"
FROM EMPLOYEE;

-- SELECT ���� ���ͷ�(LITERAL : ��)�� ����� ���� ����
SELECT EMP_ID ���, EMP_NAME �̸�, '����' ����
FROM EMPLOYEE;

/*
WHERE �� ���
3 : SELECT �÷��� ��Ī,   ...... 
1 : FROM ���̺��
2 : WHERE �÷��� �񱳿����� �񱳰�

- �ݵ�� FROM �� ������ ����ؾ� ��
- �������� : ���̺��� ���ǰ� ��ġ�ϴ� ���� ���� ����� ���
- �񱳿����� : > (ũ��, �ʰ�), < (������, �̸�), >= (ũ�ų� ������, �̻�),
           <= (�۰ų� ������, ����), = (������, ��ġ�ϴ�),
           !=, <>, ^= (��ġ���� �ʴ�, ���� ����)
- �������� : AND(&& �� ����), OR(|| �� ����), NOT(! �� ����)           
*/

-- �μ��ڵ尡 '90'�� �����鸸 ��ȸ�� ���
SELECT *
FROM EMPLOYEE
WHERE DEPT_ID = '90';

-- �����ڵ尡 'J7'�� �����鸸 ��ȸ�� ���
SELECT *
FROM EMPLOYEE
WHERE JOB_ID = 'J7';

-- �޿��� 4�鸸�� �ʰ��ϴ� �����鸸 ��ȸ
SELECT *
FROM EMPLOYEE
WHERE SALARY > 4000000;


-- �޿��� 2�鸸�̻� 4�鸸������ ������ ���� ��ȸ
-- ���, �̸�, �޿�, �����ڵ�, �μ��ڵ� ��ȸ, ��Ī ó��
SELECT EMP_ID ���, EMP_NAME �̸�, SALARY �޿�, 
        JOB_ID �����ڵ�, DEPT_ID �μ��ڵ�
FROM EMPLOYEE
--WHERE SALARY >= 2000000 AND SALARY <= 4000000;
WHERE SALARY BETWEEN 2000000 AND 4000000;

-- ��¥ �����Ϳ��� �÷��� BETWEEN ������ AND ū�� ������ �� ����
-- �Ի����� 1995�� 1�� 1�Ϻ��� 2000�� 12�� 31�� ���̿� �Ի���
-- ������ ���, �̸�, �Ի���, �μ��ڵ� ��ȸ, ��Ī ó��

-- ��¥������ ǥ��ÿ��� �����ͺ��̽��� ���� ��¥ ���˿� ���缭
-- '��¥����' ��� ǥ���ؾ� ��
SELECT SYSDATE FROM DUAL; -- '18/12/31' ǥ���ϸ� ��

SELECT EMP_ID ���, EMP_NAME �̸�, HIRE_DATE �Ի���, DEPT_ID �μ��ڵ�
FROM EMPLOYEE
--WHERE HIRE_DATE >= '95/01/01' AND HIRE_DATE <= '00/12/31';
WHERE HIRE_DATE BETWEEN '95/01/01' AND '00/12/31';

-- �μ��ڵ尡 '90'�̸鼭, �޿��� 2�鸸�� �ʰ��ϴ� ���� ��ȸ
-- 90�� �μ��� �Ҽӵ� �����߿��� �޿��� 2�鸸���� ���� �޴� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE DEPT_ID = '90' AND SALARY > 2000000;

-- �μ��ڵ尡 90 �Ǵ� 20 �� ���� ��ȸ
-- 20��, 90�� �μ��� �Ҽӵ� ���� ��ȸ
SELECT * 
FROM EMPLOYEE
--WHERE DEPT_ID = '20' OR DEPT_ID = '90';
WHERE DEPT_ID IN ('20', '90');

-- ���� ������ : || (�ڹ��� ���ڿ���ġ���ϴ� + �� ���� �ǹ��� ��������)
-- SELECT ������ ��ȸ�� �÷������� �ϳ��� ��ġ�ų�, �÷����� ���ͷ��� ��ĥ ���
SELECT EMP_NAME || ' ������ �޿��� ' || SALARY || ' ���Դϴ�.' AS �޿�����
FROM EMPLOYEE
WHERE DEPT_ID = '90';

-- 2000�� 1�� 1�� ���Ŀ� �Ի��� ���� �߿���
-- ��ȥ�� ������ �̸�, �Ի���, �����ڵ�, �μ��ڵ�, �޿�, ��ȥ���� ��ȸ, ��Ī ó��
-- �޿��� �ڿ��� '(��)' ���ͷ� �ٿ���
-- ��ȥ���� �� ���ͷ��� ä�� : '��ȥ' �� ��µǰ� ������
SELECT EMP_NAME �̸�, HIRE_DATE �Ի���, JOB_ID �����ڵ�, 
        DEPT_ID �μ��ڵ�, 
        SALARY || ' (��)' �޿�, '��ȥ' ��ȥ����
FROM EMPLOYEE
WHERE HIRE_DATE >= '00/01/01' AND MARRIAGE = 'Y';

-- �޿��� 2�鸸���� ���� �ްų�, 4�鸸���� ���� �޴� ���� ��ȸ
-- �̸�, �޿� ��ȸ
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
--WHERE SALARY < 2000000 OR SALARY > 4000000;
--WHERE NOT (SALARY >= 2000000 AND SALARY <= 4000000);
--WHERE SALARY NOT BETWEEN 2000000 AND 4000000;
WHERE NOT SALARY BETWEEN 2000000 AND 4000000;

-- LIKE ������
-- ���ڿ����� ������ �����ؼ�, ���ϰ� ��ġ�ϴ� ���� ��� �� ����ϴ� ��������
-- ���ڿ� ���Ͽ� ���ϵ�ī�� ���� �����
--     : %(0�� �̻��� ���ڵ�), _(�������ڸ�)

-- ���� '��'���� ������ ���� ��ȸ
-- ���, �̸�, �ֹι�ȣ, ��ȭ��ȣ ��ȸ, ��Ī ó��
SELECT EMP_ID ���, EMP_NAME �̸�, EMP_NO �ֹι�ȣ, 
        PHONE ��ȭ��ȣ
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%';

-- �̸��� '��' �ڰ� ���Ե� ���� ���� ��ȸ
-- �̸�, �ֹι�ȣ, ��ȭ��ȣ, ��ȥ���� ��ȸ, ��Ī ó��
SELECT EMP_NAME �̸�, EMP_NO �ֹι�ȣ, PHONE ��ȭ��ȣ, MARRIAGE ��ȥ����
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%';

-- ��ȭ��ȣ�� ����(4��°��)�� '9'�� �����ϴ� ���� ���� ��ȸ
-- �̸�, ��ȭ��ȣ ��ȸ
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

-- ������ ������ ���� ��ȸ
-- ���, �̸�, �ֹι�ȣ, ��ȭ��ȣ ��ȸ
-- ���� �Ǵ� : �ֹι�ȣ 8��° ���ڰ� 1�̸� ����, 2�̸� ������.
SELECT EMP_ID ���, EMP_NAME �̸�, EMP_NO �ֹι�ȣ, PHONE ��ȭ��ȣ
FROM EMPLOYEE
WHERE EMP_NO LIKE '_______2%';

-- ���� ���� ��� ��ȸ
SELECT EMP_ID ���, EMP_NAME �̸�, EMP_NO �ֹι�ȣ, PHONE ��ȭ��ȣ
FROM EMPLOYEE
--WHERE EMP_NO NOT LIKE '_______2%';
--WHERE NOT EMP_NO LIKE '_______2%';
WHERE EMP_NO LIKE '_______1%';

-- ��ϵ� ���ڿ� '_'�� '%' �� ���ڷ� ��ϵǾ� �ִ� ���
-- ���ϵ�ī�� ���ڿ� ��ϵ� ���ڸ� �����ؾ� �ϴ� ���
-- ESCAPE �ɼ� �����

-- �̸��Ͽ��� ��ϵ� '_' ���� �� ���ڰ� 3������ �̸��� ���� ��ȸ
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE
--WHERE EMAIL LIKE '___\_%' ESCAPE '\';
WHERE EMAIL LIKE '___#_%' ESCAPE '#';


-- IS NULL / IS NOT NULL
-- �����ڵ� ����, �μ��� �������� ���� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE MGR_ID IS NULL AND DEPT_ID IS NULL;

-- �����ڴ� ���µ�, �μ��� �������� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE MGR_ID IS NULL AND DEPT_ID IS NOT NULL;

-- �μ��� ���� �� �� �������� ���� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE DEPT_ID IS NULL AND JOB_ID IS NULL;

-- ���ʽ�����Ʈ�� ���� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE BONUS_PCT IS NULL;

-- �μ���ġ�� ���� �ʾҴµ�, ���ʽ�����Ʈ�� �޴� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE DEPT_ID IS NULL AND BONUS_PCT IS NOT NULL;

-- ������ �켱���� ��
-- �μ��ڵ尡 20 �Ǵ� 90�� ���� �߿��� �޿��� 3�鸸���� ���� �޴� ���� ��ȸ
-- �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_ID, SALARY
FROM EMPLOYEE
--WHERE DEPT_ID = '20' OR DEPT_ID = '90' AND SALARY > 3000000;
--WHERE (DEPT_ID = '20' OR DEPT_ID = '90') AND SALARY > 3000000;
WHERE DEPT_ID IN ('20', '90') AND SALARY > 3000000;











