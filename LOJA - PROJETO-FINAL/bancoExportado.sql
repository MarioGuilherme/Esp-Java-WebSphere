-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.21-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para loja
CREATE DATABASE IF NOT EXISTS `loja` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `loja`;

-- Copiando estrutura para tabela loja.clients
CREATE TABLE IF NOT EXISTS `clients` (
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `cpf` char(11) NOT NULL,
  `rg` char(9) NOT NULL,
  `status` tinyint(4) NOT NULL COMMENT 'Tipo de dado que aceita 1 e 0, sendo:\n1 - Ativado\n0 - Desativado',
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela loja.clients: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` (`id_client`, `name`, `email`, `cpf`, `rg`, `status`) VALUES
	(1, 'Mário Guilherme', 'marioguilherme@gmail.com', '18723638947', '342345674', 1),
	(2, 'Lucas Oliveira', 'lucasoliveira@gmail.com', '95486798334', '236457567', 1),
	(3, 'Fabricio Sanvido', 'fabriociosanvido@gmail.com', '44444444444', '345242354', 1),
	(4, 'Gabriel Silva', 'gabrielsilva@gmail.com', '55344378679', '212315565', 1),
	(5, 'Carlos Eduardo', 'carloseduardo@gmail.com', '11234656878', '756756745', 1),
	(6, 'Julia Costas', 'juliascostas@gmail.com', '40958603954', '374658726', 1),
	(7, 'Fernando Henrique', 'fernandohenrique@gmail.com', '40578467985', '839748956', 1),
	(8, 'Vitor Martins', 'vitormartins@gmail.com', '23940947068', '658507946', 1),
	(9, 'André Neves', 'andreneves@gmail.com', '04985654706', '095674395', 1),
	(10, 'Alessandro Rodrigues', 'alessandrorodrigues@gmail.com', '50986709780', '389479384', 1);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;

-- Copiando estrutura para tabela loja.phones
CREATE TABLE IF NOT EXISTS `phones` (
  `id_phone` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int(11) NOT NULL,
  `phone` char(13) NOT NULL COMMENT '14999071316',
  PRIMARY KEY (`id_phone`),
  KEY `fk_phones_clients1_idx` (`id_client`),
  CONSTRAINT `fk_phones_clients1` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id_client`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela loja.phones: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `phones` DISABLE KEYS */;
INSERT INTO `phones` (`id_phone`, `id_client`, `phone`) VALUES
	(1, 1, '5514996034381'),
	(2, 2, '5514989989678'),
	(3, 3, '5514996567567'),
	(4, 4, '5514989897979'),
	(5, 5, '5514999767867'),
	(6, 6, '5514967568562'),
	(7, 7, '5514998977233'),
	(8, 8, '5514998997789'),
	(9, 1, '5514999071316'),
	(10, 1, '5514997275235');
/*!40000 ALTER TABLE `phones` ENABLE KEYS */;

-- Copiando estrutura para tabela loja.products
CREATE TABLE IF NOT EXISTS `products` (
  `id_product` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `price` float(8,2) NOT NULL,
  `cost` float(8,2) NOT NULL,
  `quantity` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT 'Tipo de dado que aceita 1 e 0, sendo:\n1 - Ativado\n0 - Desativado',
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela loja.products: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`id_product`, `name`, `price`, `cost`, `quantity`, `status`) VALUES
	(1, 'Placa de Vídeo', 1600.00, 1200.00, 20, 1),
	(2, 'Teclado', 100.00, 60.00, 32, 1),
	(3, 'Monitor', 500.00, 230.00, 12, 1),
	(4, 'Mouse', 120.00, 70.00, 8, 1),
	(5, 'Gabinete', 100.00, 20.00, 22, 1),
	(6, 'Processador', 2000.00, 1600.00, 21, 1),
	(7, 'Placa Mãe', 400.00, 320.00, 2, 1),
	(8, 'Memória RAM 12GB', 300.00, 230.00, 23, 1),
	(9, 'HeadSet MultiLaser', 200.00, 130.00, 43, 1),
	(10, 'SSD 512GB', 550.00, 430.00, 21, 1),
	(11, 'HD 1TB', 600.00, 300.00, 12, 1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;