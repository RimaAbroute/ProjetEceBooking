package DAO;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DaoimplementsRechercheh implements Rechercheh {

    @Override
    public void Rechercheh() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ecebooking";
        String user = "root";
        String password = "";
        Scanner monScann = new Scanner(System.in);


        Connection connexion = DriverManager.getConnection(url, user, password);
        Statement s = connexion.createStatement();
        String rqtSql = "INSERT INTO reserver (destination, type, nbch) VALUES ('?','?','?')";
        s.executeUpdate(rqtSql);
        System.out.println("Succès de la réservation!");

    }
}
