package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);

        System.out.print("Informe o código da pessoa: ");
        int codigo = scan.nextInt();

        Connection conexao = FabricaConexao.getConexao();
        String select = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
        String update = "UPDATE pessoas SET nome = ? WHERE codigo = ? ";

        PreparedStatement stmt = conexao.prepareStatement(select);
        stmt.setInt(1, codigo);
        ResultSet resultado = stmt.executeQuery();

        if(resultado.next()) {
            Pessoa pessoa = new Pessoa(resultado.getString(2), resultado.getInt(1));

            System.out.println("O nome atual é: " + pessoa.getNome());
            scan.nextLine();

            System.out.print("Informe o novo nome: ");
            String novoNome = scan.nextLine();

            stmt.close();
            stmt = conexao.prepareStatement(update);
            stmt.setString(1, novoNome);
            stmt.setInt(2, codigo);
            stmt.execute();

            System.out.println("Pessoa Alterada com Sucesso!");
        }
        else {
            System.out.println("Pessoa não encontrada!");
        }

        conexao.close();
        scan.close();

    }
}
