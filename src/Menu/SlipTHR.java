package Menu;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
public class SlipTHR extends javax.swing.JFrame {
    private Connection conn = new koneksi().koneksi();
    String nip, nama, gaji;
    Date tgl;
    private DefaultTableModel UserTab;
    public SlipTHR() {
        initComponents();
        String KODE = UserLogin.getUserLogin();
        lid.setText(KODE);
        UserModelTable();
        clear();
        autonumber();
    }
    public void clear(){
        txtperiode.setText("");
        txtnip.setText("");
        txtnama.setText("");
        txttotal.setText("");
        jtgl.setDate(null);
    }
    protected void autonumber(){
        try{
            String Query = "Select kode_slip from slip_thr order by kode_slip asc";
            Statement st = conn.createStatement();
            ResultSet Res = st.executeQuery(Query);
            txtkd.setText("STHR0001");
            while(Res.next()){
                String Kode_Slip = Res.getString("kode_slip").substring(4);
                int AN = Integer.parseInt(Kode_Slip)+1;
                String Nol = "";
                if (AN<10){Nol="000";
                } else if (AN<100){Nol="00";
                }else if (AN<1000){Nol="0";
                }else if (AN<10000){Nol="";
                }
                txtkd.setText("STHR" + Nol + AN);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Auto Number Gagal"+ex);
        }
    }
    public void PegawaiTerpilih(){
        tetapkethr tt = new tetapkethr();
        tt.sT = this;
        txtnip.setText(nip);
        txtnama.setText(nama);
        txtgaji.setText(gaji);
    }
    public void UserModelTable(){
        String cari = txtcari.getText();
        Object [] Row ={"Kode Slip", "NIP","Id Admin", "Tanngal Slip", "Periode Kerja", "Total THR"};
        UserTab = new DefaultTableModel(null, Row);
        try{
            String sql = "SELECT * FROM slip_thr where kode_slip like'%"+cari+"%' order by kode_slip asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                UserTab.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2), 
                    rs.getString(3),
                    rs.getString(4), 
                    rs.getInt(5), 
                    rs.getInt(6)});     
                }TableUser.setModel(UserTab);
            }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil "+ex);
        }
    }
    protected void hitung(){
        int periode = Integer.parseInt(txtperiode.getText());
        int gapok = Integer.parseInt(txtgaji.getText());
        long total = periode/12*gapok +(gapok);
        txttotal.setText(Long.toString(total));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableUser = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtperiode = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btambah = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jtgl = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        lid = new javax.swing.JLabel();
        btotal = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        bcaripegawai = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtnip = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtgaji = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtkd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl.setBackground(new java.awt.Color(240, 240, 240));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Data Pegawai Tetap");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Data Pegawai Magang");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Gaji Pegawai Tetap");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Gaji Pegawai Magang");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("THR Pegawai Tetap");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("Data User");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator5)
                            .addComponent(jSeparator6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel4)))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TableUser.setBackground(new java.awt.Color(240, 240, 240));
        TableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIP Pegawai", "Nama Pegawai", "Alamat", "Jabatan", "Gaji"
            }
        ));
        TableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableUser);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Slip THR Pegawai");

        jLabel8.setText("Periode Kerja");

        jLabel9.setText("Kode Slip Gaji");

        txtperiode.setBackground(new java.awt.Color(240, 240, 240));

        jLabel10.setText("Tanggal Slip");

        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        bdelete.setText("Delete");
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });

        txtcari.setBackground(new java.awt.Color(240, 240, 240));

        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        bedit.setText("Ubah");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });

        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        txttotal.setBackground(new java.awt.Color(240, 240, 240));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jtgl.setDateFormatString("yyyy/MM/dd");

        jLabel13.setText("Id Admin");

        btotal.setText("Hitung Total THR");
        btotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btotalActionPerformed(evt);
            }
        });

        jLabel15.setText("Total THR");

        bcaripegawai.setText("Cari Pegawai");
        bcaripegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaripegawaiActionPerformed(evt);
            }
        });

        jLabel16.setText("NIP Pegawai");

        txtnip.setBackground(new java.awt.Color(240, 240, 240));

        jLabel17.setText("Nama Pegawai");

        txtnama.setBackground(new java.awt.Color(240, 240, 240));

        jLabel18.setText("Gaji Pokok");

        txtgaji.setBackground(new java.awt.Color(240, 240, 240));

        jButton1.setText("Batal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtkd.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLayout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(jLabel7))
                            .addGroup(pnlLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bcari, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlLayout.createSequentialGroup()
                                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlLayout.createSequentialGroup()
                                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlLayout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addGap(88, 88, 88)
                                                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btotal, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(16, 16, 16))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayout.createSequentialGroup()
                                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel8))
                                        .addGap(9, 9, 9)
                                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlLayout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtperiode, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(txtkd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)))
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel18))
                                        .addGap(23, 23, 23)
                                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtgaji, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                            .addComponent(txtnama, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                            .addComponent(txtnip, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                            .addComponent(lid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(pnlLayout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(bcaripegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel11)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayout.createSequentialGroup()
                        .addComponent(btambah, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(bkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addGap(12, 12, 12)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLayout.createSequentialGroup()
                                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtkd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jLabel10)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel8))
                            .addGroup(pnlLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(txtperiode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addComponent(btotal)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(lid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtnip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtgaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bcaripegawai)))
                .addGap(18, 18, 18)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bkeluar)
                    .addComponent(jButton1)
                    .addComponent(bdelete)
                    .addComponent(bedit)
                    .addComponent(btambah))
                .addGap(8, 8, 8)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bcari))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel11))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String FormDate = Date.format(jtgl.getDate());
        String sql = "insert into slip_thr values (?,?,?,?,?,?)";
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, txtkd.getText());
            st.setString(2, txtnip.getText());
            st.setString(3, lid.getText());
            st.setString(4, FormDate);
            st.setString(5, txtperiode.getText());
            st.setString(6, txttotal.getText());
            st.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
            txtperiode.requestFocus();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Data gagal Disimpan " +ex);
        }UserModelTable(); clear(); autonumber();
    }//GEN-LAST:event_btambahActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        UserModelTable();
    }//GEN-LAST:event_bcariActionPerformed

    private void TableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUserMouseClicked
        int row = TableUser.getSelectedRow();
        String a = UserTab.getValueAt(row, 0).toString();
        String b = UserTab.getValueAt(row, 1).toString();
        String c = UserTab.getValueAt(row, 2).toString();
        Date d = java.sql.Date.valueOf(UserTab.getValueAt(row, 3).toString());
        String e = UserTab.getValueAt(row, 4).toString();
        String f = UserTab.getValueAt(row, 5).toString();
        txtkd.setText(a);
        txtnip.setText(b);
        lid.setText(c);
        jtgl.setDate(d);
        txtperiode.setText(e);
        txttotal.setText(f);
    }//GEN-LAST:event_TableUserMouseClicked

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
        int ok = JOptionPane.showConfirmDialog(this, "Hapus","Request Confirmation",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String sql = "DELETE FROM slip_thr where kode_slip = '"+txtperiode.getText()+"'";
            try{
                PreparedStatement st = conn.prepareStatement(sql);
                st.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data Berhasil DiHapus");
                clear();
                txtperiode.requestFocus();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "Data gagal DiHapus " +ex);
            }UserModelTable(); clear(); autonumber();
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
        String FormDate = Date.format(jtgl.getDate());
        String sql = "update slip_thr set nip=?, id_admin=?, tgl_slip=?, periode=?, total=? where kode_slip='"+txtkd.getText()+"'";
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, txtnip.getText());
            st.setString(2, lid.getText());
            st.setString(3, FormDate);
            st.setString(4, txtperiode.getText());
            st.setString(5, txttotal.getText());
            st.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
            txtperiode.requestFocus();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Data gagal Disimpan " +ex);
        }UserModelTable(); clear(); autonumber();
    }//GEN-LAST:event_beditActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void btotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btotalActionPerformed
        int periode = Integer.parseInt(txtperiode.getText());
        int gapok = Integer.parseInt(txtgaji.getText());
        long total = gapok/12*periode+gapok;
        Long.toString(total);
        txttotal.setText(Long.toString(total));
    }//GEN-LAST:event_btotalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bcaripegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaripegawaiActionPerformed
        tetapkethr tt = new tetapkethr();
        tt.sT = this;
        tt.setVisible(true);
        tt.setResizable(false);
    }//GEN-LAST:event_bcaripegawaiActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        new DataLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new PegawaiTetap().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new PegawaiMagang().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        new SlipTetap().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new SlipMagang().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        new SlipTHR().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SlipTHR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableUser;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bcaripegawai;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton btambah;
    private javax.swing.JButton btotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private com.toedter.calendar.JDateChooser jtgl;
    private javax.swing.JLabel lid;
    private javax.swing.JPanel pnl;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtgaji;
    private javax.swing.JTextField txtkd;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnip;
    private javax.swing.JTextField txtperiode;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
