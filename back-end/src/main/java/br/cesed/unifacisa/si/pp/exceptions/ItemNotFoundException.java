package br.cesed.unifacisa.si.pp.exceptions;

public class ItemNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(String msg){
		super(msg);
	}
	
}
