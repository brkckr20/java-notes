
public class StaticKullanimi {
    /*
     
     Static => class ı new lemeden metotlarına erişebilmek için
     
     */

    public static void main(String[] args) {
        System.out.println("Online Öğrenci : " + Student.howStudent());
        Student s1 = new Student("Ali", 1, 90);
        Student s2 = new Student("Ayşe", 2, 100);
        Student s3 = new Student("Mehmet", 3, 60);
        System.out.println("Online Öğrenci : " + Student.howStudent());
        s1.exit();
        System.out.println("Online Öğrenci : " + Student.howStudent());
        
        int[] notlar = new int[4];
        notlar[0] = s1.point;
        notlar[1] = s2.point;
        notlar[2] = s3.point;
        
        System.out.println(Student.calculateOverall(notlar));
        System.out.println(Math.abs(-12));
        
    }
}
