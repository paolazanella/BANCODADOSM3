import java.util.List;

public class ImovelController {
    private ImovelRepository imovelRepository;

    public ImovelController() {
        this.imovelRepository = new ImovelRepository();
    }

    public List<Imovel> listarImoveis() {
        return imovelRepository.listarImoveis();
    }
    public Imovel buscarImovelPorId(int id) {
        return imovelRepository.buscarImovelPorId(id);
    }
    public void adicionarImovel(Imovel imovel) {
        imovelRepository.adicionarImovel(imovel);
    }

    public void atualizarImovel(Imovel imovel) {
        imovelRepository.atualizarImovel(imovel);
    }

    public void excluirImovel(int id) {
        imovelRepository.excluirImovel(id);
    }
}
