package br.cesed.unifacisa.si.pp.domains.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private String name;
	
	private double value;
	
	private String image;

}
