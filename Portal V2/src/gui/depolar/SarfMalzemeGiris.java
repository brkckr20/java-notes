package gui.depolar;

import components.FirmaModal;
import components.ListeModal;
import components.MalzemeKoduModal;
import helpers.DbHelper;
import interfaces.FirmaKartiYonetimi;
import interfaces.MalzemeKartiYonetimi;
import interfaces.MalzemeDepoYonetimi;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.util.UUID;
import models.MSarfMalzemeDepo;
import methods.SarfMalzemeDepo.Methods;

public class SarfMalzemeGiris extends javax.swing.JInternalFrame implements MalzemeKartiYonetimi, FirmaKartiYonetimi, MalzemeDepoYonetimi {

    private DefaultTableModel model;
    private JComboBox<String> comboBox;
    Methods methods = new Methods();

    @Override
    public void onMalzemeSelected(String malzemeKodu, String malzemeAdi, String birim) {
        int selectedRow = tblMalzemeGiris.getSelectedRow();
        if (selectedRow != -1) {
            // Seçilen satırın 2. hücresine malzeme kodunu, 3. hücresine malzeme adını yazdırın
            tblMalzemeGiris.setValueAt(malzemeKodu, selectedRow, 1);
            tblMalzemeGiris.setValueAt(malzemeAdi, selectedRow, 2);
            tblMalzemeGiris.setValueAt(birim, selectedRow, 4);
        }
    }

    @Override
    public void onFirmaSelected(String ulke, String ulke_kodu) {
        txtCariKod.setText(ulke);
        lblFirmaUnvan.setText(ulke_kodu);
    }

    @Override
    public void onSarfMalzemeGirisListeSelected(int id, Date tarih, String fatura_no, String firma_kodu, String firma_unvan) {
        lblKayitNoText.setText(Integer.toString(id));
        dateIslemTarihi.setDate(tarih);
        txtBelgeNo.setText(fatura_no);
        txtCariKod.setText(firma_kodu);
        lblFirmaUnvan.setText(firma_unvan);

        model = (DefaultTableModel) tblMalzemeGiris.getModel();
        model.setRowCount(0); // Mevcut satırları temizle

        /* for (String kalemIslem : kalem_islem) {
         model.addRow(new Object[]{kalemIslem});
         }*/
    }

    @Override
    public void firmaEkle() {

    }

    public SarfMalzemeGiris() {
        initComponents();
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        initTable();
        tblMalzemeGiris.setSelectionBackground(Color.decode("#ff9f43"));
        btnIleriMalzemeKarti.setEnabled(false);
        btnGeriMalzemeKarti.setEnabled(false);
        btnSilMalzemeGiris.setEnabled(false);
    }

