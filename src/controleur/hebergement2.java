package controleur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class hebergement2 extends JFrame {
    private JPanel panel1;
    private JButton btnPayer;
    private JButton btnAnnuler;
    private JPanel Heb2Panel;
    private JTextField textField1;
    private JPasswordField passwordField1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hebergement ");
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


    public hebergement2() {
        add(Heb2Panel);
        setTitle("Hebergement");
        setSize(1400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        connect();


        btnPayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paiement2 Paiement2 = new Paiement2();
                Paiement2.setVisible(true);
                dispose();
            }
        });
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rechercheh Rechercheh = new Rechercheh();
                Rechercheh.setVisible(true);
                dispose();
            }

        });

        setVisible(true);

    }
}

