package br.cesed.unifacisa.si.pp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cesed.unifacisa.si.pp.domains.Product;
import br.cesed.unifacisa.si.pp.domains.dtos.ProductDTO;
import br.cesed.unifacisa.si.pp.exceptions.ItemNotFoundException;
import br.cesed.unifacisa.si.pp.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductDTO> findAllproducts() {
		return productRepository.findAll().stream()
				.map(product -> 
				toProductDTO(product))
				.collect(Collectors.toList());
	}
	
	public Product findById(Long id){
		return productRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Produto não encontrado!"));
	}
	
	public ProductDTO getById(Long id) {
		return toProductDTO(findById(id));
	}
	
	public Product createProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setValue(productDTO.getValue());
		product.setImage(productDTO.getImage());
		return productRepository.save(product);
	}
	
	public Product updateProduct(long id, ProductDTO productDTO) {
		Product product = this.findById(id);
		product.setName(productDTO.getName());
		product.setValue(productDTO.getValue());
		product.setImage(productDTO.getImage());
		return productRepository.save(product);
	}
	
	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}
	
	private ProductDTO toProductDTO(Product product) {
		return new ProductDTO(product.getName(),product.getValue(), product.getImage());
	}

}
