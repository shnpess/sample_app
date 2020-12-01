package sample_api;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class postMemos {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost";
        String dbname = "sample_app_development";
        String username = "postgres";
        String password = "pess01";
        Connection conn = null;
        String sql = "insert into memos(id,title,body) VALUES(?,?,?)";

        try {
            // DB接続
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://" + hostname + ":5432/" + dbname, username, password);
            PreparedStatement ps = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            ps.setInt(1,5);
            ps.setString(2,"4のタイトル");
            ps.setString(3,"4の本文");
            ps.executeUpdate();
            conn.commit();

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

