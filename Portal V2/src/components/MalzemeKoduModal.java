package components;

import helpers.DbHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.MMalzemeKarti;
import interfaces.MalzemeKartiYonetimi;

public class MalzemeKoduModal extends javax.swing.JDialog {

    DefaultTableModel model;
    private MalzemeKartiYonetimi selectionListener;
    
    
    public void setSelectionListener(MalzemeKartiYonetimi listener) {
        this.selectionListener = listener;
    }

    public MalzemeKoduModal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        kartlariTabloyaYansit();
    }

    public ArrayList<MMalzemeKarti> malzemeKoduListele() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<MMalzemeKarti> kartListesi = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM malzeme_kodlama");
            kartListesi = new ArrayList<MMalzemeKarti>();
            while (resultSet.next()) {
                kartListesi.add(new MMalzemeKarti(
                        resultSet.getString("malzeme_kodu"),
                        resultSet.getString("malzeme_adi"),
                        resultSet.getString("birim")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return kartListesi;
    }

    public void kartlariTabloyaYansit() {
        model = (DefaultTableModel) tblMalzemeKoduListesi.getModel();
        model.setRowCount(0);
        try {
            ArrayList<MMalzemeKarti> malzemeLitesi = malzemeKoduListele();
            for (MMalzemeKarti liste : malzemeLitesi) {
                Object[] row = {
                    liste.getMalzeme_kodu(),
                    liste.getMalzeme_adi(),
                    liste.getBirim()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAramaIfadesi = new javax.swing.JLabel();
        txtMalzemeKoduSearch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMalzemeKoduListesi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblAramaIfadesi.setText("Arama İfadesi :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblAramaIfadesi, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMalzemeKoduSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblAramaIfadesi, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addComponent(txtMalzemeKoduSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblMalzemeKoduListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Malzeme Kodu", "Malzeme Adı", "Birim"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMalzemeKoduListesi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMalzemeKoduListesiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMalzemeKoduListesi);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblMalzemeKoduListesiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMalzemeKoduListesiMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblMalzemeKoduListesi.getSelectedRow();
            String malzeme_kodu = tblMalzemeKoduListesi.getValueAt(row, 0).toString();
            String malzeme_adi = tblMalzemeKoduListesi.getValueAt(row, 1).toString();
            if (selectionListener != null) {
                selectionListener.onMalzemeSelected(malzeme_kodu, malzeme_adi);
            }

            this.dispose();
        }
    }//GEN-LAST:event_tblMalzemeKoduListesiMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MalzemeKoduModal dialog = new MalzemeKoduModal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAramaIfadesi;
    private javax.swing.JTable tblMalzemeKoduListesi;
    private javax.swing.JTextField txtMalzemeKoduSearch;
    // End of variables declaration//GEN-END:variables
}
