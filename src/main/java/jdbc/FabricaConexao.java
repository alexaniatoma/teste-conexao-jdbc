package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {

    public static Connection getConexao() {

        try {
            Properties prop = getProperties();
            final String stringConexao = prop.getProperty("banco.url");
            final String usuario = prop.getProperty("banco.usuario");
            final String senha = prop.getProperty("banco.senha");

           return DriverManager.getConnection(stringConexao, usuario, senha);

        }catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        InputStream stream = new FileInputStream("C:\\Users\\alexa\\IdeaProjects\\teste-conexao-jdbc\\src\\main\\java\\jdbc\\scratch.properties");
        prop.load(stream);
         return prop;

    }
}
