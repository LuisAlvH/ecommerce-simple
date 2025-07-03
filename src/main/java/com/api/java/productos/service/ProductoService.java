package com.api.java.productos.service;

import java.util.List;

import com.api.java.productos.model.Producto;
import java.util.Optional;

public interface ProductoService {
    public List<Producto>getAll();
    public Optional<Producto>getId(Long id);
    public Producto add(Producto producto);
    public Producto update(Long id, Producto producto);
    public void delete(Long id);
}
