-- DAY4

-- ��¥ó���Լ� ***************************
-- SYSDATE �Լ�
-- �ý������κ��� ���� ��¥�� �ð��� ��ȸ
SELECT SYSDATE
FROM DUAL;  -- RR/MM/DD �⺻ ������.

/*
����Ŭ������ ȯ�漳��, ��ü ���� �������� ��� ���� �����ϰ� ����.
������ ��ųʸ�(������ ����) �������� ���̺��� ���·� ���� ����ǰ� ����
������ ��ųʸ��� ����� ������ ��ȸ�� �� �� ����. �� ����� ����
DB �ý����� �ڵ� ���� ������
��, ȯ�漳���� ���õ� �κ��� ���� ������ ������ �� ����
*/
SELECT *
FROM SYS.NLS_SESSION_PARAMETERS;

-- ��¥ ����� ���õ� ���� ���� ��ȸ
SELECT VALUE
FROM NLS_SESSION_PARAMETERS
WHERE PARAMETER = 'NLS_DATE_FORMAT';

-- ��¥ ���� ����
ALTER SESSION
SET NLS_DATE_FORMAT = 'DD-MON-RR';

COMMIT;

-- Ȯ��
SELECT SYSDATE
FROM DUAL;

-- ���� �������� ����
ALTER SESSION
SET NLS_DATE_FORMAT = 'RR/MM/DD';

COMMIT;

-- ADD_MONTHS(���س�¥�� | ��¥�� ��ϵ� �÷���, ���� ������)
-- ���� �������� ���� ��¥�� ���ϵ�

-- ���� ��¥���� 10�� ���� ��¥��?
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 120)
FROM DUAL;

-- ���� ���̺��� �Ի����� 20��� ��¥ ��ȸ
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 240)
FROM EMPLOYEE;

-- ������ �߿��� �ٹ������ 20���̻� �ٹ��� ���� ���� ��ȸ
-- ���, �̸�, �μ��ڵ�, �����ڵ�, �Ի��� ��ȸ, ��Ī ó��
SELECT EMP_ID ���, EMP_NAME �̸�, DEPT_ID �μ��ڵ�, 
        JOB_ID �����ڵ�, HIRE_DATE �Ի���
FROM EMPLOYEE
WHERE ADD_MONTHS(HIRE_DATE, 240) < SYSDATE;

-- MONTHS_BETWEEN(��¥1, ��¥2)
-- �� ��¥�� ���̳� �������� ������

-- �������� �̸�, �Ի���, ��������� �ٹ��ϼ�, �ٹ�������, �ٹ���� ��ȸ
SELECT EMP_NAME �̸�, HIRE_DATE �Ի���,
        FLOOR(SYSDATE - HIRE_DATE) �ٹ��ϼ�,
        FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) �ٹ�������,
        FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12) �ٹ����
FROM EMPLOYEE;

-- NEXT_DAY('��¥������' | ��¥�� ��ϵ� �÷���, '�����̸�')
-- ������ ��¥ ���� ��¥���� ���� ����� ������ ��¥�� ������
SELECT SYSDATE, NEXT_DAY(SYSDATE, '�����')
FROM DUAL;

-- �����ͺ��̽��� ��� �� �ѱ���� ������ �Ǿ� �ֱ� ������
-- �����̸��� �ѱ� �����
-- �����̸��� ���� ����ϸ� ������
SELECT NEXT_DAY(SYSDATE, 'FRIDAY')
FROM DUAL;  -- ERROR

-- �����̸��� ���� ����Ϸ��� �� �����ؾ� ��
ALTER SESSION
SET NLS_LANGUAGE = AMERICAN;

COMMIT;

-- �ѱ���� ����
ALTER SESSION
SET NLS_LANGUAGE = KOREAN;
COMMIT;

-- LAST_DAY('��¥������' | ��¥�� ��ϵ� �÷���)
-- ������ ��¥�� ���� ���� ������ ��¥�� ������
SELECT LAST_DAY(SYSDATE)
FROM DUAL;

-- ���� ���̺��� �����, �Ի���, �Ի��� ���� �ٹ��ϼ� ��ȸ
-- �ָ� ����
SELECT EMP_NAME �����, HIRE_DATE �Ի���, 
        LAST_DAY(HIRE_DATE) - HIRE_DATE "�Ի���� �ٹ��ϼ�"
FROM EMPLOYEE;

-- ���� ��¥ ��ȸ �Լ�
SELECT SYSDATE,
        SYSTIMESTAMP,
        CURRENT_DATE,
        CURRENT_TIMESTAMP
FROM DUAL;

