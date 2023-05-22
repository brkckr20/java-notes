package JDBC_database_intro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            String sql = "DELETE FROM birim where id = ?"; // soru işaretlerinin sırası önemlidir
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 46);
            int result = statement.executeUpdate(); // etkilenen kayıt sayısını getirir.
            System.out.println("Kayit silindi ve etkilenen satır sayısı : " + result);
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public static void selectDemo() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {

            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT ad,kisa_kod FROM birim");
            ArrayList<Birim> birimler = new ArrayList<Birim>();
            while (resultSet.next()) {
                birimler.add(new Birim(
                        resultSet.getString("ad"),
                        resultSet.getString("kisa_kod"),
                        resultSet.getString("depo")
                ));
            }

            System.out.println(birimler.size());
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        } finally {
            connection.close();
        }
    }

    public static void insertData() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            String sql = "INSERT INTO birim (ad,kisa_kod,depo) values (?,?,?)";
            statement = connection.prepareStatement(sql);
            //soru işaretlerinin sırasına göre
            statement.setString(1, "dene");
            statement.setString(2, "dene1");
            statement.setString(3, "dene2");
            int result = statement.executeUpdate(); // etkilenen kayıt sayısını getirir.
            System.out.println("Kayit eklendi ve etkilenen satır sayısı : " + result);
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public void updateData() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            String sql = "UPDATE birim SET depo='',kisa_kod='xyz' where id = ?"; // soru işaretlerinin sırası önemlidir
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 45);
            int result = statement.executeUpdate(); // etkilenen kayıt sayısını getirir.
            System.out.println("Kayit guncellendi ve etkilenen satır sayısı : " + result);
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        } finally {
            statement.close();
            connection.close();
        }
    }
}
