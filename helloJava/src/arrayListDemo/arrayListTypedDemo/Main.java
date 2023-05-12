/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayListDemo.arrayListTypedDemo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author BILGIISLEM
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<String> sehirler = new ArrayList<>();
        sehirler.add("Denizli");
        sehirler.add("Konya");
        sehirler.add("Antalya");
        sehirler.add("Rize");
        sehirler.add("Aydın");
        sehirler.remove("Denizli"); // döngüye girmeden önce sildik
        Collections.sort(sehirler);
        for (String sehir : sehirler) {
            System.out.println("Sehir : " + sehir);
        }
    }
}
