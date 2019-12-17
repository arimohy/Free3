package com.example.free;

public class cAgua {
    private String nombreMarca;
    private String urlPhoto;
    private int cantidad;
    private int kilo;
    private boolean confirmar;

    public cAgua(String nombreMarca, String urlPhoto) {
        this.nombreMarca = nombreMarca;
        this.urlPhoto = urlPhoto;
        this.cantidad = 0;
        this.kilo = 0;
        this.confirmar = false;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getKilo() {
        return kilo;
    }

    public void setKilo(int kilo) {
        this.kilo = kilo;
    }

    public boolean isConfirmar() {
        return confirmar;
    }

    public void setConfirmar(boolean confirmar) {
        this.confirmar = confirmar;
    }
}
