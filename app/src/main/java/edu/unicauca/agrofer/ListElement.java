package edu.unicauca.agrofer;

public class ListElement {
    public String imgPrincipal;
    public String color;
    public String name;
    public String puntaje;

    public ListElement(String color, String name, String puntaje) {
        this.color = color;
        this.name = name;
        this.puntaje = puntaje;
        this.imgPrincipal = imgPrincipal;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    public String getImgPrincipal() {
        return imgPrincipal;
    }

    public void setImgPrincipal(String imgPrincipal) {
        this.imgPrincipal = imgPrincipal;
    }
}
