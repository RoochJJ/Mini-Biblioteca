// Classe que representa um livro
public class livre {
    // Atributos (ou propriedades) de um livro
    private String titulo;       // Título do livro
    private String autor;        // Autor do livro
    private int ano;             // Ano de publicação do livro
    private String genero;       // Gênero do livro
    private String resumoBreve;  // Resumo breve do livro

    // Construtor da classe livre, usado para criar um novo objeto livre
    public livre(String titulo, String autor, int ano, String genero, String resumoBreve) {
        this.titulo = titulo;             // Define o título do livro
        this.autor = autor;               // Define o autor do livro
        this.ano = ano;                   // Define o ano de publicação
        this.genero = genero;             // Define o gênero do livro
        this.resumoBreve = resumoBreve;   // Define o resumo breve do livro
    }

    // Métodos 'getter' para acessar os atributos do livro
    public String getTitulo() {
        return titulo;  // Retorna o título do livro
    }

    public String getAutor() {
        return autor;   // Retorna o autor do livro
    }

    public int getAno() {
        return ano;     // Retorna o ano de publicação do livro
    }

    public String getGenero() {
        return genero;  // Retorna o gênero do livro
    }

    public String getResumoBreve() {
        return resumoBreve;  // Retorna o resumo breve do livro
    }

    // Método 'setter' para modificar o resumo breve do livro
    public void setresumoBreve(String resumoBreve) {
        this.resumoBreve = resumoBreve;  // Define um novo resumo breve para o livro
    }
}
