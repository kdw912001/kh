drop table product;

create table product(
  product_id  varchar2(15) primary key,
  p_name  varchar2(20)  not null,
  price number(10)  not null,
  description varchar2(50)
);  

insert into product values ('nb_ss7', '»ï¼º³ëÆ®ºÏ', 1570000, '½Ã¸®Áî 7');
insert into product values ('nb_ama4', '¸ÆºÏ¿¡¾î', 1200000, 'xcode 4');
insert into product values ('pc_ibm', 'ibmPC', 750000, 'windows 8');

commit;

select * from product;

