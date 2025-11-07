package gerenciador.service;

import gerenciador.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorBibliotecaService {
    private List<Livro> acervoDeLivros = new ArrayList<>();

    public void adicionarNovoLivro(String titulo, String autor) {
        if(titulo.isBlank() || autor.isBlank()) {
            throw new IllegalArgumentException("Título e autor não podem ser vazios.");
        }

        acervoDeLivros.stream().filter(l -> l.titulo().equalsIgnoreCase(titulo))
                .findFirst().ifPresent(l -> {
            throw new IllegalArgumentException(String.format("Livro %s já existe no acervo.", titulo));
        });

        acervoDeLivros.add(new Livro(titulo, autor));
        IO.println(String.format("Livro %s do autor %s adicionado ao acervo.", titulo, autor));
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        return acervoDeLivros.stream()
                .filter(l -> l.titulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Livro %s não encontrado no acervo.", titulo)));
    }

    public void excluirLivroPorTitulo(String titulo) {
        Livro livroParaExcluir = buscarLivroPorTitulo(titulo);
        acervoDeLivros.remove(livroParaExcluir);
        IO.println(String.format("Livro %s excluído do acervo.", titulo));
    }

    public List<Livro> listarTodosOsLivros() {
        return acervoDeLivros;
    }
}
