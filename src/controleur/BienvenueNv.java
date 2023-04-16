package controleur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BienvenueNv extends JFrame {
    private JPanel panel1;
    private JPanel BienvenuePanel;
    private JButton btnRechercher;
    private JButton btnAnnuler;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bienvenue ");
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


    public BienvenueNv() {
        add(BienvenuePanel);
        setTitle("Bienvenue");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        connect();


        btnRechercher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RechercherNv RechercherNv = new RechercherNv();
                RechercherNv.setVisible(true);
                dispose();
            }
        });
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homescreen Homescreen = new Homescreen();
                Homescreen.setVisible(true);
                dispose();
            }
        });

        setVisible(true);

    }
}
