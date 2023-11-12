package firsttask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class create_table {
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
	//Создание таблицы
	public static void CreateTable() {
        String url = "jdbc:sqlite:task.db";
        String sql = "CREATE TABLE IF NOT EXISTS workers (\n"
                + "	id NUMBER PRIMARY KEY,\n"
                + "	surname VARCHAR(255),\n"
                + "	experience NUMBER\n"
                + ");";
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	//Добавление рабочих в таблицу
	public void InsertItems(String surname, double experience) {
        String sql = "INSERT INTO workers(surname, experience) VALUES(?,?)";
        try (Connection conn = this.ConnectDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, surname);
			pstmt.setDouble(2, experience);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	//Вывод таблицы
	public void SelectItems(){
        String sql = "SELECT id, surname, experience FROM workers";
        try (Connection conn = this.ConnectDB();
             Statement stmt  = conn.createStatement();
             ResultSet rs   = stmt.executeQuery(sql)){
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("surname") + "\t" +
                                   rs.getDouble("experience"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	public static void main(String[] args) {        
		CreateTable();
        create_table app = new create_table();
        app.InsertItems("Иванов", 10);
        app.InsertItems("Петров", 12);
        app.InsertItems("Сидоров", 14);
        app.SelectItems();
    }
}
