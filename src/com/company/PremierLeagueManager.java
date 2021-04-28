package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDate;
import java.util.*;



public class PremierLeagueManager implements LeagueManager,Serializable {
    private static final long serialVersionUID = 1L;

    private List<FootballClub> footballClubArr = new ArrayList<FootballClub>();
    private List<Match> matchArr = new ArrayList<Match>();
    private List<Match> randomMatchArr = new ArrayList<Match>();
    Match playedDate = new Match();
    Match matchObj;
    private static int winingPoints = 3;
    private static int drawPoints = 1;
    TextField yearTF, monthTF, dayTF;
    TableView table4;


    @Override
    // Add a new football club to the  premier league
    public void addANewClub() throws IOException {

        System.out.println("");
        System.out.println("                                        --Adding football club to the premier league--");
        System.out.println("");

        while (true) {

            String clubNameInputAdd, clubLocationInputAdd;

            while (true) {

                Scanner sc = new Scanner(System.in);

                boolean exist = false;
                System.out.print("Enter name of the club: ");
                clubNameInputAdd = sc.nextLine();

                // check club name is already in the system
                for (FootballClub isExist: footballClubArr){

                    if (clubNameInputAdd.equals(isExist.getNameOfTheClub())){
                        exist = true;

                        System.out.println("Club is already exist");
                        System.out.println("");
                    }
                }
                if (!exist){

                    if (!(clubNameInputAdd.equals(""))) {

                        break;
                    }
                    else {

                        // If user doesn't enter a club name and press enter
                        System.out.println("Club name doesn't entered");
                        System.out.println("");
                    }
                }
            }

            while (true) {

                Scanner sc = new Scanner(System.in);

                System.out.print("Enter club location: ");
                clubLocationInputAdd = sc.nextLine();

                if (!(clubLocationInputAdd.equals(""))) {

                    break;
                } else {

                    // If user doesn't enter a club location and press enter
                    System.out.println("Club location doesn't entered");
                    System.out.println("");
                }
            }

            // add football club name and location to the football club object and initialise club statistics to 0
            FootballClub footballClubObj = new FootballClub(clubNameInputAdd, clubLocationInputAdd, 0, 0, 0,
                    0, 0, 0, 0);

            // add a football club object to football club array
            footballClubArr.add(footballClubObj);
            System.out.println(clubNameInputAdd + " is successfully added");

            System.out.println("");
            Scanner sc = new Scanner(System.in);
            System.out.print("If you want to quit(Y/N): ");
            String quit = sc.nextLine();
            System.out.println("");

            if (quit.equals("Y") || quit.equals("y")) {
                break;
            }
        }
        System.out.println("");
    }

    @Override
    // Delete an existing club from the premier league.
    public void deleteAClub() {

        System.out.println("");
        System.out.println("                                        --Deleting a football club from the premier league--");
        System.out.println("");

        while (true) {

            boolean isExit = false;

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the club name: ");
            String clubNameInputDelete = sc.nextLine();
            System.out.println("");

            // check football club name is exist in football club array
            for (int i = 0; i < footballClubArr.size(); i++) {

                if (footballClubArr.get(i).getNameOfTheClub().equals(clubNameInputDelete)) {

                    isExit = true;

                    footballClubArr.remove(i);
                    System.out.println(clubNameInputDelete + " club is removed");
                }
            }

            // if football club doesn't exist in football club array
            if (!isExit) {

                System.out.println("Club is not found");
                System.out.println("");
            }

            System.out.println("");
            System.out.print("If you want to quit(Y/N): ");
            String quit = sc.nextLine();
            System.out.println("");

            if (quit.equals("Y") || quit.equals("y")) {
                break;
            }
        }
        System.out.println("");
    }


    @Override
    // display statistics for selected club
    public void variousStatisticsForSelectedClub() {

        System.out.println("");
        System.out.println("                                        --Various statistics for a selected club--");
        System.out.println("");

        while (true) {

            boolean isExit = false;

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the club name: ");
            String searchClub = sc.nextLine();

            // check club name already exist in the football club array
            for (FootballClub searchFootballClub : footballClubArr) {

                if (searchClub.equals(searchFootballClub.getNameOfTheClub())) {

                    isExit = true;

                    System.out.println("");
                    System.out.println("wins: " + searchFootballClub.getWins());
                    System.out.println("draws: " + searchFootballClub.getDraws());
                    System.out.println("defeats: " + searchFootballClub.getDefeats());
                    System.out.println("number Of Goals Received: " + searchFootballClub.getNumberOfGoalsReceived());
                    System.out.println("number Of Goals Scored: " + searchFootballClub.getNumberOfGoalsScored());
                    System.out.println("number Of Points: " + searchFootballClub.getNumberOfPoints());
                    System.out.println("number Of Matches Played: " + searchFootballClub.getNumberOfMatchesPlayed());
                }
            }

            // club name doesn't exist in football club array
            if (!isExit) {

                System.out.println("Club is not found");
                System.out.println("");
            }

            System.out.println("");
            System.out.print("If you want to quit(Y/N): ");
            String quit = sc.nextLine();
            System.out.println("");

            if (quit.equals("Y") || quit.equals("y")) {
                break;
            }
        }
        System.out.println("");
    }

