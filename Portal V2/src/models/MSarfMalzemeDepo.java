
package models;

public class MSarfMalzemeDepo {
    private int id;
    private String malzeme_kodu;
    private String malzeme_adi;
    private int kalan_miktar;
    private String birim;
    private String uuid;

    public MSarfMalzemeDepo(String malzeme_kodu, String malzeme_adi, int kalan_miktar, String birim, String uuid) {
        this.malzeme_kodu = malzeme_kodu;
        this.malzeme_adi = malzeme_adi;
        this.kalan_miktar = kalan_miktar;
        this.birim = birim;
        this.uuid = uuid;
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
}
