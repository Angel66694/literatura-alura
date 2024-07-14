package alura.desafioLiteratura.demo.repositorio;

import alura.desafioLiteratura.demo.model.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAuthorByNombre(String nombre);

    @Query(value = "SELECT a FROM Author a WHERE a.fechaDeDefuncion >:year AND a.fechaDeNacimiento <:year")
    List<Author> findAuthorByFecha(int year);


}
