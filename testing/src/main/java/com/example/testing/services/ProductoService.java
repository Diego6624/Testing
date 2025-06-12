package com.example.testing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.testing.entities.Producto;
import com.example.testing.repository.ProductoRepository;

@Service // This annotation marks the class as a service component in Spring
public class ProductoService {
    // This field is used to interact with the database for product operations
    private final ProductoRepository productoRepository;

    // Constructor injection of the ProductoRepository dependency
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // This method retrieves all products from the database
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    // This method retrieves a product by its ID
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }
    // This method updates a product by its ID
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setNombre(productoActualizado.getNombre());
                    producto.setDescripcion(productoActualizado.getDescripcion());
                    producto.setPrecio(productoActualizado.getPrecio());
                    producto.setStock(productoActualizado.getStock());
                    return productoRepository.save(producto);
                })
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    // This method saves a new product to the database
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // This method deletes a product by its ID
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}