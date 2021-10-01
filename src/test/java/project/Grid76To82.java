package project;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Grid76To82 {

    @Test
    //P1 starts with  G1 G2 O2 R3 B3 B3 R5 B6 O7 R9 R10 B11 B12 B13
    //P2 starts with {R2 B2 G2 O2} {G3 G4 G6 G7} {O4 O5 O6 O7 O8 O9}
    //P3 starts with R4 O6 B6 B7 R7 G8 {R10 R11 R12 R13} {B10 B11 B12 B13}
    //P1 draws R2, P2 chooses to draw and draws G5 and P3 plays  {R10 R11 R12 R13} {B10 B11 B12 B13}
    //P1 plays {G2 O2 R2} {B11 B12 B13},  P2 plays and wins
    //scores (visible by all players) are P1:-47, P2: 0 and P3:-38
    void grid76To82()
    {
        Server server = new Server();
        List<String> checkMeld = null;

        String handOfP0 = "G1 G2 O2 R3 B3 B3 R5 B6 O7 R9 R10 B11 B12 B13";
        Scanner sc0 = new Scanner(handOfP0);
        while (sc0.hasNext())
        {
            String tile = sc0.next();
            server.player0Hand.add(server.stock.remove(server.stock.indexOf(tile)));
        }

        String handOfP1 = "R2 B2 G2 O2 G3 G4 G6 G7 O4 O5 O6 O7 O8 O9";
        Scanner sc1 = new Scanner(handOfP1);
        while (sc1.hasNext())
        {
            String tile = sc1.next();
            server.player1Hand.add(server.stock.remove(server.stock.indexOf(tile)));
        }

        String handOfP2 = "R4 O6 B6 B7 R7 G8 R10 R11 R12 R13 B10 B11 B12 B13";
        Scanner sc2 = new Scanner(handOfP2);
        while (sc2.hasNext())
        {
            String tile = sc2.next();
            server.player2Hand.add(server.stock.remove(server.stock.indexOf(tile)));
        }

        //P1 draws R2
        server.player0Hand.add(server.stock.remove(server.stock.indexOf("R2")));

        //P2 draws G5
        server.player1Hand.add(server.stock.remove(server.stock.indexOf("G5")));

        //P3 plays  {R10 R11 R12 R13} {B10 B11 B12 B13}
        server.playAMeld("{R10 R11 R12 R13} {B10 B11 B12 B13}", 2);
        assertFalse(Utils.checkHand(2, "R10", server));
        assertFalse(Utils.checkHand(2, "R11", server));
        assertFalse(Utils.checkHand(2, "R12", server));
        assertFalse(Utils.checkHand(2, "R13", server));
        assertFalse(Utils.checkHand(2, "B10", server));
        assertFalse(Utils.checkHand(2, "B11", server));
        assertFalse(Utils.checkHand(2, "B12", server));
        assertFalse(Utils.checkHand(2, "B13", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R10", "R11", "R12", "R13")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("B10", "B11", "B12", "B13")
        );
        assertTrue(Utils.checkTable(checkMeld, server));


        //P1 plays {G2 O2 R2} {B11 B12 B13}
        server.playAMeld("{G2 O2 R2} {B11 B12 B13}", 0);
        assertFalse(Utils.checkHand(0, "G2", server));
        assertFalse(Utils.checkHand(0, "O2", server));
        assertFalse(Utils.checkHand(0, "R2", server));
        assertFalse(Utils.checkHand(0, "B11", server));
        assertFalse(Utils.checkHand(0, "B12", server));
        assertFalse(Utils.checkHand(0, "B13", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("G2", "O2", "R2")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("B11", "B12", "B13")
        );
        assertTrue(Utils.checkTable(checkMeld, server));


        //P2 plays and wins
        server.playAMeld("{R2 B2 G2 O2} {G3 G4 G5 G6 G7} {O4 O5 O6 O7 O8 O9}", 1);
        assertFalse(Utils.checkHand(1, "R2", server));
        assertFalse(Utils.checkHand(1, "B2", server));
        assertFalse(Utils.checkHand(1, "G2", server));
        assertFalse(Utils.checkHand(1, "O2", server));
        assertFalse(Utils.checkHand(1, "G3", server));
        assertFalse(Utils.checkHand(1, "G4", server));
        assertFalse(Utils.checkHand(1, "G5", server));
        assertFalse(Utils.checkHand(1, "G6", server));
        assertFalse(Utils.checkHand(1, "G7", server));
        assertFalse(Utils.checkHand(1, "O4", server));
        assertFalse(Utils.checkHand(1, "O5", server));
        assertFalse(Utils.checkHand(1, "O6", server));
        assertFalse(Utils.checkHand(1, "O7", server));
        assertFalse(Utils.checkHand(1, "O8", server));
        assertFalse(Utils.checkHand(1, "O9", server));



        checkMeld = new ArrayList<>(
                Arrays.asList("R2", "B2", "G2", "O2")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("G3", "G4", "G5", "G6", "G7")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("O4", "O5", "O6", "O7", "O8", "O9")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

    }
}