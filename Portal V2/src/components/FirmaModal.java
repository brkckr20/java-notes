package components;

import helpers.DbHelper;
import interfaces.FirmaKartiYonetimi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.MFirmaKarti;
import utils.GlobalArama;

public class FirmaModal extends javax.swing.JDialog {

    DefaultTableModel model;
    private FirmaKartiYonetimi selectionListener;
    
    public void setSelectionListener(FirmaKartiYonetimi listener) {
        this.selectionListener = listener;
    }

    public FirmaModal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ulkeleriTabloyaYansit();
    }

    public ArrayList<MFirmaKarti> firmaListele() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<MFirmaKarti> firmalar = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id,firma_kodu,firma_unvan1 FROM firma_karti");
            firmalar = new ArrayList<MFirmaKarti>();
            while (resultSet.next()) {
                firmalar.add(new MFirmaKarti(
                        resultSet.getInt("id"),
                        resultSet.getString("firma_kodu"),
                        resultSet.getString("firma_unvan1")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return firmalar;
    }

    public void ulkeleriTabloyaYansit() {
        model = (DefaultTableModel) tblFirmaListesiModal.getModel();
        model.setRowCount(0);
        try {
            ArrayList<MFirmaKarti> firmaListesi = firmaListele();
            for (MFirmaKarti liste : firmaListesi) {
                Object[] row = {
                    liste.getId(),
                    liste.getFirma_kodu(),
                    liste.getFirma_unvan1()
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
        txtAramaIfadesi = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFirmaListesiModal = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblAramaIfadesi.setText("Arama İfadesi :");

        txtAramaIfadesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAramaIfadesiKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAramaIfadesi, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAramaIfadesi)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAramaIfadesi)
                    .addComponent(txtAramaIfadesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tblFirmaListesiModal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kayıt No", "Firma Kodu", "Firma Unvan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        tblFirmaListesiModal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFirmaListesiModalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFirmaListesiModal);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblFirmaListesiModalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFirmaListesiModalMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblFirmaListesiModal.getSelectedRow();
            String firma_kodu = tblFirmaListesiModal.getValueAt(row, 1).toString();
            String firma_unvan = tblFirmaListesiModal.getValueAt(row, 2).toString();
            if (selectionListener != null) {
                selectionListener.onFirmaSelected(firma_kodu, firma_unvan);
            }

            this.dispose();
        }
    }//GEN-LAST:event_tblFirmaListesiModalMouseClicked

    private void txtAramaIfadesiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAramaIfadesiKeyReleased
        GlobalArama.ara(txtAramaIfadesi, model, tblFirmaListesiModal);
    }//GEN-LAST:event_txtAramaIfadesiKeyReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FirmaModal dialog = new FirmaModal(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblFirmaListesiModal;
    private javax.swing.JTextField txtAramaIfadesi;
    // End of variables declaration//GEN-END:variables
}
