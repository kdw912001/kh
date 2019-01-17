-- 사용자(USER) 관리
-- 사용자 계정(접속 아이디)과 암호 설정, 권한 부여

/*
오라클 데이터베이스를 설치하면, 기본적으로 제공되는 계정이 있음
    SYS | SYSTEM
    HR : 샘플 계정임, 처음에는 잠겨있음
    SCOTT : 교육용 샘플 계정임, 버전에 따라 없을 수도 있음. 11G에는 없음

데이터베이스 관리자 (DBA) 
  - 사용자에게 DB관련 객체(테이블, 뷰, 시퀀스, 인덱스 등)에 대한 권한을 부여함
  - 여러 사용자가 공유하는 데이터베이스에 보안 설정함
  - DB에 접근하는 사용자마다 서로 다른 롤을 부여함
  
 권한 : 사용자가 특정 테이블에 접근할 수 있도록 하거나,
     허용되는 테이블에 SQL문(SELECT/INSERT/UPDATE/DELETE)을
     사용할 수 있도록 제한을 두는 것.
     
     * 시스템 권한 : DBA가 가지고 있는 권한
        CREATE USER (사용자 계정 만들기)
        DROP USER (사용자 계정 삭제)
        DROP ANY TABLE (임의의 테이블 삭제)
        QUERY REWRITE (함수 기반 인덱스 생성)
        BACKUP ANY TABLE(테이블 백업)
        
        BACKUP ANY TABLE(테이블 백업)
    * DBA 가 사용자에게 부여하는 권한
        CREATE SESSION (DB에 접속)
        CREATE TABLE (테이블 생성)
        CREATE VIEW (뷰 생성)
        CREATE SEQUENCE (시퀀스 생성)
        CREATE PROCEDURE (프로시저 생성)
    * 객체 권한 : 객체를 조작할 수 있는 권한
*/

--사용자 계정 만들기
--데이터베이스에 접근할 수 있는 아이디와 암호 만들기
--형식
/*
CREATE USER 아이디 IENTIFIED BY 암호;
아이디와 암호는 대소문자 구분함
*/

--SYSTEM 계정에서
CREATE USER user01 IDENTIFIED BY pass01;

--로그인하면 에러남 : DB에 접속하는 권한(CREATE SESSION)이 없음

--권한 부여하기 : GRANT 명령어 사용
--GRANT 권한종류 TO 사용자아이디 [WITH ADMIN OPTION];
--사용자 아이디 대신에 PUBLIC을 사용하면 모든 사용자에게 권한을 준다는 의미임

--SYSTEM 계정에서
GRANT CREATE SESSION TO user01;

--SYSTEM 계정에서 user01에게 create table 하는 권한을 부여함
GRANT CREATE TABLE TO user01;

--테이블 만들기 하면 에러남 : 테이블 스페이스를 할당받아야 함

--테이블 스페이스(TableSpace)
--테이블, 뷰, 그 밖의 데이터 베이스 객체들이 저장되는 디스크 상의 장소
--관리자로부터 할당을 받아야 함.

--system 계정에서 확인
SELECT USERNAME, DEFAULT_TABLESPACE
FROM DBA_USERS
WHERE USERNAME = 'USER01';

--테이블 스페이스 할당
ALTER USER USER01
QUOTA 3M ON SYSTEM;

CREATE USER USER007 IDENTIFIED BY PASS007;

GRANT CREATE SESSION, CREATE TABLE TO USER007;
GRANT CREATE TABLE TO USER007;

ALTER USER USER007
QUOTA 3M ON SYSTEM;

--WITH ADMIN OPTION
--사용자에게 권한 부여시 시스템 권한을 같이 부여한다는 옵션임
--권한을 부여받은 사용자는 다른 사용자에게 권한을 지정할 수 있음
/*
GRANT 권한종류 TO 사용자아이디 WITH ADMIN OPTION;
*/

--객체 권한
--테이블이나 뷰, 시퀀스, 프로시저, 함수 등 각 객체별로 DML 문을 사용할 수 있는 권한

/*
GRANT 객체권한종류 (컬럼명) | ALL
ON 테이블명 | 객체명 | 롤이름 | PUBLIC
TO 사용자계정;
*/

--객체 권한의 종류
/*
    ALTER   : TABLE, SEQUENCE
    DELETE  : TABLE, VIEW
    EXECUTE : PROCEDURE
    INDEX   : TABLE
    INSERT  : TABLE, VIEW
    REFERENCES : TABLE
    SELECT  : TABLE, VIEW, SEQUENCE
    UPDATE  : TABLE, VIEW
*/

--권한 철회 : REVOKE
--REVOKE 권한종류 | ALL ON 객체명 FROM 사용자이름 | 롤이름 | PUBLIC;

--WITH GRANT OPTION
--사용자가 어떤 객체에 접근할 수 있는 권한을 부여받으면서 , 그 권한을
--다른 사용자에게 다시 부여할 수 있게 하는 옵션임.