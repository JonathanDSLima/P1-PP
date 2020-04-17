package br.cesed.unifacisa.si.pp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.cesed.unifacisa.si.pp.domains.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
