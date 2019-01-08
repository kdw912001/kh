-- DAY7

-- SET OPERATOR (���� ������)
-- UNION, UNION ALL, INTERSECT, MINUS
-- UNION, UNION ALL (������) : ���� ���� SELECT ���� ����� �ϳ��� ��ħ
-- INTERSECT (������) : ���� ���� SELECT ������� ����� �ุ ���
-- MINUS (������) : ù��° SELECT ������� �ι�° SELECT ����� ��ġ��
--       ��ġ�ϴ� �κ��� �� ����� ������

SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
UNION ALL
SELECT EMP_ID, ROLE_NAME
FROM ROLE_HISTORY;


SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
INTERSECT
SELECT EMP_ID, ROLE_NAME
FROM ROLE_HISTORY;


SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
MINUS
SELECT EMP_ID, ROLE_NAME
FROM ROLE_HISTORY;

-- SET ������ ���� ���ǻ���
-- SELECT ���� �÷��� ������ ���ƾ� �� : ����(DUMMY) �÷��� �̿���
-- SELECT ���� �� �׸񺰷� �ڷ����� ���ƾ� ��
SELECT EMP_NAME, JOB_ID, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_ID = '20'
UNION
SELECT DEPT_NAME, DEPT_ID, NULL
FROM DEPARTMENT
WHERE DEPT_ID = '20';

-- 50�� �μ��� �Ҽӵ� ���� �� �����ڿ� �Ϲ� ������ ���� ��ȸ�ؼ� �ϳ��� ���Ķ�.
SELECT * FROM EMPLOYEE WHERE DEPT_ID = '50';

SELECT EMP_ID, EMP_NAME, '������' ����
FROM EMPLOYEE
WHERE DEPT_ID = '50' AND EMP_ID = '141'
UNION
SELECT EMP_ID, EMP_NAME, '����' ����
FROM EMPLOYEE
WHERE DEPT_ID = '50' AND EMP_ID <> '141'
ORDER BY 3, 1;


SELECT 'SQL�� �����ϰ� �ֽ��ϴ�' ����, 3 ���� FROM DUAL
UNION
SELECT '�츮�� ���� ', 1 FROM DUAL
UNION
SELECT '���� ����ְ� ', 2 FROM DUAL
ORDER BY 2;

-- ���� �����ڿ� JOIN�� ����
SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
INTERSECT
SELECT EMP_ID, ROLE_NAME
FROM ROLE_HISTORY;

-- ���α������� USING (EMP_ID, ROLE_NAME) �� �ǹ�
-- �� �÷��� ���� �ϳ��� ������ �����ϰ� ��ġ�ϴ� �׸��� ã��.
-- (104 SE) = (104 SE) : ���� ��
-- (104 SE-ANLY) != (104 SE) : �ٸ� ��

-- ���� �������� ���α������� �ٲٸ�
SELECT EMP_ID, ROLE_NAME
FROM EMPLOYEE_ROLE
JOIN ROLE_HISTORY USING (EMP_ID, ROLE_NAME);

-- ���� �����ڿ� IN �������� ����
-- UNION �� IN �� ���� ������ ����� ���� �� ����

-- ������ �븮 �Ǵ� ����� ������ �̸��� ���޸� ��ȸ
-- ���޼� �������������ϰ�, ������ ������ �̸��� ������������ ó����
SELECT EMP_NAME, JOB_TITLE
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE IN ('�븮', '���')
ORDER BY 2, 1;

-- UNION ���� �ٲٸ�
SELECT EMP_NAME, JOB_TITLE
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE = '�븮'
UNION
SELECT EMP_NAME, JOB_TITLE
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE = '���'
ORDER BY 2, 1;

-- ************************************************
/*
�޼ҵ�(���ϰ��� �ִ� �޼ҵ�())
�÷��� �񱳿����� ���Ұ�  <--- ���� ���� �˾Ƴ������� SELECT ����
                          �� ��� ��ġ�� �ٷ� �� �� ����
�÷��� �񱳿����� (SELECT .... )                          
*/

-- �������� (SUB QUERY)
-- ������ �ȿ� ���� ������

-- �� : ���¿� �̶�� ������ ���� �μ��� �Ҽӵ� �������� ��� ��ȸ
-- 1. ���¿��� �Ҽӵ� �μ� ��ȸ
SELECT DEPT_ID
FROM EMPLOYEE
WHERE EMP_NAME = '���¿�';  -- 50�� �μ�

-- 2. ��ȸ�� ������� ����ؼ� �μ����� ��ȸ
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_ID = '50';

-- ���������� �̿��ϸ�
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_ID = (SELECT DEPT_ID
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '���¿�');

-- ���������� ������
-- ������ ��������, ������ ��������, ���߿� ��������, ���߿� ������ ��������
-- ��ȣ���� ��������, ��Į�� �������� �� ���е�.
-- �������� �տ� �ٴ� �����ڰ� �޶���.

