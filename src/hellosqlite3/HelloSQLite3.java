/*
* Simple code to connect to a SQLite3 database and print a single
* row from a table.
* 
* Based on http://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/
*/

package hellosqlite3;
 
import java.sql.*;
import org.sqlite.SQLiteConfig;

public class HelloSQLite3 {
     /**
     * Connect to a sample database
     */
    public static void testCanConnect() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // db parameters (assumes movies.db is in the same directory)
            String url = "jdbc:sqlite:movies.db";
            // create a connection to the database
            SQLiteConfig config = new SQLiteConfig();
            config.enableLoadExtension(true);
            conn = DriverManager.getConnection(url, config.toProperties());

            System.out.println("Connection to SQLite has been established.");

            // Ensure we can query the actors table
            stmt = conn.createStatement();

            try {
                stmt.execute("SELECT load_extension('./lib/libsimple-osx-x64/libsimple', 'sqlite3_simple_init')");
                stmt.execute("SELECT jieba_dict('./lib/libsimple-osx-x64/dict')");
            } catch (Exception e) {
                System.out.println("Unable to load libsimple.so: " + e.getMessage());
            }


            ResultSet rs = stmt.executeQuery("SELECT jieba_query('我是中国人民的儿子，我深情地爱着我的祖国和人民') as query;");
            while ( rs.next() ) {
                String query = rs.getString("query");
                System.out.println(String.format("jieba_query: %s", query));
            }
            rs.close();  


            rs = stmt.executeQuery("SELECT * FROM ACTORS LIMIT 1;");
            while ( rs.next() ) {
                String  name = rs.getString("name");
                System.out.println(String.format("Found %s", name));
            }
            rs.close();  
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testCanConnect();
    }
}
