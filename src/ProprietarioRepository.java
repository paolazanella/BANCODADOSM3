import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioRepository {

    /**
     * Retorna uma lista de todos os proprietários no banco de dados.
     * @return Lista de proprietários.
     */
    public List<Proprietario> listarProprietarios() {
        List<Proprietario> proprietarios = new ArrayList<>();

        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "SELECT id, nome, telefone, email, senha, cpf FROM proprietario";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Proprietario proprietario = new Proprietario();
                    proprietario.setId(resultSet.getInt("id"));
                    proprietario.setNome(resultSet.getString("nome"));
                    proprietario.setTelefone(resultSet.getInt("telefone"));
                    proprietario.setEmail(resultSet.getString("email"));
                    proprietario.setSenha(resultSet.getString("senha"));
                    proprietario.setCpf(resultSet.getInt("cpf"));
                    proprietarios.add(proprietario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar proprietários: " + e.getMessage(), e);
        }

        return proprietarios;
    }

    
    /**
     * Retorna um proprietário do banco de dados com base no ID.
     * @param id O ID do proprietário a ser buscado.
     * @return O proprietário encontrado, ou null se não for encontrado.
     */
    public Proprietario buscarProprietarioPorId(int id) {
        Proprietario proprietario = null;

        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "SELECT nome, telefone, email, senha, cpf FROM proprietario WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        proprietario = new Proprietario();
                        proprietario.setId(id);
                        proprietario.setNome(resultSet.getString("nome"));
                        proprietario.setTelefone(resultSet.getInt("telefone"));
                        proprietario.setEmail(resultSet.getString("email"));
                        proprietario.setSenha(resultSet.getString("senha"));
                        proprietario.setCpf(resultSet.getInt("cpf"));
                        // Preencher outros atributos conforme necessário
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar proprietário por ID: " + e.getMessage(), e);
        }

        return proprietario;
    }
    /**
     * Adiciona um novo proprietário ao banco de dados.
     * @param proprietario O proprietário a ser adicionado.
     */
    public void adicionarProprietario(Proprietario proprietario) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "INSERT INTO proprietario (nome, telefone, email, senha, cpf) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, proprietario.getNome());
                statement.setInt(2, proprietario.getTelefone());
                statement.setString(3, proprietario.getEmail());
                statement.setString(4, proprietario.getSenha());
                statement.setInt(5, proprietario.getCpf());
                statement.executeUpdate();

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    proprietario.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar proprietário: " + e.getMessage(), e);
        }
    }

    /**
     * Atualiza as informações de um proprietário no banco de dados.
     * @param proprietario O proprietário a ser atualizado.
     */
    public void atualizarProprietario(Proprietario proprietario) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "UPDATE proprietario SET nome=?, telefone=?, email=?, senha=?, cpf=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, proprietario.getNome());
                statement.setInt(2, proprietario.getTelefone());
                statement.setString(3, proprietario.getEmail());
                statement.setString(4, proprietario.getSenha());
                statement.setInt(5, proprietario.getCpf());
                statement.setInt(6, proprietario.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar proprietário: " + e.getMessage(), e);
        }
    }

    /**
     * Exclui um proprietário do banco de dados com base no ID.
     * @param id O ID do proprietário a ser excluído.
     */
    public void excluirProprietario(int id) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "DELETE FROM proprietario WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir proprietário: " + e.getMessage(), e);
        }
    }
}
