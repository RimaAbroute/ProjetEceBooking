import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homescreen extends JFrame {

    private JPanel mainPanel;
    private JButton btnClient;

    private JButton btnEmploye;
    private JButton btnNouveau;

    public Homescreen() {
         add(mainPanel);
         setTitle("Ece Booking");
         setSize(550,550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         setLocationRelativeTo(null);
         setVisible(true);
        btnClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
                dispose(); // Fermer la fenêtre actuelle après avoir ouvert la fenêtre de connexion
            }
        });
        btnNouveau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationForm RegistrationForm = new RegistrationForm();
                RegistrationForm.setVisible(true);
                dispose(); // Fermer la fenêtre actuelle après avoir ouvert la fenêtre de connexion
            }
        });
        btnEmploye.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFormEm LoginFormEm = new LoginFormEm();
                LoginFormEm.setVisible(true);
                dispose(); // Fermer la fenêtre actuelle après avoir ouvert la fenêtre de connexion
            }
        });
     }


     public static void main(String[]args){
         Homescreen myFrame = new Homescreen();




     }
}
