import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

import com.library.ILibrarian;
import com.library.Librarian;

public class LibraryManager {
	
	ILibrarian librarian = new Librarian();
	static TextIO textIO = null;
	public static void main(String args[]) {
		 textIO = TextIoFactory.getTextIO();
		new LibraryManager().accept(textIO);
	}
	

    
    public void accept(TextIO textIO) {
        TextTerminal<?> terminal = textIO.getTextTerminal();
        terminal.println("Welcome to Library!");
        terminal.println("Please select the action no want to perform");
        terminal.println("1.Add Books");
        terminal.println("2.lend Books");
        terminal.println("3.return Books");
        terminal.println("4.add user");

        int action = textIO.newIntInputReader()
                .withMinVal(1)
                .read("Action");


        executeAction(action,terminal);
    } 
    
    private void executeAction(int action,TextTerminal<?> terminal ) {

        if(action == 1) {
        terminal.println("Please enter book title to add");
        String title = textIO.newStringInputReader()
                .read("Book title");
        librarian.addBook(title);
        terminal.println("Added Successfully");
        
        }
        
        if(action == 2) {
            terminal.println("Please enter book title to lend");
            String title = textIO.newStringInputReader()
                    .read("Book title");
            String user = textIO.newStringInputReader()
                    .read("User Name");
           
            terminal.println(librarian.lendBook(title, user));
            
          }
        
        if(action == 3) {
            terminal.println("Please enter book title to return");
            String title = textIO.newStringInputReader()
                    .read("Book title");
            String user = textIO.newStringInputReader()
                    .read("User Name");
            terminal.println(librarian.returnBook(title, user));
            
          }
        
        if(action == 4) {
            terminal.println("Please enter user name");
            String userName = textIO.newStringInputReader()
                    .read("User Name");
            int bookLimit = textIO.newIntInputReader()
                    .withMinVal(1)
                    .read("No of book limit");
            librarian.addUser(userName, bookLimit);
            terminal.println("Added Successfully!");
            
          }
        if(textIO.newBooleanInputReader()
                .withPropertiesPrefix("exit")
                .withDefaultValue(true).read("Run again?")) {
        	
        	 accept(textIO);
        }else {
        	textIO.dispose();
        }
       
        
        
    }

}
