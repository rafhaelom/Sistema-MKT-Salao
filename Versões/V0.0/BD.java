import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD{
    
    // Conexao com o Banco de Dados PostgreSQL
    private Connection con;
    
    public void abrir() throws SQLException {
        try {
            //             Caminho da classe Driver no JAR 
            Class.forName("org.postgresql.Driver");
            System.out.println("Achei o Driver");
            //                                 URL de conexao,         porta padrão,                         user,        senha
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nomedobanco?useSSL=false", "username", "password");
            System.out.println("Conectado ao PostgreSQL");
        } catch (ClassNotFoundException e) {
            System.out.println("Nome do Driver errado");
        }
    }
    
    public void fechar() throws SQLException {
        con.close();
    }

    public void executar() {
        try {
            abrir(); // Abrir a conexao
            fechar(); // Fechar a conexao
        } catch (SQLException e) {
            System.out.println("Nao consigo conexao: " + e.getMessage());
        }
    }
    
    public static void main(String [] args){
        new BD().executar();
    }
}
