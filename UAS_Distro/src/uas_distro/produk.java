/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas_distro;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author Jose, Maulana, Sardin @ 2022
 */
public class produk extends javax.swing.JFrame {
    DefaultTableModel tabModel;
    ResultSet RsProduk=null;
    /**
     * Creates new form produk
     */
    public produk() {
        initComponents();
        tampilData();
        
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize=this.getSize();
        if(frameSize.height > screenSize.height){
        frameSize.height=screenSize.height;
        }
        if(frameSize.width > screenSize.width){
        frameSize.width=screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2,
        (screenSize.height = screenSize.height) / 20); 
        
        //fungsi Tampil data dan set edit off dijalankan saat aplikasi di run
        tampilData();
        SetEditOff();
    }
    
    //fungsi untuk menampilkan data produk ke dalam tabel
    private void tampilData(){
        try{
            Object[] judul_kolom = {"Kode Barang", "Nama Barang", "Size", "Harga", "Stok", "Create Date"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            TabelProduk.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsProduk=stt.executeQuery("SELECT * from produk ");  
            while(RsProduk.next()){
                Object[] data={
                    RsProduk.getString("KodeProduk"),
                    RsProduk.getString("NamaProduk"),
                    RsProduk.getString("Size"),
                    RsProduk.getString("Harga"),
                    RsProduk.getString("Stok"),
                    RsProduk.getString("CreateDate")         
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
        // disable button
        jButtonSave.setEnabled(false);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        jButtonCancel.setEnabled(false);
    }
    
    private void cariData(String key){
        try{
            Object[] judul_kolom = {"Kode Barang", "Nama Barang", "Size", "Harga", "Stok", "Create Date"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            TabelProduk.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsProduk=stt.executeQuery("SELECT * from produk WHERE KodeProduk LIKE '%"+key+"%' OR NamaProduk LIKE '%"+key+"%' OR Size LIKE '%"+key+"%'");  
            while(RsProduk.next()){
                Object[] data={
                    RsProduk.getString("KodeProduk"),
                    RsProduk.getString("NamaProduk"),
                    RsProduk.getString("Size"),
                    RsProduk.getString("Harga"),
                    RsProduk.getString("Stok"),
                    RsProduk.getString("CreateDate")         
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
   
    //menampilkan data ke form saat data pada tabel di klik 
   void tblKeForm(){
        jTextKodeProduk.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),0)+"");
        jTextNama.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),1)+"");
        jComboBoxSize.setSelectedItem(tabModel.getValueAt(TabelProduk.getSelectedRow(),2)+"");
        jTextHarga.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),3)+"");
        jTextStok.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),4)+"");
        
        jButtonUpdate.setEnabled(true);
        jButtonDelete.setEnabled(true);
        jButtonCancel.setEnabled(true);
        jButtonSave.setEnabled(false);
    }
   
   //membersihkan form
   private void BersihData(){
        jTextKodeProduk.setText("");
        jTextNama.setText("");
        jComboBoxSize.setSelectedIndex(0);
        jTextHarga.setText(""); 
        jTextStok.setText("");
    } 
   
   //disable form
   private void SetEditOff(){
        jTextKodeProduk.setEnabled(false);
        jTextNama.setEnabled(false);
        jComboBoxSize.setEnabled(false);
        jTextHarga.setEnabled(false);
        jTextStok.setEnabled(false);
   }
   
   
   private void seteditOn(){
        jTextKodeProduk.setEnabled(true);
        jTextNama.setEnabled(true);
        jComboBoxSize.setEnabled(true);
        jTextHarga.setEnabled(true);
        jTextStok.setEnabled(true);
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelKodeProduk = new javax.swing.JLabel();
        jLabelNama = new javax.swing.JLabel();
        jTextNama = new javax.swing.JTextField();
        jLabelHarga = new javax.swing.JLabel();
        jTextHarga = new javax.swing.JTextField();
        jTextStok = new javax.swing.JTextField();
        jLabelStok = new javax.swing.JLabel();
        jLabelSize = new javax.swing.JLabel();
        jComboBoxSize = new javax.swing.JComboBox<>();
        jbuttonAdd = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelProduk = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextKodeProduk = new javax.swing.JTextField();
        jLabelKodeProduk2 = new javax.swing.JLabel();
        jTextCari = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setFont(new java.awt.Font("STZhongsong", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INPUT BARANG DISTRO TRISULA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabelKodeProduk.setText("Kode Produk");

        jLabelNama.setText("Nama");

        jTextNama.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelHarga.setText("Harga");

        jTextHarga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextHarga.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextHarga.setText("0");
        jTextHarga.setActionCommand("<Not Set>");
        jTextHarga.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextHargaKeyTyped(evt);
            }
        });

        jTextStok.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelStok.setText("Stok");

        jLabelSize.setText("Size");

        jComboBoxSize.setEditable(true);
        jComboBoxSize.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jComboBoxSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- ATASAN", "S", "M", "L", "XL", "XXL", "- CELANA", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "- SEPATU", "38", "39", "40", "41", "42", "43", "44" }));
        jComboBoxSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSizeActionPerformed(evt);
            }
        });

        jbuttonAdd.setText("Tambahkan");
        jbuttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonAddActionPerformed(evt);
            }
        });

        jButtonSave.setText("Simpan");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Perbarui");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Hapus");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Batal");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        TabelProduk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TabelProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelProduk.setCellSelectionEnabled(true);
        TabelProduk.setShowGrid(true);
        TabelProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelProduk);

        jLabel7.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Jose, Sardin, Maulana @ 2022");

        jTextKodeProduk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelKodeProduk2.setText("Cari Data");

        jTextCari.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextCariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextNama, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelStok, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextStok, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbuttonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(12, 12, 12)
                                        .addComponent(jButtonUpdate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonDelete)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonCancel))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelSize, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelKodeProduk2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextCari)
                                .addGap(23, 23, 23))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelKodeProduk2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSize, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxSize, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStok)
                            .addComponent(jTextStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jbuttonAdd)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSave)
                            .addComponent(jButtonUpdate)
                            .addComponent(jButtonDelete)
                            .addComponent(jButtonCancel)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonAddActionPerformed
        // TODO add your handling code here:
        BersihData();
        jTextKodeProduk.requestFocus();
        jButtonSave.setEnabled(true);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        seteditOn();
    }//GEN-LAST:event_jbuttonAddActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        String KodeProduk=jTextKodeProduk.getText();
        String NamaProduk=jTextNama.getText();
        String Size=jComboBoxSize.getSelectedItem().toString();
        String Harga=jTextHarga.getText();
        String Stok=jTextStok.getText();

        java.util.Date tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate=TanggalFormat.format(tanggal);

        if (KodeProduk.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Kode produk tidak boleh kosong");
            jTextKodeProduk.requestFocus();
        }else if (NamaProduk.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Nama produk tidak boleh kosong");
            jTextNama.requestFocus();
        }else if (Size.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Size produk tidak boleh kosong");
            jComboBoxSize.requestFocus();
        }else if (Harga.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Harga produk tidak boleh kosong");
            jTextHarga.requestFocus();
        }else if (Stok.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Stok produk tidak boleh kosong");
            jTextStok.requestFocus();
        }
        else if (!(new Scanner(Harga).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Harga produk harus angka");
            jTextHarga.requestFocus();
        }else if (!(new Scanner(Stok).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Stok produk harus angka");
            jTextStok.requestFocus();
        }else{
            try{
                Connection conn=(Connection)koneksi.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("insert into produk(KodeProduk,NamaProduk,Size,Harga,Stok,CreateDate)"+
                    "VALUES('"+KodeProduk+"','"+NamaProduk+"','"+Size+"','"+Harga+"','"+Stok+"','"+CreateDate+"')");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        String KodeProduk=jTextKodeProduk.getText();
        String NamaProduk=jTextNama.getText();
        String Size=jComboBoxSize.getSelectedItem().toString();
        String Harga=jTextHarga.getText();
        String Stok=jTextStok.getText();

        java.util.Date tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate=TanggalFormat.format(tanggal);

        if (KodeProduk.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Kode produk tidak boleh kosong");
            jTextKodeProduk.requestFocus();
        }else if (NamaProduk.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Nama produk tidak boleh kosong");
            jTextNama.requestFocus();
        }else if (Size.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Size produk tidak boleh kosong");
            jComboBoxSize.requestFocus();
        }else if (Harga.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Harga produk tidak boleh kosong");
            jTextHarga.requestFocus();
        }else if (Stok.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Stok produk tidak boleh kosong");
            jTextStok.requestFocus();
        }
        else if (!(new Scanner(Harga).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Harga produk harus angka");
            jTextHarga.requestFocus();
        }else if (!(new Scanner(Stok).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Stok produk harus angka");
            jTextStok.requestFocus();
        }else{
            try{
                Connection conn=(Connection)koneksi.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("UPDATE produk SET NamaProduk='"+NamaProduk+"', Size='"+Size+"', Harga='"+Harga+"',"+
                    "Stok='"+Stok+"' WHERE KodeProduk='"+KodeProduk+"'");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil diubah","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Ubah data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        String KodeProduk=jTextKodeProduk.getText();

        if (KodeProduk.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Kode produk tidak boleh kosong");
            jTextKodeProduk.requestFocus();
        }else if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM produk WHERE KodeProduk='"+KodeProduk+"'");
            BersihData();
            tampilData();
            SetEditOff();
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        BersihData();
        jButtonSave.setEnabled(false);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        SetEditOff();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void TabelProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelProdukMouseClicked
        // TODO add your handling code here:
        seteditOn();
        jTextKodeProduk.setEnabled(false);
        tblKeForm();
    }//GEN-LAST:event_TabelProdukMouseClicked

    private void jComboBoxSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSizeActionPerformed

    private void jTextHargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextHargaKeyTyped
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextHargaKeyTyped

    private void jTextCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCariKeyReleased
        // TODO add your handling code here:
        String key=jTextCari.getText();
        System.out.println(key);  
        
        if(key!=""){
            cariData(key);
        }else{
            tampilData();
        }
    }//GEN-LAST:event_jTextCariKeyReleased

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
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new produk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelProduk;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelHarga;
    private javax.swing.JLabel jLabelKodeProduk;
    private javax.swing.JLabel jLabelKodeProduk2;
    private javax.swing.JLabel jLabelNama;
    private javax.swing.JLabel jLabelSize;
    private javax.swing.JLabel jLabelStok;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextCari;
    private javax.swing.JTextField jTextHarga;
    private javax.swing.JTextField jTextKodeProduk;
    private javax.swing.JTextField jTextNama;
    private javax.swing.JTextField jTextStok;
    private javax.swing.JButton jbuttonAdd;
    // End of variables declaration//GEN-END:variables
}
