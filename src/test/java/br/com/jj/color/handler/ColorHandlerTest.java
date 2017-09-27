package br.com.jj.color.handler;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.Test;
import org.mockito.Mock;

public class ColorHandlerTest {
	
	@Mock
	ColorHandler handler;

	@Test
	public void sucessoComHexaParaDecimalRGB888() {
		
		String[] args = null;
		String expected = "255 255 255";
		
		when(handler.getNextLine()).thenReturn("rgb888");
		when(handler.getNextLine()).thenReturn("FFFF00");
		
		handler.main(args);
		
		
		fail("Not yet implemented");
	}
	
//	@Test
//	public void sucessoComHexaParaDecimalRGB565() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void sucessoComDecimalParaHexaRGB888() {
//		fail("Not yet implemented");
//	}
//
//	
//	@Test
//	public void sucessoComDecimalParaHexaRGB565() {
//		fail("Not yet implemented");
//	}

}
