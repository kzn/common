package ru.iitp.proling.common;

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

}
