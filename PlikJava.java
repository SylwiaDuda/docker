import java.sql.*;
import java.util.concurrent.TimeUnit;
public class PlikJava {
   
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try{
		     Class.forName("com.mysql.cj.jdbc.Driver");
                     System.out.println("Connecting to database...");
        	     TimeUnit.SECONDS.sleep(30);
		     connection = DriverManager.getConnection("jdbc:mysql://10.0.10.3:3306/database","sduda","password");
	             statement = connection.createStatement();

      String sqlDeleteTable = "DROP TABLE IF EXISTS Persons";
      statement.executeUpdate(sqlDeleteTable);

      String sqlCreateTable = "CREATE TABLE IF NOT EXISTS Persons(PersonID int, LastName varchar(255), FirstName varchar(255))";
      statement.executeUpdate(sqlCreateTable);

      String sqlInsert = "INSERT INTO Persons (PersonID, LastName, FirstName) VALUES (1,'Duda1','Sylwia1')";
      statement.executeUpdate(sqlInsert);
      sqlInsert = "INSERT INTO Persons (PersonID, LastName, FirstName) VALUES (2, 'Duda2','Sylwia2')";
      statement.executeUpdate(sqlInsert);
      sqlInsert = "INSERT INTO Persons (PersonID, LastName, FirstName) VALUES (3, 'Duda3','Sylwia3')";
      statement.executeUpdate(sqlInsert);

      String sqlSelect = "SELECT PersonID, FirstName, LastName FROM Persons";
      ResultSet rs = statement.executeQuery(sqlSelect);

      while(rs.next()){
         int id  = rs.getInt("PersonID");
         String first = rs.getString("FirstName");
         String last = rs.getString("LastName");
         System.out.println("ID: " + id);
         System.out.println(", First: " + first);
         System.out.println(", Last: " + last);
      }
      rs.close();
      statement.close();
      connection.close();
	
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         if(statement!=null)
            statement.close();
      }catch(SQLException se2){
      }
      try{
         if(connection!=null)
            connection.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
 }
}

