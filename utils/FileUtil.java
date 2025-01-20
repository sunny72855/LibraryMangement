package utils;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

	public static boolean saveFile(String data, String fileName) {
		try (FileOutputStream fos = new FileOutputStream(fileName)) {
			fos.write(data.getBytes());
			System.out.println("File saved successfully " + fileName);
			return true;
		} catch (IOException e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}
		return false;
	}
	
	public static void appendToFile(String filePath, String data) {
        try (FileWriter writer = new FileWriter(filePath, true)) { // 'true' để bật chế độ append
            writer.write(data); // Ghi dữ liệu và thêm dòng mới
            System.out.println("Dữ liệu đã được thêm vào file: " + filePath);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi thêm vào file: " + e.getMessage());
        }
    }

	public static String readFile(String fileName) {
		String ret = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;

			while ((line = reader.readLine()) != null) {
				ret += line + "\n";
			}

		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
			saveFile("", "Book.txt");
		}
		return ret;
	}
}
