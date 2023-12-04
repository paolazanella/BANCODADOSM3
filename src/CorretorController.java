import java.util.List;

public class CorretorController {

    private CorretorRepository corretorRepository;

    public CorretorController() {
        this.corretorRepository = new CorretorRepository();
    }

    public List<Corretor> listarCorretores() {
        return corretorRepository.listarCorretores();
    }
    public Corretor buscarCorretorPorId(int id) {
        return corretorRepository.buscarCorretorPorId(id);
    }
    

    public void adicionarCorretor(Corretor corretor) {
        corretorRepository.adicionarCorretor(corretor);
    }

    public void atualizarCorretor(Corretor corretor) {
        corretorRepository.atualizarCorretor(corretor);
    }

    public void excluirCorretor(int id) {
        corretorRepository.excluirCorretor(id);
    }
}
