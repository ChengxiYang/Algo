# noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE customer_t
(
    customer_id VARCHAR(10) NOT NULL,
    city VARCHAR(10) NOT NULL,
    PRIMARY KEY(customer_id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE order_t
(
    order_id INT NOT NULL auto_increment,
    customer_id VARCHAR(10),
    cost INT NOT NULL DEFAULT 0,
    PRIMARY KEY(order_id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

INSERT INTO customer_t(customer_id,city) VALUES('163','hangzhou');
INSERT INTO customer_t(customer_id,city) VALUES('meituan','shanghai');
INSERT INTO customer_t(customer_id,city) VALUES('tx','shenzhen');
INSERT INTO customer_t(customer_id,city) VALUES('baidu','beijing');

INSERT INTO order_t(customer_id, cost) VALUES('163', 2);
INSERT INTO order_t(customer_id, cost) VALUES('163', 3);
INSERT INTO order_t(customer_id, cost) VALUES('meituan', 1);
INSERT INTO order_t(customer_id, cost) VALUES('meituan', 1);
INSERT INTO order_t(customer_id, cost) VALUES('tx', 5);
INSERT INTO order_t(customer_id, cost) VALUES('tx', 7);
INSERT INTO order_t(customer_id, cost) VALUES('baidu', 3);
INSERT INTO order_t(customer_id, cost) VALUES('baidu', 4);
