/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventarisKantor;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DELL
 */
public class FormPegawai_diana extends javax.swing.JFrame {
    private DefaultTableModel model;
    /**
     * Creates new form FormPegawai_diana
     */
    public FormPegawai_diana() {
        initComponents();
        model = new DefaultTableModel();
        
        tabel_pegawai.setModel(model);
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Email");
        model.addColumn("No Tlp");
        model.addColumn("Agama");
        model.addColumn("Alamat");
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
            
            String sql = "SELECT * FROM tbl_login";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                Object[] o = new Object[7];
                o[0] = r.getString("username");
                o[1] = r.getString("password");
                o[2] = r.getString("jenis_kelamin");
                o[3] = r.getString("email");
                o[4] = r.getString("no_tlp");
                o[5] = r.getString("agama");
                o[6] = r.getString("alamat");
                
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        Panel_Background = new javax.swing.JPanel();
        Panel_Background2 = new javax.swing.JPanel();
        Label = new javax.swing.JLabel();
        btn_back_diana = new javax.swing.JButton();
        Label_user = new javax.swing.JLabel();
        Label_pass = new javax.swing.JLabel();
        Label_retype = new javax.swing.JLabel();
        Label_JK = new javax.swing.JLabel();
        Label_email = new javax.swing.JLabel();
        Label_tlp = new javax.swing.JLabel();
        Label_agama = new javax.swing.JLabel();
        Label_alamat = new javax.swing.JLabel();
        username_diana = new javax.swing.JTextField();
        pass_diana = new javax.swing.JPasswordField();
        retype_diana = new javax.swing.JPasswordField();
        rb_L_diana = new javax.swing.JRadioButton();
        rb_P_diana = new javax.swing.JRadioButton();
        email_diana = new javax.swing.JTextField();
        notlp_diana = new javax.swing.JTextField();
        cb_agama_diana = new javax.swing.JComboBox<>();
        alamat_diana = new javax.swing.JTextField();
        btn_simpan_diana = new javax.swing.JButton();
        btn_edit_diana = new javax.swing.JButton();
        btn_hapus_diana = new javax.swing.JButton();
        ScrollPane = new javax.swing.JScrollPane();
        tabel_pegawai = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UAS - DIANA SARI");
        setBackground(new java.awt.Color(255, 255, 255));

        Panel_Background.setBackground(new java.awt.Color(204, 153, 255));

        Panel_Background2.setBackground(new java.awt.Color(153, 0, 204));

        Label.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        Label.setForeground(new java.awt.Color(255, 255, 255));
        Label.setText("Pengolahan Data Pegawai");

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
            .addGroup(Panel_Background2Layout.createSequentialGroup()
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
                    .addComponent(Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_back_diana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Label_user.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_user.setText("Username");

        Label_pass.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_pass.setText("Password");

        Label_retype.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_retype.setText("Retype");

        Label_JK.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_JK.setText("Jenis Kelamin");

        Label_email.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_email.setText("Email");

        Label_tlp.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_tlp.setText("No Tlp");

        Label_agama.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_agama.setText("Agama");

        Label_alamat.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Label_alamat.setText("Alamat");

        buttonGroup1.add(rb_L_diana);
        rb_L_diana.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        rb_L_diana.setText("Laki-laki");
        rb_L_diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_L_dianaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_P_diana);
        rb_P_diana.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        rb_P_diana.setText("Perempuan");
        rb_P_diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_P_dianaActionPerformed(evt);
            }
        });

        cb_agama_diana.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        cb_agama_diana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Islam", "Kristen", "Budha", "Hindu" }));

        btn_simpan_diana.setBackground(new java.awt.Color(153, 0, 204));
        btn_simpan_diana.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btn_simpan_diana.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan_diana.setText("SIMPAN");
        btn_simpan_diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_dianaActionPerformed(evt);
            }
        });

        btn_edit_diana.setBackground(new java.awt.Color(153, 0, 204));
        btn_edit_diana.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btn_edit_diana.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit_diana.setText("EDIT");
        btn_edit_diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_dianaActionPerformed(evt);
            }
        });

        btn_hapus_diana.setBackground(new java.awt.Color(255, 255, 255));
        btn_hapus_diana.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btn_hapus_diana.setForeground(new java.awt.Color(255, 51, 51));
        btn_hapus_diana.setText("HAPUS");
        btn_hapus_diana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_dianaActionPerformed(evt);
            }
        });

        tabel_pegawai.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tabel_pegawai.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pegawaiMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(tabel_pegawai);

        javax.swing.GroupLayout Panel_BackgroundLayout = new javax.swing.GroupLayout(Panel_Background);
        Panel_Background.setLayout(Panel_BackgroundLayout);
        Panel_BackgroundLayout.setHorizontalGroup(
            Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Background2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(btn_simpan_diana)
                .addGap(114, 114, 114)
                .addComponent(btn_edit_diana, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(btn_hapus_diana, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_JK)
                    .addComponent(Label_user, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_pass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_retype, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_email, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(26, 26, 26)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addComponent(rb_L_diana)
                        .addGap(51, 51, 51)
                        .addComponent(rb_P_diana))
                    .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(email_diana, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pass_diana, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(retype_diana, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                        .addComponent(username_diana)))
                .addGap(36, 36, 36)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_tlp)
                    .addComponent(Label_agama)
                    .addComponent(Label_alamat))
                .addGap(24, 24, 24)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(notlp_diana)
                    .addComponent(alamat_diana, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(cb_agama_diana, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(95, 95, 95))
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addContainerGap())
        );
        Panel_BackgroundLayout.setVerticalGroup(
            Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                .addComponent(Panel_Background2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Label_user)
                        .addComponent(username_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Label_tlp)
                        .addComponent(notlp_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_pass)
                    .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pass_diana, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Label_agama)
                        .addComponent(cb_agama_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Panel_BackgroundLayout.createSequentialGroup()
                        .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_retype)
                            .addComponent(Label_alamat)
                            .addComponent(retype_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_JK)
                            .addComponent(rb_L_diana)
                            .addComponent(rb_P_diana))
                        .addGap(18, 18, 18)
                        .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_email)
                            .addComponent(email_diana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(alamat_diana, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(Panel_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan_diana)
                    .addComponent(btn_edit_diana)
                    .addComponent(btn_hapus_diana))
                .addGap(39, 39, 39)
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_back_dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_back_dianaActionPerformed
        // TODO add your handling code here:
        FormMenu_diana fm = new FormMenu_diana();
        fm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_back_dianaActionPerformed

    private void btn_simpan_dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_dianaActionPerformed
        // TODO add your handling code here:
        String gender = null;
        if (rb_L_diana.isSelected()) {
            gender = "Laki-laki";
        } else if (rb_P_diana.isSelected()) {
            gender = "Perempuan";
        }
        
        try {
            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);
            System.out.println(date);
            String tgl = date.toString();
            Connection c = koneksi.getKoneksi();
            String sql = "INSERT INTO tbl_login VALUES('" + username_diana.getText() + "','" + pass_diana.getText() + "','" + gender + "','" + email_diana.getText() + "','" + notlp_diana.getText() + "','" + cb_agama_diana.getSelectedItem() + "','" + alamat_diana.getText() + "')";
            PreparedStatement p = c.prepareStatement(sql);
            p.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil tersimpan", "INVENTARIS LUALIMASTUFF", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | SQLException e) {
            System.out.println("Terjadi Kesalahan");
        }
        
    }//GEN-LAST:event_btn_simpan_dianaActionPerformed

    private void btn_edit_dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_dianaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit_dianaActionPerformed

    private void btn_hapus_dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_dianaActionPerformed
        // TODO add your handling code here: 
        try {
            String sql ="delete from tbl_login where username ='" + username_diana.getText()+"'";
            java.sql.Connection conn=(Connection)koneksi.getKoneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        loadData();
        username_diana.setText("");
        pass_diana.setText("");
        email_diana.setText("");
        cb_agama_diana.getSelectedItem().toString();
        alamat_diana.setText("");
        
    }//GEN-LAST:event_btn_hapus_dianaActionPerformed

    private void rb_L_dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_L_dianaActionPerformed
        // TODO add your handling code here:       
    }//GEN-LAST:event_rb_L_dianaActionPerformed

    private void rb_P_dianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_P_dianaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_P_dianaActionPerformed

    private void tabel_pegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pegawaiMouseClicked
        // TODO add your handling code here:
        btn_simpan_diana.setEnabled(false);
        btn_edit_diana.setEnabled(true);
        btn_hapus_diana.setEnabled(true);
        int i = tabel_pegawai.getSelectedRow();

        if (i == -1) {
            return;
        }
        String username = (String) model.getValueAt(i, 0);
        username_diana.setText(username);
        username_diana.setEnabled(false);
        
        String password = (String) model.getValueAt(i, 1);
        pass_diana.setText(password);
        
        String email = (String) model.getValueAt(i, 2);
        email_diana.setText(email);
        
        String agama = (String) model.getValueAt(i, 3);
        cb_agama_diana.getSelectedItem().toString();
        
        String alamat = (String) model.getValueAt(i, 4);
        alamat_diana.setText(alamat);
    }//GEN-LAST:event_tabel_pegawaiMouseClicked

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
            java.util.logging.Logger.getLogger(FormPegawai_diana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPegawai_diana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPegawai_diana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPegawai_diana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPegawai_diana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.JLabel Label_JK;
    private javax.swing.JLabel Label_agama;
    private javax.swing.JLabel Label_alamat;
    private javax.swing.JLabel Label_email;
    private javax.swing.JLabel Label_pass;
    private javax.swing.JLabel Label_retype;
    private javax.swing.JLabel Label_tlp;
    private javax.swing.JLabel Label_user;
    private javax.swing.JPanel Panel_Background;
    private javax.swing.JPanel Panel_Background2;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTextField alamat_diana;
    private javax.swing.JButton btn_back_diana;
    private javax.swing.JButton btn_edit_diana;
    private javax.swing.JButton btn_hapus_diana;
    private javax.swing.JButton btn_simpan_diana;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_agama_diana;
    private javax.swing.JTextField email_diana;
    private javax.swing.JTextField notlp_diana;
    private javax.swing.JPasswordField pass_diana;
    private javax.swing.JRadioButton rb_L_diana;
    private javax.swing.JRadioButton rb_P_diana;
    private javax.swing.JPasswordField retype_diana;
    private javax.swing.JTable tabel_pegawai;
    private javax.swing.JTextField username_diana;
    // End of variables declaration//GEN-END:variables

}
