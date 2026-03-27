package menue_java;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    //starte Main
    public static void main(String[] args) throws Exception{
        String outputMenue = "keine Speisekarte eingelesen";
        //lädt die Speisekarte aus dem resources Ordner
        InputStream readMenue = Main.class
                .getClassLoader()
                .getResourceAsStream("data/Speisekarte.txt");
        //lies die erste Zeile und übersetze die Daten
        BufferedReader translate = new BufferedReader(new InputStreamReader(readMenue));
        outputMenue = translate.readLine();

        //lies und übersetze so lange, bis keine Zeile mehr da ist
        while(outputMenue != null) {
            System.out.println(outputMenue);
            outputMenue = translate.readLine();
        }
    }
}