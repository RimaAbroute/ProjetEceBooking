import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class discount {
    private int discountID;
    private String customerType;
    private int discountPercentage;


    public discount(int discountID) {
        this.discountID = discountID;
        this.customerType = customerType;
        this.discountPercentage = discountPercentage;
    }

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    // Method to add a new discount to the database
    public void addDiscount() {
        try {
            String url = "jdbc:mysql://localhost:3306/ecebooking";
            String user = "root";
            String dbpassword  = "";

            Connection cnx = DriverManager.getConnection(url, user, dbpassword);
            PreparedStatement stmt = cnx.prepareStatement("INSERT INTO discounts (customerType, discountPercentage) VALUES (?, ?)");
            stmt.setString(1, customerType);
            stmt.setInt(2, discountPercentage);
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateDiscount(int discountID, int discountPercentage) {
        try {
            String url = "jdbc:mysql://localhost:3306/ecebooking";
            String user = "root";
            String dbpassword  = "";

            Connection cnx = DriverManager.getConnection(url, user, dbpassword);
            PreparedStatement stmt = cnx.prepareStatement("UPDATE discounts SET discountPercentage = ? WHERE discountID = ?");
            stmt.setInt(1, discountPercentage);
            stmt.setInt(2, discountID);
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removediscount() {
        try {
            String url = "jdbc:mysql://localhost:3306/ecebooking";
            String user = "root";
            String dbpassword  = "";

            Connection cnx = DriverManager.getConnection(url, user, dbpassword);
            PreparedStatement stmt = cnx.prepareStatement("DELETE FROM discounts WHERE discountID = ?");
            stmt.setInt(1, discountID);
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}