/*
Navicat MySQL Data Transfer

Source Server         : Rebelion
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : mpturismo

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-19 07:47:51
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
  `VALOR` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hoteis
-- ----------------------------
INSERT INTO `hoteis` VALUES ('1', 'SP', 'MAEJOANA', '2018-11-14', '2018-11-17', '5', '8', '100.00');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of pacotes
-- ----------------------------
INSERT INTO `pacotes` VALUES ('1', '1', '1', '100', '0');

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
INSERT INTO `passagens` VALUES ('1', 'CWB', 'SP', '1000', '6', '2018-11-13');
INSERT INTO `passagens` VALUES ('2', 'SP', 'CWB', '1000', '30', '2018-11-14');
