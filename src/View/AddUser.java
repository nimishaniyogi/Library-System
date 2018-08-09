
package View;

import data.Library;
import data.LibraryUser;
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


public class AddUser extends Menu {
    
    private JLabel firstLabel, lastLabel, ssnLabel;
    
    private JTextField first, last, ssn;
    
    private final JButton addUser, exit;
    
    private final AddHandler addHandler;
    private final ExitHandler exitHandler;
    
    public AddUser(){
        
        firstLabel = new JLabel("First Name:", SwingConstants.RIGHT);
        lastLabel = new JLabel("Last Name:", SwingConstants.RIGHT);
        ssnLabel = new JLabel("Social Security Number, ######### format:", SwingConstants.RIGHT);
        
        first = new JTextField(25);
        last = new JTextField(25);
        ssn = new JTextField(9);

        addUser = new JButton("ADD ENTRY TO THE LIBRARY");
        addHandler = new AddHandler();
        addUser.addActionListener(addHandler);
        
        exit = new JButton("RETURN TO MANAGE MENU");
        exitHandler = new ExitHandler();
        exit.addActionListener(exitHandler);
        
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4,2));
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        
        add(firstLabel);
        add(first);
        add(lastLabel);
        add(last);
        add(ssnLabel);
        add(ssn);
        add(addUser);
        add(exit);
        
        setVisible(true);
        
    }  

    private class AddHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) { 
            
            String firstName, lastName, socialSecurityNumber;
            
            firstName = first.getText();
            lastName = last.getText();
            socialSecurityNumber = ssn.getText();
            
            libraryUser = new LibraryUser(firstName, lastName, socialSecurityNumber);
            library = Library.getInstance();
            library.addUser(libraryUser);
            
            first.setText("");
            last.setText("");
            ssn.setText("");
        }
    }

    private class ExitHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {  
            dispose();
        }
    }
}
