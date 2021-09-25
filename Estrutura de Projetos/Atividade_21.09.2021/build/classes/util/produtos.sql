SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE DATABASE IF NOT EXISTS `produtos` DEFAULT CHARACTER SET utf8 ;
USE `produtos` ;

CREATE TABLE IF NOT EXISTS `produtos`.`produtos` (
  `id_produto` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `preco` FLOAT(8,2) NOT NULL,
  `custo` FLOAT(8,2) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `quantidade` INT(11) NOT NULL,
  `status` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id_produto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `produtos` (`id_produto`, `nome`, `preco`, `custo`, `marca`, `quantidade`, `status`) VALUES
	(1, 'Placa de Vídeo', 1200.00, 899.00, 'NVidia', 4, 1),
	(2, 'Monitor', 1999.00, 1199.00, 'Sony', 4, 0),
	(3, 'Teclado', 150.00, 100.00, 'HyperX', 123, 0),
	(4, 'Mouse', 60.00, 30.00, 'Logitech', 6, 1),
	(5, 'Processador', 1500.00, 1100.00, 'Intel', 21, 1),
	(6, 'Cooler', 55.00, 25.00, 'DAS', 56, 0),
	(7, 'Placa Mãe', 455.00, 320.00, 'HTJ', 3, 1),
	(8, 'Memória RAM', 50.00, 20.00, 'Kingston', 35, 0),
	(9, 'SSD', 450.00, 325.00, 'Kingston', 24, 1),
	(10, 'HD', 100.00, 45.00, 'Samsung', 44, 0),
	(11, 'Gabinete', 200.00, 125.00, 'ATC', 3, 1),
	(12, 'Estabilizador', 80.00, 55.00, 'ATX', 5, 1),
	(13, 'Fonte', 123.00, 123.00, 'ABD', 111111, 0);
