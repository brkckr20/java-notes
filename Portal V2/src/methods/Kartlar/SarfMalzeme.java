package methods.Kartlar;

import helpers.DbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.MMalzemeKarti;
import utils.Bildirim;

public class SarfMalzeme {

    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet;
    Statement statement = null;
    DefaultTableModel modelMalzemeKartiListesi;

    public ArrayList<MMalzemeKarti> malzemeKartiListele() throws SQLException {
        ArrayList<MMalzemeKarti> malzemeKartiListesi = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM malzeme_kodlama");
            malzemeKartiListesi = new ArrayList<MMalzemeKarti>();
            while (resultSet.next()) {
                malzemeKartiListesi.add(new MMalzemeKarti(
                        resultSet.getInt("id"),
                        resultSet.getString("malzeme_kodu"),
                        resultSet.getString("malzeme_adi"),
                        resultSet.getString("depo_adi"),
                        resultSet.getString("birim"),
                        resultSet.getString("malzeme_marka")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return malzemeKartiListesi;
    }

    public void malzemeKartlariniTabloyaYansit(JTable tabloAdi) {
        modelMalzemeKartiListesi = (DefaultTableModel) tabloAdi.getModel();
        modelMalzemeKartiListesi.setRowCount(0);
        try {
            ArrayList<MMalzemeKarti> malzemeKartiListesi = malzemeKartiListele();
            for (MMalzemeKarti liste : malzemeKartiListesi) {
                Object[] row = {
                    liste.getId(),
                    liste.getMalzeme_kodu(),
                    liste.getMalzeme_adi(),
                    liste.getDepo_adi(),
                    liste.getBirim(),
                    liste.getMalzeme_marka()
                };
                modelMalzemeKartiListesi.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    public void malzemeKartiSil(int id) throws SQLException {
        int onayDurumu = Bildirim.onayAl();
        if (onayDurumu == JOptionPane.YES_OPTION) {
            connection = dbHelper.getConnection();
            String sqlDelete = "DELETE FROM malzeme_kodlama WHERE id=?";
            preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            Bildirim.basarili("Malzeme kartı silme işlemi başarıyla gerçekleştirildi...");
        }else {
            System.out.println("silme işlemi başarısız");
        }
    }

}
