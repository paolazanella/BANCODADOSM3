import java.util.Objects;

public class Corretor {
    private int id;
    private String imobiliariaNome;
    private String nome;
    private int cpf;
    private int creci;
    private int telefone;
    private String senha;
    private String email;

    // Construtor vazio
    public Corretor() {
    }

    // Construtor com parâmetros
    public Corretor(int id, String imobiliariaNome, String nome, int cpf, int creci, int telefone, String senha, String email) {
        this.id = id;
        this.imobiliariaNome = imobiliariaNome;
        this.nome = nome;
        this.cpf = cpf;
        this.creci = creci;
        this.telefone = telefone;
        this.senha = senha;
        this.email = email;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImobiliariaNome() {
        return imobiliariaNome;
    }

    public void setImobiliariaNome(String imobiliariaNome) {
        this.imobiliariaNome = imobiliariaNome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCreci() {
        return creci;
    }

    public void setCreci(int creci) {
        this.creci = creci;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método toString para facilitar a visualização
    @Override
    public String toString() {
        return "Corretor{" +
                "id=" + id +
                ", imobiliariaNome='" + imobiliariaNome + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", creci=" + creci +
                ", telefone=" + telefone +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // Método equals e hashCode para comparar objetos Corretor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corretor corretor = (Corretor) o;
        return id == corretor.id &&
                cpf == corretor.cpf &&
                creci == corretor.creci &&
                telefone == corretor.telefone &&
                Objects.equals(imobiliariaNome, corretor.imobiliariaNome) &&
                Objects.equals(nome, corretor.nome) &&
                Objects.equals(senha, corretor.senha) &&
                Objects.equals(email, corretor.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imobiliariaNome, nome, cpf, creci, telefone, senha, email);
    }
}
