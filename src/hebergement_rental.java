
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class hebergement_rental extends javax.swing.JFrame {

    public hebergement_rental() {
        initComponents();
        LoadCatid();
        table_update();

        txtdate.setDateFormatString("yyyy/MM/dd");
        txtdue.setDateFormatString("yyyy/MM/dd");

        txtmodel.setEnabled(false);
        txtprice.setEnabled(false);
        txttype.setEnabled(false);
        txtdiscount.setEnabled(false);
    }
    PreparedStatement pst;
    ResultSet rs;
    PreparedStatement pst1;
    PreparedStatement pst2;
    PreparedStatement pst3;
    PreparedStatement pst4;

    public void LoadCatid(){


        {Connection conn = null;
            try {

                String url       = "jdbc:mysql://localhost:3306/database";
                String user      = "root";
                String password  = "";

                conn = DriverManager.getConnection(url, user, password);
                pst = conn.prepareStatement("select * from hebergements");
                rs = pst.executeQuery();

                combocarID.removeAllItems();

                while(rs.next())
                {
                    combocarID.addItem(rs.getString(2));
                }
            } catch (SQLException ex) {
                Logger.getLogger(hebergement_rental.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    private void table_update() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/database";
            String user = "root";
            String password = "";

            conn = DriverManager.getConnection(url, user, password);
            pst = conn.prepareStatement("SELECT * FROM hebergements");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rd = rs.getMetaData();
            int c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 1; i <= c; i++) {
                    v.add(rs.getString("hebergements_no"));
                    v.add(rs.getString("type"));
                    v.add(rs.getString("lieu"));
                    v.add(rs.getString("available"));
                    v.add(rs.getDouble("pricePerDay"));
                    v.add(rs.getDouble("discount"));
                }
                df.addRow(v);
            }

        } catch (SQLException ex) {
            Logger.getLogger(carreg.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txttype = new javax.swing.JTextField();
        txtmodel = new javax.swing.JTextField();
        txtavl = new javax.swing.JTextField();
        txtcustname = new javax.swing.JTextField();
        txtdiscount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        combocarID = new javax.swing.JComboBox<>();
        txtdate = new com.toedter.calendar.JDateChooser();
        txtdue = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Car ID");

        jLabel3.setText("Customer Name");

        jLabel5.setText("Date");

        jLabel6.setText("due date ");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "id", "type", "Model", "Available", "PricePerDay", "Discount"
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

        jLabel10.setText("Click here to choose your car ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(103, 103, 103))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(111, Short.MAX_VALUE))
        );

        txttype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttypeActionPerformed(evt);
            }
        });

        txtavl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtavlActionPerformed(evt);
            }
        });

        jLabel2.setText("type");

        jLabel4.setText("model");

        jLabel7.setText("Price");

        jLabel8.setText("Discount");

        jLabel9.setText("Avl");

        combocarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocarIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(260, 260, 260))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(212, 212, 212)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(txtprice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtcustname, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(txtmodel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                                                                .addComponent(txttype, javax.swing.GroupLayout.Alignment.LEADING))
                                                                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtdue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(combocarID, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(txtavl, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(55, 55, 55)
                                                .addComponent(jButton2)
                                                .addGap(46, 46, 46))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(combocarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel9)
                                                        .addComponent(txtavl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                .addGap(27, 27, 27)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4))
                                                .addGap(43, 43, 43)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7))
                                                .addGap(32, 32, 32)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8))
                                                .addGap(42, 42, 42)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtcustname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1)
                                                        .addComponent(jButton2))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addGap(2, 2, 2)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(txtdue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String car_id = combocarID.getSelectedItem().toString();
        String cust_id = txtcustname.getText();

        if (cust_id.equals("")) {
            JOptionPane.showMessageDialog(this, "Entrer le nom du client");
            return;
        }
        if (txtdate.getDate() == null || txtdue.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Selectionner une date");
            return;
        }
        SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
        String date = Date_Format.format(txtdate.getDate());
        SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyyy-MM-dd");
        String due = Date_Format1.format(txtdue.getDate());

        Connection conn = null;
        try {
            // db parameters - ptest is the name of the database
            String url = "jdbc:mysql://localhost:3306/database";
            String user = "root";
            String password = "";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);

            // retrieve pricePerDay and discount for selected car
            pst1 = conn.prepareStatement("select pricePerDay, discount from cars where cars_no = ?");
            pst1.setString(1, car_id);
            ResultSet rs = pst1.executeQuery();
            rs.next();



            double pricePerDay = rs.getDouble("PricePerDay");
            double discount = rs.getDouble("discount");

            // calculate total price
            long diffInMillies = Math.abs(txtdue.getDate().getTime() - txtdate.getDate().getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            double totalPrice = (pricePerDay * diff * discount) ;

            pst2 = conn.prepareStatement("SELECT available FROM cars WHERE cars_no = ?");
            pst2.setString(1, car_id);
            ResultSet rs2 = pst2.executeQuery();
            rs2.next();
            String available = rs2.getString("available");

            // If the selected car is not available, display an error message
            if (available.equals("No")) {
                JOptionPane.showMessageDialog(this, "Hebergement selectionne n'est pas disponible.");
                return;
            }
            // insert order into orders table
            pst3 = conn.prepareStatement("insert into orders(cars_no, name, start_date, end_date, duration, price) values (?, ?, ?, ?, ?, ?)");
            pst3.setString(1, car_id);
            pst3.setString(2, cust_id);
            pst3.setString(3, date);
            pst3.setString(4, due);
            pst3.setLong(5, diff);
            pst3.setDouble(6, totalPrice);
            pst3.executeUpdate();

            // update available status of car
            pst3 = conn.prepareStatement("update cars set available='No' where cars_no=?");
            pst3.setString(1, car_id);
            pst3.executeUpdate();

            // display success message with total price
            JOptionPane.showMessageDialog(this, "Success. Total price: $" + totalPrice);
            new payement().setVisible(true);
            this.dispose();

        } catch (SQLException ex) {
            Logger.getLogger(hebergement_rental.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        new homepage().setVisible(true);
        this.dispose();

    }

    private void txtavlActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {

        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        combocarID.setSelectedItem(d1.getValueAt(selectIndex, 0).toString());
        txttype.setText(d1.getValueAt(selectIndex, 1).toString());
        txtmodel.setText(d1.getValueAt(selectIndex, 2).toString());
        txtprice.setText(d1.getValueAt(selectIndex, 4).toString());
        txtdiscount.setText(d1.getValueAt(selectIndex, 5).toString());
        txtavl.setText(d1.getValueAt(selectIndex, 3).toString());
    }

    private void txttypeActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void combocarIDActionPerformed(java.awt.event.ActionEvent evt) {
        String car_id = combocarID.getSelectedItem().toString();
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/database";
            String user = "root";
            String password = "";

            conn = DriverManager.getConnection(url, user, password);
            pst2 = conn.prepareStatement("SELECT * FROM hebergements WHERE hebergement_no = ?");
            pst2.setString(1, car_id);
            rs = pst.executeQuery();
            if (rs.next() == false) {
                JOptionPane.showMessageDialog(this, "Hebergement non trouve");
            } else {
                String type = rs.getString("type");
                String model = rs.getString("lieu");
                double price = rs.getDouble("PricePerDay");
                double discount = rs.getDouble("discount");
                String available = rs.getString("available");

                combocarID.setSelectedItem(car_id);
                txttype.setText(type);
                txtmodel.setText(model);
                txtprice.setText(String.valueOf(price));
                txtdiscount.setText(String.valueOf(discount));
                txtavl.setText(available);

            }
        } catch (SQLException ex) {
            Logger.getLogger(hebergement_rental.class.getName()).log(Level.SEVERE, null, ex);

        }






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
            java.util.logging.Logger.getLogger(hebergement_rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hebergement_rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hebergement_rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hebergement_rental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hebergement_rental().setVisible(true);
            }
        });
    }

    private javax.swing.JComboBox<String> combocarID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtavl;
    private javax.swing.JTextField txtcustname;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtdiscount;
    private com.toedter.calendar.JDateChooser txtdue;
    private javax.swing.JTextField txtmodel;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txttype;


}
