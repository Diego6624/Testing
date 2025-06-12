package com.example.testing.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // Lombok will generate getters, setters, toString, equals, and hashCode methods
@Entity // This annotation marks the class as a JPA entity
@Table(name = "productos") // This annotation specifies the table name in the database
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;
    
    @Column
    private double precio;

    @Column
    private int stock;
    
}
