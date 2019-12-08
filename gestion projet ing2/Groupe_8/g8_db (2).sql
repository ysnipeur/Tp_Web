-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 19 nov. 2019 à 08:12
-- Version du serveur :  5.7.21
-- Version de PHP :  7.1.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `g8_db`
--
CREATE DATABASE IF NOT EXISTS `g8_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `g8_db`;

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

DROP TABLE IF EXISTS `projet`;
CREATE TABLE IF NOT EXISTS `projet` (
  `code_proj` varchar(10) NOT NULL,
  `lib_proj` varchar(50) NOT NULL,
  `budget_proj` int(15) NOT NULL,
  `type_proj` varchar(50) NOT NULL,
  `avancement` int(3) NOT NULL,
  `statut` varchar(20) NOT NULL,
  `etat` tinyint(1) NOT NULL,
  `date_debut` datetime DEFAULT NULL,
  `date_fin` datetime DEFAULT NULL,
  `id_utilisateur` int(11) DEFAULT NULL,
  PRIMARY KEY (`code_proj`),
  KEY `fk_proj_user` (`id_utilisateur`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`code_proj`, `lib_proj`, `budget_proj`, `type_proj`, `avancement`, `statut`, `etat`, `date_debut`, `date_fin`, `id_utilisateur`) VALUES
('proj001', 'Education des enfants', 7000000, 'Conception', 12, 'Suspendu', 1, '2020-11-12 18:20:41', '2021-11-12 18:20:41', 1),
('proj002', 'Devenir Ingenieur', 12000000, 'Developpement', 70, 'En cours', 1, '2019-11-12 00:00:00', '2020-11-14 05:15:00', 2),
('proj003', 'Fiesta fin ING 2', 42000000, 'Evenement', 0, 'En cours', 1, '2019-11-30 20:15:00', '2019-12-01 07:15:00', 3),
('proj12', 'Conception de site Web', 458000, 'Conception', 40, 'En cours', 1, '2019-11-16 23:00:00', '2020-01-24 23:00:00', 0),
('projet45', 'Conception de jeux', 450000, 'Developpement', 1, 'Non Debuter', 1, '2019-11-21 23:00:00', '2019-12-28 23:00:00', 3),
('projet123', 'Tp Programmation Web', 459000, 'Conception', 100, 'Terminer', 0, '2019-11-21 23:00:00', '2019-12-28 23:00:00', 3),
('projet789', 'Conception de CV PRO', 450000, 'Developpement', 0, 'Terminer', 0, '2019-11-21 23:00:00', '2019-12-29 23:00:00', 3);

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

DROP TABLE IF EXISTS `tache`;
CREATE TABLE IF NOT EXISTS `tache` (
  `code_tc` varchar(10) NOT NULL,
  `design_tc` varchar(50) NOT NULL,
  `coutunit_tc` int(9) NOT NULL,
  `code_proj` varchar(10) NOT NULL,
  `avancement` int(3) NOT NULL,
  `statut` varchar(20) NOT NULL,
  `etat` tinyint(1) NOT NULL,
  `date_debut` datetime NOT NULL,
  `date_fin` datetime NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`code_tc`),
  KEY `fk_tache_proj` (`code_proj`),
  KEY `fk_tache_user` (`id_utilisateur`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `tache`
--

INSERT INTO `tache` (`code_tc`, `design_tc`, `coutunit_tc`, `code_proj`, `avancement`, `statut`, `etat`, `date_debut`, `date_fin`, `id_utilisateur`) VALUES
('tache001', 'formation des jeunes', 3200000, 'proj001', 12, 'En cours', 1, '2020-11-12 18:20:42', '2021-11-12 18:20:42', 4),
('tache002', 'sensibilisation de la population', 1200000, 'proj003', 97, 'Annuler', 0, '2020-11-12 18:20:42', '2021-11-12 18:20:42', 4),
('tache0010', 'Conception de site web', 560000, 'proj003', 0, 'Annuler', 0, '2019-11-28 23:00:00', '2019-11-29 23:00:00', 11),
('tache0011', 'Conception de Flyer', 58000, 'proj003', 100, 'Terminer', 0, '2019-11-20 23:00:00', '2019-11-26 23:00:00', 11),
('tache789', 'design des page authentification', 450000, 'proj003', 0, 'Non Debuter', 1, '2019-11-28 23:00:00', '2020-01-18 23:00:00', 0),
('tache45', 'conception', 78000, 'proj003', 56, 'En cours', 1, '2019-11-21 23:00:00', '2019-12-26 23:00:00', 11),
('tache78', 'Tache mouteke', 45000, 'proj002', 0, 'Non Debuter', 1, '2019-11-09 23:00:00', '2019-11-19 23:00:00', 6),
('tache365', 'redaction du rapport', 4500, 'proj002', 12, 'Suspendu', 1, '2019-11-28 23:00:00', '2019-12-27 23:00:00', 0),
('tache123', 'etude prealable', 456000, 'proj002', 0, 'Non Debuter', 1, '2019-11-28 23:00:00', '2019-12-19 23:00:00', 0),
('tache897', 'diagramme de sequence', 45000, 'proj002', 89, 'Annuler', 0, '2019-11-06 23:00:00', '2020-01-27 23:00:00', 13),
('tache89', 'conception du controlleur', 45800, 'projet123', 12, 'Non Debuter', 1, '2019-11-29 23:00:00', '2019-12-06 23:00:00', 0);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `fonction` varchar(50) DEFAULT NULL,
  `login` varchar(60) NOT NULL,
  `pwd` varchar(60) NOT NULL,
  `role` tinyint(1) NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `isFirstConnection` tinyint(1) NOT NULL,
  `createdBy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `fonction`, `login`, `pwd`, `role`, `statut`, `isFirstConnection`, `createdBy`) VALUES
