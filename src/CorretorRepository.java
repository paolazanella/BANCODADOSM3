import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CorretorRepository {

    /**
     * Retorna uma lista de todos os corretores no banco de dados.
     * @return Lista de corretores.
     */
    public List<Corretor> listarCorretores() {
        List<Corretor> corretores = new ArrayList<>();

        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "SELECT id, imobiliariaNome, nome, cpf, creci, telefone, senha, email FROM corretor";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Corretor corretor = new Corretor();
                    corretor.setId(resultSet.getInt("id"));
                    corretor.setImobiliariaNome(resultSet.getString("imobiliariaNome"));
                    corretor.setNome(resultSet.getString("nome"));
                    corretor.setCpf(resultSet.getInt("cpf"));
                    corretor.setCreci(resultSet.getInt("creci"));
                    corretor.setTelefone(resultSet.getInt("telefone"));
                    corretor.setSenha(resultSet.getString("senha"));
                    corretor.setEmail(resultSet.getString("email"));
                    corretores.add(corretor);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar corretores: " + e.getMessage(), e);
        }

        return corretores;
    }
    public Corretor buscarCorretorPorId(int id) {
        Corretor corretor = null;
    
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "SELECT imobiliariaNome, nome, cpf, creci, telefone, senha, email FROM corretor WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        corretor = new Corretor();
                        corretor.setId(id);
                        corretor.setImobiliariaNome(resultSet.getString("imobiliariaNome"));
                        corretor.setNome(resultSet.getString("nome"));
                        corretor.setCpf(resultSet.getInt("cpf"));
                        corretor.setCreci(resultSet.getInt("creci"));
                        corretor.setTelefone(resultSet.getInt("telefone"));
                        corretor.setSenha(resultSet.getString("senha"));
                        corretor.setEmail(resultSet.getString("email"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar corretor por ID: " + e.getMessage(), e);
        }
    
        return corretor;
    }
    

    /**
     * Adiciona um novo corretor ao banco de dados.
     * @param corretor O corretor a ser adicionado.
     */
    public void adicionarCorretor(Corretor corretor) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "INSERT INTO corretor (imobiliariaNome, nome, cpf, creci, telefone, senha, email) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, corretor.getImobiliariaNome());
                statement.setString(2, corretor.getNome());
                statement.setInt(3, corretor.getCpf());
                statement.setInt(4, corretor.getCreci());
                statement.setInt(5, corretor.getTelefone());
                statement.setString(6, corretor.getSenha());
                statement.setString(7, corretor.getEmail());
                statement.executeUpdate();

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    corretor.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar corretor: " + e.getMessage(), e);
        }
    }

    /**
     * Atualiza as informações de um corretor no banco de dados.
     * @param corretor O corretor a ser atualizado.
     */
    public void atualizarCorretor(Corretor corretor) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "UPDATE corretor SET imobiliariaNome=?, nome=?, cpf=?, creci=?, telefone=?, senha=?, email=? " +
                         "WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, corretor.getImobiliariaNome());
                statement.setString(2, corretor.getNome());
                statement.setInt(3, corretor.getCpf());
                statement.setInt(4, corretor.getCreci());
                statement.setInt(5, corretor.getTelefone());
                statement.setString(6, corretor.getSenha());
                statement.setString(7, corretor.getEmail());
                statement.setInt(8, corretor.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar corretor: " + e.getMessage(), e);
        }
    }

    /**
     * Exclui um corretor do banco de dados com base no ID.
     * @param id O ID do corretor a ser excluído.
     */
    public void excluirCorretor(int id) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "DELETE FROM corretor WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir corretor: " + e.getMessage(), e);
        }
    }
}
