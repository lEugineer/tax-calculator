--
-- Data for table `calculated_taxes`
--
LOCK TABLES `calculated_taxes` WRITE;
/*!40000 ALTER TABLE `calculated_taxes` DISABLE KEYS */;
INSERT INTO `calculated_taxes` VALUES
  (1,'2018-03-20 13:40:27','2018-03-20 13:40:27',0,0,10,0,'\0',2400000,'\0','\0',240000,0,0,0,0,'Quartal',0),
  (2,'2018-03-20 13:41:30','2018-03-20 13:41:30',0,0,0,0,'\0',4800000,'\0','\0',480000,0,0,4800000,0,'HalfYear',0),
  (3,'2018-03-20 13:42:58','2018-03-20 13:42:58',0,2,1,1,'\0',4800000,'\0','\0',480000,345679,98765,480000,45678,'HalfYear',0);
/*!40000 ALTER TABLE `calculated_taxes` ENABLE KEYS */;
UNLOCK TABLES;