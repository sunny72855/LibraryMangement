import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import book_loans.BookLoanService;
import books.BookService;
import models.Book;
import models.BookLoan;
import models.User;
import users.UserService;
import utils.FileUtil;

public class LibraryManager {
	public static void main(String[] args) {
//		checkBook();
//		checkUser();
//		checkBookLoan();
		
		// Kiểm tra book
		Global.listBook = BookService.searchAll("Book.txt");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Chào mừng đến với Thư viện sách: ");
		while (true) {
            System.out.print("Mời chọn chức năng: \n1. Xem tất cả.\n2.Thêm mới sách.\n3.Update sach");
            String input;
            input = scanner.nextLine(); // Đọc dòng nhập từ người dùng

            // Kiểm tra điều kiện thoát
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Kết thúc chương trình.");
                break;
            }

            // Xử lý hoặc in dữ liệu nhập
            System.out.println("Bạn đã nhập: " + input);
//            int mode = Integer.parseInt(input);
            switch(input) {
            	case "1":
            		Global.listBook = BookService.searchAll("Book.txt");
            		System.out.println(Arrays.toString(Global.listBook.toArray()));
            	break;
            	case "2":
            		AddBook();
            	break;
            	case "3":
            		UpdateBook();
            	break;
            	default:
            		
            		break;
            }
        }
	}

	private static void checkUser(){
		// Tạo 10 thành viên
		Date date = new Date();
//		String dateString = "02/01/2025";
		SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
//		try {
//			Date date = parser.parse(dateString);
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		for (int i = 0; i < 10; i++) {
			int temp = i+1;
			User user = UserService.createUser(temp, "Thành viên số " + temp, date, "Số điện thoại: " + temp);
			Global.listUser.add(user);
		}
		
		System.out.println(Arrays.toString(Global.listUser.toArray()));
		// Update thành viên số 5
		String dateString = "19/12/1991";
		try {
			Date dateDate = parser.parse(dateString);
			User user = new User(0, "Vũ Tuấn An", dateDate, "xxx");
			UserService.updateUser(5, user, Global.listUser);
			System.out.println(Arrays.toString(Global.listUser.toArray()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Delete thành viên số 9
		UserService.deleteUser(9, Global.listUser);
		System.out.println(Arrays.toString(Global.listUser.toArray()));
		
		// Search thành viên có name là abc
		User user = UserService.searchUser(0, "Thành viên số 8", Global.listUser);
		System.out.println(user);
		// Search thành viên số 3
		user = UserService.searchUser(7, "Thành viên số 8", Global.listUser);
		System.out.println(user);
	}

	private static void checkBook() {
		// Tạo 10 quyển sách
		for (int i = 0; i < 10; i++) {
			Book book = BookService.createBook(i + 1, "Quyển sách số " + (i + 1), "Tác giả số " + (i + 1),
					"Kiểu số " + (i + 1), 10);
			Global.listBook.add(book);
		}
		System.out.println(Arrays.toString(Global.listBook.toArray()));
		String buff = "";
		for (Book item : Global.listBook) {
			buff += item.infoSave()+"\n";
		}
		FileUtil.saveFile(buff, "Book.txt");
		
		// Update quyển sách số 3
		Book bookUpdate = new Book();
		bookUpdate.setBookName("Harry Potter");
		bookUpdate.setBookAuthor("J. K. Rowling");
		bookUpdate.setBookType("Tiểu Thuyết Huyền Bí");
		bookUpdate.setBookQty(10);
		BookService.updateBook(3, bookUpdate, Global.listBook);
		System.out.println("Thư viện sau khi update: \n" + Arrays.toString(Global.listBook.toArray()));

		// Delete quyển sách số 9
		BookService.deleteBook(9, Global.listBook);
		System.out.println("Thư viện sau khi delete: \n" + Arrays.toString(Global.listBook.toArray()));

		// search quyển sách có bookcode= 3
		Book book = BookService.searchBook(3, "", "", Global.listBook);
		if (book == null) {
			System.out.println("Tìm = bookcode: 3 \nKhông tìm thấy thông tin sách");
		} else {
			System.out.println("Tìm = bookcode: 3" + "\nThông tin sách: \n" + book);
		}
		// search quyển sách có bookName= Quyển sách số 4
		book = BookService.searchBook(10, "Quyển sách số 6", "", Global.listBook);
		if (book == null) {
			System.out.println("Tìm = bookName: Quyển sách số 4 \nKhông tìm thấy thông tin sách");
		} else {
			System.out.println("Tìm = bookName: Quyển sách số 4" +"\nThông tin sách: \n" + book);
		}
	}
	
	private static void AddBook() {
		System.out.println("Tạo mới 1 quyển sách: ");
		Book book = new Book();
		String tmp = getInputFromKeyboard("Mời nhập bookCode: ");
		book.setBookCode(Integer.parseInt(tmp));
		tmp = getInputFromKeyboard("Mời nhập bookName: ");
		book.setBookName(tmp);
		tmp = getInputFromKeyboard("Mời nhập bookAuthor: ");
		book.setBookAuthor(tmp);
		tmp = getInputFromKeyboard("Mời nhập bookType: ");
		book.setBookType(tmp);
		tmp = getInputFromKeyboard("Mời nhập bookQty: ");
		book.setBookQty(Integer.parseInt(tmp));
		FileUtil.appendToFile(Constants.BOOK_DB, book.infoSave());
	}
	
	private static void UpdateBook() {
		System.out.println("Update 1 quyen sach");
		while (true) {
		String tmp = getInputFromKeyboard("Moi nhap bookCode: ");
		for (Book item : Global.listBook) {
			if (item.getBookCode() == Integer.parseInt(tmp)) {
				tmp = getInputFromKeyboard("Moi nhap bookName: ");
				item.setBookName(tmp);
				tmp = getInputFromKeyboard("Moi nhap bookAuthor: ");
				item.setBookAuthor(tmp);
				tmp = getInputFromKeyboard("Moi nhap bookType: ");
				item.setBookType(tmp);
				tmp = getInputFromKeyboard("Moi nhap bookQty: ");
				item.setBookQty(Integer.parseInt(tmp));
				String buff = "";
				for (Book item2 : Global.listBook) {
					buff += item2.infoSave()+"\n";
				}
				FileUtil.saveFile(buff, "Book.txt");
				
				return;
			}
		}
		}
	}
	
	private static void checkBookLoan() {
		// Tao Book loan
		
		for (int i = 0; i < 10; i++) {
			BookLoan bookLoan = BookLoanService.createBookLoan(i + 1, i + 1, new Date());
			Global.listBookLoan.add(bookLoan);
			System.out.println(bookLoan);
		}
		
		// Update bookLoan
		
		BookLoan updateBookLoan = new BookLoan();
		updateBookLoan.setUserCode(3);
		updateBookLoan.setDateLoan(new Date());
		updateBookLoan.setDateReturn(null);
		BookLoanService.updateBookLoan(1, updateBookLoan, Global.listBookLoan);
		System.out.println("Thư viện sau khi update: \n" + Arrays.toString(Global.listBookLoan.toArray()));
		
		
		// Delete bookLoan userCode so 2
		BookLoanService.deleteBookLoan(2, Global.listBookLoan);
		System.out.println("Thư viện sau khi delete: \n" + Arrays.toString(Global.listBookLoan.toArray()));
		
		//Search bookLoan
		
		BookLoan bookLoan = BookLoanService.searchBookLoan(5, 0, null, null, Global.listBookLoan);
		if (bookLoan == null) {
			System.out.println("Tim = bookLoan: 5 \nKhong tim thay thong tin loan");
		} else {
			System.out.println("Tim = bookloan: 5" + "\nThong tin book loan\n" + bookLoan);
		}
		
		//Update bookLoan return
		String dateReturn = "15/01/2025";
		try {
			Date date = Global.parserDate.parse(dateReturn);
			BookLoan updateBookLoan2 = new BookLoan();
			updateBookLoan2.setUserCode(3);
			updateBookLoan2.setDateLoan(new Date());
			updateBookLoan2.setDateReturn(date);
			BookLoanService.updateBookLoan(1, updateBookLoan2, Global.listBookLoan);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thư viện sau khi update: \n" + Arrays.toString(Global.listBookLoan.toArray()));
	}
	public static String getInputFromKeyboard(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt + " "); // Hiển thị lời nhắc
        return scanner.nextLine(); // Đọc dữ liệu nhập từ người dùng
    }
}