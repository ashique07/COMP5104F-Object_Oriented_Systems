package parameterizedTestCases;

import io.cucumber.java.bs.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import project.Server;
import project.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitParameterizedTestCases {

    //List<String> checkMeld = new ArrayList<>();
    Server server = null;

    //Grid Line Numbers 10 to 172
    @ParameterizedTest
    @CsvSource({
            "{R9 O9 B9}, false",
            "{B11 O11 R11}, true",
            "{B9 O9 G9 R9}, true",
            "{R9 R10 R11}, false",
            "{R11 R12 R13}, true",
            "{G8 G9 G10 G11}, true",
            "{R1 O1 B1} {R2 R3 R4} {R3 O3 B3} {G1 G2 G3}, false",
            "{R1 O1 B1} {R2 R3 R4} {R3 O3 B3} {G2 G3 G4}, true",
            "{R11 O11 B11} {R2 R3 R4} {R3 O3 B3} {G2 G3 G4}, true",
            "{R1 O1 B1} {R2 O2 B2} {R3 O3 B3}, false",
            "{R1 R2 R3} {G2 G3 G4} {O2 O3 O4}, false",
            "{B6 G6 R6} {B1 R1 O1} {B3 R3 O3}, true",
            "{B1 B2 B3} {G2 G3 G4} {R4 R5 R6}, true",
            "{B7 G7 R7} {B1 R1 O1} {B3 R3 O3}, true",
            "{B11 B12 B13} {G2 G3 G4} {R4 R5 R6}, true",
            "{R9 O9 *}, false",
            "{B11 * R11}, true",
            "{* O9 G9 R9}, true",
            "{* R10 R11}, false",
            "{R11 * R13}, true",
            "{G8 G9 G10 *}, true",
            "{O9 * *}, false",
            "{B11 * *}, true",
            "{* O9 * R9}, true",
            "{R9 R10 * *}, true",
            "{R1 O1 B1} {R2 R3 R4} {R3 * B3} {G2 G3 G4}, true",
            "{R1 O1 B1} {R2 R3 R4} {R3 * B3} {G2 G3 *}, true"
    })
    public void initial30Points(String meld, boolean output)
    {
        server = new Server();
        server.distributeTilesToPlayers();

        String tilesString = "";

        for(int i = 0; i < meld.length(); i++)
        {
            //Ignoring { and }
            if(meld.charAt(i) == '{' || meld.charAt(i) == '}')
                continue;

            tilesString += String.valueOf(meld.charAt(i));
        }

        String [] tiles = tilesString.split(" ");

        for(String tile: tiles)
        {
            Utils.fixHand(0, tile, server);
        }

        server.playAMeld(meld, 0);

        if(output)
        {
            //The Tiles are not in hand
            for(String tile: tiles)
            {
                assertFalse(Utils.checkHand(0, tile, server));
            }

            //The melds are in table
            for(int i = 0; i < meld.length(); i++) {
                if(meld.charAt(i) == '{'){

                    List<String> checkMeld = new ArrayList<>();

                    int j = i+1;
                    String tempMeldString = "";

                    while(meld.charAt(j) != '}'){
                        tempMeldString += String.valueOf(meld.charAt(j));
                        j++;
                    }

                    String [] tempMeldArray = tempMeldString.split(" ");
                    for(String tile: tempMeldArray){
                        checkMeld.add(tile);
                    }
                    assertTrue(Utils.checkTable(checkMeld, server));
                    i = j+1;

                }
            }

            //Player 0 achieved initial 30 points
            assertTrue(server.initial30Points[0]);
            assertEquals("hand and table updated", server.initial30PointsOutput);
        }
        else
        {
            //Player 0 did not achieve initial 30 points
            assertFalse(server.initial30Points[0]);
            assertEquals("insufficient total for initial tiles", server.initial30PointsOutput);
        }

    }


    //Grid Line Numbers 174 to 191 and 224 to 319
    @ParameterizedTest
    @CsvSource({
            "{B11 O11 R11}, true",
            "{B11 B12 B13}, true",
            "{B11 B12 B13} {O1 G1 R1} {O4 G4 R4}, true",
            "{R1 R2}, false",
            "{R1 B2}, false",
            "{B1 B1 R1}, false",
            "{B1 B1 B2 B3}, false",
            "{B7 B8 B8 B9}, false",
            "{B6 B7 B8 B8}, false",
            "{* * R1}, true",
            "{* * B2 B3}, true",
            "{R1 B2 R3}, false",
            "{R1 B2 O3}, false",
            "{B2 B1 B3}, false",
            "{B1 B3 B4}, false",
            "{B4 B5 O4}, false",
            "{B4 B5 O5}, false"
    })
    public void playMelds(String meld, boolean valid){

        server = new Server();
        server.distributeTilesToPlayers();

        Utils.fixHand(0, "R11", server);
        Utils.fixHand(0, "O11", server);
        Utils.fixHand(0, "G11", server);

        //Achieving initial 30 points
        server.playAMeld("{R11 O11 G11}", 0);

        String tilesString = "";

        for(int i = 0; i < meld.length(); i++)
        {
            //Ignoring { and }
            if(meld.charAt(i) == '{' || meld.charAt(i) == '}')
                continue;

            tilesString += String.valueOf(meld.charAt(i));
        }

        String [] tiles = tilesString.split(" ");

        for(String tile: tiles)
        {
            Utils.fixHand(0, tile, server);
        }

        server.playAMeld(meld, 0);

        if(valid)
        {

            //1. The melds are all valid
            assertTrue(server.meldValidity);

            //2. The Tiles are not in hand
            for (String tile : tiles) {
                assertFalse(Utils.checkHand(0, tile, server));
            }

            //3. The melds are in table
            for (int i = 0; i < meld.length(); i++) {
                if (meld.charAt(i) == '{') {

                    List<String> checkMeld = new ArrayList<>();

                    int j = i + 1;
                    String tempMeldString = "";

                    while (meld.charAt(j) != '}') {
                        tempMeldString += String.valueOf(meld.charAt(j));
                        j++;
                    }

                    String[] tempMeldArray = tempMeldString.split(" ");
                    for (String tile : tempMeldArray) {
                        checkMeld.add(tile);
                    }
                    assertTrue(Utils.checkTable(checkMeld, server));
                    i = j + 1;

                }
            }
        }
        else
        {
            //The melds are invalid
            assertFalse(server.meldValidity);
        }

    }

    ////Grid Line Numbers 193 to 222
    @ParameterizedTest
    @CsvSource({"1", "2", "3", "4"})
    public void drawATile(int setup){

        Server server = new Server();

        switch (setup){

            case 1: {
                String handOfP0 = "G2 G2 O2 R3 B3 B3 R5 B6 O7 R9 R10 G11 B12 B13";
                String[] arrayOfTiles = handOfP0.split(" ");

                for (int i = 0; i < arrayOfTiles.length; i++) {
                    String tile = arrayOfTiles[i];

                    server.player0Hand.add(server.stock.remove(server.stock.indexOf(tile)));
                }

                server.takeATile(0);
                //Check if number of tiles in hand of player 0 is 15
                assertEquals(15, server.player0Hand.size());

                break;
            }

            case 2: {
                String handOfP0 = "G2 G2 O2 R3 B3 B3 R5 B6 O7 R9 R10 B11 B12 B13";
                String[] arrayOfTiles = handOfP0.split(" ");

                for (int i = 0; i < arrayOfTiles.length; i++) {
                    String tile = arrayOfTiles[i];

                    server.player0Hand.add(server.stock.remove(server.stock.indexOf(tile)));
                }

                server.playAMeld("{B11 B12 B13}", 0);

                server.takeATile(0);
                //Check if number of tiles in hand of player 0 is 12
                assertEquals(12, server.player0Hand.size());

                break;
            }

            case 3: {

                String handOfP0 = "G2 G2 O2 R3 B3 B3 R5 B6 O7 R9 R10 B11 B12 B13";
                String[] arrayOfTiles = handOfP0.split(" ");

                for (int i = 0; i < arrayOfTiles.length; i++) {
                    String tile = arrayOfTiles[i];

                    server.player0Hand.add(server.stock.remove(server.stock.indexOf(tile)));
                }

                server.takeATile(0);
                //Check if number of tiles in hand of player 0 is 15
                assertEquals(15, server.player0Hand.size());

                break;
            }

            case 4: {
                String handOfP0 = "R2 G2 O2 R3 B3 B3 R5 B6 O7 R9 R10 B11 B12 B13";
                String[] arrayOfTiles = handOfP0.split(" ");

                for (int i = 0; i < arrayOfTiles.length; i++) {
                    String tile = arrayOfTiles[i];

                    server.player0Hand.add(server.stock.remove(server.stock.indexOf(tile)));
                }

                server.playAMeld("{B11 B12 B13}", 0);

                server.takeATile(0);
                //Check if number of tiles in hand of player 0 is 12
                assertEquals(12, server.player0Hand.size());

                break;
            }
        }
    }

    @ParameterizedTest
    @CsvSource({
            "R3 R4 R5, R7 R8, false",
            "R3 R4 R5, R1, false",
            "R3 R4 R5, R3, false",
            "R3 R4 R5, R2, true",
            "R3 R4 R5, R1 R2, true",
            "R1 G1 B1, O2, false",
            "R1 G1 B1, R1 O1, false",
            "R1 G1 B1, O1, true",
            "R3 R4 R5, *, true",
            "R3 R4 R5, * *, true",
            "R1 G1 B1 O1, *, false",
            "R1 G1 B1, *, true"
    })
    public void tableReuse(String initialTableMeld, String tiles, boolean valid)
    {
        server = new Server();
        server.distributeTilesToPlayers();

        Utils.fixHand(0, "R11", server);
        Utils.fixHand(0, "O11", server);
        Utils.fixHand(0, "G11", server);

        //Achieving initial 30 points using R11 O11 G11
        //R11 O11 G11 is in position 0 of table
        server.playAMeld("{R11 O11 G11}", 0);

        String initialTableMeldArray [] = initialTableMeld.split(" ");

        //R3 R4 R5 is in position 1 of table
        Utils.fixTable(new ArrayList<>(Arrays.asList(initialTableMeldArray)), server);

        String tilesArray[] = tiles.split(" ");

        List<String> oldMeld = server.addTilesFromHandToTableMelds(tilesArray, 1, 0);

        //newMeld has all the initial tiles
        for(String tile: initialTableMeldArray)
            assertTrue(server.table.get(1).contains(tile));

        if(valid)
        {
            //Number of tiles added is newMeld.size() - oldMeld.size()
            assertTrue(tilesArray.length == (server.table.get(1).size() - oldMeld.size()));

            //newMeld has all the new tiles
            for(String tile: tilesArray)
                assertTrue(server.table.get(1).contains(tile));
        }
        else
        {
            //oldMeld is exactly equal to the newMeld
            for(int i = 0; i < server.table.get(1).size(); i++)
            {
                assertTrue(oldMeld.get(i).equals(server.table.get(1).get(i)));
            }
        }
    }



    @ParameterizedTest
    @CsvSource({"1", "2"})
    public void winnerAndScore(int setup)
    {
        Server server = new Server();

        for(int i = 0; i < server.initial30Points.length; i++)
        {
            server.initial30Points[i] = true;
        }

        if(setup == 1)
        {
            server.player0Hand = new ArrayList<>(Arrays.asList("R1", "G1", "B1"));
            server.player1Hand = new ArrayList<>(Arrays.asList("O2", "O3", "O4"));
            server.player2Hand = new ArrayList<>(Arrays.asList("R4", "B6", "G9", "O13"));

            server.playAMeld("{R1 G1 B1}", 0);

            server.calculatePlayersFinalScore();

            assertEquals(0, server.winner);
            assertEquals(0, server.player0Score);
            assertEquals(9, server.player1Score);
            assertEquals(32, server.player2Score);
        }

    }

}