import java.util.List;
import java.util.Scanner;

public class ImovelView {

    private ImovelController imovelController;
    private Scanner scanner;

    public ImovelView() {
        this.imovelController = new ImovelController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n---- Menu Imóvel ----");
            System.out.println("1. Listar Imóveis");
            System.out.println("2. Adicionar Imóvel");
            System.out.println("3. Atualizar Imóvel");
            System.out.println("4. Excluir Imóvel");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    listarImoveis();
                    break;
                case 2:
                    adicionarImovel();
                    break;
                case 3:
                    atualizarImovel();
                    break;
                case 4:
                    excluirImovel();
                    break;
                case 0:
                    System.out.println("Retornando ao Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void listarImoveis() {
        List<Imovel> imoveis = imovelController.listarImoveis();
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imóvel encontrado.");
        } else {
            for (Imovel imovel : imoveis) {
                System.out.println(imovel);
            }
        }
    }

    private void adicionarImovel() {
        System.out.println("---- Adicionar Imóvel ----");
        // Preencha as informações do imóvel
        Imovel imovel = preencherInformacoesImovel();
        imovelController.adicionarImovel(imovel);
        System.out.println("Imóvel adicionado com sucesso!");
    }

    private void atualizarImovel() {
        System.out.println("---- Atualizar Imóvel ----");
        System.out.print("Digite o ID do imóvel a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verificar se o imóvel existe
        Imovel imovelExistente = imovelController.buscarImovelPorId(id);
        if (imovelExistente == null) {
            System.out.println("Imóvel não encontrado com o ID fornecido.");
            return;
        }

        // Preencha as novas informações do imóvel
        Imovel novasInformacoes = preencherInformacoesImovel();
        novasInformacoes.setId(id);
        imovelController.atualizarImovel(novasInformacoes);
        System.out.println("Imóvel atualizado com sucesso!");
    }

    private void excluirImovel() {
        System.out.println("---- Excluir Imóvel ----");
        System.out.print("Digite o ID do imóvel a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verificar se o imóvel existe
        Imovel imovelExistente = imovelController.buscarImovelPorId(id);
        if (imovelExistente == null) {
            System.out.println("Imóvel não encontrado com o ID fornecido.");
            return;
        }

        imovelController.excluirImovel(id);
        System.out.println("Imóvel excluído com sucesso!");
    }

    private Imovel preencherInformacoesImovel() {
        Imovel imovel = new Imovel();

        // Preencha os atributos conforme necessário

        System.out.print("Tamanho: ");
        imovel.setTamanho(scanner.nextFloat());
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Preço: ");
        imovel.setPreco(scanner.nextFloat());
        scanner.nextLine(); // Limpar o buffer

        // Preencha os demais atributos como proprietário, corretor, tipoImovel, endereco, etc.

        return imovel;
    }
}
