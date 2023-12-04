import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoImovelRepository {

    /**
     * Retorna uma lista de todos os tipos de imóveis no banco de dados.
     * @return Lista de tipos de imóveis.
     */
    public List<TipoImovel> listarTiposImovel() {
        List<TipoImovel> tiposImovel = new ArrayList<>();

        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "SELECT id, nome FROM tipo_imovel";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    TipoImovel tipoImovel = new TipoImovel();
                    tipoImovel.setId(resultSet.getInt("id"));
                    tipoImovel.setNome(resultSet.getString("nome"));
                    tiposImovel.add(tipoImovel);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar tipos de imóveis: " + e.getMessage(), e);
        }

        return tiposImovel;
    }
 /**
     * Retorna um tipo de imóvel do banco de dados com base no ID.
     * @param id O ID do tipo de imóvel a ser buscado.
     * @return O tipo de imóvel encontrado, ou null se não for encontrado.
     */
    public TipoImovel buscarTipoImovelPorId(int id) {
        TipoImovel tipoImovel = null;

        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "SELECT nome FROM tipo_imovel WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        tipoImovel = new TipoImovel();
                        tipoImovel.setId(id);
                        tipoImovel.setNome(resultSet.getString("nome"));
                        // Preencher outros atributos conforme necessário
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar tipo de imóvel por ID: " + e.getMessage(), e);
        }

        return tipoImovel;
    }
    /**
     * Adiciona um novo tipo de imóvel ao banco de dados.
     * @param tipoImovel O tipo de imóvel a ser adicionado.
     */
    public void adicionarTipoImovel(TipoImovel tipoImovel) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "INSERT INTO TipoImovel (nome) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, tipoImovel.getNome());
                statement.executeUpdate();

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    tipoImovel.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter chave gerada para TipoImovel.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar tipo de imóvel: " + e.getMessage(), e);
        }
    }
    /**
     * Atualiza as informações de um tipo de imóvel no banco de dados.
     * @param tipoImovel O tipo de imóvel a ser atualizado.
     */
    public void atualizarTipoImovel(TipoImovel tipoImovel) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "UPDATE tipoimovel SET nome=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, tipoImovel.getNome());
                statement.setInt(2, tipoImovel.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar tipo de imóvel: " + e.getMessage(), e);
        }
    }

    /**
     * Exclui um tipo de imóvel do banco de dados com base no ID.
     * @param id O ID do tipo de imóvel a ser excluído.
     */
    public void excluirTipoImovel(int id) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "DELETE FROM tipo_imovel WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir tipo de imóvel: " + e.getMessage(), e);
        }
    }
}
