package gui.depolar;

import helpers.DbHelper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import models.MSarfMalzemeDepo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import utils.SQLDosyasındanOku;
import methods.SarfMalzemeDepo.Methods;

public class SarfMalzemeCikis extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    Methods methods = new Methods();

    public SarfMalzemeCikis() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        malzemeDepoListesiniTabloyaYansit();
    }

    public void malzemeDepoListesiniTabloyaYansit() {
        model = (DefaultTableModel) tblSarfMalzemeDepoDurumu.getModel();
        model.setRowCount(0);
        try {
            ArrayList<MSarfMalzemeDepo> malzemeDepo = methods.malzemeDepoListele();
            for (MSarfMalzemeDepo liste : malzemeDepo) {
                Object[] row = {
                    liste.getMalzeme_kodu(),
                    liste.getMalzeme_adi(),
                    liste.getBirim(),
                    liste.getKalan_miktar(),
                    liste.getUuid()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlButtonGroup = new javax.swing.JPanel();
        btnKaydetMalzemeKarti = new javax.swing.JButton();
        btnGeriMalzemeKarti = new javax.swing.JButton();
        btnIleriMalzemeKarti = new javax.swing.JButton();
        btnSilMalzemeGiris = new javax.swing.JButton();
        btnListeMalzemeGiris = new javax.swing.JButton();
        btnYeniMalzemeGiris = new javax.swing.JButton();
        btnListeMalzemeCikisDepoYenile = new javax.swing.JButton();
        pnlMainForm = new javax.swing.JPanel();
        txtFisNo = new javax.swing.JTextField();
        lblFisNo = new javax.swing.JLabel();
        dateIslemTarihi = new com.toedter.calendar.JDateChooser();
        lblTarih = new javax.swing.JLabel();
        txtCariKod = new javax.swing.JTextField();
        lblFirmaKod = new javax.swing.JLabel();
        btnFirmaSec = new javax.swing.JButton();
        lblFirmaUnvan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMalzemeGiris = new javax.swing.JTable();
        pnlHavuzlar = new javax.swing.JPanel();
        tbpHavuzlar = new javax.swing.JTabbedPane();
        pnlSarfMalzemeDepoHavuz = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSarfMalzemeDepoDurumu = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        btnKaydetMalzemeKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/save.png"))); // NOI18N
        btnKaydetMalzemeKarti.setText("Kaydet");
        btnKaydetMalzemeKarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetMalzemeKartiActionPerformed(evt);
            }
        });

        btnGeriMalzemeKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Back Arrow.png"))); // NOI18N
        btnGeriMalzemeKarti.setText("Geri");
        btnGeriMalzemeKarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeriMalzemeKartiActionPerformed(evt);
            }
        });

        btnIleriMalzemeKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Forward Button.png"))); // NOI18N
        btnIleriMalzemeKarti.setText("İleri");
        btnIleriMalzemeKarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIleriMalzemeKartiActionPerformed(evt);
            }
        });

        btnSilMalzemeGiris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Delete.png"))); // NOI18N
        btnSilMalzemeGiris.setText("Sil");
        btnSilMalzemeGiris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilMalzemeGirisActionPerformed(evt);
            }
        });

        btnListeMalzemeGiris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/List.png"))); // NOI18N
        btnListeMalzemeGiris.setText("Liste");
        btnListeMalzemeGiris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListeMalzemeGirisActionPerformed(evt);
            }
        });

        btnYeniMalzemeGiris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/File.png"))); // NOI18N
        btnYeniMalzemeGiris.setText("Yeni");
        btnYeniMalzemeGiris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYeniMalzemeGirisActionPerformed(evt);
            }
        });

        btnListeMalzemeCikisDepoYenile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Restart.png"))); // NOI18N
        btnListeMalzemeCikisDepoYenile.setText("Yenile");
        btnListeMalzemeCikisDepoYenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListeMalzemeCikisDepoYenileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonGroupLayout = new javax.swing.GroupLayout(pnlButtonGroup);
        pnlButtonGroup.setLayout(pnlButtonGroupLayout);
        pnlButtonGroupLayout.setHorizontalGroup(
            pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonGroupLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnYeniMalzemeGiris)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKaydetMalzemeKarti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGeriMalzemeKarti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIleriMalzemeKarti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSilMalzemeGiris)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListeMalzemeGiris)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListeMalzemeCikisDepoYenile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlButtonGroupLayout.setVerticalGroup(
            pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnKaydetMalzemeKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnYeniMalzemeGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnGeriMalzemeKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnIleriMalzemeKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSilMalzemeGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnListeMalzemeGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnListeMalzemeCikisDepoYenile, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txtFisNo.setEditable(false);
        txtFisNo.setText("SARF_MALZEME_CIKIS");

        lblFisNo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFisNo.setText("İşlem Cinsi");

        dateIslemTarihi.setDateFormatString("dd.MM.yyyy");

        lblTarih.setText("Tarih :");

        txtCariKod.setEditable(false);

        lblFirmaKod.setText("Firma :");

        btnFirmaSec.setText("Seç");
        btnFirmaSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirmaSecActionPerformed(evt);
            }
        });

        tblMalzemeGiris.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kalem İşlem", "Malzeme Kodu", "Malzeme Adı", "Miktar", "Birim", "Not 1", "Not 2", "Çıkılan Birim", "Teslim Alan", "Uuid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMalzemeGiris.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMalzemeGirisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMalzemeGiris);

        tblSarfMalzemeDepoDurumu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Malzeme Kodu", "Malzeme Adı", "Kalan Miktar", "Birim", "Uuid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSarfMalzemeDepoDurumu);

        javax.swing.GroupLayout pnlSarfMalzemeDepoHavuzLayout = new javax.swing.GroupLayout(pnlSarfMalzemeDepoHavuz);
        pnlSarfMalzemeDepoHavuz.setLayout(pnlSarfMalzemeDepoHavuzLayout);
        pnlSarfMalzemeDepoHavuzLayout.setHorizontalGroup(
            pnlSarfMalzemeDepoHavuzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSarfMalzemeDepoHavuzLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 438, Short.MAX_VALUE))
        );
        pnlSarfMalzemeDepoHavuzLayout.setVerticalGroup(
            pnlSarfMalzemeDepoHavuzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSarfMalzemeDepoHavuzLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        tbpHavuzlar.addTab("Sarf Malzeme Depo", pnlSarfMalzemeDepoHavuz);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1106, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );

        tbpHavuzlar.addTab("Sarf Malzeme Kartı Listesi", jPanel2);

        javax.swing.GroupLayout pnlHavuzlarLayout = new javax.swing.GroupLayout(pnlHavuzlar);
        pnlHavuzlar.setLayout(pnlHavuzlarLayout);
        pnlHavuzlarLayout.setHorizontalGroup(
            pnlHavuzlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHavuzlarLayout.createSequentialGroup()
                .addComponent(tbpHavuzlar)
                .addContainerGap())
        );
        pnlHavuzlarLayout.setVerticalGroup(
            pnlHavuzlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpHavuzlar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnlMainFormLayout = new javax.swing.GroupLayout(pnlMainForm);
        pnlMainForm.setLayout(pnlMainFormLayout);
        pnlMainFormLayout.setHorizontalGroup(
            pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlHavuzlar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMainFormLayout.createSequentialGroup()
                        .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(pnlMainFormLayout.createSequentialGroup()
                                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFisNo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTarih)
                                    .addComponent(lblFirmaKod))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCariKod)
                                    .addComponent(dateIslemTarihi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFisNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFirmaSec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFirmaUnvan, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        pnlMainFormLayout.setVerticalGroup(
            pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFisNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFisNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateIslemTarihi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTarih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariKod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirmaKod)
                    .addComponent(btnFirmaSec)
                    .addComponent(lblFirmaUnvan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlHavuzlar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(pnlMainForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetMalzemeKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetMalzemeKartiActionPerformed
        /*
         Connection connection = null;
         DbHelper dbHelper = new DbHelper();
         PreparedStatement statement = null;
         PreparedStatement statementTablo1 = null;
         ResultSet generatedKeys = null;
         java.util.Date talepTarihiDate = dateIslemTarihi.getDate();
         DateFormat tarihFormat = new SimpleDateFormat("yyyy-MM-dd");
         try {
         connection = dbHelper.getConnection();
         connection.setAutoCommit(false);
         String sqlTablo1 = "INSERT INTO sarf_malzeme_depo1 (islem_cinsi, firma_kodu, firma_unvan,fatura_no,tarih) VALUES (?, ?, ?, ?,?)";
         statementTablo1 = connection.prepareStatement(sqlTablo1, Statement.RETURN_GENERATED_KEYS);
         statementTablo1.setString(1, txtFisNo.getText());
         statementTablo1.setString(2, txtCariKod.getText());
         statementTablo1.setString(3, lblFirmaUnvan.getText());
         statementTablo1.setString(4, txtBelgeNo.getText());
         statementTablo1.setString(5, tarihFormat.format(talepTarihiDate));
         statementTablo1.executeUpdate();

         // Eklenen satırın id'sini almak için auto-generated keys'i al
         generatedKeys = statementTablo1.getGeneratedKeys();
         int tablo1Id = -1;
         if (generatedKeys.next()) {
         tablo1Id = generatedKeys.getInt(1);
         } else {
         throw new SQLException("Tablo1'e veri eklenirken bir hata oluştu, id alınamadı.");
         }

         int rowCount = model.getRowCount();
         for (int i = 0; i < rowCount; i++) {
         String kalemIslem = (String) model.getValueAt(i, 0);
         String malzemeKodu = (String) model.getValueAt(i, 1);
         String malzemeAdi = (String) model.getValueAt(i, 2);
         int miktar = (int) model.getValueAt(i, 3);
         String birim = (String) model.getValueAt(i, 4);
         String uuid = (String) model.getValueAt(i, 6);

         String sql = "INSERT INTO sarf_malzeme_depo2 (kalem_islem, malzeme_kodu, malzeme_adi, miktar, birim, refNoId, uuid) VALUES (?, ?, ?, ?, ?, ?, ?)";
         statement = connection.prepareStatement(sql);
         statement.setString(1, kalemIslem);
         statement.setString(2, malzemeKodu);
         statement.setString(3, malzemeAdi);
         statement.setInt(4, miktar);
         statement.setString(5, birim);
         statement.setInt(6, tablo1Id);
         statement.setString(7, uuid);
         statement.executeUpdate();
         }
         // Veritabanı işlemlerini onayla ve işlemi tamamla
         connection.commit();
         JOptionPane.showMessageDialog(this, "Veriler başarıyla veritabanına kaydedildi.");
         } catch (SQLException e) {
         System.out.println(e.getMessage());
         JOptionPane.showMessageDialog(this, "Veritabanına kaydetme işlemi başarısız oldu.");
         } finally {
         // Kapatma işlemlerini yapın
         try {
         if (statement != null) {
         statement.close();
         }
         if (connection != null) {
         connection.close();
         }
         } catch (SQLException ex) {
         ex.printStackTrace();
         }
         }*/
    }//GEN-LAST:event_btnKaydetMalzemeKartiActionPerformed

    private void btnGeriMalzemeKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeriMalzemeKartiActionPerformed

    }//GEN-LAST:event_btnGeriMalzemeKartiActionPerformed

    private void btnIleriMalzemeKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIleriMalzemeKartiActionPerformed

    }//GEN-LAST:event_btnIleriMalzemeKartiActionPerformed

    private void btnSilMalzemeGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilMalzemeGirisActionPerformed

    }//GEN-LAST:event_btnSilMalzemeGirisActionPerformed

    private void btnListeMalzemeGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListeMalzemeGirisActionPerformed

    }//GEN-LAST:event_btnListeMalzemeGirisActionPerformed

    private void btnYeniMalzemeGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniMalzemeGirisActionPerformed
        try {
            methods.malzemeDepoListele();
        } catch (SQLException ex) {
            Logger.getLogger(SarfMalzemeCikis.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SarfMalzemeCikis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnYeniMalzemeGirisActionPerformed

    private void btnFirmaSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirmaSecActionPerformed
        //  FirmaModal firmaModal = new FirmaModal(null, true);
        //    firmaModal.setSelectionListener(this);
        //   firmaModal.setVisible(true);
    }//GEN-LAST:event_btnFirmaSecActionPerformed

    private void tblMalzemeGirisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMalzemeGirisMouseClicked

        if (evt.getClickCount() == 1) {
            int column = tblMalzemeGiris.columnAtPoint(evt.getPoint());
            int row = tblMalzemeGiris.rowAtPoint(evt.getPoint());

            if (column != 1) {
                return;
            }

            Object cellValue = tblMalzemeGiris.getValueAt(row, column);

            if (cellValue != null) {
                //     MalzemeKoduModal malzemeKoduModal = new MalzemeKoduModal(null, true);
                //    malzemeKoduModal.setSelectionListener(this);
                //    malzemeKoduModal.setVisible(true);

            }
        }
    }//GEN-LAST:event_tblMalzemeGirisMouseClicked

    private void btnListeMalzemeCikisDepoYenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListeMalzemeCikisDepoYenileActionPerformed
        malzemeDepoListesiniTabloyaYansit();
    }//GEN-LAST:event_btnListeMalzemeCikisDepoYenileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirmaSec;
    private javax.swing.JButton btnGeriMalzemeKarti;
    private javax.swing.JButton btnIleriMalzemeKarti;
    private javax.swing.JButton btnKaydetMalzemeKarti;
    private javax.swing.JButton btnListeMalzemeCikisDepoYenile;
    private javax.swing.JButton btnListeMalzemeGiris;
    private javax.swing.JButton btnSilMalzemeGiris;
    private javax.swing.JButton btnYeniMalzemeGiris;
    private com.toedter.calendar.JDateChooser dateIslemTarihi;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFirmaKod;
    private javax.swing.JLabel lblFirmaUnvan;
    private javax.swing.JLabel lblFisNo;
    private javax.swing.JLabel lblTarih;
    private javax.swing.JPanel pnlButtonGroup;
    private javax.swing.JPanel pnlHavuzlar;
    private javax.swing.JPanel pnlMainForm;
    private javax.swing.JPanel pnlSarfMalzemeDepoHavuz;
    private javax.swing.JTable tblMalzemeGiris;
    private javax.swing.JTable tblSarfMalzemeDepoDurumu;
    private javax.swing.JTabbedPane tbpHavuzlar;
    private javax.swing.JTextField txtCariKod;
    private javax.swing.JTextField txtFisNo;
    // End of variables declaration//GEN-END:variables

}
