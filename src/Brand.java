public class Brand {
    int id;
    String name;

    public static Brand[] brandList={new Brand(1,"Samsung"),new Brand(2,"Lenovo"),new Brand(3,"Apple"),
    new Brand(4,"Huwaei"),new Brand(5,"Casper"),new Brand(6,"Asus"),new Brand(7,"HP"),
    new Brand(8,"Xiaomi"), new Brand(9,"Monster")};//static şekilde atanmıs brand listesi

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public static Brand findBrand(String brandName){ //Girilen String brand adından Brand nesnesi döndüren metod
        for (Brand i:
                Brand.brandList) {
            if(i.name.equals(brandName)){
                return i;
            }
        }
        return null;
    }




}
