import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CorretorView corretorView = new CorretorView();
        TipoImovelView tipoImovelView = new TipoImovelView();
        ImovelView imovelView = new ImovelView();
        ProprietarioView proprietarioView = new ProprietarioView();
        EnderecoView enderecoView = new EnderecoView();

        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    corretorView.exibirMenu();
                    break;
                case 2:
                    tipoImovelView.exibirMenu();
                    break;
                case 3:
                    imovelView.exibirMenu();
                    break;
                case 4:
                    proprietarioView.exibirMenu();
                    break;
                case 5:
                    enderecoView.exibirMenu();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n---- Menu Principal ----");
        System.out.println("1. Corretor");
        System.out.println("2. Tipo de Imóvel");
        System.out.println("3. Imóvel");
        System.out.println("4. Proprietário");
        System.out.println("5. Endereço");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
}
