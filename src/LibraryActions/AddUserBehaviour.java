package LibraryActions;

import View.AddUser;
import data.LibraryUser;

public class AddUserBehaviour extends LibraryBehaviour {
	
	public AddUserBehaviour(){
		super();
	}

	@Override
	public void execute() {
            new AddUser();            
	}

}
