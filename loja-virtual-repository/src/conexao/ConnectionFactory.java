package conexao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.postgresql.ds.PGConnectionPoolDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private PGConnectionPoolDataSource poolDataSource;
    private DataSource dataSource;

    public ConnectionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost/loja_virtual");
        comboPooledDataSource.setUser("postgres");
        comboPooledDataSource.setPassword("senha1");
        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSource = comboPooledDataSource;

        /*
        PGConnectionPoolDataSource pool = new PGConnectionPoolDataSource();
        pool.setUrl("jdbc:postgresql://localhost/loja_virtual");
        pool.setUser("postgres");
        pool.setPassword("senha1");

        this.poolDataSource = pool;
        */
    }

    public Connection obterConexao() throws SQLException {
        return this.dataSource.getConnection();
        /*
        this.poolDataSource.getParentLogger();
        Connection connection = poolDataSource.getConnection();
        return connection;
        */
    }
/*
    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/loja_virtual",
                "postgres",
                "senha1");

    }
 */
}
