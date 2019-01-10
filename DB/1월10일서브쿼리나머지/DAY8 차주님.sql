-- DAY8

-- ������ ���������� ����� �� �ִ� ������
-- IN/NOT IN, ANY, ALL

-- �÷��� > ANY (������ ��������) : �������� ���� �߿� �ּҰ����� ũ��?
-- �÷��� < ANY (������ ��������) : �������� ���� �߿� �ִ밪���� ������?

-- �븮 ������ ���� �߿��� ���� ���� �޿��� �ּҰ����� ���� �޴� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE = '�븮'
AND SALARY > ANY (SELECT SALARY
                    FROM EMPLOYEE
                    JOIN JOB USING (JOB_ID)
                    WHERE JOB_TITLE = '����');

-- �÷��� > ALL (������ ��������) : �÷����� �������� �������� ���ؼ� 
--                          ���� ū ������ ũ��?
-- �÷��� < ALL (������ ��������) : �÷����� �������� �������� ���ؼ�
--                          ���� ���� ������ ������?

-- ���� ������ �޿� �� ���� ū ������ �޿��� ���� �޴� �븮 ���� ��ȸ
SELECT EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_ID)
WHERE JOB_TITLE = '�븮'
AND SALARY > ALL (SELECT SALARY
                    FROM EMPLOYEE
                    JOIN JOB USING (JOB_ID)
                    WHERE JOB_TITLE = '����');

-- ���������� ��� ��ġ
-- SELECT ��, FROM ��, WHERE ��, GROUP BY ��, HAVING ��,
-- ORDER BY ��, INSERT ��, UPDATE ��, CREATE TABLE ��
-- CREATE VIEW ��

-- �ڱ� ������ ��� �޿��� �޴� ���� ��ȸ
-- 1. WHERE ������ ����� ��������
SELECT JOB_ID, TRUNC(AVG(SALARY), -5)
FROM EMPLOYEE
GROUP BY JOB_ID;

SELECT EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE
LEFT JOIN JOB USING (JOB_ID)
WHERE SALARY IN (SELECT TRUNC(AVG(SALARY), -5)
                    FROM EMPLOYEE
                    GROUP BY JOB_ID
                    );

-- 2. FROM ������ ����� ��������
-- FROM ���̺��  >>>> FROM (��������)
-- ���̺��� �����
-- �ζ��� ��(INLINE VIEW) : FROM ���� ���� ���������� �������
-- ���� ó���� ����Ŭ ���뱸���� ANSI ǥ�ر����� ON ���ÿ� ���̺� ��Ī ��밡��

SELECT EMP_NAME, JOB_TITLE, SALARY
FROM (SELECT JOB_ID, TRUNC(AVG(SALARY), -5) JOBAVG
        FROM EMPLOYEE
        GROUP BY JOB_ID) V -- �ζ��� ��
LEFT JOIN EMPLOYEE E ON (V.JOBAVG = E.SALARY 
                            AND NVL(V.JOB_ID, ' ') = NVL(E.JOB_ID, ' '))
LEFT JOIN JOB J ON (E.JOB_ID = J.JOB_ID)
ORDER BY 3, 2;


/*
���������� ����
������ �������� : ������� �׸� 1���� �� 1��
������ �������� : ������� �׸� 1���� �� ���� ��
���߿� ������ �������� : ������� �׸��� ���� �� ���� 1��
���߿� ������ �������� : ������� �׸� ���� ��, �� ������
=> ��κ��� ���������� ���������� ���� ���� ���� ������ ����ϴ� ������

��[ȣ��]�� �������� : ���������� ���������� ���� �����ٰ� ����� ����
            ���������� ���� ���� ���������� ����� �޶���
��Į�� �������� : ������� + ������ ��������
*/

-- 3. ��[ȣ��]�� �������� ���
SELECT EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE E
LEFT JOIN JOB J ON (E.JOB_ID = J.JOB_ID)
WHERE SALARY = (SELECT TRUNC(AVG(SALARY), -5)
                  FROM EMPLOYEE
                  WHERE NVL(JOB_ID, ' ') = NVL(E.JOB_ID, ' '))
ORDER BY 2;

-- 4, ���߿� ������ �������� ���
SELECT EMP_NAME, JOB_TITLE, SALARY
FROM EMPLOYEE
LEFT JOIN JOB USING (JOB_ID)
WHERE (NVL(JOB_ID, ' '), SALARY) IN (SELECT NVL(JOB_ID, ' '), TRUNC(AVG(SALARY), -5)
                                      FROM EMPLOYEE
                                      GROUP BY NVL(JOB_ID, ' '))
