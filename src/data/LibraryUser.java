package data;

import java.util.ArrayList;
import java.util.List;

public class LibraryUser extends User {
	private final List<Publication> publicationHistory;
    private final List<Publication> borrowedPublications;
     
    public List<Publication> getPublicationHistory() {
        return publicationHistory;
    }
     
    public List<Publication> getBorrowedPublications() {
        return borrowedPublications;
    }
 
    public LibraryUser(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
        publicationHistory = new ArrayList<>();
        borrowedPublications = new ArrayList<>();
    }
 
    private void addPublicationToHistory(Publication publication) {
        publicationHistory.add(publication);
    }
     
    public void borrowPublication(Publication publication) {
        borrowedPublications.add(publication);
    }
     
    public boolean returnPublication(Publication publication) {
        boolean result = false;
        if(borrowedPublications.remove(publication)) {
            result = true;
            addPublicationToHistory(publication);
        }
        return result;
    }     
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((borrowedPublications == null) ? 0 : borrowedPublications.hashCode());
     
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        LibraryUser other = (LibraryUser) obj;
        if (borrowedPublications == null && other.borrowedPublications != null)
            return false;
        if (!borrowedPublications.equals(other.borrowedPublications))
            return false;
        if (publicationHistory == null && other.publicationHistory != null)
                return false;
        return true;
    }
}
