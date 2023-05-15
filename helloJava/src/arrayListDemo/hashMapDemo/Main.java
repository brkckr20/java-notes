package arrayListDemo.hashMapDemo;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> sozluk = new HashMap<String, String>(); // illa ki String,String olmak zorunda değildir.
        sozluk.put("book", "Kitap");
        sozluk.put("table", "masa");
        sozluk.put("computer", "bilgisayar");
        System.out.println("Sözlük " + sozluk);
        System.out.println("kac eleman  : " + sozluk.size());

        System.out.println("---");
        for (String item : sozluk.keySet()) {
            System.out.println("Eleman : " + item + ", Değer : " + sozluk.get(item));
        }
        System.out.println("---");
        sozluk.remove("computer");
        System.out.println(sozluk.get("table")); // key değeri olan value'yi siler
        sozluk.clear(); //tümünü temizler
        System.out.println(sozluk.get("table"));
    }
}
