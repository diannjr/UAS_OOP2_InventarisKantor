/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventarisKantor;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import InventarisKantor.FormBarangMasuk_diana;
/**
 *
 * @author DELL
 */
public class PopupBarang_diana extends javax.swing.JFrame {
    DefaultTableModel model;
       
    public FormBarangMasuk_diana barang = null;
    /**
     * Creates new form PopupBarang_diana
     */
    public PopupBarang_diana() {
        initComponents();
        model = new DefaultTableModel();

        tabel_data.setModel(model);

        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Kategori");
        model.addColumn("Merk");
        model.addColumn("Jumlah");
        model.addColumn("Tanggal Masuk");
        loadData();
    }

    public final void loadData() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM tbl_inventaris";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                Object[] o = new Object[6];
                o[0] = r.getString("kd_barang");
                o[1] = r.getString("nama_barang");
                o[2] = r.getString("kategori");
                o[3] = r.getString("merk");
                o[4] = r.getString("jumlah");
                o[5] = r.getString("tanggal_masuk");
                
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Backgroud = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_data = new javax.swing.JTable();
        cari_diana = new javax.swing.JTextField();
        btn_cari_diana = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UAS - DIANA SARI");

        Panel_Backgroud.setBackground(new java.awt.Color(204, 153, 255));

        tabel_data.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_data);

        btn_cari_diana.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        btn_cari_diana.setText("CARI");

        javax.swing.GroupLayout Panel_BackgroudLayout = new javax.swing.GroupLayout(Panel_Backgroud);
        Panel_Backgroud.setLayout(Panel_BackgroudLayout);
        Panel_BackgroudLayout.setHorizontalGroup(
            Panel_BackgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BackgroudLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(Panel_BackgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_BackgroudLayout.createSequentialGroup()
                        .addComponent(cari_diana, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cari_diana))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        Panel_BackgroudLayout.setVerticalGroup(
            Panel_BackgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BackgroudLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(Panel_BackgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cari_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cari_diana))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabel_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_dataMouseClicked
        // TODO add your handling code here:
        int index = tabel_data.getSelectedRow(); 
        barang.kdbrng = tabel_data.getValueAt(index, 0).toString();
        barang.nmbrng = tabel_data.getValueAt(index, 1).toString();
        barang.kat = tabel_data.getValueAt(index, 2).toString();
        barang.merks = tabel_data.getValueAt(index, 3).toString();
        barang.itemTerpilih();
        this.dispose();
    }//GEN-LAST:event_tabel_dataMouseClicked

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
            java.util.logging.Logger.getLogger(PopupBarang_diana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopupBarang_diana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopupBarang_diana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopupBarang_diana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopupBarang_diana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Backgroud;
    private javax.swing.JButton btn_cari_diana;
    private javax.swing.JTextField cari_diana;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_data;
    // End of variables declaration//GEN-END:variables
}
