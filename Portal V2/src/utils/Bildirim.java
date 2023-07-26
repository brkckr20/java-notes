package utils;

import javax.swing.JOptionPane;

public abstract class Bildirim {

    public static void basarili(String mesaj) {
        String[] options = {"Tamam"};
        JOptionPane.showOptionDialog(null, mesaj, "Bilgi", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }

}
