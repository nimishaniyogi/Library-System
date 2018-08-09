package LibraryActions;

import Factories.BookFactory;
import View.AddBook;
import View.BookDisplay;

public class AddBookBehaviour extends LibraryBehaviour {
        
    public AddBookBehaviour() {
	super();
    }

    public void execute() {
	new AddBook();
    }

}
