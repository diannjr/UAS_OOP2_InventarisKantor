/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventarisKantor;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import InventarisKantor.koneksi;

/**
 *
 * @author DELL
 */
public class FormBarangMasuk_diana extends javax.swing.JFrame {
    private DefaultTableModel model;
    String tempat, kdlokasi, nmlokasi, kdbrng, nmbrng, kat, merks;
    /**
     * Creates new form FormInventaris_diana
     */
    public FormBarangMasuk_diana() {
        initComponents();
        model = new DefaultTableModel();

        tabel_inventaris.setModel(model);

        model.addColumn("Kode Inventaris");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Kategori");
        model.addColumn("Merk");
        model.addColumn("Jumlah");
        model.addColumn("Kode Lokasi");
        model.addColumn("Nama Lokasi");
        model.addColumn("Tanggal Masuk");
        loadData();
    }

    public final void loadData() {
        btn_simpan_diana.setEnabled(true);
        btn_hapus_diana.setEnabled(false);
        btn_edit_diana.setEnabled(false);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM tbl_masuk";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                Object[] o = new Object[9];
                o[0] = r.getString("kd_inventaris");
                o[1] = r.getString("kd_barang");
                o[2] = r.getString("nama_barang");
                o[3] = r.getString("kategori");
                o[4] = r.getString("merk");
                o[5] = r.getString("jumlah");
                o[6] = r.getString("kd_lokasi");
                o[7] = r.getString("nama_lokasi");
                o[8] = r.getString("tanggal_masuk");
                
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan");
        }
    }

    public void kode() {
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM tbl_masuk";
            ResultSet r = s.executeQuery(sql);

            if (r.next()) {
                String kdinventaris = r.getString("kd_inventaris").substring(1);
                String AN = "" + (Integer.parseInt(kdinventaris)+1);
                String Nol ="";

                if (AN.length()==1) {
                    Nol = "000";
                } else if (AN.length()==2) {
                    Nol = "00";
                } else if (AN.length()==3) {
                    Nol = "0";
                } else if (AN.length()==4) {
                    Nol = "";
                }

                kdinventaris_diana.setText("IN" + Nol + AN);
            } else {
                kdinventaris_diana.setText("IN0001");
            }
        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan");
        }
    }
     
    public void itemTerpilih() {
        PopupBarang_diana pp = new PopupBarang_diana();
        pp.barang = this;
        kdbarang_diana.setText(kdbrng);
        nmbarang_diana.setText(nmbrng);
        kategori_diana.setText(kat);
        merk_diana.setText(merks);
    }
    
    public void lokasiTerpilih() {
        PopupLokasi_diana pp = new PopupLokasi_diana();
        pp.lokasi = this;
        kdlokasi_diana.setText(kdlokasi);
        nmlokasi_diana.setText(nmlokasi);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Background = new javax.swing.JPanel();
        Panel_Background2 = new javax.swing.JPanel();
        Label = new javax.swing.JLabel();
        btn_back_diana = new javax.swing.JButton();
        Label_kdinvenntaris = new javax.swing.JLabel();
        Label_kdbarang = new javax.swing.JLabel();
        Label_nmbarang = new javax.swing.JLabel();
        Label_kategori = new javax.swing.JLabel();
        Label_merk = new javax.swing.JLabel();
        Label_jumlah = new javax.swing.JLabel();
        Label_kdlokasi = new javax.swing.JLabel();
        Label_lokasi = new javax.swing.JLabel();
        Label_cari = new javax.swing.JLabel();
        kdinventaris_diana = new javax.swing.JTextField();
        kdbarang_diana = new javax.swing.JTextField();
        btn_carikd_diana = new javax.swing.JButton();
        nmbarang_diana = new javax.swing.JTextField();
        kategori_diana = new javax.swing.JTextField();
        merk_diana = new javax.swing.JTextField();
        jumlah_diana = new javax.swing.JTextField();
        kdlokasi_diana = new javax.swing.JTextField();
        nmlokasi_diana = new javax.swing.JTextField();
        cari_diana = new javax.swing.JTextField();
        btn_cari_diana = new javax.swing.JButton();
        btn_simpan_diana = new javax.swing.JButton();
        btn_hapus_diana = new javax.swing.JButton();
        btn_edit_diana = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_inventaris = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UAS - DIANA SARI");

        Panel_Background.setBackground(new java.awt.Color(204, 153, 255));

        Panel_Background2.setBackground(new java.awt.Color(153, 0, 204));
        Panel_Background2.setPreferredSize(new java.awt.Dimension(582, 81));

        Label.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        Label.setForeground(new java.awt.Color(255, 255, 255));
        Label.setText("Data Inventaris Masuk");

        btn_back_diana.setBackground(new java.awt.Color(255, 255, 255));
        btn_back_diana.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_back_diana.setForeground(new java.awt.Color(255, 51, 51));
        btn_back_diana.setText("BACK");
        btn_back_diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_back_dianaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_Background2Layout = new javax.swing.GroupLayout(Panel_Background2);
        Panel_Background2.setLayout(Panel_Background2Layout);
        Panel_Background2Layout.setHorizontalGroup(
            Panel_Background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_Background2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_back_diana)
                .addGap(24, 24, 24))
        );
        Panel_Background2Layout.setVerticalGroup(
            Panel_Background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Background2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_Background2Layout.createSequentialGroup()
                        .addComponent(Label)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(Panel_Background2Layout.createSequentialGroup()
                        .addComponent(btn_back_diana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(23, 23, 23))))
        );

        Label_kdinvenntaris.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_kdinvenntaris.setText("Kode Inventaris");

        Label_kdbarang.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_kdbarang.setText("Kode Barang");

        Label_nmbarang.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_nmbarang.setText("Nama Barang");

        Label_kategori.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_kategori.setText("Kategori");

        Label_merk.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_merk.setText("Merk");

        Label_jumlah.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_jumlah.setText("Jumlah");

        Label_kdlokasi.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_kdlokasi.setText("Kode Lokasi");

        Label_lokasi.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_lokasi.setText("Nama Lokasi");

        Label_cari.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_cari.setText("CARI :");

        btn_carikd_diana.setBackground(new java.awt.Color(153, 0, 204));
        btn_carikd_diana.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        btn_carikd_diana.setForeground(new java.awt.Color(255, 255, 255));
        btn_carikd_diana.setText("CARI");
        btn_carikd_diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_carikd_dianaActionPerformed(evt);
            }
        });

        nmbarang_diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmbarang_dianaActionPerformed(evt);
            }
        });

        cari_diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari_dianaActionPerformed(evt);
            }
        });
        cari_diana.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cari_dianaKeyReleased(evt);
            }
        });

        btn_cari_diana.setBackground(new java.awt.Color(153, 0, 204));
        btn_cari_diana.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        btn_cari_diana.setForeground(new java.awt.Color(255, 255, 255));
        btn_cari_diana.setText("CARI");
        btn_cari_diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_dianaActionPerformed(evt);
            }
        });

        btn_simpan_diana.setBackground(new java.awt.Color(255, 255, 255));
        btn_simpan_diana.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_simpan_diana.setText("SIMPAN");
        btn_simpan_diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_dianaActionPerformed(evt);
            }
        });

        btn_hapus_diana.setBackground(new java.awt.Color(255, 255, 255));
        btn_hapus_diana.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_hapus_diana.setText("HAPUS");
        btn_hapus_diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_dianaActionPerformed(evt);
            }
        });

        btn_edit_diana.setBackground(new java.awt.Color(255, 255, 255));
        btn_edit_diana.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_edit_diana.setText("EDIT");
        btn_edit_diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_dianaActionPerformed(evt);
            }
        });

        tabel_inventaris.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tabel_inventaris.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_inventaris.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_inventarisMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_inventaris);

        javax.swing.GroupLayout Panel_BackgroundLayout = new javax.swing.GroupLayout(Panel_Background);
        Panel_Background.setLayout(Panel_BackgroundLayout);
        Panel_BackgroundLayout.setHorizontalGroup(
            Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Background2, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BackgroundLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Label_cari)
                        .addGap(38, 38, 38)
                        .addComponent(cari_diana, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_nmbarang)
                    .addComponent(Label_kdbarang)
                    .addComponent(Label_kategori)
                    .addComponent(Label_kdinvenntaris))
                .addGap(33, 33, 33)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kdinventaris_diana)
                    .addComponent(nmbarang_diana)
                    .addComponent(kategori_diana)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BackgroundLayout.createSequentialGroup()
                        .addComponent(kdbarang_diana, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_carikd_diana)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_jumlah)
                    .addComponent(Label_kdlokasi)
                    .addComponent(Label_lokasi)
                    .addComponent(Label_merk))
                .addGap(33, 33, 33)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(merk_diana)
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addComponent(kdlokasi_diana, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cari_diana))
                    .addComponent(jumlah_diana)
                    .addComponent(nmlokasi_diana, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_simpan_diana, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btn_hapus_diana, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btn_edit_diana, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268))
        );
        Panel_BackgroundLayout.setVerticalGroup(
            Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addComponent(Panel_Background2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                            .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(kdinventaris_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Label_kdinvenntaris))
                            .addGap(129, 129, 129))
                        .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                            .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Label_kdbarang)
                                .addComponent(kdbarang_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_carikd_diana))
                            .addGap(21, 21, 21)
                            .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Label_nmbarang)
                                .addComponent(nmbarang_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(kategori_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Label_kategori))))
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_merk)
                            .addComponent(merk_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_jumlah)
                            .addComponent(jumlah_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_kdlokasi)
                            .addComponent(kdlokasi_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cari_diana))
                        .addGap(20, 20, 20)
                        .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_lokasi)
                            .addComponent(nmlokasi_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addComponent(btn_edit_diana)
                        .addGap(1, 1, 1))
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_simpan_diana)
                            .addComponent(btn_hapus_diana))))
                .addGap(18, 18, 18)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cari_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_back_dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_back_dianaActionPerformed
        // TODO add your handling code here:
        FormMenu_diana fm = new FormMenu_diana();
        fm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_back_dianaActionPerformed

    private void cari_dianaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cari_dianaKeyReleased
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "select * from tbl_masuk where kd_barang like '%" + cari_diana.getText() + "%' or nama_barang like'%" + cari_diana.getText() + "%'            or kategori like'" + cari_diana.getText() + "%' or jumlah like'%" + cari_diana.getText() + "%' " + "or tempat_penyimpanan like'%" + cari_diana.getText() + "%'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[8];
                o[0] = r.getString("kd_inventaris");
                o[1] = r.getString("kd_barang");
                o[2] = r.getString("nama_barang");
                o[3] = r.getString("kategori");
                o[4] = r.getString("merk");
                o[5] = r.getString("jumlah");
                o[6] = r.getString("kd_lokasi");
                o[7] = r.getString("nama_lokasi");
                o[8] = r.getString("tanggal_masuk");
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
    }//GEN-LAST:event_cari_dianaKeyReleased

    private void tabel_inventarisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_inventarisMouseClicked
        btn_simpan_diana.setEnabled(false);
        btn_edit_diana.setEnabled(true);
        btn_hapus_diana.setEnabled(true);
        int i = tabel_inventaris.getSelectedRow();

        if (i == -1) {
            return;
        }
        String kdinventaris = (String) model.getValueAt(i, 0);
        kdinventaris_diana.setText(kdinventaris);
        kdinventaris_diana.setEnabled(false);
        
        String kdbarang = (String) model.getValueAt(i, 0);
        kdbarang_diana.setText(kdbarang);
        
        String nmbarang = (String) model.getValueAt(i, 1);
        nmbarang_diana.setText(nmbarang);
        
        String kategori = (String) model.getValueAt(i, 2);
        kategori_diana.setText(kategori);
        
        String merk = (String) model.getValueAt(i, 2);
        merk_diana.setText(kategori);
        
        String jumlah = (String) model.getValueAt(i, 3);
        jumlah_diana.setText(jumlah);
        
        String kdlokasi = (String) model.getValueAt(i, 4);
        kdlokasi_diana.setText(kdlokasi);
        
        String nmlokasi = (String) model.getValueAt(i, 5);
        nmlokasi_diana.setText(nmlokasi);
    }//GEN-LAST:event_tabel_inventarisMouseClicked

    private void btn_simpan_dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_dianaActionPerformed
        if (kdinventaris_diana.getText().equals("") || kdbarang_diana.getText().equals("") || nmbarang_diana.getText().equals("") || kategori_diana.getText().equals("") || merk_diana.getText().equals("") ||  jumlah_diana.getText().equals("") || kdlokasi_diana.getText().equals("") || nmlokasi_diana.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA!", "INVENTARIS LUALIMASTUFF", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String kdinventaris = kdinventaris_diana.getText();
            String kdbarang = kdbarang_diana.getText();
            String nmbarang = nmbarang_diana.getText();
            String kategori = kategori_diana.getText();
            String merk = merk_diana.getText();
            String jumlah = jumlah_diana.getText();
            String kdlokasi = kdlokasi_diana.getText();
            String nmlokasi = nmlokasi_diana.getText();

            try {
                long millis=System.currentTimeMillis();
                java.sql.Date date=new java.sql.Date(millis);
                System.out.println(date);
                String tgl = date.toString();
                Connection c = koneksi.getKoneksi();
                String sql = "INSERT INTO tbl_masuk VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, kdinventaris);
                p.setString(2, kdbarang);
                p.setString(3, nmbarang);
                p.setString(4, kategori);
                p.setString(5, merk);
                p.setString(6, jumlah);
                p.setString(7, kdlokasi);
                p.setString(8, nmlokasi);
                p.setString(9, tgl);
                p.executeUpdate();
                p.close();
            } catch (SQLException e) {
                System.out.println("Terjadi Kesalahan");
            } finally {
                loadData();
                kode();

                kdinventaris_diana.setText("");
                kdbarang_diana.setText("");
                nmbarang_diana.setText("");
                kategori_diana.setText("");
                merk_diana.setText("");
                jumlah_diana.setText("");
                kdlokasi_diana.setText("");
                nmlokasi_diana.setText("");

                JOptionPane.showMessageDialog(null, "Data berhasil tersimpan", "INVENTARIS LUALIMASTUFF", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_simpan_dianaActionPerformed

    private void btn_hapus_dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_dianaActionPerformed
        try {
            String sql ="delete from tbl_masuk where kd_inventaris ='"+kdinventaris_diana.getText()+"'";
            java.sql.Connection conn=(Connection)koneksi.getKoneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        loadData();
        kdinventaris_diana.setText("");
        kdbarang_diana.setText("");
        nmbarang_diana.setText("");
        kategori_diana.setText("");
        merk_diana.setText("");
        jumlah_diana.setText("");
        kdlokasi_diana.setText("");
        nmlokasi_diana.setText("");
    }//GEN-LAST:event_btn_hapus_dianaActionPerformed

    private void btn_edit_dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_dianaActionPerformed
        if(kdinventaris_diana.getText().equals("") ||kdbarang_diana.getText().equals("") ||nmbarang_diana.getText().equals("") || kategori_diana.getText().equals("")|| merk_diana.getText().equals("") || jumlah_diana.getText().equals("")|| kdlokasi_diana.getText().equals("") || nmlokasi_diana.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "INVENTARIS LUALIMASTURR", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int i = tabel_inventaris.getSelectedRow();
            if (i == -1) {
                return;
            }
            String user = (String) model.getValueAt(i, 0);
            try {
                Connection c = koneksi.getKoneksi();
                String sql = "UPDATE tbl_masuk SET nama_barang = '" + nmbarang_diana.getText() + "', kategori='"+ kategori_diana.getText() + "', merk='"+ merk_diana.getText() + "', jumlah='"+ jumlah_diana.getText() + "', kd_lokasi ='"+ kdlokasi_diana.getText() + "', nama_lokasi='"+ nmlokasi_diana.getText() + "', kd_lokasi ='"+ "' WHERE kd_barang ='" + kdbarang_diana.getText() + "'";
                PreparedStatement p = c.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            } catch (SQLException e) {
                System.out.println("Terjadi Error");
            } finally {
                loadData();
                kdinventaris_diana.setText("");
                kdbarang_diana.setText("");
                nmbarang_diana.setText("");
                kategori_diana.setText("");
                merk_diana.setText("");
                jumlah_diana.setText("");
                kdlokasi_diana.setText("");
                nmlokasi_diana.setText("");
                btn_simpan_diana.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Data berhasil diubah", "INVENTARIS LUALIMASTUDD", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_edit_dianaActionPerformed

    private void btn_cari_dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_dianaActionPerformed
        PopupLokasi_diana pp = new PopupLokasi_diana();
        pp.lokasi = this;
        pp.setVisible(true);
        pp.setResizable(false);
    }//GEN-LAST:event_btn_cari_dianaActionPerformed

    private void cari_dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari_dianaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cari_dianaActionPerformed

    private void nmbarang_dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmbarang_dianaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nmbarang_dianaActionPerformed

    private void btn_carikd_dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_carikd_dianaActionPerformed
        // TODO add your handling code here:
        PopupBarang_diana pp = new PopupBarang_diana();
        pp.barang = this;
        pp.setVisible(true);
        pp.setResizable(false);
        
    }//GEN-LAST:event_btn_carikd_dianaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormBarangMasuk_diana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBarangMasuk_diana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBarangMasuk_diana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBarangMasuk_diana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBarangMasuk_diana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.JLabel Label_cari;
    private javax.swing.JLabel Label_jumlah;
    private javax.swing.JLabel Label_kategori;
    private javax.swing.JLabel Label_kdbarang;
    private javax.swing.JLabel Label_kdinvenntaris;
    private javax.swing.JLabel Label_kdlokasi;
    private javax.swing.JLabel Label_lokasi;
    private javax.swing.JLabel Label_merk;
    private javax.swing.JLabel Label_nmbarang;
    private javax.swing.JPanel Panel_Background;
    private javax.swing.JPanel Panel_Background2;
    private javax.swing.JButton btn_back_diana;
    private javax.swing.JButton btn_cari_diana;
    private javax.swing.JButton btn_carikd_diana;
    private javax.swing.JButton btn_edit_diana;
    private javax.swing.JButton btn_hapus_diana;
    private javax.swing.JButton btn_simpan_diana;
    private javax.swing.JTextField cari_diana;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jumlah_diana;
    private javax.swing.JTextField kategori_diana;
    private javax.swing.JTextField kdbarang_diana;
    private javax.swing.JTextField kdinventaris_diana;
    private javax.swing.JTextField kdlokasi_diana;
    private javax.swing.JTextField merk_diana;
    private javax.swing.JTextField nmbarang_diana;
    private javax.swing.JTextField nmlokasi_diana;
    private javax.swing.JTable tabel_inventaris;
    // End of variables declaration//GEN-END:variables
}
