drop table product;

create table product(
  product_id  varchar2(15) primary key,
  p_name  varchar2(20)  not null,
  price number(10)  not null,
  description varchar2(50)
);  

insert into product values ('nb_ss7', '�Ｚ��Ʈ��', 1570000, '�ø��� 7');
insert into product values ('nb_ama4', '�ƺϿ���', 1200000, 'xcode 4');
insert into product values ('pc_ibm', 'ibmPC', 750000, 'windows 8');

commit;

select * from product;

