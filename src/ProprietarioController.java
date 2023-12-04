import java.util.List;

public class ProprietarioController {

    private ProprietarioRepository proprietarioRepository;

    public ProprietarioController() {
        this.proprietarioRepository = new ProprietarioRepository();
    }

    public List<Proprietario> listarProprietarios() {
        return proprietarioRepository.listarProprietarios();
    }
    public Proprietario buscarProprietarioPorId(int id) {
        return proprietarioRepository.buscarProprietarioPorId(id);
    }

    public void adicionarProprietario(Proprietario proprietario) {
        proprietarioRepository.adicionarProprietario(proprietario);
    }

    public void atualizarProprietario(Proprietario proprietario) {
        proprietarioRepository.atualizarProprietario(proprietario);
    }

    public void excluirProprietario(int id) {
        proprietarioRepository.excluirProprietario(id);
    }
}
