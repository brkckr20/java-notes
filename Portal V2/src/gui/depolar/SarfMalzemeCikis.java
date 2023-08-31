package gui.depolar;

import components.FirmaModal;
import helpers.DbHelper;
import interfaces.FirmaKartiYonetimi;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import models.MSarfMalzemeDepo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import utils.TabloSecilenRengiDegistir;
import methods.SarfMalzemeDepo.Methods;
import java.text.SimpleDateFormat;
import java.util.UUID;
import models.MMalzemeKarti;
import utils.Bildirim;
import utils.GlobalArama;

public class SarfMalzemeCikis extends javax.swing.JInternalFrame implements FirmaKartiYonetimi {

    DefaultTableModel model, modelKartListesi;
    DefaultTableModel model2Kalem;
    Methods methods = new Methods();
    private JComboBox<String> comboBox;
    int kayitNumarasi = 0; // kayit numarası vazgeç tıklandıktan sonra alınacak

    public SarfMalzemeCikis() {
        initComponents();
        /* - border kaldırma */
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        /* - border kaldırma */
        malzemeDepoListesiniTabloyaYansit();
        malzemeKartListesiniTabloyaYansit();
        tabloyaComboboxEkle();
        TabloSecilenRengiDegistir.degistir(tblMalzemeCikis);
        TabloSecilenRengiDegistir.degistir(tblSarfMalzemeDepoDurumu);

    }

    @Override
    public void firmaEkle() {

    }

