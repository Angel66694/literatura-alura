package alura.desafioLiteratura.demo.model.author;

import alura.desafioLiteratura.demo.model.book.Book;
import alura.desafioLiteratura.demo.service.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "author")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuthor;

    @Column(unique = true)
    private String nombre;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private Integer fechaDeNacimiento;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private Integer fechaDeDefuncion;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    private List<Book> books;

    public Author() {

    }

    public Author(String nombre, Integer fechaDeNacimiento, Integer fechaDeDefuncion) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaDeDefuncion = fechaDeDefuncion;
    }

    public Author(DatosAuthor datosAuthor) {
        this.nombre = datosAuthor.nombre();
        this.fechaDeNacimiento = datosAuthor.fechaDeNacimiento();
        this.fechaDeDefuncion = datosAuthor.fechaDeDefuncion();
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaDeDefuncion() {
        return fechaDeDefuncion;
    }

    public void setFechaDeDefuncion(Integer fechaDeDefuncion) {
        this.fechaDeDefuncion = fechaDeDefuncion;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", nombre='" + nombre + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", fechaDeDefuncion=" + fechaDeDefuncion +
                '}';
    }
}
