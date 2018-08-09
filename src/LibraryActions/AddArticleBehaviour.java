package LibraryActions;

import Factories.ArticleFactory;
import View.AddArticle;

public class AddArticleBehaviour extends LibraryBehaviour {
        
    public AddArticleBehaviour() {
	super();
    }

    public void execute() {
	new AddArticle();
    }
}
