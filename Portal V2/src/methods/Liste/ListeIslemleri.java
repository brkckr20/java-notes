package methods.Liste;

import helpers.DbHelper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.MSarfMalzemeDepo;
import utils.SQLDosyasındanOku;

public class ListeIslemleri {

    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet;

    public ArrayList<MSarfMalzemeDepo> malzemeDepoGirisListe() throws SQLException, IOException {
        ArrayList<MSarfMalzemeDepo> sonuc = new ArrayList<>();
        try {
            connection = dbHelper.getConnection();
            String query = SQLDosyasındanOku.sorguGetir("SarfMalzemeDepoGirisListe.sql");
            preparedStatement = connection.prepareStatement(query); // PreparedStatement oluşturuldu
            resultSet = preparedStatement.executeQuery(); // Sorgu çalıştırıldı
            while (resultSet.next()) {
                sonuc.add(new MSarfMalzemeDepo(
                        resultSet.getInt("id"),
                        resultSet.getString("malzeme_kodu"),
                        resultSet.getString("malzeme_adi"),
                        resultSet.getInt("miktar"),
                        resultSet.getString("birim"),
                        resultSet.getString("uuid"),
                        resultSet.getDate("tarih"), // tarih değeri getDate() ile alınır
                        resultSet.getString("firma_kodu"),
                        resultSet.getString("firma_unvan"), // firma_unvan String olarak alınır
                        resultSet.getString("fatura_no"),
                        resultSet.getString("kalem_islem")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return sonuc;
    }
}
