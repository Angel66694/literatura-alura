package alura.desafioLiteratura.demo.model.book;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosBook(
        @JsonAlias("id") int idBook,
        @JsonAlias("title") String titulo,
        @JsonAlias("download_count") Integer totalDeDescargas
) {
}
