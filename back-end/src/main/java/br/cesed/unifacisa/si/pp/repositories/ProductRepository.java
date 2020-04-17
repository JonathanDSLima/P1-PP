package br.cesed.unifacisa.si.pp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cesed.unifacisa.si.pp.domains.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
