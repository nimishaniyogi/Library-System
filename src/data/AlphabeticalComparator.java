package data;
import java.util.Comparator;

/**
 *
 * @author Nimisha
 */
public class AlphabeticalComparator implements Comparator<Publication> {
        @Override
        public int compare(Publication o1, Publication o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
