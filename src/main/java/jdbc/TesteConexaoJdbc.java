package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexaoJdbc {

    public static void main(String[] args) throws SQLException {

        final String stringConexao = "jdbc:mysql://localhost:3306";
        final String usuario = "root";
        final String senha = "Cali020730";

        Connection conexao = DriverManager.getConnection(stringConexao, usuario, senha);

        System.out.println("Conexao efetuada com sucesso!");
        conexao.close();

    }
}
