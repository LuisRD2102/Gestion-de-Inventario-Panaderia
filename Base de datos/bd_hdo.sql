-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_hdo
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `contactos`
--

DROP TABLE IF EXISTS `contactos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contactos` (
  `Codigo de Proveedor` int NOT NULL,
  `Nombre` varchar(21) NOT NULL,
  `Apellido` varchar(21) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Telefono` varchar(25) NOT NULL,
  `Domicilio Fiscal` varchar(101) NOT NULL,
  `Cedula` varchar(10) NOT NULL,
  `RIF` varchar(11) NOT NULL,
  PRIMARY KEY (`Codigo de Proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactos`
--

LOCK TABLES `contactos` WRITE;
/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
INSERT INTO `contactos` VALUES (1,'Lios','gsj','l@gmail.com','(1111) 111-1111','sugfdjhffffffffffffffffff','11.111.111',''),(2,'Juan','','2@h.com','(2222) 222-2222','2222','22.222.222','');
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `costos`
--

DROP TABLE IF EXISTS `costos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `costos` (
  `No. Factura` int unsigned NOT NULL,
  `No. Control` int NOT NULL,
  `Codigo de Proveedor` int NOT NULL,
  `Fecha de emision` date NOT NULL,
  `Productos` longtext NOT NULL,
  `Total` double NOT NULL,
  PRIMARY KEY (`No. Factura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costos`
--

LOCK TABLES `costos` WRITE;
/*!40000 ALTER TABLE `costos` DISABLE KEYS */;
INSERT INTO `costos` VALUES (1,5,2,'2021-07-04','Leche,Leche de Vaca,1,01\nHuevos,Postura de gallina,1,1\n',2.32),(100,100,100,'2021-07-04','Leche,Leche de Vaca,5,5\n',29),(500,500,500,'2021-07-30','Leche,Leche de Vaca,1,1\n',1.16),(2121,2121,2121,'2021-07-06','Leche,Leche de Vaca,1,1\n',1.16);
/*!40000 ALTER TABLE `costos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota_credito`
--

DROP TABLE IF EXISTS `nota_credito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nota_credito` (
  `Factura de referencia` int unsigned NOT NULL,
  `Destinatario` varchar(45) NOT NULL,
  `Razon` tinytext NOT NULL,
  `Fecha` date NOT NULL,
  `Monto Original` double NOT NULL,
  `Monto Adicional` double NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_credito`
--

LOCK TABLES `nota_credito` WRITE;
/*!40000 ALTER TABLE `nota_credito` DISABLE KEYS */;
INSERT INTO `nota_credito` VALUES (2121,'Pedro','','2021-07-09',1.16,1,2.16),(2121,'Juan','','2021-07-09',1.16,1,2.16),(2121,'2.32','','2021-07-09',1.16,1.16,2.32),(2121,'Luis','200','2021-07-09',1.16,200,201.16),(2121,'Mañana','Mañana','2021-07-17',1.16,1.16,2.32);
/*!40000 ALTER TABLE `nota_credito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota_debito`
--

DROP TABLE IF EXISTS `nota_debito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nota_debito` (
  `Factura de referencia` int unsigned NOT NULL,
  `Destinatario` varchar(45) NOT NULL,
  `Razon` tinytext NOT NULL,
  `Fecha` date NOT NULL,
  `Monto original` double NOT NULL,
  `Monto adicional` double NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_debito`
--

LOCK TABLES `nota_debito` WRITE;
/*!40000 ALTER TABLE `nota_debito` DISABLE KEYS */;
INSERT INTO `nota_debito` VALUES (2121,'Pedro','','2021-07-06',1.16,58000,-57998.84),(2121,'Carlos','','2021-07-06',1.16,2900019721.8,-2900019720.6400003),(2121,'Carlillos','','2021-07-08',1.16,4000,-3998.84);
/*!40000 ALTER TABLE `nota_debito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `Nombre` varchar(20) NOT NULL,
  `Tipo GTIN` varchar(8) NOT NULL,
  `GTIN` varchar(15) NOT NULL,
  `Fecha de Caducidad` date NOT NULL,
  `Descripcion` varchar(101) NOT NULL,
  `Cantidad Disponible` int unsigned NOT NULL,
  PRIMARY KEY (`GTIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES ('Leche','GTIN-13','1111111111111','2021-07-04','Leche de Vaca',0),('Huevos','GTIN-13','1234564444444','2021-06-05','Postura de gallina',2800),('Harina','GTIN-13','2222222222222','2021-07-11','',0);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `Nombre` varchar(21) NOT NULL,
  `Apellido` varchar(21) NOT NULL,
  `Cedula` varchar(11) NOT NULL,
  `Telefono` varchar(25) NOT NULL,
  `Direccion` varchar(101) NOT NULL,
  `Email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Usuario` varchar(20) NOT NULL,
  `Contraseña` varchar(20) NOT NULL,
  `Tipo de Usuario` varchar(20) NOT NULL,
  `Bloqueado` tinyint NOT NULL,
  PRIMARY KEY (`Cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('Luis','Romero','27.223.224','(0424) 133-0853','Caracas','luisromerod21@gmail.com','Luis','123456','Administrador',0);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-09 17:56:50