    @Override
    // add a played match
    public void addAPlayedMatch() {

        System.out.println("");
        System.out.println("                                        --Add a played match--");
        System.out.println("");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Played date(YYYY/MM/DD)");

        String year, month, day;
        // if day, month , year correctly entered, the user can go ahead
        do {

            System.out.print("Enter the year(YYYY): ");
            year = sc.nextLine();
            playedDate.setYear(year);
        }
        while (!playedDate.yearIsCorrect);

        do {

            System.out.print("Enter the month(MM): ");
            month = sc.nextLine();
            playedDate.setMonth(month);
        }
        while (!playedDate.monthIsCorrect);

        do {

            System.out.print("Enter the date(DD): ");
            day = sc.nextLine();
            playedDate.setDay(day);
        }
        while (!playedDate.dayIsCorrect);


        boolean club1Found = false, club2Found = false;
        Scanner input = new Scanner(System.in);
        boolean isExit1 = false;
        System.out.print("Enter club name1: ");
        String clubName1 = input.nextLine();
        String clubScore1;
        int intClubScore1 = 0;

        // check whether club name 1 is exist in football club array
        for (int i = 0; i < footballClubArr.size(); i++) {

            if (clubName1.equals(footballClubArr.get(i).getNameOfTheClub())) {
                isExit1 = true;
                club1Found = true;
                while (true) {

                    try {
                        input = new Scanner(System.in);
                        System.out.print("Enter " + clubName1 + " score: ");
                        clubScore1 = input.nextLine();
                        intClubScore1 = Integer.parseInt(clubScore1);

                        if (intClubScore1 >= 0) {
                            break;
                        } else {
                            System.out.println("Score is not in range");
                        }
                    } catch (Exception e1) {
                        System.out.println("Invalid score");
                    }
                }
            }
        }

        // if club name 1 doesn't exist
        if (!isExit1) {
            System.out.println("Club is not found");
        }

        System.out.println("");

        boolean isExit2 = false;
        System.out.print("Enter club name2: ");
        String clubName2 = input.nextLine();
        String clubScore2;
        int intClubScore2 = 0;

        // check whether club name 2 is exist in football club array
        for (int i = 0; i < footballClubArr.size(); i++) {

            if (clubName2.equals(footballClubArr.get(i).getNameOfTheClub())) {

                isExit2 = true;
                club2Found = true;

                while (true) {

                    try {
                        input = new Scanner(System.in);
                        System.out.print("Enter " + clubName2 + " score: ");
                        clubScore2 = input.nextLine();
                        intClubScore2 = Integer.parseInt(clubScore2);

                        if (intClubScore2 >= 0) {
                            break;
                        } else {
                            System.out.println("Score is not in range");
                        }

                    } catch (Exception e) {

                        System.out.println("Invalid score");
                    }
                }
            }
        }

        // if club name 1 doesn't exist
        if (!isExit2) {
            System.out.println("Club is not found");
        }

        // if club 1 and club 2 found only, match will add to the match array
        if (club1Found && club2Found) {

            // check if club 1 is exist
            for (FootballClub footballClub : footballClubArr) {

                if (clubName1.equals(footballClub.getNameOfTheClub())) {

                    // update existing information
                    if (intClubScore1 > intClubScore2) {
                        footballClub.setWins(footballClub.getWins() + 1);
                        footballClub.setNumberOfPoints(footballClub.getNumberOfPoints() + winingPoints);
                        footballClub.setNumberOfGoalsScored(footballClub.getNumberOfGoalsScored() + intClubScore1);
                        footballClub.setNumberOfGoalsReceived(footballClub.getNumberOfGoalsReceived() + intClubScore2);
                        footballClub.setNumberOfMatchesPlayed(footballClub.getNumberOfMatchesPlayed() + 1);

                    } else if (intClubScore2 > intClubScore1) {
                        footballClub.setDefeats(footballClub.getDefeats() + 1);
                        footballClub.setNumberOfGoalsScored(footballClub.getNumberOfGoalsScored() + intClubScore1);
                        footballClub.setNumberOfGoalsReceived(footballClub.getNumberOfGoalsReceived() + intClubScore2);
                        footballClub.setNumberOfMatchesPlayed(footballClub.getNumberOfMatchesPlayed() + 1);
                    } else {
                        footballClub.setDraws(footballClub.getDraws() + 1);
                        footballClub.setNumberOfPoints(footballClub.getNumberOfPoints() + drawPoints);
                        footballClub.setNumberOfGoalsScored(footballClub.getNumberOfGoalsScored() + intClubScore1);
                        footballClub.setNumberOfGoalsReceived(footballClub.getNumberOfGoalsReceived() + intClubScore2);
                        footballClub.setNumberOfMatchesPlayed(footballClub.getNumberOfMatchesPlayed() + 1);
                    }

                }

                // check if club 2 is exist
                if (clubName2.equals(footballClub.getNameOfTheClub())) {

                    // update existing information
                    if (intClubScore1 > intClubScore2) {
                        footballClub.setDefeats(footballClub.getDefeats() + 1);
                        footballClub.setNumberOfGoalsScored(footballClub.getNumberOfGoalsScored() + intClubScore2);
                        footballClub.setNumberOfGoalsReceived(footballClub.getNumberOfGoalsReceived() + intClubScore1);
                        footballClub.setNumberOfMatchesPlayed(footballClub.getNumberOfMatchesPlayed() + 1);

                    } else if (intClubScore2 > intClubScore1) {

                        footballClub.setWins(footballClub.getWins() + 1);
                        footballClub.setNumberOfPoints(footballClub.getNumberOfPoints() + winingPoints);
                        footballClub.setNumberOfGoalsScored(footballClub.getNumberOfGoalsScored() + intClubScore2);
                        footballClub.setNumberOfGoalsReceived(footballClub.getNumberOfGoalsReceived() + intClubScore1);
                        footballClub.setNumberOfMatchesPlayed(footballClub.getNumberOfMatchesPlayed() + 1);
                    } else {
                        footballClub.setDraws(footballClub.getDraws() + 1);
                        footballClub.setNumberOfPoints(footballClub.getNumberOfPoints() + drawPoints);
                        footballClub.setNumberOfGoalsScored(footballClub.getNumberOfGoalsScored() + intClubScore2);
                        footballClub.setNumberOfGoalsReceived(footballClub.getNumberOfGoalsReceived() + intClubScore1);
                        footballClub.setNumberOfMatchesPlayed(footballClub.getNumberOfMatchesPlayed() + 1);
                    }
                }
                System.out.println("");
            }

            // add above inputs to the match object
            matchObj = new Match(playedDate.getYear(), playedDate.getMonth(), playedDate.getDay(), clubName1, intClubScore1,
                    clubName2, intClubScore2);
            // add match object to match array
            matchArr.add(matchObj);

        }
    }