(1, 'KOUEMOU', 'Samanta', 'Directeur Marketing en Chef', 'Samanta', 'Samanta', 1, 0, 0, 5),
(2, 'MOUTEKE', 'Destin', 'Directeur RH', 'Destin', 'Destin', 1, 1, 0, 5),
(3, 'TAKOUMBO', 'Yvan', 'Directeur Artistique', 'Yvan', 'Yvan', 1, 1, 0, 5),
(4, 'MOUSAVOU', 'Bryan', 'Developpeur IOS  MOBILE', 'Mousavou', 'Mousavou', 2, 1, 0, 2),
(5, 'SuperAdmin', 'SuperAdmin', NULL, 'Super', 'Super', 0, 1, 0, NULL),
(6, 'TAKOUMBO MBE', 'Bernard Yvan', 'Data Scientist', 'Takoumbo', 'Takoumbo', 2, 1, 1, 2),
(7, 'KOUEMOU', 'Samanta', 'Data Analyste', 'sami', 'sami', 2, 1, 1, 6),
(8, 'OURO AKPO', 'Khaled', 'Concepteur de Jeux IOS', 'khaled', 'khaled', 2, 1, 1, 2),
(9, 'AMOUSOUVI', 'Darel', 'Designer', 'darel', 'darel', 2, 0, 1, 2),
(10, 'NDONG', 'Bekale', 'Analyste', 'bekale', 'bekale', 2, 0, 1, 2),
(11, 'ADA ADA', 'Lauren', 'Secretaire generale', 'lauren', 'Lauren', 2, 1, 0, 3),
(12, 'NDONG', 'Makaya', 'Developpeur', 'makaya', 'makaya', 2, 1, 1, 1),
(13, 'MARIAM', 'Makaya', 'Developpeur Mobile', 'mariam', 'mariama', 2, 0, 0, 2),
(14, 'MARIAM', 'Makaya', 'Developpeur Mobile', 'mariam', 'mariam', 2, 1, 1, 2),
(15, 'AMOUSOUVI', 'Alexandre', 'Cuisinier maison', 'alexandre', 'alexandre', 2, 1, 1, 2),
(16, 'Professeur', 'Professeur', 'Enseignant', 'prof', 'prof', 2, 1, 1, 5),
(17, 'invite', 'invite', 'invite en chef', 'invite', 'snippeur', 2, 1, 0, 5),
(18, 'snippeur', 'snippeur', 'Tireur administrateur', 'snippeur', 'snippeur', 2, 1, 1, 5);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
