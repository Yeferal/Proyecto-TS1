-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: calendariomaya
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `calendariocholqij`
--

CREATE DATABASE calendariomaya;
USE calendariomaya;

DROP TABLE IF EXISTS calendariocholqij;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE calendariocholqij (
  id int NOT NULL AUTO_INCREMENT,
  nahual int NOT NULL,
  energia int NOT NULL,
  fecha date NOT NULL,
  descripcion varchar(5000) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_Id_Nagual (nahual),
  KEY FK_Id_Energia (energia),
  CONSTRAINT FK_Id_Energia FOREIGN KEY (energia) REFERENCES energia (id),
  CONSTRAINT FK_Id_Nagual FOREIGN KEY (nahual) REFERENCES nahual (id)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `calendariohaab`
--

DROP TABLE IF EXISTS calendariohaab;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE calendariohaab (
  id int NOT NULL AUTO_INCREMENT,
  nahual int NOT NULL,
  winal int NOT NULL,
  nombre varchar(35) NOT NULL,
  fecha date NOT NULL,
  descripcion varchar(5000) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_Id_Nahual (nahual),
  KEY FK_Id_Winal (winal),
  CONSTRAINT FK_Id_Nahual FOREIGN KEY (nahual) REFERENCES nahual (id),
  CONSTRAINT FK_Id_Winal FOREIGN KEY (winal) REFERENCES winal (id)
) ENGINE=InnoDB AUTO_INCREMENT=366 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cargador`
--

DROP TABLE IF EXISTS cargador;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE cargador (
  nombre varchar(10) NOT NULL,
  descripcion varchar(45) NOT NULL,
  rutaImagen varchar(80) DEFAULT NULL,
  id int DEFAULT NULL,
  PRIMARY KEY (nombre)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS categoria;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE categoria (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `categorizar`
--

DROP TABLE IF EXISTS categorizar;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE categorizar (
  idHechoHistorico int NOT NULL,
  idCategoria int NOT NULL,
  KEY FK_IDCATEGORIA_CATEGORIZAR_CATEGORIA (idCategoria),
  KEY FK_IDHECHO_CATEGORIZAR_HECHOHISTORICO (idHechoHistorico),
  CONSTRAINT FK_IDCATEGORIA_CATEGORIZAR_CATEGORIA FOREIGN KEY (idCategoria) REFERENCES categoria (id),
  CONSTRAINT FK_IDHECHO_CATEGORIZAR_HECHOHISTORICO FOREIGN KEY (idHechoHistorico) REFERENCES hechohistorico (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `edicion`
--

DROP TABLE IF EXISTS edicion;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE edicion (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(35) NOT NULL,
  idHechoHistorico int NOT NULL,
  fecha date NOT NULL,
  creacion tinyint(1) NOT NULL,
  PRIMARY KEY (id),
  KEY FK_ID_TEMA (idHechoHistorico),
  KEY FK_ID_USER_R (username),
  CONSTRAINT FK_ID_TEMA FOREIGN KEY (idHechoHistorico) REFERENCES hechohistorico (id),
  CONSTRAINT FK_ID_USER_R FOREIGN KEY (username) REFERENCES usuario (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `energia`
--

DROP TABLE IF EXISTS energia;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE energia (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(15) NOT NULL,
  rutaImagen varchar(80) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hechohistorico`
--

DROP TABLE IF EXISTS hechohistorico;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE hechohistorico (
  id int NOT NULL AUTO_INCREMENT,
  fechaInicio date NOT NULL,
  fechaFinalizacion date NOT NULL,
  titulo varchar(150) DEFAULT NULL,
  descripcion varchar(5000) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `informacion`
--

DROP TABLE IF EXISTS informacion;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE informacion (
  id int NOT NULL AUTO_INCREMENT,
  titulo varchar(50) NOT NULL,
  descripcion varchar(5000) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `nahual`
--

DROP TABLE IF EXISTS nahual;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE nahual (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(35) DEFAULT NULL,
  fechaInicio date NOT NULL,
  fechaFinalizacion date NOT NULL,
  rutaImagen varchar(80) DEFAULT NULL,
  significado varchar(100) DEFAULT NULL,
  descripcion varchar(5000) DEFAULT NULL,
  nombreSp varchar(35) DEFAULT NULL,
  nombreYucateco varchar(35) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS rol;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE rol (
  id int NOT NULL AUTO_INCREMENT,
  tipo varchar(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS usuario;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE usuario (
  username varchar(40) NOT NULL,
  `password` varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  nombre varchar(50) NOT NULL,
  apellido varchar(50) NOT NULL,
  nacimiento date DEFAULT NULL,
  telefono varchar(15) DEFAULT NULL,
  rol int NOT NULL,
  PRIMARY KEY (username),
  KEY FK_ROL_ROLES (rol),
  CONSTRAINT FK_ROL_ROLES FOREIGN KEY (rol) REFERENCES rol (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `winal`
--

DROP TABLE IF EXISTS winal;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE winal (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(10) NOT NULL,
  descripcion varchar(45) NOT NULL,
  dias int DEFAULT NULL,
  rutaImagen varchar(80) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
