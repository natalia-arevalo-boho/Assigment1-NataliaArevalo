-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 04, 2024 at 05:17 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `artists`
--

-- --------------------------------------------------------

--
-- Table structure for table `artists`
--

CREATE TABLE `artists` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `most_popular_year` int(11) DEFAULT NULL,
  `musical_genre` varchar(100) DEFAULT NULL,
  `formation_year` int(11) DEFAULT NULL,
  `end_year` varchar(100) DEFAULT NULL,
  `youtube_views_2022` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artists`
--

INSERT INTO `artists` (`id`, `name`, `most_popular_year`, `musical_genre`, `formation_year`, `end_year`, `youtube_views_2022`) VALUES
(1, 'Coldplay', 2002, 'Rock', 1996, 'Still active', 100),
(2, 'Eminem', 2000, 'Hip-hop', 1996, 'Still active', 140),
(3, 'Beyoncé', 2003, 'Pop', 1997, 'Still active', 80),
(4, 'Linkin Park', 2000, 'Alternative Rock', 1996, '2017 (after the death of Chester Bennington)', 120),
(5, 'Adele', 2011, 'Pop', 2006, 'Still active', 60),
(6, 'Taylor Swift', 2008, 'Pop', 2004, 'Still active', 150),
(7, 'Drake', 2009, 'Hip-hop', 2006, 'Still active', 200),
(8, 'Lady Gaga', 2008, 'Pop', 2005, 'Still active', 90),
(9, 'Ed Sheeran', 2011, 'Pop', 2005, 'Still active', 250),
(10, 'Kanye West', 2004, 'Hip-hop', 1996, 'Still active', 70);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artists`
--
ALTER TABLE `artists`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artists`
--
ALTER TABLE `artists`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