ORDER BY 2;

-- EXISTS / NOT EXISTS ������
-- ����������� ����ϴ� ��������
-- ���������� ����� �����ϴ��� / �������� �ʴ��� ����� ��������.

-- �������� ���� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, '������' ����
FROM EMPLOYEE E
WHERE EXISTS (SELECT NULL
                FROM EMPLOYEE
                WHERE E.EMP_ID = MGR_ID);
-- ���������� ������ �����Ѵ� ��鸸 ���

-- �����ڰ� �ƴ� ���� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, '����' ����
FROM EMPLOYEE E
WHERE NOT EXISTS (SELECT NULL
                    FROM EMPLOYEE
                    WHERE E.EMP_ID = MGR_ID);
-- �������� �������� ��ġ���� �ʴ� ���� ���

-- ��Į�� ��������
-- �� �÷��� �Ѱ��� �ุ ����� ��ȯ�ϴ� �������
-- ������� + ������ ��������

-- �����, �μ��ڵ�, �޿�, �ش� ������ �Ҽӵ� �μ��� �޿���� ��ȸ
-- SELECT ������ ����� ���
SELECT EMP_NAME, DEPT_ID, SALARY, 
        (SELECT TRUNC(AVG(SALARY), -5)  -- �׸� 1�� ��հ� 1��
         FROM EMPLOYEE
         WHERE DEPT_ID = E.DEPT_ID) AS AVGSAL
FROM EMPLOYEE E;

-- CASE ǥ���Ŀ� �������� ����� ���
-- �μ��� �ٹ������� 'OT'�̸� '������', �ƴϸ� '������' ����
-- ������ �ٹ������� ���� �Ҽ��� ��ȸ
SELECT EMP_ID, EMP_NAME,
        CASE
        WHEN DEPT_ID = (SELECT DEPT_ID
                          FROM DEPARTMENT
                          WHERE LOC_ID = 'OT') THEN '������'
        ELSE '������'
        END AS �Ҽ�
FROM EMPLOYEE
ORDER BY �Ҽ� DESC;

-- ORDER BY ���� ��Į�� �������� ��� ����

-- ������ �Ҽӵ� �μ��� �μ����� ū ������ ���ĵǰ� ���� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_ID, HIRE_DATE
FROM EMPLOYEE E
ORDER BY (SELECT DEPT_NAME
            FROM DEPARTMENT
            WHERE DEPT_ID = E.DEPT_ID) DESC NULLS LAST;


-- TOP-N �м� ***************************
-- ���� �� ��, ���� �� ���� ��ȸ�� ��

-- �ζ��� ��� RANK() �Լ��� �̿��� TOP-N �м��� ��
-- �� : ���� �������� �޿��� ���� ���� �޴� ���� 5�� ��ȸ
SELECT *
FROM (SELECT EMP_NAME, SALARY, 
               RANK() OVER (ORDER BY SALARY DESC) ����
        FROM EMPLOYEE) -- �ζ��� ��
WHERE ���� <= 5;

-- ROWNUM �� �̿��� TOP-N �м�
SELECT ROWNUM, EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE SALARY > 3500000
ORDER BY EMP_NAME ASC;

-- ROWNUM(���ȣ) �� �ο��Ǵ� ������ FROM �� ����.
-- ORDER BY �ϸ� ���ȣ ���� �ȵǰ� ����.
-- �ذ� : ORDER BY �� ������ ROWNUM �� �ο��ǰ� �Ϸ���
--       FROM ���� ���������� ����� (�ζ��κ� �̿�)

-- �� : �޿��� ���� �޴� ���� 3�� ��ȸ  : �׳� ��ȸ
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE ROWNUM < 4
ORDER BY SALARY DESC;
-- �޿� �������� ���� ���� ROWNUM �� ������
-- ���� ����� Ʋ��

-- �ذ� : ���ĵǰ� ���� ROWNUM �� �ο��ǰԲ� �ϸ� ������
-- �ζ��κ並 �̿���
SELECT ROWNUM, EMP_NAME, SALARY 
FROM (SELECT *
       FROM EMPLOYEE
       ORDER BY SALARY DESC)  -- ���� �Ŀ� ROWNUM �� �ο���
WHERE ROWNUM < 4;       









