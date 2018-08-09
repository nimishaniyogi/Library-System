package LibraryActions;

import View.AllInventoryDisplay;


public class PrintAllBehaviour extends LibraryBehaviour {

	public PrintAllBehaviour() {
		super();
	}

	@Override
	public void execute() {
		new AllInventoryDisplay(library);
	}

}
