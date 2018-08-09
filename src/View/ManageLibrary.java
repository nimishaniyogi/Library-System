
package View;

import LibraryActions.AddUserBehaviour;
import LibraryActions.PrintUserBehaviour;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class ManageLibrary extends Menu {
    
    private final JButton viewUsers, addUser, exit;
    
    private final ViewHandler viewHandler;
    private final AddHandler addHandler;
    private final ExitHandler exitHandler;
    
    public ManageLibrary(){
        
        viewUsers = new JButton("VIEW ALL USERS");
        viewHandler = new ViewHandler();
        viewUsers.addActionListener(viewHandler);
        
        addUser = new JButton("ADD A USER TO THE LIBRARY");
        addHandler = new AddHandler();
        addUser.addActionListener(addHandler);
        
        exit = new JButton("RETURN TO MAIN MENU");
        exitHandler = new ExitHandler();
        exit.addActionListener(exitHandler);
        
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(3,1));
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        
        add(viewUsers);
        add(addUser);
        add(exit);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
    private class ViewHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            myBehaviour = new PrintUserBehaviour();
            myBehaviour.execute();
        }
    }

    private class AddHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            myBehaviour = new AddUserBehaviour();
            myBehaviour.execute();
        }
    }

    private class ExitHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            dispose();
      
        }
    }
}
