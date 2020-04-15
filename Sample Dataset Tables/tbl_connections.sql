-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Apr 15, 2020 at 02:34 PM
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
-- Table structure for table `tbl_connections`
--

DROP TABLE IF EXISTS `tbl_connections`;
CREATE TABLE IF NOT EXISTS `tbl_connections` (
  `station_1` int(11) NOT NULL,
  `station_2` int(11) NOT NULL,
  `distance` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tbl_connections`
--

INSERT INTO `tbl_connections` (`station_1`, `station_2`, `distance`) VALUES
(1, 3, 50),
(1, 5, 30),
(1, 8, 43),
(1, 7, 78),
(5, 8, 40),
(3, 8, 35),
(8, 9, 70),
(2, 6, 55),
(6, 9, 60),
(2, 8, 45),
(5, 10, 80),
(10, 2, 25),
(4, 9, 75),
(4, 7, 90),
(9, 7, 65),
(6, 4, 50),
(6, 3, 85),
(3, 4, 40),
(3, 7, 65),
(5, 2, 35),
(10, 6, 80),
(7, 6, 90),
(5, 9, 75),
(1, 10, 60);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
