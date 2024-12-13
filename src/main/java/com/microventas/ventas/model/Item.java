package com.microventas.ventas.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Item {

    private String nombre;
    private Integer quantity;
    private Double precio;


    public Item() {
    }
    

    public Item(String nombre, Integer quantity, Double precio) {
        this.nombre = nombre;
        this.quantity = quantity;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
