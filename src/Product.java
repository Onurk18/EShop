import java.util.ArrayList;

public abstract class Product {
    int productId,stock,ram,storage;
    double unitPrice, discountRate,screen;
    String name;
    Brand brand;
    static int idCount=100;

    public Product(int stock, int ram, int storage, double screen, double unitPrice, double discountRate, String name, Brand brand) {
        this.productId = idCount;
        idCount++;
        this.stock = stock;
        this.ram = ram;
        this.storage = storage;
        this.screen = screen;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.name = name;
        this.brand = brand;
    }

    public static ArrayList<Product> productList=new ArrayList<>();//girilen ürünlerin tutulduğu array


}

