
package models;

import java.util.Date;



public class MSarfMalzemeDepo {
    private int id;
    private String malzeme_kodu;
    private String malzeme_adi;
    private int kalan_miktar;
    private String birim;
    private String uuid;
    private int giris_miktar;

    private String firma_kodu;
    private String firma_unvan;
    private String fatura_no;
    private String kalem_islem;
    
  
    public MSarfMalzemeDepo(String malzeme_kodu, String malzeme_adi, int kalan_miktar, String birim, String uuid) {
        this.malzeme_kodu = malzeme_kodu;
        this.malzeme_adi = malzeme_adi;
        this.kalan_miktar = kalan_miktar;
        this.birim = birim;
        this.uuid = uuid;
    }
    //id nosuna göre giriş önceki kayit getirme için
    public MSarfMalzemeDepo(int id, String malzeme_kodu, String malzeme_adi, int kalan_miktar, String birim, String uuid, Date tarih, String firma_kodu, String firma_unvan, String fatura_no, String kalem_islem) {
        this.id = id;
        this.malzeme_kodu = malzeme_kodu;
        this.malzeme_adi = malzeme_adi;
        this.kalan_miktar = kalan_miktar;
        this.birim = birim;
        this.uuid = uuid;
        this.tarih = tarih;
        this.firma_kodu = firma_kodu;
        this.firma_unvan = firma_unvan;
        this.fatura_no = fatura_no;
        this.kalem_islem = kalem_islem;
    }

    @Override
    public String toString() {
        return "MSarfMalzemeDepo{" + "id=" + id + ", malzeme_kodu=" + malzeme_kodu + ", malzeme_adi=" + malzeme_adi + ", kalan_miktar=" + kalan_miktar + ", birim=" + birim + ", uuid=" + uuid + ", tarih=" + tarih + ", firma_kodu=" + firma_kodu + ", firma_unvan=" + firma_unvan + ", fatura_no=" + fatura_no + ", kalem_islem=" + kalem_islem + '}';
    }
    
     private Date tarih;

    public Date getTarih() {
        return tarih;
    }

    public String getFirma_kodu() {
        return firma_kodu;
    }

    public String getFirma_unvan() {
        return firma_unvan;
    }

    public String getFatura_no() {
        return fatura_no;
    }

    public String getKalem_islem() {
        return kalem_islem;
    }
    

    public int getId() {
        return id;
    }

    public String getMalzeme_kodu() {
        return malzeme_kodu;
    }

    public String getMalzeme_adi() {
        return malzeme_adi;
    }

    public int getKalan_miktar() {
        return kalan_miktar;
    }

    public String getBirim() {
        return birim;
    }

    public String getUuid() {
        return uuid;
    }

    public int getGiris_miktar() {
        return giris_miktar;
    }
}
