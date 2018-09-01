package bean;

public class Book extends MediaItem {
		private String author;
		public Book() {
			//System.out.println("Book-------------------------------------");
		}
		public Book(String author) {
			super();
			this.author = author;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		@Override
		public String toString() {
			return super.toString()+"Book [author=" + author + "]"+"\n";
		}
		
}
