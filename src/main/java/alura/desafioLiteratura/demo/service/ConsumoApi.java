package alura.desafioLiteratura.demo.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


@Component
public class ConsumoApi {
    private String urlBook = "https://gutendex.com/books/?search=";

    public String buscarBoook(String tituloLibro) {
        String url = urlBook + tituloLibro.replace(" ", "%20");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response =null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }

    public String getIdioma(JSONObject jsonMap) throws JSONException {
        if (jsonMap.has("idiomas")) {
            JSONArray idiomasArray = jsonMap.getJSONArray("idiomas");
            if (idiomasArray.length() > 0) {
                return idiomasArray.getString(0);
            } else {
                return "";
            }
        } else {
            return "";
        }
    }
}