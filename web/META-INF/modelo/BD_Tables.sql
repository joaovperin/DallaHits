CREATE TABLE IF NOT EXISTS Usuario (
  Login VARCHAR(80) NOT NULL COMMENT 'Login',
  Email VARCHAR(160) NOT NULL COMMENT 'Email',
  Senha VARCHAR(32) NOT NULL COMMENT 'Senha',
  Nome VARCHAR(120) NOT NULL COMMENT 'Nome',
  Tipo VARCHAR(1) NOT NULL DEFAULT 'R' COMMENT 'Tipo',
  PRIMARY KEY (Login))
ENGINE = InnoDB
;

CREATE TABLE IF NOT EXISTS Produto (
  idProduto BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'Código',
  Descricao VARCHAR(120) NOT NULL COMMENT 'Descrição',
  ValorUnitario DECIMAL(8,2) NOT NULL COMMENT 'Valor unitário',
  PRIMARY KEY (idProduto))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Cliente (
  idCliente BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'Código',
  Nome VARCHAR(120) NOT NULL COMMENT 'Nome',
  Sexo VARCHAR(1) NOT NULL COMMENT 'Sexo',
  Idade INT(3) NULL COMMENT 'Idade',
  PRIMARY KEY (idCliente))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Comanda (
  idComanda BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'Código',
  idCliente BIGINT(20) NOT NULL COMMENT 'Cliente vinculado',
  Data DATETIME NOT NULL COMMENT 'Data',
  ValorTotal DECIMAL(12,2) NOT NULL COMMENT 'Valor unitário',
  PRIMARY KEY (idComanda),
  INDEX Comanda_Cliente_idx (idCliente ASC),
  CONSTRAINT FK_Comanda_Cliente
    FOREIGN KEY (idCliente)
    REFERENCES Cliente (idCliente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Item_Comanda (
  idComanda BIGINT(20) NOT NULL COMMENT 'Código',
  Item BIGINT(20) NOT NULL COMMENT 'Item',
  Produto BIGINT(20) NOT NULL COMMENT 'Produto',
  Quantidade INT(10) NOT NULL COMMENT 'Quantidade',
  ValorTotalItem DECIMAL(12,2) NOT NULL COMMENT 'Total do Item',
  PRIMARY KEY (idComanda, Item),
  CONSTRAINT FK_Comanda_Item
    FOREIGN KEY (idComanda)
    REFERENCES Comanda (idComanda)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Mensagem (
  idMsg BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'Código da mensagem',
  Usuario VARCHAR(80) NOT NULL COMMENT 'Usuário que escreveu',
  Msg VARCHAR(160) NOT NULL COMMENT 'Mensagem',
  PRIMARY KEY (idMsg),
  INDEX Mensagem_Usuario_idx (Usuario ASC),
  CONSTRAINT FK_Mensagem_Usuario
    FOREIGN KEY (Usuario)
    REFERENCES usuario (Login)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Pessoas (
   Nome VARCHAR(200) NOT NULL COMMENT 'Nome',
   Email VARCHAR(120) NULL COMMENT 'E-mail',
   Idade INT(3) NOT NULL COMMENT 'Idade',
   PRIMARY KEY (Nome))
ENGINE = InnoDB;