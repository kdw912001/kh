

CREATE USER scott IDENTIFIED BY tiger;--scott����
GRANT CONNECT , RESOURCE TO scott;

CREATE USER homework IDENTIFIED BY homework;--���������
GRANT CONNECT , RESOURCE TO homework;
--homework �������� -����-���������� workbook_script �� ���� ��ũ��Ʈ����(F5)

CREATE USER student IDENTIFIED BY student;--���������
GRANT CONNECT , RESOURCE TO student;
--student������ # �ǽ���ũ��Ʈ ���� �ȿ� �ǽ���_��ũ��Ʈ

 alter user hr identified by hr account unlock;	--hr����
GRANT CONNECT , RESOURCE TO hr;

