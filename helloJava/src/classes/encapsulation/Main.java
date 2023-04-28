package classes.encapsulation;

public class Main {

    public static void main(String[] args) {
        Product product = new Product();
        product.setName("Bilgisayar");
        product.setPrice(12);
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        product.setId(1);
        

        ProductManager productManager = new ProductManager();
        productManager.Add(product);
        productManager.Add2(1, "lorem", "ipsum", 12, 11.5);
        System.out.println("Kod : " + product.getKod());
    }
}
