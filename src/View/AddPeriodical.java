
package View;

import Factories.PeriodicalFactory;
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


public class AddPeriodical extends Menu {
    
    private JLabel titleLabel, languageLabel, publisherLabel, yearLabel, monthLabel, dayLabel;
    
    private JTextField title, language, publisher, year, month, day;
    
    private final JButton addUser, exit;
    
    private final AddHandler addHandler;
    private final ExitHandler exitHandler;
    
    public AddPeriodical(){
        
        titleLabel = new JLabel("Title:", SwingConstants.RIGHT);
        languageLabel = new JLabel("Language:", SwingConstants.RIGHT);
        publisherLabel = new JLabel("Publishing House:", SwingConstants.RIGHT);
        yearLabel = new JLabel("Publication Year:", SwingConstants.RIGHT);
        monthLabel = new JLabel("Publication Month:", SwingConstants.RIGHT);
        dayLabel = new JLabel("Publication Day:", SwingConstants.RIGHT);
        
        title = new JTextField(100);
        language = new JTextField(25);
        publisher = new JTextField(100);
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
        add(languageLabel);
        add(language);
        add(publisherLabel);
        add(publisher);
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
            PeriodicalFactory factory = new PeriodicalFactory();
            
            parameters.title = title.getText();
            parameters.language = language.getText();
            parameters.publisher = publisher.getText();
            parameters.year = Integer.parseInt(year.getText());
            parameters.month = Integer.parseInt(month.getText());
            parameters.day = Integer.parseInt(day.getText());
            
            library = Library.getInstance();
            library.addPublication(factory.getPublication(parameters));
            
            title.setText("");
            language.setText("");
            publisher.setText("");
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
