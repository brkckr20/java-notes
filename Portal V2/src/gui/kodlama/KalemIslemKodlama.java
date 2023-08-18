
package gui.kodlama;

import javax.swing.plaf.basic.BasicInternalFrameUI;

public class KalemIslemKodlama extends javax.swing.JInternalFrame {

    public KalemIslemKodlama() {
        initComponents();
        /* - border kaldırma */
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
         /* - border kaldırma */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlButtonGroup = new javax.swing.JPanel();
        btnKaydetMalzemeDepoCikis = new javax.swing.JButton();
        btnGeriMalzemeKarti = new javax.swing.JButton();
        btnIleriMalzemeKarti = new javax.swing.JButton();
        btnSilMalzemeGiris = new javax.swing.JButton();
        btnListeMalzemeGiris = new javax.swing.JButton();
        btnYeniMalzemeGiris = new javax.swing.JButton();
        btnListeMalzemeCikisDepoYenile = new javax.swing.JButton();
        btnListeMalzemeCikisDepoVazgec = new javax.swing.JButton();

        btnKaydetMalzemeDepoCikis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/save.png"))); // NOI18N
        btnKaydetMalzemeDepoCikis.setText("Kaydet");
        btnKaydetMalzemeDepoCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetMalzemeDepoCikisActionPerformed(evt);
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
                .addComponent(btnGeriMalzemeKarti)
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
                .addComponent(btnGeriMalzemeKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnIleriMalzemeKarti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSilMalzemeGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnListeMalzemeGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnListeMalzemeCikisDepoYenile, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnListeMalzemeCikisDepoVazgec, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlButtonGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlButtonGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(590, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetMalzemeDepoCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetMalzemeDepoCikisActionPerformed

    }//GEN-LAST:event_btnKaydetMalzemeDepoCikisActionPerformed

    private void btnGeriMalzemeKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeriMalzemeKartiActionPerformed

    }//GEN-LAST:event_btnGeriMalzemeKartiActionPerformed

    private void btnIleriMalzemeKartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIleriMalzemeKartiActionPerformed

    }//GEN-LAST:event_btnIleriMalzemeKartiActionPerformed

    private void btnSilMalzemeGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilMalzemeGirisActionPerformed

    }//GEN-LAST:event_btnSilMalzemeGirisActionPerformed

    private void btnListeMalzemeGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListeMalzemeGirisActionPerformed

    }//GEN-LAST:event_btnListeMalzemeGirisActionPerformed

    private void btnYeniMalzemeGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYeniMalzemeGirisActionPerformed
    /*    try {
            methods.malzemeDepoListele();
        } catch (SQLException ex) {
            Logger.getLogger(SarfMalzemeCikis.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SarfMalzemeCikis.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_btnYeniMalzemeGirisActionPerformed

    private void btnListeMalzemeCikisDepoYenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListeMalzemeCikisDepoYenileActionPerformed
        //malzemeDepoListesiniTabloyaYansit();
    }//GEN-LAST:event_btnListeMalzemeCikisDepoYenileActionPerformed

    private void btnListeMalzemeCikisDepoVazgecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListeMalzemeCikisDepoVazgecActionPerformed
       // malzemeDepoCikisSonKayitGetir();
    }//GEN-LAST:event_btnListeMalzemeCikisDepoVazgecActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGeriMalzemeKarti;
    private javax.swing.JButton btnIleriMalzemeKarti;
    private javax.swing.JButton btnKaydetMalzemeDepoCikis;
    private javax.swing.JButton btnListeMalzemeCikisDepoVazgec;
    private javax.swing.JButton btnListeMalzemeCikisDepoYenile;
    private javax.swing.JButton btnListeMalzemeGiris;
    private javax.swing.JButton btnSilMalzemeGiris;
    private javax.swing.JButton btnYeniMalzemeGiris;
    private javax.swing.JPanel pnlButtonGroup;
    // End of variables declaration//GEN-END:variables
}
