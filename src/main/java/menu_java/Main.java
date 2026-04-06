package menu_java;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //starte Main
    public static void main(String[] args) throws Exception {
        //Methode zum Auslesen der Speiekarte
        ArrayList<Product> menu = readMenu();
        writeMenu(menu);

        //Methode zum Einfügen von neuen Gerichten
        Product newProduct = addProduct();
        if(newProduct != null)
        {
            menu.add(newProduct);
        }
        writeMenu(menu);
    }

    private static Product addProduct() {
        // Benutzereingabe vorbereiten
        Scanner scanner = new Scanner(System.in);

        // Fragen, ob neues Gericht hinzugefügt werden soll
        System.out.println();
        System.out.print("Möchtest du ein neues Gericht hinzufügen? (y/n): ");
        String answer = scanner.nextLine();

        // nur wenn y eingegeben wurde
        if (answer.equalsIgnoreCase("y")) {

            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Produktname: ");
            String productName = scanner.nextLine();

            System.out.print("Portion: ");
            String portion = scanner.nextLine();

            System.out.print("Preis: ");
            double price = Double.parseDouble(scanner.nextLine().replace(",", "."));

            System.out.print("Kategorie: ");
            String category = scanner.nextLine();

            System.out.print("Beschreibung: ");
            String description = scanner.nextLine();

            // neues Produkt erzeugen
            Product newMeal = new Product(id, productName, portion, price, category, description);

            // zur Liste hinzufügen
            System.out.println("Neues Gericht wurde hinzugefügt.");
            return newMeal;
        }
        return null;
    }

    private static ArrayList<Product> readMenu() throws IOException {
        //Erstelle Array für alle Gerichte
        ArrayList<Product> menu = new ArrayList<>();

        //lädt die Speisekarte aus dem resources Ordner
        InputStream readMenu = Main.class
                .getClassLoader()
                .getResourceAsStream("data/Speisekarte.txt");
        //Überprüft ob Speisekarte vorhanden ist. Wenn nicht gib Fehler zurück.
        if (readMenu == null) {
            System.out.println("keine Speisekarte gefunden");
            return menu;
        }
        //Datei zeilenweise lesbar machen
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(readMenu))){

            //Erste Zeile der Textdatei enthält keine Zahl, sondern nur den Spaltenkopf. Wird mit einem readLine rausgefiltert.
            reader.readLine();
            //anschließend gelesene zeilen in inputMenu speichern
            String inputMenu = reader.readLine();
            System.out.println("Aktuelle Speisekarte:");

            //lies und übersetze so lange, bis keine Zeile mehr da ist
            while (inputMenu != null) {

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

                //nächste Zeile auslesen und Speisekarte auslesen
                inputMenu = reader.readLine();
            }
        }
        return menu;
    }

    public static void writeMenu(ArrayList<Product> menu) {
        for (Product product : menu){
            System.out.println(product.toString());
        }
    }
}