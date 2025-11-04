package hospital.Management.System; // Uncomment if you are using this package

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    // --- DECLARED AS PUBLIC INSTANCE VARIABLES ---
    public Connection connection;
    public static Statement statement;

    public conn() {
        try {
            // --- INITIALIZED THE INSTANCE VARIABLES ---
            // Replace "Root" with your actual MySQL password
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root", "Root@123");
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}