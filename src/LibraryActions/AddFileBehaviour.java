package LibraryActions;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.FileInputReader;

public class AddFileBehaviour extends LibraryBehaviour {

    public FileInputReader dataReader;
     
    public AddFileBehaviour(){
    }
    
    @Override
    public final void execute() {
        dataReader = FileInputReader.getInstance();
        try {
            dataReader.addFile();
        } catch (IOException ex) {
            Logger.getLogger(AddFileBehaviour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}
