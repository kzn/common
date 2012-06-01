package ru.iitp.proling.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StringHashMapper implements StringMapper {
	final int size;
	final int bias;
	final int mod;
	
	public StringHashMapper(int size){
		this.size = size;
		this.mod = size/2;
		this.bias = size/2 + 1;
		
	}
	

	@Override
	public int lookup(String string) {
		return string.hashCode() % mod + bias;
	}

	@Override
	public int size() {
		return size;
	}


	@Override
	public void write(String filename) {
		try{
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
			fos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static StringHashMapper read(String filename) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream ois = new ObjectInputStream(fis);
		StringHashMapper obj = (StringHashMapper)ois.readObject();
		ois.close();
		fis.close();
		return obj;
	}

}
