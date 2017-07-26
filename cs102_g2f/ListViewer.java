/*
 * Author: Kazım Sanlav
 * Date: 13/7/2017
 */

package cs102_g2f;

import java.util.ArrayList;


import javax.swing.JOptionPane;

//List viewer takes a list of books from the core app, 
//print them to the as a numerated list, and take the user’s 
//choice and return it to the core app.
public class ListViewer {
	
	static String booklist ="";
	public static Book selectBook(ArrayList<Book> ListOfBooks)
	{
		for(int i=0; i<ListOfBooks.size(); i++)
			booklist += (i+"- "+ListOfBooks.get(i)+"\n");
		
		
		String input = JOptionPane.showInputDialog(booklist+"Select a book(id): ");
		int bookIndex = Integer.parseInt(input);
		System.out.println(booklist);
		booklist ="";
		return ListOfBooks.get(bookIndex);
		
	}
	

}
