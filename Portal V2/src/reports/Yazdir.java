package reports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Yazdir {

    Connection con;
    PreparedStatement pst;

    public Yazdir(JTextField txtKayitNumarasi) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/portal2023", "root", "");
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\BILGIISLEM\\Desktop\\Klasörler\\New Folder\\udemy\\Portal V2\\src\\reports\\newReports.jrxml");
            String sql = "SELECT portal2023.sarf_malzeme_depo1.id,\n"
                    + "	portal2023.sarf_malzeme_depo1.islem_cinsi,\n"
                    + "	portal2023.sarf_malzeme_depo1.tarih,\n"
                    + "	portal2023.sarf_malzeme_depo1.firma_kodu,\n"
                    + "	portal2023.sarf_malzeme_depo1.firma_unvan,\n"
                    + "	portal2023.sarf_malzeme_depo1.fatura_no,\n"
                    + "	portal2023.sarf_malzeme_depo2.id,\n"
                    + "	portal2023.sarf_malzeme_depo2.kalem_islem,\n"
                    + "	portal2023.sarf_malzeme_depo2.malzeme_kodu,\n"
                    + "	portal2023.sarf_malzeme_depo2.malzeme_adi,\n"
                    + "	portal2023.sarf_malzeme_depo2.miktar,\n"
                    + "	portal2023.sarf_malzeme_depo2.not1,\n"
                    + "	portal2023.sarf_malzeme_depo2.not2,\n"
                    + "	portal2023.sarf_malzeme_depo2.birim,\n"
                    + "	portal2023.sarf_malzeme_depo2.cikilan_birim,\n"
                    + "	portal2023.sarf_malzeme_depo2.teslim_alan,\n"
                    + "	portal2023.sarf_malzeme_depo2.uuid,\n"
                    + "	portal2023.sarf_malzeme_depo2.`refNoId`,\n"
                    + "	portal2023.sarf_malzeme_depo2.aciklama,\n"
                    + "	portal2023.sarf_malzeme_depo2.fiyat\n"
                    + "FROM portal2023.sarf_malzeme_depo2\n"
                    + "	INNER JOIN portal2023.sarf_malzeme_depo1 ON \n"
                    + "	 portal2023.sarf_malzeme_depo1.id = portal2023.sarf_malzeme_depo2.`refNoId` \n"
                    + "WHERE \n"
                    + "	 portal2023.sarf_malzeme_depo1.id =" + txtKayitNumarasi.getText();
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(sql);
            jdesign.setQuery(updateQuery);
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
            JasperViewer.viewReport(jprint);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SMCikisServisRaporu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SMCikisServisRaporu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(SMCikisServisRaporu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