-- EXTRACT(������ �׸� FROM ��¥)
-- ��¥ �����Ϳ��� ���ϴ� �׸� ����

-- ���� ��¥���� �⵵�� ����
SELECT EXTRACT(YEAR FROM SYSDATE),
        EXTRACT(MONTH FROM SYSDATE),
        EXTRACT(DAY FROM SYSDATE)
FROM DUAL;

-- ������ �̸�, �Ի���, �ٹ���� ��ȸ
SELECT EMP_NAME, HIRE_DATE,
        EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) �ٹ����,
        FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12) �ٹ����
FROM EMPLOYEE;

-- ����ȯ �Լ� **************************************

-- �ڵ�����ȯ�� ���
SELECT 20 + '10'
FROM DUAL;

SELECT 20 + TO_NUMBER('10')
FROM DUAL;

-- �ڵ�����ȯ�� �� �Ǵ� ���
SELECT SYSDATE - '15/03/25'
FROM DUAL;  -- ERROR
-- ���� ����ȯ�ؾ� ��
SELECT SYSDATE - TO_DATE('15/03/25')
FROM DUAL;

-- �Ǵ�
SELECT SYSDATE - TO_DATE('15/03/25', 'RR/MM/DD')
FROM DUAL;

-- TO_CHAR(���� | ��¥, '�ٲٰ��� ���ϴ� ���˹��ڵ� ����')
-- ���ڳ� ��¥�� ���ϴ� �������� �ٲ� �� �����

SELECT EMP_NAME �̸�,
        TO_CHAR(SALARY, 'L99,999,999') �޿�, 
        TO_CHAR(NVL(BONUS_PCT, 0), '90.00') ���ʽ�����Ʈ
FROM EMPLOYEE;

-- ��¥ �����Ϳ� ���� ����ÿ��� TO_CHAR() �����.
SELECT SYSDATE,
        TO_CHAR(SYSDATE, 'YYYY'), TO_CHAR(SYSDATE, 'RRRR'),
        TO_CHAR(SYSDATE, 'YY'), TO_CHAR(SYSDATE, 'RR'),
        TO_CHAR(SYSDATE, 'YEAR')
FROM DUAL;

SELECT HIRE_DATE,
        TO_CHAR(HIRE_DATE, 'YYYY "��"'), 
        TO_CHAR(HIRE_DATE, 'RRRR "��"'),
        TO_CHAR(HIRE_DATE, 'YY'), TO_CHAR(HIRE_DATE, 'RR'),
        TO_CHAR(HIRE_DATE, 'YEAR')
FROM EMPLOYEE;

SELECT SYSDATE,
        TO_CHAR(SYSDATE, 'YYYY "��" MM "��"'),
        TO_CHAR(SYSDATE, 'MM'), TO_CHAR(SYSDATE, 'MONTH'),
        TO_CHAR(SYSDATE, 'MON'), TO_CHAR(SYSDATE, 'RM')
FROM DUAL;

SELECT SYSDATE,
        TO_CHAR(SYSDATE, '"1�����" DDD "��°"'),
        TO_CHAR(SYSDATE, '"������" DD "��°"'),
        TO_CHAR(SYSDATE, '"�ֱ���" D "��°"')
FROM DUAL;

SELECT SYSDATE,
        TO_CHAR(SYSDATE, 'Q "��б�"'),
        TO_CHAR(SYSDATE, 'DAY'),
        TO_CHAR(SYSDATE, 'DY')
FROM DUAL;

-- ���� ���̺��� �̸�, �Ի��� ��ȸ
-- �Ի����� ������ �����ؼ�
-- '2016�� 05�� 19�� (��)" �������� ���ó����
SELECT EMP_NAME �̸�,
        TO_CHAR(HIRE_DATE, 'YYYY"��" MM"��" DD"��" "("DY")"') �Ի���
FROM EMPLOYEE;

SELECT EMP_NAME,
        TO_CHAR(HIRE_DATE, 'YYYY-MM-DD AM HH:MI:SS'),
        TO_CHAR(HIRE_DATE, 'YYYY-fmMM-DD AM HH:MI:SS'),
        TO_CHAR(HIRE_DATE, 'YYYY-MM-fmDD HH24:MI:SS')
FROM EMPLOYEE
WHERE EMP_ID = '100';

-- ��¥ ������ �񱳿���� �ð��� ���� ���� ���� ��¥�� �� ������ �� ����.
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE = '90/04/01';  -- �ð��� ��ϵǾ� ����

-- �ذ�
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE TO_CHAR(HIRE_DATE, 'YY/MM/DD') = '90/04/01'; 

-- �Ǵ�
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE LIKE '90/04/01'; 

