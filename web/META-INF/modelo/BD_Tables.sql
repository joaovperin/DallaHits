/* Gerado em 11/04/2017 23:44:11 por Joaov. */

DROP SCHEMA IF EXISTS `dallahits` ;
CREATE SCHEMA IF NOT EXISTS `dallahits` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `mensagem` (
  `idMsg` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'Código da mensagem',
  `Usuario` VARCHAR(80) NOT NULL COMMENT 'Usuário que escreveu',
  `Msg` VARCHAR(160) NOT NULL COMMENT 'Mensagem',
  PRIMARY KEY (`idMsg`),
  INDEX `Mensagem_Usuario_idx` (`Usuario` ASC),
  CONSTRAINT `FK_Mensagem_Usuario`
    FOREIGN KEY (`Usuario`)
    REFERENCES `usuario` (`Login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3;

CREATE TABLE IF NOT EXISTS `produto` (
  `idProduto` INT(10) NOT NULL AUTO_INCREMENT COMMENT 'Código',
  `Descricao` VARCHAR(120) NOT NULL COMMENT 'Descrição',
  `ValorUnitario` DECIMAL(8,2) NOT NULL COMMENT 'Valor unitário',
  PRIMARY KEY (`idProduto`))
ENGINE = InnoDB
AUTO_INCREMENT = 6;

CREATE TABLE IF NOT EXISTS `usuario` (
  `Login` VARCHAR(80) NOT NULL COMMENT 'Nome',
  `Email` VARCHAR(160) NOT NULL COMMENT 'Email',
  `Senha` VARCHAR(32) NOT NULL COMMENT 'Senha',
  `Nome` VARCHAR(120) NOT NULL COMMENT 'Nome',
  `Tipo` VARCHAR(1) NOT NULL DEFAULT 'R' COMMENT 'Tipo',
  PRIMARY KEY (`Login`))
ENGINE = InnoDB;

/* FIM */