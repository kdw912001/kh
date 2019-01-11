-- DAY9

-- WITH �̸� AS (����������)
-- SELECT * FROM �̸�
-- ���������� �̸��� �ٿ��ְ�, ���� �̸��� ����ϰ� ��
-- ���� �������� ���� �� ���� ��� �ߺ��� ���� �� �ְ�
-- ���� �ӵ��� �������ٴ� ������ ����.
-- �ַ� �ζ��� ��� ���� ���������� ���� �̿���.

-- �μ��� �޿��� �հ谡 ��ü �޿� ������ 20%���� ���� ��������
-- �μ���� �μ��� �޿��հ踦 ��ȸ��.
SELECT DEPT_NAME, SUM(SALARY)
FROM EMPLOYEE
NATURAL JOIN DEPARTMENT -- DEPARTMENT �� �⺻Ű�� ���ε�
GROUP BY DEPT_NAME
HAVING SUM(SALARY) > (SELECT SUM(SALARY) * 0.2
                        FROM EMPLOYEE);

-- WITH ��� SQL �� �ٲ۴ٸ�
WITH TOTAL_SAL AS (SELECT DEPT_NAME, SUM(SALARY) SSAL
                     FROM EMPLOYEE
                     NATURAL JOIN DEPARTMENT
                     GROUP BY DEPT_NAME)
SELECT DEPT_NAME, SSAL
FROM TOTAL_SAL  -- �ζ��� ��
WHERE SSAL > (SELECT SUM(SALARY) * 0.2
                FROM EMPLOYEE);

-- *********************************************
-- �м��Լ� (�������Լ�)
/*
����Ŭ �м��Լ��� �����͸�  �м��ϴ� �Լ��̴�.
�м��Լ��� ����ϸ�, ���� ������ ����� RESULT SET(�������)�� �������
��ü �����Ͱ� �ƴ� �ұ׷캰�� �� �࿡ ���� �м� ����� ǥ���ϴ� �Լ��̴�.

�Ϲ� �׷��Լ���� �ٸ� ���� �м��Լ��� �м��Լ��� �׷��� ������ �����ؼ�
�� �׷��� ������� �м��� ���� ����� �����Ѵٴ� ���̴�.
�Ϲ� �׷��Լ��� �׷캰�� ����� �����Ѵ�.

�������

SELECT �м��Լ��� ([��������1, ��������2, ��������3]) 
        OVER ([���� PARTITON ��]
              [ORDER BY ��]
              [WINDOW ��])
FROM ���̺��

* �м��Լ��� : AVG, SUM, RANK, MAX, MIN, COUNT ��
* �������� : �м��Լ��� ���� 0 ~ 3������ ����� �� ����
* ���� PARTITION �� : PARTITION BY ǥ����
            PARTITION BY �� �����ϸ�, ǥ���Ŀ� ���� �׷캰�� �и��ϴ�
            ������ ��. RESULT SET(�������)�� �и���
* ORDER BY �� : ORDER BY �÷��� ���Ĺ��
            ASC �� ���� ������.
            PARTITION BY �� �ڿ� ��ġ�ϸ�,
            ��� ��� �׷쿡 ���ؼ� �����۾��� ������.
            �и��� �ұ׷� �ȿ��� ���� ó�� �����.
* WINDOW �� : �м��Լ��� ����� �Ǵ� �����͸�
            �� �������� ������ �� ���������� ������.
            PARTITION BY �� ���� �������� �׷쿡 ���� 
            ������ �м��� ���� �ұ׷��� ����
            PARTITON �ȿ��� ������ �������� �����͸� 
            �м� ó���ض�. �� ������ ������.
*/

-- ��� �ű�� �Լ� : RANK
-- ���� ����� ���� ���� ���� ������� �ǳʶ�
-- �� : 1, 2, 2, 4

-- �޿��� ������ �ű�ٸ�
SELECT EMP_ID, EMP_NAME, SALARY,
        RANK() OVER (ORDER BY SALARY DESC) ����
FROM EMPLOYEE;

-- � ���� ������ ��ȸ�ϰ��� �� ����
-- RANK (������ �˰��� �ϴ� ��)

