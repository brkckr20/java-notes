
package models;

public class MUlke {
    private String ulke_adi;
    private String ulke_kodu;
    private String alan_kodu;

    public MUlke(String ulke_adi, String ulke_kodu, String alan_kodu) {
        this.ulke_adi = ulke_adi;
        this.ulke_kodu = ulke_kodu;
        this.alan_kodu = alan_kodu;
    }

    public String getUlke_adi() {
        return ulke_adi;
    }

    public void setUlke_adi(String ulke_adi) {
        this.ulke_adi = ulke_adi;
    }

    public String getUlke_kodu() {
        return ulke_kodu;
    }

    public void setUlke_kodu(String ulke_kodu) {
        this.ulke_kodu = ulke_kodu;
    }

    public String getAlan_kodu() {
        return alan_kodu;
    }

    public void setAlan_kodu(String alan_kodu) {
        this.alan_kodu = alan_kodu;
    }
}
