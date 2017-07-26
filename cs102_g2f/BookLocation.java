/*
 * Author: Kazım Sanlav
 * Date: 13/7/2017
 */

package cs102_g2f;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class BookLocation {
	
	AlphanumericComparator comparator = new AlphanumericComparator();

	Connection conn;

	final String connectionString = "jdbc:access:/C:/Users/kazIm/Documents/BookLocation.accdb";


	public BookLocation(){

		connectToDB(connectionString);

	}
	private void connectToDB(String url){

		try{ 
			// Step 2: Load the corresponding JDBC driver for the data source you want to connect. 
			Class.forName("com.hxtt.sql.access.AccessDriver");


			/* Step 3: We interact with a data source through sessions. Each connection identifies a  logical session. Connections are specified through a JDBC URL in the following form:
	    jdbc:<subprotocol>:<otherParameters>     */

			String userId="";
			String password="";

			conn = DriverManager.getConnection(url, userId, password);
			System.out.println("Successfully connected to the database!");


		}
		catch(ClassNotFoundException classEx) // this exception is caught if the driver is unknown
		{
			System.out.println("Class Not found exception" ); 
		}
		catch(SQLException sqlEx) // this exception is caught if something is wrong with connection 
		{
			System.out.println("\nError occured during getting the connection\n" + sqlEx);
		}
	}


	public ArrayList<String> getLocationInformation(String search)
	{
		ArrayList<String> list = new ArrayList<String>();

		try{ 


			Statement stmt = conn.createStatement();
			ResultSet rs2 = stmt.executeQuery("SELECT ShelfRange,ShelfLocation,Xcor,Ycor FROM locations ");


			while (rs2.next()) {

				String ShelfRange = rs2.getString("ShelfRange");
				String ShelfLocation = rs2.getString("ShelfLocation");
				int Xcor = rs2.getInt("Xcor");
				int Ycor = rs2.getInt("Ycor");
				String ShelfRange1 = ShelfRange.substring(0,ShelfRange.indexOf("|"));
				String ShelfRange2 = ShelfRange.substring(ShelfRange.indexOf("|")+1, ShelfRange.length());
				//System.out.println(ShelfRange1+""+ShelfRange2);
				if(comparator.compare(ShelfRange1, search)<=0 && comparator.compare(ShelfRange2, search)>=0)
					list.add(Xcor+" "+Ycor);

			}
			//System.out.println(list);

			// finally close statement and connection.
			stmt.close();


		}
		catch(SQLException sqlEx) // this exception is caught if something is wrong with connection 
		{
			System.out.println("\nError occured during getting the connection\n" + sqlEx);
		}
		return list;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BookLocation b = new BookLocation();
		System.out.println("search: ");
		String search = scan.next();
		System.out.println(b.getLocationInformation(search));
		scan.close();
	}

}