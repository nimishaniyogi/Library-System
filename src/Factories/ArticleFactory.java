
package Factories;

import data.Article;
import data.InputData;
import data.Publication;


public class ArticleFactory extends PublicationFactory{
    
    @Override
    public Publication getPublication(InputData parameters){
        return new Article(parameters);
    }
    
}
