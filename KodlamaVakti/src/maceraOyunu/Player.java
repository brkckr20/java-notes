package maceraOyunu;

public class Player {

    private int damage, healthy, money;
    private String name,cName;
    private Inventory inv;
    
    public int getDamage() {
        return damage;
    }
    
    public void selectChar(){
        charMenu();
    }
    
    public void charMenu() {
        System.out.println("Lütfen bir karakter seçiniz... : ");
        System.out.println("Türü : Samuray, Hasar : 5, Sağlık 21, Para 15");
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }
    
    public Player(String name) {
        this.name = name;
    }

    
}
