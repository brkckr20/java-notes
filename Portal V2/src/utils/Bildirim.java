package utils;

import javax.swing.JOptionPane;

public abstract class Bildirim {

    public static void basarili(String mesaj) {
        String[] options = {"Tamam"};
        JOptionPane.showOptionDialog(null, mesaj, "Bilgi", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }

    public static int onayAl() {
        Object[] options = {"Evet", "İptal Et"};
        int confirmResult = JOptionPane.showOptionDialog(
                null,
                "Seçili kaydı silmek istediğinizden emin misiniz?",
                "Silme Onayı",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);
        return confirmResult;
    }

}
