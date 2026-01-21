package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
public class Lettore implements Runnable{
    @Override
    public void run() {
        leggi();
        System.out.println("\nLettura con GSON");
        leggiConGson();
    }
    public void leggi(){
        FileReader fr;
        int i;
        try {
            //1) apro il file
            fr = new FileReader("playlist.json");
            //2) leggo carattere per carattere e lo stampo
            while ((i=fr.read()) != -1)
                System.out.print((char) i);

            System.out.print("\n\r");
            //3) chiudo il file
            fr.close();
        } catch (IOException ex) {
            System.err.println("Errore in lettura!");
        }
    }

    public void leggiConGson() {
        try (FileReader fr = new FileReader("playlist.json")) {
            // Creo un'istanza di Gson con formattazione elegante
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Leggo il JSON come JsonElement
            JsonElement jsonElement = JsonParser.parseReader(fr);

            // Stampo il JSON formattato
            String jsonFormattato = gson.toJson(jsonElement);
            System.out.println(jsonFormattato);

        } catch (IOException ex) {
            System.err.println("Errore in lettura con GSON!");
        }
    }
}