    @Override
    public void onFirmaSelected(String ulke, String ulke_kodu) {
        txtCariKod.setText(ulke);
        lblFirmaUnvan.setText(ulke_kodu);
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
                    liste.getKalan_miktar(),
                    liste.getBirim(),
                    liste.getUuid()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    public ArrayList<MMalzemeKarti> malzemeKartiListele() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<MMalzemeKarti> malzemeKartiListesi = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM malzeme_kodlama");
            malzemeKartiListesi = new ArrayList<MMalzemeKarti>();
            while (resultSet.next()) {
                malzemeKartiListesi.add(new MMalzemeKarti(
                        resultSet.getInt("id"),
                        resultSet.getString("malzeme_kodu"),
                        resultSet.getString("malzeme_adi"),
                        resultSet.getString("depo_adi"),
                        resultSet.getString("birim"),
                        resultSet.getString("malzeme_marka")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return malzemeKartiListesi;
    }

    public void malzemeKartListesiniTabloyaYansit() {
        model = (DefaultTableModel) tblSMCMalzemeKartiListesi.getModel();
        model.setRowCount(0);
        try {
            ArrayList<MMalzemeKarti> kartListesi = malzemeKartiListele();
            for (MMalzemeKarti liste : kartListesi) {
                Object[] row = {
                    liste.getMalzeme_kodu(),
                    liste.getMalzeme_adi(),
                    liste.getDepo_adi(),
                    liste.getBirim(),
                    liste.getMalzeme_marka()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    public int malzemeDepoCikisSonKayitGetir() {
        model = (DefaultTableModel) tblMalzemeCikis.getModel();
        model.setRowCount(0);
        int sonKayitNo = 0;
        try {
            ArrayList<MSarfMalzemeDepo> sonuc = methods.malzemeDepoCikisSonKayitGetir();
            if (!sonuc.isEmpty()) {
                MSarfMalzemeDepo ilkKayit = sonuc.get(0); // İlk kaydı al
                int kayitNoText = ilkKayit.getId();
                sonKayitNo = kayitNoText;
                lblKayitNoText.setText(Integer.toString(kayitNoText)); // int değeri String olarak dönüştür
                txtCariKod.setText(ilkKayit.getFirma_kodu());
                lblFirmaUnvan.setText(ilkKayit.getFirma_unvan());
                dateIslemTarihi.setDate(ilkKayit.getTarih());
                try {
                    for (MSarfMalzemeDepo liste : sonuc) {
                        Object[] row = {
                            liste.getKalem_islem(),
                            liste.getMalzeme_kodu(),
                            liste.getMalzeme_adi(),
                            liste.getMiktar(),
                            liste.getBirim(),
                            liste.getNot1(),
                            liste.getNot2(),
                            liste.getCikilan_birim(),
                            liste.getTeslim_alan(),
                            liste.getUuid()
                        };
                        model.addRow(row);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("kayit bulunamadı");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sonKayitNo;
    }

    public void malzemeDepoCikisSonrakiKayitGetir(int id) {
        btnGeriMalzemeCikis.setEnabled(true);
        model = (DefaultTableModel) tblMalzemeCikis.getModel();
        model.setRowCount(0);
        try {
            ArrayList<MSarfMalzemeDepo> sonuc = methods.malzemeDepoCikisSonrakiKayitGetir(id);
            if (!sonuc.isEmpty()) {

                if (!sonuc.isEmpty()) {
                    MSarfMalzemeDepo ilkKayit = sonuc.get(0); // İlk kaydı al
                    int kayitNoText = ilkKayit.getId();

                    lblKayitNoText.setText(Integer.toString(kayitNoText)); // int değeri String olarak dönüştür
                    txtCariKod.setText(ilkKayit.getFirma_kodu());
                    lblFirmaUnvan.setText(ilkKayit.getFirma_unvan());
                    dateIslemTarihi.setDate(ilkKayit.getTarih());
                    try {
                        for (MSarfMalzemeDepo liste : sonuc) {
                            Object[] row = {
                                liste.getKalem_islem(),
                                liste.getMalzeme_kodu(),
                                liste.getMalzeme_adi(),
                                liste.getMiktar(),
                                liste.getBirim(),
                                "",
                                "",
                                "",
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
    
    public void malzemeDepoCikisOncekiKayitGetir(int id) {
        btnGeriMalzemeCikis.setEnabled(true);
        model = (DefaultTableModel) tblMalzemeCikis.getModel();
        model.setRowCount(0);
        try {
            ArrayList<MSarfMalzemeDepo> sonuc = methods.malzemeDepoCikisOncekiKayitGetir(id);
            if (!sonuc.isEmpty()) {

                if (!sonuc.isEmpty()) {
                    MSarfMalzemeDepo ilkKayit = sonuc.get(0); // İlk kaydı al
                    int kayitNoText = ilkKayit.getId();

                    lblKayitNoText.setText(Integer.toString(kayitNoText)); // int değeri String olarak dönüştür
                    txtCariKod.setText(ilkKayit.getFirma_kodu());
                    lblFirmaUnvan.setText(ilkKayit.getFirma_unvan());
                    dateIslemTarihi.setDate(ilkKayit.getTarih());
                    try {
                        for (MSarfMalzemeDepo liste : sonuc) {
                            Object[] row = {
                                liste.getKalem_islem(),
                                liste.getMalzeme_kodu(),
                                liste.getMalzeme_adi(),
                                liste.getMiktar(),
                                liste.getBirim(),
                                "",
                                "",
                                "",
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUp = new javax.swing.JPopupMenu();
        popupMenuZimmetYazdir = new javax.swing.JMenuItem();
        pnlButtonGroup = new javax.swing.JPanel();
        btnKaydetMalzemeDepoCikis = new javax.swing.JButton();
        btnGeriMalzemeCikis = new javax.swing.JButton();
        btnIleriMalzemeKarti = new javax.swing.JButton();
        btnSilMalzemeGiris = new javax.swing.JButton();
        btnListeMalzemeGiris = new javax.swing.JButton();
        btnYeniMalzemeGiris = new javax.swing.JButton();
        btnListeMalzemeCikisDepoYenile = new javax.swing.JButton();
        btnListeMalzemeCikisDepoVazgec = new javax.swing.JButton();
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
        tblMalzemeCikis = new javax.swing.JTable();
        pnlHavuzlar = new javax.swing.JPanel();
        tbpHavuzlar = new javax.swing.JTabbedPane();
        pnlSarfMalzemeDepoHavuz = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSarfMalzemeDepoDurumu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSarfMalzemeDepoAra = new javax.swing.JTextField();
        pnlMalzemeKarti = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSMCMalzemeKartiListesi = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSMCMalzemeKartiListesi = new javax.swing.JTable();
        lblKayitNo = new javax.swing.JLabel();
        lblKayitNoText = new javax.swing.JLabel();

        popUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                popUpMouseReleased(evt);
            }
        });

        popupMenuZimmetYazdir.setText("Zimmet Formu Yazdır");
        popUp.add(popupMenuZimmetYazdir);

        btnKaydetMalzemeDepoCikis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/save.png"))); // NOI18N
        btnKaydetMalzemeDepoCikis.setText("Kaydet");
        btnKaydetMalzemeDepoCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetMalzemeDepoCikisActionPerformed(evt);
            }
        });

        btnGeriMalzemeCikis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Back Arrow.png"))); // NOI18N
        btnGeriMalzemeCikis.setText("Geri");
        btnGeriMalzemeCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeriMalzemeCikisActionPerformed(evt);
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

        btnListeMalzemeCikisDepoVazgec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Cancel.png"))); // NOI18N
        btnListeMalzemeCikisDepoVazgec.setText("Vazgeç");
        btnListeMalzemeCikisDepoVazgec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListeMalzemeCikisDepoVazgecActionPerformed(evt);
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
                .addComponent(btnKaydetMalzemeDepoCikis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGeriMalzemeCikis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIleriMalzemeKarti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListeMalzemeCikisDepoVazgec)
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
                .addComponent(btnKaydetMalzemeDepoCikis, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnYeniMalzemeGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnGeriMalzemeCikis, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnIleriMalzemeKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSilMalzemeGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnListeMalzemeGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnListeMalzemeCikisDepoYenile, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnListeMalzemeCikisDepoVazgec, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMainForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlMainFormMouseReleased(evt);
            }
        });

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

        tblMalzemeCikis.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMalzemeCikis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMalzemeCikisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMalzemeCikis);

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
        tblSarfMalzemeDepoDurumu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSarfMalzemeDepoDurumuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSarfMalzemeDepoDurumu);

        jLabel1.setText("Arama İfadesi : ");

        txtSarfMalzemeDepoAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSarfMalzemeDepoAraKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlSarfMalzemeDepoHavuzLayout = new javax.swing.GroupLayout(pnlSarfMalzemeDepoHavuz);
        pnlSarfMalzemeDepoHavuz.setLayout(pnlSarfMalzemeDepoHavuzLayout);
        pnlSarfMalzemeDepoHavuzLayout.setHorizontalGroup(
            pnlSarfMalzemeDepoHavuzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSarfMalzemeDepoHavuzLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSarfMalzemeDepoAra, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 151, Short.MAX_VALUE))
        );
        pnlSarfMalzemeDepoHavuzLayout.setVerticalGroup(
            pnlSarfMalzemeDepoHavuzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSarfMalzemeDepoHavuzLayout.createSequentialGroup()
                .addGroup(pnlSarfMalzemeDepoHavuzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSarfMalzemeDepoHavuzLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtSarfMalzemeDepoAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 54, Short.MAX_VALUE))
        );

        tbpHavuzlar.addTab("Sarf Malzeme Depo", pnlSarfMalzemeDepoHavuz);

        pnlMalzemeKarti.setPreferredSize(new java.awt.Dimension(1106, 216));

        jLabel2.setText("Arama İfadesi :");

        txtSMCMalzemeKartiListesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSMCMalzemeKartiListesiKeyReleased(evt);
            }
        });

        tblSMCMalzemeKartiListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Malzeme Kodu", "Malzeme Adı", "Depo Adı", "Birim"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSMCMalzemeKartiListesi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSMCMalzemeKartiListesiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSMCMalzemeKartiListesi);

        javax.swing.GroupLayout pnlMalzemeKartiLayout = new javax.swing.GroupLayout(pnlMalzemeKarti);
        pnlMalzemeKarti.setLayout(pnlMalzemeKartiLayout);
        pnlMalzemeKartiLayout.setHorizontalGroup(
            pnlMalzemeKartiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMalzemeKartiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMalzemeKartiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
                    .addGroup(pnlMalzemeKartiLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSMCMalzemeKartiListesi)))
                .addContainerGap())
        );
        pnlMalzemeKartiLayout.setVerticalGroup(
            pnlMalzemeKartiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMalzemeKartiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMalzemeKartiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSMCMalzemeKartiListesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbpHavuzlar.addTab("Malzeme Kartı Listesi", pnlMalzemeKarti);

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
            .addGroup(pnlHavuzlarLayout.createSequentialGroup()
                .addComponent(tbpHavuzlar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblKayitNo.setText("Kayıt No :");

        lblKayitNoText.setText("0");

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
                                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlMainFormLayout.createSequentialGroup()
                                        .addComponent(btnFirmaSec)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblFirmaUnvan, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlMainFormLayout.createSequentialGroup()
                                        .addComponent(lblKayitNo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblKayitNoText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        pnlMainFormLayout.setVerticalGroup(
            pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblKayitNo)
                        .addComponent(lblKayitNoText))
                    .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFisNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFisNo)))
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
                .addComponent(pnlMainForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetMalzemeDepoCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetMalzemeDepoCikisActionPerformed
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statementTablo1 = null;
        PreparedStatement statementTablo2 = null;
        ResultSet generatedKeys = null;
        java.util.Date talepTarihiDate = dateIslemTarihi.getDate();
        DateFormat tarihFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (Integer.parseInt(lblKayitNoText.getText()) == 0) {
            try {
                connection = dbHelper.getConnection();
                connection.setAutoCommit(false);
                String sqlTablo1 = "INSERT INTO sarf_malzeme_depo1 (islem_cinsi, firma_kodu, firma_unvan,tarih) VALUES (?, ?, ?, ?)";
                statementTablo1 = connection.prepareStatement(sqlTablo1, Statement.RETURN_GENERATED_KEYS);
                statementTablo1.setString(1, txtFisNo.getText());
                statementTablo1.setString(2, txtCariKod.getText());
                statementTablo1.setString(3, lblFirmaUnvan.getText());
                statementTablo1.setString(4, tarihFormat.format(talepTarihiDate));
                statementTablo1.executeUpdate();
                generatedKeys = statementTablo1.getGeneratedKeys();
                int tablo1Id = -1;
                if (generatedKeys.next()) {
                    tablo1Id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Tablo1'e veri eklenirken bir hata oluştu, id alınamadı.");
                }

                int rowCount = model2Kalem.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    String kalem_islem = (String) model2Kalem.getValueAt(i, 0);
                    String malzeme_kodu = (String) model2Kalem.getValueAt(i, 1);
                    String malzeme_adi = (String) model2Kalem.getValueAt(i, 2);
                    int miktar = (int) model2Kalem.getValueAt(i, 3);
                    String birim = (String) model2Kalem.getValueAt(i, 4);
                    String not1 = (String) model2Kalem.getValueAt(i, 5);
                    String not2 = (String) model2Kalem.getValueAt(i, 6);
                    String cikilan_birim = (String) model2Kalem.getValueAt(i, 7);
                    String teslim_alan = (String) model2Kalem.getValueAt(i, 8);
                    String uuidString = (String) model2Kalem.getValueAt(i, 9); // UUID değerini String olarak al
                    UUID uuid = UUID.fromString(uuidString); // String'den UUID'ye dönüştür
                    String sqlTablo2 = "INSERT INTO sarf_malzeme_depo2 (kalem_islem, malzeme_kodu, malzeme_adi, miktar, birim, refNoId, uuid ,not1, not2, cikilan_birim, teslim_alan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    statementTablo2 = connection.prepareStatement(sqlTablo2);
                    statementTablo2.setString(1, kalem_islem);
                    statementTablo2.setString(2, malzeme_kodu);
                    statementTablo2.setString(3, malzeme_adi);
                    statementTablo2.setInt(4, miktar);
                    statementTablo2.setString(5, birim);
                    statementTablo2.setInt(6, tablo1Id);
                    statementTablo2.setString(7, uuid.toString());
                    statementTablo2.setString(8, not1);
                    statementTablo2.setString(9, not2);
                    statementTablo2.setString(10, cikilan_birim);
                    statementTablo2.setString(11, teslim_alan);
                    statementTablo2.executeUpdate();
                }
                connection.commit();
                Bildirim.basarili("Veritabanına kayıt işlemi başarıyla gerçekleştirildi");
                malzemeDepoListesiniTabloyaYansit();
            } catch (SQLException ex) {
                System.out.println("hata mesajı" + ex.getMessage());
            }
        } else {

            try {
                connection = dbHelper.getConnection();
                connection.setAutoCommit(false);
                String sqlTablo1 = "UPDATE sarf_malzeme_depo1 SET tarih = ? , firma_kodu = ? , firma_unvan = ? where id = ?";
                statementTablo1 = connection.prepareStatement(sqlTablo1);
                statementTablo1.setString(1, tarihFormat.format(talepTarihiDate));
                statementTablo1.setString(2, txtCariKod.getText());
                statementTablo1.setString(3, lblFirmaUnvan.getText());
                statementTablo1.setInt(4, Integer.parseInt(lblKayitNoText.getText()));
                statementTablo1.executeUpdate();
                int rowCount = model.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    String kalemIslem = (String) model.getValueAt(i, 0);
                    String malzemeKodu = (String) model.getValueAt(i, 1);
                    String malzemeAdi = (String) model.getValueAt(i, 2);
                    int miktar = (int) model.getValueAt(i, 3);
                    String not1 = (String) model.getValueAt(i, 5);
                    String not2 = (String) model.getValueAt(i, 6);
                    String cikilan_birim = (String) model.getValueAt(i, 7);
                    String teslim_alan = (String) model.getValueAt(i, 8);
                    String uuid = (String) model.getValueAt(i, 9);
                    tblMalzemeCikis.repaint();
                    String sqlTablo2 = "UPDATE sarf_malzeme_depo2 SET kalem_islem = ?, malzeme_kodu = ?, malzeme_adi = ?, miktar = ?,not1=?,not2=?,cikilan_birim=?,teslim_alan=? WHERE uuid = ?";
                    statementTablo2 = connection.prepareStatement(sqlTablo2);
                    statementTablo2.setString(1, kalemIslem);
                    statementTablo2.setString(2, malzemeKodu);
                    statementTablo2.setString(3, malzemeAdi);
                    statementTablo2.setInt(4, miktar);
                    statementTablo2.setString(5, not1);
                    statementTablo2.setString(6, not2);
                    statementTablo2.setString(7, cikilan_birim);
                    statementTablo2.setString(8, teslim_alan);
                    statementTablo2.setString(9, uuid);

                    int affectedRows = statementTablo2.executeUpdate();
                    System.out.println("Affected Rows: " + affectedRows);

                    if (affectedRows > 0) {
                        model.setValueAt(kalemIslem, i, 0);
                        model.setValueAt(malzemeKodu, i, 1);
                        model.setValueAt(malzemeAdi, i, 2);
                        model.setValueAt(miktar, i, 3);
                        model.setValueAt(uuid, i, 6);
                    }
                }
                connection.commit();
                Bildirim.basarili("Veriler başarıyla veritabanına kaydedildi.");
                malzemeDepoListesiniTabloyaYansit();
            } catch (SQLException ex) {
                System.out.println("hata mesajı update" + ex.getMessage());

            }

        }
    }//GEN-LAST:event_btnKaydetMalzemeDepoCikisActionPerformed

    private void btnGeriMalzemeCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeriMalzemeCikisActionPerformed
        int kayitNo = Integer.parseInt(lblKayitNoText.getText());
        malzemeDepoCikisOncekiKayitGetir(kayitNo);
    }//GEN-LAST:event_btnGeriMalzemeCikisActionPerformed

    private void btnIleriMalzemeKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIleriMalzemeKartiActionPerformed
        int kayitNo = Integer.parseInt(lblKayitNoText.getText());
        malzemeDepoCikisSonrakiKayitGetir(kayitNo);
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
        FirmaModal firmaModal = new FirmaModal(null, true);
        firmaModal.setSelectionListener(this);
        firmaModal.setVisible(true);
    }//GEN-LAST:event_btnFirmaSecActionPerformed

    private void tblMalzemeCikisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMalzemeCikisMouseClicked

        if (evt.getClickCount() == 1) {
            int column = tblMalzemeCikis.columnAtPoint(evt.getPoint());
            int row = tblMalzemeCikis.rowAtPoint(evt.getPoint());

            if (column != 1) {
                return;
            }

            Object cellValue = tblMalzemeCikis.getValueAt(row, column);

            if (cellValue != null) {
                //     MalzemeKoduModal malzemeKoduModal = new MalzemeKoduModal(null, true);
                //    malzemeKoduModal.setSelectionListener(this);
                //    malzemeKoduModal.setVisible(true);

            }
        }
    }//GEN-LAST:event_tblMalzemeCikisMouseClicked

    private void btnListeMalzemeCikisDepoYenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListeMalzemeCikisDepoYenileActionPerformed
        malzemeDepoListesiniTabloyaYansit();
    }//GEN-LAST:event_btnListeMalzemeCikisDepoYenileActionPerformed

    private void tblSarfMalzemeDepoDurumuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSarfMalzemeDepoDurumuMouseClicked
        model = (DefaultTableModel) tblSarfMalzemeDepoDurumu.getModel();
        model2Kalem = (DefaultTableModel) tblMalzemeCikis.getModel();

        if (evt.getClickCount() == 2) {
            int row = tblSarfMalzemeDepoDurumu.getSelectedRow();

            if (row != -1) {
                String malzeme_kodu = (String) tblSarfMalzemeDepoDurumu.getValueAt(row, 0);
                String malzeme_adi = (String) tblSarfMalzemeDepoDurumu.getValueAt(row, 1);
                String birim = (String) tblSarfMalzemeDepoDurumu.getValueAt(row, 3);
                String uuid = (String) tblSarfMalzemeDepoDurumu.getValueAt(row, 4);

                model2Kalem.addRow(new Object[]{"", malzeme_kodu, malzeme_adi, "", birim, "", "", "", "", uuid});
            }
        }
    }//GEN-LAST:event_tblSarfMalzemeDepoDurumuMouseClicked

    private void txtSarfMalzemeDepoAraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSarfMalzemeDepoAraKeyReleased
        GlobalArama.ara(txtSarfMalzemeDepoAra, model, tblSarfMalzemeDepoDurumu);
    }//GEN-LAST:event_txtSarfMalzemeDepoAraKeyReleased

    private void btnListeMalzemeCikisDepoVazgecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListeMalzemeCikisDepoVazgecActionPerformed
        int gelenSonKayitNo = malzemeDepoCikisSonKayitGetir();
        kayitNumarasi = gelenSonKayitNo;
      //  btnIleriMalzemeKarti.setEnabled(false);
    }//GEN-LAST:event_btnListeMalzemeCikisDepoVazgecActionPerformed

    private void pnlMainFormMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainFormMouseReleased
        if (evt.isPopupTrigger()) {
            popUp.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_pnlMainFormMouseReleased

    private void popUpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_popUpMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_popUpMouseReleased

    private void txtSMCMalzemeKartiListesiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSMCMalzemeKartiListesiKeyReleased
        GlobalArama.ara(txtSMCMalzemeKartiListesi, modelKartListesi, tblSMCMalzemeKartiListesi);
    }//GEN-LAST:event_txtSMCMalzemeKartiListesiKeyReleased

    private void tblSMCMalzemeKartiListesiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSMCMalzemeKartiListesiMouseClicked
        model2Kalem = (DefaultTableModel) tblMalzemeCikis.getModel();
        if (evt.getClickCount() == 2) {
            int row = tblSMCMalzemeKartiListesi.getSelectedRow();

            if (row != -1) {
                String malzeme_kodu = (String) tblSMCMalzemeKartiListesi.getValueAt(row, 0);
                String malzeme_adi = (String) tblSMCMalzemeKartiListesi.getValueAt(row, 1);
                String birim = (String) tblSMCMalzemeKartiListesi.getValueAt(row, 3);
                UUID uuid = UUID.randomUUID();
                model2Kalem.addRow(new Object[]{"", malzeme_kodu, malzeme_adi, "", birim, "DOLUM / TAMİR İÇİN SEVK", "", "", "", uuid.toString()});
            }
        }
    }//GEN-LAST:event_tblSMCMalzemeKartiListesiMouseClicked

    private void tabloyaComboboxEkle() {
        comboBox = new JComboBox<>();
        comboBox.addItem("KURUMA ÇIKIŞ");
        comboBox.addItem("DOLUMA ÇIKIŞ");
        comboBox.addItem("TAMİRE ÇIKIŞ");
        comboBox.addItem("STOK DÜZELTME");
        comboBox.addItem("DEMİRBAŞ ÇIKIŞ");
        tblMalzemeCikis.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox));
        model = (DefaultTableModel) tblMalzemeCikis.getModel();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirmaSec;
    private javax.swing.JButton btnGeriMalzemeCikis;
    private javax.swing.JButton btnIleriMalzemeKarti;
    private javax.swing.JButton btnKaydetMalzemeDepoCikis;
    private javax.swing.JButton btnListeMalzemeCikisDepoVazgec;
    private javax.swing.JButton btnListeMalzemeCikisDepoYenile;
    private javax.swing.JButton btnListeMalzemeGiris;
    private javax.swing.JButton btnSilMalzemeGiris;
    private javax.swing.JButton btnYeniMalzemeGiris;
    private com.toedter.calendar.JDateChooser dateIslemTarihi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFirmaKod;
    private javax.swing.JLabel lblFirmaUnvan;
    private javax.swing.JLabel lblFisNo;
    private javax.swing.JLabel lblKayitNo;
    private javax.swing.JLabel lblKayitNoText;
    private javax.swing.JLabel lblTarih;
    private javax.swing.JPanel pnlButtonGroup;
    private javax.swing.JPanel pnlHavuzlar;
    private javax.swing.JPanel pnlMainForm;
    private javax.swing.JPanel pnlMalzemeKarti;
    private javax.swing.JPanel pnlSarfMalzemeDepoHavuz;
    private javax.swing.JPopupMenu popUp;
    private javax.swing.JMenuItem popupMenuZimmetYazdir;
    private javax.swing.JTable tblMalzemeCikis;
    private javax.swing.JTable tblSMCMalzemeKartiListesi;
    private javax.swing.JTable tblSarfMalzemeDepoDurumu;
    private javax.swing.JTabbedPane tbpHavuzlar;
    private javax.swing.JTextField txtCariKod;
    private javax.swing.JTextField txtFisNo;
    private javax.swing.JTextField txtSMCMalzemeKartiListesi;
    private javax.swing.JTextField txtSarfMalzemeDepoAra;
    // End of variables declaration//GEN-END:variables

}
