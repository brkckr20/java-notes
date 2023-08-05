package methods;

import helpers.DbHelper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import models.MSarfMalzemeDepo;
import utils.SQLDosyasındanOku;

public class Methods {

    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet;
    //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ArrayList<MSarfMalzemeDepo> malzemeDepoListele() throws SQLException, IOException {
        ArrayList<MSarfMalzemeDepo> depoListesi = new ArrayList<>();
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            String query = SQLDosyasındanOku.sorguGetir("SarfMalzemeDepoHavuzSorgusu.sql");
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                depoListesi.add(new MSarfMalzemeDepo(
                        resultSet.getString("malzeme_kodu"),
                        resultSet.getString("malzeme_adi"),
                        resultSet.getInt("kalan_miktar"),
                        resultSet.getString("birim"),
                        resultSet.getString("uuid")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return depoListesi;
    }

    public ArrayList<MSarfMalzemeDepo> malzemeDepoGirisOncekiKayitGetir(int id) throws SQLException, IOException {
        ArrayList<MSarfMalzemeDepo> sonuc = new ArrayList<>();
        try {
            connection = dbHelper.getConnection();
            String query = SQLDosyasındanOku.sorguGetir("SarfMalzemeGirisOncekiKayitGetir.sql");
            preparedStatement = connection.prepareStatement(query); // PreparedStatement oluşturuldu
            preparedStatement.setInt(1, id); // Parametre ayarlandı
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

    public ArrayList<MSarfMalzemeDepo> malzemeDepoGirisSonKayitGetir() throws SQLException, IOException {
        ArrayList<MSarfMalzemeDepo> sonuc = new ArrayList<>();
        try {
            connection = dbHelper.getConnection();
            String query = SQLDosyasındanOku.sorguGetir("SarfMalzemeDepoSonKayitGetir.sql");
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
    
     public ArrayList<MSarfMalzemeDepo> malzemeDepoGirisSonrakiKayitGetir(int id) throws SQLException, IOException {
        ArrayList<MSarfMalzemeDepo> sonuc = new ArrayList<>();
        try {
            connection = dbHelper.getConnection();
            String query = SQLDosyasındanOku.sorguGetir("SarfMalzemeGirisSonrakiKayitGetir.sql");
            preparedStatement = connection.prepareStatement(query); // PreparedStatement oluşturuldu
            preparedStatement.setInt(1, id); // Parametre ayarlandı
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
