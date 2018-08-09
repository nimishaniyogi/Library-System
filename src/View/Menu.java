
package View;

import LibraryActions.LibraryBehaviour;
import data.Library;
import data.LibraryUser;
import javax.swing.JFrame;


public abstract class Menu extends JFrame{
    
    protected LibraryBehaviour myBehaviour;
    protected Library library;
    protected LibraryUser libraryUser;

    public Menu(){
        
        setTitle("Library System version-2.0");
 
    }
    
}
