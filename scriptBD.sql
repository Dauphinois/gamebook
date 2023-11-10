CREATE DATABASE  IF NOT EXISTS `gamebook` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gamebook`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: gamebook
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `directionchance`
--

DROP TABLE IF EXISTS `directionchance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directionchance` (
  `idDepart` int NOT NULL,
  `idArrivee` int NOT NULL,
  `Chance` double NOT NULL,
  PRIMARY KEY (`idDepart`,`idArrivee`),
  KEY `FK_idArrivee_idx` (`idArrivee`),
  CONSTRAINT `FK_idArriveeChance` FOREIGN KEY (`idArrivee`) REFERENCES `scene` (`idScene`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_idDepartChance` FOREIGN KEY (`idDepart`) REFERENCES `scene` (`idScene`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directionchance`
--

LOCK TABLES `directionchance` WRITE;
/*!40000 ALTER TABLE `directionchance` DISABLE KEYS */;
/*!40000 ALTER TABLE `directionchance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directionchoice`
--

DROP TABLE IF EXISTS `directionchoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directionchoice` (
  `idDepart` int NOT NULL,
  `idArrivee` int NOT NULL,
  `Texte` varchar(250) NOT NULL,
  PRIMARY KEY (`idDepart`,`idArrivee`),
  KEY `FK_idArrivee_idx` (`idArrivee`),
  CONSTRAINT `FK_idArriveeChoice` FOREIGN KEY (`idArrivee`) REFERENCES `scene` (`idScene`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_idDepartChoice` FOREIGN KEY (`idDepart`) REFERENCES `scene` (`idScene`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directionchoice`
--

LOCK TABLES `directionchoice` WRITE;
/*!40000 ALTER TABLE `directionchoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `directionchoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scene`
--

DROP TABLE IF EXISTS `scene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scene` (
  `idScene` int NOT NULL AUTO_INCREMENT,
  `Description` varchar(500) NOT NULL,
  PRIMARY KEY (`idScene`),
  UNIQUE KEY `Description_UNIQUE` (`Description`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scene`
--

LOCK TABLES `scene` WRITE;
/*!40000 ALTER TABLE `scene` DISABLE KEYS */;
INSERT INTO `scene` VALUES (1,'Le continent est divisé en 3 régions rivales. Le royaume de Queen, la Republique démocratique, populaire et bienveillante de Weimahr et l\'Empire Enmieux. Queen est un royaume intellectuel et très poussé dans le contre-espionnage. La République est une prison en plein air avec un dictateur tyrannique qui appauvrit le pays de jour en jour. L\'empire est une nation guerrière qui vit pour la conquête.');
/*!40000 ALTER TABLE `scene` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-10 20:38:52
