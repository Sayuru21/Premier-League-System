package com.company;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {
    
    LeagueManager premierLeagueManager = new PremierLeagueManager();


    public Main(){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("");
        System.out.println("                                       ***   Premier league championship   ***");
        System.out.println("");

//        reading from 3 files

        try {
            premierLeagueManager.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            premierLeagueManager.readFile1();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            premierLeagueManager.readFile2();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        while (true){

            System.out.println("Enter 1 for add a new football club to premier league.");
            System.out.println("Enter 2 for delete an existing club from the premier league.");
            System.out.println("Enter 3 for display the various statistics for a selected club.");
            System.out.println("Enter 4 for display the premier league table.");
            System.out.println("Enter 5 for add a played match.");
            System.out.println("Enter 6 for open GUI.");
            System.out.println("Enter 7 for quit the program.");
            System.out.println("");

            try {

                Scanner input = new Scanner(System.in);
                System.out.print("Your choice: ");
                String choiceStr = input.nextLine();
                System.out.println("");
                int choiceInt = Integer.parseInt(choiceStr);

                switch (choiceInt){

                    case 1 :

//                        add a new club

                        premierLeagueManager.addANewClub();
                        break;

                    case 2 :

//                        delete a club

                        premierLeagueManager.deleteAClub();
                        break;

                    case 3 :

//                        display statistics for selected club

                        premierLeagueManager.variousStatisticsForSelectedClub();
                        break;

                    case 4 :

//                       display premier league table

                        premierLeagueManager.premierLeagueTable();
                        break;

                    case 5 :

//                        add a played match

                        premierLeagueManager.addAPlayedMatch();
                        break;

                    case 6 :

//                        open gui

                        premierLeagueManager.gUI();
                        break;

                    case 7 :

//                        writing to 3 files

                        premierLeagueManager.writeFile();
                        premierLeagueManager.writeFile1();
                        premierLeagueManager.writeFile2();
                        System.exit(0);

                    default:
                        System.out.println("Please enter valid number");
                }

            }
            catch (Exception exception){

                System.out.println("Your choice is invalid");
            }
        }
    }

    public static void main(String[] args)  {
        launch(args);
    }

}



