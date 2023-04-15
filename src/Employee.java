import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
///

public class Employee extends JFrame {
    private JPanel panel1;
    private JPanel Main;
    private JTextField txtName;
    private JTextField txtSalary;
    private JTextField txtMobile;
    private JButton enregistrerButton;
    private JTable table1;
    private JButton mettreÀJourButton;
    private JButton effacerButton;
    private JButton rechercherButton;
    private JTextField txtid;
    private JScrollPane table_1;
    private JTextField txtDispo;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee");
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
        try
        {
            pst = con.prepareStatement("select * from employee");
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }








    public Employee() {
            add(panel1);
            setTitle("Espace Client");
            setSize(550,550);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        connect();
        table_load();
        enregistrerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lieu, type, prix, disponible;

                lieu = txtName.getText();
                type = txtSalary.getText();
                prix = txtMobile.getText();
                disponible = txtDispo.getText();
                try {
                    pst = con.prepareStatement("insert into employee(lieu,type,prix,disponible)values(?,?,?, ?)");
                    pst.setString(1, lieu);
                    pst.setString(2, type);
                    pst.setString(3, prix);
                    pst.setString(4, disponible);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Hebergement ajouté avec succés !");
                    table_load();
                    txtName.setText("");
                    txtSalary.setText("");
                    txtMobile.setText("");
                    txtName.requestFocus();
                    txtDispo.setText("");
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }
            }


        });
        rechercherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                String empid = txtid.getText();

                pst = con.prepareStatement("select lieu,type,prix, disponible from employee where id = ?");
                pst.setString(1, empid);
                ResultSet rs = pst.executeQuery();

                if(rs.next()==true)
                {
                    String lieu = rs.getString(1);
                    String type = rs.getString(2);
                    String prix = rs.getString(3);
                    String disponible = rs.getString(4);
                    txtName.setText(lieu);
                    txtSalary.setText(type);
                    txtMobile.setText(prix);
                    txtDispo.setText(disponible);

                }
                else
                {
                    txtName.setText("");
                    txtSalary.setText("");
                    txtMobile.setText("");
                    txtDispo.setText("");
                    JOptionPane.showMessageDialog(null,"Hebergement introuvable");

                }
            }
                catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        });
        mettreÀJourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String empid,lieu, type, prix, disponible;

                lieu = txtName.getText();
                type = txtSalary.getText();
                prix = txtMobile.getText();
                disponible = txtDispo.getText();
                empid = txtid.getText();
                try {
                    pst = con.prepareStatement("update employee set lieu = ?,type = ?,prix = ?,disponible = ? where id = ?");
                    pst.setString(1, lieu);
                    pst.setString(2, type);
                    pst.setString(3, prix);
                    pst.setString(4, disponible);
                    pst.setString(5, empid);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Hebergement mis à jour !");
                    table_load();
                    txtName.setText("");
                    txtSalary.setText("");
                    txtMobile.setText("");
                    txtName.requestFocus();
                    txtDispo.setText("");
                    txtDispo.requestFocus();
                }

                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }

        });
        effacerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String empid;
                empid = txtid.getText();

                try {
                    pst = con.prepareStatement("delete from employee  where id = ?");

                    pst.setString(1, empid);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Hebergement effacé !");
                    table_load();
                    txtName.setText("");
                    txtSalary.setText("");
                    txtMobile.setText("");
                    txtName.requestFocus();
                    txtDispo.setText("");
                    txtDispo.requestFocus();
                }

                catch (SQLException e1)
                {

                    e1.printStackTrace();
                }
            }
        });
    }


}

