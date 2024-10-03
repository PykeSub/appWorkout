package com.example.workout;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;
    private String correo;
    private String contrasenia;
    private String confirmacion;

    public Usuario(String nombre, String correo, String contrasenia, String confirmacion) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.confirmacion = confirmacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", confirmacion='" + confirmacion + '\'' +
                '}';
    }
}
