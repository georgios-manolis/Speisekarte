package speisekarte_java;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    //starte Main
    public static void main(String[] args) throws Exception{
        //lädt die Speisekarte aus dem resources Ordner
        InputStream liesKarte = Main.class
                .getClassLoader()
                .getResourceAsStream("data/Speisekarte.txt");
        //Übersetze eingelesene Daten...
        BufferedReader uebersetzung = new BufferedReader(new InputStreamReader(liesKarte));
        String ausgabe = uebersetzung.readLine();

        //...und gib aus, was du übersetzt hast
        System.out.println(ausgabe);
    }
}