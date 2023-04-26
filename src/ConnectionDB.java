import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class ConnectionDB {
	private static String BDD = "db_projet";
	private static String url = "jdbc:mysql://localhost/" + BDD;
    private static String user = "root";
    private static String password = "";
    private static Connection connection;
    
    
    public static Connection getConnection() {
        if(connection == null){
            
            try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url,user,password);
            } catch (Exception e) {
             // System.out.println(e);
                System.err.println("Unable to find and load driver");
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return connection;
    } 
}