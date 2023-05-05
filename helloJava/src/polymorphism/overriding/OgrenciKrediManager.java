package polymorphism.overriding;

public class OgrenciKrediManager extends BaseKrediManager {
    // overriding ile basekredimanagerin hesapla metodu ezildi

    /**
     *
     * @param tutar
     * @return
     */
    
    @Override
    public double hesapla(double tutar) {
        return tutar * 1.10;

    }
}
