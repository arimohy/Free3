package com.example.free;

public class Producto {
    private String nombre;
    private String urlPhoto;
    private String comentario;

    public Producto(String nombre, String urlPhoto, String comentario) {
        this.nombre = nombre;
        this.urlPhoto = urlPhoto;
        this.comentario = comentario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

