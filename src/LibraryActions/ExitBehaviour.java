package LibraryActions;

import utils.LibraryFileManager;

public class ExitBehaviour extends LibraryBehaviour {
	
	private LibraryFileManager fileManager;

	public ExitBehaviour() {
		super();
		fileManager = LibraryFileManager.getInstance();
	}

	@Override
	public void execute() {
		fileManager.writeLibraryToFile(library);
	}

}
