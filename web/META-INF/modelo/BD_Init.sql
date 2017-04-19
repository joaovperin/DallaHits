INSERT INTO Usuario (Login, Email, Senha, Nome, Tipo) VALUES 
   ('joaovperin', 'joaovperin@live.com', '1234', 'João Victor', 'A'),
   ('admin', 'admin@dallahits.com', 'admin', 'Administrador', 'A'),
   ('fulano', 'fulanodetal@email.com', 'senha', 'Fulano de tal', 'R'),
   ('narnia', '', '2', 'Nárnia', 'A'),
   ('viccenzo', '', '1234', 'Jesus', 'A');

INSERT INTO Mensagem (Usuario, Msg) VALUES 
   ('joaovperin', 'batata'),
   ('admin', 'Bom dia, usuários');

INSERT INTO Produto (Descricao, ValorUnitario) VALUES 
   ('Batata', '12.50'), ('Vodka', '5.50'), ('Whisky', '11.00'), ('Água', '2.50'), ('Refri lata', '3.50'),
   ('FAR. AMIZADE A71	FARINHAS	', '10.99'),
   ('RLC 250 GR	EMBALAGENS - BOBINAS	', '10.99'),
   ('BERCO COQUETEL INTEGRAL LIGHT	BERCO DE PLASTICO	', '10.99'),
   ('COQUETEL INTEGRAL LIGHT 250 G	EMBALAGENS PLASTICAS - SACARIA	', '10.99'),
   ('PPLC- PASTEIS CALABRESA 280 GR	EMBALAGENS - CAIXAS PAPELAO	', '10.99'),
   ('ERVA MATE TRADICIONAL 1KG		', '10.99'),
   ('ERVA MATE TRADICIONAL 500G		', '10.99'),
   ('MASSA ESPAGUETE ESPINAFRE 500G		', '10.99'),
   ('PASTEL DE FORNO MEDIO 300G.		', '10.99'),
   ('FRESA TOPO RET 2C MD K40 TINAL		', '10.99'),
   ('MASSA FOLHADA ROLO 300G', '10.99'),
   ('PASTEL PRONTO DE CARNE 280G		', '10.99'),
   ('PASTEL PRONTO DE CARNE 1000G		', '10.99'),
   ('PASTEL PRONTO DE QUEIJO 280G		', '10.99'),
   ('PASTEL PRONTO DE QUEIJO 1000G		', '10.99'),
   ('MASSA COLORIDA		', '10.99'),
   ('RETALHO RAVIOLI 500g		', '10.99'),
   ('RAVIOLI DE CARNE 250G		', '10.99'),
   ('RAVIOLI QUATRO QUEIJOS 1000G		', '10.99'),
   ('MARC.PROPRIA RCR47		', '10.99'),
   ('MARC.PROPRIA RFR51		', '10.99'),
   ('RAVIOLI QUATRO QUEIJOS 250G		', '10.99'),
   ('RAVIOLI DE FRANGO 1000G		', '10.99'),
   ('RAVIOLI DE FRANGO ROMANHA 2KG		', '10.99'),
   ('RAVIOLI DE CARNE ROMANHA 2KG		', '10.99'),
   ('EXTRATO DE TOMATE 270GR		', '10.99'),
   ('RETALHO DE CAPELETTI 500G		', '10.99'),
   ('RETALHO CAPELETTI LEGUMES 500G		', '10.99'),
   ('CAPELLETI DE CARNE		', '10.99'),
   ('SORVETE NAPOLITANO		', '10.99'),
   ('CAP. 5 QUEIJOS DE KILO		', '10.99'),
   ('MARC.PROPRIA CCR46', '10.99'),
   ('MARC.PROPRIA CFR50', '10.99'),
   ('CAPELETTI DE LEGUMES 250G		', '10.99'),
   ('CAPELETTI DE FRANGO 1000G		', '10.99'),
   ('CAPELLETI DE CARNE ROMANHA', '10.99'),
   ('PASTEL PRONTO DE CARNE 280G', '10.99'),
   ('PASTEL PRONTO DE CARNE 1000G', '10.99'),
   ('PASTEL PRONTO DE QUEIJO 280G', '10.99'),
   ('PASTEL PRONTO DE QUEIJO 1000G', '10.99'),
   ('MASSA COLORIDA', '10.99'),
   ('RETALHO RAVIOLI 500g', '10.99'),
   ('RAVIOLI DE CARNE 250G', '10.99'),
   ('RAVIOLI QUATRO QUEIJOS 1000G', '10.99'),
   ('MARC.PROPRIA RCR47', '10.99'),
   ('MARC.PROPRIA RFR51', '10.99'),
   ('RAVIOLI QUATRO QUEIJOS 250G', '10.99'),
   ('RAVIOLI DE FRANGO 1000G', '10.99'),
   ('RAVIOLI DE FRANGO ROMANHA 2KG', '10.99'),
   ('RAVIOLI DE CARNE ROMANHA 2KG', '10.99'),
   ('EXTRATO DE TOMATE 270GR', '10.99'),
   ('RETALHO DE CAPELETTI 500G', '10.99'),
   ('RETALHO CAPELETTI LEGUMES 500G', '10.99'),
   ('CAPELLETI DE CARNE', '10.99'),
   ('SORVETE NAPOLITANO', '10.99'),
   ('CAP. 5 QUEIJOS DE KILO', '10.99'),
   ('MARC.PROPRIA CCR46', '10.99'),
   ('MARC.PROPRIA CFR50', '10.99'),
   ('CAPELETTI DE LEGUMES 250G', '10.99'),
   ('CAPELETTI DE FRANGO 1000G', '10.99'),
   ('CAPELLETI DE CARNE ROMANHA 2KG', '10.99'),
   ('G', '10.99'),
   ('BISCOITO MARIA', '10.99'),
   ('BISCOITO MIGNON', '10.99'),
   ('BISCOITO AGUA E SAL', '10.99'),
   ('BISCOITO FOLHADO DOCE', '10.99'),
   ('FARINHA DE ROSCA', '10.99'),
   ('FARINHA DE ROSCA', '10.99'),
   ('FARINHA DE ROSCA', '10.99'),
   ('PRODUTO TESTE', '10.99'),
   ('FARINHA ROSCA', '10.99'),
   ('CANUDINHOS', '10.99'),
   ('QUEIJO RALADO', '10.99'),
   ('MASSA CASEIRA PAVIOLI', '10.99'),
   ('MACARRAO TIPO GRAVATA', '10.99'),
   ('BATATA PALHA', '10.99'),
   ('BATATA PALHA', '10.99');

