package View;

import data.AlphabeticalComparator;
import data.Library;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;


public abstract class Display extends Menu{

    
    protected static void printPublications(Library library, Class<?> cl) {
    	long countPublications = library.getPublications().values().stream()
    			.filter(cl::isInstance).sorted(new AlphabeticalComparator())
    			.peek(System.out::println).count();
    	if(countPublications == 0) {
    		System.out.println("No type publication was found in the library: " + cl.getSimpleName());
    	}
    }
    
    protected static void printUsers(Library library) {
    	library.getUsers().values().stream()
    	.sorted((a,b) -> a.getLastName().compareTo(b.getLastName()))
    	.forEach(System.out::println);
    }
    
 /** I found this code online and used it to redirect output from standard out to the scroll pane:
 * This class extends from OutputStream to redirect output to a JTextArrea
 * @author www.codejava.net
 */
    protected class CustomOutputStream extends OutputStream {
        private final JTextArea textArea;
     
        public CustomOutputStream(JTextArea textArea) {
         this.textArea = textArea;
        }
     
        @Override
        public void write(int b) throws IOException {
            textArea.append(String.valueOf((char)b));
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }
    
    
    
}
