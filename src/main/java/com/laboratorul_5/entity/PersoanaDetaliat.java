package com.laboratorul_5.entity;

public class PersoanaDetaliat {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private char gender;
    private Adresa adresa;

    public PersoanaDetaliat(int id, String firstName, String lastName, String email, char gender, int idd, String tara, String oras, String strada, int nrCasa, int nrApartament) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        adresa = new Adresa(idd, tara, oras, strada, nrCasa, nrApartament);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "PersoanaDetaliat{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", adresa=" + adresa +
                '}';
    }
}
