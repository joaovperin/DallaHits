INSERT INTO Usuario VALUES ('joaovperin', 'joaovperin@live.com', '1234', 'João Victor', 'A');
INSERT INTO Usuario VALUES ('admin', 'admin@dallahits.com', 'admin', 'Administrador', 'A');
INSERT INTO Usuario VALUES ('fulano', 'fulanodetal@email.com', 'senha', 'Fulano de tal', 'R');
INSERT INTO Usuario VALUES ('narnia', '', '2', 'Nárnia', 'A');
INSERT INTO Usuario VALUES ('viccenzo', '', '1234', 'Jesus', 'A');

INSERT INTO Mensagem (Usuario, Msg) VALUES ('joaovperin', 'batata');
INSERT INTO Mensagem (Usuario, Msg) VALUES ('admin', 'Bom dia, usuários');

INSERT INTO Produto (Descricao, ValorUnitario) VALUES ('Batata', '12.50');
INSERT INTO Produto (Descricao, ValorUnitario) VALUES ('Vodka', '5.50');
INSERT INTO Produto (Descricao, ValorUnitario) VALUES ('Whisky', '11.00');
INSERT INTO Produto (Descricao, ValorUnitario) VALUES ('Água', '2.50');
INSERT INTO Produto (Descricao, ValorUnitario) VALUES ('Refri lata', '3.50');

INSERT INTO Pessoa VALUES ('Tousif', 'tousif@mail.com', 32);
INSERT INTO Pessoa VALUES ('Asif', 'asif@mail.com', 28);
INSERT INTO Pessoa VALUES ('Ramiz', 'ramiz@mail.com', 26);
INSERT INTO Pessoa VALUES ('Rizwan', 'rizwan@mail.com', 32);
INSERT INTO Pessoa VALUES ('Amol', 'amol@mail.com', 33);
INSERT INTO Pessoa VALUES ('Ramdas', 'ramdas@mail.com', 31);

INSERT INTO Cliente (Nome, Sexo, Idade) VALUES ('Fabinho', 'M', 23);
INSERT INTO Cliente (Nome, Sexo, Idade) VALUES ('Matheus', 'F', 21);
INSERT INTO Cliente (Nome, Sexo, Idade) VALUES ('Juca', 'M', 23);
INSERT INTO Cliente (Nome, Sexo, Idade) VALUES ('Andressa', 'F', 21);
INSERT INTO Cliente (Nome, Sexo, Idade) VALUES ('Júlia', 'F', 19);
INSERT INTO Cliente (Nome, Sexo, Idade) VALUES ('Eduarda', 'F', 20);

INSERT INTO Comanda (idCliente, Data, ValorTotal) VALUES (1, '2017-02-14 19:13:55', '23.50');
INSERT INTO Comanda (idCliente, Data, ValorTotal) VALUES (2, '2017-02-14 20:32:11', '28.90');
INSERT INTO Comanda (idCliente, Data, ValorTotal) VALUES (3, '2017-03-14 21:13:10', '32.00');
INSERT INTO Comanda (idCliente, Data, ValorTotal) VALUES (4, '2017-03-14 21:13:32', '30');
INSERT INTO Comanda (idCliente, Data, ValorTotal) VALUES (5, '2017-04-14 18:32:49', '0.00');
INSERT INTO Comanda (idCliente, Data, ValorTotal) VALUES (6, '2017-04-14 18:33:11', '0');

INSERT INTO Item_Comanda (idComanda, Item, Produto, Quantidade, ValorTotalItem) 
   VALUES (1, 1, 1, 2, '5.00'), (1, 2, 2, 1, '12.00'), (1, 3, 4, 1, '5.00');

INSERT INTO Item_Comanda (idComanda, Item, Produto, Quantidade, ValorTotalItem) 
   VALUES (2, 1, 1, 2, '2.40'), (2, 2, 2, 1, '8.99'), (2, 3, 4, 1, '52.00');