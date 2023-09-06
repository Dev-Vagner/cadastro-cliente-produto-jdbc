package br.com.vbruno;

import br.com.vbruno.dao.ClienteDAO;
import br.com.vbruno.dao.IProdutoDAO;
import br.com.vbruno.dao.ProdutoDAO;
import br.com.vbruno.domain.Cliente;
import br.com.vbruno.domain.Produto;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

public class ProdutoDAOTest {
    IProdutoDAO produtoDAO;
    Produto produto;

    @Test
    public void cadastrarTest() throws SQLException {
        produtoDAO = new ProdutoDAO();
        produto = new Produto();

        produto.setCodigo("01");
        produto.setNome("Notebook");

        Integer qtd = produtoDAO.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = produtoDAO.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer qtdDel = produtoDAO.excluir(produto.getCodigo());
        assertTrue(qtdDel == 1);
        Produto produtoBDExcluido = produtoDAO.consultar(produto.getCodigo());
        assertNull(produtoBDExcluido);
    }

    @Test
    public void consultarTest() throws SQLException {
        produtoDAO = new ProdutoDAO();
        produto = new Produto();

        produto.setCodigo("01");
        produto.setNome("Notebook");

        Integer qtd = produtoDAO.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = produtoDAO.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer qtdDel = produtoDAO.excluir(produto.getCodigo());
        assertTrue(qtdDel == 1);
        Produto produtoBDExcluido = produtoDAO.consultar(produto.getCodigo());
        assertNull(produtoBDExcluido);
    }

    @Test
    public void consultarTodosTest() throws SQLException {
        produtoDAO = new ProdutoDAO();
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        Produto produto3 = new Produto();

        produto1.setCodigo("01");
        produto1.setNome("Notebook");
        produto2.setCodigo("02");
        produto2.setNome("Garrafa");
        produto3.setCodigo("03");
        produto3.setNome("Mouse");

        Integer qtd1 = produtoDAO.cadastrar(produto1);
        assertTrue(qtd1 == 1);
        Integer qtd2 = produtoDAO.cadastrar(produto2);
        assertTrue(qtd2 == 1);
        Integer qtd3 = produtoDAO.cadastrar(produto3);
        assertTrue(qtd3 == 1);

        List<Produto> produtosBD = produtoDAO.consultarTodos();
        assertTrue(produtosBD.size() >= 3);

        Integer qtdDel1 = produtoDAO.excluir(produto1.getCodigo());
        assertTrue(qtdDel1 == 1);
        Integer qtdDel2 = produtoDAO.excluir(produto2.getCodigo());
        assertTrue(qtdDel2 == 1);
        Integer qtdDel3 = produtoDAO.excluir(produto3.getCodigo());
        assertTrue(qtdDel3 == 1);

        Produto produtoBD1 = produtoDAO.consultar(produto1.getCodigo());
        assertNull(produtoBD1);
        Produto produtoBD2 = produtoDAO.consultar(produto2.getCodigo());
        assertNull(produtoBD2);
        Produto produtoBD3 = produtoDAO.consultar(produto3.getCodigo());
        assertNull(produtoBD3);
    }

    @Test
    public void editarTest() throws SQLException {
        produtoDAO = new ProdutoDAO();
        produto = new Produto();

        produto.setCodigo("01");
        produto.setNome("Notebook");

        Integer qtd = produtoDAO.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = produtoDAO.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        produto.setId(produtoBD.getId());
        produto.setCodigo("02");
        produto.setNome("Garrafa");
        Integer qtdEdit = produtoDAO.editar(produto);
        assertTrue(qtdEdit == 1);
        assertNotEquals(produtoBD.getCodigo(), produto.getCodigo());
        assertNotEquals(produtoBD.getNome(), produto.getNome());

        Produto produtoBD2 = produtoDAO.consultar(produto.getCodigo());
        assertNotNull(produtoBD2);
        assertEquals(produto.getCodigo(), produtoBD2.getCodigo());
        assertEquals(produto.getNome(), produtoBD2.getNome());

        Integer qtdDel = produtoDAO.excluir(produto.getCodigo());
        assertTrue(qtdDel == 1);
        Produto produtoBDExcluido = produtoDAO.consultar(produto.getCodigo());
        assertNull(produtoBDExcluido);
    }

    @Test
    public void excluirTest() throws SQLException {
        produtoDAO = new ProdutoDAO();
        produto = new Produto();

        produto.setCodigo("01");
        produto.setNome("Notebook");

        Integer qtd = produtoDAO.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = produtoDAO.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer qtdDel = produtoDAO.excluir(produto.getCodigo());
        assertTrue(qtdDel == 1);
        Produto produtoBDExcluido = produtoDAO.consultar(produto.getCodigo());
        assertNull(produtoBDExcluido);
    }
}
