package firsttask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class select_worker {
	//Подключение к бд
	private Connection ConnectDB() {
        String url = "jdbc:sqlite:task.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	//Выбор нужного рабочего
	public void SelectItems(){
        String sql = "SELECT surname FROM workers ORDER BY experience DESC LIMIT 1 OFFSET 1";
        
        try (Connection conn = this.ConnectDB();
             Statement stmt  = conn.createStatement();
             ResultSet rs   = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                System.out.println(rs.getString("surname"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	public static void main(String[] args) {        
		select_worker app = new select_worker();
        app.SelectItems();
    }
}