    @Override
    // display statistics of all the teams in football club array
    public void premierLeagueTable() {

        // sort according to points and goal difference
        Collections.sort(footballClubArr, FootballClub.pointComparator);

        String leftAlignFormat = "| %-25s |   %-3d   |   %-3d   |   %-3d    |      %-3d       |     %-3d      |  %-3d   |      %-3d       |%n";
        System.out.format("+---------------------------+---------+---------+----------+----------------+--------------+--------+----------------+%n");
        System.out.format("| Club name                 | wins    | Draws   | defeats  | Goals Received | Goals Scored | Points | Matches Played |%n");
        System.out.format("+---------------------------+---------+---------+----------+----------------+--------------+--------+----------------+%n");


        // add football club information one by one
         for (int i = 0; i < footballClubArr.size(); i++) {
            System.out.format(leftAlignFormat, footballClubArr.get(i).getNameOfTheClub(), footballClubArr.get(i).getWins(),
                    footballClubArr.get(i).getDraws(), footballClubArr.get(i).getDefeats(), footballClubArr.get(i).getNumberOfGoalsReceived(),
                    footballClubArr.get(i).getNumberOfGoalsScored(), footballClubArr.get(i).getNumberOfPoints(),
                    footballClubArr.get(i).getNumberOfMatchesPlayed());
        }
        System.out.format("+---------------------------+---------+---------+----------+----------------+--------------+--------+----------------+%n");

        System.out.println("");
    }

    @Override
    // read Football club information.txt
    public void readFile() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("Football club information.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<FootballClub> footballClubListRead = new ArrayList<>();

        while (true) {
            try {

                FootballClub readFootballClub = (FootballClub) objectInputStream.readObject();
                footballClubListRead.add(readFootballClub);

            } catch (IOException | ClassNotFoundException e) {
                break;
            }
        }
        footballClubArr.addAll(footballClubListRead);
    }


    @Override
    // write to Football club information.txt
    public void writeFile() throws IOException {

        File file = new File("Football club information.txt");

        PrintWriter writer = new PrintWriter("Football club information.txt");
        writer.print("");

        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        Iterator iterator = footballClubArr.iterator();
        while (iterator.hasNext()) {
            FootballClub newFootballClub = (FootballClub) iterator.next();
            objectOutputStream.writeObject(newFootballClub);

        }
        writer.close();
    }

