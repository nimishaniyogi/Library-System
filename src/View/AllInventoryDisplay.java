
package View;


import static View.Display.printPublications;
import data.Article;
import data.Book;
import data.Library;
import data.Periodical;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class AllInventoryDisplay extends Display{
    
    private final JButton exit;
    private final ExitHandler exitHandler;

    private final JTextArea viewItems;
    private final JScrollPane scrollPane;

    
    public AllInventoryDisplay(Library library){
        
        exit = new JButton("RETURN TO DISPLAY MENU");
        exitHandler = new ExitHandler();
        exit.addActionListener(exitHandler);
        
        viewItems = new JTextArea();
        PrintStream printStream = new PrintStream(new Display.CustomOutputStream(viewItems));
        System.setOut(printStream);
        System.setErr(printStream);
        viewItems.setEditable(false);
        
        System.out.println("Articles:");
        printArticles(library);
        System.out.println("Books:");
        printBooks(library);
        System.out.println("Periodicals:");
        printPeriodicals(library);
        
        scrollPane = new JScrollPane(viewItems, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(100, 100));
        
        Container pane = getContentPane();
        pane.setLayout(null);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        
        scrollPane.setLocation(10,0);
        exit.setLocation((screenSize.width/2) - 100, (screenSize.height/2) + 100);
        
        scrollPane.setSize(screenSize.width-20, screenSize.height/2);
        exit.setSize(200,80);

        add(scrollPane);
        add(exit);
        
        setVisible(true);
        
    }
    
    public static void printArticles(Library library) {
    	printPublications(library, Article.class);
    }
    
    private static void printBooks(Library library) {
		printPublications(library, Book.class);
    }
    
        public static void printPeriodicals(Library library) {
    	printPublications(library, Periodical.class);
    }
    
    private class ExitHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {  
            dispose();
        }
    }
    
}
