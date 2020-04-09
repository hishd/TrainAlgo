-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Apr 09, 2020 at 01:47 PM
-- Server version: 8.0.18
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `traindb`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_stations`
--

DROP TABLE IF EXISTS `tbl_stations`;
CREATE TABLE IF NOT EXISTS `tbl_stations` (
  `station_id` int(11) NOT NULL AUTO_INCREMENT,
  `station_name` varchar(100) NOT NULL,
  PRIMARY KEY (`station_id`)
) ENGINE=MyISAM AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tbl_stations`
--

INSERT INTO `tbl_stations` (`station_id`, `station_name`) VALUES
(2, 'Dematagoda'),
(3, 'Kelaniya'),
(4, 'Wanawasala'),
(5, 'Hunupitiya'),
(6, 'Enderamulla'),
(7, 'Horape'),
(8, 'Ragama'),
(9, 'Walpola'),
(10, 'Batuwatte'),
(11, 'Bulugahagoda'),
(12, 'Ganemulla'),
(13, 'Yagoda'),
(14, 'Gampaha'),
(15, 'Daraluwa'),
(16, 'Bemmulla'),
(17, 'Magelegoda'),
(18, 'Heendeniya'),
(19, 'Veyangoda'),
(20, 'Wandurawa'),
(21, 'Keenawala'),
(22, 'Pallewala'),
(23, 'Ganegoda'),
(24, 'Wijayarajadahana'),
(25, 'Mihirigama'),
(26, 'Wilwatte'),
(27, 'Botale'),
(28, 'Abeypussa'),
(29, 'Yattalgoda'),
(30, 'Buthgamuwa'),
(31, 'Alawwa'),
(32, 'Wlakubura'),
(33, 'Poplgahawela'),
(34, 'Panaleeya'),
(35, 'Tismalpola'),
(36, 'Yatagama'),
(37, 'Rambukkana'),
(38, 'Kadigamuwa'),
(39, 'Gangoda'),
(40, 'Ihalakotte'),
(41, 'Balana'),
(42, 'Kadugannawa'),
(43, 'Pilimatalawa'),
(44, 'Peradeniya'),
(45, 'Koshinna'),
(46, 'Gelioya'),
(47, 'Gampola'),
(48, 'Tembligala'),
(49, 'Ulapone'),
(50, 'Nawalapitiya'),
(51, 'Inguruoya'),
(52, 'Galaboda'),
(53, 'Watawala'),
(54, 'Ihalawatawala'),
(55, 'Rosella'),
(56, 'Hatton'),
(57, 'Kotagala'),
(58, 'Talawakele'),
(59, 'watagoda'),
(60, 'Greatwestern'),
(61, 'Radella'),
(62, 'Nanuoya'),
(63, 'Perakumpura'),
(64, 'Ambewela'),
(65, 'Pattipola'),
(66, 'Ohiya'),
(67, 'Idalgasinna'),
(68, 'Haputale'),
(69, 'Deyatalawa'),
(70, 'Bandarawela'),
(71, 'Kinigama'),
(72, 'Heeloya'),
(73, 'Kitalelle'),
(74, 'Elle'),
(75, 'Demodara'),
(76, 'Uduwara'),
(77, 'Haliela'),
(78, 'Badulla'),
(79, 'Sarasaviuyana'),
(80, 'Sarasaviuyana'),
(81, 'Mahaiyawa'),
(82, 'Katugastota'),
(83, 'Udatalawinna'),
(84, 'Wattegama'),
(85, 'Pathanpha'),
(86, 'Udaththawala'),
(87, 'Ukuwela'),
(88, 'Matale'),
(89, 'Peralanda'),
(90, 'Kandana'),
(91, 'Kapuwatte'),
(92, 'Tudella'),
(93, 'Kudahakapola'),
(94, 'Seeduwa'),
(95, 'Alawatupitiya'),
(96, 'Liyanagemulla'),
(97, 'Katunayake'),
(98, 'Kurana'),
(99, 'Negombo'),
(100, 'kattuwa');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
