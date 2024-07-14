package alura.desafioLiteratura.demo.principal;

import alura.desafioLiteratura.demo.model.author.Author;
import alura.desafioLiteratura.demo.model.author.DatosAuthor;
import alura.desafioLiteratura.demo.model.book.Book;
import alura.desafioLiteratura.demo.service.ConsumoApi;
import alura.desafioLiteratura.demo.model.book.DatosBook;
import alura.desafioLiteratura.demo.model.idioma.Idiomas;
import alura.desafioLiteratura.demo.repositorio.AuthorRepository;
import alura.desafioLiteratura.demo.repositorio.BookRepository;
import alura.desafioLiteratura.demo.service.AuthorServices;
import alura.desafioLiteratura.demo.service.BookService;
import alura.desafioLiteratura.demo.service.ConvierteDatos;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@Component
public class MenuPrincipal {

    @Autowired
    private MensajeMenu mensajeMenu;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ConsumoApi consumoApi = new  ConsumoApi();
    @Autowired
    private ConvierteDatos convierteDatos;
    @Autowired
    private BookService bookService = new BookService();
    @Autowired
    private AuthorServices authorService = new AuthorServices();

    private Scanner teclado = new Scanner(System.in);
    private DatosBook datosBook;
    private DatosAuthor datosAuthor;
    private Author authorOfTheBook;
    private List<Author> authors;
    private List<Book> books;
    private Idiomas Idioma;

    public MenuPrincipal(AuthorRepository authorRepository, ConsumoApi ConsumoApi) {
        this.authorRepository = authorRepository;
        this.consumoApi = ConsumoApi;
    }


