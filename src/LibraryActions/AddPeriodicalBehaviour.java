package LibraryActions;

import Factories.PeriodicalFactory;
import View.AddPeriodical;

public class AddPeriodicalBehaviour extends LibraryBehaviour {
          
    public AddPeriodicalBehaviour() {
	super();
    }
        
    public void execute() {
	new AddPeriodical();
    }
    
}
