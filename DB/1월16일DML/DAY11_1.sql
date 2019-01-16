
 --DAY12********************************
 
 --DELETE 문
 --행을 삭제하는 구문
 /*
 DELETE [FROM] 테이블명
 WHERE 조건식;
 */
 
 -- WHERE 절을 사용하지 않으면, 테이블의 모든 행이 삭제됨
 SELECT * FROM DCOPY;
 
 DELETE FROM DCOPY; --복구할 수 있음
 ROLLBACK; --DELETE 취소
 
 -- 다른 테이블에서 FOREIGN KEY 로 참조되고 있는 테이블일 경우
 DELETE FROM DEPARTMENT
 WHERE DEPT_ID = '90';
 --참조되고 있는 (사용되고 있는) 값이 기록된 행은 삭제 못 함.
 
 DELETE FROM DEPARTMENT 
 WHERE DEPT_ID = '30';
 --참조테이블에서 사용되지 않는 값에 대한 행은 삭제할 수 있음.
 
 SELECT * FROM DEPARTMENT;
 ROLLBACK;
 
 -- TRUNCATE 문
 -- 테이블의 모든 행 삭제시 사용함. DELETE보다 속도가 빠름
 -- 복구(ROLLBACK) 불가능, 제약조건이 있으면 삭제 못 함
 TRUNCATE TABLE DCOPY;
 
 SELECT * FROM DCOPY;
 
 ROLLBACK; --TRUNCATE는 복구 불가
 
 TRUNCATE TABLE DEPARTMENT; --ERROR : 제약조건이 있기 때문에 삭제불가
 
 --***************************************************
 -- TCL (Transaction Controll Language) : 트랜잭션 관리 언어
 -- COMMIT, ROLLBACK, SAVEPOINT
 
 ALTER TABLE EMPLOYEE
 DISABLE CONSTRAINTS FK_MGRID; --DDL 구문 실행 : 새 트랙잭션 시작됨
 --제약조건을 해제하여 PARENT KEY 삭제할 수 있음
 
 SAVEPOINT S0;
 
 INSERT INTO DEPARTMENT
 VALUES ('40','기획전략팀','A1');
 
 SAVEPOINT S1;
 
 UPDATE EMPLOYEE
 SET DEPT_ID = '40'
 WHERE DEPT_ID IS NULL;
 
 SAVEPOINT S2;
 DELETE FROM EMPLOYEE; --TESTFK가 참조 되어있어 TESTFK를 삭제(아래 주석)
 
 ROLLBACK TO S2;
 
 SELECT * FROM EMPLOYEE;
 
-- SELECT CONSTRAINT_NAME, TABLE_NAME
-- FROM USER_CONSTRAINTS
-- WHERE CONSTRAINT_NAME = 'SYS_C007332';
-- 
-- DROP TABLE TESTFK CASCADE CONSTRAINTS;

SELECT COUNT(*)
FROM EMPLOYEE
WHERE DEPT_ID = '40';

ROLLBACK TO S0;

SELECT COUNT(*)
FROM EMPLOYEE
WHERE DEPT_ID = '40'; -- 0

ROLLBACK;

-- 동시성 제어 : 잠금 (LOCK)
SELECT EMP_ID, MARRIAGE
FROM EMPLOYEE
WHERE EMP_ID = '143';

UPDATE EMPLOYEE
SET MARRIAGE = 'Y'
WHERE EMP_ID = '143';

COMMIT;