    public void malzemeDepoListesiniTabloyaYansit() {
        model = (DefaultTableModel) tblMalzemeGiris.getModel();
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

    public void malzemeDepoGirisOncekiKayitGetir(int id) {
        btnIleriMalzemeKarti.setEnabled(true);
        model = (DefaultTableModel) tblMalzemeGiris.getModel();
        model.setRowCount(0);
        try {
            ArrayList<MSarfMalzemeDepo> sonuc = methods.malzemeDepoGirisOncekiKayitGetir(id);
            if (!sonuc.isEmpty()) {
                MSarfMalzemeDepo ilkKayit = sonuc.get(0); // İlk kaydı al
                int kayitNoText = ilkKayit.getId();
                if (kayitNoText == 1) {
                    btnGeriMalzemeKarti.setEnabled(false);
                }
                lblKayitNoText.setText(Integer.toString(kayitNoText)); // int değeri String olarak dönüştür
                txtCariKod.setText(ilkKayit.getFirma_kodu());
                txtBelgeNo.setText(ilkKayit.getFatura_no());
                lblFirmaUnvan.setText(ilkKayit.getFirma_unvan());
                dateIslemTarihi.setDate(ilkKayit.getTarih());
                try {
                    for (MSarfMalzemeDepo liste : sonuc) {
                        Object[] row = {
                            liste.getKalem_islem(),
                            liste.getMalzeme_kodu(),
                            liste.getMalzeme_adi(),
                            liste.getKalan_miktar(),
                            liste.getBirim(),
                            "",
                            liste.getUuid()
                        };
                        model.addRow(row);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                lblKayitNoText.setText("1"); // Eğer liste boşsa
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void malzemeDepoGirisSonrakiKayitGetir(int id) {
        btnGeriMalzemeKarti.setEnabled(true);
        model = (DefaultTableModel) tblMalzemeGiris.getModel();
        model.setRowCount(0);
        try {
            ArrayList<MSarfMalzemeDepo> sonuc = methods.malzemeDepoGirisSonrakiKayitGetir(id);
            if (!sonuc.isEmpty()) {

                if (!sonuc.isEmpty()) {
                    MSarfMalzemeDepo ilkKayit = sonuc.get(0); // İlk kaydı al
                    int kayitNoText = ilkKayit.getId();

                    lblKayitNoText.setText(Integer.toString(kayitNoText)); // int değeri String olarak dönüştür
                    txtCariKod.setText(ilkKayit.getFirma_kodu());
                    txtBelgeNo.setText(ilkKayit.getFatura_no());
                    lblFirmaUnvan.setText(ilkKayit.getFirma_unvan());
                    dateIslemTarihi.setDate(ilkKayit.getTarih());
                    try {
                        for (MSarfMalzemeDepo liste : sonuc) {
                            Object[] row = {
                                liste.getKalem_islem(),
                                liste.getMalzeme_kodu(),
                                liste.getMalzeme_adi(),
                                liste.getKalan_miktar(),
                                liste.getBirim(),
                                "",
                                liste.getUuid()
                            };
                            model.addRow(row);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    btnIleriMalzemeKarti.setEnabled(false);
                }

            } else {
                MSarfMalzemeDepo ilkKayit = sonuc.get(0);
                int kayitNoText = ilkKayit.getId();
                lblKayitNoText.setText(Integer.toString(kayitNoText));
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void malzemeDepoGirisSonKayitGetir() {
        model = (DefaultTableModel) tblMalzemeGiris.getModel();
        model.setRowCount(0);
        try {
            ArrayList<MSarfMalzemeDepo> sonuc = methods.malzemeDepoGirisSonKayitGetir();
            if (!sonuc.isEmpty()) {
                MSarfMalzemeDepo ilkKayit = sonuc.get(0); // İlk kaydı al
                int kayitNoText = ilkKayit.getId();
                lblKayitNoText.setText(Integer.toString(kayitNoText)); // int değeri String olarak dönüştür
                txtCariKod.setText(ilkKayit.getFirma_kodu());
                txtBelgeNo.setText(ilkKayit.getFatura_no());
                lblFirmaUnvan.setText(ilkKayit.getFirma_unvan());
                dateIslemTarihi.setDate(ilkKayit.getTarih());
                try {
                    for (MSarfMalzemeDepo liste : sonuc) {
                        Object[] row = {
                            liste.getKalem_islem(),
                            liste.getMalzeme_kodu(),
                            liste.getMalzeme_adi(),
                            liste.getKalan_miktar(),
                            liste.getBirim(),
                            "",
                            liste.getUuid()
                        };
                        model.addRow(row);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("kayit bulunamadı");
                //lblKayitNoText.setText(Integer.toString(1)); // Eğer liste boşsa
            }
        } catch (Exception e) {
            System.out.println(e);
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
        btnVazgecMalzemeKarti = new javax.swing.JButton();
        pnlMainForm = new javax.swing.JPanel();
        txtFisNo = new javax.swing.JTextField();
        lblFisNo = new javax.swing.JLabel();
        dateIslemTarihi = new com.toedter.calendar.JDateChooser();
        lblTarih = new javax.swing.JLabel();
        txtBelgeNo = new javax.swing.JTextField();
        lblBelgeNo = new javax.swing.JLabel();
        txtCariKod = new javax.swing.JTextField();
        lblFirmaKod = new javax.swing.JLabel();
        btnFirmaSec = new javax.swing.JButton();
        lblFirmaUnvan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMalzemeGiris = new javax.swing.JTable();
        btnYeniSatir = new javax.swing.JButton();
        lblKayitNo = new javax.swing.JLabel();
        lblKayitNoText = new javax.swing.JLabel();

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

        btnVazgecMalzemeKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Cancel.png"))); // NOI18N
        btnVazgecMalzemeKarti.setText("Vazgeç");
        btnVazgecMalzemeKarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVazgecMalzemeKartiActionPerformed(evt);
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
                .addComponent(btnVazgecMalzemeKarti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSilMalzemeGiris)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListeMalzemeGiris)
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
                .addComponent(btnVazgecMalzemeKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txtFisNo.setEditable(false);
        txtFisNo.setText("SARF_MALZEME_GIRIS");

        lblFisNo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFisNo.setText("İşlem Cinsi");

        dateIslemTarihi.setDateFormatString("dd.MM.yyyy");

        lblTarih.setText("Tarih :");

        lblBelgeNo.setText("Belge No :");

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
                "Kalem İşlem", "Malzeme Kodu", "Malzeme Adı", "Miktar", "Birim", "Malzeme Marka", "Uuid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true, true, false
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

        btnYeniSatir.setText("Yeni Satır Ekle");
        btnYeniSatir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYeniSatirActionPerformed(evt);
            }
        });

        lblKayitNo.setText("Kayıt No :");

        lblKayitNoText.setText("0");

        javax.swing.GroupLayout pnlMainFormLayout = new javax.swing.GroupLayout(pnlMainForm);
        pnlMainForm.setLayout(pnlMainFormLayout);
        pnlMainFormLayout.setHorizontalGroup(
            pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlMainFormLayout.createSequentialGroup()
                        .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFisNo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTarih)
                            .addComponent(lblBelgeNo)
                            .addComponent(lblFirmaKod))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCariKod)
                            .addComponent(txtBelgeNo)
                            .addComponent(dateIslemTarihi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFisNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFirmaSec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFirmaUnvan, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlMainFormLayout.createSequentialGroup()
                                .addComponent(lblKayitNo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblKayitNoText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(59, Short.MAX_VALUE))
                    .addGroup(pnlMainFormLayout.createSequentialGroup()
                        .addComponent(btnYeniSatir)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlMainFormLayout.setVerticalGroup(
            pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFisNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFisNo)
                    .addComponent(lblKayitNo)
                    .addComponent(lblKayitNoText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateIslemTarihi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTarih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBelgeNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBelgeNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariKod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirmaKod)
                    .addComponent(btnFirmaSec)
                    .addComponent(lblFirmaUnvan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnYeniSatir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlButtonGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(115, 115, 115))
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

    private void btnKaydetMalzemeKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetMalzemeKartiActionPerformed

        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
        PreparedStatement statementTablo1 = null;
        ResultSet generatedKeys = null;
        java.util.Date talepTarihiDate = dateIslemTarihi.getDate();
        DateFormat tarihFormat = new SimpleDateFormat("yyyy-MM-dd");
        // yeni kayıt ekleme işlemi
        if (Integer.parseInt(lblKayitNoText.getText()) == 0) {
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
            }
        } else {
            try {
                connection = dbHelper.getConnection();
                connection.setAutoCommit(false);
                String sqlTablo1 = "UPDATE sarf_malzeme_depo1 SET tarih = ? , firma_kodu = ? , firma_unvan = ? , fatura_no = ? where id = ?";
                statementTablo1 = connection.prepareStatement(sqlTablo1);
                statementTablo1.setString(1, tarihFormat.format(talepTarihiDate));
                statementTablo1.setString(2, txtCariKod.getText());
                statementTablo1.setString(3, lblFirmaUnvan.getText());
                statementTablo1.setString(4, txtBelgeNo.getText());
                statementTablo1.setInt(5, Integer.parseInt(lblKayitNoText.getText()));
                statementTablo1.executeUpdate();

                int rowCount = model.getRowCount();

                for (int i = 0; i < rowCount; i++) {
                    String kalemIslem = (String) model.getValueAt(i, 0);
                    String malzemeKodu = (String) model.getValueAt(i, 1);
                    String malzemeAdi = (String) model.getValueAt(i, 2);
                    int miktar = (int) model.getValueAt(i, 3);
                    String uuid = (String) model.getValueAt(i, 6);
                    tblMalzemeGiris.repaint();
                    String sqlTablo2 = "UPDATE sarf_malzeme_depo2 SET kalem_islem = ?, malzeme_kodu = ?, malzeme_adi = ?, miktar = ? WHERE uuid = ?";
                    statement = connection.prepareStatement(sqlTablo2);
                    statement.setString(1, kalemIslem);
                    statement.setString(2, malzemeKodu);
                    statement.setString(3, malzemeAdi);
                    statement.setInt(4, miktar);
                    statement.setString(5, uuid);

                    int affectedRows = statement.executeUpdate();
                    System.out.println("Affected Rows: " + affectedRows);

                    if (affectedRows > 0) {
                        model.setValueAt(kalemIslem, i, 0);
                        model.setValueAt(malzemeKodu, i, 1);
                        model.setValueAt(malzemeAdi, i, 2);
                        model.setValueAt(miktar, i, 3);
                        model.setValueAt(uuid, i, 6);
                    }
                }
                // Veritabanı işlemlerini onayla ve işlemi tamamla  7bc06951-3592-4fcd-86a0-cb35fcb8c3ec
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
            }
        }
    }//GEN-LAST:event_btnKaydetMalzemeKartiActionPerformed

    private void btnYeniSatirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniSatirActionPerformed
        UUID uuid = UUID.randomUUID();
        Object[] newRow = {"Seç", "", "", "", "", "", uuid.toString()};
        model.addRow(newRow);
    }//GEN-LAST:event_btnYeniSatirActionPerformed

    private void tblMalzemeGirisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMalzemeGirisMouseClicked

        if (evt.getClickCount() == 1) {
            int column = tblMalzemeGiris.columnAtPoint(evt.getPoint());
            int row = tblMalzemeGiris.rowAtPoint(evt.getPoint());

            if (column != 1) {
                return;
            }

            Object cellValue = tblMalzemeGiris.getValueAt(row, column);

            if (cellValue != null) {
                MalzemeKoduModal malzemeKoduModal = new MalzemeKoduModal(null, true);
                malzemeKoduModal.setSelectionListener(this);
                malzemeKoduModal.setVisible(true);

            }
        }
    }//GEN-LAST:event_tblMalzemeGirisMouseClicked

    private void btnFirmaSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirmaSecActionPerformed
        FirmaModal firmaModal = new FirmaModal(null, true);
        firmaModal.setSelectionListener(this);
        firmaModal.setVisible(true);

    }//GEN-LAST:event_btnFirmaSecActionPerformed

    private void btnGeriMalzemeKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeriMalzemeKartiActionPerformed
        int kayitNo = Integer.parseInt(lblKayitNoText.getText());
        malzemeDepoGirisOncekiKayitGetir(kayitNo);
    }//GEN-LAST:event_btnGeriMalzemeKartiActionPerformed

    private void btnIleriMalzemeKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIleriMalzemeKartiActionPerformed
        int kayitNo = Integer.parseInt(lblKayitNoText.getText());
        malzemeDepoGirisSonrakiKayitGetir(kayitNo);
    }//GEN-LAST:event_btnIleriMalzemeKartiActionPerformed

    private void btnSilMalzemeGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilMalzemeGirisActionPerformed
        int kayitNo = Integer.parseInt(lblKayitNoText.getText());
        try {
            methods.sil(kayitNo);
            malzemeDepoGirisSonKayitGetir();
        } catch (SQLException ex) {
            System.out.println("Btn sil : " + ex.getMessage());
        }

    }//GEN-LAST:event_btnSilMalzemeGirisActionPerformed

    private void btnListeMalzemeGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListeMalzemeGirisActionPerformed
        ListeModal listeModal = new ListeModal(null, true);
        listeModal.setSelectionListener(this);
        listeModal.setVisible(true);
    }//GEN-LAST:event_btnListeMalzemeGirisActionPerformed

    private void btnYeniMalzemeGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniMalzemeGirisActionPerformed
        lblKayitNoText.setText(Integer.toString(0));
        Date currentDate = new Date();  // Günümüz tarihi
        dateIslemTarihi.setDate(currentDate);
        txtBelgeNo.setText("");
        txtCariKod.setText("");
        lblFirmaUnvan.setText("");
        model.setRowCount(0);
    }//GEN-LAST:event_btnYeniMalzemeGirisActionPerformed

    private void btnVazgecMalzemeKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVazgecMalzemeKartiActionPerformed
        malzemeDepoGirisSonKayitGetir();
        btnGeriMalzemeKarti.setEnabled(true);
        btnIleriMalzemeKarti.setEnabled(true);
        btnSilMalzemeGiris.setEnabled(true);

    }//GEN-LAST:event_btnVazgecMalzemeKartiActionPerformed

    private void initTable() {
        comboBox = new JComboBox<>();
        comboBox.addItem("GİRİŞ");
        comboBox.addItem("TAMİR GİRİŞ");
        comboBox.addItem("DOLUM");
        comboBox.addItem("SATIN ALMA");
        comboBox.addItem("STOK GİRİŞ");
        tblMalzemeGiris.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox));
        model = (DefaultTableModel) tblMalzemeGiris.getModel();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirmaSec;
    private javax.swing.JButton btnGeriMalzemeKarti;
    private javax.swing.JButton btnIleriMalzemeKarti;
    private javax.swing.JButton btnKaydetMalzemeKarti;
    private javax.swing.JButton btnListeMalzemeGiris;
    private javax.swing.JButton btnSilMalzemeGiris;
    private javax.swing.JButton btnVazgecMalzemeKarti;
    private javax.swing.JButton btnYeniMalzemeGiris;
    private javax.swing.JButton btnYeniSatir;
    private com.toedter.calendar.JDateChooser dateIslemTarihi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBelgeNo;
    private javax.swing.JLabel lblFirmaKod;
    private javax.swing.JLabel lblFirmaUnvan;
    private javax.swing.JLabel lblFisNo;
    private javax.swing.JLabel lblKayitNo;
    private javax.swing.JLabel lblKayitNoText;
    private javax.swing.JLabel lblTarih;
    private javax.swing.JPanel pnlButtonGroup;
    private javax.swing.JPanel pnlMainForm;
    private javax.swing.JTable tblMalzemeGiris;
    private javax.swing.JTextField txtBelgeNo;
    private javax.swing.JTextField txtCariKod;
    private javax.swing.JTextField txtFisNo;
    // End of variables declaration//GEN-END:variables
}
