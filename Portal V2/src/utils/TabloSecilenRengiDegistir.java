
package utils;

import java.awt.Color;
import javax.swing.JTable;

public abstract class TabloSecilenRengiDegistir {
    public static void degistir(JTable table){
        table.setSelectionBackground(Color.decode("#ff9f43"));
    }
}
