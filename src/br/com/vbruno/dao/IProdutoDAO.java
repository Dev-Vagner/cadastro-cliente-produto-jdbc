package br.com.vbruno.dao;

import br.com.vbruno.domain.Cliente;
import br.com.vbruno.domain.Produto;

import java.sql.SQLException;
import java.util.List;

public interface IProdutoDAO {
    Integer cadastrar(Produto produto) throws SQLException;
    Produto consultar(String codigo) throws SQLException;
    List<Produto> consultarTodos() throws SQLException;
    Integer editar(Produto produto) throws SQLException;
    Integer excluir(String codigo) throws SQLException;
}
