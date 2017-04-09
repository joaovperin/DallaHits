/**
 * Author:  Joaov
 * Created: 09/04/2017
 */
CREATE TABLE IF NOT EXISTS `Usuario` (
  `Login` VARCHAR(80) NOT NULL COMMENT 'Nome',
  `Senha` VARCHAR(32) NOT NULL COMMENT 'Senha',
  `Nome` VARCHAR(120) NOT NULL COMMENT 'Nome',
  `Tipo` VARCHAR(1) NOT NULL DEFAULT 'R' COMMENT 'Tipo',
  PRIMARY KEY (`Login`));