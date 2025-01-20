package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookLoan {
	private int userCode;
	private int bookCode;
	private Date dateLoan;
	private Date dateReturn;
	SimpleDateFormat parser=new SimpleDateFormat("DD/MM/yyyy");

	@Override
	public String toString() {
		String dateLoanString = "";
		String dateReturnString = "";
		if (dateReturn != null) {
			dateReturnString = parser.format(dateReturn);
		}
		if (dateLoan != null) {
			dateLoanString = parser.format(dateLoan);
		}
		return "BookLoan [userCode=" + userCode + ", bookCode=" + bookCode
				+ ", dateLoan=" + dateLoanString + ", dateReturn=" + dateReturnString + "]";
	}

	public BookLoan() {
		super();
	}
	
	public BookLoan(int userCode, int bookCode, Date dateLoan) {
		super();
		this.userCode = userCode;
		this.bookCode = bookCode;
		this.dateLoan = dateLoan;
		this.dateReturn = null;
	}

	public BookLoan(int userCode, int bookCode, Date dateLoan, Date dateReturn) {
		super();
		this.userCode = userCode;
		this.bookCode = bookCode;
		this.dateLoan = dateLoan;
		this.dateReturn = dateReturn;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public Date getDateLoan() {
		return dateLoan;
	}

	public void setDateLoan(Date dateLoan) {
		this.dateLoan = dateLoan;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

}
