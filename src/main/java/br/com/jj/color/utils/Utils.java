package br.com.jj.color.utils;

public class Utils {

	public static String hexToDec(String s) {
		return String.valueOf(Integer.parseInt(s, 16) + " ");
	}
	
	public static String decToHex(String s) {
		return String.format("%02X", Integer.parseInt(s));
	}
}
