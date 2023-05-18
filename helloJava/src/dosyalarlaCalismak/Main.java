package dosyalarlaCalismak;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        readFile();
        writeFile();
        readFile();
    }

    public static void createFile() {
        File file = new File("C:\\Users\\BILGIISLEM\\Desktop\\New Folder\\udemy\\helloJava\\src\\files\\students.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Dosya oluşturuldu");
            } else {
                System.out.println("Dosya zaten mevcuttur..");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getFileInfo() {
        File file = new File("C:\\Users\\BILGIISLEM\\Desktop\\New Folder\\udemy\\helloJava\\src\\files\\students.txt");
        if (file.exists()) {
            System.out.println("Dosya adı : " + file.getName());
            System.out.println("Dosya yolu : " + file.getAbsolutePath());
            System.out.println("Dosya okunabilir mi : " + file.canWrite());
            System.out.println("Dosya yazilabilir mi : " + file.canRead());
            System.out.println("Dosya boyutu : " + file.length()); // byte cinsinden gösterir
        }
    }

    public static void readFile() {
        File file = new File("C:\\Users\\BILGIISLEM\\Desktop\\New Folder\\udemy\\helloJava\\src\\files\\students.txt");
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) { // okunacak satir varsa / dosya içeriği satır satır okunur.
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close(); // okuma islemi bitince kapat
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void writeFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\BILGIISLEM\\Desktop\\New Folder\\udemy\\helloJava\\src\\files\\students.txt", true)); // true eklemezsek hepsini siler ve üzerine yazar
            writer.newLine(); // yeni satır ekler ve sonra yazar
            writer.write("Ahmet");
            System.out.println("Dosyaya yazıldı");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
