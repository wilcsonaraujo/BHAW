-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bhaw
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materia` (
  `materia_id` int(11) NOT NULL AUTO_INCREMENT,
  `materia_nome` varchar(45) NOT NULL,
  PRIMARY KEY (`materia_id`),
  UNIQUE KEY `materia_id_UNIQUE` (`materia_id`),
  UNIQUE KEY `materia_nome_UNIQUE` (`materia_nome`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `produto_id` int(11) NOT NULL AUTO_INCREMENT,
  `produto_nome` varchar(50) DEFAULT NULL,
  `produto_preco` float DEFAULT NULL,
  `produto_quantidade` int(11) DEFAULT NULL,
  `produto_descricao` varchar(140) DEFAULT NULL,
  `produto_ativo` varchar(1) DEFAULT NULL,
  `produto_status` varchar(15) DEFAULT 'disponivel',
  `data_registro` datetime DEFAULT NULL,
  `produto_click` int(11) DEFAULT '0',
  PRIMARY KEY (`produto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Livro de algoritmo',152.2,1,'Produto utilizado por um semestre','s','disponivel',NULL,0),(2,'Calculadora',25.98,2,'Novo','n','indisponivel',NULL,0),(3,'Calculadora',21.5,2,'Novo','s','disponivel',NULL,0),(4,'Regua',5.85,1,'Novo','s','disponivel',NULL,0),(5,'Borracha',2.3,4,'Teste','s','disponivel',NULL,0),(6,'Calculadora',54.65,1,'novo',NULL,'disponivel',NULL,0),(7,'Livro calculo',48.6,1,'Novo',NULL,'disponivel',NULL,0);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `usuario_cpf` varchar(11) NOT NULL,
  `usuario_nome` varchar(50) DEFAULT NULL,
  `usuario_telefone` varchar(11) DEFAULT NULL,
  `usuario_email` varchar(50) DEFAULT NULL,
  `usuario_senha` varchar(10) DEFAULT NULL,
  `usuario_ativo` varchar(1) DEFAULT 's',
  `data_registro` datetime DEFAULT NULL,
  PRIMARY KEY (`usuario_cpf`),
  UNIQUE KEY `usuario_cpf` (`usuario_cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('11111111','Amanda Cristina Pereira Santos','31975016216','contatoacps@gmail.com','123456','s',NULL),('11111111111','Joao','31365896','c@teste.com','123456','s',NULL),('1234567890','Amanda Cristina Pereira Santos','31975016216','contatoacps@gmail.com','123456','s',NULL),('12345678956','Paulo','316589745','lll@teste.com','123456','s',NULL),('12365478985','Joaquim','2223325','teste@teste.com','123456','s',NULL),('14785236972','Amanda','3134532288','amanda@teste.com','123456','s',NULL),('14785236985','teste1','316589','oioioi','123456','s',NULL),('22222222222','Maria','3165896989','s@teste,com','123456','s',NULL),('74185296332','teste','365896874','etstauah','123456','s',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `venda_id` int(11) NOT NULL AUTO_INCREMENT,
  `produto_id` int(11) NOT NULL,
  `vendedor_id` varchar(11) NOT NULL,
  `usuario_id` varchar(11) NOT NULL,
  `venda_status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`venda_id`),
  UNIQUE KEY `venda_id_UNIQUE` (`venda_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,2,'12345678996','11111111111','Aguardando'),(2,3,'12345678996','11111111111','Confirmado'),(3,3,'11111111111','22222222222','Confirmado');
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-18 22:10:45
