import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Hello {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost";
        String dbname = "sample_app_development";
        String username = "shun";
        String password = "pess01";
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://" + hostname + ":5432/" + dbname, username, password);
            System.out.println("接続成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
