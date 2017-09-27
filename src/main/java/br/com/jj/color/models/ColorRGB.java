package br.com.jj.color.models;

import br.com.jj.color.enums.ConversionType;
import br.com.jj.color.enums.RGBFormat;

public class ColorRGB {

	private String color;

	private String convertedColor;

	private RGBFormat format;

	private ConversionType conversionType;

	private Error error;

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		sb.append("color: ");
		sb.append(getColor());
		sb.append(",");
		sb.append("converted-color: ");
		sb.append(getConvertedColor());
		sb.append(" ]");
		return sb.toString();
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public boolean hasError() {
		if (null != getError()) {
			return true;
		}
		return false;
	}

	public RGBFormat getFormat() {
		return format;
	}

	public void setFormat(RGBFormat format) {
		this.format = format;
	}

	public ConversionType getConversionType() {
		return conversionType;
	}

	public void setConversionType(ConversionType conversionType) {
		this.conversionType = conversionType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getConvertedColor() {
		return convertedColor;
	}

	public void setConvertedColor(String convertedColor) {
		this.convertedColor = convertedColor;
	}
}
