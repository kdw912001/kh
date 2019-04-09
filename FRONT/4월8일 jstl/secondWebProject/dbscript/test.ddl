DROP TABLE order CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: 상품 */
/**********************************/
CREATE TABLE product(
		product_code                  		VARCHAR2(15)		 NULL ,
		product_name                  		VARCHAR2(30)		 NOT NULL,
		order_no                      		NUMBER(10)		 NULL 
);

COMMENT ON TABLE product is '상품';
COMMENT ON COLUMN product.product_code is '상품코드';
COMMENT ON COLUMN product.product_name is '상품명';
COMMENT ON COLUMN product.order_no is '주문번호';


/**********************************/
/* Table Name: 주문 */
/**********************************/
CREATE TABLE order(
		order_no                      		NUMBER(10)		 NULL ,
		product_code                  		VARCHAR2(15)		 NULL 
);

COMMENT ON TABLE order is '주문';
COMMENT ON COLUMN order.order_no is '주문번호';
COMMENT ON COLUMN order.product_code is '상품코드';



ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (product_code);

ALTER TABLE order ADD CONSTRAINT IDX_order_PK PRIMARY KEY (order_no);
ALTER TABLE order ADD CONSTRAINT IDX_order_FK0 FOREIGN KEY (product_code) REFERENCES product (product_code);

