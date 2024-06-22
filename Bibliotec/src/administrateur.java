import java.util.List;
import java.util.Optional;
import java.util.Scanner;

// Classe que gerencia a remoção e restauração de livros na biblioteca
public class administrateur {
    // Atributos da classe
    private List<livre> livros;          // Lista de livros disponíveis na biblioteca
    private List<livre> retirarLivros;   // Lista de livros que foram removidos
    private Scanner scanner;             // Scanner para leitura de entradas do usuário

    // Construtor da classe administrateur
    public administrateur(List<livre> livros, List<livre> retirarLivros, Scanner scanner) {
        this.livros = livros;             // Inicializa a lista de livros disponíveis
        this.retirarLivros = retirarLivros; // Inicializa a lista de livros removidos
        this.scanner = scanner;           // Inicializa o scanner para leitura de entradas
    }

    // Método para remover um livro da lista de disponíveis e adicioná-lo à lista de removidos
    public void retirarLivro() {
        System.out.print("Informe o titulo do livro a ser removido: ");
        String titulo = scanner.nextLine(); // Lê o título do livro a ser removido

        // Procura o livro na lista de livros disponíveis
        Optional<livre> optionLivro = livros.stream()
                .filter(livre -> livre.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();

        // Verifica se o livro foi encontrado
        if (optionLivro.isPresent()) {
            livre livro = optionLivro.get(); // Obtém o livro encontrado
            livros.remove(livro);            // Remove o livro da lista de disponíveis
            retirarLivros.add(livro);        // Adiciona o livro à lista de removidos
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro nao encontrado."); // Mensagem caso o livro não seja encontrado
        }
    }

    // Método para restaurar um livro da lista de removidos para a lista de disponíveis
    public void restauraLivros() {
        // Verifica se há livros para restaurar
        if (retirarLivros.isEmpty()) {
            System.out.println("Nenhum livro removido disponivel para restauracao.");
            return;
        }

        // Mostra a lista de livros removidos
        System.out.println("Livros removidos:");
        for (int i = 0; i < retirarLivros.size(); i++) {
            livre livro = retirarLivros.get(i);
            System.out.println((i + 1) + ". " + livro.getTitulo() + " por " + livro.getAutor());
        }

        // Lê a escolha do usuário para restaurar um livro
        System.out.print("Informe o numero do livro que deseja restaurar: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consome a nova linha para evitar problemas de leitura

        // Verifica se a escolha do usuário é válida
        if (index >= 0 && index < retirarLivros.size()) {
            livre livro = retirarLivros.remove(index); // Remove o livro da lista de removidos
            livros.add(livro);                        // Adiciona o livro à lista de disponíveis
            // Ordena a lista de livros disponíveis por título
            livros.sort((b1, b2) -> b1.getTitulo().compareToIgnoreCase(b2.getTitulo()));
            System.out.println("Livro restaurado com sucesso!");
        } else {
            System.out.println("Opcao invalida."); // Mensagem caso a escolha do usuário seja inválida
        }
    }
}
