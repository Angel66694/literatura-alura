package alura.desafioLiteratura.demo.model.author;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAuthor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") int fechaDeNacimiento,
        @JsonAlias("death_year") int fechaDeDefuncion
) {


    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public int fechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    @Override
    public int fechaDeDefuncion() {
        return fechaDeDefuncion;
    }

}
