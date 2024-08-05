package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);

        Connection conexao = FabricaConexao.getConexao();
        String deleteSql = "DELETE FROM pessoas WHERE codigo = ?";

        System.out.print("Informe o código da pessoa: ");
        int codigo = scan.nextInt();

        PreparedStatement stmt = conexao.prepareStatement(deleteSql);
        stmt.setInt(1, codigo);

        if(stmt.executeUpdate() > 0 ) {
            System.out.println("Pessoa excluida com sucesso!");
        }
        else {
            System.out.println("Não houve exclusão!");
        }

        scan.close();
        conexao.close();
    }

}
