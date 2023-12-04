import java.util.List;

public class EnderecoController {

    private EnderecoRepository enderecoRepository;

    public EnderecoController() {
        this.enderecoRepository = new EnderecoRepository();
    }

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.listarEnderecos();
    }
    
    public Endereco buscarEnderecoPorId(int id) {
        return enderecoRepository.buscarEnderecoPorId(id);
    }

    public void adicionarEndereco(Endereco endereco) {
        enderecoRepository.adicionarEndereco(endereco);
    }

    public void atualizarEndereco(Endereco endereco) {
        enderecoRepository.atualizarEndereco(endereco);
    }

    public void excluirEndereco(int id) {
        enderecoRepository.excluirEndereco(id);
    }
}
