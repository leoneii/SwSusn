/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swsusn;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.JDBC;

public class conn {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	
	// --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
	public static void Conn() throws ClassNotFoundException, SQLException, IOException 
	   {
		   conn = null;
		  Class.forName("org.sqlite.JDBC");
		   conn = DriverManager.getConnection("jdbc:sqlite:"+AppSettings.getString("dbname", "susn.ixdb"));
		   
		   System.out.println("База Подключена!");
                   swsusn.Message.showInfo("Успех!", "База данных подключена", null);
	   }
	
	// --------Создание таблицы--------
	public static void CreateDB() throws ClassNotFoundException, SQLException
	   {
		statmt = conn.createStatement();
		statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");
		
		System.out.println("Таблица создана или уже существует.");
	   }
	
	// --------Заполнение таблицы--------
	public static void WriteDB() throws SQLException
	{
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");
		  
		   System.out.println("Таблица заполнена");
	}
	
	// -------- Вывод таблицы--------
	public static void ReadDB(String SQL) throws ClassNotFoundException, SQLException
	   {
               statmt = conn.createStatement();
		resSet = statmt.executeQuery(SQL);
		
		while(resSet.next())
		{
			int id = resSet.getInt("id");
			String  name = resSet.getString("name");
			String  phone = resSet.getString("phone");
	         System.out.println( "ID = " + id );
	         System.out.println( "name = " + name );
	         System.out.println( "phone = " + phone );
	         System.out.println();
		}	
		
		System.out.println("Таблица выведена");
	    }
	
		// --------Закрытие--------
		public static void CloseDB() throws ClassNotFoundException, SQLException
		   {
			conn.close();
			statmt.close();
			resSet.close();
			
			System.out.println("Соединения закрыты");
		   }
                
         public static String ReadNStr(int nstr, String table, String column) throws ClassNotFoundException, SQLException
	   {
               statmt = conn.createStatement();
               resSet = statmt.executeQuery("SELECT "+column+" FROM "+table+";" );
                int i = -1;
               
	      while (resSet.next()){
                  
                    i++;              
                    if(i==nstr){
                    return resSet.getString(column); 
                       
                    }
              }
              
                    return "htyjntym"; 
	    }
                
}