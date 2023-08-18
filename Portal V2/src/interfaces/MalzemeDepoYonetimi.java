package interfaces;

import java.util.ArrayList;
import java.util.Date;

public interface MalzemeDepoYonetimi {

    void onSarfMalzemeGirisListeSelected(int id, Date tarih, String fatura_no, String firma_kodu, String firma_unvan, ArrayList<Object[]> selectedRowData);
}
