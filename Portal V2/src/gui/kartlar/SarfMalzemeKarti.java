package gui.kartlar;

import helpers.DbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import methods.Kartlar.SarfMalzeme;
import utils.Bildirim;
import utils.GlobalArama;

public class SarfMalzemeKarti extends javax.swing.JInternalFrame {

    SarfMalzeme sarfMalzemeMethods = new SarfMalzeme();
    int secilenSatirId = 0;

    public SarfMalzemeKarti() {
        initComponents();

        /*borderleri kaldırma*/
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        sarfMalzemeMethods.malzemeKartlariniTabloyaYansit(tblSarfMalzemeKartiListesi);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlButtonGroup = new javax.swing.JPanel();
        btnKaydetMalzemeKarti = new javax.swing.JButton();
        btnYeniMalzemeKarti = new javax.swing.JButton();
        btnSilMalzemeKarti = new javax.swing.JButton();
        pnlForm = new javax.swing.JPanel();
        lblMalzemeKodu = new javax.swing.JLabel();
        txtMalzemeKodu = new javax.swing.JTextField();
        txtMalzemeAdi = new javax.swing.JTextField();
        lblMalzemeAdi = new javax.swing.JLabel();
        lblMarka = new javax.swing.JLabel();
        txtMalzemeMarka = new javax.swing.JTextField();
        lblBirim = new javax.swing.JLabel();
        cmbBirim = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtDepoAdi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSarfMalzemeKartiListesi = new javax.swing.JTable();
        lblAramaIfadesi = new javax.swing.JLabel();
        txtAramaIfadesi = new javax.swing.JTextField();

        btnKaydetMalzemeKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/save.png"))); // NOI18N
        btnKaydetMalzemeKarti.setText("Kaydet");
        btnKaydetMalzemeKarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetMalzemeKartiActionPerformed(evt);
            }
        });

        btnYeniMalzemeKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/plus.png"))); // NOI18N
        btnYeniMalzemeKarti.setText("Yeni");
        btnYeniMalzemeKarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYeniMalzemeKartiActionPerformed(evt);
            }
        });

        btnSilMalzemeKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Delete.png"))); // NOI18N
        btnSilMalzemeKarti.setText("Sil");
        btnSilMalzemeKarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilMalzemeKartiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonGroupLayout = new javax.swing.GroupLayout(pnlButtonGroup);
        pnlButtonGroup.setLayout(pnlButtonGroupLayout);
        pnlButtonGroupLayout.setHorizontalGroup(
            pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonGroupLayout.createSequentialGroup()
                .addComponent(btnYeniMalzemeKarti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKaydetMalzemeKarti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSilMalzemeKarti)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlButtonGroupLayout.setVerticalGroup(
            pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnKaydetMalzemeKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnYeniMalzemeKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSilMalzemeKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblMalzemeKodu.setText("Kod :");

        lblMalzemeAdi.setText("Malzeme Adı :");

        lblMarka.setText("Marka :");

        lblBirim.setText("Birim :");

        cmbBirim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adet", "Set", "Metre", "Kilogram", "Santimetre" }));

        jLabel2.setText("Depo Adı :");

        tblSarfMalzemeKartiListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kayıt No", "Malzeme Kodu", "Malzeme Adı", "Depo Adı", "Birim", "Malzeme Marka"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSarfMalzemeKartiListesi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSarfMalzemeKartiListesiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSarfMalzemeKartiListesi);

        lblAramaIfadesi.setText("Arama İfadesi :");

        txtAramaIfadesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAramaIfadesiKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblAramaIfadesi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMalzemeKodu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMalzemeAdi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(lblMarka, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBirim, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormLayout.createSequentialGroup()
                                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDepoAdi)
                                    .addComponent(cmbBirim, 0, 150, Short.MAX_VALUE)
                                    .addComponent(txtMalzemeMarka)
                                    .addComponent(txtMalzemeAdi)
                                    .addComponent(txtMalzemeKodu))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtAramaIfadesi))))
                .addContainerGap())
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMalzemeKodu)
                    .addComponent(txtMalzemeKodu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMalzemeAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMalzemeAdi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMalzemeMarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarka))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBirim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDepoAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAramaIfadesi)
                    .addComponent(txtAramaIfadesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlButtonGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlButtonGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetMalzemeKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetMalzemeKartiActionPerformed
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        if (secilenSatirId == 0) {
            try {
                connection = dbHelper.getConnection();
                String sql = "INSERT INTO malzeme_kodlama (malzeme_kodu,malzeme_adi,depo_adi,birim,malzeme_marka) values (?,?,?,?,?)";
                statement = connection.prepareStatement(sql);
                statement.setString(1, txtMalzemeKodu.getText());
                statement.setString(2, txtMalzemeAdi.getText());
                statement.setString(3, (String) txtDepoAdi.getText());
                statement.setString(4, (String) cmbBirim.getSelectedItem());
                statement.setString(5, txtMalzemeMarka.getText());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Kayıt işlemi başarılı!");
                sarfMalzemeMethods.malzemeKartlariniTabloyaYansit(tblSarfMalzemeKartiListesi);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            try {
                connection = dbHelper.getConnection();
                String sql = "UPDATE malzeme_kodlama SET malzeme_kodu = ?, malzeme_adi = ?, depo_adi = ?, birim=?, malzeme_marka=? WHERE id = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, txtMalzemeKodu.getText());
                statement.setString(2, txtMalzemeAdi.getText());
                statement.setString(3, (String) txtDepoAdi.getText());
                statement.setString(4, (String) cmbBirim.getSelectedItem());
                statement.setString(5, txtMalzemeMarka.getText());
                statement.setInt(6, secilenSatirId);
                statement.executeUpdate();
                Bildirim.basarili("Malzeme güncelleme işlemi başarıyla tamamlandı..");
                sarfMalzemeMethods.malzemeKartlariniTabloyaYansit(tblSarfMalzemeKartiListesi);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnKaydetMalzemeKartiActionPerformed

    private void txtAramaIfadesiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAramaIfadesiKeyReleased
        GlobalArama.ara(txtAramaIfadesi, null, tblSarfMalzemeKartiListesi);
    }//GEN-LAST:event_txtAramaIfadesiKeyReleased

    private void tblSarfMalzemeKartiListesiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSarfMalzemeKartiListesiMouseClicked
        int selectedRow = tblSarfMalzemeKartiListesi.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tblSarfMalzemeKartiListesi.getValueAt(selectedRow, 0);
            secilenSatirId = id;
            String malzemeKodu = (String) tblSarfMalzemeKartiListesi.getValueAt(selectedRow, 1);
            String malzemeAdi = (String) tblSarfMalzemeKartiListesi.getValueAt(selectedRow, 2);
            String depoAdi = (String) tblSarfMalzemeKartiListesi.getValueAt(selectedRow, 3);
            String birim = (String) tblSarfMalzemeKartiListesi.getValueAt(selectedRow, 4);
            String malzemeMarka = (String) tblSarfMalzemeKartiListesi.getValueAt(selectedRow, 5);

            txtMalzemeAdi.setText(malzemeAdi);
            txtMalzemeKodu.setText(malzemeKodu);
            cmbBirim.setSelectedItem(birim);
            txtMalzemeMarka.setText(malzemeMarka);
            txtDepoAdi.setText(depoAdi);
        }
    }//GEN-LAST:event_tblSarfMalzemeKartiListesiMouseClicked

    private void btnYeniMalzemeKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniMalzemeKartiActionPerformed
        formAlanlariniTemizle();
    }//GEN-LAST:event_btnYeniMalzemeKartiActionPerformed

    public void formAlanlariniTemizle() {
        secilenSatirId = 0;
        txtMalzemeKodu.setText("");
        txtMalzemeAdi.setText("");
        txtDepoAdi.setText("");
        cmbBirim.setSelectedIndex(0);
        txtMalzemeMarka.setText("");
    }

    private void btnSilMalzemeKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilMalzemeKartiActionPerformed
        try {
            sarfMalzemeMethods.malzemeKartiSil(secilenSatirId);
            sarfMalzemeMethods.malzemeKartlariniTabloyaYansit(tblSarfMalzemeKartiListesi);
            formAlanlariniTemizle();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnSilMalzemeKartiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydetMalzemeKarti;
    private javax.swing.JButton btnSilMalzemeKarti;
    private javax.swing.JButton btnYeniMalzemeKarti;
    private javax.swing.JComboBox cmbBirim;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAramaIfadesi;
    private javax.swing.JLabel lblBirim;
    private javax.swing.JLabel lblMalzemeAdi;
    private javax.swing.JLabel lblMalzemeKodu;
    private javax.swing.JLabel lblMarka;
    private javax.swing.JPanel pnlButtonGroup;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JTable tblSarfMalzemeKartiListesi;
    private javax.swing.JTextField txtAramaIfadesi;
    private javax.swing.JTextField txtDepoAdi;
    private javax.swing.JTextField txtMalzemeAdi;
    private javax.swing.JTextField txtMalzemeKodu;
    private javax.swing.JTextField txtMalzemeMarka;
    // End of variables declaration//GEN-END:variables
}
