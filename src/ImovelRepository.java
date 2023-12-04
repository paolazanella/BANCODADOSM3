import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImovelRepository {
    /**
     * Retorna uma lista de todos os imóveis no banco de dados.
     * @return Lista de imóveis.
     */
    public List<Imovel> listarImoveis() {
        List<Imovel> imoveis = new ArrayList<>();

        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "SELECT id, tamanho, preco FROM imovel";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Imovel imovel = new Imovel();
                    imovel.setId(resultSet.getInt("id"));
                    imovel.setTamanho(resultSet.getFloat("tamanho"));
                    imovel.setPreco(resultSet.getFloat("preco"));
                    // Preencher outros atributos conforme necessário
                    imoveis.add(imovel);
                }
            }
        } catch (SQLException e) {
            // Tratamento mais apropriado, como logar o erro ou lançar uma exceção personalizada
            throw new RuntimeException("Erro ao listar imóveis: " + e.getMessage(), e);
        }

        return imoveis;
    }

    /**
     * Adiciona um novo imóvel ao banco de dados.
     * @param imovel O imóvel a ser adicionado.
     */
    public void adicionarImovel(Imovel imovel) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "INSERT INTO imovel (tamanho, preco) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setFloat(1, imovel.getTamanho());
                statement.setFloat(2, imovel.getPreco());
                // Setar outros parâmetros conforme necessário
                statement.executeUpdate();

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    imovel.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            // Tratamento mais apropriado, como logar o erro ou lançar uma exceção personalizada
            throw new RuntimeException("Erro ao adicionar imóvel: " + e.getMessage(), e);
        }
    }
     /**
     * Retorna um imóvel do banco de dados com base no ID.
     * @param id O ID do imóvel a ser buscado.
     * @return O imóvel encontrado, ou null se não for encontrado.
     */
    public Imovel buscarImovelPorId(int id) {
        Imovel imovel = null;

        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "SELECT tamanho, preco FROM imovel WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        imovel = new Imovel();
                        imovel.setId(id);
                        imovel.setTamanho(resultSet.getFloat("tamanho"));
                        imovel.setPreco(resultSet.getFloat("preco"));
                        // Preencher outros atributos conforme necessário
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar imóvel por ID: " + e.getMessage(), e);
        }

        return imovel;
    }

    /**
     * Atualiza as informações de um imóvel no banco de dados.
     * @param imovel O imóvel a ser atualizado.
     */
    public void atualizarImovel(Imovel imovel) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "UPDATE imovel SET tamanho=?, preco=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setFloat(1, imovel.getTamanho());
                statement.setFloat(2, imovel.getPreco());
                // Setar outros parâmetros conforme necessário
                statement.setInt(3, imovel.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            // Tratamento mais apropriado, como logar o erro ou lançar uma exceção personalizada
            throw new RuntimeException("Erro ao atualizar imóvel: " + e.getMessage(), e);
        }
    }

    /**
     * Exclui um imóvel do banco de dados com base no ID.
     * @param id O ID do imóvel a ser excluído.
     */
    public void excluirImovel(int id) {
        try (Connection connection = ConexaoJDBC.conectar()) {
            String sql = "DELETE FROM imovel WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            // Tratamento mais apropriado, como logar o erro ou lançar uma exceção personalizada
            throw new RuntimeException("Erro ao excluir imóvel: " + e.getMessage(), e);
        }
    }
}
