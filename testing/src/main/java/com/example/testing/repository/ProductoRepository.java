package com.example.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testing.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // This interface will automatically provide CRUD operations for the Producto entity
    // No need to define any methods here, JpaRepository provides them out of the box
}
