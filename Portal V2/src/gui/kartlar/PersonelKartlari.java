package gui.kartlar;

import helpers.DbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import models.MPersonelKarti;
import utils.Bildirim;
import utils.GlobalArama;

public class PersonelKartlari extends javax.swing.JInternalFrame {

    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet;
    DefaultTableModel model;
    private int secilenId = 0;
    

    public PersonelKartlari() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        personelleriTabloyaYansit();
        silBtnToggle();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlIslemler = new javax.swing.JPanel();
        pnlButtonGroup2 = new javax.swing.JPanel();
        btnKaydetPersonelKarti = new javax.swing.JButton();
        btnYeniMalzemeKarti = new javax.swing.JButton();
        btnSilPersonelKarti = new javax.swing.JButton();
        pnlGovde = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtAdSoyad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDepartman = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonelListesi = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPersonelAra = new javax.swing.JTextField();

        btnKaydetPersonelKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/save.png"))); // NOI18N
        btnKaydetPersonelKarti.setText("Kaydet");
        btnKaydetPersonelKarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetPersonelKartiActionPerformed(evt);
            }
        });

        btnYeniMalzemeKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/plus.png"))); // NOI18N
        btnYeniMalzemeKarti.setText("Yeni");
        btnYeniMalzemeKarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYeniMalzemeKartiActionPerformed(evt);
            }
        });

        btnSilPersonelKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Delete.png"))); // NOI18N
        btnSilPersonelKarti.setText("Sil");
        btnSilPersonelKarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilPersonelKartiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonGroup2Layout = new javax.swing.GroupLayout(pnlButtonGroup2);
        pnlButtonGroup2.setLayout(pnlButtonGroup2Layout);
        pnlButtonGroup2Layout.setHorizontalGroup(
            pnlButtonGroup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonGroup2Layout.createSequentialGroup()
                .addComponent(btnYeniMalzemeKarti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKaydetPersonelKarti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSilPersonelKarti)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlButtonGroup2Layout.setVerticalGroup(
            pnlButtonGroup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonGroup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnKaydetPersonelKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnYeniMalzemeKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSilPersonelKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setText("Adı Soyadı :");

        jLabel2.setText("Departmanı :");

        tblPersonelListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ad Soyad", "Departman"
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
        tblPersonelListesi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPersonelListesiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPersonelListesi);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Mevcut Personel Listesi :");

        jLabel4.setText("Arama İfadesi :");

        txtPersonelAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPersonelAraKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlGovdeLayout = new javax.swing.GroupLayout(pnlGovde);
        pnlGovde.setLayout(pnlGovdeLayout);
        pnlGovdeLayout.setHorizontalGroup(
            pnlGovdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGovdeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGovdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlGovdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAdSoyad)
                    .addComponent(txtDepartman, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlGovdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGovdeLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPersonelAra, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        pnlGovdeLayout.setVerticalGroup(
            pnlGovdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGovdeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGovdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGovdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGovdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDepartman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlGovdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtPersonelAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(303, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlIslemlerLayout = new javax.swing.GroupLayout(pnlIslemler);
        pnlIslemler.setLayout(pnlIslemlerLayout);
        pnlIslemlerLayout.setHorizontalGroup(
            pnlIslemlerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIslemlerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlButtonGroup2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnlGovde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlIslemlerLayout.setVerticalGroup(
            pnlIslemlerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIslemlerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlButtonGroup2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGovde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIslemler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIslemler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetPersonelKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetPersonelKartiActionPerformed
        if (secilenId == 0) {
            try {
                connection = dbHelper.getConnection();
                String sql = "insert into personel_karti (ad_soyad,departman) values (?,?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, txtAdSoyad.getText());
                preparedStatement.setString(2, txtDepartman.getText());
                preparedStatement.executeUpdate();
                Bildirim.basarili("Kayıt işlemi başarılı!");
                personelleriTabloyaYansit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            try {
                connection = dbHelper.getConnection();
                String sql = "update personel_karti set ad_soyad = ?, departman = ? where id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, txtAdSoyad.getText());
                preparedStatement.setString(2, txtDepartman.getText());
                preparedStatement.setInt(3, secilenId);
                preparedStatement.executeUpdate();
                Bildirim.basarili("Güncelleme işlemi başarılı!");
                personelleriTabloyaYansit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnKaydetPersonelKartiActionPerformed

    public ArrayList<MPersonelKarti> personelListele() throws SQLException {
        ArrayList<MPersonelKarti> personeller = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM personel_karti");
            personeller = new ArrayList<MPersonelKarti>();
            while (resultSet.next()) {
                personeller.add(new MPersonelKarti(
                        resultSet.getInt("id"),
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
        return personeller;
    }
    
    public void personelleriTabloyaYansit() {
        model = (DefaultTableModel) tblPersonelListesi.getModel();
        model.setRowCount(0);
        try {
            ArrayList<MPersonelKarti> personelListesi = personelListele();
            for (MPersonelKarti liste : personelListesi) {
                Object[] row = {
                    liste.getId(),
                    liste.getAd_soyad(),
                    liste.getDepartman()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    public void resetForm() {
        secilenId = 0;
        txtAdSoyad.setText("");
        txtDepartman.setText("");
    }

    private void btnYeniMalzemeKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniMalzemeKartiActionPerformed
        resetForm();
    }//GEN-LAST:event_btnYeniMalzemeKartiActionPerformed

    private void silBtnToggle(){
        if (secilenId == 0) {
            btnSilPersonelKarti.setEnabled(false);
        }else{
            btnSilPersonelKarti.setEnabled(true);
        }
    }
    
    private void btnSilPersonelKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilPersonelKartiActionPerformed
        int onayDurumu = Bildirim.onayAl();
        if (onayDurumu == JOptionPane.YES_OPTION) {
            try {
                connection = dbHelper.getConnection();
                String sqlDelete = "DELETE FROM personel_karti WHERE id=?";
                preparedStatement = connection.prepareStatement(sqlDelete);
                preparedStatement.setInt(1, secilenId);
                preparedStatement.executeUpdate();
                Bildirim.basarili("Personel kartı silme işlemi başarıyla gerçekleştirildi...");
                personelleriTabloyaYansit();
            } catch (SQLException ex) {
                Logger.getLogger(FirmaKarti.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("silme işlemi başarısız");
        }
    }//GEN-LAST:event_btnSilPersonelKartiActionPerformed

    private void tblPersonelListesiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonelListesiMouseClicked
        int selectedRow = tblPersonelListesi.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tblPersonelListesi.getValueAt(selectedRow, 0);
            String adSoyad = (String) tblPersonelListesi.getValueAt(selectedRow, 1);
            String departman = (String) tblPersonelListesi.getValueAt(selectedRow, 2);
            secilenId = id;
            txtAdSoyad.setText(adSoyad);
            txtDepartman.setText(departman);
            silBtnToggle();
        }
    }//GEN-LAST:event_tblPersonelListesiMouseClicked

    private void txtPersonelAraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonelAraKeyReleased
        GlobalArama.ara(txtPersonelAra, model, tblPersonelListesi);
    }//GEN-LAST:event_txtPersonelAraKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydetPersonelKarti;
    private javax.swing.JButton btnSilPersonelKarti;
    private javax.swing.JButton btnYeniMalzemeKarti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlButtonGroup2;
    private javax.swing.JPanel pnlGovde;
    private javax.swing.JPanel pnlIslemler;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTable tblPersonelListesi;
    private javax.swing.JTextField txtAdSoyad;
    private javax.swing.JTextField txtDepartman;
    private javax.swing.JTextField txtPersonelAra;
    // End of variables declaration//GEN-END:variables
}
