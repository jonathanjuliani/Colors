package br.com.jj.color.service.impl;

import br.com.jj.color.service.DecimalService;
import br.com.jj.color.utils.Utils;

public class RGB888DecimalService implements DecimalService {

	@Override
	public String toDecimal(String param) {
		
		String color = param.substring(2);
		String[] array;
		StringBuilder sb = new StringBuilder();
		
		array = color.split("(?<=\\G..)");

		for (String s : array) {
			sb.append(Utils.hexToDec(s));
		}
		
		return sb.toString();
	}

}
