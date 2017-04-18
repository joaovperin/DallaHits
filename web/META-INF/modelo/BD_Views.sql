CREATE OR REPLACE VIEW View_Comandas AS
   SELECT
        c.idComanda,
        c.idCliente,
        cl.Nome as 'Cliente',
        usu.Nome as 'Usuario', 
        c.Data, c.ValorTotal
        FROM Comanda c
    LEFT JOIN
        Cliente cl ON c.idCliente = cl.idCliente
    LEFT JOIN
        Usuario usu ON usu.idUsuario = c.idUsuario;