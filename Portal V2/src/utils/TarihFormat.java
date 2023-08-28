
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class TarihFormat {
    private static SimpleDateFormat gelenTarihSaatFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat gosterilecekTarihFormat = new SimpleDateFormat("dd.MM.yyyy");
    
    public static String formatla(String gelenTarihSaatStr){
        try {
            Date gelenTarihSaat = gelenTarihSaatFormat.parse(gelenTarihSaatStr);
            return gosterilecekTarihFormat.format(gelenTarihSaat);
        } catch (Exception e) {
            e.printStackTrace();
            return ""; // Hata durumunda boş string dönebilirsiniz
        }
    }
}
