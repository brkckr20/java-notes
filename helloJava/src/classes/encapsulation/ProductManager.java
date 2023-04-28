package classes.encapsulation;

public class ProductManager {

    public void Add(Product product) {
        //jdbc kullanarak db ye kayıt işlemleri yapılacak
        System.out.println("Ürün eklendi : " + product.getName());
    }

    // bu kullanım genel olarak hatalı kullanımdır. farklı ekranlarda kullanılınca ve yeni bir özellik eklendiğinde her ekranda teker teker düzenleme ihtiyacı gelebilir
    public void Add2(int id, String name, String description, int stockAmount, double price) {
        System.out.println("Add2 : " + id + name + description + stockAmount + price);
    }
}
