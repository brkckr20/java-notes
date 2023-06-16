
public class Car {
    private int enginePower, engine, model;
    int speed;
    protected String color; //sadece bu package ait olmuş oldu
    
    
    Car(){
        this.model = 2020;
        this.enginePower = 300;
        this.speed = 120;
        this.color = "red";
    }
    
    public void print(){
        System.out.println("Model : " + model);
    }
}
