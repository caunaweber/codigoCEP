package Model;

import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Json  {

    private static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public JsonElement apiReader(String cep) {

        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return JsonParser.parseString(response.body());
        } catch (IOException | InterruptedException  e) {
            throw new RuntimeException("Algum erro interrompeu a busca: ", e);
        }
    }

    public void JsonGenerator(JsonElement jsonText) throws IOException {
        Endereco end = gson.fromJson(jsonText, Endereco.class);

        try(FileWriter fw = new FileWriter(end.cep()+".json")){
            fw.write(gson.toJson(jsonText));
        }
    }

    public Endereco jsonConverter(JsonElement json) {
        return gson.fromJson(json, Endereco.class);
    }
}