-- �޿� 2300000 �� �޿� ū������ ������������ ���ĵǾ��� ��
-- ������ ��ȸ�Ϸ���
SELECT RANK(2300000) WITHIN GROUP (ORDER BY SALARY DESC) ����
FROM EMPLOYEE;

-- DENSE_RANK()
-- ���� ������ ���� �� ���� ��, ���� ������ �ǳʶ��� ����
-- �� : 1, 2, 2, 3

-- �޿��� ������ �ű�ٸ�
SELECT EMP_ID, DEPT_ID, SALARY,
        RANK() OVER (ORDER BY SALARY DESC) "����1",
        DENSE_RANK() OVER (ORDER BY SALARY DESC) "����2",
        DENSE_RANK() OVER (PARTITION BY DEPT_ID
                             ORDER BY SALARY DESC) "����3"
                             -- �׷� �ȿ����� ������.  �׷�ȿ����� ������
FROM EMPLOYEE
ORDER BY DEPT_ID DESC;

-- CUME_DIST()
-- CUMulative DISTribution
-- PARTITION BY �� ���� �������� �׷캰�� �� ���� ORDER BY ���� ��õ�
-- ������ ������ ������, �׷캰�� ������ �л�����(������� ��ġ)�� ���ϴ� �Լ���.
-- �л�����(������� ��ġ)�� ���ϰ��� �ϴ� ������ �۰ų� ���� ���� ���� �� ����
-- �׷� ���� ����� ���� ���� �ǹ���
-- 0 < ����� <= 1 ������ ���� ��

-- �μ��ڵ尡 '50'�� ������ �̸�, �޿�, �����л� �� ��ȸ
SELECT EMP_NAME, SALARY,
        ROUND(CUME_DIST() OVER (ORDER BY SALARY), 1) �����л�
FROM EMPLOYEE
WHERE DEPT_ID = '50';

-- NTILE() ******************
/*
PARTITION �� ��Ŷ(BUCKET) �̶� �Ҹ��� �׷캰�� ������,
PARTITION ���� �� ���� BUCKET �� ��ġ�ϴ� �Լ���
���� ��� PARTITION �ȿ� 100 ���� ���� �ִٸ�,
BUCKET �� 4���� ���ϸ�, 1���� BUCKET �� 25���� ���� ��е�.
��Ȯ�ϰ� �й���� ���� ���� �ٻ�ġ�� ����� �� ���� ���� ���� ��Ŷ��
�Ҵ��
*/

-- �޿��� 4������� �з�
SELECT EMP_NAME, SALARY,
        NTILE(4) OVER (ORDER BY SALARY) ���
FROM EMPLOYEE;

-- ROW_NUMBER() *****************
-- ROWNUM ���� ���谡 ����
-- �� PARTITION ���� ������ ORDER BY �� ���� ������ �Ŀ�
-- �� ������� ������ �ο���

-- ���, �̸�, �޿�, �Ի���, ����
-- ��, ������ �޿��� ���� ������, ���� �޿��� �Ի����� ���� �������
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, 
        ROW_NUMBER() OVER (ORDER BY SALARY DESC, HIRE_DATE ASC) ����
FROM EMPLOYEE;

-- �����Լ� ******************************
-- EMPLOYEE ���̺�� ���� �μ��ڵ尡 '60'�� ��������
-- ���, �޿�, �ش� �μ��׷�(�������� ��)�� ����� �������� �����ϰ�
SELECT EMP_ID, SALARY, 
        SUM(SALARY) OVER (PARTITION BY DEPT_ID
                             ORDER BY EMP_ID
                             ROWS BETWEEN UNBOUNDED PRECEDING
                             AND UNBOUNDED FOLLOWING) "WIN1",
-- �޿��� �հ踦 ù����� ����������� ���ؼ� "WIN1" ��,
-- �������� ù�� : UNBOUNDED PRECEDING
-- �������� �������� : UNBOUNDED FOLLOWING
        SUM(SALARY) OVER (PARTITION BY DEPT_ID
                             ORDER BY EMP_ID
                             ROWS BETWEEN UNBOUNDED PRECEDING
                             AND CURRENT ROW) "WIN2",
