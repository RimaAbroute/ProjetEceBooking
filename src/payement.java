
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

public class payement extends javax.swing.JFrame {


    public void sendEmail(String emailAddress, String subject, String message) {
        String from = "guitduy@gmail.com";
        String password = "nozpesjnpbbilyzf";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        });

        try {
            Message mailMessage = new MimeMessage(session);
            mailMessage.setFrom(new InternetAddress(from));
            mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddress));
            mailMessage.setSubject(subject);
            mailMessage.setText(message);

            Transport.send(mailMessage);
        } catch (MessagingException ex) {

            ex.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")



    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String cardNumber = cardnumbertxt.getText();
        String Name = nametxt.getText();
        String CVC = CVCtxt.getText();

        if (cardNumber.length() != 16 || !isNumeric(cardNumber)) {
            JOptionPane.showMessageDialog(this, "Entrez un numero de carte valide");
            return;
        }

        if (!isAlphabetic(Name)) {
            JOptionPane.showMessageDialog(this, "Entrer le nom du proprietaire de la carte.");
            return;
        }



        if (CVC.length() != 3 || !isNumeric(CVC)) {
            JOptionPane.showMessageDialog(this, "Entrer un code valide");
            return;
        }

        {Connection conn = null;
            try {
                String url       = "jdbc:mysql://localhost:3306/database";
                String user      = "root";
                String password  = "";


                conn = DriverManager.getConnection(url, user, password);

                String sql = "SELECT email FROM customers WHERE name = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, Name);

                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            String emailAddress = rs.getString("email");

                            // Envoyer un e-mail de confirmation
                            String subject = "Payment fait avec succes";
                            String message = "Chere client,\n\nMerci pour votre paiement";
                            sendEmail(emailAddress, subject, message);

                            JOptionPane.showMessageDialog(this, "Paiement fait avec succes. Un email de confirmation vous a ete envoye " + emailAddress); // Afficher une boîte de dialogue avec un message de confirmation
                        } else {
                            JOptionPane.showMessageDialog(this, "Numero de carte invalide."); // Si la requête ne retourne pas d'enregistrement, afficher une boîte de dialogue avec un message d'erreur
                        }

                    }
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "erreur lorsq de la connexion a la base de donnee.");
            }
        }
        new homepage().setVisible(true);
        this.dispose();

    }

    private boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    private boolean isAlphabetic(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }
    private boolean isValidExpirationDate(String str) {
        if (str.length() != 5 || str.charAt(2) != '/') {
            return false;
        }

        String[] parts = str.split("/");
        if (parts.length != 2 || !isNumeric(parts[0]) || !isNumeric(parts[1])) {
            return false;
        }

        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);
        return (month >= 1 && month <= 12 && year >= 21 && year <= 99);

    }

    private void cardnumbertxtActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void CVCtxtActionPerformed(java.awt.event.ActionEvent evt) {

    }


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(payement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new payement().setVisible(true);
            }
        });
    }


    private javax.swing.JTextField CVCtxt;
    private javax.swing.JTextField cardnumbertxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nametxt;


}