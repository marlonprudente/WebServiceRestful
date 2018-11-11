/*
Navicat MySQL Data Transfer

Source Server         : Rebelion
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : mpturismo

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-11 21:24:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hoteis`
-- ----------------------------
DROP TABLE IF EXISTS `hoteis`;
CREATE TABLE `hoteis` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CIDADE` varchar(255) NOT NULL,
  `NOMEHOTEL` varchar(255) NOT NULL,
  `DATAENTRADA` date NOT NULL,
  `DATASAIDA` date NOT NULL,
  `QUANTIDADEQUARTOS` int(11) NOT NULL,
  `NUMEROMAXPESSOAS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hoteis
-- ----------------------------

-- ----------------------------
-- Table structure for `pacotes`
-- ----------------------------
DROP TABLE IF EXISTS `pacotes`;
CREATE TABLE `pacotes` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PassagemID` int(11) NOT NULL,
  `HotelID` int(11) NOT NULL,
  `Valor` decimal(10,0) NOT NULL,
  `QantidadePessoas` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of pacotes
-- ----------------------------

-- ----------------------------
-- Table structure for `passagens`
-- ----------------------------
DROP TABLE IF EXISTS `passagens`;
CREATE TABLE `passagens` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ORIGEM` varchar(255) NOT NULL,
  `DESTINO` varchar(255) NOT NULL,
  `VALOR` decimal(10,0) NOT NULL,
  `POLTRONAS` int(10) unsigned DEFAULT NULL,
  `DATA` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of passagens
-- ----------------------------
INSERT INTO `passagens` VALUES ('1', 'CWB', 'SP', '1000', '10', '2018-11-13');
INSERT INTO `passagens` VALUES ('2', 'SP', 'CWB', '1000', '40', '2018-11-14');
