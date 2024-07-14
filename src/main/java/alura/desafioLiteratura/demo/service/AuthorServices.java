package alura.desafioLiteratura.demo.service;


import alura.desafioLiteratura.demo.model.author.Author;
import alura.desafioLiteratura.demo.repositorio.AuthorRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorServices {

    @Autowired
    private AuthorRepository authorRepository;



    public List<Author> getAutoresVivosPorAno(int year) {
        return authorRepository.findAuthorByFecha(year);
    }
    @Transactional
    public Author findAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            Hibernate.initialize(author.getBooks());
        }
        return author;
    }
    }


