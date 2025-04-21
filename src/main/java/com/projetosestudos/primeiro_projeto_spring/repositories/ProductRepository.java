package com.projetosestudos.primeiro_projeto_spring.repositories;

import com.projetosestudos.primeiro_projeto_spring.models.Category;
import com.projetosestudos.primeiro_projeto_spring.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { }
