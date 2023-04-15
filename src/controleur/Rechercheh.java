package controleur;

import model.User;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Rechercheh extends JFrame {

    public Rechercheh() {
        initComponents();
        findUsers();
    }

    public Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/ecebooking", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return con;
    }

    public ArrayList<User> ListUsers(String ValToSearch) {
        ArrayList<User> usersList = new ArrayList<User>();

        Statement st;
        ResultSet rs;

        try {
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `reserver` WHERE CONCAT(`id`, `destination`, `type`, `nbch`, `reduction`) LIKE '%" + ValToSearch + "%'";
            rs = st.executeQuery(searchQuery);

            User user;

            while (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("destination"),
                        rs.getString("type"),
                        rs.getInt("nbch"),
                        rs.getInt("reduction")
                );
                usersList.add(user);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return usersList;
    }

    public void findUsers() {
        ArrayList<User> users = ListUsers(jText_Search.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID", "Destination", "Type", "Nombre de Chambres", "Réduction en %"});
        Object[] row = new Object[5];

        for (int i = 0; i < users.size(); i++) {
            row[0] = users.get(i).getId();
            row[1] = users.get(i).getFname();
            row[2] = users.get(i).getLname();
            row[3] = users.get(i).getAge();
            row[4] = users.get(i).getReduction();
            model.addRow(row);
        }
        jTable_Users.setModel(model);

        // Ajouter un MouseListener pour détecter les clics sur les lignes du tableau
        jTable_Users.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Récupérer la ligne sélectionnée
                int row = jTable_Users.getSelectedRow();
                // Vérifier quelle ligne a été cliquée et rediriger l'utilisateur vers la page correspondante
                if (row == 0) {
                    // Créer une instance de la classe Hebergement1GUI
                    hebergement1 hebergement1 = new hebergement1();
                    // Afficher l'interface graphique
                    hebergement1.setVisible(true);
                } else if (row == 1) {
                    // Créer une instance de la classe Hebergement2GUI
                    hebergement2 hebergement2 = new hebergement2();
                    // Afficher l'interface graphique
                    hebergement2.setVisible(true);
                }
                // Fermer la fenêtre actuelle
                dispose();
            }
        });
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel2 = new JPanel();
        jButton_Search = new JButton();
        jText_Search = new JTextField();
        jScrollPane1 = new JScrollPane();
        jTable_Users = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButton_Search.setText("Search");
        jButton_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SearchActionPerformed(evt);
            }
        });

        jText_Search.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jTable_Users.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable_Users.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable_Users);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jText_Search, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton_Search)
                                                .addGap(136, 136, 136))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29))))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_Search)
                                        .addComponent(jText_Search, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(41, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }


    private void jButton_SearchActionPerformed(java.awt.event.ActionEvent evt) {

        findUsers();

    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Rechercheh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rechercheh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rechercheh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rechercheh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rechercheh().setVisible(true);
            }
        });
    }


    private JButton jButton_Search;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTable jTable_Users;
    private JTextField jText_Search;
    private JPanel panell1;
}