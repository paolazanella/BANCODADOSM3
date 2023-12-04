import java.util.Objects;

public class Endereco {
    private int id;
    private String rua;
    private String bairro;
    private int cep;
    private int numero;
    private String complemento;

    // Construtor vazio
    public Endereco() {
    }

    // Construtor com parâmetros
    public Endereco(int id, String rua, String bairro, int cep, int numero, String complemento) {
        this.id = id;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    // Método toString para facilitar a visualização
    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep=" + cep +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                '}';
    }

    // Método equals e hashCode para comparar objetos Endereco
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return id == endereco.id &&
                cep == endereco.cep &&
                numero == endereco.numero &&
                Objects.equals(rua, endereco.rua) &&
                Objects.equals(bairro, endereco.bairro) &&
                Objects.equals(complemento, endereco.complemento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rua, bairro, cep, numero, complemento);
    }
}
