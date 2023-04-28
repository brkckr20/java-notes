package classes.encapsulation;

public class Product {

    // attributes - özellik
    // özellikler varsayılan olarak public olarak gelir
    // private String name; // private olan değerler sadece kapsamındaki blogundan erişilebilir
    private int id;
    private String name;
    private String description;
    private double price;
    private int stokAmount;
    private String kod;

    //getter  yazımı
    public int getId() {
        return this.id;
    }

    //setter yazımı
    public void setId(int id) { // set edilecek değer parametre olarak verilmelidir.
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the stokAmount
     */
    public int getStokAmount() {
        return stokAmount;
    }

    /**
     * @param stokAmount the stokAmount to set
     */
    public void setStokAmount(int stokAmount) {
        this.stokAmount = stokAmount;
    }

    /**
     * @return the kod
     */
    public String getKod() {
        return this.name.substring(0,1) + id;
    }


}
