

public class strings {

    public static void main(String[] args) {
        String mesaj = "    Lorem ipsum dolor sit amet : ";
        System.out.println("Mesajım : " + mesaj);
         System.out.println("Uzunluk : " + mesaj.length());
         System.out.println("5. eleman : " + mesaj.charAt(4)); // index numarası verilir.
         System.out.println(mesaj.concat(" Bunlar mıgır metinlerdir!"));
         System.out.println(mesaj.startsWith("x")); // x ile mi başlıyor.
         System.out.println(mesaj.endsWith(" ")); // boşluk ile mi bitiyor.
         char[] karakterler = new char[5];
         mesaj.getChars(0, 5, karakterler, 0);
         //System.out.println("Karakterler : " + Arrays.toString(karakterler));
         System.out.println(mesaj.indexOf("a")); // a harfinin kaçıncı karakter olacağı - ilk bulduğunu verir. - baştan itibaren arar.
         System.out.println(mesaj.lastIndexOf(":")); // sondan aramaya başlar.

         System.out.println("---------------------");

        System.out.println(mesaj.replace(" ", "-"));
        System.out.println("---------------------");
        System.out.println(mesaj.substring(7)); // 7.indexden sona kadar keser
        System.out.println(mesaj.substring(7, 8)); // 7.indexden 8. index'e kadar keser
        for (String kelime : mesaj.split(" ")) {
            System.out.println(kelime);
        }
        System.out.println("---------------------");
        System.out.println(mesaj.toLowerCase());
        System.out.println(mesaj.toUpperCase());
        System.out.println(mesaj.trim()); // baştaki ve sonraki boşlukları siler
    }
}
