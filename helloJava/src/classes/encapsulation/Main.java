package classes.encapsulation;

public class Main {

    public static void main(String[] args) {
        Product product = new Product(121, "Laptop", "Macbook pro", 3020, 5, "laptop123");
        /*product.setName("Bilgisayar");
         product.setPrice(12);
         System.out.println(product.getName());
         System.out.println(product.getPrice());
         product.setId(1);*/

        ProductManager productManager = new ProductManager();
        productManager.Add(product);
        productManager.Add2(1, "lorem", "ipsum", 12, 11.5);
        System.out.println("Kod : " + product.getKod());

        MethodOverloading mo = new MethodOverloading();
        System.out.println(mo.topla(1, 4));
        System.out.println("topla :" + mo.topla(2, 34, 1));
    }
}
