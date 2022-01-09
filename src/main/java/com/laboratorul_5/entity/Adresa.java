package com.laboratorul_5.entity;

public class Adresa {
    private int id;
    private String tara;
    private String oras;
    private String strada;
    private int nrCasa;
    private int nrApartament;

    public Adresa(int id, String tara, String oras, String strada, int nrCasa, int nrApartament) {
        this.id = id;
        this.tara = tara;
        this.oras = oras;
        this.strada = strada;
        this.nrCasa = nrCasa;
        this.nrApartament = nrApartament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNrCasa() {
        return nrCasa;
    }

    public void setNrCasa(int nrCasa) {
        this.nrCasa = nrCasa;
    }

    public int getNrApartament() {
        return nrApartament;
    }

    public void setNrApartament(int nrApartament) {
        this.nrApartament = nrApartament;
    }

    @Override
    public String toString() {
        return "Adresa{" +
                "id=" + id +
                ", tara='" + tara + '\'' +
                ", oras='" + oras + '\'' +
                ", strada='" + strada + '\'' +
                ", nrCasa=" + nrCasa +
                ", nrApartament=" + nrApartament +
                '}';
    }
}
