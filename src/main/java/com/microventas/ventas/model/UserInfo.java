package com.microventas.ventas.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserInfo {

    private String nombre;
    private String email;
    private String direccion;

    // Constructor por defecto
    public UserInfo() {
    }

    // Constructor con todos los campos
    public UserInfo(String nombre, String email, String direccion) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
