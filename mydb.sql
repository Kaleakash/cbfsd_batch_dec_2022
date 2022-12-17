create database ecommerce_db;
use ecommerce_db;
drop database ecommerce_db;
show tables;

CREATE TABLE ADMINS ( adminId INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, email VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL, fullName VARCHAR(255) NOT NULL,loginType INTEGER DEFAULT 1,
  addedOn DATETIME DEFAULT CURRENT_TIMESTAMP );
select * from Admins ad where ad.email = 'admin@gmail.com' and ad.password = 'admin@123';

insert into admins(email,password,fullname,addedOn) values('admin@gmail.com','admin@123','Admin',current_date());

select * from admins;

CREATE TABLE USERS(
  userId               INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  email                VARCHAR(50) NOT NULL,
  password             VARCHAR(50) NOT NULL,
  fullName             VARCHAR(255) NOT NULL,
  street               VARCHAR(50) DEFAULT NULL,
  city                 VARCHAR(50) DEFAULT NULL,
  state                VARCHAR(50) DEFAULT NULL,
  country              VARCHAR(50) DEFAULT NULL,
  pincode              INTEGER,
  image                VARCHAR(1000),
  contact              BIGINT,
  addedOn              DATETIME DEFAULT CURRENT_TIMESTAMP);

CREATE TABLE CATEGORIES (
  categoryId            INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  categoryName          VARCHAR(255) NOT NULL,
  categoryDescription   VARCHAR(255),
  categoryImageUrl      VARCHAR(500),
  active                boolean,
  addedOn               DATETIME DEFAULT CURRENT_TIMESTAMP
);
alter table categories modify categoryImageUrl longblob;

#alter table categories modify active boolean;
CREATE TABLE ORDERS(
  orderId              INTEGER NOT NULL PRIMARY KEY,
  orderDate            DATETIME DEFAULT CURRENT_TIMESTAMP,
  orderStatus          VARCHAR(50) NOT NULL,
  totalItems           INTEGER NOT NULL,
  itemsSubTotal        INTEGER NOT NULL,
  shipmentCharges      INTEGER NOT NULL,
  totalAmount          INTEGER NOT NULL,
  paymentStatus        INTEGER DEFAULT 0,
  paymentStatusTitle   VARCHAR(255),
  paymentMethod        INTEGER,
  paymentMethodTitle   VARCHAR(255) NOT NULL,
  userId               INTEGER NOT NULL,
  name                 VARCHAR(255) NOT NULL,
  email                VARCHAR(255) NOT NULL,
  contact              BIGINT NOT NULL,
  address              VARCHAR(500) NOT NULL,
  FOREIGN KEY (userId) REFERENCES USERS(userId)
);

CREATE TABLE PRODUCTS(
  productId             INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  productTitle          VARCHAR(500) NOT NULL,
  productDescription    VARCHAR(500) NOT NULL,
  productCode           VARCHAR(500) NOT NULL,
  categoryId            INTEGER,
		images                VARCHAR(1000),
  thumbnailImage        INTEGER DEFAULT 0,
  price                 INTEGER DEFAULT 0,
  addedOn               DATETIME DEFAULT CURRENT_TIMESTAMP,
  rating                INTEGER NOT NULL,
  FOREIGN KEY (categoryId) REFERENCES CATEGORIES(categoryId)
);

CREATE TABLE ORDERITEMS(
  orderItemId          INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  orderId              INTEGER,
  productId            INTEGER,
  productCode          VARCHAR(255) NOT NULL,
  productImg           VARCHAR(255) NOT NULL,
  productTitle         VARCHAR(255) NOT NULL,
  productDescription   VARCHAR(255) NOT NULL,
  productCategory      VARCHAR(255) NOT NULL,
  price                INTEGER NOT NULL,
  quantity             INTEGER NOT NULL,
  totalPrice           INTEGER NOT NULL,
  FOREIGN KEY (orderId) REFERENCES ORDERS(orderId),
  FOREIGN KEY (productId) REFERENCES PRODUCTS(productId)
);


desc imageinfo;
#product_productid,imageid(CPK)

select * from imageinfo;
select * from products;

#create table imageinfo1(product_productid int, images longblob, imageid int, primary key(product_productid,imageid));
select * from categories;
desc imageinfo1;
CREATE TABLE SHIPMENTS(
  shipmentId           INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  orderId              INTEGER,
  shipmentStatus       INTEGER,
  shipmentTitle        VARCHAR(255),
  shipmentDate         DATETIME DEFAULT CURRENT_TIMESTAMP,
  expectedDeliveryDate DATETIME,
  shipmentMethod       VARCHAR(255),
  shipmentCompany      VARCHAR(255),
  FOREIGN KEY (orderId) REFERENCES ORDERS(orderId)
);

CREATE TABLE WHISHLIST(
  whishListId          INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userId               INTEGER NOT NULL,
  productId            INTEGER NOT NULL,
  FOREIGN KEY (userId) REFERENCES USERS(userId),
  FOREIGN KEY (productId) REFERENCES PRODUCTS(productId)
);

CREATE TABLE CART(
  cartId               INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userId               INTEGER NOT NULL,
  productId            INTEGER NOT NULL,
  quantity             INTEGER DEFAULT 1,
  FOREIGN KEY (userId) REFERENCES USERS(userId),
  FOREIGN KEY (productId) REFERENCES PRODUCTS(productId)
);

show tables;

desc imageinfo;
alter table imageinfo modify images longblob;

