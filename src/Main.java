import gerenciador.model.Livro;
import gerenciador.service.GerenciadorBibliotecaService;

void main() {
    GerenciadorBibliotecaService gerenciadorBiblioteca = new GerenciadorBibliotecaService();
    boolean continuar = true;

    while(continuar) {
        try{
            IO.println("=== Gerenciador de Biblioteca ===");
            IO.println("1. Adicionar novo livro");
            IO.println("2. Buscar livro por título");
            IO.println("3. Excluir livro por título");
            IO.println("4. Listar todos os livros");
            IO.println("5. Sair");
            String opcao = IO.readln("Escolha uma opção: ");

            switch (opcao) {
                case "1":
                    String tituloAdicionar = IO.readln("Digite o título do livro: ");
                    String autorAdicionar = IO.readln("Digite o autor do livro: ");
                    gerenciadorBiblioteca.adicionarNovoLivro(tituloAdicionar, autorAdicionar);
                    break;
                case "2":
                    String tituloBuscar = IO.readln("Digite o título do livro a buscar: ");
                    Livro livroEncontrado = gerenciadorBiblioteca.buscarLivroPorTitulo(tituloBuscar);
                    IO.println(String.format("Livro encontrado: %s de %s", livroEncontrado.titulo(), livroEncontrado.autor()));
                    break;
                case "3":
                    String tituloExcluir = IO.readln("Digite o título do livro a excluir: ");
                    gerenciadorBiblioteca.excluirLivroPorTitulo(tituloExcluir);
                    break;
                case "4":
                    List<Livro> livros = gerenciadorBiblioteca.listarTodosOsLivros();
                    if (livros.isEmpty()) {
                        IO.println("Nenhum livro no acervo.");
                    } else {
                        IO.println("Livros no acervo:");
                        for (Livro livro : livros) {
                            IO.println(String.format("- %s de %s", livro.titulo(), livro.autor()));
                        }
                    }
                    break;
                case "5":
                    continuar = false;
                    IO.println("Saindo do gerenciador de biblioteca.");
                    break;
                default:
                    IO.println("Opção inválida. Tente novamente.");
            }

            IO.println("");
        } catch (Exception e) {
            IO.println(String.format("Error: %s", e.getMessage()));
            IO.println("");
        }
    }
}
