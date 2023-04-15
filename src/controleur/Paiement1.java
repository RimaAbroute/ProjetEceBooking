package controleur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Paiement1 extends JFrame {
    private JPanel PaymentPanel;
    private JButton annulerButton;
    private JButton btnPayer;
    private JTextField txtName;
    private JTextField txtNumero;
    private JTextField txtDatee;
    private JTextField txtCvc;
    private JPanel PaymentPanell;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Paiement");
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


    public Paiement1() {
        add(PaymentPanell);
        setTitle("Paiement");
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        connect();


        btnPayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name, numero, datee, cvc;
                name = txtName.getText();
                numero = txtNumero.getText();
                datee = txtDatee.getText();
                cvc = txtCvc.getText();
                try {
                    pst = con.prepareStatement("insert into paiement(name,numero,datee,cvc)values(?,?,?, ?)");
                    pst.setString(1, name);
                    pst.setString(2, numero);
                    pst.setString(3, datee);
                    pst.setString(4, cvc);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Paiement effectué avec succés !");
                    txtName.setText("");
                    txtNumero.setText("");
                    txtDatee.setText("");
                    txtName.requestFocus();
                    txtCvc.setText("");
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }
                Remerciement Remerciement = new Remerciement();
                Remerciement.setVisible(true);
                    dispose(); // Fermer la fenêtre actuelle après avoir ouvert la fenêtre de connexion
                }
            });


        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hebergement1 hebergement1 = new hebergement1();
                hebergement1.setVisible(true);
                dispose(); //
            }

        });

        setVisible(true);

    }
}
