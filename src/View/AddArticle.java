
package View;

import Factories.ArticleFactory;
import data.InputData;
import data.Library;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class AddArticle extends Menu {
    
    private JLabel titleLabel, authorLabel, journalLabel, pagesLabel, volumeLabel, yearLabel;
    
    private JTextField title, author, journal, pages, volume, year;
    
    private final JButton addBook, exit;
    
    private final AddHandler addHandler;
    private final ExitHandler exitHandler;
    
    public AddArticle(){
        
        titleLabel = new JLabel("Title:", SwingConstants.RIGHT);
        authorLabel = new JLabel("Author:", SwingConstants.RIGHT);
        journalLabel = new JLabel("Journal:", SwingConstants.RIGHT);
        pagesLabel = new JLabel("Number Of Pages:", SwingConstants.RIGHT);
        volumeLabel = new JLabel("Volume:", SwingConstants.RIGHT);
        yearLabel = new JLabel("Publication Year:", SwingConstants.RIGHT);
        
        title = new JTextField(100);
        author = new JTextField(100);
        journal = new JTextField(100);
        pages = new JTextField(25);
        volume = new JTextField(25);
        year = new JTextField(4);

        addBook = new JButton("ADD ENTRY TO THE LIBRARY");
        addHandler = new AddHandler();
        addBook.addActionListener(addHandler);
        
        exit = new JButton("RETURN TO ADD MENU");
        exitHandler = new ExitHandler();
        exit.addActionListener(exitHandler);
        
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(7,2));
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        
        add(titleLabel);
        add(title);
        add(authorLabel);
        add(author);
        add(journalLabel);
        add(journal);
        add(pagesLabel);
        add(pages);
        add(volumeLabel);
        add(volume);
        add(yearLabel);
        add(year);
        add(addBook);
        add(exit);
        
        setVisible(true);
        
    }  

    private class AddHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) { 
            
            InputData parameters = new InputData();
            ArticleFactory factory = new ArticleFactory();
            
            parameters.title = title.getText();
            parameters.author = author.getText();
            parameters.journal = journal.getText();
            parameters.volume = Integer.parseInt(volume.getText());
            parameters.pages = pages.getText();
            parameters.year = Integer.parseInt(year.getText());;
            
            library = Library.getInstance();
            library.addPublication(factory.getPublication(parameters));
            
            title.setText("");
            author.setText("");
            journal.setText("");
            pages.setText("");
            volume.setText("");
            year.setText("");
        }
    }

    private class ExitHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {  
            dispose();
        }
    }
}
