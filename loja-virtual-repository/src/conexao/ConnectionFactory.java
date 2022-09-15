package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/loja_virtual",
                "postgres",
                "senha1");
    }
}
