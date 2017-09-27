package br.com.jj.color.service.impl;

import br.com.jj.color.service.HexaService;

public class RGB565HexaService implements HexaService {

	@Override
	public String toHex(String param) {

		String color = param;
		StringBuilder sb = new StringBuilder();
		String[] array = color.split(" ");

		int r = Integer.parseInt(array[0]);
		int g = Integer.parseInt(array[1]);
		int b = Integer.parseInt(array[2]);

		String rS = Integer.toString(r, 2);
		String gS = Integer.toString(g, 2);
		String bS = Integer.toString(b, 2);

		if (rS.length() < 5) {
			rS = appendLeftZeros(rS, 5);
		}

		if (gS.length() < 5) {
			gS = appendLeftZeros(gS, 6);
		}

		if (bS.length() < 5) {
			bS = appendLeftZeros(bS, 5);
		}

		sb.append(rS);
		sb.append(gS);
		sb.append(bS);

		array = sb.toString().split("(?<=\\G.{8})");

		sb = new StringBuilder();
		sb.append("0x");

		for (String s : array) {
			int decimal = Integer.parseInt(s, 2);
			sb.append(decToHex(String.valueOf(decimal)));
		}
		
		return sb.toString();
	}
	
	private String appendLeftZeros(String param, int length) {

		String ret = ("000000" + param);
		ret = ret.substring(ret.length() - length, ret.length());
		return ret;
	}
	
	private String decToHex(String s) {
		return String.format("%02X", Integer.parseInt(s));
	}

}