    public void exhibitMenu() {
        System.out.println("menu principal");
        while (true) {
            mensajeMenu.mostrarMenu();

            int opcion = teclado.nextInt();
            teclado.nextLine();

            try {

            switch (opcion) {
                case 1:
                    busquedaDeBooks();
                    break;
                case 2:
                    listaBooksRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    buscarAuthorsVivosEnAnoEspecifico();
                    break;
                case 5:
                    buscarBooksPorIdioma();
                    break;
                case 6:
                    top5BooksConMasDescargas();
                    break;
                case 7:
                    listaBooksPorNombreDeAuthor();
                    break;
                case 0:
                    System.out.println("Gracias por usar mi aplicación. ¡Hasta pronto!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            }catch (Exception e){
                System.out.println("Error al ajecutar la opcion: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }


    private void listaBooksRegistrados() {
        System.out.println("Libros registrados");
        books = bookRepository.findAll();
        books.forEach(System.out::println);

    }
    private void listarAutoresRegistrados() {
        System.out.println("\nListado de autores registrados:");
        authors = authorRepository.findAll();
        authors.forEach(System.out::println);
    }
    private void buscarAuthorsVivosEnAnoEspecifico() {
        System.out.println("\nEscriba el año que desea buscar: ");
        var año = teclado.nextInt();

        authors = authorRepository.findAll();
        if (authors.isEmpty()) {
            System.out.println("No hay autores vivos en ese año:");
        }else {
            System.out.println(año);
            System.out.println("\nListado de autores vivos en el año " + año + ": ");
            authors = authorRepository.findAuthorByFecha(año);

            authors.forEach(System.out::println);

        }
    }

    public void buscarBooksPorIdioma() {
        System.out.println("\nListado de idiomas registrados:");
        List<Idiomas> listaDeIdiomas = List.of(Idiomas.values());
        for (int i = 0; i < listaDeIdiomas.size(); i++) {
            System.out.println(" " + (i + 1) + " " + listaDeIdiomas.get(i).getNombreIdioma());
        }
        System.out.println("\nSeleccione el número del idioma que desea buscar: ");
        var eleccion = teclado.nextInt();
        teclado.nextLine();
        if (eleccion < 1 || eleccion > listaDeIdiomas.size()) {
            System.out.println("Opción inválida");
            return;
        }
        Idiomas idiomaSeleccionado = listaDeIdiomas.get(eleccion - 1);
        System.out.println("\nListado de libros en - [ " + idiomaSeleccionado.getNombreIdioma().toUpperCase() + " ]:");
        books = bookRepository.findByIdioma(idiomaSeleccionado.getAbreviaturas());
        books.forEach(System.out::println);
        System.out.println();
    }

    private void top5BooksConMasDescargas() {
        System.out.println("\nTop 5 libros más descargados:\n");
        books = bookRepository.findTop10Descargados();
        books.forEach(System.out::println);
    }

    private void listaBooksPorNombreDeAuthor() {
        authors = authorRepository.findAll();
        System.out.println("\nListado de autor registrados:");
        for (int i = 0; i < authors.size(); i++) {
            System.out.println(" " + (i + 1) + " " + authors.get(i).getNombre());
        }

        System.out.println("\nEscriba el número del autor que desea buscar: ");
        var eleccion = teclado.nextInt();
        if (eleccion < 1 || eleccion > authors.size()) {
            System.out.println("Opción inválida");
            return;
        }
        System.out.println("\nListado de books de : " + authors.get(eleccion - 1).getNombre());
        books = bookRepository.findBookByAuthor(authors.get(eleccion - 1));
        books.forEach(System.out::println);
    }


    private void busquedaDeBooks() throws Exception {
        System.out.println("Escriba el título del libro que desea buscar: ");
        var tituloLibro = teclado.nextLine();

        var resultadoBusqueda = new ConsumoApi().buscarBoook(tituloLibro);
        System.out.println("Resultado de la búsqueda: " + resultadoBusqueda);

        JSONObject jsonObject = new JSONObject(resultadoBusqueda);
        JSONArray resultsArray = jsonObject.getJSONArray("results");

        if (resultsArray.length() == 0) {
            System.out.println("Libro no encontrado con el título: " + tituloLibro);
            return;
        }

        System.out.println("Se encontraron " + resultsArray.length() + " libros: \n");
        for (int i = 0; i < resultsArray.length(); i++) {
            System.out.println((i + 1) + " " + resultsArray.getJSONObject(i).getString("title"));
        }

        System.out.println("\nSeleccione el libro deseado indicando su número, o presione 0 para cancelar: ");
        var numeroLibro = teclado.nextInt();
        teclado.nextLine();
        if (numeroLibro == 0) {
            return;
        }
        numeroLibro = numeroLibro - 1;

        JSONObject selectedBook = resultsArray.getJSONObject(numeroLibro);
        datosBook = convierteDatos.obtenerDatos(selectedBook.toString(), DatosBook.class);

        Optional<Book> libro = bookRepository.findById(datosBook.idBook());
        if (libro.isPresent()) {
            System.out.println("Libro ya está registrado");
            System.out.println(libro.get());
            return;
        }

        String idioma = new ConsumoApi().getIdioma(selectedBook);

        String authorsJson = selectedBook.getJSONArray("authors").toString();
        String resultado = authorsJson.substring(1, authorsJson.length() - 1);


        datosAuthor = convierteDatos.obtenerDatos(resultado, DatosAuthor.class);

        authors = authorRepository.findAll();
        Optional<Author> author = authors.stream()
                .filter(a -> a.getNombre() != null && a.getNombre().equals(datosAuthor.nombre()))
                .findFirst();

        Author authorOfTheBook;
        if (author.isPresent()) {
            authorOfTheBook = author.get();
        } else {
            authorOfTheBook = new Author(datosAuthor.nombre(), datosAuthor.fechaDeNacimiento(), datosAuthor.fechaDeDefuncion());
            authorOfTheBook = authorRepository.save(authorOfTheBook);
        }

        Book libroNuevo = new Book(datosBook, authorOfTheBook, idioma);
        bookRepository.save(libroNuevo);

        System.out.println("Libro registrado exitosamente");
        System.out.println(libroNuevo);
    }


}

