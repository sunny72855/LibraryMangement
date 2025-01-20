package models;

public class Book {
	private int bookCode;
	private String bookName;
	private String bookAuthor;
	private String bookType;
	private int bookQty;

	public Book() {
		super();
	}

	public Book(int bookCode, String bookName, String bookAuthor, String bookType, int bookQty) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookType = bookType;
		this.bookQty = bookQty;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public int getBookQty() {
		return bookQty;
	}

	public void setBookQty(int bookQty) {
		this.bookQty = bookQty;
	}

	public String infoSave() {
		return "bookCode=" + bookCode + 
				",bookName=" + bookName +  
				",bookAuthor=" + bookAuthor +  
				",bookType="+ bookType +  
				",bookQty=" + bookQty;
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookType="
				+ bookType + ", bookQty=" + bookQty + "]\n";
	}

}
