package project;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Grid50To59 {

    @Test
    //P1 plays {R11 R12 R13}
    void grid51()
    {
        Server server = new Server();
        List<String> checkMeld = null;
        server.distributeTilesToPlayers();

        Utils.fixHand(0, "R11", server);
        Utils.fixHand(0, "R12", server);
        Utils.fixHand(0, "R13", server);

        server.playAMeld("{R11 R12 R13}", 0);

        assertFalse(Utils.checkHand(0, "R11", server));
        assertFalse(Utils.checkHand(0, "R12", server));
        assertFalse(Utils.checkHand(0, "R13", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R11", "R12", "R13")
        );
        assertTrue(Utils.checkTable(checkMeld, server));
    }

    @Test
    //P1 plays {R12 G12 B12}
    void grid52()
    {
        Server server = new Server();
        List<String> checkMeld = null;
        server.distributeTilesToPlayers();

        Utils.fixHand(0, "R12", server);
        Utils.fixHand(0, "G12", server);
        Utils.fixHand(0, "B12", server);

        server.playAMeld("{R12 G12 B12}", 0);

        assertFalse(Utils.checkHand(0, "R12", server));
        assertFalse(Utils.checkHand(0, "G12", server));
        assertFalse(Utils.checkHand(0, "B12", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R12", "G12", "B12")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

    }

    @Test
    //P1 plays {R9 R10 R11 R12 R13}
    void grid53()
    {
        Server server = new Server();
        List<String> checkMeld = null;
        server.distributeTilesToPlayers();

        Utils.fixHand(0, "R9", server);
        Utils.fixHand(0, "R10", server);
        Utils.fixHand(0, "R11", server);
        Utils.fixHand(0, "R12", server);
        Utils.fixHand(0, "R13", server);

        server.playAMeld("{R9 R10 R11 R12 R13}", 0);

        assertFalse(Utils.checkHand(0, "R9", server));
        assertFalse(Utils.checkHand(0, "R10", server));
        assertFalse(Utils.checkHand(0, "R11", server));
        assertFalse(Utils.checkHand(0, "R12", server));
        assertFalse(Utils.checkHand(0, "R13", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R9", "R10", "R11", "R12", "R13")
        );
        assertTrue(Utils.checkTable(checkMeld, server));
    }


    @Test
    //P1 plays {R13 G13 B13 O13}
    void grid54()
    {
        Server server = new Server();
        List<String> checkMeld = null;
        server.distributeTilesToPlayers();

        Utils.fixHand(0, "R13", server);
        Utils.fixHand(0, "G13", server);
        Utils.fixHand(0, "B13", server);
        Utils.fixHand(0, "O13", server);

        server.playAMeld("{R13 G13 B13 O13}", 0);

        assertFalse(Utils.checkHand(0, "R13", server));
        assertFalse(Utils.checkHand(0, "G13", server));
        assertFalse(Utils.checkHand(0, "B13", server));
        assertFalse(Utils.checkHand(0, "O13", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R13", "G13", "B13", "O13")
        );
        assertTrue(Utils.checkTable(checkMeld, server));
    }


    @Test
    //P1 plays {R2 R3 R4} {B7 B8 B9}
    void grid55()
    {
        Server server = new Server();
        List<String> checkMeld = null;
        server.distributeTilesToPlayers();

        Utils.fixHand(0, "R2", server);
        Utils.fixHand(0, "R3", server);
        Utils.fixHand(0, "R4", server);
        Utils.fixHand(0, "B7", server);
        Utils.fixHand(0, "B8", server);
        Utils.fixHand(0, "B9", server);

        server.playAMeld("{R2 R3 R4} {B7 B8 B9}", 0);

        assertFalse(Utils.checkHand(0, "R2", server));
        assertFalse(Utils.checkHand(0, "R3", server));
        assertFalse(Utils.checkHand(0, "R4", server));
        assertFalse(Utils.checkHand(0, "B7", server));
        assertFalse(Utils.checkHand(0, "B8", server));
        assertFalse(Utils.checkHand(0, "B9", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R2", "R3", "R4")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("B7", "B8", "B9")
        );
        assertTrue(Utils.checkTable(checkMeld, server));
    }


    @Test
    //P1 plays {R2 B2 O2} {G4 O4 B4 R4} {O5 B5 R5}
    void grid56()
    {
        Server server = new Server();
        List<String> checkMeld = null;
        server.distributeTilesToPlayers();

        Utils.fixHand(0, "R2", server);
        Utils.fixHand(0, "B2", server);
        Utils.fixHand(0, "O2", server);
        Utils.fixHand(0, "G4", server);
        Utils.fixHand(0, "O4", server);
        Utils.fixHand(0, "B4", server);
        Utils.fixHand(0, "R4", server);
        Utils.fixHand(0, "O5", server);
        Utils.fixHand(0, "B5", server);
        Utils.fixHand(0, "R5", server);

        server.playAMeld("{R2 B2 O2} {G4 O4 B4 R4} {O5 B5 R5}", 0);

        assertFalse(Utils.checkHand(0, "R2", server));
        assertFalse(Utils.checkHand(0, "B2", server));
        assertFalse(Utils.checkHand(0, "O2", server));
        assertFalse(Utils.checkHand(0, "G4", server));
        assertFalse(Utils.checkHand(0, "O4", server));
        assertFalse(Utils.checkHand(0, "B4", server));
        assertFalse(Utils.checkHand(0, "R4", server));
        assertFalse(Utils.checkHand(0, "O5", server));
        assertFalse(Utils.checkHand(0, "B5", server));
        assertFalse(Utils.checkHand(0, "R5", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R2", "B2", "O2")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("G4", "O4", "B4", "R4")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("O5", "B5", "R5")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

    }


    @Test
    //P1 plays {R8 G8 O8} {R2 R3 R4}
    void grid57()
    {
        Server server = new Server();
        List<String> checkMeld = null;
        server.distributeTilesToPlayers();

        Utils.fixHand(0, "R8", server);
        Utils.fixHand(0, "G8", server);
        Utils.fixHand(0, "O8", server);
        Utils.fixHand(0, "R2", server);
        Utils.fixHand(0, "R3", server);
        Utils.fixHand(0, "R4", server);

        server.playAMeld("{R8 G8 O8} {R2 R3 R4}", 0);

        assertFalse(Utils.checkHand(0, "R8", server));
        assertFalse(Utils.checkHand(0, "G8", server));
        assertFalse(Utils.checkHand(0, "O8", server));
        assertFalse(Utils.checkHand(0, "R2", server));
        assertFalse(Utils.checkHand(0, "R3", server));
        assertFalse(Utils.checkHand(0, "R4", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R8", "G8", "O8")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R2", "R3", "R4")
        );
        assertTrue(Utils.checkTable(checkMeld, server));
    }


    @Test
    //P1 plays {R2 O2 B2} {G2 G3 G4} {R3 B3 O3} {B5 B6 B7}
    void grid58()
    {
        Server server = new Server();
        List<String> checkMeld = null;
        server.distributeTilesToPlayers();

        Utils.fixHand(0, "R2", server);
        Utils.fixHand(0, "O2", server);
        Utils.fixHand(0, "B2", server);
        Utils.fixHand(0, "G2", server);
        Utils.fixHand(0, "G3", server);
        Utils.fixHand(0, "G4", server);
        Utils.fixHand(0, "R3", server);
        Utils.fixHand(0, "B3", server);
        Utils.fixHand(0, "O3", server);
        Utils.fixHand(0, "B5", server);
        Utils.fixHand(0, "B6", server);
        Utils.fixHand(0, "B7", server);

        server.playAMeld("{R2 O2 B2} {G2 G3 G4} {R3 B3 O3} {B5 B6 B7}", 0);

        assertFalse(Utils.checkHand(0, "R2", server));
        assertFalse(Utils.checkHand(0, "O2", server));
        assertFalse(Utils.checkHand(0, "B2", server));
        assertFalse(Utils.checkHand(0, "G2", server));
        assertFalse(Utils.checkHand(0, "G3", server));
        assertFalse(Utils.checkHand(0, "G4", server));
        assertFalse(Utils.checkHand(0, "R3", server));
        assertFalse(Utils.checkHand(0, "B3", server));
        assertFalse(Utils.checkHand(0, "O3", server));
        assertFalse(Utils.checkHand(0, "B5", server));
        assertFalse(Utils.checkHand(0, "B6", server));
        assertFalse(Utils.checkHand(0, "B7", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R2", "O2", "B2")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("G2", "G3", "G4")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R3", "B3", "O3")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("B5", "B6", "B7")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

    }


    @Test
    //P1 plays {R2 B2 G2 O2} {G3 G4 G5 G6 G7} {O4 O5 O6 O7 O8}
    void grid59()
    {
        Server server = new Server();
        List<String> checkMeld = null;
        server.distributeTilesToPlayers();

        Utils.fixHand(0, "R2", server);
        Utils.fixHand(0, "B2", server);
        Utils.fixHand(0, "G2", server);
        Utils.fixHand(0, "O2", server);
        Utils.fixHand(0, "G3", server);
        Utils.fixHand(0, "G4", server);
        Utils.fixHand(0, "G5", server);
        Utils.fixHand(0, "G6", server);
        Utils.fixHand(0, "G7", server);
        Utils.fixHand(0, "O4", server);
        Utils.fixHand(0, "O5", server);
        Utils.fixHand(0, "O6", server);
        Utils.fixHand(0, "O7", server);
        Utils.fixHand(0, "O8", server);

        server.playAMeld("{R2 B2 G2 O2} {G3 G4 G5 G6 G7} {O4 O5 O6 O7 O8}", 0);

        assertFalse(Utils.checkHand(0, "R2", server));
        assertFalse(Utils.checkHand(0, "B2", server));
        assertFalse(Utils.checkHand(0, "G2", server));
        assertFalse(Utils.checkHand(0, "O2", server));
        assertFalse(Utils.checkHand(0, "G3", server));
        assertFalse(Utils.checkHand(0, "G4", server));
        assertFalse(Utils.checkHand(0, "G5", server));
        assertFalse(Utils.checkHand(0, "G6", server));
        assertFalse(Utils.checkHand(0, "G7", server));
        assertFalse(Utils.checkHand(0, "O4", server));
        assertFalse(Utils.checkHand(0, "O5", server));
        assertFalse(Utils.checkHand(0, "O6", server));
        assertFalse(Utils.checkHand(0, "O7", server));
        assertFalse(Utils.checkHand(0, "O8", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R2", "B2", "G2", "O2")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("G3", "G4", "G5", "G6", "G7")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("O4", "O5", "O6", "O7", "O8")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

    }

}