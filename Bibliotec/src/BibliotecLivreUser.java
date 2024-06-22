import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

// Classe que gerencia operações básicas de usuários sobre os livros na biblioteca
public class BibliotecLivreUser {
    // Atributos da classe
    private List<livre> livros;  // Lista de livros disponíveis na biblioteca
    private Scanner scanner;     // Scanner para leitura de entradas do usuário

    // Construtor da classe BibliotecLivreUser
    public BibliotecLivreUser(List<livre> livros, Scanner scanner) {
        this.livros = livros;   // Inicializa a lista de livros disponíveis
        this.scanner = scanner; // Inicializa o scanner para leitura de entradas
    }

    // Método para adicionar livros à biblioteca
    public void adicionaLivros() {
        System.out.print("Informe o titulo do livro: ");
        String titulo = scanner.nextLine(); // Lê o título do livro

        System.out.print("Informe o autor do livro: ");
        String autor = scanner.nextLine(); // Lê o autor do livro

        System.out.print("Informe o ano de lancamento do livro: ");
        int ano = scanner.nextInt();       // Lê o ano de lançamento do livro
        scanner.nextLine();                // Consome a nova linha para evitar problemas de leitura

        System.out.print("Informe o tipo (genero) do livro: ");
        String genero = scanner.nextLine(); // Lê o gênero do livro

        System.out.print("Informe um breve resumo do livro: ");
        String resumo = scanner.nextLine(); // Lê um breve resumo do livro

        // Adiciona o novo livro à lista de livros
        livros.add(new livre(titulo, autor, ano, genero, resumo));
        // Ordena a lista de livros por título
        livros.sort((b1, b2) -> b1.getTitulo().compareToIgnoreCase(b2.getTitulo()));
        System.out.println("Livro adicionado com sucesso!");
    }

    // Método para visualizar todos os livros da biblioteca
    public void olharLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro adicionado.");
        } else {
            System.out.println("Livros na biblioteca:");
            for (livre livre : livros) {
                System.out.println(livre.getTitulo() + " por " + livre.getAutor() + " (" + livre.getAno() + ") - " + livre.getGenero());
                System.out.println("Resumo: " + livre.getResumoBreve());
                System.out.println("-------------------------------------------------");
            }
        }
    }

    // Método para procurar um livro pelo título
    public void procurarLivro() {
        System.out.print("Informe o titulo do livro que quer pesquisar: ");
        String titulo = scanner.nextLine(); // Lê o título do livro a ser procurado

        // Procura o livro na lista de livros disponíveis
        Optional<livre> optionLivro = livros.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst(); // Filtra a lista de livros pelo título e retorna o primeiro encontrado

        // Verifica se o livro foi encontrado
        if (optionLivro.isPresent()) {
            livre livro = optionLivro.get(); // Obtém o livro encontrado
            System.out.println("Livro encontrado:");
            System.out.println("Titulo: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano de Lancamento: " + livro.getAno());
            System.out.println("Tipo: " + livro.getGenero());
            System.out.println("Resumo: " + livro.getResumoBreve());
        } else {
            System.out.println("Livro nao encontrado.");
        }
    }

    // Método para editar o resumo de um livro
    public void resumirMais() {
        System.out.print("Informe o titulo do livro cujo resumo deseja editar: ");
        String titulo = scanner.nextLine(); // Lê o título do livro

        // Procura o livro na lista de livros disponíveis
        Optional<livre> optionalLivro = livros.stream()
                .filter(livre -> livre.getTitulo().equalsIgnoreCase(titulo))
                .findFirst(); // Filtra a lista de livros pelo título e retorna o primeiro encontrado

        // Verifica se o livro foi encontrado
        if (optionalLivro.isPresent()) {
            livre livro = optionalLivro.get(); // Obtém o livro encontrado
            System.out.println("Resumo atual: " + livro.getResumoBreve());
            System.out.print("Informe o novo resumo: ");
            String novoResumo = scanner.nextLine(); // Lê o novo resumo
            livro.setresumoBreve(novoResumo);       // Atualiza o resumo do livro
            System.out.println("Resumo atualizado com sucesso!");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    // Método para sugerir um livro com base no gênero
    public void sugestionPorGenero() {
        System.out.print("Informe o genero do livro: ");
        String genero = scanner.nextLine(); // Lê o gênero do livro

        // Filtra a lista de livros pelo gênero especificado
        List<livre> resultados = livros.stream()
                .filter(livre -> livre.getGenero().equalsIgnoreCase(genero))
                .collect(Collectors.toList()); // Coleta os livros que correspondem ao gênero

        // Verifica se há livros disponíveis para o gênero especificado
        if (resultados.isEmpty()) {
            System.out.println("Nenhum livro encontrado para o genero especificado.");
        } else {
            System.out.println("Sugestoes de livros para o genero " + genero + ":");
            for (livre livre : resultados) {
                System.out.println(livre.getTitulo() + " por " + livre.getAutor() + " (" + livre.getAno() + ")");
                System.out.println("Resumo: " + livre.getResumoBreve());
                System.out.println("-------------------------------------------------");
            }
        }
    }
}



/////.filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo)):

///Aplica um filtro ao stream para manter apenas os livros cujo título (livro.getTitulo()) seja igual ao título fornecido (titulo), ignorando maiúsculas e minúsculas (equalsIgnoreCase).
//.findFirst():

//Encontra e retorna o primeiro elemento no stream que corresponde ao filtro aplicado. Retorna um Optional<livre> que pode conter o livro encontrado ou estar vazio se nenhum livro corresponder ao filtro.
