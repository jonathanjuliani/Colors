package br.com.jj.color.enums;

public enum RGBFormat {
	
	RGB888 ("rgb888"),
	RGB565 ("rgb565");
	
	String format;
	
	private RGBFormat(String format) {
		this.format = format;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
