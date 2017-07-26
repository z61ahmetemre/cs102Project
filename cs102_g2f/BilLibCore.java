/*
 * Author: Kazim Sanlav
 * Date: 13/7/2017
 */


package cs102_g2f;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class BilLibCore {

	public static void main(String[] args) {
		
    	String url2 = "jdbc:access:/C:/Users/kazIm/Documents/BookLocation.accdb"; //location of bookshelves database 
    	
    	String search = "";
    	
    	search = JOptionPane.showInputDialog("Searh a book: ");
  
    	//System.out.println(search);
    	
    	ArrayList<Book> ListOfBooks = new SearchHtml().getBook(search);
    	
    	//System.out.println(ListOfBooks);
    	
    	Book book = ListViewer.selectBook(ListOfBooks);
    	
    	System.out.println("**Book: "+book);
    	
    	String callNumber = book.getCallNum();
    	
    	System.out.println("Call num: "+callNumber);
    	
    	ArrayList<String> location = new BookLocation().getLocationInformation(callNumber);
    	
    	JOptionPane.showMessageDialog(null,"Locations x,y: "+ location);
    	
    	
    	
    	
    
	}

}
