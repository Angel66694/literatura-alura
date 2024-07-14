package alura.desafioLiteratura.demo.repositorio;

import alura.desafioLiteratura.demo.model.author.Author;
import alura.desafioLiteratura.demo.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<String> findDistinctIdiomaBy();

    @Query("SELECT b FROM Book b ORDER BY b.totalDeDescargas DESC LIMIT 10")
    List<Book> findTop10Descargados();

    @Query("SELECT b FROM Book b WHERE b.titulo = :title")
    Optional<Book> findByTitulo(String title);

    Optional<Book> findById(long id);
    List<Book> findByAuthorIdAuthor(Long idAuthor);

    Optional<Book> findBookByTitulo(String titulo);

    @Query("SELECT DISTINCT b.idioma FROM Book b")
    List<String> findDistinctIdiomas();

    @Query("SELECT b FROM Book b WHERE b.idioma = :idioma")
    List<Book> findByIdioma(@Param("idioma") String idioma);

    @Query("SELECT b FROM Book b WHERE b.author = :author")
    List<Book> findBookByAuthor(Author author);
}
