package br.com.softblue.bluefood.util;

//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;

public class StringUtils {
	
	public static boolean isEmpty(String str) {
		
		if(str==null) {
			return true;
		}
		
		return str.trim().length()==0;
	}
	
	
	public static String encrypt(String rawString){
			
		if(isEmpty(rawString)) {
			return null;				
		}
		//PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//return encoder.encode(rawString);
		return rawString;
	}
	
	
	
	
	
	
//public static boolean isEmpty2(String str) {
//		
//		if(str==null) {
//			return true;
//		}
//		
//		return str.trim().length()==0;
//	}
//	
	
	
	
	
}
