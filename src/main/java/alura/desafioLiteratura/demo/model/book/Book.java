package alura.desafioLiteratura.demo.model.book;

import alura.desafioLiteratura.demo.model.author.Author;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jdk.jfr.Name;

@Entity
@Table(name = "book")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    @Id
    private int idBook;
    @Column(unique = true)
    @Name(value = "titulo")
    private String titulo;
    private String idioma;

    @ManyToOne
    @JoinColumn(name = "idAuthor")
    private Author author;
    private int totalDeDescargas;


    public Book(){

    }

    public Book(DatosBook datosBook, Author author, String idioma){
        this.idBook = datosBook.idBook();
        this.titulo = datosBook.titulo();
        this.totalDeDescargas = datosBook.totalDeDescargas();
        this.idioma = idioma;
        this.author = author;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getTotalDeDescargas() {
        return totalDeDescargas;
    }

    public void setTotalDeDescargas(int totalDeDescargas) {
        this.totalDeDescargas = totalDeDescargas;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", titulo='" + titulo + '\'' +
                ", idioma='" + idioma + '\'' +
                ", totalDeDescargas=" + totalDeDescargas +
                '}';
    }
}
