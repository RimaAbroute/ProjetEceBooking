
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Profil extends javax.swing.JFrame {


    ImageIcon ProfilImage = new ImageIcon();
    public Profil() {
        initComponents();
        this.setLocationRelativeTo(null);
        labelPic.setText("");
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        Usernametxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descriptionarea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        mailtxt = new javax.swing.JTextField();
        phonetxt = new javax.swing.JTextField();
        addresstxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        DescriptionLabel = new javax.swing.JLabel();
        mailLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        labelPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Client regulier", "Client occasionnel", "Employe", " " }));
        jComboBox1.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jComboBox1HierarchyChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        Descriptionarea.setColumns(20);
        Descriptionarea.setRows(5);
        jScrollPane1.setViewportView(Descriptionarea);

        jButton1.setText("Envoyer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Profil");

        UsernameLabel.setText("Pseudo");

        DescriptionLabel.setText("Description");

        mailLabel.setText("mail");

        phoneLabel.setText("Numero de telephone");

        addressLabel.setText("addresse");

        jButton2.setText("Selectionner une photo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 327, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(287, 287, 287))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(UsernameLabel)
                                        .addComponent(DescriptionLabel)
                                        .addComponent(mailLabel)
                                        .addComponent(phoneLabel)
                                        .addComponent(addressLabel))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(phonetxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                        .addComponent(mailtxt, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(Usernametxt, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addresstxt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(labelPic, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton2)
                                                .addGap(88, 88, 88))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(211, 211, 211))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(261, 261, 261))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(UsernameLabel)
                                        .addComponent(Usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(DescriptionLabel)))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(mailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mailLabel))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(phonetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phoneLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addresstxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addressLabel))
                                .addGap(39, 39, 39)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(26, 26, 26))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(labelPic, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jButton2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jComboBox1HierarchyChanged(java.awt.event.HierarchyEvent evt) {

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        ResultSet rs = null;
        Connection conn = null;

        try {

            String url = "jdbc:mysql://localhost:3306/database";
            String user = "root";
            String pass  = "";

            String name = Usernametxt.getText();
            String address = addresstxt.getText();
            String phone = phonetxt.getText();
            String mail = mailtxt.getText();
            String description = Descriptionarea.getText();

            conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = conn.prepareStatement("UPDATE users SET name=?, address=?, email=?, phone=?, description=? WHERE users_id=(SELECT MAX(users_id) FROM users)");
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, mail);
            pst.setString(4, phone);
            pst.setString(5, description);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Customer information updated successfully");
                pst = conn.prepareStatement("SELECT * FROM users WHERE users_id=(SELECT MAX(users_id) FROM users)");
                rs = pst.executeQuery();
                if (rs.next()) {
                    Descriptionarea.setText("Description: " + rs.getString("description"));
                    Usernametxt.setText("Nom: " + rs.getString("name"));
                    addresstxt.setText("Addresse: " + rs.getString("address"));
                    phonetxt.setText("numero de tel: " + rs.getString("phone"));
                    mailtxt.setText("Email: " + rs.getString("email"));
                }
            } else {
                    JOptionPane.showMessageDialog(null, "Erreur");
            }
            conn.close();
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        new homepage().setVisible(true);
        this.dispose();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Create a new file chooser dialog
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selectionner une photo");

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Image files", "jpg", "jpeg", "gif", "png");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(new JFrame());

        if (result == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();

            BufferedImage Image = null;
            try {
                Image = ImageIO.read(file);
            } catch (IOException ex) {
                Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Create a new JLabel with the image

            labelPic.setIcon( ProfilImage);

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
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profil().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JTextArea Descriptionarea;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JTextField Usernametxt;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addresstxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPic;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JTextField mailtxt;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phonetxt;
    // End of variables declaration
}

