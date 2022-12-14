package edu.unicauca.agrofer;

public class ListElement {

    public String color;
    public String name;
    public String puntaje;
    public String imgUrl;

    public ListElement(String color, String name, String puntaje, String imgUrl) {
        this.color = color;
        this.name = name;
        this.puntaje = puntaje;
        this.imgUrl = imgUrl;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
