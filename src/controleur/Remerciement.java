package controleur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Remerciement extends JFrame {
    private JPanel MerciPanel;
    private JButton btnBienvenue;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Merci ");
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


    public Remerciement() {
        add(MerciPanel);
        setTitle("Merci");
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        connect();


        btnBienvenue.addActionListener(new ActionListener() {
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
