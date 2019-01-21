-- PL/SQL
-- 오라클에서만 제공함
-- SQL 구문 실행에 프로그래밍 기능을 추가함

--출력 기능 작동 확인
SHOW SERVEROUTPUT;
--출력되게 값 변경
SET SERVEROUTPUT ON;

--한선기 직원의 사번과 이름 출력 : PLSQL BLOCK 사용
SET SERVEROUTPUT ON;
DECLARE --선언부 : 변수 선언
    --변수명 자료형;
    VEMPNO CHAR(3);
    VENAME VARCHAR2(20);
BEGIN
    -- 변수에 값 대입, 제어문, 출력문 처리
    SELECT EMP_ID, EMP_NAME
    INTO VEMPNO, VENAME
    FROM EMPLOYEE
    WHERE EMP_NAME = '한선기';
    
    SYS.DBMS_OUTPUT.PUT_LINE('사번      이름');
    SYS.DBMS_OUTPUT.PUT_LINE('--------------------------');
    SYS.DBMS_OUTPUT.PUT_LINE(VEMPNO || '         ' || VENAME);
END;
/

--사원을 입력받아 지원 정보 조회 출력 처리
SET SERVEROUTPUT ON;
DECLARE
    VEMPNO EMPLOYEE.EMP_ID%TYPE;
    VENAME EMPLOYEE.EMP_NAME%TYPE;
    VSAL EMPLOYEE.SALARY%TYPE;
    VHIREDATE EMPLOYEE.HIRE_DATE%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
    INTO VEMPNO, VENAME, VSAL, VHIREDATE
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    DBMS_OUTPUT.PUT_LINE(VEMPNO || '  ' || VENAME || '  ' || VSAL || '  ' || VHIREDATE);
END;
/

