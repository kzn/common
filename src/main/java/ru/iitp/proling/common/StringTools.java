package ru.iitp.proling.common;

import java.util.ArrayList;
import java.util.List;

public class StringTools {
	
	/**
	 * Convert a string into a list of characters
	 * @param s string to convert
	 * @return resulting list
	 */
	public static List<Character> explode(String s) {
		List<Character> list = new ArrayList<Character>(s.length());
		
		for(int i = 0; i < s.length(); i++)
			list.add(s.charAt(i));
		
		return list;
	}
	
	
	/**
	 * Convert a list of characters into a string
	 * @param list source array to convert
	 * @return resulting string
	 */
	public static String implode(List<Character> list) {
		StringBuilder sb = new StringBuilder(list.size());
		
		for(Character ch : list)
			sb.append(ch);
		
		return sb.toString();
	}
	
	/**
	 * Splits a string with a char separator
	 * @param s string to parse
	 * @param sep separator
	 * @param skipEmpty if true, skip empty result string
	 * @return list of splitted strings
	 */
	public static List<String> split(String s, char sep, boolean skipEmpty) {
		List<String> parts = new ArrayList<String>();
		int last = 0;
		for(int i = 0; i != s.length(); i++) {
			if(s.charAt(i) == sep) {
				if(!skipEmpty || last != i)
					parts.add(s.substring(last, i));
				last = i + 1; // after the sep

			}
		}
		if(last != s.length())
			parts.add(s.substring(last, s.length()));
		return parts;
	}
	


}
