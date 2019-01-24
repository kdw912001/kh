CREATE TABLE BOOK(
    book_id number primary key,
    title varchar2(50) not null,
    author varchar2(20) not null,
    publisher varchar2(20) not null,
    publish_date date not null,
    price number not null
);

create sequence seq_bid
start with 1
increment by 1
maxvalue 999
nocycle
nocache;