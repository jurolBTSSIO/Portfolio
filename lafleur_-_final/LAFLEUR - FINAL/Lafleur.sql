-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Lun 16 Mars 2015 à 15:16
-- Version du serveur: 5.5.41
-- Version de PHP: 5.3.10-1ubuntu3.16

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `Lafleur`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `cat_code` varchar(3) NOT NULL,
  `cat_libelle` varchar(50) NOT NULL,
  PRIMARY KEY (`cat_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`cat_code`, `cat_libelle`) VALUES
('bul', 'Bulbes'),
('mas', 'Plantes à massif'),
('ros', 'Rosiers');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `id` varchar(3) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prix_unitaire` decimal(5,2) NOT NULL,
  `quantite` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`id`, `nom`, `prix_unitaire`, `quantite`) VALUES
('b01', '3 bulbes de bégonias', 5.00, 17),
('m02', 'Bouquet de 6 pensées', 6.00, 6);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `pdt_ref` varchar(3) NOT NULL,
  `pdt_designation` varchar(50) NOT NULL,
  `pdt_prix` decimal(5,2) NOT NULL,
  `pdt_image` text NOT NULL,
  `pdt_categorie` varchar(3) NOT NULL,
  PRIMARY KEY (`pdt_ref`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`pdt_ref`, `pdt_designation`, `pdt_prix`, `pdt_image`, `pdt_categorie`) VALUES
('b01', '3 bulbes de bégonias', 5.00, '<img src="bulbes_begonia.jpg">', 'bul'),
('b02', '10 bulbes de dahlias', 12.00, '<img src="bulbes_dahlia.jpg">', 'bul'),
('b03', '50 glaïeuls', 9.00, '<img src="bulbes_glaieul.jpg">', 'bul'),
('m01', 'Lot de 3 marguerites', 5.00, '<img src="massif_marguerite.jpg">', 'mas'),
('m02', 'Bouquet de 6 pensées', 6.00, '<img src="massif_pensee.jpg">', 'mas'),
('m03', 'Mélange varié de 10 plantes à massif', 15.00, '<img src="massif_melange.jpg">', 'mas'),
('m04', 'Pivoine Rose', 17.00, '<img src="pivoine_rose.jpg">', 'mas'),
('r01', '1 pied spécial grandes fleurs', 20.00, '<img src="rosiers_gdefleur.jpg">', 'ros'),
('r02', 'Une varieté sélectionnée pour son parfum', 9.00, '<img src="rosiers_parfum.jpg">', 'ros'),
('r03', 'Rosier arbuste', 8.00, '<img src="rosiers_arbuste.jpg">', 'ros');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
