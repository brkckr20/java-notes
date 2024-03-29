package components;

import interfaces.MalzemeDepoYonetimi;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.MSarfMalzemeDepo;
import methods.Liste.ListeIslemleri;
import utils.GlobalArama;

public class ListeModal extends javax.swing.JDialog {

    DefaultTableModel model;
    ListeIslemleri listeIslemleri = new ListeIslemleri();
    private MalzemeDepoYonetimi selectionListener;

    public void setSelectionListener(MalzemeDepoYonetimi listener) {
        this.selectionListener = listener;
    }

    public ListeModal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        malzemeGirisListeYansit();
    }

    public void malzemeGirisListeYansit() {
        model = (DefaultTableModel) tblSarfMalzemeGiris.getModel();
        model.setRowCount(0);
        try {
            ArrayList<MSarfMalzemeDepo> malzemeDepoListe = listeIslemleri.malzemeDepoGirisListe();
            for (MSarfMalzemeDepo liste : malzemeDepoListe) {
                Object[] row = {
                    liste.getId(),
                    liste.getTarih(),
                    liste.getFirma_kodu(),
                    liste.getFirma_unvan(),
                    liste.getFatura_no(),
                    liste.getKalem_islem(),
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSearchBar = new javax.swing.JPanel();
        lblAramaIfadesi = new javax.swing.JLabel();
        txtListeAramaIfadesi = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSarfMalzemeGiris = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sarf Malzeme Giriş Liste");

        lblAramaIfadesi.setText("Arama İfadesi : ");

        txtListeAramaIfadesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtListeAramaIfadesiKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchBarLayout = new javax.swing.GroupLayout(pnlSearchBar);
        pnlSearchBar.setLayout(pnlSearchBarLayout);
        pnlSearchBarLayout.setHorizontalGroup(
            pnlSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAramaIfadesi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtListeAramaIfadesi)
                .addContainerGap())
        );
        pnlSearchBarLayout.setVerticalGroup(
            pnlSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAramaIfadesi)
                    .addComponent(txtListeAramaIfadesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tblSarfMalzemeGiris.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tarih", "Firma Kodu", "Firma Unvan", "Fatura No", "Kalem İşlem", "Malzeme Kodu", "Malzeme Adı", "Miktar", "Birim", "Uuid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSarfMalzemeGiris.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSarfMalzemeGirisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSarfMalzemeGiris);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSearchBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblSarfMalzemeGirisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSarfMalzemeGirisMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblSarfMalzemeGiris.getSelectedRow();
            int id = (int) tblSarfMalzemeGiris.getValueAt(row, 0);
            Date tarih = (Date) tblSarfMalzemeGiris.getValueAt(row, 1);
            String firma_kodu = (String) tblSarfMalzemeGiris.getValueAt(row, 2);
            String firma_unvan = (String) tblSarfMalzemeGiris.getValueAt(row, 3);
            String fatura_no = (String) tblSarfMalzemeGiris.getValueAt(row, 4);
            List<Object[]> selectedRowData = new ArrayList<>();
            for (int i = 0; i < tblSarfMalzemeGiris.getRowCount(); i++) {
                int currentId = (int) tblSarfMalzemeGiris.getValueAt(i, 0);
                if (currentId == id) {
                    String kalemIslem = (String) tblSarfMalzemeGiris.getValueAt(i, 5);
                    String malzemeKodu = (String) tblSarfMalzemeGiris.getValueAt(i, 6);
                    String malzemeAdi = (String) tblSarfMalzemeGiris.getValueAt(i, 7);

                    int miktar = (int) tblSarfMalzemeGiris.getValueAt(i, 8);
                    String birim = (String) tblSarfMalzemeGiris.getValueAt(i, 9);
                    String uuid = (String) tblSarfMalzemeGiris.getValueAt(i, 10);
                    Object[] rowData = new Object[]{
                        kalemIslem, malzemeKodu, malzemeAdi, miktar, birim, uuid
                    };
                    selectedRowData.add(rowData);
                }
            }
            if (selectionListener != null) {
                selectionListener.onSarfMalzemeGirisListeSelected(id, tarih, fatura_no, firma_kodu, firma_unvan, (ArrayList<Object[]>) selectedRowData);
            }

            this.dispose();
        }
    }//GEN-LAST:event_tblSarfMalzemeGirisMouseClicked

    private void txtListeAramaIfadesiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtListeAramaIfadesiKeyReleased
        GlobalArama.ara(txtListeAramaIfadesi, model, tblSarfMalzemeGiris);
    }//GEN-LAST:event_txtListeAramaIfadesiKeyReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListeModal dialog = new ListeModal(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAramaIfadesi;
    private javax.swing.JPanel pnlSearchBar;
    private javax.swing.JTable tblSarfMalzemeGiris;
    private javax.swing.JTextField txtListeAramaIfadesi;
    // End of variables declaration//GEN-END:variables
}
