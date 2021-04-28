package com.company;

import java.io.Serializable;
import java.util.Objects;

public class UniversityFootballClub extends FootballClub implements Serializable {



    private String universityName;

    public UniversityFootballClub(){

    }

    public UniversityFootballClub(String nameOfTheClub, String location, int wins, int draws, int defeats, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfPoints, int numberOfMatchesPlayed, String universityName) {
        super(nameOfTheClub, location, wins, draws, defeats, numberOfGoalsReceived, numberOfGoalsScored, numberOfPoints, numberOfMatchesPlayed);
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversityFootballClub that = (UniversityFootballClub) o;
        return Objects.equals(universityName, that.universityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(universityName);
    }
}
