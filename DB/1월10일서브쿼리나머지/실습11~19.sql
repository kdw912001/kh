--11번 --출력이 이상
SELECT SUBSTR(TERM_NO,1,4) 년도, ROUND(AVG(POINT),1) 평점
FROM TB_GRADE
WHERE STUDENT_NO IN (SELECT STUDENT_NO
                    FROM TB_STUDENT
                    WHERE COACH_PROFESSOR_NO = 'P095')
GROUP BY SUBSTR(TERM_NO,1,4)
ORDER BY 1 DESC;

SELECT STUDENT_NAME,STUDENT_NO
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO = 'P095';

SELECT SUBSTR(TERM_NO,1,4) 년도, ROUND(AVG(POINT),1) 평점
FROM TB_GRADE
WHERE STUDENT_NO IN ('A213046','9847024','A015282','A515015','A211278')
GROUP BY SUBSTR(TERM_NO,1,4)
ORDER BY 1 DESC;

--12번 답 확인 해야 함
SELECT DEPARTMENT_NAME 학과명, STUDENT_NAME 학생명, ENTRANCE_DATE 입학일자
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE ENTRANCE_DATE BETWEEN '01/01/01' AND SYSDATE
AND SUBSTR(STUDENT_SSN,8,1)='1'
AND ABSENCE_YN = 'Y'
ORDER BY ENTRANCE_DATE DESC;

--13번 

--선생님
SELECT PROFESSOR_NAME, COUNT(*)
FROM TB_STUDENT
JOIN TB_PROFESSOR ON (PROFESSOR_NO = COACH_PROFESSOR_NO)
LEFT JOIN TB_CLASS_PROFESSOR USING(PROFESSOR_NO)
WHERE CLASS_NO IS NULL
GROUP BY PROFESSOR_NAME;

--내가 한거
SELECT PROFESSOR_NAME, COUNT(*)
FROM TB_STUDENT
JOIN TB_PROFESSOR ON (PROFESSOR_NO = COACH_PROFESSOR_NO)
WHERE PROFESSOR_NO IN(
    SELECT PROFESSOR_NO
    FROM TB_PROFESSOR
    MINUS
    SELECT DISTINCT PROFESSOR_NO
    FROM TB_CLASS
    JOIN TB_CLASS_PROFESSOR USING (CLASS_NO))
GROUP BY PROFESSOR_NAME;

--14
SELECT STUDENT_NAME, TERM_NO, POINT
FROM TB_GRADE
JOIN TB_STUDENT USING (STUDENT_NO)
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE CATEGORY LIKE '%공학%' AND 
POINT IN (SELECT SUBSTR(TERM_NO,1,4),AVG(POINT)
        FROM TB_GRADE
        WHERE SUBSTR(TERM_NO,1,4)='2009'
        GROUP BY SUBSTR(TERM_NO,1,4));
--TERM_NO LIKE '2009%'
--AND POINT >= 4.0;


SELECT STUDENT_NAME,TERM_NO, ROUND(AVG(POINT),1)
FROM TB_GRADE
JOIN TB_STUDENT USING (STUDENT_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE TERM_NO LIKE '2009%' AND CATEGORY = '공학'
GROUP BY STUDENT_NAME,TERM_NO
HAVING AVG(POINT) >= 4.0;

--15
SELECT SUBSTR(TERM_NO,1,4), SUBSTR(TERM_NO,5,2), ROUND(AVG(POINT),1)
FROM TB_GRADE
JOIN TB_STUDENT USING (STUDENT_NO)
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE SUBSTR(TERM_NO,1,4) IN (2007,2008) AND
    DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                        FROM TB_DEPARTMENT
                        JOIN TB_STUDENT USING(DEPARTMENT_NO)
                        WHERE STUDENT_NAME = '김고운')
GROUP BY ROLLUP(SUBSTR(TERM_NO,1,4), SUBSTR(TERM_NO,5,2));

--16
SELECT SUBSTR(TERM_NO,1,4), SUBSTR(TERM_NO,5,2), TO_CHAR(ROUND(AVG(POINT),1),'9.9')
FROM TB_GRADE
JOIN TB_CLASS USING (CLASS_NO)
WHERE SUBSTR(TERM_NO,1,4) = '2004' AND
        DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                        FROM TB_CLASS
                        WHERE CLASS_NAME = '문학과생태학')
GROUP BY ROLLUP(SUBSTR(TERM_NO,1,4), SUBSTR(TERM_NO,5,2));

--17
SELECT STUDENT_NAME 학생이름, PROFESSOR_NAME 지도교수
FROM TB_STUDENT
JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
WHERE STUDENT_NO LIKE 'A__3___'
AND PROFESSOR_NAME LIKE '이%'
ORDER BY 1;

--18
SELECT CATEGORY 계열, DEPARTMENT_NAME 학과이름, COUNT(*) 학생수 
FROM TB_DEPARTMENT
JOIN TB_STUDENT USING(DEPARTMENT_NO)
WHERE CATEGORY IN('예체능','의학')
GROUP BY CATEGORY, DEPARTMENT_NAME
ORDER BY 1,3 DESC;

--19
(SELECT CLASS_NAME
                        FROM TB_CLASS
                        WHERE PREATTENDING_CLASS_NO IS NOT NULL
                        );
SELECT CLASS_NAME 과목, PREATTENDING_CLASS_NO
FROM TB_CLASS
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '행정학과';