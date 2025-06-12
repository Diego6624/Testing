package com.example.testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testing.entities.Producto;
import com.example.testing.services.ProductoService;

@RestController // This annotation marks the class as a REST controller
@RequestMapping("/productos") // This annotation specifies the base URL for the controller
public class ProductoController {
    @Autowired // This annotation is used for dependency injection
    private final ProductoService productoService; // Service to handle business logic

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    } // Constructor injection of the ProductoService

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    } // Endpoint to get all products

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    } // Endpoint to get a product by ID

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    } // Endpoint to create a new product

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        return productoService.actualizarProducto(id, productoActualizado);
    } // Endpoint to update a product by ID

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    } // Endpoint to delete a product by ID

}
