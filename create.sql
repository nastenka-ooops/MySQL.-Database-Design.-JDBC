CREATE DATABASE IF NOT EXISTS flower_shop;
USE flower_shop;

-- auto-generated definition
create table product
(
    id     int auto_increment
        primary key,
    name   varchar(255) not null,
    height int          not null,
    price  double       not null
);

-- auto-generated definition
create table compatibility
(
    dominant_flower_id   int    not null,
    compatible_flower_id int    not null,
    optimal_quantity     double not null,
    constraint compatible_flower
        foreign key (compatible_flower_id) references product (id)
            on update cascade on delete cascade,
    constraint dominant_flower_id
        foreign key (dominant_flower_id) references product (id)
            on update cascade on delete cascade
);

-- auto-generated definition
create table customer
(
    id         int          not null
        primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    address    varchar(255) not null,
    phone      varchar(255) not null,
    email      varchar(255) not null,
    constraint email_UNIQUE
        unique (email),
    constraint phone_UNIQUE
        unique (phone)
);

-- auto-generated definition
create table employee
(
    id         int auto_increment
        primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    position   varchar(255) not null,
    salary     double       not null,
    hire_date  date         not null
);

-- auto-generated definition
create table inventory
(
    product_id    int  not null,
    quantity      int  not null,
    shipment_date date not null,
    constraint product_id
        foreign key (product_id) references product (id)
            on update cascade on delete cascade
);

-- auto-generated definition
create table `order`
(
    id          int auto_increment
        primary key,
    date        date not null,
    customer_id int  not null,
    status      int  not null,
    constraint customer_id
        foreign key (customer_id) references customer (id)
            on update cascade on delete cascade
);

create index customer_id_idx
    on `order` (customer_id);

create index status
    on `order` (status);

-- auto-generated definition
create table order_item
(
    order_id   int not null,
    product_id int not null,
    quantity   int not null,
    constraint order_id
        foreign key (order_id) references `order` (id)
            on update cascade on delete cascade,
    constraint order_item_product_id
        foreign key (product_id) references product (id)
            on update cascade on delete cascade
);

create index product_id
    on order_item (product_id);

-- auto-generated definition
create table supplier
(
    id           int auto_increment
        primary key,
    company_name varchar(255) not null,
    address      varchar(255) not null,
    phone        varchar(255) not null,
    email        varchar(255) not null,
    constraint email
        unique (email),
    constraint phone
        unique (phone)
);

-- auto-generated definition
create table shipment
(
    id          int auto_increment
        primary key,
    date        date not null,
    supplier_id int  not null,
    status      int  not null,
    constraint supplier_id
        foreign key (supplier_id) references supplier (id)
            on update cascade on delete cascade
);

create index supplier_id_idx
    on shipment (supplier_id);

create index status
    on shipment (status);

-- auto-generated definition
create table shipment_item
(
    shipment_id int not null,
    product_id  int not null,
    quantity    int not null,
    constraint shipment_id
        foreign key (shipment_id) references shipment (id)
            on update cascade on delete cascade,
    constraint shipment_item_product_id
        foreign key (product_id) references product (id)
            on update cascade on delete cascade
);




