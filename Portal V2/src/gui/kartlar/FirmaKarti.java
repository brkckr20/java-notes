package gui.kartlar;

import components.UlkeModal;
import helpers.DbHelper;
import interfaces.FirmaKartiYonetimi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import utils.Bildirim;
import models.MFirmaKarti;

public class FirmaKarti extends javax.swing.JInternalFrame implements FirmaKartiYonetimi {

    DefaultTableModel model;

    public FirmaKarti() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
    }
    
    @Override
    public void onFirmaSelected(String ulke, String ulke_kodu){
        txtUlke.setText(ulke);
        lblUlkeKoduText.setText(ulke_kodu);
    }

    @Override
    public void firmaEkle() {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "INSERT INTO firma_karti (firma_kodu,firma_unvan1,firma_unvan2,adres1,adres2,ulke_adi,ulke_kodu,sehir,ilce,posta_kodu,vergi_dairesi,vergi_no,"
                    + "telefon,cari_tipi,gib_mail) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, txtFirmaKodu.getText());
            statement.setString(2, txtFirmaUnvan1.getText());
            statement.setString(3, txtFirmaUnvan2.getText());
            statement.setString(4, txtAdres1.getText());
            statement.setString(5, txtAdres2.getText());
            statement.setString(6, txtUlke.getText());
            statement.setString(7, lblUlkeKoduText.getText());
            statement.setString(8, txtSehir.getText());
            statement.setString(9, txtIlce.getText());
            statement.setString(10, txtPostaKodu.getText());
            statement.setString(11, txtVergiDairesi.getText());
            statement.setString(12, txtVergiNo.getText());
            statement.setString(13, txtTelefon.getText());
            statement.setString(14, (String) cmbCariTipi.getSelectedItem());
            statement.setString(15, txtGibMail.getText());

            statement.executeUpdate();
            Bildirim.basarili("Kayıt işlemi başarılı!");
            firmalariTabloyaYansit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
            resultSet = statement.executeQuery("SELECT * FROM firma_karti");
            firmalar = new ArrayList<MFirmaKarti>();
            while (resultSet.next()) {
                firmalar.add(new MFirmaKarti(
                        resultSet.getString("firma_kodu"),
                        resultSet.getString("firma_unvan1"),
                        resultSet.getString("firma_unvan2"),
                        resultSet.getString("adres1"),
                        resultSet.getString("adres2"),
                        resultSet.getString("ulke_adi"),
                        resultSet.getString("ulke_kodu"),
                        resultSet.getString("sehir"),
                        resultSet.getString("ilce"),
                        resultSet.getString("posta_kodu"),
                        resultSet.getString("vergi_dairesi"),
                        resultSet.getString("vergi_no"),
                        resultSet.getString("telefon"),
                        resultSet.getString("cari_tipi"),
                        resultSet.getString("gib_mail")
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

    public void firmalariTabloyaYansit() {
        model = (DefaultTableModel) tblFirmaListesi.getModel();
        model.setRowCount(0);
        try {
            ArrayList<MFirmaKarti> firmaListesi = firmaListele();
            for (MFirmaKarti liste : firmaListesi) {
                Object[] row = {
                    liste.getFirma_kodu(),
                    liste.getFirma_unvan1(),
                    liste.getFirma_unvan2(),
                    liste.getAdres1(),
                    liste.getAdres2(),
                    liste.getUlke_adi(),
                    liste.getUlke_kodu(),
                    liste.getSehir(),
                    liste.getIlce(),
                    liste.getPosta_kodu(),
                    liste.getVergi_dairesi(),
                    liste.getVergi_no(),
                    liste.getTelefon(),
                    liste.getCari_tipi(),
                    liste.getGib_mail()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }
    
      public void resetForm() {
        txtFirmaKodu.setText("");
        txtFirmaUnvan1.setText("");
        txtFirmaUnvan2.setText("");
        txtAdres1.setText("");
        txtAdres2.setText("");
        txtUlke.setText("");
        lblUlkeKoduText.setText("");
        txtSehir.setText("");
        txtIlce.setText("");
        txtPostaKodu.setText("");
        txtVergiDairesi.setText("");
        txtVergiNo.setText("");
        txtTelefon.setText("");
        txtGibMail.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlButtonGroup = new javax.swing.JPanel();
        btnKaydetFirmaKarti = new javax.swing.JButton();
        btnYeniMalzemeKarti = new javax.swing.JButton();
        pnlMainForm = new javax.swing.JPanel();
        txtFirmaKodu = new javax.swing.JTextField();
        lblFirmaKodu = new javax.swing.JLabel();
        txtFirmaUnvan1 = new javax.swing.JTextField();
        lblFirmaUnvan1 = new javax.swing.JLabel();
        txtFirmaUnvan2 = new javax.swing.JTextField();
        lblFirmaUnvan2 = new javax.swing.JLabel();
        txtAdres1 = new javax.swing.JTextField();
        lblAdres1 = new javax.swing.JLabel();
        txtAdres2 = new javax.swing.JTextField();
        lblAdres2 = new javax.swing.JLabel();
        txtUlke = new javax.swing.JTextField();
        lblUlke = new javax.swing.JLabel();
        btnUlkeSec = new javax.swing.JButton();
        lblUlkeKodu = new javax.swing.JLabel();
        lblUlkeKoduText = new javax.swing.JLabel();
        txtSehir = new javax.swing.JTextField();
        lblSehir = new javax.swing.JLabel();
        txtIlce = new javax.swing.JTextField();
        lblIlce = new javax.swing.JLabel();
        txtPostaKodu = new javax.swing.JTextField();
        lblPostaKodu = new javax.swing.JLabel();
        txtVergiDairesi = new javax.swing.JTextField();
        lblVergiDairesi = new javax.swing.JLabel();
        txtVergiNo = new javax.swing.JTextField();
        lblVergiNo = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JTextField();
        lblTelefon = new javax.swing.JLabel();
        txtFax = new javax.swing.JTextField();
        lblFax = new javax.swing.JLabel();
        txtGibMail = new javax.swing.JTextField();
        lblGibMail = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFirmaListesi = new javax.swing.JTable();
        cmbCariTipi = new javax.swing.JComboBox();
        lblCariTipi = new javax.swing.JLabel();
        btnListeyiYukle = new javax.swing.JButton();

        btnKaydetFirmaKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/save.png"))); // NOI18N
        btnKaydetFirmaKarti.setText("Kaydet");
        btnKaydetFirmaKarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetFirmaKartiActionPerformed(evt);
            }
        });

        btnYeniMalzemeKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/plus.png"))); // NOI18N
        btnYeniMalzemeKarti.setText("Yeni");

        javax.swing.GroupLayout pnlButtonGroupLayout = new javax.swing.GroupLayout(pnlButtonGroup);
        pnlButtonGroup.setLayout(pnlButtonGroupLayout);
        pnlButtonGroupLayout.setHorizontalGroup(
            pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonGroupLayout.createSequentialGroup()
                .addComponent(btnYeniMalzemeKarti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKaydetFirmaKarti)
                .addGap(0, 864, Short.MAX_VALUE))
        );
        pnlButtonGroupLayout.setVerticalGroup(
            pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnKaydetFirmaKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnYeniMalzemeKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblFirmaKodu.setText("Firma Kodu :");

        lblFirmaUnvan1.setText("Firma Unvan 1 :");

        lblFirmaUnvan2.setText("Firma Unvan 2 :");

        lblAdres1.setText("Adres 1 :");

        lblAdres2.setText("Adres 2 :");

        lblUlke.setText("Ülke :");

        btnUlkeSec.setText("Seç");
        btnUlkeSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUlkeSecActionPerformed(evt);
            }
        });

        lblUlkeKodu.setText("Ülke Kodu :");

        lblUlkeKoduText.setText("Ülke Kodu :");

        lblSehir.setText("Şehir :");

        lblIlce.setText("İlçe :");

        lblPostaKodu.setText("Posta Kodu :");

        lblVergiDairesi.setText("Vergi Dairesi :");

        lblVergiNo.setText("Vergi No :");

        lblTelefon.setText("Telefon : ");

        lblFax.setText("Fax :");

        lblGibMail.setText("Gib Mail :");

        tblFirmaListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Firma Kodu", "Firma Unvan 1", "Firma Unvan 2", "Adres 1", "Adres 2", "Ülke", "Ülke Kodu", "Şehir", "İlçe", "Posta Kodu", "Vergi Dairesi", "Vergi No", "Telefon", "Cari Tipi", "Gib Mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFirmaListesi);

        cmbCariTipi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yerli Müşteri", "Yabancı Müşteri", "Aksesuar", "Dokuma" }));

        lblCariTipi.setText("Cari Tipi :");

        btnListeyiYukle.setText("Listeyi Yükle");
        btnListeyiYukle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListeyiYukleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainFormLayout = new javax.swing.GroupLayout(pnlMainForm);
        pnlMainForm.setLayout(pnlMainFormLayout);
        pnlMainFormLayout.setHorizontalGroup(
            pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
            .addGroup(pnlMainFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblFirmaKodu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFirmaUnvan1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(lblFirmaUnvan2)
                    .addComponent(lblAdres1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAdres2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUlke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSehir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIlce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPostaKodu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVergiDairesi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVergiNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGibMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCariTipi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbCariTipi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGibMail, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(txtFax)
                    .addComponent(txtTelefon)
                    .addComponent(txtVergiNo)
                    .addComponent(txtVergiDairesi)
                    .addComponent(txtPostaKodu)
                    .addComponent(txtIlce)
                    .addComponent(txtSehir)
                    .addComponent(txtUlke)
                    .addComponent(txtAdres2)
                    .addComponent(txtAdres1)
                    .addComponent(txtFirmaUnvan2)
                    .addComponent(txtFirmaUnvan1)
                    .addComponent(txtFirmaKodu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUlkeSec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUlkeKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUlkeKoduText, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlMainFormLayout.createSequentialGroup()
                .addComponent(btnListeyiYukle, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlMainFormLayout.setVerticalGroup(
            pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirmaKodu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirmaKodu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirmaUnvan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirmaUnvan1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirmaUnvan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirmaUnvan2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdres1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdres1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdres2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdres2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUlke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUlke)
                    .addComponent(btnUlkeSec)
                    .addComponent(lblUlkeKodu)
                    .addComponent(lblUlkeKoduText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSehir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSehir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIlce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIlce))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPostaKodu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPostaKodu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVergiDairesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVergiDairesi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVergiNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVergiNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFax))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGibMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGibMail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCariTipi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCariTipi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnListeyiYukle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlButtonGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMainForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlButtonGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMainForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetFirmaKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetFirmaKartiActionPerformed
        firmaEkle();
    }//GEN-LAST:event_btnKaydetFirmaKartiActionPerformed

    private void btnUlkeSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUlkeSecActionPerformed
        UlkeModal ulkeModal = new UlkeModal(null, true);
        
        ulkeModal.setVisible(true);
    }//GEN-LAST:event_btnUlkeSecActionPerformed

    private void btnListeyiYukleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListeyiYukleActionPerformed
        firmalariTabloyaYansit();
    }//GEN-LAST:event_btnListeyiYukleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydetFirmaKarti;
    private javax.swing.JButton btnListeyiYukle;
    private javax.swing.JButton btnUlkeSec;
    private javax.swing.JButton btnYeniMalzemeKarti;
    private javax.swing.JComboBox cmbCariTipi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdres1;
    private javax.swing.JLabel lblAdres2;
    private javax.swing.JLabel lblCariTipi;
    private javax.swing.JLabel lblFax;
    private javax.swing.JLabel lblFirmaKodu;
    private javax.swing.JLabel lblFirmaUnvan1;
    private javax.swing.JLabel lblFirmaUnvan2;
    private javax.swing.JLabel lblGibMail;
    private javax.swing.JLabel lblIlce;
    private javax.swing.JLabel lblPostaKodu;
    private javax.swing.JLabel lblSehir;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JLabel lblUlke;
    private javax.swing.JLabel lblUlkeKodu;
    private javax.swing.JLabel lblUlkeKoduText;
    private javax.swing.JLabel lblVergiDairesi;
    private javax.swing.JLabel lblVergiNo;
    private javax.swing.JPanel pnlButtonGroup;
    private javax.swing.JPanel pnlMainForm;
    private javax.swing.JTable tblFirmaListesi;
    private javax.swing.JTextField txtAdres1;
    private javax.swing.JTextField txtAdres2;
    private javax.swing.JTextField txtFax;
    private javax.swing.JTextField txtFirmaKodu;
    private javax.swing.JTextField txtFirmaUnvan1;
    private javax.swing.JTextField txtFirmaUnvan2;
    private javax.swing.JTextField txtGibMail;
    private javax.swing.JTextField txtIlce;
    private javax.swing.JTextField txtPostaKodu;
    private javax.swing.JTextField txtSehir;
    private javax.swing.JTextField txtTelefon;
    private javax.swing.JTextField txtUlke;
    private javax.swing.JTextField txtVergiDairesi;
    private javax.swing.JTextField txtVergiNo;
    // End of variables declaration//GEN-END:variables
}
