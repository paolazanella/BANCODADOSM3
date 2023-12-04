import java.util.List;
import java.util.Scanner;

public class TipoImovelView {

    private TipoImovelController tipoImovelController;
    private Scanner scanner;

    public TipoImovelView() {
        this.tipoImovelController = new TipoImovelController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n---- Menu Tipo de Imóvel ----");
            System.out.println("1. Listar Tipos de Imóvel");
            System.out.println("2. Adicionar Tipo de Imóvel");
            System.out.println("3. Atualizar Tipo de Imóvel");
            System.out.println("4. Excluir Tipo de Imóvel");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    listarTiposImovel();
                    break;
                case 2:
                    adicionarTipoImovel();
                    break;
                case 3:
                    atualizarTipoImovel();
                    break;
                case 4:
                    excluirTipoImovel();
                    break;
                case 0:
                    System.out.println("Retornando ao Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void listarTiposImovel() {
        List<TipoImovel> tiposImovel = tipoImovelController.listarTiposImovel();
        if (tiposImovel.isEmpty()) {
            System.out.println("Nenhum tipo de imóvel encontrado.");
        } else {
            for (TipoImovel tipoImovel : tiposImovel) {
                System.out.println(tipoImovel);
            }
        }
    }

    private void adicionarTipoImovel() {
        System.out.println("---- Adicionar Tipo de Imóvel ----");
        // Preencha as informações do tipo de imóvel
        TipoImovel tipoImovel = preencherInformacoesTipoImovel();
        tipoImovelController.adicionarTipoImovel(tipoImovel);
        System.out.println("Tipo de Imóvel adicionado com sucesso!");
    }

    private void atualizarTipoImovel() {
        System.out.println("---- Atualizar Tipo de Imóvel ----");
        System.out.print("Digite o ID do tipo de imóvel a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verificar se o tipo de imóvel existe
        TipoImovel tipoImovelExistente = tipoImovelController.buscarTipoImovelPorId(id);
        if (tipoImovelExistente == null) {
            System.out.println("Tipo de Imóvel não encontrado com o ID fornecido.");
            return;
        }

        // Preencha as novas informações do tipo de imóvel
        TipoImovel novasInformacoes = preencherInformacoesTipoImovel();
        novasInformacoes.setId(id);
        tipoImovelController.atualizarTipoImovel(novasInformacoes);
        System.out.println("Tipo de Imóvel atualizado com sucesso!");
    }

    private void excluirTipoImovel() {
        System.out.println("---- Excluir Tipo de Imóvel ----");
        System.out.print("Digite o ID do tipo de imóvel a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verificar se o tipo de imóvel existe
        TipoImovel tipoImovelExistente = tipoImovelController.buscarTipoImovelPorId(id);
        if (tipoImovelExistente == null) {
            System.out.println("Tipo de Imóvel não encontrado com o ID fornecido.");
            return;
        }

        tipoImovelController.excluirTipoImovel(id);
        System.out.println("Tipo de Imóvel excluído com sucesso!");
    }

    private TipoImovel preencherInformacoesTipoImovel() {
        TipoImovel tipoImovel = new TipoImovel();
    
        System.out.print("Nome: ");
        tipoImovel.setNome(scanner.nextLine());
    
        return tipoImovel;
    }
}
