import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class employee {
    private int employeeID;
    private String name;
    private String username;
    private String password;


    public employee(String name, String username, String password) {
        this.employeeID = employeeID;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method to add a car to the database
    public void addCar(hebergement car) {
        Connection cnx = null;
        PreparedStatement stmt = null;
        try {
            String url = "jdbc:mysql://localhost:3306/car_rental";
            String user = "root";
            String dbpassword  = "root";

            cnx = DriverManager.getConnection(url, user, dbpassword);
            stmt = cnx.prepareStatement("INSERT INTO cars ( make, model, PricePerDay) VALUES ( ?, ?, ?, ?)");
            stmt.setString(2, car.getmake());
            stmt.setInt(4, car.getPricePerDay());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    //Method to update the price per day of a car in the database
    public void updateCarPrice(int carID, int pricePerDay) {
        Connection cnx = null;
        PreparedStatement stmt = null;
        try {
            String url = "jdbc:mysql://localhost:3306/car_rental";
            String user = "root";
            String dbpassword  = "root";

            cnx = DriverManager.getConnection(url, user, dbpassword);
            stmt = cnx.prepareStatement("UPDATE cars SET pricePerDay = ? WHERE id = ?");
            stmt.setInt(1, pricePerDay);
            stmt.setInt(2, carID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Method to remove a car from the database
    public void removeCar(int carID) {
        Connection cnx = null;
        PreparedStatement stmt = null;
        try {
            String url = "jdbc:mysql://localhost:3306/car_rental";
            String user = "root";
            String dbpassword  = "root";

            cnx = DriverManager.getConnection(url, user, dbpassword);
            stmt = cnx.prepareStatement("DELETE FROM cars WHERE id = ?");
            stmt.setInt(1, carID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}