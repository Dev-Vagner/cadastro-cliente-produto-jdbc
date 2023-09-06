package br.com.vbruno.dao.jdbc;

import br.com.vbruno.VariaveisGlobais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;
    private ConnectionFactory(Connection connection){

    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = initConnection();
        } else if (connection != null && connection.isClosed()){
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() {
        try{
            return DriverManager.getConnection(
                    VariaveisGlobais.urlPostgreSQL, VariaveisGlobais.userPostgreSQL, VariaveisGlobais.passwordPostgreSQL
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