-- ��¥�� ��ϵ� ��쿡�� ��¥�� �񱳿����� �� ����
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE = '04/04/30';


-- TO_DATE('���ڷ� �� ��¥�� �ð�', '���� ���� ���ڸ��� ���˹���')
-- ���� ���ڿ� ���� ���˹����� ������ ���ƾ� �� : �ؼ��� �ǹ���.

SELECT TO_DATE('20161225', 'YYYYMMDD'),
        TO_CHAR(TO_DATE('20161225', 'YYYYMMDD'), 'DY')
FROM DUAL;

SELECT TO_CHAR(TO_DATE('20201225 134550', 'YYYYMMDD HH24MISS'),
                'YY-MM-DD DY AM HH:MI:SS')
FROM DUAL;

SELECT TO_DATE('2013-03-15', 'YYYY-MM-DD')
FROM DUAL;


-- RR �� YY �� ����
-- �� �ڸ� �⵵�� ���ڸ� �⵵�� �ٲ� ��
-- ���� �⵵(19 : 50���� ����)�� ��,
-- �ٲ� �⵵�� 50�̸��̸� 2000�⵵�� ����, �ٲ� �⵵�� 50�̻��̸� 1900�� �����

SELECT HIRE_DATE,
        TO_CHAR(HIRE_DATE, 'YYYY'), TO_CHAR(HIRE_DATE, 'RRRR')
FROM EMPLOYEE;

-- ���� �⵵�� �ٲ� �⵵�� �� �� 50�̸��̸� Y, R �ƹ��ų� ����ϸ� ��
SELECT TO_CHAR(TO_DATE('160505', 'YYMMDD'), 'YYYY-MM-DD'),
        TO_CHAR(TO_DATE('160505', 'RRMMDD'), 'RRRR-MM-DD'),
        TO_CHAR(TO_DATE('160505', 'RRMMDD'), 'YYYY-MM-DD'),
        TO_CHAR(TO_DATE('160505', 'YYMMDD'), 'RRRR-MM-DD')
FROM DUAL;

-- ���� �⵵�� 50�̸��̰�, �ٲ� �⵵�� 50�̻��� ��
-- �⵵�� �ٲ� �� Y ����ϸ� ���� ����(2000��)�� �����
-- �⵵�� �ٲ� �� R ����ϸ� ���� ����(1900��)�� �����
SELECT TO_CHAR(TO_DATE('990101', 'YYMMDD'), 'YYYY-MM-DD'), --2099
        TO_CHAR(TO_DATE('990101', 'RRMMDD'), 'RRRR-MM-DD'), --1999
        TO_CHAR(TO_DATE('990101', 'YYMMDD'), 'RRRR-MM-DD'), --2099
        TO_CHAR(TO_DATE('990101', 'RRMMDD'), 'YYYY-MM-DD') -- 1999
FROM DUAL;

-- ��� : ���ڸ� �⵵�� �ٲ� �� �⵵�� 'R' ����ϸ� ��.

-- ��Ÿ�Լ� ***********************************************

-- NVL(�÷���, �÷��� ���� NULL�� �� �ٲ� ��)
SELECT EMP_NAME, BONUS_PCT, DEPT_ID, JOB_ID
FROM EMPLOYEE;

SELECT EMP_NAME, NVL(BONUS_PCT, 0.0),
        NVL(DEPT_ID, '00'), NVL(JOB_ID, 'J0')
FROM EMPLOYEE;

-- NVL2(�÷���, �ٲܰ�1, �ٲܰ�2)
-- �ش� �÷��� ���� ������ �ٲܰ�1�� �����ϰ�, NULL�̸� �ٲܰ�2�� ������.

-- ������������ ���ʽ�����Ʈ�� 0.2�̸��̰ų� NULL �� ������ ��ȸ
-- ���, �̸�, ���ʽ�����Ʈ, ���溸�ʽ�����Ʈ
-- ���溸�ʽ�����Ʈ�� ���� ������ 0.15�� �ٲٰ�, NULL�̸� 0.05�� �ٲ�
SELECT EMP_ID ���, EMP_NAME �̸�, BONUS_PCT ���ʽ�����Ʈ, 
        NVL2(BONUS_PCT, 0.15, 0.05) ���溸�ʽ�����Ʈ
FROM EMPLOYEE
WHERE BONUS_PCT < 0.2 OR BONUS_PCT IS NULL;

-- DECODE(�Լ��� | ���� | �÷���, ���ð�1, ���ð�1, ..., ���ð�N, ���ð�N
-- [, ��� ���ð��� �ƴ� �� ������ ��]) 
-- ����Ŭ �����Լ�
-- SWITCH ���� ������ ���� �Լ���.

