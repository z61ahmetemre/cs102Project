/*
 * Author: Kazim Sanlav
 * Date: 13/7/2017
 */

package cs102_g2f;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class BilLib {

	Connection conn;

	final String connectionString = "jdbc:access:/C:/Users/kazIm/Documents/BilLib.accdb";


	public BilLib(){

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

	public ArrayList<String> getListOfBooks(String search)
	{

		ArrayList<String> list = new ArrayList<String>();
		
		try{ 
		

			Statement stmt = conn.createStatement();
			ResultSet rs2 = stmt.executeQuery("SELECT BookName FROM books ");


			while (rs2.next()) {
				String bookname = rs2.getString("BookName");
				if(bookname.toLowerCase().contains(search.toLowerCase()))
					list.add(bookname);
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
	public String getCallNumberOfBooks(String search)
	{
		
		String list = "";
		
		try{ 
		

			Statement stmt = conn.createStatement();
			ResultSet rs2 = stmt.executeQuery("SELECT CallNumber,BookName FROM books ");


			while (rs2.next()) {
				String bookname = rs2.getString("BookName");
				if(bookname.trim().equals(search.trim()))
					list = rs2.getString("CallNumber");
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
		BilLib b = new BilLib();
		System.out.println("search: ");
		String search = scan.next();
		System.out.println(b.getListOfBooks(search));
		System.out.println("search: ");
		 search = scan.next();
		System.out.println(b.getCallNumberOfBooks(search));
		scan.close();
	}     
}