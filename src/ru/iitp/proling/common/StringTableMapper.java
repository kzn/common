package ru.iitp.proling.common;

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

}
