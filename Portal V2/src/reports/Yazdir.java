
package reports;

import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class Yazdir {
    public Yazdir(int d1id,Connection connection){
        
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("d1id", d1id);
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream("/reports/newReports_1.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,connection);
            JasperViewer.viewReport(jasperPrint,true);
        } catch (JRException ex) {
            Logger.getLogger(Yazdir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