    @Override
    // read Match information.txt
    public void readFile1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Match information.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Match> matchListRead = new ArrayList<>();

        while (true) {
            try {

                Match readMatch = (Match) objectInputStream.readObject();
                matchListRead.add(readMatch);

            } catch (IOException | ClassNotFoundException e) {
                break;
            }
        }
        matchArr.addAll(matchListRead);
    }

    @Override
    // write to Match information.txt
    public void writeFile1() throws IOException {
        File file = new File("Match information.txt");

        PrintWriter writer = new PrintWriter("Match information.txt");
        writer.print("");

        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        Iterator iterator = matchArr.iterator();
        while (iterator.hasNext()) {
            Match newMatch = (Match) iterator.next();
            objectOutputStream.writeObject(newMatch);

        }
        writer.close();
    }

    @Override
    // read Random Match information.txt
    public void readFile2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Random Match information.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Match> matchListRead = new ArrayList<>();

        while (true) {
            try {

                Match readMatch = (Match) objectInputStream.readObject();
                matchListRead.add(readMatch);

            } catch (IOException | ClassNotFoundException e) {
                break;
            }
        }
        randomMatchArr.addAll(matchListRead);
    }

    @Override
    // write to Random Match information.txt
    public void writeFile2() throws IOException {
        File file = new File("Random Match information.txt");

        PrintWriter writer = new PrintWriter("Random Match information.txt");
        writer.print("");

        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        Iterator iterator = randomMatchArr.iterator();
        while (iterator.hasNext()) {
            Match newMatch = (Match) iterator.next();
            objectOutputStream.writeObject(newMatch);

        }
        writer.close();
    }

    // testing
    public void searchDate() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Played date(YYYY/MM/DD)");

        boolean isExit = false;
        int year = 0, month = 0, day = 0;

        try {
            System.out.print("Enter the year(YYYY): ");
            year = sc.nextInt();

            System.out.print("Enter the month(MM): ");
            month = sc.nextInt();

            System.out.print("Enter the date(DD): ");
            day = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }

        for (Match findDate : matchArr) {

            if (year == (findDate.getYear()) && month == (findDate.getMonth()) && day == (findDate.getDay())) {
                isExit = true;

                System.out.println(findDate);
            }

        }
        if (!isExit) {
            System.out.println("No clubs are found");
        }

    }

    // testing
    public void matchesAccordingToDate() {

        Collections.sort(matchArr);
        for (Match sortDate : matchArr) {

            System.out.println(sortDate);
        }
    }

    //  sort wins and goals
    public void sortWinsAndGoalScored() {

        Collections.sort(footballClubArr, FootballClub.goalScoredComparator);

        for (FootballClub sortGoalScored : footballClubArr) {

            System.out.println(sortGoalScored);
        }
        System.out.println("");
        System.out.println("");
        Collections.sort(footballClubArr, FootballClub.winComparator);

        for (FootballClub sortWin : footballClubArr) {
            System.out.println(sortWin);

        }
    }


    public void randomPlay() {

        while (true) {

            Random random = new Random();
            // generate  2 random numbers between 0 and football club array current size
            FootballClub randomIndex1 = footballClubArr.get(random.nextInt(footballClubArr.size()));
//            System.out.println(randomIndex1);

            FootballClub randomIndex2 = footballClubArr.get(random.nextInt(footballClubArr.size()));

            // if randomly generated numbers are not equal then get those indexes form football club array
            if (randomIndex1 != randomIndex2) {

                String randomTeam1 = randomIndex1.getNameOfTheClub();
                String randomTeam2 = randomIndex2.getNameOfTheClub();

                // randomly generate 2 scores are between 0 and 25
                int randomScore1 = random.nextInt(25);
                int randomScore2 = random.nextInt(25);
//                System.out.println(randomScore1);
//                System.out.println(randomScore2);

                // get current date
                LocalDate localDate = LocalDate.now();

                int year = localDate.getYear();
                int month = localDate.getMonthValue();
                int day = localDate.getDayOfMonth();

                // add inputs to match object
                matchObj = new Match(year, month, day, randomTeam1, randomScore1, randomTeam2, randomScore2);
                // add match object to match array
                matchArr.add(matchObj);
                // add match object to random match array. To display specially randomly generated matches
                randomMatchArr.add(matchObj);
//                System.out.println(matchObj);
//                System.out.println(randomMatchArr);

                // updating existing match information
                for (FootballClub footballClub : footballClubArr) {

                    // update 1st club information
                    if (randomTeam1.equals(footballClub.getNameOfTheClub())) {

                        if (randomScore1 > randomScore2) {
                            footballClub.setWins(footballClub.getWins() + 1);
                            footballClub.setNumberOfPoints(footballClub.getNumberOfPoints() + winingPoints);
                            footballClub.setNumberOfGoalsScored(footballClub.getNumberOfGoalsScored() + randomScore1);
                            footballClub.setNumberOfGoalsReceived(footballClub.getNumberOfGoalsReceived() + randomScore2);
                            footballClub.setNumberOfMatchesPlayed(footballClub.getNumberOfMatchesPlayed() + 1);

                        } else if (randomScore2 > randomScore1) {
                            footballClub.setDefeats(footballClub.getDefeats() + 1);
                            footballClub.setNumberOfGoalsScored(footballClub.getNumberOfGoalsScored() + randomScore1);
                            footballClub.setNumberOfGoalsReceived(footballClub.getNumberOfGoalsReceived() + randomScore2);
                            footballClub.setNumberOfMatchesPlayed(footballClub.getNumberOfMatchesPlayed() + 1);
                        } else {
                            footballClub.setDraws(footballClub.getDraws() + 1);
                            footballClub.setNumberOfPoints(footballClub.getNumberOfPoints() + drawPoints);
                            footballClub.setNumberOfGoalsScored(footballClub.getNumberOfGoalsScored() + randomScore1);
                            footballClub.setNumberOfGoalsReceived(footballClub.getNumberOfGoalsReceived() + randomScore2);
                            footballClub.setNumberOfMatchesPlayed(footballClub.getNumberOfMatchesPlayed() + 1);
                        }

                    }
                    // update 2nd club information
                    if (randomTeam2.equals(footballClub.getNameOfTheClub())) {

                        if (randomScore1 > randomScore2) {
                            footballClub.setDefeats(footballClub.getDefeats() + 1);
                            footballClub.setNumberOfGoalsScored(footballClub.getNumberOfGoalsScored() + randomScore2);
                            footballClub.setNumberOfGoalsReceived(footballClub.getNumberOfGoalsReceived() + randomScore1);
                            footballClub.setNumberOfMatchesPlayed(footballClub.getNumberOfMatchesPlayed() + 1);

                        } else if (randomScore2 > randomScore1) {

                            footballClub.setWins(footballClub.getWins() + 1);
                            footballClub.setNumberOfPoints(footballClub.getNumberOfPoints() + winingPoints);
                            footballClub.setNumberOfGoalsScored(footballClub.getNumberOfGoalsScored() + randomScore2);
                            footballClub.setNumberOfGoalsReceived(footballClub.getNumberOfGoalsReceived() + randomScore1);
                            footballClub.setNumberOfMatchesPlayed(footballClub.getNumberOfMatchesPlayed() + 1);
                        } else {
                            footballClub.setDraws(footballClub.getDraws() + 1);
                            footballClub.setNumberOfPoints(footballClub.getNumberOfPoints() + drawPoints);
                            footballClub.setNumberOfGoalsScored(footballClub.getNumberOfGoalsScored() + randomScore2);
                            footballClub.setNumberOfGoalsReceived(footballClub.getNumberOfGoalsReceived() + randomScore1);
                            footballClub.setNumberOfMatchesPlayed(footballClub.getNumberOfMatchesPlayed() + 1);
                        }
                    }
                }
                break;
            }
        }
    }

    @Override
    public void gUI() throws FileNotFoundException {

        TableView table = new TableView();
        TableView table2 = new TableView();
        TableView table3 = new TableView();
        table4 = new TableView();

        Stage stage = new Stage();
        stage.setTitle("Premier League Championship");
        Label homeLabel = new Label("Premier League Championship");
//        homeLabel.setPrefHeight(50);
//        homeLabel.setPrefWidth(100);
        homeLabel.setLayoutX(100);
        homeLabel.setLayoutY(100);

        Button scene2Button = new Button("Get start");
        scene2Button.setStyle("-fx-background-color: Orange;-fx-text-fill: White;");
        scene2Button.setLayoutX(300);
        scene2Button.setLayoutY(350);
//        scene2Button.setPrefHeight(30);
//        scene2Button.setPrefWidth(120);

        // add a picture to home page
        FileInputStream input = new FileInputStream("318e9-15611111738749-800.jpg");
        javafx.scene.image.Image image = new Image(input);

        javafx.scene.image.ImageView imageView = new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setFitWidth(400);
        HBox hBoxImage = new HBox(imageView);

        Pane homePane = new Pane();
        homePane.getChildren().addAll(hBoxImage,homeLabel, scene2Button);
        Scene scene1 = new Scene(homePane, 400, 400);

        BorderPane scene2BP = new BorderPane();


        Button homeButton = new Button("Home");
        homeButton.setPrefWidth(120);
        homeButton.setStyle("-fx-background-color: Turquoise;-fx-text-fill: White;");
        homeButton.setOnAction(e -> stage.setScene(scene1));
        Button scoreBoardButton = new Button("Score Board");
        scoreBoardButton.setPrefWidth(120);
        scoreBoardButton.setStyle("-fx-background-color: Turquoise;-fx-text-fill: White;");
        Button randomMatchButton = new Button("Generate Match");
        randomMatchButton.setPrefWidth(120);
        randomMatchButton.setStyle("-fx-background-color: Turquoise;-fx-text-fill: White;");
        Button dateButton = new Button("Date");
        dateButton.setPrefWidth(120);
        dateButton.setStyle("-fx-background-color: Turquoise;-fx-text-fill: White;");
        Button dateSearchButton = new Button("Search match");
        dateSearchButton.setPrefWidth(120);
        dateSearchButton.setStyle("-fx-background-color: Turquoise;-fx-text-fill: White;");

        VBox navigation = new VBox();
        navigation.setSpacing(15);
        navigation.setLayoutX(20);
        navigation.setLayoutY(40);

        navigation.getChildren().addAll(homeButton, scoreBoardButton, randomMatchButton, dateButton, dateSearchButton);
        Pane navigationPane = new Pane();
        navigationPane.getChildren().add(navigation);


//        scene2BP.setLeft(navigationPane);
//        scoreBoardButton.setOnAction(e -> scene2BP.);
        // creating a table for display statistics of all clubs
        table.setEditable(true);

        TableColumn<FootballClub, String> clubName = new TableColumn<>("Club Name");
        clubName.setMinWidth(160);
        clubName.setCellValueFactory(new PropertyValueFactory<>("nameOfTheClub"));

        TableColumn<FootballClub, String> clubLocation = new TableColumn<>("Club Location");
        clubLocation.setMinWidth(150);
        clubLocation.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<FootballClub, Integer> wins = new TableColumn<>("Wins");
        wins.setMinWidth(80);
        wins.setCellValueFactory(new PropertyValueFactory<>("wins"));

        TableColumn<FootballClub, Integer> draws = new TableColumn<>("Draws");
        draws.setMinWidth(80);
        draws.setCellValueFactory(new PropertyValueFactory<>("draws"));

        TableColumn<FootballClub, Integer> defeats = new TableColumn<>("Defeats");
        defeats.setMinWidth(80);
        defeats.setCellValueFactory(new PropertyValueFactory<>("defeats"));

        TableColumn<FootballClub, Integer> goalsReceived = new TableColumn<>("Goals Received");
        goalsReceived.setMinWidth(120);
        goalsReceived.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsReceived"));

        TableColumn<FootballClub, Integer> goalsScored = new TableColumn<>("Goals Scored");
        goalsScored.setMinWidth(80);
        goalsScored.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsScored"));

        TableColumn<FootballClub, Integer> points = new TableColumn<>("Points");
        points.setMinWidth(80);
        points.setCellValueFactory(new PropertyValueFactory<>("numberOfPoints"));

        TableColumn<FootballClub, Integer> matchesPlayed = new TableColumn<>("Matches Played");
        matchesPlayed.setMinWidth(120);
        matchesPlayed.setCellValueFactory(new PropertyValueFactory<>("numberOfMatchesPlayed"));

        table.getColumns().addAll(clubName, clubLocation, wins, draws, defeats, goalsReceived, goalsScored, points, matchesPlayed);

        Button sortWin = new Button("Sort according to Wins");
        sortWin.setPrefWidth(200);
        sortWin.setStyle("-fx-background-color: MediumPurple;-fx-text-fill: White;");
        Button sortGoalScored = new Button("Sort according to Goal Scored");
        sortGoalScored.setPrefWidth(200);
        sortGoalScored.setStyle("-fx-background-color: MediumSlateBlue;-fx-text-fill: White;");

        sortWin.setOnAction(e -> {

            Collections.sort(footballClubArr, FootballClub.winComparator);
            table.setItems(getStatistics());
        });

        sortGoalScored.setOnAction(e -> {

            Collections.sort(footballClubArr, FootballClub.goalScoredComparator);
            table.setItems(getStatistics());
        });

        HBox sortHBox = new HBox();
        sortHBox.getChildren().addAll(sortWin,sortGoalScored);
        sortHBox.setPadding(new Insets(10, 0, 0, 50));
        sortHBox.setSpacing(20);

        HBox tableHBox = new HBox();
        tableHBox.getChildren().addAll(table);
        tableHBox.setPadding(new Insets(10, 0, 0, 50));
        tableHBox.setSpacing(20);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(70, 0, 0, 30));
        vbox.getChildren().addAll(sortHBox,tableHBox);
        Pane statisticPane = new Pane();
        statisticPane.getChildren().addAll(vbox);
        //        scoreBoardButton.setOnAction();
        scoreBoardButton.setOnAction(e -> {
            scene2BP.setCenter(statisticPane);
            // sort according to points and goal difference
            Collections.sort(footballClubArr, FootballClub.pointComparator);
            table.setItems(getStatistics());
            table.refresh();
        });

        // creating a table for display matches according to date
        table2.setEditable(true);

        TableColumn<Match, String> team1 = new TableColumn<>("Team 1");
        team1.setMinWidth(160);
        team1.setCellValueFactory(new PropertyValueFactory<>("team1"));

        TableColumn<Match, Integer> score1 = new TableColumn<>("Team 1 Score");
        score1.setMinWidth(100);
        score1.setCellValueFactory(new PropertyValueFactory<>("score1"));

        TableColumn<Match, String> team2 = new TableColumn<>("Team 2");
        team2.setMinWidth(160);
        team2.setCellValueFactory(new PropertyValueFactory<>("team2"));

        TableColumn<Match, Integer> score2 = new TableColumn<>("Team 2 Score");
        score2.setMinWidth(100);
        score2.setCellValueFactory(new PropertyValueFactory<>("score2"));

        TableColumn<Match, Integer> year = new TableColumn<>("Year");
        year.setMinWidth(50);
        year.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<Match, Integer> month = new TableColumn<>("Month");
        month.setMinWidth(50);
        month.setCellValueFactory(new PropertyValueFactory<>("month"));

        TableColumn<Match, Integer> day = new TableColumn<>("Day");
        day.setMinWidth(50);
        day.setCellValueFactory(new PropertyValueFactory<>("day"));


        table2.getColumns().addAll(year,month,day,team1,score1,team2,score2);

        VBox vbox1 = new VBox();
        vbox1.setPadding(new Insets(40, 0, 0, 110));
        vbox1.getChildren().add(table2);

        Pane datePane = new Pane();
        datePane.getChildren().add(vbox1);
        dateButton.setOnAction(e -> {
            table2.setItems(getDates());
            table2.refresh();
            scene2BP.setCenter(datePane);
        });

        // creating a table for display randomly generated matches
        table3.setEditable(true);

        TableColumn<Match, String> randomTeam1 = new TableColumn<>("Team 1");
        randomTeam1.setMinWidth(160);
        randomTeam1.setCellValueFactory(new PropertyValueFactory<>("team1"));

        TableColumn<Match, Integer> randomScore1 = new TableColumn<>("Team 1 Score");
        randomScore1.setMinWidth(100);
        randomScore1.setCellValueFactory(new PropertyValueFactory<>("score1"));

        TableColumn<Match, String> randomTeam2 = new TableColumn<>("Team 2");
        randomTeam2.setMinWidth(160);
        randomTeam2.setCellValueFactory(new PropertyValueFactory<>("team2"));

        TableColumn<Match, Integer> randomScore2 = new TableColumn<>("Team 2 Score");
        randomScore2.setMinWidth(100);
        randomScore2.setCellValueFactory(new PropertyValueFactory<>("score2"));

        TableColumn<Match, Integer> randomYear = new TableColumn<>("Year");
        randomYear.setMinWidth(50);
        randomYear.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<Match, Integer> randomMonth = new TableColumn<>("Month");
        randomMonth.setMinWidth(50);
        randomMonth.setCellValueFactory(new PropertyValueFactory<>("month"));

        TableColumn<Match, Integer> randomDay = new TableColumn<>("Day");
        randomDay.setMinWidth(50);
        randomDay.setCellValueFactory(new PropertyValueFactory<>("day"));

        Button generateMatch = new Button("Generate");
        generateMatch.setStyle("-fx-background-color: Indigo;-fx-text-fill: White;");
        generateMatch.setLayoutX(700);
        generateMatch.setLayoutY(50);
        generateMatch.setOnAction(e -> {
            randomPlay();

            table3.setItems(getRandomDates());

        });


        table3.getColumns().addAll(randomYear, randomMonth, randomDay, randomTeam1, randomScore1, randomTeam2, randomScore2);


        VBox vbox2 = new VBox();
        vbox2.setSpacing(15);
        vbox2.setPadding(new Insets(30, 0, 0, 110));
        vbox2.getChildren().addAll(generateMatch, table3);
        Pane randomDatePane = new Pane();
        randomDatePane.getChildren().add(vbox2);
        randomMatchButton.setOnAction(e -> {

            table3.setItems(getRandomDates());
            scene2BP.setCenter(randomDatePane);

        });


        // creating a table for display matches by search date
        table4.setEditable(true);

        TableColumn<Match, String> selectDateTeam1 = new TableColumn<>("Team 1");
        selectDateTeam1.setMinWidth(160);
        selectDateTeam1.setCellValueFactory(new PropertyValueFactory<>("team1"));

        TableColumn<Match, Integer> selectDateScore1 = new TableColumn<>("Team 1 Score");
        selectDateScore1.setMinWidth(100);
        selectDateScore1.setCellValueFactory(new PropertyValueFactory<>("score1"));

        TableColumn<Match, String> selectDateTeam2 = new TableColumn<>("Team 2");
        selectDateTeam2.setMinWidth(160);
        selectDateTeam2.setCellValueFactory(new PropertyValueFactory<>("team2"));

        TableColumn<Match, Integer> selectDateScore2 = new TableColumn<>("Team 2 Score");
        selectDateScore2.setMinWidth(100);
        selectDateScore2.setCellValueFactory(new PropertyValueFactory<>("score2"));



        table4.getColumns().addAll(selectDateTeam1, selectDateScore1, selectDateTeam2, selectDateScore2);

        yearTF = new TextField("               Year");
        yearTF.setOnMouseClicked(e -> yearTF.setText(""));
        monthTF = new TextField("               Month");
        monthTF.setOnMouseClicked(e -> monthTF.setText(""));
        dayTF = new TextField("                Day");
        dayTF.setOnMouseClicked(e -> dayTF.setText(""));
        Button search = new Button("Search");
        search.setStyle("-fx-background-color: DeepPink;-fx-text-fill: White;");
        search.setOnAction(event -> {

            table4.setItems(getSearch());
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(yearTF, monthTF, dayTF, search);
        hBox.setSpacing(25);
        hBox.setPadding(new Insets(30, 0, 0, 80));


        HBox hBox2 = new HBox();
        hBox2.setSpacing(15);
        hBox2.setPadding(new Insets(30, 50, 0, 110));
        hBox2.getChildren().addAll(table4);

        VBox vbox3 = new VBox();
        vbox3.setPadding(new Insets(0, 0, 0, 110));
        vbox3.getChildren().addAll(hBox,hBox2);

        Pane selectedDatePane = new Pane();
        selectedDatePane.getChildren().add(vbox3);
        dateSearchButton.setOnAction(e -> {
            scene2BP.setCenter(selectedDatePane);

        });


        Scene scene2 = new Scene(scene2BP, 1150, 500);
        scene2Button.setOnAction(e -> {

            stage.setScene(scene2);
            scene2BP.setLeft(navigationPane);
        });

        stage.setScene(scene1);
        stage.showAndWait();
    }

    // display statistics of all clubs
    public ObservableList<FootballClub> getStatistics() {

        ObservableList<FootballClub> statistics = FXCollections.observableArrayList();

        for (FootballClub statistic : footballClubArr) {

            statistics.add(new FootballClub(statistic.getNameOfTheClub(), statistic.getLocation(), statistic.getWins(),
                    statistic.getDraws(), statistic.getDefeats(), statistic.getNumberOfGoalsReceived(), statistic.getNumberOfGoalsScored(),
                    statistic.getNumberOfPoints(), statistic.getNumberOfMatchesPlayed()));
        }
        return statistics;
    }

    // display all matches according to date
    public ObservableList<Match> getDates() {

        ObservableList<Match> dates = FXCollections.observableArrayList();
        // sort match date
        Collections.sort(matchArr);
        for (Match date : matchArr) {
//            System.out.println(date.getDate().getYear());
            dates.add(new Match(date.getYear(), date.getMonth(), date.getDay(), date.getTeam1(),
                    date.getScore1(), date.getTeam2(), date.getScore2()));
        }
        return dates;
    }

    // display randomly played matches
    public ObservableList<Match> getRandomDates() {

        ObservableList<Match> randomDates = FXCollections.observableArrayList();

        for (Match date : randomMatchArr) {

            randomDates.add(new Match(date.getYear(), date.getMonth(), date.getDay(), date.getTeam1(),
                    date.getScore1(), date.getTeam2(), date.getScore2()));
        }
        return randomDates;
    }

    // search matches by given date
    public ObservableList<Match> getSearch() {

        ObservableList<Match> search = FXCollections.observableArrayList();

        for (Match findDate : matchArr) {

            // if day, month, year equal to existing played date then only will display
            if (Integer.parseInt(yearTF.getText()) == findDate.getYear() && Integer.parseInt(monthTF.getText()) == findDate.getMonth()
                    && Integer.parseInt(dayTF.getText()) == findDate.getDay()) {

                search.add(new Match(findDate.getYear(), findDate.getMonth(), findDate.getDay(), findDate.getTeam1(),
                        findDate.getScore1(), findDate.getTeam2(), findDate.getScore2()));
            }
        }
        return search;
    }


}

