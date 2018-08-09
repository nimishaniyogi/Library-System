package data;

public class Book extends Publication {
	private static final long serialVersionUID = -7907331751072277846L;
	private String author;
	private String pages;
	private String isbn;
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Book(InputData parameters) {
		super(parameters);
		this.author = parameters.author;
		this.pages = parameters.pages;
		this.isbn = parameters.isbn;
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder(64);
		print.append(getTitle());
		print.append("; ");
		print.append(getAuthor());
		print.append("; ");
		print.append(getYear());
		print.append("; ");
		print.append(getPages());
		print.append("; ");
		print.append(getPublisher());
		print.append("; ");
		print.append(getIsbn());
		return print.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} 
                if (!author.equals(other.author))
			return false;
		if (isbn == null && other.isbn != null )
				return false;
		
                if (!isbn.equals(other.isbn))
			return false;
                
		return pages == other.pages;
	}
}
