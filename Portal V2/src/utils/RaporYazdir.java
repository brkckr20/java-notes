package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RaporYazdir {

    Connection con;
    PreparedStatement pst;

    public void GuvenHizmetRaporu() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal2023", "root", "");
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\BILGIISLEM\\Desktop\\Klasörler\\New Folder\\udemy\\Portal V2\\src\\reports\\GuvenBilgisayar.jrxml");
            String sql = "SELECT DATE_FORMAT(portal2023.sarf_malzeme_depo1.tarih, '%d.%m.%Y') tarih,\n"
                    + "	portal2023.sarf_malzeme_depo2.malzeme_adi,\n"
                    + "	portal2023.sarf_malzeme_depo2.miktar,\n"
                    + "	portal2023.sarf_malzeme_depo2.birim,\n"
                    + "	portal2023.sarf_malzeme_depo2.aciklama\n"
                    + "FROM portal2023.sarf_malzeme_depo2\n"
                    + "	INNER JOIN portal2023.sarf_malzeme_depo1 ON \n"
                    + "	 portal2023.sarf_malzeme_depo1.id = portal2023.sarf_malzeme_depo2.`refNoId` WHERE portal2023.sarf_malzeme_depo1.firma_kodu = '320-01-12-025' and\n"
                    + "	 portal2023.sarf_malzeme_depo1.islem_cinsi = 'SARF_MALZEME_GIRIS'";
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(sql);
            jdesign.setQuery(updateQuery);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
            // JasperPrint jprint = JasperFillManager.fillReport(jreport, null, new JREmptyDataSource());

            JasperViewer.viewReport(jprint);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
}
