import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Definição da classe principal "librairie"
public class librairie {
    // Listas para armazenar livros e livros removidos
    private static List<livre> livros = new ArrayList<>();
    private static List<livre> retireLivros = new ArrayList<>();
    // Scanner para ler a entrada do usuário
    private static Scanner scanner = new Scanner(System.in);
    // Instâncias de classes para gerenciar livros e remoção de livros
    private static BibliotecLivreUser GestionnaireDeLivros = new BibliotecLivreUser(livros, scanner);
    private static administrateur retirarLivroradministrateur = new administrateur(livros, retireLivros, scanner);

    // Método principal que inicia o programa
    public static void main(String[] args) {
        boolean sair = false;

        // Loop principal do programa que exibe o menu e processa a escolha do usuário
        while (!sair) {
            MontreMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer de entrada

            // Processa a escolha do usuário usando uma estrutura switch
            switch (escolha) {
                case 1:
                    // Adiciona um livro
                    GestionnaireDeLivros.adicionaLivros();
                    break;
                case 2:
                    // Exibe os livros lidos
                    GestionnaireDeLivros.olharLivros();
                    break;
                case 3:
                    // Remove um livro
                    retirarLivroradministrateur.retirarLivro();
                    break;
                case 4:
                    // Pesquisa um livro
                    GestionnaireDeLivros.procurarLivro();
                    break;
                case 5:
                    // Edita o resumo de um livro
                    GestionnaireDeLivros.resumirMais();
                    break;
                case 6:
                    // Sugere um livro por gênero
                    GestionnaireDeLivros.sugestionPorGenero();
                    break;
                case 7:
                    // Restaura um livro removido
                    retirarLivroradministrateur.restauraLivros();
                    break;
                case 8:
                    // Sai do programa
                    sair = true;
                    break;
                default:
                    // Caso o usuário insira uma opção inválida
                    System.out.println("Opcao invalida. Tente mais uma vez.");
            }
        }

        // Fecha o scanner após sair do loop
        scanner.close();
    }

    // Método que exibe o menu para o usuário
    private static void MontreMenu() {
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("Biblioteca de livros:");
        System.out.println("1. Adicionar livro");
        System.out.println("2. Ver livros lidos");
        System.out.println("3. Remover livro");
        System.out.println("4. Pesquisar livro");
        System.out.println("5. Editar resumo");
        System.out.println("6. Sugerir livro por genero");
        System.out.println("7. Restaurar livro removido");
        System.out.println("8. Sair");
        System.out.print("Escolha uma opcao: ");
    }
}
