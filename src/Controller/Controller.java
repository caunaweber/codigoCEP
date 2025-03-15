package Controller;

import Model.Cep;
import Model.Json;
import View.View;
import com.google.gson.JsonElement;

import java.io.IOException;

public class Controller {
    public void menu() throws IOException {

        String cep;
        Json json = new Json();

        while(true){
            cep = View.solicitaCEP();
            if(cep.equalsIgnoreCase("sair")){
                break;
            }
            JsonElement jsonResponse = json.apiReader(cep);

            if(json.jsonConverter(jsonResponse).cep() != null){
                View.apresentaEndereco(new Cep(json.jsonConverter(jsonResponse)));

                json.JsonGenerator(jsonResponse);
            }else {
                System.out.println("Cep não existe");
            }
        }

        View.finisher();
    }
}
