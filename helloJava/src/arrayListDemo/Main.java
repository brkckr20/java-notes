package arrayListDemo;

import java.util.ArrayList; //ArrayList kullanılması için import edilmelidir.

public class Main {

    public static void main(String[] args) {
        ArrayList sayilar = new ArrayList();
        sayilar.add(1);
        sayilar.add(10);
        sayilar.add("Denizli");
        System.out.println("size : " + sayilar.size());
        System.out.println("2.index : " + sayilar.get(2));
        sayilar.set(0, 100); //degerin degistirilmesi islemi - guncelleme
        System.out.println("0.index : " + sayilar.get(0));
        sayilar.remove(0);

        sayilar.add(true);
        System.out.println("0.index : " + sayilar.get(0));
        //sayilar.clear(); // tüm elemanları siler

        for (Object i : sayilar) {
            System.out.println(i);
        }

    }
}
