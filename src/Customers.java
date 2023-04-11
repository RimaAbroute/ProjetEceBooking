
import java.sql.*;
import java.util.Date;

public class Customers {

    private String id;
    private String name;
    private String type;
    private String address;
    private String phone;
    private String email;

    public Customers(String name, String type, String address) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public static Customers login(String email, String password) {
        try {
            String url = "jdbc:mysql://localhost:3306/car_rental";
            String user = "root";
            String dbpassword  = "root";

            Connection cnx = DriverManager.getConnection(url, user, dbpassword);
            PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM customers WHERE email = ? AND password = ?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                Customers customer = new Customers(name, type, address);
                return customer;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getCustomerID() {
        return id;
    }

    public void setCustomerID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String email) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }





    public void register() {
        try {
            String url = "jdbc:mysql://localhost:3306/car_rental";
            String user = "root";
            String dbpassword  = "root";

            Connection cnx = DriverManager.getConnection(url, user, dbpassword);
            PreparedStatement stmt = cnx.prepareStatement("INSERT INTO customers (name, type, address, phone, email) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, type);
            stmt.setString(3, address);
            stmt.setString(4, phone);
            stmt.setString(5, email);
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



}
