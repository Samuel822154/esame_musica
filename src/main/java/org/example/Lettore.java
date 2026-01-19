package org.example;

import java.io.FileReader;
import java.io.IOException;
public class Lettore implements Runnable{
    @Override
    public void run() {
        leggi();
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
}
