package br.cesed.unifacisa.si.pp.domains;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private double value;
	
	@NotBlank
	private String image;

}