INSERT INTO Pessoa VALUES 
   ('Tousif', 'tousif@mail.com', 32), 
   ('Asif', 'asif@mail.com', 28),
   ('Ramiz', 'ramiz@mail.com', 26),
   ('Rizwan', 'rizwan@mail.com', 32),
   ('Amol', 'amol@mail.com', 33),
   ('Ramdas', 'ramdas@mail.com', 31);

INSERT INTO Cliente (Nome, Sexo, Idade) VALUES 
   ('Fabinho', 'M', 23),
   ('Matheus', 'F', 21),
   ('Juca', 'M', 23),
   ('Andressa', 'F', 21),
   ('Júlia', 'F', 19),
   ('Eduarda', 'F', 20);

INSERT INTO Comanda (idCliente, idUsuario, Data, ValorTotal) VALUES 
   (1, 1, '2017-02-14 19:13:55', '23.50'),
   (2, 1, '2017-02-14 20:32:11', '28.90'),
   (3, 2, '2017-03-14 21:13:10', '32.00'),
   (4, 2, '2017-03-14 21:13:32', '30'),
   (5, 2, '2017-04-14 18:32:49', '0.00'),
   (6, 3, '2017-04-14 18:33:11', '0');

INSERT INTO Item_Comanda (idComanda, Item, Produto, Quantidade, ValorTotalItem) 
   VALUES (1, 1, 1, 2, '5.00'), (1, 2, 2, 1, '12.00'), (1, 3, 4, 1, '5.00');

INSERT INTO Item_Comanda (idComanda, Item, Produto, Quantidade, ValorTotalItem) 
   VALUES (2, 1, 1, 2, '2.40'), (2, 2, 2, 1, '8.99'), (2, 3, 4, 1, '52.00');