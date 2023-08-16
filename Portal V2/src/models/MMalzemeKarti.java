
package models;


public class MMalzemeKarti {
    private int id;
    private String malzeme_kodu;
    private String malzeme_adi;
    private String depo_adi;
    private String birim;
    private String malzeme_marka;

    public MMalzemeKarti(String malzeme_kodu, String malzeme_adi, String birim) {
        this.malzeme_kodu = malzeme_kodu;
        this.malzeme_adi = malzeme_adi;
        this.birim = birim;
    }

    public MMalzemeKarti(int id, String malzeme_kodu, String malzeme_adi, String depo_adi, String birim, String malzeme_marka) {
        this.id = id;
        this.malzeme_kodu = malzeme_kodu;
        this.malzeme_adi = malzeme_adi;
        this.depo_adi = depo_adi;
        this.birim = birim;
        this.malzeme_marka = malzeme_marka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMalzeme_kodu() {
        return malzeme_kodu;
    }

    public void setMalzeme_kodu(String malzeme_kodu) {
        this.malzeme_kodu = malzeme_kodu;
    }

    public String getMalzeme_adi() {
        return malzeme_adi;
    }

    public void setMalzeme_adi(String malzeme_adi) {
        this.malzeme_adi = malzeme_adi;
    }

    public String getDepo_adi() {
        return depo_adi;
    }

    public void setDepo_adi(String depo_adi) {
        this.depo_adi = depo_adi;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getMalzeme_marka() {
        return malzeme_marka;
    }

    public void setMalzeme_marka(String malzeme_marka) {
        this.malzeme_marka = malzeme_marka;
    }
}
