package com.laboratorul_5.entity;

public class Carte {
    private int id;
    private String denumire;
    private String autor;
    private int an;

    public Carte(int id, String denumire, String autor, int an) {
        this.id = id;
        this.denumire = denumire;
        this.autor = autor;
        this.an = an;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", autor='" + autor + '\'' +
                ", an=" + an +
                '}';
    }
}
