package app;

import data.Library;
import utils.LibraryFileManager;

public class LibraryControl {

    private static LibraryControl instance;

    private final LibraryFileManager fileManager;
	
    private final Library library;
        
	
    private LibraryControl() {
        
        fileManager = LibraryFileManager.getInstance();
        library = Library.getInstanceFromSaveFile();
    }

    public static LibraryControl getInstance(){
    	if(instance == null)
    		instance = new LibraryControl();
    	return instance;
    }
    
    
}
