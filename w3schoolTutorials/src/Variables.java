
public class Variables {

    public static void main(String[] args) {
        // değişken tanımlama döz dizimi
        // type variableName = value;

        String name = "Burak";
        System.out.println(name);

        int sayi1 = 10;
        sayi1 = 20; //değer sonradan değiştirilebildi
        System.out.println("sayi1 :" + sayi1);
        
        final int sayi2=22; // sayi final int şeklinde tanımlandığı için değeri sonradan değiştirelemez değiştirince hata verir.
        //sayi2=33;
        System.out.println(sayi2);
    }
}
