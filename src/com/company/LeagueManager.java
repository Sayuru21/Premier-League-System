package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface LeagueManager {

    void addANewClub() throws IOException;
    void deleteAClub();
    void variousStatisticsForSelectedClub();
    void addAPlayedMatch();
    void premierLeagueTable();
    void readFile() throws IOException;
    void writeFile() throws IOException;
    void readFile1() throws IOException;
    void writeFile1() throws IOException;
    void readFile2() throws IOException;
    void writeFile2() throws IOException;
    void gUI() throws FileNotFoundException;
}
