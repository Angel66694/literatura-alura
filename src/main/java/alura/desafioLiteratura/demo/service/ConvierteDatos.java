package alura.desafioLiteratura.demo.service;

import alura.desafioLiteratura.demo.service.IConvierteDatos;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}