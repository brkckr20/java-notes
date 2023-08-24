package models;

public class MFirmaKarti {

    private int id;
    private String firma_kodu;
    private String firma_unvan1;
    private String firma_unvan2;
    private String adres1;
    private String adres2;
    private String ulke_adi;
    private String ulke_kodu;
    private String sehir;
    private String ilce;
    private String posta_kodu;
    private String vergi_dairesi;
    private String vergi_no;
    private String telefon;
    private String cari_tipi;
    private String gib_mail;

    public MFirmaKarti(int id, String firma_kodu, String firma_unvan1) {
        this.id = id;
        this.firma_kodu = firma_kodu;
        this.firma_unvan1 = firma_unvan1;
    }

    public MFirmaKarti(String firma_kodu, String firma_unvan1, String firma_unvan2, String adres1, String adres2, String ulke_adi, String ulke_kodu, String sehir, String ilce, String posta_kodu, String vergi_dairesi, String vergi_no, String telefon, String cari_tipi, String gib_mail,int id) {
        this.firma_kodu = firma_kodu;
        this.firma_unvan1 = firma_unvan1;
        this.firma_unvan2 = firma_unvan2;
        this.adres1 = adres1;
        this.adres2 = adres2;
        this.ulke_adi = ulke_adi;
        this.ulke_kodu = ulke_kodu;
        this.sehir = sehir;
        this.ilce = ilce;
        this.posta_kodu = posta_kodu;
        this.vergi_dairesi = vergi_dairesi;
        this.vergi_no = vergi_no;
        this.telefon = telefon;
        this.cari_tipi = cari_tipi;
        this.gib_mail = gib_mail;
        this.id = id;
    }

    @Override
    public String toString() {
        return "FirmaKarti{" + "id=" + id + ", firma_kodu=" + firma_kodu + ", firma_unvan1=" + firma_unvan1 + ", firma_unvan2=" + firma_unvan2 + ", adres1=" + adres1 + ", adres2=" + adres2 + ", ulke_adi=" + ulke_adi + ", ulke_kodu=" + ulke_kodu + ", sehir=" + sehir + ", ilce=" + ilce + ", posta_kodu=" + posta_kodu + ", vergi_dairesi=" + vergi_dairesi + ", vergi_no=" + vergi_no + ", telefon=" + telefon + ", cari_tipi=" + cari_tipi + ", gib_mail=" + gib_mail + '}';
    }

    public MFirmaKarti() {
    }


    public MFirmaKarti(int id, String firma_kodu, String firma_unvan1, String firma_unvan2, String adres1, String adres2, String ulke_adi, String ulke_kodu, String sehir, String ilce, String posta_kodu, String vergi_dairesi, String vergi_no, String telefon, String cari_tipi, String gib_mail) {
        this.id = id;
        this.firma_kodu = firma_kodu;
        this.firma_unvan1 = firma_unvan1;
        this.firma_unvan2 = firma_unvan2;
        this.adres1 = adres1;
        this.adres2 = adres2;
        this.ulke_adi = ulke_adi;
        this.ulke_kodu = ulke_kodu;
        this.sehir = sehir;
        this.ilce = ilce;
        this.posta_kodu = posta_kodu;
        this.vergi_dairesi = vergi_dairesi;
        this.vergi_no = vergi_no;
        this.telefon = telefon;
        this.cari_tipi = cari_tipi;
        this.gib_mail = gib_mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirma_kodu() {
        return firma_kodu;
    }

    public void setFirma_kodu(String firma_kodu) {
        this.firma_kodu = firma_kodu;
    }

    public String getFirma_unvan1() {
        return firma_unvan1;
    }

    public void setFirma_unvan1(String firma_unvan1) {
        this.firma_unvan1 = firma_unvan1;
    }

    public String getFirma_unvan2() {
        return firma_unvan2;
    }

    public void setFirma_unvan2(String firma_unvan2) {
        this.firma_unvan2 = firma_unvan2;
    }

    public String getAdres1() {
        return adres1;
    }

    public void setAdres1(String adres1) {
        this.adres1 = adres1;
    }

    public String getAdres2() {
        return adres2;
    }

    public void setAdres2(String adres2) {
        this.adres2 = adres2;
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

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getPosta_kodu() {
        return posta_kodu;
    }

    public void setPosta_kodu(String posta_kodu) {
        this.posta_kodu = posta_kodu;
    }

    public String getVergi_dairesi() {
        return vergi_dairesi;
    }

    public void setVergi_dairesi(String vergi_dairesi) {
        this.vergi_dairesi = vergi_dairesi;
    }

    public String getVergi_no() {
        return vergi_no;
    }

    public void setVergi_no(String vergi_no) {
        this.vergi_no = vergi_no;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCari_tipi() {
        return cari_tipi;
    }

    public void setCari_tipi(String cari_tipi) {
        this.cari_tipi = cari_tipi;
    }

    public String getGib_mail() {
        return gib_mail;
    }

    public void setGib_mail(String gib_mail) {
        this.gib_mail = gib_mail;
    }
}
