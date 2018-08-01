-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema online_bank
--

CREATE DATABASE IF NOT EXISTS online_bank;
USE online_bank;

--
-- Definition of table `account_info`
--

DROP TABLE IF EXISTS `account_info`;
CREATE TABLE `account_info` (
  `account_number` int(10) unsigned NOT NULL auto_increment,
  `account_name` varchar(45) NOT NULL,
  `father_name` varchar(45) NOT NULL,
  `mother_name` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `mobile` varchar(11) NOT NULL,
  `nid` int(10) unsigned NOT NULL,
  `dob` date NOT NULL,
  `balance` double NOT NULL,
  `adate` date NOT NULL,
  PRIMARY KEY  (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account_info`
--

/*!40000 ALTER TABLE `account_info` DISABLE KEYS */;
INSERT INTO `account_info` (`account_number`,`account_name`,`father_name`,`mother_name`,`address`,`mobile`,`nid`,`dob`,`balance`,`adate`) VALUES 
 (1,'Golam Mostafa','Mohammad Ullah','Fatema  Begum','Laxmipur','01737174099',1992511333,'1992-05-13',88888,'2018-03-29'),
 (2,'Redwan','Mohammad Ullah','Fatema  Begum','Laxmipur','01737174099',1995511,'2018-03-11',45000,'2018-03-29'),
 (3,'Rafi','Jafor','Karima','Dhaka','0988455',332434,'2001-03-14',5222,'2018-03-31'),
 (4,'fghsa','dsfikds','fdsh','dfsa','8555',4785,'2018-03-25',5455,'2018-03-31'),
 (5,'jdjjfd','sfad','dfsa','dfsa','7438',3478,'2018-04-03',0,'2018-04-01'),
 (6,'jdjjfd','sfad','dfsa','dfsa','7438',3478,'2018-04-03',4555,'2018-04-01'),
 (8,'mostafa','mohammad','fatema','laxmipur','017383217',4328326,'2018-04-03',566,'2018-04-01'),
 (9,'mostafa','mohammad','fatema','laxmipur','017383217',4328326,'2018-04-03',566,'2018-04-01'),
 (10,'jsdkfj','dsajdf','dsa','dsa','435',53252,'2018-04-05',4532,'2018-04-01'),
 (11,'jsdkfj','dsajdf','dsa','dsa','435',53252,'2018-04-05',4532,'2018-04-01'),
 (12,'mostafa','mohammad','fatema','laxmipur','017383217',4328326,'2018-04-03',566,'2018-04-01'),
 (13,'fdjklsfhasj','fdsadjkfh','dfasa','asdffafsd','3425',34321,'2018-04-24',3425,'2018-04-01'),
 (14,'erjhew','qwreih','erqwyhe','erqwryh','3444',3333,'2018-04-25',34255,'2018-04-01'),
 (15,'gkjdfhgkj','reqwyhr','erwehg','erhig','45677',646352,'2018-04-17',7888,'2018-04-01'),
 (16,'jkdfssgafdj','dfsjgdf','fdsdsa','dfsdhg','445',32536,'2018-04-30',432432,'2018-04-01'),
 (17,'dfhdsajkdf','fasdjkdfsa','asdfsjgs','fdasjfsd','dsfdhgdfjs',44444,'2018-04-24',66677,'2018-04-01'),
 (18,'erwqrioyqw','erqwiryoeqw','erqwioyet','rquitq','reqwiyte',646464,'2018-04-27',34212,'2018-04-01'),
 (19,'erwqiery','erqwhfd','rdfhdjg','rewqht','6463646',2345351,'2018-04-26',1434234,'2018-04-01'),
 (20,'fdsfhasd','dsfhdsjklaa','fdsajfsd','dfsahfdask','33444',34234,'2018-04-30',43232,'2018-04-01'),
 (21,'Golam Mostafa','Mohammad Ullah','Fatema  Begum','Laxmipur','01737174099',1992511,'2018-03-06',88888,'2018-04-02'),
 (22,'erdfs','dsaa','fsdaa','asdfa','3424',54,'2018-04-23',34234,'2018-04-04'),
 (23,'fdsaasd','sdaftgds','rewqgd','fdsafgds','345',4321,'2018-04-27',5321,'2018-04-04'),
 (24,'Golam Mostafa','Mohammad Ullah','Fatema  Begum','Laxmipur','01737174099',1992511,'2018-03-06',88888,'2018-04-04'),
 (25,'Golam Mostafa','Mohammad','Fatema','Laxmipur','01737174099',1233352,'1992-05-13',5666,'2018-04-05'),
 (26,'Redwan','Mohammad Ullah','Fatema  Begum','Laxmipur','01737174099',1995511,'2018-03-11',45000,'2018-04-05'),
 (27,'Golam Mostafa','Mohammad Ullah','Fatema  Begum','Laxmipur','01737174099',1992511333,'1992-05-13',88888,'2018-04-05'),
 (28,'jdkfh','fdsahfda','dfrehjdf','trewg','34455',43242,'2018-04-24',555,'2018-04-09'),
 (29,'fdsfs','sdfgdsa','dsafsd','asdfdasdfd','4444',3214,'2018-04-11',312434,'2018-04-09'),
 (30,'fdsa','afda','afsda','afd','345523',5151,'2018-04-07',534125,'2018-04-09');
/*!40000 ALTER TABLE `account_info` ENABLE KEYS */;


--
-- Definition of trigger `after_create_account_on_ta`
--

DROP TRIGGER /*!50030 IF EXISTS */ `after_create_account_on_ta`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `after_create_account_on_ta` AFTER INSERT ON `account_info` FOR EACH ROW BEGIN
INSERT INTO transaction_account
SET account_number=NEW.account_number, deposit=NEW.balance, ddate=NEW.adate;
END $$

DELIMITER ;

--
-- Definition of table `deposit`
--

DROP TABLE IF EXISTS `deposit`;
CREATE TABLE `deposit` (
  `dep_id` int(10) unsigned NOT NULL auto_increment,
  `account_number` int(10) unsigned NOT NULL,
  `deposit` double NOT NULL,
  `ddate` date NOT NULL,
  PRIMARY KEY  (`dep_id`),
  KEY `FK_deposit_account_no` (`account_number`),
  CONSTRAINT `FK_deposit_account_no` FOREIGN KEY (`account_number`) REFERENCES `account_info` (`account_number`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deposit`
--

/*!40000 ALTER TABLE `deposit` DISABLE KEYS */;
INSERT INTO `deposit` (`dep_id`,`account_number`,`deposit`,`ddate`) VALUES 
 (1,1,88888,'2018-03-29'),
 (2,2,45000,'2018-03-29'),
 (3,3,5222,'2018-03-31'),
 (4,4,5455,'2018-03-31');
/*!40000 ALTER TABLE `deposit` ENABLE KEYS */;


--
-- Definition of trigger `before_deposit_on_ai`
--

DROP TRIGGER /*!50030 IF EXISTS */ `before_deposit_on_ai`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `before_deposit_on_ai` BEFORE INSERT ON `deposit` FOR EACH ROW BEGIN
update account_info
set balance = balance + new.deposit
where account_number=new.account_number;
END $$

DELIMITER ;

--
-- Definition of trigger `after_deposit_on_ta`
--

DROP TRIGGER /*!50030 IF EXISTS */ `after_deposit_on_ta`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `after_deposit_on_ta` AFTER INSERT ON `deposit` FOR EACH ROW BEGIN
INSERT INTO transaction_account
SET dep_id=NEW.dep_id, deposit=NEW.deposit, ddate=NEW.ddate;
END $$

DELIMITER ;

--
-- Definition of table `loan`
--

DROP TABLE IF EXISTS `loan`;
CREATE TABLE `loan` (
  `loan_id` int(10) unsigned NOT NULL auto_increment,
  `account_number` int(10) unsigned NOT NULL,
  `loan_amount` double NOT NULL,
  `interest_rate` int(10) unsigned NOT NULL,
  `total_month` int(10) unsigned NOT NULL,
  `total_payable` double NOT NULL,
  `monthly_payment` double NOT NULL,
  `ldate` date NOT NULL,
  PRIMARY KEY  (`loan_id`),
  KEY `FK_loan_account_no` (`account_number`),
  CONSTRAINT `FK_loan_account_no` FOREIGN KEY (`account_number`) REFERENCES `account_info` (`account_number`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loan`
--

/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
INSERT INTO `loan` (`loan_id`,`account_number`,`loan_amount`,`interest_rate`,`total_month`,`total_payable`,`monthly_payment`,`ldate`) VALUES 
 (1,1,5000,10,10,5500,550,'2018-03-07'),
 (3,4,4444,4,6,4621.76,770.293333333334,'2018-04-09'),
 (4,2,5550,8,10,4995,499.5,'2018-04-10'),
 (9,3,50000,10,10,55000,5500,'2018-04-12'),
 (10,5,5000,10,0,0,5500,'2018-04-12');
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;


--
-- Definition of table `loan_payment`
--

DROP TABLE IF EXISTS `loan_payment`;
CREATE TABLE `loan_payment` (
  `pay_id` int(10) unsigned NOT NULL auto_increment,
  `account_number` int(10) unsigned NOT NULL,
  `loan_id` int(10) unsigned NOT NULL,
  `pay_month` int(10) unsigned NOT NULL,
  `pay_amount` double NOT NULL,
  `pdate` date NOT NULL,
  PRIMARY KEY  (`pay_id`),
  KEY `FK_loan_payment_account_no` (`account_number`),
  KEY `FK_loan_payment_loan_id` (`loan_id`),
  CONSTRAINT `FK_loan_payment_account_no` FOREIGN KEY (`account_number`) REFERENCES `account_info` (`account_number`) ON DELETE CASCADE,
  CONSTRAINT `FK_loan_payment_loan_id` FOREIGN KEY (`loan_id`) REFERENCES `loan` (`loan_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loan_payment`
--

/*!40000 ALTER TABLE `loan_payment` DISABLE KEYS */;
INSERT INTO `loan_payment` (`pay_id`,`account_number`,`loan_id`,`pay_month`,`pay_amount`,`pdate`) VALUES 
 (1,2,4,1,499.5,'2018-04-11'),
 (2,2,4,1,499.5,'2018-04-11'),
 (14,5,10,1,5500,'2018-04-12');
/*!40000 ALTER TABLE `loan_payment` ENABLE KEYS */;


--
-- Definition of trigger `before_loan_payment_on_loan`
--

DROP TRIGGER /*!50030 IF EXISTS */ `before_loan_payment_on_loan`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `before_loan_payment_on_loan` BEFORE INSERT ON `loan_payment` FOR EACH ROW BEGIN
update loan
set total_month = total_month - new.pay_month, total_payable=total_payable-New.pay_amount
where account_number=new.account_number;
END $$

DELIMITER ;

--
-- Definition of table `transaction_account`
--

DROP TABLE IF EXISTS `transaction_account`;
CREATE TABLE `transaction_account` (
  `transaction_id` int(10) unsigned NOT NULL auto_increment,
  `account_number` int(10) unsigned NOT NULL,
  `deposit` double default NULL,
  `ddate` date default NULL,
  `withdraw` double default NULL,
  `wdate` date default NULL,
  `transfer_amount` double default NULL,
  `transfer_account` int(10) unsigned default NULL,
  `tdate` date default NULL,
  `dep_id` int(10) unsigned default NULL,
  `transfer_id` int(10) unsigned default NULL,
  `withdraw_id` int(10) unsigned default NULL,
  PRIMARY KEY  (`transaction_id`),
  KEY `FK_transaction_accoun_dep_id` (`dep_id`),
  KEY `FK_transaction_account_transfer_id` (`transfer_id`),
  KEY `FK_transaction_account_withdraw_id` (`withdraw_id`),
  KEY `FK_transaction_account_number` (`account_number`),
  CONSTRAINT `FK_transaction_account_number` FOREIGN KEY (`account_number`) REFERENCES `account_info` (`account_number`) ON DELETE CASCADE,
  CONSTRAINT `FK_transaction_account_transfer_id` FOREIGN KEY (`transfer_id`) REFERENCES `transfer` (`transfer_id`) ON DELETE CASCADE,
  CONSTRAINT `FK_transaction_account_withdraw_id` FOREIGN KEY (`withdraw_id`) REFERENCES `withdrawal` (`withdraw_id`) ON DELETE CASCADE,
  CONSTRAINT `FK_transaction_accoun_dep_id` FOREIGN KEY (`dep_id`) REFERENCES `deposit` (`dep_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction_account`
--

/*!40000 ALTER TABLE `transaction_account` DISABLE KEYS */;
INSERT INTO `transaction_account` (`transaction_id`,`account_number`,`deposit`,`ddate`,`withdraw`,`wdate`,`transfer_amount`,`transfer_account`,`tdate`,`dep_id`,`transfer_id`,`withdraw_id`) VALUES 
 (1,5,0,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (2,6,4555,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (4,8,566,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (5,9,566,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (6,10,4532,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (7,11,4532,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (8,12,566,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (9,13,3425,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (10,14,34255,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (11,15,7888,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (12,16,432432,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (13,17,66677,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (14,18,34212,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (15,19,1434234,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (16,20,43232,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (17,21,88888,'2018-04-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (18,22,34234,'2018-04-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (19,23,5321,'2018-04-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (20,24,88888,'2018-04-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (21,25,5666,'2018-04-05',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (22,26,45000,'2018-04-05',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (23,27,88888,'2018-04-05',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (24,28,555,'2018-04-09',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (25,29,312434,'2018-04-09',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (26,30,534125,'2018-04-09',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `transaction_account` ENABLE KEYS */;


--
-- Definition of table `transfer`
--

DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer` (
  `transfer_id` int(10) unsigned NOT NULL auto_increment,
  `account_number` int(10) unsigned NOT NULL,
  `transfer_account` int(10) unsigned NOT NULL,
  `transfer_amount` double NOT NULL,
  `tdate` date NOT NULL,
  PRIMARY KEY  (`transfer_id`),
  KEY `FK_transfer_account_no` (`account_number`),
  CONSTRAINT `FK_transfer_account_no` FOREIGN KEY (`account_number`) REFERENCES `account_info` (`account_number`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transfer`
--

/*!40000 ALTER TABLE `transfer` DISABLE KEYS */;
/*!40000 ALTER TABLE `transfer` ENABLE KEYS */;


--
-- Definition of trigger `before_transfer_on_ai`
--

DROP TRIGGER /*!50030 IF EXISTS */ `before_transfer_on_ai`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `before_transfer_on_ai` BEFORE INSERT ON `transfer` FOR EACH ROW BEGIN
update account_info
set balance = balance - new.transfer_account
where account_number=new.account_number;
END $$

DELIMITER ;

--
-- Definition of trigger `after_transfer_on_ta`
--

DROP TRIGGER /*!50030 IF EXISTS */ `after_transfer_on_ta`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `after_transfer_on_ta` AFTER INSERT ON `transfer` FOR EACH ROW BEGIN
INSERT INTO transaction_account
SET transfer_id=NEW.transfer_id, transfer_account=NEW.transfer_account, transfer_amount=NEW.transfer_amount, tdate=NEW.tdate;
END $$

DELIMITER ;

--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `user_role` varchar(45) default NULL,
  `account_number` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_user_account_no` (`account_number`),
  CONSTRAINT `FK_user_account_no` FOREIGN KEY (`account_number`) REFERENCES `account_info` (`account_number`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=FIXED;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`name`,`email`,`user_name`,`password`,`user_role`,`account_number`) VALUES 
 (6,'Golam Mostafa','mostafa.sna@gmail.com','mostafa.sna','12345',NULL,1),
 (7,'Golam Mostafa','mostafa.sna@gmail.com','mostafa.sna','12345',NULL,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `withdrawal`
--

DROP TABLE IF EXISTS `withdrawal`;
CREATE TABLE `withdrawal` (
  `withdraw_id` int(10) unsigned NOT NULL auto_increment,
  `account_number` int(10) unsigned NOT NULL,
  `withdraw` double NOT NULL,
  `wdate` date NOT NULL,
  PRIMARY KEY  (`withdraw_id`),
  KEY `FK_withdrawal_account_no` (`account_number`),
  CONSTRAINT `FK_withdrawal_account_no` FOREIGN KEY (`account_number`) REFERENCES `account_info` (`account_number`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `withdrawal`
--

/*!40000 ALTER TABLE `withdrawal` DISABLE KEYS */;
/*!40000 ALTER TABLE `withdrawal` ENABLE KEYS */;


--
-- Definition of trigger `before_withdraw_on_ai`
--

DROP TRIGGER /*!50030 IF EXISTS */ `before_withdraw_on_ai`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `before_withdraw_on_ai` BEFORE INSERT ON `withdrawal` FOR EACH ROW BEGIN
update account_info
set balance = balance - new.withdraw
where account_number=new.account_number;
END $$

DELIMITER ;

--
-- Definition of trigger `after_withdraw_on_ta`
--

DROP TRIGGER /*!50030 IF EXISTS */ `after_withdraw_on_ta`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `after_withdraw_on_ta` AFTER INSERT ON `withdrawal` FOR EACH ROW BEGIN
INSERT INTO transaction_account
SET withdraw_id=NEW.withdraw_id, withdraw=NEW.withdraw, wdate=NEW.wdate;
END $$

DELIMITER ;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
