
package Factories;

import data.InputData;
import data.Periodical;
import data.Publication;


public class PeriodicalFactory extends PublicationFactory{
    
    @Override
    public Publication getPublication(InputData parameters){
        return new Periodical(parameters);
    }
    
}
