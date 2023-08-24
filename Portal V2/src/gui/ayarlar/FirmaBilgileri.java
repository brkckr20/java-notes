package gui.ayarlar;

import helpers.DbHelper;
import java.awt.Image;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import models.MFirmaBilgileri;
import utils.Bildirim;

public class FirmaBilgileri extends javax.swing.JInternalFrame {

    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet;

    public FirmaBilgileri() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        createAndShowGUI();
        bilgileriAlanlaraYansit();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlButtonGroup = new javax.swing.JPanel();
        btnKaydetFirmaKarti = new javax.swing.JButton();
        pnlMain = new javax.swing.JPanel();
        lblFirmaKodu = new javax.swing.JLabel();
        txtFirmaKodu = new javax.swing.JTextField();
        lblFirmaUnvanı = new javax.swing.JLabel();
        txtFirmaUnvani = new javax.swing.JTextField();
        lblFirmaAdresi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFirmaAdresi = new javax.swing.JTextPane();
        lblFirmaAdresi1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGenelBilgi = new javax.swing.JTextPane();
        lblFirmaUnvanı1 = new javax.swing.JLabel();
        txtEirsUserName = new javax.swing.JTextField();
        lblFirmaUnvanı2 = new javax.swing.JLabel();
        txtEirsPassword = new javax.swing.JTextField();
        lblFirmaUnvanı3 = new javax.swing.JLabel();
        txtVergiNo = new javax.swing.JTextField();
        lblFirmaUnvanı4 = new javax.swing.JLabel();
        lblFirmaUnvanı5 = new javax.swing.JLabel();
        txtWebSitesi = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblResim = new javax.swing.JLabel();
        lblResimImg = new javax.swing.JLabel();

        btnKaydetFirmaKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/save.png"))); // NOI18N
        btnKaydetFirmaKarti.setText("Kaydet");
        btnKaydetFirmaKarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetFirmaKartiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonGroupLayout = new javax.swing.GroupLayout(pnlButtonGroup);
        pnlButtonGroup.setLayout(pnlButtonGroupLayout);
        pnlButtonGroupLayout.setHorizontalGroup(
            pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKaydetFirmaKarti)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlButtonGroupLayout.setVerticalGroup(
            pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonGroupLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(btnKaydetFirmaKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblFirmaKodu.setText("Firma Kodu :");

        lblFirmaUnvanı.setText("Firma Unvanı :");

        lblFirmaAdresi.setText("Firma Adresi :");

        jScrollPane1.setViewportView(txtFirmaAdresi);

        lblFirmaAdresi1.setText("Genel Bilgi :");

        jScrollPane2.setViewportView(txtGenelBilgi);

        lblFirmaUnvanı1.setText("Eirs Username :");

        lblFirmaUnvanı2.setText("Eirs Password :");

        lblFirmaUnvanı3.setText("Vergi No :");

        lblFirmaUnvanı4.setText("Web Sitesi :");

        lblFirmaUnvanı5.setText("Telefon :");

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        lblResim.setText("Firma Logo :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblResim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResimImg, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResimImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblResim)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblFirmaKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFirmaKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblFirmaUnvanı, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFirmaUnvani, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblFirmaAdresi, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblFirmaAdresi1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblFirmaUnvanı1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEirsUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblFirmaUnvanı2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEirsPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblFirmaUnvanı3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtVergiNo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblFirmaUnvanı4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtWebSitesi, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblFirmaUnvanı5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFirmaKodu)
                            .addComponent(txtFirmaKodu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFirmaUnvanı)
                            .addComponent(txtFirmaUnvani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFirmaAdresi)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFirmaAdresi1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFirmaUnvanı1)
                            .addComponent(txtEirsUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFirmaUnvanı2)
                            .addComponent(txtEirsPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFirmaUnvanı3)
                            .addComponent(txtVergiNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFirmaUnvanı4)
                            .addComponent(txtWebSitesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFirmaUnvanı5)
                            .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(247, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlButtonGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 1015, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlButtonGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetFirmaKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetFirmaKartiActionPerformed
        try {
            connection = dbHelper.getConnection();
            String sql = "UPDATE firma_sabitleri SET "
                    + "firma_kodu = ? ,"
                    + "firma_unvani = ?, "
                    + "firma_adresi = ?, "
                    + "genel_bilgi = ?, "
                    + "eirs_user_name = ?,"
                    + " eirs_password = ?, "
                    + "vergi_no = ?, "
                    + "web_sitesi = ?, "
                    + "telefon = ? "
                    + "WHERE id = 1";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, txtFirmaKodu.getText());
            preparedStatement.setString(2, txtFirmaUnvani.getText());
            preparedStatement.setString(3, txtFirmaAdresi.getText());
            preparedStatement.setString(4, txtGenelBilgi.getText());
            preparedStatement.setString(5, txtEirsUserName.getText());
            preparedStatement.setString(6, txtEirsPassword.getText());
            preparedStatement.setString(7, txtVergiNo.getText());
            preparedStatement.setString(8, txtWebSitesi.getText());
            preparedStatement.setString(9, txtTelefon.getText());
            preparedStatement.executeUpdate();
            Bildirim.basarili("Kayıt işlemi başarılı!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnKaydetFirmaKartiActionPerformed

    private void createAndShowGUI() {

        ImageIcon icon = createImageIcon("logo.png");
        if (icon != null) {
            lblResimImg.setIcon(new ImageIcon(icon.getImage().getScaledInstance(410, 300, Image.SCALE_DEFAULT)));
        }

    }

    private static ImageIcon createImageIcon(String filename) {
        URL imageUrl = FirmaBilgileri.class.getResource(filename);
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        } else {
            System.err.println("Resim bulunamadı: " + filename);
            return null;
        }
    }

    public ArrayList<MFirmaBilgileri> firmaBilgisiListele() throws SQLException {
        ArrayList<MFirmaBilgileri> bilgiler = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM firma_sabitleri");
            bilgiler = new ArrayList<MFirmaBilgileri>();
            while (resultSet.next()) {
                bilgiler.add(new MFirmaBilgileri(
                        resultSet.getInt("id"),
                        resultSet.getString("firma_kodu"),
                        resultSet.getString("firma_unvani"),
                        resultSet.getString("firma_adresi"),
                        resultSet.getString("genel_bilgi"),
                        resultSet.getString("firma_logo"),
                        resultSet.getString("eirs_user_name"),
                        resultSet.getString("eirs_password"),
                        resultSet.getString("vergi_no"),
                        resultSet.getString("web_sitesi"),
                        resultSet.getString("telefon")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return bilgiler;
    }

    public void bilgileriAlanlaraYansit() {
        try {
            ArrayList<MFirmaBilgileri> firmaListesi = firmaBilgisiListele();
            for (MFirmaBilgileri liste : firmaListesi) {
                txtFirmaKodu.setText(liste.getFirma_kodu());
                txtFirmaUnvani.setText(liste.getFirma_unvani());
                txtFirmaAdresi.setText(liste.getFirma_adresi());
                txtGenelBilgi.setText(liste.getGenel_bilgi());
                txtEirsUserName.setText(liste.getEirs_user_name());
                txtEirsPassword.setText(liste.getEirs_password());
                txtVergiNo.setText(liste.getVergi_no());
                txtWebSitesi.setText(liste.getWeb_sitesi());
                txtTelefon.setText(liste.getTelefon());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydetFirmaKarti;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFirmaAdresi;
    private javax.swing.JLabel lblFirmaAdresi1;
    private javax.swing.JLabel lblFirmaKodu;
    private javax.swing.JLabel lblFirmaUnvanı;
    private javax.swing.JLabel lblFirmaUnvanı1;
    private javax.swing.JLabel lblFirmaUnvanı2;
    private javax.swing.JLabel lblFirmaUnvanı3;
    private javax.swing.JLabel lblFirmaUnvanı4;
    private javax.swing.JLabel lblFirmaUnvanı5;
    private javax.swing.JLabel lblResim;
    private javax.swing.JLabel lblResimImg;
    private javax.swing.JPanel pnlButtonGroup;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextField txtEirsPassword;
    private javax.swing.JTextField txtEirsUserName;
    private javax.swing.JTextPane txtFirmaAdresi;
    private javax.swing.JTextField txtFirmaKodu;
    private javax.swing.JTextField txtFirmaUnvani;
    private javax.swing.JTextPane txtGenelBilgi;
    private javax.swing.JTextField txtTelefon;
    private javax.swing.JTextField txtVergiNo;
    private javax.swing.JTextField txtWebSitesi;
    // End of variables declaration//GEN-END:variables
}
