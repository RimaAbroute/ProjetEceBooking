package DAO;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DaoimplementsEmployee implements Employee {

    @Override
    public void Employee() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ecebooking";
        String user = "root";
        String password = "";
        Scanner monScann = new Scanner(System.in);
        String lieu, type, prix, disponible;


        Connection connexion = DriverManager.getConnection(url, user, password);
        Statement s = connexion.createStatement();
        String rqtSql = "INSERT INTO employee (lieu, type, prix, disponible) VALUES ('?','?','?','?')";
        s.executeUpdate(rqtSql);
        System.out.println("Hébérgement mis à jour avec succés !");

    }
}
