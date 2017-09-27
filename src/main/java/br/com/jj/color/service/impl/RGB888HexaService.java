package br.com.jj.color.service.impl;

import br.com.jj.color.service.HexaService;
import br.com.jj.color.utils.Utils;

public class RGB888HexaService implements HexaService {

	@Override
	public String toHex(String param) {
		
		String color = param;
		String[] array;
		StringBuilder sb = new StringBuilder();
		
		array = color.split(" ");
		sb.append("0x");
		for (String s : array) {
			sb.append(Utils.decToHex(s));
		}
		
		return sb.toString();
	}
	
}
