package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Address implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.AUTO) // vezi si application.properties
    private int id;
    private String email;
    private String street;
    private String number;
    private String building;
    private String sc;
    private String ap;
    private int postalCod;

    public Address() {
    }

    public Address(int id, String email, String street, String number, String building, String sc, String ap, int postalCod) {
        this.id= id;
        this.email = email;
        this.street = street;
        this.number = number;
        this.building = building;
        this.sc = sc;
        this.ap = ap;
        this.postalCod = postalCod;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public Address(String email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public int getPostalCod() {
        return postalCod;
    }

    public void setPostalCod(int postalCod) {
        this.postalCod = postalCod;
    }


    @Override
    public String toString() {
        return "Address{" +
                "email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", building='" + building + '\'' +
                ", sc='" + sc + '\'' +
                ", ap='" + ap + '\'' +
                ", postalCod='" + postalCod + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (getPostalCod() != address.getPostalCod()) return false;
        if (!getEmail().equals(address.getEmail())) return false;
        if (!getStreet().equals(address.getStreet())) return false;
        if (!getNumber().equals(address.getNumber())) return false;
        if (!getBuilding().equals(address.getBuilding())) return false;
        if (!getSc().equals(address.getSc())) return false;
        return getAp().equals(address.getAp());
    }

    @Override
    public int hashCode() {
        int result = getEmail().hashCode();
        result = 31 * result + getStreet().hashCode();
        result = 31 * result + getNumber().hashCode();
        result = 31 * result + getBuilding().hashCode();
        result = 31 * result + getSc().hashCode();
        result = 31 * result + getAp().hashCode();
        result = 31 * result + getPostalCod();
        return result;
    }
}
