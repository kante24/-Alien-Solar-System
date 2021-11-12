-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : ven. 12 nov. 2021 à 04:16
-- Version du serveur :  10.4.19-MariaDB
-- Version de PHP : 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `AlienSolarSystem`
--

-- --------------------------------------------------------

--
-- Structure de la table `AstreCeleste`
--

CREATE TABLE `AstreCeleste` (
  `NomAstre` text NOT NULL,
  `TailleAstre` int(11) NOT NULL,
  `CouleurAstre` text NOT NULL,
  `StatusAstre` tinyint(1) NOT NULL,
  `NomImageAstre` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `AstreCeleste`
--

INSERT INTO `AstreCeleste` (`NomAstre`, `TailleAstre`, `CouleurAstre`, `StatusAstre`, `NomImageAstre`) VALUES
('Terre', 100, 'Bleu', 0, 'earthe.jpg'),
('Jupiter', 100, 'Blanc_Rouge', 0, 'jupiter.jpg'),
('Pluton', 100, 'Rouge', 0, 'pluton.jpg'),
('Venus', 100, 'Jaune', 0, 'venus.jpg');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
