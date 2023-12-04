import java.util.List;
import java.util.Scanner;

public class ProprietarioView {

    private ProprietarioController proprietarioController;
    private Scanner scanner;

    public ProprietarioView() {
        this.proprietarioController = new ProprietarioController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n---- Menu Proprietário ----");
            System.out.println("1. Listar Proprietários");
            System.out.println("2. Adicionar Proprietário");
            System.out.println("3. Atualizar Proprietário");
            System.out.println("4. Excluir Proprietário");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    listarProprietarios();
                    break;
                case 2:
                    adicionarProprietario();
                    break;
                case 3:
                    atualizarProprietario();
                    break;
                case 4:
                    excluirProprietario();
                    break;
                case 0:
                    System.out.println("Retornando ao Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void listarProprietarios() {
        List<Proprietario> proprietarios = proprietarioController.listarProprietarios();
        if (proprietarios.isEmpty()) {
            System.out.println("Nenhum proprietário encontrado.");
        } else {
            for (Proprietario proprietario : proprietarios) {
                System.out.println(proprietario);
            }
        }
    }

    private void adicionarProprietario() {
        System.out.println("---- Adicionar Proprietário ----");
        // Preencha as informações do proprietário
        Proprietario proprietario = preencherInformacoesProprietario();
        proprietarioController.adicionarProprietario(proprietario);
        System.out.println("Proprietário adicionado com sucesso!");
    }

    private void atualizarProprietario() {
        System.out.println("---- Atualizar Proprietário ----");
        System.out.print("Digite o ID do proprietário a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verificar se o proprietário existe
        Proprietario proprietarioExistente = proprietarioController.buscarProprietarioPorId(id);
        if (proprietarioExistente == null) {
            System.out.println("Proprietário não encontrado com o ID fornecido.");
            return;
        }

        // Preencha as novas informações do proprietário
        Proprietario novasInformacoes = preencherInformacoesProprietario();
        novasInformacoes.setId(id);
        proprietarioController.atualizarProprietario(novasInformacoes);
        System.out.println("Proprietário atualizado com sucesso!");
    }

    private void excluirProprietario() {
        System.out.println("---- Excluir Proprietário ----");
        System.out.print("Digite o ID do proprietário a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verificar se o proprietário existe
        Proprietario proprietarioExistente = proprietarioController.buscarProprietarioPorId(id);
        if (proprietarioExistente == null) {
            System.out.println("Proprietário não encontrado com o ID fornecido.");
            return;
        }

        proprietarioController.excluirProprietario(id);
        System.out.println("Proprietário excluído com sucesso!");
    }

    private Proprietario preencherInformacoesProprietario() {
        Proprietario proprietario = new Proprietario();

        // Preencha os atributos conforme necessário

        System.out.print("Nome: ");
        proprietario.setNome(scanner.nextLine());

        System.out.print("Telefone: ");
        proprietario.setTelefone(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Email: ");
        proprietario.setEmail(scanner.nextLine());

        System.out.print("Senha: ");
        proprietario.setSenha(scanner.nextLine());

        System.out.print("CPF: ");
        proprietario.setCpf(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer

        return proprietario;
    }
}
