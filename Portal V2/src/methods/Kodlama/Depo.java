package methods.Kodlama;

import helpers.DbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.MDepoKodlama;
import utils.Bildirim;

public class Depo {

    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    DefaultTableModel modelTabloDepoListesi;

    public void depoKaydet(int id, JTextField txt) {
        if (id == 0) {
            if (txt.getText().isEmpty()) {
                Bildirim.uyari("Depo adı alanı boş geçilemez!");
            } else {
                try {
                    connection = dbHelper.getConnection();
                    String sql = "INSERT INTO depo_kodlama (ad) values (?)";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, txt.getText());
                    preparedStatement.executeUpdate();
                    Bildirim.basarili("Kayıt işlemi başarılı!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                connection = dbHelper.getConnection();
                String sql = "UPDATE depo_kodlama SET ad = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, txt.getText());
                preparedStatement.setInt(2, id);
                preparedStatement.executeUpdate();
                Bildirim.basarili(id + " numaralı kaydın güncelleme işlemi başarılı!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<MDepoKodlama> depoListele() throws SQLException {
        ArrayList<MDepoKodlama> depolar = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM depo_kodlama");
            depolar = new ArrayList<MDepoKodlama>();
            while (resultSet.next()) {
                depolar.add(new MDepoKodlama(
                        resultSet.getInt("id"),
                        resultSet.getString("ad")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return depolar;
    }

    public void depolariTabloyaYansit(JTable tablo) {
        modelTabloDepoListesi = (DefaultTableModel) tablo.getModel();
        modelTabloDepoListesi.setRowCount(0);
        try {
            ArrayList<MDepoKodlama> depoListesi = depoListele();
            for (MDepoKodlama liste : depoListesi) {
                Object[] row = {
                    liste.getId(),
                    liste.getDepoAdi()
                };
                modelTabloDepoListesi.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    public void depoKodlamaSil(int id) {
        int onayDurumu = Bildirim.onayAl();
        if (onayDurumu == JOptionPane.YES_OPTION) {
            try {
                connection = dbHelper.getConnection();
                String sqlDelete = "DELETE FROM depo_kodlama WHERE id = ?";
                preparedStatement = connection.prepareStatement(sqlDelete);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                Bildirim.basarili("Firma kartı silme işlemi başarıyla gerçekleştirildi...");
            } catch (SQLException ex) {
                System.out.println("ex :" + ex.getMessage());
                ex.printStackTrace();
            }

        } else {
            System.out.println("silme işlemi başarısız");
        }
    }
}
