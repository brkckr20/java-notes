package gui.kodlama;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import methods.Kodlama.Depo;

public class DepoKodlama extends javax.swing.JInternalFrame {

    Depo depoMethodlari = new Depo();

    public DepoKodlama() {
        initComponents();
        /* - border kaldırma */
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlButtonGroup = new javax.swing.JPanel();
        btnKaydetDepoKodlama = new javax.swing.JButton();
        btnSilMalzemeGiris = new javax.swing.JButton();
        btnYeniMalzemeGiris = new javax.swing.JButton();
        pnlGovde = new javax.swing.JPanel();
        lblDepoAdi = new javax.swing.JLabel();
        txtDepoAdi = new javax.swing.JTextField();
        lblDepoId = new javax.swing.JLabel();
        lblDepoIdText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDepolar = new javax.swing.JTable();

        btnKaydetDepoKodlama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/save.png"))); // NOI18N
        btnKaydetDepoKodlama.setText("Kaydet");
        btnKaydetDepoKodlama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetDepoKodlamaActionPerformed(evt);
            }
        });

        btnSilMalzemeGiris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Delete.png"))); // NOI18N
        btnSilMalzemeGiris.setText("Sil");
        btnSilMalzemeGiris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilMalzemeGirisActionPerformed(evt);
            }
        });

        btnYeniMalzemeGiris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/File.png"))); // NOI18N
        btnYeniMalzemeGiris.setText("Yeni");
        btnYeniMalzemeGiris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYeniMalzemeGirisActionPerformed(evt);
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
                .addComponent(btnKaydetDepoKodlama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSilMalzemeGiris)
                .addContainerGap(847, Short.MAX_VALUE))
        );
        pnlButtonGroupLayout.setVerticalGroup(
            pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnKaydetDepoKodlama, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnYeniMalzemeGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSilMalzemeGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblDepoAdi.setText("Depo Adı Giriniz : ");

        lblDepoId.setText("Depo Id :");

        lblDepoIdText.setText("0");

        tblDepolar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Depo Adı"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDepolar);

        javax.swing.GroupLayout pnlGovdeLayout = new javax.swing.GroupLayout(pnlGovde);
        pnlGovde.setLayout(pnlGovdeLayout);
        pnlGovdeLayout.setHorizontalGroup(
            pnlGovdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGovdeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGovdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlGovdeLayout.createSequentialGroup()
                        .addComponent(lblDepoAdi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDepoAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblDepoId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDepoIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGovdeLayout.setVerticalGroup(
            pnlGovdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGovdeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGovdeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepoAdi)
                    .addComponent(txtDepoAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDepoId)
                    .addComponent(lblDepoIdText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(369, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlButtonGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlGovde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlButtonGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGovde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetDepoKodlamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetDepoKodlamaActionPerformed
        depoMethodlari.depoKaydet(Integer.parseInt(lblDepoIdText.getText()), txtDepoAdi);
    }//GEN-LAST:event_btnKaydetDepoKodlamaActionPerformed

    private void btnSilMalzemeGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilMalzemeGirisActionPerformed

    }//GEN-LAST:event_btnSilMalzemeGirisActionPerformed

    private void btnYeniMalzemeGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniMalzemeGirisActionPerformed

    }//GEN-LAST:event_btnYeniMalzemeGirisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydetDepoKodlama;
    private javax.swing.JButton btnSilMalzemeGiris;
    private javax.swing.JButton btnYeniMalzemeGiris;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDepoAdi;
    private javax.swing.JLabel lblDepoId;
    private javax.swing.JLabel lblDepoIdText;
    private javax.swing.JPanel pnlButtonGroup;
    private javax.swing.JPanel pnlGovde;
    private javax.swing.JTable tblDepolar;
    private javax.swing.JTextField txtDepoAdi;
    // End of variables declaration//GEN-END:variables
}
