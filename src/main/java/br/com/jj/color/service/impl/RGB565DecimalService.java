package br.com.jj.color.service.impl;

import br.com.jj.color.service.DecimalService;

public class RGB565DecimalService implements DecimalService {

	@Override
	public String toDecimal(String param) {
		
		String color = param.substring(2);;
		StringBuilder sb = new StringBuilder();
		String[] array = color.split("(?<=\\G.{2})");

		for (String s : array) {
			String aux = hexToDec(s).trim();
			int n = Integer.parseInt(aux);
			s = Integer.toString(n, 2);
			sb.append(s);
		}

		String rgb = sb.toString();
		String r = rgb.substring(0, 5);
		String g = rgb.substring(5, 11);
		String b = rgb.substring(11, 16);

		sb = new StringBuilder();
		sb.append(Integer.parseInt(r, 2) + " ");
		sb.append(Integer.parseInt(g, 2) + " ");
		sb.append(Integer.parseInt(b, 2));
		
		return sb.toString();
	}
	
	private String hexToDec(String s) {
		return String.valueOf(Integer.parseInt(s, 16) + " ");
	}

}
