package sample_api;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getMemos {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost";
        String dbname = "sample_app_development";
        String username = "postgres";
        String password = "pess01";
        Connection conn = null;
    
        String sql = "SELECT * FROM memos;";

        try {
            // DB接続
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://" + hostname + ":5432/" + dbname, username, password);
            System.out.println("OK");
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            
            
            // DB取得
            result.next();
            
            System.out.println(result.getString("id"));
            System.out.println(result.getString("title"));
            System.out.println(result.getString("body"));

            System.out.println("");
            
            result.next();
            
            System.out.println(result.getString("id"));
            System.out.println(result.getString("title"));
            System.out.println(result.getString("body"));

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

