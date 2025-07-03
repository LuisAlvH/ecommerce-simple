package com.api.java.productos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.java.productos.model.Producto;
import com.api.java.productos.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;


    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    @Override
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }
    @Override
    public Optional<Producto> getId(Long id) {
        return productoRepository.findById(id);
    }
    @Override
    public Producto add(Producto producto) {
       return productoRepository.save(producto);

    }
    @Override
    public Producto update(Long id, Producto producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }
    @Override
    public void delete(Long id) {
         productoRepository.deleteById(id);
    }
}
