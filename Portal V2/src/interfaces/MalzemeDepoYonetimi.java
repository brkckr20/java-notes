
package interfaces;

import java.util.Date;
import java.util.List;
import models.MSarfMalzemeDepo;


public interface MalzemeDepoYonetimi {
    void onSarfMalzemeGirisListeSelected(int id, Date tarih, String fatura_no,String firma_kodu,String firma_unvan);
}
