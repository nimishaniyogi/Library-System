
package Factories;

import data.Book;
import data.InputData;
import data.Publication;


public class BookFactory extends PublicationFactory {
    

    @Override
    public Publication getPublication(InputData parameters){
        return new Book(parameters);
    }
    
}
