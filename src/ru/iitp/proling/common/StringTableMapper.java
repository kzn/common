package ru.iitp.proling.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import gnu.trove.TObjectHash;
import gnu.trove.TObjectIntHashMap;

public class StringTableMapper implements StringMapper {
	TObjectIntHashMap<String> table;
	
	public StringTableMapper(){
		this.table = new TObjectIntHashMap<String>();
	}
	
	public StringTableMapper(TObjectIntHashMap<String> table){
		this.table = table;
	}

	@Override
	public int lookup(String string) {
		int index = table.get(string);
		if(index == 0){
			index = table.size() + 1;
			table.put(string, index);
		}
		return index;
	}

	@Override
	public int size() {
		return table.size();
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
	
	public static StringTableMapper read(String filename) throws ClassNotFoundException{
		try{
			FileInputStream fis = new FileInputStream(filename);		
			ObjectInputStream ois = new ObjectInputStream(fis);
			StringTableMapper obj = (StringTableMapper)ois.readObject();
			ois.close();
			fis.close();
			return obj;
		}catch(IOException e){
			return new StringTableMapper();
		}

	}


}
