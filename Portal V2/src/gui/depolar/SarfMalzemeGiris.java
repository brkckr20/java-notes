package gui.depolar;

import components.MalzemeKoduModal;
import components.UlkeModal;
import helpers.DbHelper;
import interfaces.FirmaKartiYonetimi;
import interfaces.MalzemeKartiYonetimi;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.util.UUID;


public class SarfMalzemeGiris extends javax.swing.JInternalFrame implements MalzemeKartiYonetimi, FirmaKartiYonetimi{

    private DefaultTableModel model;
    private JComboBox<String> comboBox;
    
    @Override
    public void onMalzemeSelected(String malzemeKodu, String malzemeAdi) {
        int selectedRow = tblMalzemeGiris.getSelectedRow();
        if (selectedRow != -1) {
            // Seçilen satırın 2. hücresine malzeme kodunu, 3. hücresine malzeme adını yazdırın
            tblMalzemeGiris.setValueAt(malzemeKodu, selectedRow, 1);
            tblMalzemeGiris.setValueAt(malzemeAdi, selectedRow, 2);
        }
    }
    
    @Override
    public void onFirmaSelected(String ulke, String ulke_kodu) {
        txtCariKod.setText(ulke);
        lblFirmaUnvan.setText(ulke_kodu);
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

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlButtonGroup = new javax.swing.JPanel();
        btnKaydetMalzemeKarti = new javax.swing.JButton();
        pnlMainForm = new javax.swing.JPanel();
        txtFisNo = new javax.swing.JTextField();
        lblFisNo = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
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

        btnKaydetMalzemeKarti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/save.png"))); // NOI18N
        btnKaydetMalzemeKarti.setText("Kaydet");
        btnKaydetMalzemeKarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetMalzemeKartiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonGroupLayout = new javax.swing.GroupLayout(pnlButtonGroup);
        pnlButtonGroup.setLayout(pnlButtonGroupLayout);
        pnlButtonGroupLayout.setHorizontalGroup(
            pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonGroupLayout.createSequentialGroup()
                .addComponent(btnKaydetMalzemeKarti)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlButtonGroupLayout.setVerticalGroup(
            pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnKaydetMalzemeKarti, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        txtFisNo.setEditable(false);
        txtFisNo.setText("SARF_MALZEME_GIRIS");

        lblFisNo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFisNo.setText("İşlem Cinsi");

        jDateChooser1.setDateFormatString("dd.MM.yyyy");

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
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFisNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFirmaSec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFirmaUnvan, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(lblFisNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
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
        try {
            connection = dbHelper.getConnection();
            connection.setAutoCommit(false);
            String sqlTablo1 = "INSERT INTO sarf_malzeme_depo1 (islem_cinsi,firma_kodu) VALUES (?, ?)";
            statementTablo1 = connection.prepareStatement(sqlTablo1, Statement.RETURN_GENERATED_KEYS);
            statementTablo1.setString(1, txtFisNo.getText());
            statementTablo1.setString(2, txtCariKod.getText());
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

                String sql = "INSERT INTO sarf_malzeme_depo2 (kalem_islem, malzeme_kodu, malzeme_adi, miktar, birim,refNoId,uuid) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
    }//GEN-LAST:event_btnKaydetMalzemeKartiActionPerformed

    private void btnYeniSatirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniSatirActionPerformed
        UUID uuid = UUID.randomUUID();
        Object[] newRow = {"Seç", "", "", "", "Seç", "", uuid.toString()};
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
        UlkeModal ulkeModal = new UlkeModal(null, true);
        ulkeModal.setSelectionListener(this);
        ulkeModal.setVisible(true);
    }//GEN-LAST:event_btnFirmaSecActionPerformed

    private void initTable() {
        comboBox = new JComboBox<>();
        comboBox.addItem("GİRİŞ");
        comboBox.addItem("TAMİR GİRİŞ");
        comboBox.addItem("DOLUM");
        comboBox.addItem("SATIN ALMA");
        tblMalzemeGiris.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox));
        model = (DefaultTableModel) tblMalzemeGiris.getModel();
        birimiSetle();
    }

    private void birimiSetle() {
        comboBox = new JComboBox<>();
        comboBox.addItem("ADET");
        comboBox.addItem("SET");
        comboBox.addItem("METRE");
        comboBox.addItem("KİLOGRAM");
        tblMalzemeGiris.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboBox));
        model = (DefaultTableModel) tblMalzemeGiris.getModel();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirmaSec;
    private javax.swing.JButton btnKaydetMalzemeKarti;
    private javax.swing.JButton btnYeniSatir;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBelgeNo;
    private javax.swing.JLabel lblFirmaKod;
    private javax.swing.JLabel lblFirmaUnvan;
    private javax.swing.JLabel lblFisNo;
    private javax.swing.JLabel lblTarih;
    private javax.swing.JPanel pnlButtonGroup;
    private javax.swing.JPanel pnlMainForm;
    private javax.swing.JTable tblMalzemeGiris;
    private javax.swing.JTextField txtBelgeNo;
    private javax.swing.JTextField txtCariKod;
    private javax.swing.JTextField txtFisNo;
    // End of variables declaration//GEN-END:variables
}
