
package View;

import LibraryActions.LibraryBehaviour;
import LibraryActions.PrintAllBehaviour;
import LibraryActions.PrintArticleBehaviour;
import LibraryActions.PrintBookBehaviour;
import LibraryActions.PrintPeriodicalBehaviour;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class View extends Menu {
    

    
    private final JButton book, article, periodical, all, exit;
    
    private final BookHandler bookHandler;
    private final ArticlHandler articleHandler;
    private final PeriodicalHandler periodicalHandler;
    private final AllHandler allHandler;
    private final ExitHandler exitHandler;
    
    public View(){
        
        book = new JButton("VIEW BOOK INVENTORY");
        bookHandler = new BookHandler();
        book.addActionListener(bookHandler);
        
        article = new JButton("VIEW ARTICLE INVENTORY");
        articleHandler = new ArticlHandler();
        article.addActionListener(articleHandler);
        
        periodical = new JButton("VIEW PERIODICAL INVENTORY");
        periodicalHandler = new PeriodicalHandler();
        periodical.addActionListener(periodicalHandler);
        
        all = new JButton("VIEW ALL INVENTORY");
        allHandler = new AllHandler();
        all.addActionListener(allHandler);
        
        exit = new JButton("RETURN TO MAIN MENU");
        exitHandler = new ExitHandler();
        exit.addActionListener(exitHandler);
        
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(5,1));
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        
        add(book);
        add(article);
        add(periodical);
        add(all);
        add(exit);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private class BookHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            myBehaviour = new PrintBookBehaviour();
            myBehaviour.execute();
        }
    }

    private class ArticlHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            myBehaviour = new PrintArticleBehaviour();
            myBehaviour.execute();
        }
    }

    private class PeriodicalHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            myBehaviour = new PrintPeriodicalBehaviour();
            myBehaviour.execute();
        }
    }
    
    private class AllHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            myBehaviour = new PrintAllBehaviour();
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
