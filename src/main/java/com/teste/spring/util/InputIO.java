package com.teste.spring.util;

import java.text.Normalizer;

public class InputIO {
	
	public static String checkInput(String str){
				
		String input =  Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		
		return input.toLowerCase();
		
	}
		
}
