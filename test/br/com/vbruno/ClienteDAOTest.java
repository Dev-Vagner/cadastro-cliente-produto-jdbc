package br.com.vbruno;

import br.com.vbruno.dao.ClienteDAO;
import br.com.vbruno.dao.IClienteDAO;
import br.com.vbruno.domain.Cliente;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Optional;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClienteTest {
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
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = clienteDAO.excluir(cliente.getCodigo());
        assertNotNull(qtdDel);
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
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = clienteDAO.excluir(cliente.getCodigo());
        assertNotNull(qtdDel);
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
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = clienteDAO.excluir(cliente.getCodigo());
        assertNotNull(qtdDel);
    }
}
