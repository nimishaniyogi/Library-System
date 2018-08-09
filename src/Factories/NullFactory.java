
package Factories;

import data.InputData;
import data.NullPublication;
import data.Publication;

public class NullFactory extends PublicationFactory {
    
    boolean isNull(){
        return true;
    }
    
    @Override
    public Publication getPublication(InputData parameters){
        return new NullPublication(parameters);
    }
    
}
