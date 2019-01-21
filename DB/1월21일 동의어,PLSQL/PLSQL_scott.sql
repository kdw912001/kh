SET SERVEROUTPUT ON;
DECLARE
    box NUMBER;
BEGIN
    SELECT empno
    INTO box
    FROM emp
    WHERE ename='WARD';
    
    DBMS_OUTPUT.PUT_LINE(box);
EXCEPTION
    WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('No Data!!!');
END;
/

--변수에 값 대입 출력하기
DECLARE
EMPNO NUMBER(4);
ENAME VARCHAR2(10);
BEGIN
EMPNO := 1001;
ENAME := '김사랑';
DBMS_OUTPUT.PUT_LINE('        사번      이름');
DBMS_OUTPUT.PUT_LINE('----------------------');
DBMS_OUTPUT.PUT_LINE('  '||EMPNO||'    '||ENAME);
END;
/

--PL/SQL SELECT 문
SET SERVEROUTPUT ON;
DECLARE
        VEMPNO EMP.EMPNO%TYPE;
        VENAME EMP.ENAME%TYPE;
BEGIN
        SELECT EMPNO, ENAME
        INTO VEMPNO, VENAME
        FROM EMP
        WHERE ENAME = 'ALLEN';
        DBMS_OUTPUT.PUT_LINE('사번      이름');
        DBMS_OUTPUT.PUT_LINE('---------------------');
        DBMS_OUTPUT.PUT_LINE(VEMPNO||'   '||VENAME);
END;
/

SET SERVEROUTPUT ON;

DECLARE
    VEMPNO EMP.EMPNO%TYPE;
    VENAME EMP.ENAME%TYPE;
    VSAL EMP.SAL%TYPE;
    VHIREDATE EMP.HIREDATE%TYPE;
BEGIN
    SELECT EMPNO, ENAME, SAL, HIREDATE
    INTO VEMPNO, VENAME, VSAL, VHIREDATE
    FROM EMP
    WHERE EMPNO = '&EMPNO';
    SYS.DBMS_OUTPUT.PUT_LINE(VENAME||' '||VSAL||' '|| VHIREDATE);
END;
/

--PL SQL 선택문
DECLARE
    VEMPNO EMP.EMPNO%TYPE;
    VENAME EMP.ENAME%TYPE;
    VDEPTNO EMP.DEPTNO%TYPE;
    VDNAME VARCHAR2(20) := NULL;
BEGIN
    SELECT EMPNO, ENAME, DEPTNO
    INTO VEMPNO, VENAME, VDEPTNO
    FROM EMP
    WHERE EMPNO = &EMPNO;
    
    IF(VDEPTNO = 10) THEN
        VDNAME := 'ACCOUNTING';
    END IF;
    IF(VDEPTNO = 20) THEN
        VDNAME := 'RESEARCH';
    END IF;
    IF(VDEPTNO = 30) THEN
        VDNAME := 'SALES';
    END IF;
    IF (VDEPTNO = 40) THEN
        VDNAME := 'OPERATIONS';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('사번    이름   부서명');
    DBMS_OUTPUT.PUT_LINE('----------------------');
    DBMS_OUTPUT.PUT_LINE(VEMPNO||'   '||VENAME||'  '||VDNAME);
END;
/

DECLARE
    VEMP EMP%ROWTYPE;
    ANNSAL NUMBER(7,2);
BEGIN
    SELECT * INTO VEMP
    FROM EMP
    WHERE ENAME = '&ENAME';
    
    IF(VEMP.COMM IS NULL) THEN
        ANNSAL := VEMP.SAL * 12;
    ELSE
        ANNSAL := VEMP.SAL * 12 + VEMP.COMM;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('사번   이름   연봉');
    DBMS_OUTPUT.PUT_LINE('----------------');
    DBMS_OUTPUT.PUT_LINE(VEMP.EMPNO||' '||VEMP.ENAME||'     '||ANNSAL);
END;
/

--특정사원이 커미션을 받는지에 대한 실습
DECLARE
    VEMPNO EMP.EMPNO%TYPE;
    VCOMM EMP.COMM%TYPE;
    VENAME EMP.ENAME%TYPE;
