package com.company;

import java.io.Serializable;

public class Match implements Serializable,Comparable <Match> {
    private static final long serialVersionUID = 1L;

    private int year;
    private int month;
    private int day;
    private String team1;
    private int score1;
    private String team2;
    private int score2;
    boolean yearIsCorrect = false;
    boolean monthIsCorrect = false;
    boolean dayIsCorrect = false;

    public Match(){

    }
    public Match(int year, int month, int day, String team1, int score1, String team2, int score2) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.team1 = team1;
        this.score1 = score1;
        this.team2 = team2;
        this.score2 = score2;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }


    public int getYear() {
        return year;
    }

    public void setYear(String stringYear) {

//    year validation

        try {

            this.year = Integer.parseInt(stringYear);

            if (year > 999 && year < 10000) {

                yearIsCorrect = true;

            } else {
                System.out.println("Year is not in range");
            }



        } catch (Exception e1) {

            System.out.println("Invalid year");
        }
    }

    //    month validation

    public int getMonth() {
        return month;
    }

    public void setMonth(String stringMonth) {

        try {

            this.month = Integer.parseInt(stringMonth);

            if (month > 0 && month < 13) {

                this.month = Integer.parseInt(stringMonth);
                monthIsCorrect = true;

            } else {
                System.out.println("Month is not in range");
            }

        } catch (Exception e2) {

            System.out.println("Invalid month");
        }
    }

//    day validation

    public int getDay() {
        return day;
    }

    public void setDay(String stringDay) {

        try {

            day = Integer.parseInt(stringDay);

            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {

                if (day > 0 && day < 32) {

                    day = Integer.parseInt(stringDay);
                    dayIsCorrect = true;

                } else {
                    System.out.println("Day is not in range");
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {

                if (day > 0 && day < 31) {

                    day = Integer.parseInt(stringDay);
                    dayIsCorrect = true;

                } else {
                    System.out.println("Day is not in range");
                }
            }
            else if (month == 2 && (year % 4 == 0)) {

                if (day > 0 && day < 30) {

                    day = Integer.parseInt(stringDay);
                    dayIsCorrect = true;

                } else {
                    System.out.println("Day is not in range");
                }
            }
            else if (month == 2 && !(year % 4 == 0)) {

                if (day > 0 && day < 29) {

                    day = Integer.parseInt(stringDay);
                    dayIsCorrect = true;

                } else {
                    System.out.println("Day is not in range");
                }
            }
            else {
                System.out.println("Month is not in range");
            }
        }

        catch (Exception e3){

            System.out.println("Invalid day");
        }
    }


    @Override
    public String toString() {
        return "Match{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", score1=" + score1 +
                ", score2=" + score2 +
                '}';
    }

//    sorting according to date

    @Override
    public int compareTo(Match dateSortObj) {

        if (year == dateSortObj.year){
            if (month == dateSortObj.month){
                if (day == dateSortObj.day){
                    return 0;
                }
                else if (day > dateSortObj.day){
                    return 1;
                }
                else {
                    return -1;
                }            }
            else if (month > dateSortObj.month){
                return 1;
            }
            else {
                return -1;
            }
        }

        else if (year > dateSortObj.year)
            return 1;
        else
            return -1;

    }
}
