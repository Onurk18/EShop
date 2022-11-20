import java.util.Scanner;

public class PatikaStore {

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);//Scanner nesnesi oluşturuldu
        System.out.println("Patika Store Ürün Yönetim Sistemi");
        System.out.println("---------------------------------\n");
        int choose;
        do {//do-while ve switch kullanarak yapılacak işlem seçildi.
            System.out.println("1-Ürün ekle");
            System.out.println("2-Ürünleri listele");
            System.out.println("3-Ürün sil");
            System.out.println("0-Kapat");
            System.out.print("işlem seçin: ");
            choose= input.nextInt();
            switch (choose) {
                case 1 -> addProduct();
                case 2 -> showList();
                case 3 -> {
                    System.out.print("Silinecek ürünün id'sini girin: ");
                    int id = input.nextInt();
                    deleteRecord(id);
                }
                default -> {
                }
            }
        }while (choose!=0);






    }

    static void addProduct(){//sisteme ürün yüklemek için kullanılan metod
        Scanner input= new Scanner(System.in);
        System.out.print("Ekleyeceğiniz Tür (Notebook,Cep Telefonu): ");
        String x= input.nextLine();
        int control= x.equals("Notebook")||x.equals("notebook")? 1:0;// ürün notebook mu telefon mu oldugu kontrol edildi

        System.out.print("Adı: ");
        String name= input.nextLine();

        System.out.print("Markası: ");
        String brandName= input.nextLine();
        Brand brand=Brand.findBrand(brandName);

        System.out.print("Stok: ");
        int stok= input.nextInt();

        System.out.print("Fiyat: ");
        int price= input.nextInt();

        System.out.print("İndirim Oranı: ");
        double discount= input.nextDouble();

        System.out.print("Ekran boyutu: ");
        double screen= input.nextDouble();

        System.out.print("RAM: ");
        int mem= input.nextInt();

        System.out.print("Depolama: ");
        int storage= input.nextInt(); //Kullanıcıdan özellikleri alındı.

        if (control==1){
            Product.productList.add(new Notebook(stok,mem,storage,screen,price,discount,name,brand));//notebook kurucu metodu
        }
        else {
            System.out.print("Batarya: ");
            int batt= input.nextInt();
            input.nextLine();

            System.out.print("Renk: ");
            String color= input.nextLine();


            Product.productList.add(new Phone(stok,mem,storage,screen,price,discount,name,brand,batt,color));//telefon için fazladan özellikler alınıp kurucu metod çağrıldı
        }

        System.out.println("Ürün girildi! ID: "+(Product.idCount-1)); //ürünün idsi
        System.out.println("\n");


    }

    static void showList(){
        Scanner input= new Scanner(System.in);
        System.out.println("\n\n1-Tüm ürünleri listele");//liste çeşitleri
        System.out.println("2-Notebook");
        System.out.println("3-Phone");
        System.out.println("4-Marka listele");
        System.out.println("5-ID giriniz");
        System.out.print("İşlem seçiniz: ");
        int choose= input.nextInt();
        switch (choose) {
            case 1 -> show(0);
            case 2 -> show(1);
            case 3 -> show(2);
            case 4 -> showBrand();
            case 5 -> showId();
            default -> {
            }
        }
        System.out.println("Ana menüye dönmek için entera basın.\n\n");
        input.nextLine();
        input.nextLine();
    }

    public static void show(int a){
        if(a==0){ //Burada seçilen liste çeşidine göre fortmatlı bir şekilde listelendi
            System.out.printf("%4s  %7s  %7s  %7s  %9s  %15s  %13s  %7s  %7s  %7s  %7s\n\n","ID","Name","Brand","Stock","Price","Discount Rate","Screen Size","Memory","Storage","Battery","Color");
            for (Product i:
                 Product.productList) {
                if(i instanceof Phone){
                    System.out.printf("%4s  %7s  %7s  %7s  %7sTL  %15s  %9sINCH  %5sGB  %5sGB  %7s  %7s\n",i.productId,i.name,i.brand.name,i.stock,i.unitPrice,i.discountRate,i.screen,i.ram,i.storage,((Phone) i).battery,((Phone) i).color);
                }else{
                    System.out.printf("%4s  %7s  %7s  %7s  %7sTL  %15s  %9sINCH  %5sGB  %5sGB\n",i.productId,i.name,i.brand.name,i.stock,i.unitPrice,i.discountRate,i.screen,i.ram,i.storage);
                }

            }
        }
        else if(a==1){
            System.out.printf("%4s  %7s  %7s  %7s  %9s  %15s  %13s  %7s  %7s  %7s  %7s\n\n","ID","Name","Brand","Stock","Price","Discount Rate","Screen Size","Memory","Storage","Battery","Color");

            for (Product i:
                    Product.productList) {
                if(i instanceof Notebook){
                    System.out.printf("%4s  %7s  %7s  %7s  %7sTL  %15s  %9sINCH  %5sGB  %5sGB\n",i.productId,i.name,i.brand.name,i.stock,i.unitPrice,i.discountRate,i.screen,i.ram,i.storage);

                }
            }
        }
        else if(a==2){
            System.out.printf("%4s  %7s  %7s  %7s  %9s  %15s  %13s  %7s  %7s  %7s  %7s\n\n","ID","Name","Brand","Stock","Price","Discount Rate","Screen Size","Memory","Storage","Battery","Color");

            for (Product i:
                    Product.productList) {
                if(i instanceof Phone){
                    System.out.printf("%4s  %7s  %7s  %7s  %7sTL  %15s  %9sINCH  %5sGB  %5sGB  %7s  %7s\n",i.productId,i.name,i.brand.name,i.stock,i.unitPrice,i.discountRate,i.screen,i.ram,i.storage,((Phone) i).battery,((Phone) i).color);

                }
            }
        }
    }

    public static void showBrand(){//seçilen brand için yapılan listeleme
        Scanner input= new Scanner(System.in);
        System.out.print("Brand seçiniz: ");
        String brand=input.nextLine();
        System.out.printf("%4s  %7s  %7s  %7s  %9s  %15s  %13s  %7s  %7s  %7s  %7s\n\n","ID","Name","Brand","Stock","Price","Discount Rate","Screen Size","Memory","Storage","Battery","Color");



        for (Product i:
             Product.productList) {
            if(i.brand.name.equals(brand)){
                if(i instanceof Phone){
                    System.out.printf("%4s  %7s  %7s  %7s  %7sTL  %15s  %9sINCH  %5sGB  %5sGB  %7s  %7s\n",i.productId,i.name,i.brand.name,i.stock,i.unitPrice,i.discountRate,i.screen,i.ram,i.storage,((Phone) i).battery,((Phone) i).color);

                }else{
                    System.out.printf("%4s  %7s  %7s  %7s  %7sTL  %15s  %9sINCH  %5sGB  %5sGB\n",i.productId,i.name,i.brand.name,i.stock,i.unitPrice,i.discountRate,i.screen,i.ram,i.storage);
                }

            }
        }
    }

    public static void showId(){//seçilen id için çalıştırılan listeleme
        Scanner input= new Scanner(System.in);
        System.out.print("ID giriniz: ");
        int id=input.nextInt();
        System.out.printf("%4s  %7s  %7s  %7s  %9s  %15s  %13s  %7s  %7s  %7s  %7s\n\n","ID","Name","Brand","Stock","Price","Discount Rate","Screen Size","Memory","Storage","Battery","Color");



        for (Product i:
                Product.productList) {
            if(i.productId==id){
                if(i instanceof Phone){
                    System.out.printf("%4s  %7s  %7s  %7s  %7sTL  %15s  %9sINCH  %5sGB  %5sGB  %7s  %7s\n",i.productId,i.name,i.brand.name,i.stock,i.unitPrice,i.discountRate,i.screen,i.ram,i.storage,((Phone) i).battery,((Phone) i).color);

                }else{
                    System.out.printf("%4s  %7s  %7s  %7s  %7sTL  %15s  %9sINCH  %5sGB  %5sGB\n",i.productId,i.name,i.brand.name,i.stock,i.unitPrice,i.discountRate,i.screen,i.ram,i.storage);
                }
            }
            if((id<100)||(id>=Product.idCount)){
                System.out.println("ID bulunamadı...");
            }



        }
    }

    public static void deleteRecord(int id){//girilen idyi arrayden silen metod
        if(Product.productList.removeIf(i -> i.productId == id)){//eğer id eşleşirse nesne silinir.
            System.out.println("Ürün silindi.");
        }
        else {
            System.out.println("Ürün bulunamadı.");
        }
        System.out.println("Ana menüye dönülüyor. \n\n");


    }


}
