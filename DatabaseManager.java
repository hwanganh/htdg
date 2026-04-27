import java.sql.*;

public class DatabaseManager
{
    private static final String URL = "jdbc:sqlite:bidding.db";
    public static Connection connect() throws SQLException
    {
        return DriverManager.getConnection(URL);
    }
    public static void initDatabase()
    {
        String createProductTable = "CREATE TABLE IF NOT EXISTS products (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," + // Tự đánh số thứ tự 1,2,3,...
                "name TEXT NOT NULL," + // tên là dạng chữ và không được trống
                "price REAL," + // Giá là số thực
                "description TEXT);"; // Mô tả là dạng chữ
        String createHistoryTable = "CREATE TABLE IF NOT EXISTS history (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "product_id INTEGER," +
                "record TEXT," +
                "FOREIGN KEY(product_id) REFERENCES products(id));";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(createProductTable);
            stmt.execute(createHistoryTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}