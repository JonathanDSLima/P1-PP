package br.cesed.unifacisa.si.pp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {

	private long timeStamp;
	
	private String path;
	
	private String message;
	
	private String error;
	
	private Integer status;
	
}
