package LibraryActions;

import View.PeriodicalDisplay;

public class PrintPeriodicalBehaviour extends LibraryBehaviour {

	public PrintPeriodicalBehaviour() {
		super();
	}

	@Override
	public void execute() {
		new PeriodicalDisplay(library);
	}

}
