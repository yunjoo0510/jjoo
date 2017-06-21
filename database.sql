-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.1.22-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- pentakill 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `pentakill` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pentakill`;

-- 테이블 pentakill.co2 구조 내보내기
CREATE TABLE IF NOT EXISTS `co2` (
  `Time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CO2_Value` int(4) DEFAULT NULL,
  `Metro_Num` int(4) DEFAULT NULL,
  PRIMARY KEY (`Time_stamp`),
  KEY `FK_metro_co2` (`Metro_Num`),
  CONSTRAINT `FK_metro_co2` FOREIGN KEY (`Metro_Num`) REFERENCES `metro` (`Metro_Num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='CO2';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 pentakill.image 구조 내보내기
CREATE TABLE IF NOT EXISTS `image` (
  `Image_Value` int(11) NOT NULL AUTO_INCREMENT,
  `Metro_Num` int(11) DEFAULT NULL,
  `Start_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Image_Value`),
  KEY `FK_metro_image` (`Metro_Num`,`Start_Time`),
  KEY `Start_Time` (`Start_Time`),
  KEY `Metro_Num` (`Metro_Num`)
) ENGINE=InnoDB AUTO_INCREMENT=123128 DEFAULT CHARSET=utf8 COMMENT='image processing';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 pentakill.metro 구조 내보내기
CREATE TABLE IF NOT EXISTS `metro` (
  `Metro_Num` int(11) NOT NULL,
  `Start_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Direction` char(50) DEFAULT NULL,
  PRIMARY KEY (`Metro_Num`,`Start_Time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Subway';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 pentakill.station 구조 내보내기
CREATE TABLE IF NOT EXISTS `station` (
  `Station_name` varchar(50) NOT NULL,
  `Metro_Num` int(11) DEFAULT NULL,
  `Start_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Station_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
