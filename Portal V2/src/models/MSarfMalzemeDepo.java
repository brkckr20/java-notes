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
    private int miktar;
    private String not1;
    private String not2;
    private String cikilan_birim;
    private String teslim_alan;
    

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
    
    /* sarf malzeme depo cikis için */

    public MSarfMalzemeDepo(int id, String malzeme_kodu, String malzeme_adi, String birim, String uuid, int miktar, String not1, String not2, String cikilan_birim, String teslim_alan, String firma_kodu, String firma_unvan, String kalem_islem, Date tarih) {
        this.id = id;
        this.malzeme_kodu = malzeme_kodu;
        this.malzeme_adi = malzeme_adi;
        this.birim = birim;
        this.uuid = uuid;
        this.miktar = miktar;
        this.not1 = not1;
        this.not2 = not2;
        this.cikilan_birim = cikilan_birim;
        this.teslim_alan = teslim_alan;
        this.firma_kodu = firma_kodu;
        this.firma_unvan = firma_unvan;
        this.kalem_islem = kalem_islem;
        this.tarih = tarih;
    }

    /* SARF MALZEME DEPO ÇIKIŞ'TAN DOLUM TAMİR BEKLEYENLER İÇİN OLUŞTURULDU*/
    public MSarfMalzemeDepo(String malzeme_kodu, String malzeme_adi, int kalan_miktar, String birim, String uuid, String kalem_islem,Date tarih,String firma_unvan) {
        this.malzeme_kodu = malzeme_kodu;
        this.malzeme_adi = malzeme_adi;
        this.kalan_miktar = kalan_miktar;
        this.birim = birim;
        this.uuid = uuid;
        this.kalem_islem = kalem_islem;
        this.tarih = tarih;
        this.firma_unvan = firma_unvan;
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

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public String getNot1() {
        return not1;
    }

    public String getNot2() {
        return not2;
    }

    public String getCikilan_birim() {
        return cikilan_birim;
    }

    public String getTeslim_alan() {
        return teslim_alan;
    }
    
}
