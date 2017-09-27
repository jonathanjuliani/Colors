package br.com.jj.color.service.impl;

import br.com.jj.color.enums.ConversionType;
import br.com.jj.color.enums.RGBFormat;
import br.com.jj.color.models.ColorRGB;
import br.com.jj.color.models.Error;
import br.com.jj.color.service.CorService;
import br.com.jj.color.service.DecimalService;
import br.com.jj.color.service.HexaService;

public class DefaultCorService implements CorService {

	String decimal = "[0-9]{1,3}[ ]?[0-9]{1,3}[ ]?[0-9]{1,3}[ ]?";
	String hexa	= "^[0-9A-Fa-f]{1,6}+$";
	DecimalService decimalService;
	HexaService hexaService;

	@Override
	public boolean validarFormato(String formato) {

		if (formato.equalsIgnoreCase(RGBFormat.RGB565.getFormat()) || formato.equalsIgnoreCase(RGBFormat.RGB888.getFormat())) {
			return true;
		}

		return false;
	}

	@Override
	public boolean validarCor(String param) {
		
		String color = param.substring(2);
		
		if ( color.matches(decimal) || color.matches(hexa) ) {
			return true;
		}
		
		return false;
	}

	@Override
	public ColorRGB buildColorRGB(String format, String color) {
		
		ColorRGB cor = new ColorRGB();

		try {
			
			cor.setColor(color);
			cor.setConversionType( getConversionType(color) );
			cor.setFormat( getFormat(format) );
			
		} catch (Exception e) {
			cor.setError( new Error(e.getMessage(), e.toString()));
		}
		
		return cor;
	}

	private RGBFormat getFormat(String format) {
		
		if ( format.equalsIgnoreCase(RGBFormat.RGB565.getFormat()) ) {
			return RGBFormat.RGB565;
		}
		
		return RGBFormat.RGB888;
	}

	private ConversionType getConversionType(String color) {
		
		if ( color.matches(decimal) ){
			return ConversionType.TOHEX;
		}
		
		return ConversionType.TODEC;
	}

	@Override
	public ColorRGB parse(ColorRGB rgb) {
		
		String converted = "";
		
		try {
			
			setHexaService(rgb.getFormat());
			setDecimalService(rgb.getFormat());
			
			if(rgb.getConversionType().equals(ConversionType.TODEC)) {
				converted = decimalService.toDecimal(rgb.getColor());
			} else {
				converted = hexaService.toHex(rgb.getColor());
			}
		
			rgb.setConvertedColor(converted);
			return rgb;
			
		} catch (Exception e) {
			rgb.setError(new Error(e.getMessage(), e.getLocalizedMessage()));
		}
		
		return rgb;
	}

	private void setHexaService(RGBFormat format) {
		if (format.equals(RGBFormat.RGB888)) {
			this.hexaService = new RGB888HexaService();
		} else {
			this.hexaService = new RGB565HexaService();
		}
	}

	private void setDecimalService(RGBFormat format) {
		if (format.equals(RGBFormat.RGB888)) {
			this.decimalService = new RGB888DecimalService();
		} else {
			this.decimalService = new RGB565DecimalService();
		}
	}

}
