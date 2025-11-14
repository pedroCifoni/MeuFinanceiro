package services;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

	private static final Gson gson = new GsonBuilder()
	        .registerTypeAdapter(java.time.LocalDate.class, 
	            (com.google.gson.JsonSerializer<LocalDate>) (src, typeOfSrc, context) ->
	                    new com.google.gson.JsonPrimitive(src.toString()))
	        .registerTypeAdapter(java.time.LocalDate.class,
	            (com.google.gson.JsonDeserializer<LocalDate>) (json, type, context) ->
	                    LocalDate.parse(json.getAsString()))
	        .setPrettyPrinting()
	        .create();



    public static <T> void salvarLista(String caminho, List<T> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static <T> List<T> carregarLista(String caminho, Type tipoLista) {
        try (FileReader reader = new FileReader(caminho)) {
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            return null;
        }
    }
}
