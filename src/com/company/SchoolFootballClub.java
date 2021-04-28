package com.company;

import java.io.Serializable;
import java.util.Objects;

public class SchoolFootballClub extends FootballClub implements Serializable {

    private String schoolName;

    public SchoolFootballClub(){

    }

    public SchoolFootballClub(String nameOfTheClub, String location, int wins, int draws, int defeats, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfPoints, int numberOfMatchesPlayed, String schoolName) {
        super(nameOfTheClub, location, wins, draws, defeats, numberOfGoalsReceived, numberOfGoalsScored, numberOfPoints, numberOfMatchesPlayed);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolFootballClub that = (SchoolFootballClub) o;
        return Objects.equals(schoolName, that.schoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolName);
    }
}