-- ������ �������� (SINGLE ROW SUBQUERY)
-- ���������� ������� �� ���� ���
-- ������ �������� �տ��� �Ϲ� �񱳿����� ��� ��� ������
-- <, >, <=, >=, =, != | <>  |^=

-- �� : ���¿��� ������ �����鼭, ���¿����� �޿��� ���� �޴� ���� ��ȸ
-- �̸�, ����, �޿� ��ȸ
-- 1. ���¿��� ���� ��ȸ
SELECT JOB_ID
FROM EMPLOYEE
WHERE EMP_NAME = '���¿�'; -- J5

-- 2. ���¿��� �޿� ��ȸ
SELECT SALARY
FROM EMPLOYEE
WHERE EMP_NAME = '���¿�'; -- 2300000

-- 3. ��� ��ȸ
SELECT EMP_NAME, JOB_ID, SALARY
FROM EMPLOYEE
WHERE JOB_ID = 'J5'
AND SALARY > 2300000;

-- ���������� �ٲ۴ٸ�
SELECT EMP_NAME, JOB_ID, SALARY
FROM EMPLOYEE
WHERE JOB_ID = (SELECT JOB_ID
                  FROM EMPLOYEE
                  WHERE EMP_NAME = '���¿�')
AND SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '���¿�');

-- �����޿��� �ް� �ִ� ���� ��ȸ
SELECT EMP_NAME, 
        JOB_ID,
        SALARY
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY)
                  FROM EMPLOYEE);

-- �μ��� �޿��հ� �� ���� ū �� ��ȸ
-- ���� ���� �޿��� �޾ư��� �μ� ��ȸ
SELECT DEPT_NAME, SUM(SALARY)
FROM EMPLOYEE
LEFT JOIN DEPARTMENT USING (DEPT_ID)
GROUP BY DEPT_NAME
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                        FROM EMPLOYEE
                        GROUP BY DEPT_ID);  -- ������ ��������

-- ���������� SELECT��, FROM��, WHERE��, GROUP BY��, HAVING��,
-- ORDER BY������ ��� ��� ������


-- ������(MULTIPLE ROW) �������� ***************
-- �������� ������� ������ ���� ���� ���

-- �� : �μ��� �޿� ������ ��ȸ
SELECT MIN(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_ID;

-- �μ����� �� �μ��� �����޿��� �ް� �ִ� ���� ��ȸ
SELECT EMP_ID, SALARY
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY)
                  FROM EMPLOYEE
                  GROUP BY DEPT_ID); -- ������ ��������

/*
������ �������� �տ��� �Ϲ� �񱳿����� ��� �� ��
�Ϲ� �񱳿����ڴ� �� ���� ���� ������ �� �Ǵ���.

������ �������� �տ� ����� �� �ִ� �����ڴ�
�÷��� IN (������ ��������) : ���� ���� ���߿��� �� ���� ��ġ�ϴ� ���� �ִٸ�...
�÷��� NOT IN (������ ��������) : ���� ���� ���� �� ���� ��ġ���� �ʴ´ٸ�...

�÷��� > ANY (������ ��������) : ���� ���� �ϳ��� ũ��?
                    ���� ���� ������ ũ��?
�÷��� < ANY (������ ��������) : ���� ���� �ϳ��� ������?
                    ���� ū ������ ������?
                    
�÷��� > ALL (������ ��������) : ��� ������ ũ��? (���� ū ������ ũ��?)
�÷��� < ALL (������ ��������) : ��� ������ ������? (���� ���������� ������?)
*/

SELECT EMP_ID, DEPT_ID, SALARY
FROM EMPLOYEE
WHERE SALARY IN (SELECT MIN(SALARY)
                  FROM EMPLOYEE
                  GROUP BY DEPT_ID);

-- IN / NOT IN
-- ���� ���� ���� ���ؼ� ���� ���� �ִ��� / ���� ���� ������ ��
SELECT DISTINCT MGR_ID
FROM EMPLOYEE
WHERE MGR_ID IS NOT NULL;

-- ���� �������� �����ڸ� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, '������' ����
FROM EMPLOYEE
WHERE EMP_ID IN (SELECT MGR_ID FROM EMPLOYEE)
UNION
SELECT EMP_ID, EMP_NAME, '����' ����
FROM EMPLOYEE
WHERE EMP_ID NOT IN (SELECT MGR_ID FROM EMPLOYEE
                        WHERE MGR_ID IS NOT NULL)
ORDER BY 3, 1;  

-- SELECT �������� �������� ����� �� ����
SELECT EMP_ID, EMP_NAME,
        CASE
        WHEN EMP_ID IN (SELECT MGR_ID FROM EMPLOYEE) THEN '������'
        ELSE '����'
        END ����
FROM EMPLOYEE
ORDER BY 3, 1;









