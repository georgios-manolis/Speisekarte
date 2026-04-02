package menu_java;

//Baue Klasse Product/Gericht
public class Product {
    private int id;
    private String productName;
    private String portion;
    private double price;
    private String category;
    private String description;

    //Erstelle Bauplan für Nachträge
    public Product(int id,String productName,String portion,double price,String category, String description){
        this.id = id;
        this.productName = productName;
        this.portion = portion;
        this.price = price;
        this.category = category;
        this.description = description;
    }
    @Override
    public String toString() {
        return id + " | " + productName + " | " + portion + " | " + price + " | " + category + " | " + description;
    }
}
