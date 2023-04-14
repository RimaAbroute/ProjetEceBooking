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
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        connect();


        btnPayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paiement Paiement = new Paiement();
                Paiement.setVisible(true);
                dispose(); // Fermer la fenêtre actuelle après avoir ouvert la fenêtre de connexion
            }
        });
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);

    }
}


