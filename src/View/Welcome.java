
package View;

import LibraryActions.ExitBehaviour;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Welcome extends Menu {
    
    private final JButton view, add, manage, exit;
    
    private final ViewHandler viewHandler;
    private final AddHandler addHandler;
    private final ManageHandler manageHandler;
    private final ExitHandler exitHandler;
    
    public Welcome(){
        
        view = new JButton("VIEW LIBRARY INVENTORY");
        viewHandler = new ViewHandler();
        view.addActionListener(viewHandler);
        
        add = new JButton("ADD NEW INVENTORY");
        addHandler = new AddHandler();
        add.addActionListener(addHandler);
        
        manage = new JButton("MANAGE LIBRARY");
        manageHandler = new ManageHandler();
        manage.addActionListener(manageHandler);
        
        exit = new JButton("EXIT PROGRAM");
        exitHandler = new ExitHandler();
        exit.addActionListener(exitHandler);
        
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4,1));
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        
        add(view);
        add(add);
        add(manage);
        add(exit);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private class ViewHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {  
            new View();
        }
    }

    private class AddHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            new Add();  
        }
    }

    private class ManageHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent e) {
            new Manage();
        }
    }

    private class ExitHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {         
            myBehaviour = new ExitBehaviour();
            myBehaviour.execute();
            System.exit(0);     
        }
    }
}
