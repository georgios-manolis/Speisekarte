package menu_java;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    //starte Main
    public static void main(String[] args) throws Exception{
        //Erstelle Array für alle Gerichte
        ArrayList<Product> menu = new ArrayList<>();

        //lädt die Speisekarte aus dem resources Ordner
        InputStream readMenu = Main.class
                .getClassLoader()
                .getResourceAsStream("data/Speisekarte.txt");
        //Überprüft ob Speisekarte vorhanden ist. Wenn nicht gib Fehler zurück.
        if (readMenu == null){
            System.out.println("keine Speisekarte gefunden");
            return;
        }
        //Datei zeilenweise lesbar machen
        BufferedReader reader = new BufferedReader(new InputStreamReader(readMenu));
        //Erste Zeile der Textdatei enthält keine Zahl, sondern nur den Spaltenkopf. Wird mit einem readLine rausgefiltert.
        reader.readLine();
        //anschließend gelesene zeilen in inputMenu speichern
        String inputMenu = reader.readLine();

        //lies und übersetze so lange, bis keine Zeile mehr da ist
        while(inputMenu != null) {

            //Einträge an den Tabs einteilen
            String[] columns = inputMenu.split("\t");

            //Spalten entprechned erstellen
            int id = Integer.parseInt(columns[0]);
            String productName = columns[1];
            String portion = columns[2];
            double price = Double.parseDouble(columns[3]);
            String category = columns[4];
            String description = columns[5];

            //Object Meal erstellen
            Product meal = new Product(id, productName, portion, price, category, description);
            //und der ArrayList hinzufügen
            menu.add(meal);

            //Speisekarte ausgeben
            System.out.println(meal);
            //nächste Zeile auslesen
            inputMenu = reader.readLine();
        }
        reader.close();
    }
}