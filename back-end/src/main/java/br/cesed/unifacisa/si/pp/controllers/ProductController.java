package br.cesed.unifacisa.si.pp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.cesed.unifacisa.si.pp.domains.Product;
import br.cesed.unifacisa.si.pp.domains.dtos.ProductDTO;
import br.cesed.unifacisa.si.pp.services.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired 
	private ProductService productService;

	@GetMapping()
	public ResponseEntity<List<ProductDTO>> getProducts(){
		return new ResponseEntity<List<ProductDTO>>(productService.findAllproducts(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
		return new ResponseEntity<ProductDTO>(productService.getById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
		return new ResponseEntity<Product>(productService.createProduct(productDTO), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
		return new ResponseEntity<Product>(productService.updateProduct(id, productDTO), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
