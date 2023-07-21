package main;

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

    public void setLogo(){
        ImageIcon img;
        img = new ImageIcon("C:\\Users\\BILGIISLEM\\Desktop\\New Folder\\udemy\\Portal V2\\src\\assets\\logo.png");
        this.setIconImage(img.getImage());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        menuKartTanimlamalari.add(menuSarfMalzemeKartlari);

        menuFirmaKartlari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/cards.png"))); // NOI18N
        menuFirmaKartlari.setText("Firma Kartları");
        menuKartTanimlamalari.add(menuFirmaKartlari);

        MainMenu.add(menuKartTanimlamalari);

        menuSarfMalzemeDepo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/package.png"))); // NOI18N
        menuSarfMalzemeDepo.setText("Sarf Malzeme Depo");

        menuSarfMalzemeDepoGiris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/package.png"))); // NOI18N
        menuSarfMalzemeDepoGiris.setText("Sarf Malzeme Depo Giriş");
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

        setJMenuBar(MainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1046, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        for (UIManager.LookAndFeelInfo lafInfo : UIManager.getInstalledLookAndFeels()) {
            System.out.println(lafInfo.getClassName());
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
    private javax.swing.JMenu menuSarfMalzemeDepo;
    private javax.swing.JMenuItem menuSarfMalzemeDepoCikis;
    private javax.swing.JMenuItem menuSarfMalzemeDepoGiris;
    private javax.swing.JMenuItem menuSarfMalzemeKartlari;
    private javax.swing.JMenu menuTeknikDestek;
    private javax.swing.JMenuItem menuTeknikDestekMevcutTalepListesi;
    private javax.swing.JMenuItem menuTeknikDestekTamamlanmisTalepler;
    private javax.swing.JMenuItem menuTeknikDestekYeniKayit;
    // End of variables declaration//GEN-END:variables
}
