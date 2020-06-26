package br.com.softblue.bluefood.domain.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


//import org.springframework.boot.autoconfigure.domain.EntityScan;

import br.com.softblue.bluefood.domain.usuario.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded=true, callSuper = true)
@Entity
public class Cliente extends Usuario {
	
	@NotBlank(message="O CPF precisa ser preenchido")
	@Pattern(regexp = "[0-9]{11}" , message="CPF com formato invalido ")
	@Column(length = 11, nullable = false)
	private String cpf;
	
	@NotBlank(message="O CEP precisa ser preenchido")
	@Pattern(regexp = "[0-9]{8}" , message="CEP com formato invalido ")
	@Column(length = 8)
	private String cep;	

}
