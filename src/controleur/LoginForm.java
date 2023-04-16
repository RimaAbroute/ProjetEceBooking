package controleur;

import model.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JDialog {
    private JTextField tfEmail;
    private JPasswordField pfMdp;
    private JButton btnOK;
    private JButton btnCancel;
    private JPanel loginPanel;

    public LoginForm() {
        add(loginPanel);
        setTitle("Ece Booking");
        setSize(550,550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = String.valueOf(pfMdp.getPassword());

                user = getAuthenticatedUser(email, password);

                if (user != null) {
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "Email ou mot de passe invalide",
                            "Essayer à nouveau",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rechercheh Rechercheh = new Rechercheh();
                Rechercheh.setVisible(true);
                dispose(); // Fermer la fenêtre actuelle après avoir ouvert la fenêtre de connexion
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public Client user;
    private Client getAuthenticatedUser(String email, String password) {
        Client user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/ecebooking";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new Client();
                user.name = resultSet.getString("name");
                user.email = resultSet.getString("email");
                user.phone = resultSet.getString("phone");
                user.address = resultSet.getString("address");
                user.password = resultSet.getString("password");
            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        Client user = loginForm.user;
        if (user != null) {
            System.out.println("Connexion reussie " + user.name);
            System.out.println("          Email: " + user.email);
            System.out.println("          phone: " + user.phone);
            System.out.println("          address: " + user.address);
        }

        else {
            System.out.println("Connexion annulée");
        }
    }
}




