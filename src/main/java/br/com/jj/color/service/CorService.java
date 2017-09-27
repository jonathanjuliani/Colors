package br.com.jj.color.service;

import br.com.jj.color.models.ColorRGB;

public interface CorService {

	boolean validarFormato(String param);

	boolean validarCor(String param);
	
	ColorRGB buildColorRGB (String format, String color);
	
	ColorRGB parse (ColorRGB rgb);
}
