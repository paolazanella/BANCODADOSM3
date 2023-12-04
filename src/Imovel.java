import java.util.Objects;

public class Imovel {
    private int id;
    private Proprietario proprietario;
    private Corretor corretor;
    private TipoImovel tipoImovel;
    private Endereco endereco;
    private float tamanho;
    private float preco;

    // Construtor vazio
    public Imovel() {
    }

    // Construtor com parâmetros
    public Imovel(int id, Proprietario proprietario, Corretor corretor, TipoImovel tipoImovel,
                  Endereco endereco, float tamanho, float preco) {
        this.id = id;
        this.proprietario = proprietario;
        this.corretor = corretor;
        this.tipoImovel = tipoImovel;
        this.endereco = endereco;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(TipoImovel tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    // Método toString para facilitar a visualização
    @Override
    public String toString() {
        return "Imovel{" +
                "id=" + id +
                ", proprietario=" + proprietario +
                ", corretor=" + corretor +
                ", tipoImovel=" + tipoImovel +
                ", endereco=" + endereco +
                ", tamanho=" + tamanho +
                ", preco=" + preco +
                '}';
    }

    // Método equals e hashCode para comparar objetos Imovel
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imovel imovel = (Imovel) o;
        return id == imovel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