BEGIN
    SELECT EMPNO, ENAME, COMM
    INTO VEMPNO, VENAME, VCOMM
    FROM EMP
    WHERE EMPNO = &EMPNO;
    
    IF(VCOMM IS NULL OR VCOMM = 0) THEN
        DBMS_OUTPUT.PUT_LINE('사번'||VEMPNO||'은 '||VENAME||'사원이고 커미션을 받지 않습니다.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('사번'||VEMPNO||'은 '||VENAME||'사원이고'||VCOMM||'을 받습니다.');
    END IF;
END;
/

DECLARE
    VEMP EMP%ROWTYPE;
    VDNAME VARCHAR2(14);
BEGIN
    SELECT * INTO VEMP
    FROM EMP
    WHERE ENAME = '&ENAME';
    
    IF(VEMP.DEPTNO = 10) THEN
        VDNAME := 'ACCOUNTING';
    ELSIF(VEMP.DEPTNO = 20) THEN
        VDNAME := 'RESEARCH';
    ELSIF(VEMP.DEPTNO = 30) THEN
        VDNAME := 'SALES';
    ELSIF(VEMP.DEPTNO = 40) THEN
        VDNAME := 'OPERATIONS';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('사번   이름   부서명');
    DBMS_OUTPUT.PUT_LINE('----------------------');
    DBMS_OUTPUT.PUT_LINE(VEMP.EMPNO||' '||VEMP.ENAME||'    '||VDNAME);
END;
/

DECLARE
    score int;
    grade varchar2(2);
BEGIN
    score := &score;
    IF score >= 90 THEN
            Grade := 'A';
    ELSIF score >= 80 THEN
            Grade := 'B';
    ELSIF score >= 70 then
            grade := 'C';
    ELSIF score >= 60 then
            grade := 'D';
    ELSE grade := 'F';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('당신의 SCOR는 '||score||'점이고,'||'Grade는 '||grade||'입니다.');
END;
/

--CASE 문

DECLARE
    vempno EMP.EMPNO%TYPE;
    vename EMP.ENAME%TYPE;
    vdeptno EMP.DEPTNO%TYPE;
    vdname VARCHAR(20) := null;
BEGIN
    SELECT EMPNO, ENAME, DEPTNO
    INTO vempno, vename, vdeptno
    FROM EMP
    WHERE EMPNO = &EMPNO;
    
    vdname := CASE vdeptno
                WHEN 10 THEN 'ACCOUNT'
                WHEN 20 THEN 'RESEARCH'
                WHEN 30 THEN 'SALES'
                WHEN 40 THEN 'OPERATIONS'
            END;
    DBMS_OUTPUT.PUT_LINE(VEMPNO ||' '||VENAME||' '||VDEPTNO||' '||VDNAME);
END;
/

--PL/SQL의 반복문

DECLARE
    N NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N + 1;
        IF N > 5 THEN
            EXIT;
        END IF;
    END LOOP;
END;
/

DECLARE
BEGIN
FOR N IN 1..5 LOOP
DBMS_OUTPUT.PUT_LINE(N);
END LOOP;
END;
/

CREATE TABLE test1(bunho number(3), irum varchar2(10));

BEGIN
FOR i IN 1..10 LOOP
INSERT INTO test1 values(i, SYSDATE);
END LOOP;
END;
/

SELECT * FROM test1;

--구구단의 홀수단만 출력(FOR, IF 문 혼합)
DECLARE
    RESULT NUMBER;
BEGIN
    FOR DAN IN 2..9 LOOP
        IF MOD(DAN, 2) = 1 THEN
            FOR N IN 1..9 LOOP
                RESULT := DAN * N;
                DBMS_OUTPUT.PUT_LINE(DAN||'*'||N||' = '||RESULT);
            END LOOP;
            DBMS_OUTPUT.PUT_LINE('');
        END IF;
    END LOOP;
END;
/

--WHILE LOOP문으로 1부터 5까지 출력
DECLARE
    N NUMBER := 1;
BEGIN
    WHILE N <= 5 LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N + 1;
    END LOOP;
END;
/

--구구단 2~9단에서 결과가 홀수인 것만 출력 (WHILE)
DECLARE
    RESULT NUMBER;
    DAN NUMBER := 2;
    SU NUMBER;
BEGIN
    WHILE DAN <= 9 LOOP
        SU := 1;
        WHILE SU <= 9 LOOP
            RESULT := DAN * SU;
            IF MOD(RESULT,2) = 1 THEN
                DBMS_OUTPUT.PUT_LINE(DAN||'*'||SU||' = '|| RESULT);
            END IF;
            SU := SU + 1;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE(' ');
        DAN := DAN + 1;
    END LOOP;
END;
/

--예외처리
INSERT INTO EMP (EMPNO, ENAME)
VALUES (9999, 'ROSA-MADONA');
-- ORA-12899 에러 발생 : 컬럼 지정 바이트 사이즈 초과됨
-- value too large for column

-- PL/SQL 구문에서 오류코드에 예외이름 지어주고 사용하기
SET SERVEROUTPUT ON;
DECLARE
    TOOLONG_NAME EXCEPTION;
    PRAGMA EXCEPTION_INIT(TOOLONG_NAME, -12899); 
BEGIN
    INSERT INTO EMP (EMPNO, ENAME)
    VALUES (SEQ_ENO.NEXTVAL, '&ENAME');
    COMMIT;
EXCEPTION
    WHEN TOOLONG_NAME THEN 
        DBMS_OUTPUT.PUT_LINE('기록될 사원명의 글자가 10바이트를 초과하였습니다.');
END;
/--사원명이 10바이트 이하면 EMP테이블에 INSERT하고 10바이트를 초과하면 에러메시지 출력

SELECT * FROM EMP;

CREATE SEQUENCE SEQ_ENO
START WITH 8200
INCREMENT BY 1
MAXVALUE 9999
NOCYCLE
NOCACHE;

--p26에 있는 아이디와 암호를 입력받는 실습
DECLARE
     VID VARCHAR2(14) := 'STUDENT0123';
     V_ID VARCHAR2(14);
     V_PWD VARCHAR2(14); 
     
     TOOLONG EXCEPTION;
     TOOSHORT EXCEPTION;
     
     PRAGMA EXCEPTION_INIT(TOOLONG, -12899);
     PRAGMA EXCEPTION_INIT(TOOSHORT, -20001);
BEGIN
     V_ID := '&ID';
     V_PWD := '&PWD';
    
     IF (LENGTH(V_ID) < 10 OR LENGTH(V_PWD) < 10) THEN
        RAISE_APPLICATION_ERROR(-20001, '글자 갯수 부족');
     END IF;

     IF VID = V_ID THEN
        RAISE DUP_VAL_ON_INDEX;
     END IF;

EXCEPTION 
     WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('아이디가 중복되었습니다.');
     WHEN TOOLONG THEN
        DBMS_OUTPUT.PUT_LINE('글자 갯수 범위 초과');
     WHEN TOOSHORT THEN
        DBMS_OUTPUT.PUT_LINE('글자 갯수 부족.');
     WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('알수 없는 오류가 발생하였습니다.');
END;
/  