package br.com.softblue.bluefood;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
	
	private String Nome;
	
	
	public static void main(String[] args) {
		Cliente c = new Cliente();		
		c.setNome("abc");
		c.getNome();
	}	
}
