
package models;

public class MFirmaBilgileri {
    private int id;
    private String firma_kodu;
    private String firma_unvani;
    private String firma_adresi;
    private String genel_bilgi;
    private String firma_logo;
    private String eirs_user_name;
    private String eirs_password;
    private String vergi_no;
    private String web_sitesi;
    private String telefon;

    public MFirmaBilgileri(int id, String firma_kodu, String firma_unvani, String firma_adresi, String genel_bilgi, String firma_logo, String eirs_user_name, String eirs_password, String vergi_no, String web_sitesi, String telefon) {
        this.id = id;
        this.firma_kodu = firma_kodu;
        this.firma_unvani = firma_unvani;
        this.firma_adresi = firma_adresi;
        this.genel_bilgi = genel_bilgi;
        this.firma_logo = firma_logo;
        this.eirs_user_name = eirs_user_name;
        this.eirs_password = eirs_password;
        this.vergi_no = vergi_no;
        this.web_sitesi = web_sitesi;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public String getFirma_kodu() {
        return firma_kodu;
    }

    public String getFirma_unvani() {
        return firma_unvani;
    }

    public String getFirma_adresi() {
        return firma_adresi;
    }

    public String getGenel_bilgi() {
        return genel_bilgi;
    }

    public String getFirma_logo() {
        return firma_logo;
    }

    public String getEirs_user_name() {
        return eirs_user_name;
    }

    public String getEirs_password() {
        return eirs_password;
    }

    public String getVergi_no() {
        return vergi_no;
    }

    public String getWeb_sitesi() {
        return web_sitesi;
    }

    public String getTelefon() {
        return telefon;
    }
}
