package models;

public class MDepoKodlama {

    private int id;
    private String depoAdi;

    public MDepoKodlama(int id, String depoAdi) {
        this.id = id;
        this.depoAdi = depoAdi;
    }

    public int getId() {
        return id;
    }

    public String getDepoAdi() {
        return depoAdi;
    }

}
