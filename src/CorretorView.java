import java.util.List;
import java.util.Scanner;

public class CorretorView {

    private CorretorController corretorController;
    private Scanner scanner;

    public CorretorView() {
        this.corretorController = new CorretorController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n---- Menu Corretor ----");
            System.out.println("1. Listar Corretores");
            System.out.println("2. Adicionar Corretor");
            System.out.println("3. Atualizar Corretor");
            System.out.println("4. Excluir Corretor");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    listarCorretores();
                    break;
                case 2:
                    adicionarCorretor();
                    break;
                case 3:
                    atualizarCorretor();
                    break;
                case 4:
                    excluirCorretor();
                    break;
                case 0:
                    System.out.println("Retornando ao Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void listarCorretores() {
        List<Corretor> corretores = corretorController.listarCorretores();
        if (corretores.isEmpty()) {
            System.out.println("Nenhum corretor encontrado.");
        } else {
            for (Corretor corretor : corretores) {
                System.out.println(corretor);
            }
        }
    }

    private void adicionarCorretor() {
        System.out.println("---- Adicionar Corretor ----");
        try {
            Corretor corretor = preencherInformacoesCorretor();
            corretorController.adicionarCorretor(corretor);
            System.out.println("Corretor adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar corretor: " + e.getMessage());
        }
    }

    private void atualizarCorretor() {
        System.out.println("---- Atualizar Corretor ----");
        System.out.print("Digite o ID do corretor a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Corretor corretorExistente = corretorController.buscarCorretorPorId(id);
        if (corretorExistente == null) {
            System.out.println("Corretor não encontrado com o ID fornecido.");
            return;
        }

        try {
            Corretor novasInformacoes = preencherInformacoesCorretor();
            novasInformacoes.setId(id);
            corretorController.atualizarCorretor(novasInformacoes);
            System.out.println("Corretor atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar corretor: " + e.getMessage());
        }
    }

    private void excluirCorretor() {
        System.out.println("---- Excluir Corretor ----");
        System.out.print("Digite o ID do corretor a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Corretor corretorExistente = corretorController.buscarCorretorPorId(id);
        if (corretorExistente == null) {
            System.out.println("Corretor não encontrado com o ID fornecido.");
            return;
        }

        try {
            corretorController.excluirCorretor(id);
            System.out.println("Corretor excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir corretor: " + e.getMessage());
        }
    }

    private Corretor preencherInformacoesCorretor() {
        Corretor corretor = new Corretor();

        System.out.print("Imobiliaria Nome: ");
        corretor.setImobiliariaNome(scanner.nextLine());

        System.out.print("Nome: ");
        corretor.setNome(scanner.nextLine());

        System.out.print("CPF: ");
        corretor.setCpf(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer

        System.out.print("CRECI: ");
        corretor.setCreci(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Telefone: ");
        corretor.setTelefone(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Senha: ");
        corretor.setSenha(scanner.nextLine());

        System.out.print("Email: ");
        corretor.setEmail(scanner.nextLine());

        return corretor;
    }
}
