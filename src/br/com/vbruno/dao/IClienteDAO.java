package br.com.vbruno.dao;

import br.com.vbruno.domain.Cliente;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface IClienteDAO {
    Integer cadastrar(Cliente cliente) throws SQLException;
    Cliente consultar(String codigo) throws SQLException;
    List<Cliente> consultarTodos() throws SQLException;
    Integer editar(Cliente cliente) throws SQLException;
    Integer excluir(String codigo) throws SQLException;
}
