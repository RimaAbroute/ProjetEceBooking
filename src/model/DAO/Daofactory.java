package model.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Daofactory {



    public void Connexion() {

            String url = "jdbc:mysql://localhost:3306/ecebooking";
            String user = "root";
            String password = "";

            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }





