package g.io.text;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {

	public static void main(String[] args) {
		// 1. define a file object - source
		File file = new File("files/letter.txt");
		// 2. define a source object - IO Object
		FileReader in = null;
		try {
			in = new FileReader(file);
			// 3. read
			int c = in.read();
			while (c != -1) {
				System.out.print((char) c);
				c = in.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 4. close the stream
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
