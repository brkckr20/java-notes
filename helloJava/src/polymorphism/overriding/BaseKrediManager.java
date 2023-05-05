package polymorphism.overriding;

public class BaseKrediManager {

    public double hesapla(double tutar) {
        return tutar * 1.18;
    }
}
    //overridable




//override edilebilir olmasını engellemek için publicden sonra final keywordu yazılır 
/*
    public final double hesapla(double tutar) {
        return tutar * 1.18;
    }
*/
