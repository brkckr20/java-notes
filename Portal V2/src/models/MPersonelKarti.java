
package models;


public class MPersonelKarti {
    private int id;
    private String ad_soyad;
    private String departman;

    public MPersonelKarti(int id, String ad_soyad, String departman) {
        this.id = id;
        this.ad_soyad = ad_soyad;
        this.departman = departman;
    }

    public int getId() {
        return id;
    }

    public String getAd_soyad() {
        return ad_soyad;
    }

    public String getDepartman() {
        return departman;
    }
}
