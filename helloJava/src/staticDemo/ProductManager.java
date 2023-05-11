package staticDemo;

public class ProductManager {

    public void add(Product product) {
        //ProductValidator validator = new ProductValidator();
        if (ProductValidator.isValid(product)) { //metot static yapılınca direkt class ismiyle cağrılabilir.
            System.out.println("Eklendi");
        } else {
            System.out.println("Ürün bilgilerini kontrol ediniz...");
        }

    }
}
