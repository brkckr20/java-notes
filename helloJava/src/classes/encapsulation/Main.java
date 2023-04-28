package classes.encapsulation;

public class Main {

    public static void main(String[] args) {
        Product product = new Product();
        product.name = "Bilgisayar";
        product.price = 12;
        System.out.println(product.name);
        System.out.println(product.price);

        ProductManager productManager = new ProductManager();
        productManager.Add(product);
        productManager.Add2(1, "lorem", "ipsum", 12, 11.5);
    }
}
