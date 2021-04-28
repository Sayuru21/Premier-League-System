package com.company;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class FootballClub extends SportsClub implements Serializable {
    private static final long serialVersionUID = 1L;

    private int wins ;
    private int draws ;
    private int defeats ;
    private int numberOfGoalsReceived ;
    private int numberOfGoalsScored ;
    private int numberOfPoints ;
    private int numberOfMatchesPlayed ;


    public FootballClub(){

    }

    public FootballClub(String nameOfTheClub,String location, int wins, int draws, int defeats, int numberOfGoalsReceived,
                        int numberOfGoalsScored, int numberOfPoints, int numberOfMatchesPlayed) {
        super(nameOfTheClub,location);

        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.numberOfGoalsReceived = numberOfGoalsReceived;
        this.numberOfGoalsScored = numberOfGoalsScored;
        this.numberOfPoints = numberOfPoints;
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getNumberOfGoalsReceived() {
        return numberOfGoalsReceived;
    }

    public void setNumberOfGoalsReceived(int numberOfGoalsReceived) {
        this.numberOfGoalsReceived = numberOfGoalsReceived;
    }

    public int getNumberOfGoalsScored() {
        return numberOfGoalsScored;
    }

    public void setNumberOfGoalsScored(int numberOfGoalsScored) {
        this.numberOfGoalsScored = numberOfGoalsScored;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public int getNumberOfMatchesPlayed() {
        return numberOfMatchesPlayed;
    }

    public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "wins=" + wins +
                ", draws=" + draws +
                ", defeats=" + defeats +
                ", numberOfGoalsReceived=" + numberOfGoalsReceived +
                ", numberOfGoalsScored=" + numberOfGoalsScored +
                ", numberOfPoints=" + numberOfPoints +
                ", numberOfMatchesPlayed=" + numberOfMatchesPlayed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballClub that = (FootballClub) o;
        return Objects.equals(wins, that.wins) &&
                Objects.equals(draws, that.draws) &&
                Objects.equals(defeats, that.defeats) &&
                Objects.equals(numberOfGoalsReceived, that.numberOfGoalsReceived) &&
                Objects.equals(numberOfGoalsScored, that.numberOfGoalsScored) &&
                Objects.equals(numberOfPoints, that.numberOfPoints) &&
                Objects.equals(numberOfMatchesPlayed, that.numberOfMatchesPlayed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wins, draws, defeats, numberOfGoalsReceived, numberOfGoalsScored, numberOfPoints, numberOfMatchesPlayed);
    }


/*
 sorting according to points

 if point are equal then sorting according to goal difference
 */

    public static Comparator <FootballClub> pointComparator = new Comparator<FootballClub>() {
        @Override
        public int compare(FootballClub obj1, FootballClub obj2) {
            int point1 = obj1.getNumberOfPoints();
            int point2 = obj2.getNumberOfPoints();
            int goalDifference1 = obj1.getNumberOfGoalsScored() - obj1.getNumberOfGoalsReceived();
            int goalDifference2 = obj2.getNumberOfGoalsScored() - obj2.getNumberOfGoalsReceived();

            if (point1 - point2 == 0){

                return goalDifference2 - goalDifference1;
            }
            else
                return point2 - point1;
        }
    };

//    sorting according to wins

    public static Comparator <FootballClub> winComparator = new Comparator<FootballClub>() {
        @Override
        public int compare(FootballClub obj1, FootballClub obj2) {
            int win1 = obj1.getWins();
            int win2 = obj2.getWins();
            return win2 - win1;
        }
    };

//    sorting according to goals scored

    public static Comparator <FootballClub> goalScoredComparator = (obj1, obj2) -> {
        int goalScored1 = obj1.getNumberOfGoalsScored();
        int goalScored2 = obj2.getNumberOfGoalsScored();
        return goalScored2 - goalScored1;
    };
}
