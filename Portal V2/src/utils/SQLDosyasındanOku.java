package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class SQLDosyasındanOku {

    public static String sorguGetir(String dosyaYolu) throws FileNotFoundException, IOException {
        String dosyaAdi = "C:\\Users\\BILGIISLEM\\Desktop\\Klasörler\\New Folder\\udemy\\Portal V2\\src\\queries\\"+dosyaYolu;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(dosyaAdi));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        br.close();
        String query = sb.toString();
        return query;
    }
}