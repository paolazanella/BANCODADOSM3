import java.util.List;

public class TipoImovelController {

    private TipoImovelRepository tipoImovelRepository;

    public TipoImovelController() {
        this.tipoImovelRepository = new TipoImovelRepository();
    }

    public List<TipoImovel> listarTiposImovel() {
        return tipoImovelRepository.listarTiposImovel();
    }
    public TipoImovel buscarTipoImovelPorId(int id) {
        return tipoImovelRepository.buscarTipoImovelPorId(id);
    }

    public void adicionarTipoImovel(TipoImovel tipoImovel) {
        tipoImovelRepository.adicionarTipoImovel(tipoImovel);
    }

    public void atualizarTipoImovel(TipoImovel tipoImovel) {
        tipoImovelRepository.atualizarTipoImovel(tipoImovel);
    }

    public void excluirTipoImovel(int id) {
        tipoImovelRepository.excluirTipoImovel(id);
    }
}
