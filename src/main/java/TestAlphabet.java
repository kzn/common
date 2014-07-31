import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import name.kazennikov.common.Alphabet;




public class TestAlphabet {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Alphabet<String> towrite = new Alphabet<String>();
		
		towrite.get("a");
		towrite.get("b");
		
		FileOutputStream fos = new FileOutputStream("test.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(towrite);
		oos.close();
		fos.close();
		
		Alphabet<String> toRead;
		
		FileInputStream fis = new FileInputStream("test.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		toRead = (Alphabet<String>)ois.readObject();
		
		assert toRead.get(1).equals("a");
		System.out.println(toRead);

	}

}
