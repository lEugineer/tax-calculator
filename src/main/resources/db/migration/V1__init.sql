  -- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
  --
  -- Host: localhost    Database: tax_calculator_service
  -- ------------------------------------------------------
  -- Server version	5.7.21-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `tax_calculator_service`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `tax_calculator_service` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tax_calculator_service`;

--
-- Table structure for table `calculated_taxes`
--

DROP TABLE IF EXISTS `calculated_taxes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calculated_taxes` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `children_younger18` int(11) DEFAULT NULL,
  `dependants` int(11) DEFAULT NULL,
  `disabled_children` int(11) DEFAULT NULL,
  `has_benefit_for_single` bit(1) DEFAULT NULL,
  `income` double NOT NULL,
  `is_benefit_permitted` bit(1) DEFAULT NULL,
  `is_has_main_work` bit(1) DEFAULT NULL,
  `out_of_realized_income_without_vat` double NOT NULL,
  `outcome_sum_for_building` double DEFAULT NULL,
  `outcome_sum_for_education` double DEFAULT NULL,
  `outcome_sum_for_individual_business` double DEFAULT NULL,
  `outcome_sum_for_insurance` double DEFAULT NULL,
  `period` varchar(255) NOT NULL,
  `tax_to_pay` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-20 13:51:18
