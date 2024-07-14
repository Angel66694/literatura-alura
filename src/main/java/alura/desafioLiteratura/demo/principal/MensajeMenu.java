package alura.desafioLiteratura.demo.principal;

import org.springframework.stereotype.Component;

@Component
public class MensajeMenu {
    public void mostrarMenu() {
        String mensajeInicial = """
                ***************************************************
                ***Ingrese el numero de la opcion que desea usar***
                --------------------------------------------------
                
                1). Buscar libro por titulo..
                2). Lista de libros registrados..
                3). lista de autores registrados..
                4). Buscar autores vivios en un año especifico..
                5). Buscar libros por idioma..
                6). Top 5 libros con mas descargas..
                7). Lista de libros por nombre de autor..
                
                0). Salir de la aplicacion
                """;

        System.out.println(mensajeInicial);
    }
}
