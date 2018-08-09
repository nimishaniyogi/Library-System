package data;

public class Article extends Publication {
	private static final long serialVersionUID = -7907331751072277846L;
	private String author;
        private String journal;
        private int volume;
	private String pages;
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
        
        public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}
        
        public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public Article(InputData parameters) {
		super(parameters);
		this.author = parameters.author;
		this.pages = parameters.pages;
                this.journal = parameters.journal;
                this.volume = parameters.volume;
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder(64);
		print.append(getAuthor());
		print.append("; ");
                print.append(getTitle());
		print.append("; ");
                print.append(getJournal());
		print.append("; ");
                print.append(getVolume());
		print.append("; ");
		print.append(getYear());
		print.append("; ");
		print.append(getPages());
		return print.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((journal == null) ? 0 : journal.hashCode());
                result = prime * result + ((pages == null) ? 0 : pages.hashCode());
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
		Article other = (Article) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (journal == null) {
			if (other.journal != null)
				return false;
		} else if (!journal.equals(other.journal))
			return false;
		if (pages != other.pages)
			return false;
		return true;
	}
}
