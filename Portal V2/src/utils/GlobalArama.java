package utils;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public abstract class GlobalArama {
    private static TableRowSorter<DefaultTableModel> tableRowSorter; // TableRowSorter'ı burada tanımlayın

    public static void ara(JTextField aramaYapilacakTextbox, DefaultTableModel model, JTable tablo) {
        String aramaIfadesi = aramaYapilacakTextbox.getText();
        model = (DefaultTableModel) tablo.getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(model);
        tablo.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + aramaIfadesi));
    }
}
