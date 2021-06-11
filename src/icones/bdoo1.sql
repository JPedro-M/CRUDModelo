-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 31-Maio-2021 às 22:59
-- Versão do servidor: 5.7.31
-- versão do PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bdoo1`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbusuario`
--

DROP TABLE IF EXISTS `tbusuario`;
CREATE TABLE IF NOT EXISTS `tbusuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `email` varchar(150) NOT NULL,
  `senha` varchar(80) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbusuario`
--

INSERT INTO `tbusuario` (`id`, `nome`, `email`, `senha`, `tipo`) VALUES
(1, 'Jeferson Leon', 'jeferson@gmail.com', '1', 'adm'),
(2, 'Yasmin da Silveira', 'yasmin@ulbra.br', 'souloucaporalcoolemgel2021', 'usuaria'),
(3, 'JOÃO PEDRO MARQUES', 'j', '1', 'ADMINISTRADOR');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbveiculo`
--

DROP TABLE IF EXISTS `tbveiculo`;
CREATE TABLE IF NOT EXISTS `tbveiculo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(80) NOT NULL,
  `modelo` varchar(80) NOT NULL,
  `ano` int(11) NOT NULL,
  `cor` varchar(25) NOT NULL,
  `placa` varchar(8) NOT NULL,
  `motor` varchar(10) NOT NULL,
  `km` int(11) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbveiculo`
--

INSERT INTO `tbveiculo` (`id`, `marca`, `modelo`, `ano`, `cor`, `placa`, `motor`, `km`, `valor`) VALUES
(1, 'bmw', 'Tourer', 2000, 'preto', 'XXX-XXX', 'num sei', 555, '9999.99');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
