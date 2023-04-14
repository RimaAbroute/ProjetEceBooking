import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Reserver extends JFrame {

    private JPanel ReserverPanel;
    private JTextField txtName;
    private JTextField txtSalary;
    private JTextField txtMobile;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JCheckBox procheDuCentreCheckBox;
    private JCheckBox piscineCheckBox;
    private JCheckBox vueDégagéeCheckBox;
    private JCheckBox jardinCheckBox;
    private JButton btnRechercher;
    private JButton btnAnnuler;
    private JTable table2;
    private JTextField txtid;

    public static void main(String[] args) {
        Reserver myFrame = new Reserver();
    }

    Connection con;
    PreparedStatement pst;

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/ecebooking", "root", "");
            System.out.println("Succés");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void table_load() {
        try {
            pst = con.prepareStatement("select * from reserver");
            ResultSet rs = pst.executeQuery();
            table2.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Reserver() {
        add(ReserverPanel);
        setTitle("Espace Client");
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        connect();
        table_load();

        // Ajout d'un listener pour écouter les événements de sélection de la ligne dans la table
        table2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // Si une ligne est sélectionnée
                if (table2.getSelectedRow() > -1) {
                    // Récupération de l'id de l'hébergement sélectionné
                    String empid = table2.getValueAt(table2.getSelectedRow(), 0).toString();
                    // Ouverture de la page de paiement avec les informations de l'hébergement sélectionné
                    LoginForm myFrame = new LoginForm();
                }
            }
        });

        btnRechercher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String empid = txtid.getText();

                    pst = con.prepareStatement("select destination,datea,dateb from reserver where id = ?");
                    pst.setString(1, empid);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next() == true) {
                        String destination = rs.getString(1);
                        String datea = rs.getString(2);
                        String dateb = rs.getString(3);
                        txtName.setText(destination);
                        txtSalary.setText(datea);
                        txtMobile.setText(dateb);

                    } else {
                        txtName.setText("");
                        txtSalary.setText("");
                        txtMobile.setText("");
                        JOptionPane.showMessageDialog(null, "Hebergement introuvable");

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        });
    }
}
