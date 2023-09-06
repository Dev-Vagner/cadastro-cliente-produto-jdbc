package br.com.vbruno;

import br.com.vbruno.dao.ClienteDAO;
import br.com.vbruno.dao.IClienteDAO;
import br.com.vbruno.domain.Cliente;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class ClienteDAOTest {
    IClienteDAO clienteDAO;
    Cliente cliente;

    @Test
    public void cadastrarTest() throws SQLException {
        clienteDAO = new ClienteDAO();
        cliente = new Cliente();

        cliente.setCodigo("01");
        cliente.setNome("Vagner");

        Integer qtd = clienteDAO.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = clienteDAO.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = clienteDAO.excluir(cliente.getCodigo());
        assertTrue(qtdDel == 1);
        Cliente clienteBDExcluido = clienteDAO.consultar(cliente.getCodigo());
        assertNull(clienteBDExcluido);
    }

    @Test
    public void consultarTest() throws SQLException {
        clienteDAO = new ClienteDAO();
        cliente = new Cliente();

        cliente.setCodigo("01");
        cliente.setNome("Vagner");

        Integer qtd = clienteDAO.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = clienteDAO.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = clienteDAO.excluir(cliente.getCodigo());
        assertTrue(qtdDel == 1);
        Cliente clienteBDExcluido = clienteDAO.consultar(cliente.getCodigo());
        assertNull(clienteBDExcluido);
    }

    @Test
    public void consultarTodosTest() throws SQLException {
        clienteDAO = new ClienteDAO();
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();

        cliente1.setCodigo("01");
        cliente1.setNome("Vagner");
        cliente2.setCodigo("02");
        cliente2.setNome("Kaline");
        cliente3.setCodigo("03");
        cliente3.setNome("Vânia");

        Integer qtd1 = clienteDAO.cadastrar(cliente1);
        assertTrue(qtd1 == 1);
        Integer qtd2 = clienteDAO.cadastrar(cliente2);
        assertTrue(qtd2 == 1);
        Integer qtd3 = clienteDAO.cadastrar(cliente3);
        assertTrue(qtd3 == 1);

        List<Cliente> clientesBD = clienteDAO.consultarTodos();
        assertTrue(clientesBD.size() >= 3);

        Integer qtdDel1 = clienteDAO.excluir(cliente1.getCodigo());
        assertTrue(qtdDel1 == 1);
        Integer qtdDel2 = clienteDAO.excluir(cliente2.getCodigo());
        assertTrue(qtdDel2 == 1);
        Integer qtdDel3 = clienteDAO.excluir(cliente3.getCodigo());
        assertTrue(qtdDel3 == 1);

        Cliente clienteBD1 = clienteDAO.consultar(cliente1.getCodigo());
        assertNull(clienteBD1);
        Cliente clienteBD2 = clienteDAO.consultar(cliente2.getCodigo());
        assertNull(clienteBD2);
        Cliente clienteBD3 = clienteDAO.consultar(cliente3.getCodigo());
        assertNull(clienteBD3);
    }

    @Test
    public void editarTest() throws SQLException {
        clienteDAO = new ClienteDAO();
        cliente = new Cliente();

        cliente.setCodigo("01");
        cliente.setNome("Vagner");

        Integer qtd = clienteDAO.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = clienteDAO.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        cliente.setId(clienteBD.getId());
        cliente.setCodigo("02");
        cliente.setNome("Socorro");
        Integer qtdEdit = clienteDAO.editar(cliente);
        assertTrue(qtdEdit == 1);
        assertNotEquals(clienteBD.getCodigo(), cliente.getCodigo());
        assertNotEquals(clienteBD.getNome(), cliente.getNome());

        Cliente clienteBD2 = clienteDAO.consultar(cliente.getCodigo());
        assertNotNull(clienteBD2);
        assertEquals(cliente.getCodigo(), clienteBD2.getCodigo());
        assertEquals(cliente.getNome(), clienteBD2.getNome());

        Integer qtdDel = clienteDAO.excluir(cliente.getCodigo());
        assertTrue(qtdDel == 1);
        Cliente clienteBDExcluido = clienteDAO.consultar(cliente.getCodigo());
        assertNull(clienteBDExcluido);
    }

    @Test
    public void excluirTest() throws SQLException {
        clienteDAO = new ClienteDAO();
        cliente = new Cliente();

        cliente.setCodigo("01");
        cliente.setNome("Vagner");

        Integer qtd = clienteDAO.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = clienteDAO.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = clienteDAO.excluir(cliente.getCodigo());
        assertTrue(qtdDel == 1);
        Cliente clienteBDExcluido = clienteDAO.consultar(cliente.getCodigo());
        assertNull(clienteBDExcluido);
    }
}
