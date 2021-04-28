package com.company;

import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nameOfTheClub;
    private String location;

    public SportsClub(){

    }

    public SportsClub(String nameOfTheClub, String location) {
        super();
        this.nameOfTheClub = nameOfTheClub;
        this.location = location;
    }

    public String getNameOfTheClub() {
        return nameOfTheClub;
    }

    public void setNameOfTheClub(String nameOfTheClub) {
        this.nameOfTheClub = nameOfTheClub;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "SportsClub { nameOfTheClub = " + nameOfTheClub + " , location = " + location + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return Objects.equals(nameOfTheClub, that.nameOfTheClub) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfTheClub, location);
    }
}
