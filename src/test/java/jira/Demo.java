package jira;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		writeFile("Rishav", "ID.txt");
	}
	
	public static void writeFile(String data, String path) {
		try {
			FileWriter writer = new FileWriter(path);  
			BufferedWriter buffer = new BufferedWriter(writer);  
			buffer.write(data);  
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
