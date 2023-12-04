import java.util.Objects;

public class TipoImovel {
    private int id;
    private String nome;

    // Construtor vazio
    public TipoImovel() {
    }

    // Construtor com parâmetros
    public TipoImovel(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método toString para facilitar a visualização
    @Override
    public String toString() {
        return "TipoImovel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    // Método equals e hashCode para comparar objetos TipoImovel
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoImovel tipoImovel = (TipoImovel) o;
        return id == tipoImovel.id && Objects.equals(nome, tipoImovel.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