-- 50�� �μ��� ���� �������� �̸��� ���� ��ȸ
-- ������ �ֹι�ȣ 8��° ���� 1 �Ǵ� 3 �̸� ����, 2 �Ǵ� 4 �̸� ����
SELECT EMP_NAME �̸�,
        DECODE(SUBSTR(EMP_NO, 8, 1), '1', '����', '3', '����', '����') ����
FROM EMPLOYEE
WHERE DEPT_ID = '50'
ORDER BY ����, �̸�;

-- ������ �̸��� ������ ��� ��ȸ
-- �����ڻ���� NULL �̸� '�����ھ���' ���� ���

-- DECODE() ���
SELECT EMP_NAME, 
        DECODE(MGR_ID, NULL, '�����ھ���', MGR_ID)
FROM EMPLOYEE;

-- NVL() ���
SELECT EMP_NAME, NVL(MGR_ID, '�����ھ���')
FROM EMPLOYEE;

-- ���޺� �޿� �λ���� �ٸ� ��
SELECT EMP_NAME, JOB_ID, SALARY,
        DECODE(JOB_ID, 'J7', SALARY * 1.1,
                        'J6', SALARY * 1.15,
                        'J5', SALARY * 1.2,
                        SALARY * 1.05) �λ�޿�
FROM EMPLOYEE;

-- CASE ǥ����
SELECT EMP_NAME, JOB_ID, SALARY,
        CASE JOB_ID
        WHEN 'J7' THEN SALARY * 1.1
        WHEN 'J6' THEN SALARY * 1.15
        WHEN 'J5' THEN SALARY * 1.2
        ELSE SALARY * 1.05
        END �λ�޿�
FROM EMPLOYEE;

-- CASE ǥ������ ���� IF��ó�� ����� ���� ����.
SELECT EMP_ID, EMP_NAME, SALARY,
        CASE WHEN SALARY <= 3000000 THEN '�ʱ�'
             WHEN SALARY <= 4000000 THEN '�߱�'
             ELSE '���'
        END ����
FROM EMPLOYEE
ORDER BY ����;

-- �׷��Լ� ******************************************
-- ���� ���� ���� �о �Ի��ϰ�, �ϳ��� ����� �����ϴ� �Լ�
-- SUM, AVG, MIN, MAX, COUNT
SELECT SUM(SALARY), SUM(DISTINCT SALARY),
        FLOOR(AVG(SALARY)), AVG(DISTINCT SALARY),
        MIN(SALARY), MAX(SALARY),
        COUNT(*), COUNT(SALARY), COUNT(BONUS_PCT)
FROM EMPLOYEE;


--�Լ� ��������
--
--1. ������� �ֹι�ȣ�� ��ȸ��
--  ��, �ֹι�ȣ 9��° �ڸ����� �������� '*'���ڷ� ä��
--  �� : ȫ�浿 771120-1******


--2. ������, �����ڵ�, ����(��) ��ȸ
--  ��, ������ ��57,000,000 ���� ǥ�õǰ� ��
--     ������ ���ʽ�����Ʈ�� ����� 1��ġ �޿���
--
--
--3. �μ��ڵ尡 50, 90�� ������ �߿��� 2004�⵵�� �Ի��� ������ 
--   �� ��ȸ��.
--	��� ����� �μ��ڵ� �Ի���
--
--
--4. ������, �Ի���, �Ի��� ���� �ٹ��ϼ� ��ȸ
--  ��, �ָ��� ������
--
--
--5. ������, �μ��ڵ�, �������, ����(��) ��ȸ
--  ��, ��������� �ֹι�ȣ���� �����ؼ�, 
--     ������ ������ �����Ϸ� ��µǰ� ��.
--  ���̴� �ֹι�ȣ���� �����ؼ� ��¥�����ͷ� ��ȯ�� ����, �����

--6. �������� �Ի��Ϸ� ���� �⵵�� ������, �� �⵵�� �Ի��ο����� ���Ͻÿ�.
--  �Ʒ��� �⵵�� �Ի��� �ο����� ��ȸ�Ͻÿ�.
--  => to_char, decode, sum ���
--
--	-------------------------------------------------------------
--	��ü������   2001��   2002��   2003��   2004��
--	-------------------------------------------------------------
--
--
--7.  �μ��ڵ尡 50�̸� �ѹ���, 60�̸� ��ȹ��, 90�̸� �����η� ó���Ͻÿ�.
--   ��, �μ��ڵ尡 50, 60, 90 �� ������ ������ ��ȸ��
--  => case ���
--	�μ��ڵ� ���� �������� ������.



























