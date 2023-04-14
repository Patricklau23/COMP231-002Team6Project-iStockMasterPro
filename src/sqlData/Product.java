package sqlData;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleDoubleProperty price;
    private final SimpleIntegerProperty stock;
    
//    public Product(String name, double price)
//    {
//    	this.name = name;
//    	this.price = price
//    }
    public Product(int id, String name, double price, int stock) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.stock = new SimpleIntegerProperty(stock);
    }
    
    public int getId() {
        return id.get();
    }
    
    public SimpleIntegerProperty idProperty() {
        return id;
    }
    
    public String getName() {
        return name.get();
    }
    
    public SimpleStringProperty nameProperty() {
        return name;
    }
    
    
    public int getStockLevel() {
        return stock.get();
    }
    
    public SimpleIntegerProperty stockProperty() {
        return stock;
    }
    
    public double getPrice() { 
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }
    
    public void setId(int id) {
    	this.id.set(id);
    }
    
    public void setName(String name) {
        this.name.set(name);
    }
    
    public void setPrice(double price) {
        this.price.set(price);
    }

    public void setStockLevel(int stock) {
        this.stock.set(stock);
    }

}