-- �������� �����࿡�� ���� ��ġ(CURRENT ROW) ������ �հ踦 ���ؼ� "WIN2"��
        SUM(SALARY) OVER (PARTITION BY DEPT_ID
                             ORDER BY EMP_ID
                             ROWS BETWEEN CURRENT ROW
                             AND UNBOUNDED FOLLOWING) "WIN3"
-- ���� ��ġ���� ���������� ������������� �հ踦 ���ؼ� "WIN3" �� ��ȸ
FROM EMPLOYEE
WHERE DEPT_ID = '60';


SELECT EMP_ID, SALARY, 
        SUM(SALARY) OVER (PARTITION BY DEPT_ID
                             ORDER BY EMP_ID
                             ROWS BETWEEN 1 PRECEDING
                             AND 1 FOLLOWING) "WIN1",
-- �޿��� �հ踦 ���� ���� �߽����� ������� ��������� ���ؼ� "WIN1" ��,
-- 1 PRECEDING AND 1 FOLLOWING
        SUM(SALARY) OVER (PARTITION BY DEPT_ID
                             ORDER BY EMP_ID
                             ROWS BETWEEN 1 PRECEDING
                             AND CURRENT ROW) "WIN2",
-- �������� ������� ���� ��ġ(CURRENT ROW) ������ �հ踦 ���ؼ� "WIN2"��
-- 1 PRECEDING AND CURRENT ROW
        SUM(SALARY) OVER (PARTITION BY DEPT_ID
                             ORDER BY EMP_ID
                             ROWS BETWEEN CURRENT ROW
                             AND 1 FOLLOWING) "WIN3"
-- ���� ��ġ���� ���������� ����������� �հ踦 ���ؼ� "WIN3" �� ��ȸ
-- CURRENT ROW AND 1 FOLLOWING
FROM EMPLOYEE
WHERE DEPT_ID = '60';


-- RATIO_TO_REPORT() **********************
-- �ش� �������� �����ϴ� ������ �����ϴ� �Լ�

-- �������� �ѱ޿��� 2õ���� ���� ��ų ��, 
-- ���� �޿� ������ �����ؼ� �� ������ �޿� �λ�� ��ȸ
SELECT EMP_NAME, SALARY,
        LPAD(TRUNC(RATIO_TO_REPORT(SALARY) OVER () * 100, 0), 5) 
            || ' %' �޿�����,
        TO_CHAR(TRUNC(
            RATIO_TO_REPORT(SALARY) OVER () * 20000000, 0), 
            'L00,999,999') �޿��λ��
FROM EMPLOYEE;

-- LAG(��ȸ�� ����, ������ġ, ����������ġ)
-- �����ϴ� �÷��� ���� ���� �������� ���� ��(���� ��)�� ���� ��ȸ��
SELECT EMP_NAME, DEPT_ID, SALARY,
        LAG(SALARY, 1, 0) OVER (ORDER BY SALARY) "��ȸ1",
        -- 1 : �ٷ� ���� ���� ��, 0 : �������� ������ 0 ó����
        LAG(SALARY, 1, SALARY) OVER (ORDER BY SALARY) "��ȸ2",
        -- �������� ������, ���� ���� ���� ���
        LAG(SALARY, 1, SALARY) OVER (PARTITION BY DEPT_ID
                                        ORDER BY SALARY) "��ȸ3"
        -- �μ� �׷� �ȿ����� �����ప ���
FROM EMPLOYEE;

-- LEAD(��ȸ�� ����, �������, 0 �Ǵ� �÷���)
-- ���� ���� �� ��ȸ
SELECT EMP_NAME, DEPT_ID, SALARY,
        LEAD(SALARY, 1, 0) OVER (ORDER BY SALARY) "��ȸ1",
        -- 1 : ���� ���� ��, 0 : �������� ������ 0 ó����
        LEAD(SALARY, 1, SALARY) OVER (ORDER BY SALARY) "��ȸ2",
        -- �������� ������, ���� ���� ���� ���
        LEAD(SALARY, 1, SALARY) OVER (PARTITION BY DEPT_ID
                                        ORDER BY SALARY) "��ȸ3"
        -- �μ� �׷� �ȿ����� �����ప ���
FROM EMPLOYEE
ORDER BY DEPT_ID;












