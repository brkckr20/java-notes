package miniProjects;

public class sayiBulma {

    public static void main(String[] args) {
        int[] sayilar = new int[]{1, 2, 3, 11, 23, 44, 2};
        int aranacak = 11;
        boolean varmi = false;
        for (int sayi : sayilar) {
            if (sayi == aranacak) {
                varmi = true;
                break;
            }
        }
        if (varmi) {
            System.out.println("Sayi var...");
        }else{
            System.out.println("Sayi yok...");
        }

    }
}
