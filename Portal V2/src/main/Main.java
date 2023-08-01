package main;

import gui.depolar.SarfMalzemeGiris;
import gui.kartlar.FirmaKarti;
import gui.kartlar.SarfMalzemeKarti;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main extends javax.swing.JFrame {

    public Main() {

        initComponents();
        setLogo();
    }

    public void setLogo() {
        ImageIcon img;
        img = new ImageIcon("C:\\Users\\BILGIISLEM\\Desktop\\New Folder\\udemy\\Portal V2\\src\\assets\\logo.png");
        this.setIconImage(img.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbp1 = new javax.swing.JTabbedPane();
        MainMenu = new javax.swing.JMenuBar();
        menuAyarlar = new javax.swing.JMenu();
        menuAyarlarSirketBilgileri = new javax.swing.JMenuItem();
        menuKartTanimlamalari = new javax.swing.JMenu();
        menuSarfMalzemeKartlari = new javax.swing.JMenuItem();
        menuFirmaKartlari = new javax.swing.JMenuItem();
        menuSarfMalzemeDepo = new javax.swing.JMenu();
        menuSarfMalzemeDepoGiris = new javax.swing.JMenuItem();
        menuSarfMalzemeDepoCikis = new javax.swing.JMenuItem();
        menuTeknikDestek = new javax.swing.JMenu();
        menuTeknikDestekYeniKayit = new javax.swing.JMenuItem();
        menuTeknikDestekMevcutTalepListesi = new javax.swing.JMenuItem();
        menuTeknikDestekTamamlanmisTalepler = new javax.swing.JMenuItem();
        menuKodlama = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stok Takip Programı [Portal v.2.0.0]");
        setBackground(new java.awt.Color(255, 255, 255));
        setName("MainFrame"); // NOI18N

        menuAyarlar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/settings.png"))); // NOI18N
        menuAyarlar.setText("Ayarlar");

        menuAyarlarSirketBilgileri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/settings.png"))); // NOI18N
        menuAyarlarSirketBilgileri.setText("Şirket Bilgileri");
        menuAyarlar.add(menuAyarlarSirketBilgileri);

        MainMenu.add(menuAyarlar);

        menuKartTanimlamalari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/cards.png"))); // NOI18N
        menuKartTanimlamalari.setText("Kart Tanımlamaları");

        menuSarfMalzemeKartlari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/cards.png"))); // NOI18N
        menuSarfMalzemeKartlari.setText("Sarf Malzeme Kartları");
        menuSarfMalzemeKartlari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSarfMalzemeKartlariActionPerformed(evt);
            }
        });
        menuKartTanimlamalari.add(menuSarfMalzemeKartlari);

        menuFirmaKartlari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/cards.png"))); // NOI18N
        menuFirmaKartlari.setText("Firma Kartları");
        menuFirmaKartlari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFirmaKartlariActionPerformed(evt);
            }
        });
        menuKartTanimlamalari.add(menuFirmaKartlari);

        MainMenu.add(menuKartTanimlamalari);

        menuSarfMalzemeDepo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/package.png"))); // NOI18N
        menuSarfMalzemeDepo.setText("Sarf Malzeme Depo");

        menuSarfMalzemeDepoGiris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/package.png"))); // NOI18N
        menuSarfMalzemeDepoGiris.setText("Sarf Malzeme Depo Giriş");
        menuSarfMalzemeDepoGiris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSarfMalzemeDepoGirisActionPerformed(evt);
            }
        });
        menuSarfMalzemeDepo.add(menuSarfMalzemeDepoGiris);

        menuSarfMalzemeDepoCikis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/package.png"))); // NOI18N
        menuSarfMalzemeDepoCikis.setText("Sarf Malzeme Depo Çıkış");
        menuSarfMalzemeDepo.add(menuSarfMalzemeDepoCikis);

        MainMenu.add(menuSarfMalzemeDepo);

        menuTeknikDestek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/teknikdestek.png"))); // NOI18N
        menuTeknikDestek.setText("Teknik Destek");

        menuTeknikDestekYeniKayit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/teknikdestek.png"))); // NOI18N
        menuTeknikDestekYeniKayit.setText("Yeni Talep Girişi");
        menuTeknikDestek.add(menuTeknikDestekYeniKayit);

        menuTeknikDestekMevcutTalepListesi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/teknikdestek.png"))); // NOI18N
        menuTeknikDestekMevcutTalepListesi.setText("Mevcut Talep Listesi");
        menuTeknikDestek.add(menuTeknikDestekMevcutTalepListesi);

        menuTeknikDestekTamamlanmisTalepler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/teknikdestek.png"))); // NOI18N
        menuTeknikDestekTamamlanmisTalepler.setText("Tamamlanmış Talepler");
        menuTeknikDestek.add(menuTeknikDestekTamamlanmisTalepler);

        MainMenu.add(menuTeknikDestek);

        menuKodlama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/code.png"))); // NOI18N
        menuKodlama.setText("Kodlama");
        MainMenu.add(menuKodlama);

        setJMenuBar(MainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbp1, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbp1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSarfMalzemeKartlariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSarfMalzemeKartlariActionPerformed
        SarfMalzemeKarti smk = new SarfMalzemeKarti();
        smk.setClosable(false);
        String tabTitle = "Malzeme Kartı" + " " + " ";
        tbp1.addTab(tabTitle, smk);

        // Sekmeye çarpı simgesi ekle
        int tabCount = tbp1.getTabCount();
        tbp1.setTabComponentAt(tabCount - 1, new components.ButtonTabComponent(tbp1));

        // Yeni oluşturulan sekmeyi seçin
        tbp1.setSelectedIndex(tabCount - 1);
    }//GEN-LAST:event_menuSarfMalzemeKartlariActionPerformed

    private void menuSarfMalzemeDepoGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSarfMalzemeDepoGirisActionPerformed
        SarfMalzemeGiris smg = new SarfMalzemeGiris();
        smg.setClosable(false);
        String tabTitle = "Sarf Malzeme Depo Giriş İşlemleri" + " " + " ";
        tbp1.addTab(tabTitle, smg);

        // Sekmeye çarpı simgesi ekle
        int tabCount = tbp1.getTabCount();
        tbp1.setTabComponentAt(tabCount - 1, new components.ButtonTabComponent(tbp1));

        // Yeni oluşturulan sekmeyi seçin
        tbp1.setSelectedIndex(tabCount - 1);
    }//GEN-LAST:event_menuSarfMalzemeDepoGirisActionPerformed

    private void menuFirmaKartlariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFirmaKartlariActionPerformed
        FirmaKarti firmaKarti = new FirmaKarti();
        firmaKarti.setClosable(false);
        String tabTitle = "Firma Kartı " + " " + " ";
        tbp1.addTab(tabTitle, firmaKarti);

        // Sekmeye çarpı simgesi ekle
        int tabCount = tbp1.getTabCount();
        tbp1.setTabComponentAt(tabCount - 1, new components.ButtonTabComponent(tbp1));

        // Yeni oluşturulan sekmeyi seçin
        tbp1.setSelectedIndex(tabCount - 1);
    }//GEN-LAST:event_menuFirmaKartlariActionPerformed

    public static void main(String args[]) {
        for (UIManager.LookAndFeelInfo lafInfo : UIManager.getInstalledLookAndFeels()) {
            // System.out.println(lafInfo.getClassName());
        }
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MainMenu;
    private javax.swing.JMenu menuAyarlar;
    private javax.swing.JMenuItem menuAyarlarSirketBilgileri;
    private javax.swing.JMenuItem menuFirmaKartlari;
    private javax.swing.JMenu menuKartTanimlamalari;
    private javax.swing.JMenu menuKodlama;
    private javax.swing.JMenu menuSarfMalzemeDepo;
    private javax.swing.JMenuItem menuSarfMalzemeDepoCikis;
    private javax.swing.JMenuItem menuSarfMalzemeDepoGiris;
    private javax.swing.JMenuItem menuSarfMalzemeKartlari;
    private javax.swing.JMenu menuTeknikDestek;
    private javax.swing.JMenuItem menuTeknikDestekMevcutTalepListesi;
    private javax.swing.JMenuItem menuTeknikDestekTamamlanmisTalepler;
    private javax.swing.JMenuItem menuTeknikDestekYeniKayit;
    private javax.swing.JTabbedPane tbp1;
    // End of variables declaration//GEN-END:variables
}
