-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2017 at 05:50 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `ID` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ingredience` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `price` decimal(14,2) NOT NULL,
  `vegetarian` tinyint(1) NOT NULL,
  `foodType` enum('starter','main','dessert','drink') COLLATE utf8_unicode_ci NOT NULL,
  `calories` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`ID`, `name`, `ingredience`, `price`, `vegetarian`, `foodType`, `calories`) VALUES
(1, 'ceps', 'mushroom,garlic', '10.50', 1, 'starter', 100),
(2, 'chicken', 'butter,onion,chiken,salt,peper', '15.50', 0, 'main', 300),
(3, 'clafoutis', 'milk,suger,flaur,eggse,vanilla', '12.99', 1, 'dessert', 250),
(4, 'martini', '', '7.98', 0, 'drink', 150),
(5, 'potato pie', 'potato,chees,creem,salt,peper', '10.99', 1, 'starter', 350),
(6, 'rosted vegeteable', 'potato,mushroom,onion,bell peper,carot,tomato,garlic,salt', '11.99', 1, 'main', 150),
(7, 'duck', 'duck,onion,carot,garlic,buter,vine,salt,peper', '19.99', 0, 'main', 550),
(8, 'fish', 'fish,garlic,limon jouse,salt,spice', '22.00', 0, 'main', 200),
(9, 'mousse', 'milk,creem,cacao,suger,vanilla', '12.99', 1, 'dessert', 350),
(10, 'lagoon', 'lagoon', '15.00', 1, 'drink', 200),
(11, 'foiegras', 'foiegrase,vine,olive oil,salt,tomato pat', '25.99', 0, 'starter', 550),
(12, 'pudding', 'age,salt,peper,floure,spice', '10.88', 0, 'starter', 200);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
