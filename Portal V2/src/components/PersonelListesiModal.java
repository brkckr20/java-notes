package components;

import helpers.DbHelper;
import interfaces.PersonelKartiYonetimi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.MPersonelKarti;
import utils.GlobalArama;

public class PersonelListesiModal extends javax.swing.JDialog {

    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    Statement statement = null;
    ResultSet resultSet;
    DefaultTableModel model = null;
    
    private PersonelKartiYonetimi selectionListener;
    
        public void setSelectionListener(PersonelKartiYonetimi listener) {
        this.selectionListener = listener;
    }

    public PersonelListesiModal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        kartlariTabloyaYansit();
    }

    public ArrayList<MPersonelKarti> personelListele() throws SQLException {
        ArrayList<MPersonelKarti> personelListesi = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM personel_karti");
            personelListesi = new ArrayList<MPersonelKarti>();
            while (resultSet.next()) {
                personelListesi.add(new MPersonelKarti(
                        resultSet.getString("ad_soyad"),
                        resultSet.getString("departman")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return personelListesi;
    }

    public void kartlariTabloyaYansit() {
        model = (DefaultTableModel) tblPersonelListesi.getModel();
        model.setRowCount(0);
        try {
            ArrayList<MPersonelKarti> personelListesi = personelListele();
            for (MPersonelKarti liste : personelListesi) {
                Object[] row = {
                    liste.getAd_soyad(),
                    liste.getDepartman()
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonelListesi = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtPersonelAra = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Personel Listesi");

        tblPersonelListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Adı Soyadı", "Departmanı"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPersonelListesi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPersonelListesiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPersonelListesi);

        jLabel1.setText("Arama İfadesi :");

        txtPersonelAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPersonelAraKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPersonelAra)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPersonelAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPersonelAraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonelAraKeyReleased
        GlobalArama.ara(txtPersonelAra, model, tblPersonelListesi);
    }//GEN-LAST:event_txtPersonelAraKeyReleased

    private void tblPersonelListesiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonelListesiMouseClicked
       if (evt.getClickCount() == 2) {
            int row = tblPersonelListesi.getSelectedRow();
            String ad_soyad = tblPersonelListesi.getValueAt(row, 0).toString();
            String departman = tblPersonelListesi.getValueAt(row, 1).toString();
            if (selectionListener != null) {
                selectionListener.onPersonelSelected(ad_soyad, departman);
            }
            this.dispose();
        }
    }//GEN-LAST:event_tblPersonelListesiMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PersonelListesiModal dialog = new PersonelListesiModal(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPersonelListesi;
    private javax.swing.JTextField txtPersonelAra;
    // End of variables declaration//GEN-END:variables
}
