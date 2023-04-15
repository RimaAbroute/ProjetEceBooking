
import java.sql.ResultSetMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

////
public class carreg extends javax.swing.JFrame {

    public carreg() {
        initComponents();
        autoID();
        table_update();
    }
    Connection con;
    PreparedStatement pst;

    @SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txttype = new javax.swing.JTextField();
        txtregno = new javax.swing.JTextField();
        txtmodel = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Comavl = new javax.swing.JComboBox<>();
        txtprice = new javax.swing.JTextField();
        txtdiscount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Car id");

        jLabel2.setText("Type");

        jLabel3.setText("Model");

        jLabel4.setText("Disponible");

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modifier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Annuler");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txttype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttypeActionPerformed(evt);
            }
        });

        txtregno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtregnoActionPerformed(evt);
            }
        });

        txtmodel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmodelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "id", "type", "lieu", "Available", "PricePerDay", "Discount"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Comavl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oui", "Non" }));
        Comavl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComavlActionPerformed(evt);
            }
        });

        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });

        txtdiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiscountActionPerformed(evt);
            }
        });

        jLabel5.setText("Prix");

        jLabel6.setText("Reduction");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(94, 94, 94)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtregno, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Comavl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(txtdiscount, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(txtprice, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(txtmodel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton1)
                                                        .addComponent(jButton3))
                                                .addGap(61, 61, 61)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton4)
                                                        .addComponent(jButton2))))
                                .addGap(179, 179, 179)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(txtregno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(22, 22, 22)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6))
                                                .addGap(14, 14, 14)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(Comavl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton2)
                                                        .addComponent(jButton1))
                                                .addGap(28, 28, 28)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton3)
                                                        .addComponent(jButton4))
                                                .addGap(0, 72, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );

        pack();
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();

        int selectIndex =jTable1.getSelectedRow();
        txtregno.setText(d1.getValueAt(selectIndex,0).toString());
        txttype.setText(d1.getValueAt(selectIndex,1).toString());
        txtmodel.setText(d1.getValueAt(selectIndex,2).toString());
        txtprice.setText(d1.getValueAt(selectIndex,4).toString());
        txtdiscount.setText(d1.getValueAt(selectIndex,5).toString());


        Comavl.setSelectedItem(d1.getValueAt(selectIndex,3).toString());



    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex =jTable1.getSelectedRow();
        String id = d1.getValueAt(selectIndex, 0).toString();
        int dialogResult=JOptionPane.showConfirmDialog(this,"Voulez-vous effacer ceci?","warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            {Connection conn = null;
                try {
                    // db parameters - ptest is the name of the database
                    String url       = "jdbc:mysql://localhost:3306/database";
                    String user      = "root";
                    String password  = "";

                    // create a connection to the database
                    conn = DriverManager.getConnection(url, user, password);
                    pst = conn.prepareStatement("delete from hebergements where hebergement_no = ?");
                    pst.setString(1, id);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Effacé");
                    table_update();
                }catch (SQLException ex){
                    Logger.getLogger(carreg.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        new homepage().setVisible(true);
        this.dispose();

    }

    private void txtdiscountActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txtregnoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void ComavlActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        String rgno =txtregno.getText();
        String type = txttype.getText();
        String mod = txtmodel.getText();

        String aval = Comavl.getSelectedItem().toString();
        double price = Double.parseDouble(txtprice.getText());
        double promotion = Double.parseDouble(txtdiscount.getText());

        {Connection conn = null;
            try {
                // db parameters - ptest is the name of the database
                String url       = "jdbc:mysql://localhost:3306/database";
                String user      = "root";
                String password  = "";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);
                // more processing here
                pst = conn.prepareStatement("insert into hebergements(hebergement_no,type,lieu,available,PricePerDay,discount) values(?,?,?,?,?,?)");
                pst.setString(1,rgno);
                pst.setString(2,type);
                pst.setString(3,mod);

                pst.setString(4,aval);
                pst.setDouble(5,price);
                pst.setDouble(6,promotion);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this,"Hebergement ajoute");

                txttype.setText("");
                txtmodel.setText("");
                Comavl.setSelectedIndex(-1);
                txtprice.setText("");
                txtdiscount.setText("");
                txttype.requestFocus();
                autoID();
                table_update();

            }catch(SQLException ex){
                Logger.getLogger(carreg.class.getName()).log(Level.SEVERE,null,ex);

            }}
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex =jTable1.getSelectedRow();
        {Connection conn = null;
            try {

                String id = d1.getValueAt(selectIndex, 0).toString();
                String type = txttype.getText();
                String mod = txtmodel.getText();
                String status = Comavl.getSelectedItem().toString();
                double price = Double.parseDouble(txtprice.getText());
                double promotion = Double.parseDouble(txtdiscount.getText());

                // db parameters - ptest is the name of the database
                String url       = "jdbc:mysql://localhost:3306/database";
                String user      = "root";
                String password  = "";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);

                pst =conn.prepareStatement("update hebergements set type =?,lieu=?, available=?,pricePerDay=?,discount=? where hebergement_no=?");
                pst.setString(1, type);
                pst.setString(2, mod);
                pst.setString(3, status);
                pst.setString(6, id);
                pst.setDouble(4,price);
                pst.setDouble(5,promotion);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, "Mise a jour faite avec succes");
                table_update();
            }
            catch (SQLException ex) {
                Logger.getLogger(carreg.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void txtmodelActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void txttypeActionPerformed(java.awt.event.ActionEvent evt) {

    }



    public void table_update(){
        int c;
        {Connection conn = null;
            try {
                String url       = "jdbc:mysql://localhost:3306/database";
                String user      = "root";
                String password  = "";


                conn = DriverManager.getConnection(url, user, password);
                pst = conn.prepareStatement("select * from hebergements");
                ResultSet rs = pst.executeQuery();
                ResultSetMetaData rd = rs.getMetaData();
                c=rd.getColumnCount();
                DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
                df.setRowCount(0);

                while(rs.next())
                {
                    Vector v2 = new Vector();
                    for(int i =1; i<=c;i++)
                    {
                        v2.add(rs.getString("cars_no"));
                        v2.add(rs.getString("type"));
                        v2.add(rs.getString("lieu"));
                        v2.add(rs.getString("available"));
                        v2.add(rs.getDouble("pricePerDay"));
                        v2.add(rs.getDouble("discount"));
                    }
                    df.addRow(v2);
                }


            }       catch (SQLException ex) {
                Logger.getLogger(carreg.class.getName()).log(Level.SEVERE, null, ex);
            }

            finally {
                try {
                    if(con != null)
                        con.close();
                } catch(SQLException ex) {
                    Logger.getLogger(carreg.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
    }
    public void autoID()
    {Connection conn = null;
        try {
            String url       = "jdbc:mysql://localhost:3306/database";
            String user      = "root";
            String password  = "";


            conn = DriverManager.getConnection(url, user, password);

            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select Max(hebergement_no) from hebergements");
            rs.next();

            if (rs.getString("Max(hebergement_no)")==null){
                txtregno.setText("C00001");
            }
            else
            {
                long id = Long.parseLong(rs.getString("Max(hebergement_no)").substring(2,rs.getString("Max(hebergement_no)").length()));
                id++;
                txtregno.setText("C0"+ String.format("%03d", id));
            }
        }       catch (SQLException ex) {
            Logger.getLogger(carreg.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException ex){
                Logger.getLogger(carreg.class.getName()).log(Level.SEVERE,null,ex);
            }}
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(carreg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(carreg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(carreg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(carreg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new carreg().setVisible(true);
            }
        });
    }
    private javax.swing.JComboBox<String> Comavl;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtdiscount;
    private javax.swing.JTextField txtmodel;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtregno;
    private javax.swing.JTextField txttype;

}
