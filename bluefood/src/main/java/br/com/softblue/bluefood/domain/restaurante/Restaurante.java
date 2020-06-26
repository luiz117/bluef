package br.com.softblue.bluefood.domain.restaurante;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import org.springframework.web.multipart.MultipartFile;

import br.com.softblue.bluefood.domain.usuario.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@SuppressWarnings("serial")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded=true, callSuper = true)
@Entity
@Table(name="restaurante")
public class Restaurante extends Usuario{
	
	
	@NotBlank(message="O CNPJ precisa ser preenchido")
	@Pattern(regexp = "[0-9]{14}" , message="CPF com formato invalido ")
	@Column(length = 14, nullable = false)
	private String cnpj;
	
	@Size(max=80)
	private String logotipo;
	
	private transient MultipartFile logotipoFile;
	
	@NotNull(message = "A taxa de entrega não pode ser vazia")
	@Min(0)
	@Max(99)
	private BigDecimal taxaEntrega;
	
	@NotNull(message = "A tempo de entrega não pode ser vazia")
	@Min(0)
	@Max(120)
	private Integer tempoEntregaBase;
	
	//@ManyToMany(fetch = FetchType.EAGER)
	@ManyToMany
	@JoinTable(
			name = "restaurante_has_categoria",
			joinColumns = @JoinColumn(name = "restaurante_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_restaurante_id")
			)
	
	@Size(min=1, message = "O restaurante precisa ter pelo menos uma categoria")
	@ToString.Exclude
	private Set<CategoriaRestaurante> categorias = new HashSet<>(0);
	
	public void setLogotipoFileName() {
		
		if(getId()==null) {
			throw new IllegalStateException("É preciso primeiro gravar o registro");			
		}
		
		//TODO TROCAR FORMA DE LER EXTENSÃO
		this.logotipo = String.format("%04d-logo.%s", getId(),".png");
		
	}
	
	
}
