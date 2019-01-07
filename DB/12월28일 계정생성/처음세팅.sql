

CREATE USER scott IDENTIFIED BY tiger;--scott계정
GRANT CONNECT , RESOURCE TO scott;

CREATE USER homework IDENTIFIED BY homework;--과제용계정
GRANT CONNECT , RESOURCE TO homework;
--homework 계정에서 -열기-과제폴더에 workbook_script 그 이후 스크립트실행(F5)

CREATE USER student IDENTIFIED BY student;--수업용계정
GRANT CONNECT , RESOURCE TO student;
--student계정은 # 실습스크립트 폴더 안에 실습용_스크립트

 alter user hr identified by hr account unlock;	--hr계정
GRANT CONNECT , RESOURCE TO hr;

