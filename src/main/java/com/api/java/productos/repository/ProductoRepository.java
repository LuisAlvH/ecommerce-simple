package com.api.java.productos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.java.productos.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long>{
        public List<Producto> findAll();
        public Optional findById(Long id); 
        public Producto save(Producto a); 
        public void deleteById(Long id);
}
