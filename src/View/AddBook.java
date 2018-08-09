
package View;

import Factories.BookFactory;
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


public class AddBook extends Menu {
    
    private JLabel titleLabel, authorLabel, publisherLabel, pagesLabel, isbnLabel, yearLabel, monthLabel, dayLabel;
    
    private JTextField title, author, publisher, pages, isbn, year, month, day;
    
    private final JButton addUser, exit;
    
    private final AddHandler addHandler;
    private final ExitHandler exitHandler;
    
    public AddBook(){
        
        titleLabel = new JLabel("Title:", SwingConstants.RIGHT);
        authorLabel = new JLabel("Author:", SwingConstants.RIGHT);
        publisherLabel = new JLabel("Publishing House:", SwingConstants.RIGHT);
        pagesLabel = new JLabel("Number Of Pages:", SwingConstants.RIGHT);
        isbnLabel = new JLabel("ISBN:", SwingConstants.RIGHT);
        yearLabel = new JLabel("Publication Year:", SwingConstants.RIGHT);
        monthLabel = new JLabel("Publication Month:", SwingConstants.RIGHT);
        dayLabel = new JLabel("Publication Day:", SwingConstants.RIGHT);
        
        title = new JTextField(100);
        author = new JTextField(25);
        publisher = new JTextField(100);
        pages = new JTextField(25);
        isbn = new JTextField(25);
        year = new JTextField(4);
        month = new JTextField(2);
        day = new JTextField(2);

        addUser = new JButton("ADD ENTRY TO THE LIBRARY");
        addHandler = new AddHandler();
        addUser.addActionListener(addHandler);
        
        exit = new JButton("RETURN TO ADD MENU");
        exitHandler = new ExitHandler();
        exit.addActionListener(exitHandler);
        
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(9,2));
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        
        add(titleLabel);
        add(title);
        add(authorLabel);
        add(author);
        add(publisherLabel);
        add(publisher);
        add(pagesLabel);
        add(pages);
        add(isbnLabel);
        add(isbn);
        add(yearLabel);
        add(year);
        add(monthLabel);
        add(month);
        add(dayLabel);
        add(day);
        add(addUser);
        add(exit);
        
        setVisible(true);
        
    }  

    private class AddHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) { 
            
            InputData parameters = new InputData();
            BookFactory factory = new BookFactory();
            
            parameters.title = title.getText();
            parameters.author = author.getText();
            parameters.publisher = publisher.getText();
            parameters.isbn = isbn.getText();
            parameters.pages = pages.getText();
            parameters.year = Integer.parseInt(year.getText());
            parameters.month = Integer.parseInt(month.getText());
            parameters.day = Integer.parseInt(day.getText());
            
            library = Library.getInstance();
            library.addPublication(factory.getPublication(parameters));
            
            title.setText("");
            author.setText("");
            publisher.setText("");
            pages.setText("");
            isbn.setText("");
            year.setText("");
            month.setText("");
            day.setText("");
        }
    }

    private class ExitHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {  
            dispose();
        }
    }
}
