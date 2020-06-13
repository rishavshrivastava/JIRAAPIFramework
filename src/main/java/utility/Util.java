package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Util {

	public static String readFile() {
		String st = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("ID.txt")); 
			while ((st = br.readLine()) != null) 
				return st;
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return st;
	}
	
	public static void writeFile(String data, String filepath) {
		try {
			FileWriter writer = new FileWriter(filepath);
			BufferedWriter buffer = new BufferedWriter(writer);  
		    buffer.write(data);  
		    buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
}
