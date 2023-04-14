
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Orders {
    private int id;
    private int hebergementID;
    private int usersID;
    private Date startDate;
    private Date endDate;
    private int total;

    public Orders(int orderID, int hebergementID, String id, Date startDate, Date endDate, int usersID) {
        this.id = orderID;
        this.hebergementID = hebergementID;
        this.usersID = usersID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.total = total;
    }

    public int getOrderID() {
        return id;
    }

    public void setOrderID(int orderID) {
        this.id = orderID;
    }

    public int gethebergementID() {
        return hebergementID;
    }

    public void sethebergementID(int carID) {
        this.hebergementID = hebergementID;
    }

    public int getusersID() {
        return usersID;
    }

    public void setCustomerID(int usersID) {
        this.usersID = usersID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }




    public hebergement gethebergement() {
        // Retrieve the car from the database based on the car ID
        hebergement hebergement = null;
        try {
            String url = "jdbc:mysql://localhost:3306/database";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM hebergement WHERE id = ?");
            stmt.setInt(1, hebergementID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                hebergement = new hebergement(rs.getString("type"), rs.getString("lieu"), rs.getInt("id"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hebergement;
    }


    public Customers getCustomers() {
        // Retrieve the customer from the database based on the customer ID
        Customers customers = null;
        try {
            String url = "jdbc:mysql://localhost:3306/database";
            String user = "root";
            String password = "";

            Connection cnx = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM clients WHERE clientID = ?");
            stmt.setInt(1, usersID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                customers = new Customers(rs.getString("name"), rs.getString("type"), rs.getString("address"));
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customers;
    }
}

