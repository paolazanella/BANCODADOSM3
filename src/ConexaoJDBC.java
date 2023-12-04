import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC do MySQL não encontrado.", e);
        }
    }

    /**
     * Método para estabelecer uma conexão com o banco de dados.
     * @return A conexão estabelecida.
     */
    public static Connection conectar() {
        Connection connection = null;
        try {
            // Informações de conexão
            String url = "jdbc:mysql://localhost:3306/imobiliariabd_m3";
            String user = "root";
            String password = "master";
            
            // Estabelecer a conexão
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return connection;
    }

    /**
     * Método para fechar uma conexão com o banco de dados.
     * @param connection A conexão a ser fechada.
     */
    public void fecharConexao(Connection connection) {
        try {
            // Verificar se a conexão está aberta antes de fechar
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}
