package alura.desafioLiteratura.demo.service;

import alura.desafioLiteratura.demo.model.book.Book;
import alura.desafioLiteratura.demo.repositorio.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    public BookRepository bookRepository;

    public List<String> obtenerIdiomasDistintos() {
        return bookRepository.findDistinctIdiomas();
    }

    public List<Book> obtenerLibrosPorIdioma(String idioma) {
        return bookRepository.findByIdioma(idioma);
    }
}
