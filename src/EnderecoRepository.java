import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoRepository {

    /**
     * Retorna uma lista de todos os endereços no banco de dados.
     * @return Lista de endereços.
     */
    public List<Endereco> listarEnderecos() {
        List<Endereco> enderecos = new ArrayList<>();

        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "SELECT id, rua, bairro, cep, numero, complemento FROM endereco";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Endereco endereco = new Endereco();
                    endereco.setId(resultSet.getInt("id"));
                    endereco.setRua(resultSet.getString("rua"));
                    endereco.setBairro(resultSet.getString("bairro"));
                    endereco.setCep(resultSet.getInt("cep"));
                    endereco.setNumero(resultSet.getInt("numero"));
                    endereco.setComplemento(resultSet.getString("complemento"));
                    enderecos.add(endereco);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar endereços: " + e.getMessage(), e);
        }

        return enderecos;
    }
    
    /**
     * Retorna um endereço do banco de dados com base no ID.
     * @param id O ID do endereço a ser buscado.
     * @return O endereço encontrado, ou null se não for encontrado.
     */
    public Endereco buscarEnderecoPorId(int id) {
        Endereco endereco = null;

        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "SELECT rua, bairro, cep, numero, complemento FROM endereco WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        endereco = new Endereco();
                        endereco.setId(id);
                        endereco.setRua(resultSet.getString("rua"));
                        endereco.setBairro(resultSet.getString("bairro"));
                        endereco.setCep(resultSet.getInt("cep"));
                        endereco.setNumero(resultSet.getInt("numero"));
                        endereco.setComplemento(resultSet.getString("complemento"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar endereço por ID: " + e.getMessage(), e);
        }

        return endereco;
    }

    /**
     * Adiciona um novo endereço ao banco de dados.
     * @param endereco O endereço a ser adicionado.
     */
    public void adicionarEndereco(Endereco endereco) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "INSERT INTO endereco (rua, bairro, cep, numero, complemento) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, endereco.getRua());
                statement.setString(2, endereco.getBairro());
                statement.setInt(3, endereco.getCep());
                statement.setInt(4, endereco.getNumero());
                statement.setString(5, endereco.getComplemento());
                statement.executeUpdate();

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    endereco.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar endereço: " + e.getMessage(), e);
        }
    }

    /**
     * Atualiza as informações de um endereço no banco de dados.
     * @param endereco O endereço a ser atualizado.
     */
    public void atualizarEndereco(Endereco endereco) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "UPDATE endereco SET rua=?, bairro=?, cep=?, numero=?, complemento=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, endereco.getRua());
                statement.setString(2, endereco.getBairro());
                statement.setInt(3, endereco.getCep());
                statement.setInt(4, endereco.getNumero());
                statement.setString(5, endereco.getComplemento());
                statement.setInt(6, endereco.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar endereço: " + e.getMessage(), e);
        }
    }

    /**
     * Exclui um endereço do banco de dados com base no ID.
     * @param id O ID do endereço a ser excluído.
     */
    public void excluirEndereco(int id) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "DELETE FROM endereco WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir endereço: " + e.getMessage(), e);
        }
    }
}
