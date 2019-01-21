-- 데이터베이스 롤(ROLE) - 권한제어
/*
사용자마다 일일이 권한을 부여하는 것은 번거로움
오라클에서는 간편하게 권한을 부여하는 방법으로 롤(ROLE)을 제공함

- 여러 개의 권한을 묶어 놓은 것
- 사용자 권한을 보다 간편하고 효율적으로 부여할 수 있게 됨
- 다수의 사용자에게 공통으로 필요한 권한들을 롤에 하나의 그룹으로 묶어 두고,
  사용자마다 특정 롤에 대한 권한을 구분해서 부여할 수 있도록 함
  
- 사용자 그룹별로 권한 수정이 필요한 경우도, 롤만 수정하면 부여된 그룹에 자동 반영됨
  일일이 사용자마다 하나씩 권한 수정을 하지 않아도 됨.

- 롤을 활성화/비활성화하여 일시적으로 권한을 부여했다/철회했다 할 수도 있음

- 롤의 종류
    * 사전 정의된 ROLE (데이터베이스가 제공하는 롤)
    * 사용자가 정의한 ROLE
    
- 사전 정의된 ROLE
    : 오라클에서 기본으로 제공되는 롤
    
    * CONNECT ROLE : 사용자가 데이터베이스에 접속할 수 있도록
        시스템 권한 8가지를 묶어 놓았음.
        CREATE SESSION, ALTER SESSION, 
        CREATE TABLE, CREATE VIEW, 
        CREATE SYNONYM, CREATE SEQUENCE,
        CREATE CLUSTER, CREATE DATABASE LINK
    * RESOURCE ROLE : 사용자가 객체를 생성할 수 있도록 하는 권한을 묶어 놓았음
        CREATE CLUSTER, CREATE PROCEDURE,
        CREATE SEQUENCE, CREATE TABLE,
        CREATE TRIGGER
    * DBA ROLE : 사용자가 소유한 데이터베이스 객체를 관리하고
            사용자 계정 만들고 편집하고 제거할 수 있는 모든 권한을 가짐
            시스템 권한을 부여하는 가장 강력한 롤임

-롤을 이요한 권한 부여하기
    : 일반적으로 사용자 생성할 때 CONNECT 롤과 RESOURCE 롤을 많이 사용함

GRANT 롤이름 TO 사용자계정;
GRANT 롤이름, 롤이름, .... TO 사용자계정;
*/

-- 롤 관련 딕셔너리
-- 롤을 확인하기 위한 데이터 딕셔너리가 아주 많음

-- 관리자(SYSTEM) 계정에서 확인
--관리자가 사용자에게 부여한 롤 정보 확인
SELECT * FROM DICT
WHERE TABLE_NAME LIKE '%ROLE%'; --9개의 테이블 존재 확인

--현재 사용자(student)에게 부여된 롤 확인해 보기
-- student 계정에서
SELECT * FROM USER_ROLE_PRIVS;

-- ROLE_SYS_PRIVS : 롤에 부여된 시스템 권한 정보
-- ROLE_TAB_PRIVS : 롤에 부여된 테이블 관련 권한 정보
-- USER_ROLE_PRIVS : 접근 가능한 롤 정보
-- USER_TAB_PRIVS_MADE : 해당 사용자가 만든 객체 권한 롤 정보
-- USER_TAB_PRIVS_RECD : 사용자에게 부여한 객체 권한 정보
-- USER_COL_PRIVS_MADE : 해당 사용자가 만든 컬럼 객체 권한 관련 롤 정보
-- USER_COL_PRIVS_RECD : 사용자에 부여한 특정 컬럼 관련 객체 권한 롤 정보

/*
사용자 롤 정의 형식
        롤 생성은 반드시 DBA 권한이 있는 사용자만 생성할 수 있음.
        
CREATE ROLE 롤이름; --1. 롤 객체 생성
GRANT 권한 종류 TO 롤이름; --2. 생성된 롤 객체에 저장된 권한 추가
GRANT 롤이름 TO 사용자명; --3. 사용자에게 롤을 이용한 권한 부여하기

*/

-- 롤 회수
-- GRANT ROLE 롤이름 FROM 사용자이름;

        