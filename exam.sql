-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: exam
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `CourseID` int NOT NULL,
  `CourseName` varchar(250) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,123,'asds'),(2,1232,'math'),(3,3141,'123');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exams`
--

DROP TABLE IF EXISTS `exams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exams` (
  `ExamId` int unsigned NOT NULL AUTO_INCREMENT,
  `CourseId` int NOT NULL,
  `ExamName` varchar(45) NOT NULL,
  `Description` varchar(500) NOT NULL,
  `NumberOfQuestions` int unsigned NOT NULL,
  `Duration` int unsigned NOT NULL,
  PRIMARY KEY (`ExamId`)
) ENGINE=InnoDB AUTO_INCREMENT=12334343 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exams`
--

LOCK TABLES `exams` WRITE;
/*!40000 ALTER TABLE `exams` DISABLE KEYS */;
INSERT INTO `exams` VALUES (1,123,'IT','<html><h2>Topics Covered</h2><ol><li>IT Fundamentals</li><li>OS Fundamentals</li><li>Networking</li><li>Internet</li><li>Binary Logic</li><li>IT Trends</li></ol></html>',10,1),(123,0,'BOSH','DHDHYWYYDGYGWY',122,123),(341,0,'testdata','sdfsadfs',23,5),(478,123,'IT','asdfsdfsadfsd',24,45),(674,0,'michael','jhjhkgiu',56,25),(1233,0,'opp','dasdssfsfasffffffffffffffffffffffffffffffffffffffffffff\nfffffffffffffffffff',10,10),(2424,0,'hhhhh','asdfsdfsadfsd',24,45),(12334,0,'namsd','shgsdgsdyagsygdgaysd',12,10),(12343,0,'jasmine','asdfdsesefwfwfsefsefwew',123,2),(23123,0,'fdfsd','2323',2312,12321),(123222,0,'23','sdsafsf',1,1),(1233333,0,'IT-100','FDFSDFDFDF',23,3),(12333444,0,'ben','dcdff',12,12),(12334342,0,'namsd','shgsdgsdyagsygdgaysd',12,10);
/*!40000 ALTER TABLE `exams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `QuestionId` int unsigned NOT NULL AUTO_INCREMENT,
  `Question` varchar(500) NOT NULL,
  `OptionA` varchar(45) NOT NULL,
  `OptionB` varchar(45) NOT NULL,
  `OptionC` varchar(45) NOT NULL,
  `OptionD` varchar(45) NOT NULL,
  `Answer` varchar(45) NOT NULL,
  `ExamId` int unsigned NOT NULL,
  PRIMARY KEY (`QuestionId`),
  KEY `FK_questions_exams` (`ExamId`),
  CONSTRAINT `FK_questions_exams` FOREIGN KEY (`ExamId`) REFERENCES `exams` (`ExamId`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'Which language is connected with the term WORA','Java','C#','VB.Net','VC++','A',1),(2,'Which of the following is not an RDBMS?','SAP','Derby','SQLite','Sybase','A',1),(3,'Who is the CEO of Microsoft?','Bill Gates','Steve Ballmer','Larry Ellison','Steve Jobs','B',1),(4,'Which of the following is not a Mobile Platform?','Android','Symbian','iOS','Azure','D',1),(5,'The IP Address in IPv6 consists of ____ Bytes','6','8','12','16','D',1),(6,'The Base 10 number 65535 is represented in Hexadecimal as','0xFF','0xFFF','0xFFFF','0xFFFFF','C',1),(7,'Which of the following disk drive does not have moving parts','IDE','SCSI','SATA','Solid State','D',1),(8,'The complement of 1  (i.e. ~1) will result in','0','-1','-2','65534','C',1),(9,'Android is','Language','Platform','Script','Database','B',1),(10,'Which of the following in not a Box technique for software testing','Black Box','Grey Box','Blue Box','White Box','C',1),(12,'wgyygywgygyeygw','wehwhehuw','123','ewhewhue','1233','123',123),(123,'12323','1231233','231231','2312312','23123','123123',1233);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reports` (
  `ReportId` int unsigned NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) NOT NULL,
  `ExamName` varchar(45) NOT NULL,
  `ExamDate` datetime NOT NULL,
  `TotalQuestions` int unsigned NOT NULL,
  `CorrectAnswers` int unsigned NOT NULL,
  `Score` double NOT NULL,
  PRIMARY KEY (`ReportId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
INSERT INTO `reports` VALUES (6,'JAKE','Core Java','2024-03-19 00:00:00',20,0,0),(11,'Alfred','IT','2024-03-24 00:00:00',10,2,20),(12,'Alfred','IT','2024-03-24 00:00:00',10,2,20),(13,'Arnel','IT','2024-03-25 00:00:00',10,0,0),(14,'Arnel','IT','2024-03-25 00:00:00',10,1,10),(15,'Arnel','IT','2024-03-25 00:00:00',10,0,0),(16,'Alfred','IT','2024-03-26 00:00:00',10,3,30),(17,'MENARD','IT','2024-03-26 00:00:00',10,0,0),(18,'Alfred','IT','2024-03-26 00:00:00',10,0,0),(19,'Alfred','IT','2024-03-31 00:00:00',10,2,20),(21,'TEST','BOSH','2024-04-01 00:00:00',10,0,0),(22,'TEST','IT','2024-04-01 00:00:00',10,2,20),(23,'ben','IT','2024-04-15 00:00:00',10,0,0),(24,'ben','BOSH','2024-04-16 00:00:00',122,0,0),(25,'iyt','IT','2024-04-16 00:00:00',10,3,30);
/*!40000 ALTER TABLE `reports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `UserId` int NOT NULL,
  `Passwd` varchar(240) NOT NULL,
  `UserType` varchar(240) NOT NULL,
  `Name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (123,'123','AAdministrator','kadava'),(1234,'1234','student','ben'),(12345,'12345','student','ben'),(1234567,'12345678','Student','ben'),(123456789,'123456789','student','JAKE'),(1515,'alfred','student','Alfred'),(123453,'123456','student','ben1002'),(10100,'gojo123','student','Gojo123'),(1234321,'123','student','ben'),(21121,'1232123','student','212'),(60888,'123','student','MENARD'),(1234567890,'TEST123','student','TEST'),(231,'sdafsd','student','dasd'),(1233333,'1233','student','DEN'),(909,'iyt','student','iyt');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-02 14:06:02
