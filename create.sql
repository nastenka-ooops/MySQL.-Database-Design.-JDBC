CREATE DATABASE flower_shop;
USE flower_shop;

CREATE TABLE `flower_shop`.`flower` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `height` INT NOT NULL,
  `price` DOUBLE NOT NULL,
  `betterBefore` INT NOT NULL);
  
ALTER TABLE `flower_shop`.`flower`
ADD PRIMARY KEY (id);

ALTER TABLE `flower_shop`.`flower`
MODIFY COLUMN id INT AUTO_INCREMENT;

CREATE TABLE `flower_shop`.`compatibility` (
  `dominant_flower_id` INT NOT NULL,
  `compatible_flower_idl` INT NOT NULL,
  `optimal_quantity` DOUBLE NOT NULL);
  
ALTER TABLE `flower_shop`.`compatibility`
ADD CONSTRAINT `dominant_flower_id`
    FOREIGN KEY (`dominant_flower_id`)
    REFERENCES `flower_shop`.`flower` (`id`)
	ON DELETE CASCADE,
ADD CONSTRAINT `compatible_flower`
    FOREIGN KEY (`compatible_flower_idl`)
    REFERENCES `flower_shop`.`flower` (`id`)
	ON DELETE CASCADE;

CREATE TABLE `flower_shop`.`customer` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(150) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL);
  
ALTER TABLE `flower_shop`.`customer`
ADD PRIMARY KEY (id);

ALTER TABLE `flower_shop`.`customer`
MODIFY COLUMN id INT AUTO_INCREMENT;

CREATE TABLE `flower_shop`.`order` (
  `id` INT NOT NULL,
  `date` DATE NOT NULL,
  `customer_id` INT NOT NULL);
    
ALTER TABLE `flower_shop`.`order`
ADD PRIMARY KEY (id),	
ADD CONSTRAINT `customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `flower_shop`.`customer` (`id`)
	ON DELETE CASCADE;

ALTER TABLE `flower_shop`.`order`
MODIFY COLUMN id INT AUTO_INCREMENT;

CREATE TABLE `flower_shop`.`order_item` (
  `order_id` INT NOT NULL,
  `id_flower` INT NOT NULL,
  `quantity` INT NOT NULL);
  
ALTER TABLE `flower_shop`.`order_item`
ADD CONSTRAINT `order_id`
    FOREIGN KEY (`order_id`)
    REFERENCES `flower_shop`.`order` (`id`)
	ON DELETE CASCADE,
ADD CONSTRAINT `id_flower`
    FOREIGN KEY (`id_flower`)
    REFERENCES `flower_shop`.`flower` (`id`)
    ON DELETE CASCADE;

CREATE TABLE `flower_shop`.`employee` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `salary` DOUBLE NOT NULL,
  `hire_date` DATE NOT NULL);
  
ALTER TABLE `flower_shop`.`employee`
ADD PRIMARY KEY (id);

ALTER TABLE `flower_shop`.`employee`
MODIFY COLUMN id INT AUTO_INCREMENT;

CREATE TABLE `flower_shop`.`inventory` (
  `flower_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  `shipment_date` DATE NOT NULL);

CREATE TABLE `flower_shop`.`supplier` (
  `id` INT NOT NULL,
  `company_name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(150) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL);
  
ALTER TABLE `flower_shop`.`supplier`
ADD PRIMARY KEY (id);

ALTER TABLE `flower_shop`.`supplier`
MODIFY COLUMN id INT AUTO_INCREMENT;

CREATE TABLE `flower_shop`.`shipment` (
  `id` INT NOT NULL,
  `date` DATE NOT NULL,
  `supplier_id` INT NOT NULL);
    
ALTER TABLE `flower_shop`.`shipment`
ADD PRIMARY KEY (id),
ADD CONSTRAINT `supplier_id`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `flower_shop`.`supplier` (`id`)
	ON DELETE CASCADE;

ALTER TABLE `flower_shop`.`shipment`
MODIFY COLUMN id INT AUTO_INCREMENT;

CREATE TABLE `flower_shop`.`shipment_item` (
  `shipment_id` INT NOT NULL,
  `flower_id` INT NOT NULL,
  `quantity` INT NOT NULL);

ALTER TABLE `flower_shop`.`shipment_item`
ADD CONSTRAINT `shipment_id`
    FOREIGN KEY (`shipment_id`)
    REFERENCES `flower_shop`.`shipment` (`id`)
	ON DELETE CASCADE,
ADD CONSTRAINT `flower_id`
    FOREIGN KEY (`flower_id`)
    REFERENCES `flower_shop`.`flower` (`id`)
    ON DELETE CASCADE;

