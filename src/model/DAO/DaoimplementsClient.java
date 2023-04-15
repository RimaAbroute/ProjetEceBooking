package model.DAO;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DaoimplementsClient implements DaointerfaceClient {
    @Override
    public void AjouterClient() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ecebooking";
        String user = "root";
        String password = "";

            Connection connexion = DriverManager.getConnection(url, user, password);
            Statement s = connexion.createStatement();
            String rqtSql = "INSERT INTO client (email, password) VALUES ('?','?')";
            s.executeUpdate(rqtSql);
            System.out.println("Un client a été ajouté");


    }

    @Override
    public void ModifierClient() {

    }

    @Override
    public void SupprimerClient() {

    }
}
