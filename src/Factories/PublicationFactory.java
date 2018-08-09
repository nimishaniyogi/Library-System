
package Factories;

import data.InputData;
import data.Publication;


public abstract class PublicationFactory {
    public abstract Publication getPublication(InputData parameters);
}
