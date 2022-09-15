-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: love_pet
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal` (
  `id_animal` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `raca` varchar(45) NOT NULL,
  `peso` int DEFAULT NULL,
  `tipo` varchar(7) DEFAULT NULL,
  `porte` varchar(5) DEFAULT NULL,
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`id_animal`),
  KEY `fk_animal_cliente1_idx` (`id_cliente`),
  CONSTRAINT `fk_animal_cliente1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal_has_pedido`
--

DROP TABLE IF EXISTS `animal_has_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal_has_pedido` (
  `id_animal` int NOT NULL,
  `id_pedido` int NOT NULL,
  PRIMARY KEY (`id_animal`,`id_pedido`),
  KEY `fk_animal_has_pedido_pedido1_idx` (`id_pedido`),
  KEY `fk_animal_has_pedido_animal1_idx` (`id_animal`),
  CONSTRAINT `fk_animal_has_pedido_animal1` FOREIGN KEY (`id_animal`) REFERENCES `animal` (`id_animal`),
  CONSTRAINT `fk_animal_has_pedido_pedido1` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_has_pedido`
--

LOCK TABLES `animal_has_pedido` WRITE;
/*!40000 ALTER TABLE `animal_has_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `animal_has_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` text,
  `cpf` varchar(13) NOT NULL,
  `telefone_1` varchar(10) NOT NULL,
  `telefone_2` varchar(10) DEFAULT NULL,
  `id_endereco` int NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `fk_cliente_endereco_idx` (`id_endereco`),
  CONSTRAINT `fk_cliente_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `id_endereco` int NOT NULL AUTO_INCREMENT,
  `cep` varchar(10) NOT NULL,
  `rua` varchar(100) NOT NULL,
  `numero` int NOT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `bairro` varchar(30) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `estado` varchar(2) NOT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco_has_pedido`
--

DROP TABLE IF EXISTS `endereco_has_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco_has_pedido` (
  `id_endereco` int NOT NULL,
  `id_pedido` int NOT NULL,
  PRIMARY KEY (`id_endereco`,`id_pedido`),
  KEY `fk_endereco_has_pedido_pedido1_idx` (`id_pedido`),
  KEY `fk_endereco_has_pedido_endereco1_idx` (`id_endereco`),
  CONSTRAINT `fk_endereco_has_pedido_endereco1` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`),
  CONSTRAINT `fk_endereco_has_pedido_pedido1` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco_has_pedido`
--

LOCK TABLES `endereco_has_pedido` WRITE;
/*!40000 ALTER TABLE `endereco_has_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco_has_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id_pedido` int NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `horario` time NOT NULL,
  `quant_animal` int NOT NULL,
  `horario_busca` time NOT NULL,
  `horario_entrega` time NOT NULL,
  `status` varchar(20) NOT NULL,
  `preco_inicial` double NOT NULL,
  `preco_final` double NOT NULL,
  `desconto` double DEFAULT NULL,
  `tempo_execucao` time DEFAULT NULL,
  `forma_pagto` varchar(15) NOT NULL,
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `fk_pedido_cliente1_idx` (`id_cliente`),
  CONSTRAINT `fk_pedido_cliente1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_has_servico`
--

DROP TABLE IF EXISTS `pedido_has_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido_has_servico` (
  `id_pedido` int NOT NULL,
  `id_servico` int NOT NULL,
  PRIMARY KEY (`id_pedido`,`id_servico`),
  KEY `fk_pedido_has_Servico_Servico1_idx` (`id_servico`),
  KEY `fk_pedido_has_Servico_pedido1_idx` (`id_pedido`),
  CONSTRAINT `fk_pedido_has_Servico_pedido1` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`),
  CONSTRAINT `fk_pedido_has_Servico_Servico1` FOREIGN KEY (`id_servico`) REFERENCES `servico` (`id_servico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_has_servico`
--

LOCK TABLES `pedido_has_servico` WRITE;
/*!40000 ALTER TABLE `pedido_has_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido_has_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servico` (
  `id_servico` int NOT NULL AUTO_INCREMENT,
  `nome_servico` varchar(15) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `valor_servico` double NOT NULL,
  `tempo_servico` time NOT NULL,
  PRIMARY KEY (`id_servico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico_has_animal`
--

DROP TABLE IF EXISTS `servico_has_animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servico_has_animal` (
  `id_servico` int NOT NULL,
  `id_animal` int NOT NULL,
  PRIMARY KEY (`id_servico`,`id_animal`),
  KEY `fk_Servico_has_animal_animal1_idx` (`id_animal`),
  KEY `fk_Servico_has_animal_Servico1_idx` (`id_servico`),
  CONSTRAINT `fk_Servico_has_animal_animal1` FOREIGN KEY (`id_animal`) REFERENCES `animal` (`id_animal`),
  CONSTRAINT `fk_Servico_has_animal_Servico1` FOREIGN KEY (`id_servico`) REFERENCES `servico` (`id_servico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico_has_animal`
--

LOCK TABLES `servico_has_animal` WRITE;
/*!40000 ALTER TABLE `servico_has_animal` DISABLE KEYS */;
/*!40000 ALTER TABLE `servico_has_animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'love_pet'
--

--
-- Dumping routines for database 'love_pet'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-14 22:39:52
