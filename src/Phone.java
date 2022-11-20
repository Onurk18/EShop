public class Phone extends Product {
    int battery;
    String color;

    public Phone(int stock, int ram, int storage, double screen, double unitPrice, double discountRate, String name, Brand brand, int battery, String color) {
        super( stock, ram, storage, screen, unitPrice, discountRate, name, brand);
        this.battery = battery;
        this.color = color;
    }
}
