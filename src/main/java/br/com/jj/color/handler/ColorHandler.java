package br.com.jj.color.handler;

import java.util.Scanner;

import br.com.jj.color.models.ColorRGB;
import br.com.jj.color.service.CorService;
import br.com.jj.color.service.impl.DefaultCorService;

public class ColorHandler {
	
	static CorService corService = new DefaultCorService();

	public static void main(String[] args) {

		String rgbFormat;
		String color;
		
		while (true) {			
			
			System.out.println("Entre com o formato da cor (RGB888 ou RGB565):\n");
			rgbFormat = getNextLine();
			
			System.out.println("Entre com a cor: \n");
			color = getNextLine();
			
			String result = parseColor(rgbFormat, color);
			System.out.println(result);
			break;
		}
		

	}
	
	public static String getNextLine() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	private static String parseColor(String rgbFormat, String color) {
		
		String mensagem = null;
		
		if ( corService.validarFormato(rgbFormat) ) {
			if( corService.validarCor(color) ) {
				
				ColorRGB rgb = corService.buildColorRGB(rgbFormat, color);
				rgb = corService.parse(rgb);
				
				if(rgb.hasError()) {
					mensagem = rgb.getError().getDescription();
				} else {
					mensagem = rgb.getConvertedColor();
				}
				
			} else {
				mensagem = "Formato de cor inv�lido!\nEntre com a com em hexadecimal (0xFFE0) ou em decimal (255 255 0).";
			}
		} else {
			mensagem = "Formato inv�lido! Formato informado � diferente de RGB888 ou RGB565.";
		}
		
		return mensagem;
	}
}
