package interfaces;

public class MySqlCustomerDal implements ICustomerDal, IRepository { //classlar birden fazla interface'i impelement edebilir.

    @Override
    public void Add() {
        System.out.println("MySql eklendi...");
    }

    @Override
    public void Remove() {
        System.out.println("Ireporsitory'den eklendi");
    }

}
