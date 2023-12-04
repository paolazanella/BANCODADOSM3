import java.util.List;
import java.util.Scanner;

public class EnderecoView {

    private EnderecoController enderecoController;
    private Scanner scanner;

    public EnderecoView() {
        this.enderecoController = new EnderecoController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n---- Menu Endereço ----");
            System.out.println("1. Listar Endereços");
            System.out.println("2. Adicionar Endereço");
            System.out.println("3. Atualizar Endereço");
            System.out.println("4. Excluir Endereço");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    listarEnderecos();
                    break;
                case 2:
                    adicionarEndereco();
                    break;
                case 3:
                    atualizarEndereco();
                    break;
                case 4:
                    excluirEndereco();
                    break;
                case 0:
                    System.out.println("Retornando ao Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void listarEnderecos() {
        List<Endereco> enderecos = enderecoController.listarEnderecos();
        if (enderecos.isEmpty()) {
            System.out.println("Nenhum endereço encontrado.");
        } else {
            for (Endereco endereco : enderecos) {
                System.out.println(endereco);
            }
        }
    }

    private void adicionarEndereco() {
        System.out.println("---- Adicionar Endereço ----");
        // Preencha as informações do endereço
        Endereco endereco = preencherInformacoesEndereco();
        enderecoController.adicionarEndereco(endereco);
        System.out.println("Endereço adicionado com sucesso!");
    }

    private void atualizarEndereco() {
        System.out.println("---- Atualizar Endereço ----");
        System.out.print("Digite o ID do endereço a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verificar se o endereço existe
        Endereco enderecoExistente = enderecoController.buscarEnderecoPorId(id);
        if (enderecoExistente == null) {
            System.out.println("Endereço não encontrado com o ID fornecido.");
            return;
        }

        // Preencha as novas informações do endereço
        Endereco novasInformacoes = preencherInformacoesEndereco();
        novasInformacoes.setId(id);
        enderecoController.atualizarEndereco(novasInformacoes);
        System.out.println("Endereço atualizado com sucesso!");
    }

    private void excluirEndereco() {
        System.out.println("---- Excluir Endereço ----");
        System.out.print("Digite o ID do endereço a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Verificar se o endereço existe
        Endereco enderecoExistente = enderecoController.buscarEnderecoPorId(id);
        if (enderecoExistente == null) {
            System.out.println("Endereço não encontrado com o ID fornecido.");
            return;
        }

        enderecoController.excluirEndereco(id);
        System.out.println("Endereço excluído com sucesso!");
    }

    private Endereco preencherInformacoesEndereco() {
        Endereco endereco = new Endereco();

        // Preencha os atributos conforme necessário

        System.out.print("Rua: ");
        endereco.setRua(scanner.nextLine());

        System.out.print("Bairro: ");
        endereco.setBairro(scanner.nextLine());

        System.out.print("CEP: ");
        endereco.setCep(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Número: ");
        endereco.setNumero(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Complemento: ");
        endereco.setComplemento(scanner.nextLine());

        return endereco;
    }
}
