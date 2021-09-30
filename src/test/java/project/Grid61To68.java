package project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Grid61To68 {

    public Server server = null;

    @BeforeEach
    //setup for 1st turn P1 plays {R11 R12 R13}, P2 {B11 B12 B13} and P3 {O11 O12 O13}
    void init(){

        server = new Server();
        server.distributeTilesToPlayers();

        Utils.fixHand(0, "R11", server);
        Utils.fixHand(0, "R12", server);
        Utils.fixHand(0, "R13", server);

        Utils.fixHand(1, "B11", server);
        Utils.fixHand(1, "B12", server);
        Utils.fixHand(1, "B13", server);

        Utils.fixHand(2, "O11", server);
        Utils.fixHand(2, "O12", server);
        Utils.fixHand(2, "O13", server);

        server.playAMeld("{R11 R12 R13}", 0);
        server.playAMeld("{B11 B12 B13}", 1);
        server.playAMeld("{O11 O12 O13}", 2);
    }

    @Test
    //start of turn 2: P1 then plays {G2 G3 G4} from hand
    void grid63(){

        List<String> checkMeld = null;

        Utils.fixHand(0, "G2", server);
        Utils.fixHand(0, "G3", server);
        Utils.fixHand(0, "G4", server);

        server.playAMeld("{G2 G3 G4}", 0);

        assertFalse(Utils.checkHand(0, "G2", server));
        assertFalse(Utils.checkHand(0, "G3", server));
        assertFalse(Utils.checkHand(0, "G4", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("G2", "G3", "G4")
        );
        assertTrue(Utils.checkTable(checkMeld, server));
    }

    @Test
    //start of turn 2: P1 then plays {G2 G3 G4} {O8 O9 O10} from hand
    void grid64(){

        List<String> checkMeld = null;

        Utils.fixHand(0, "G2", server);
        Utils.fixHand(0, "G3", server);
        Utils.fixHand(0, "G4", server);
        Utils.fixHand(0, "O8", server);
        Utils.fixHand(0, "O9", server);
        Utils.fixHand(0, "O10", server);

        server.playAMeld("{G2 G3 G4} {O8 O9 O10}", 0);

        assertFalse(Utils.checkHand(0, "G2", server));
        assertFalse(Utils.checkHand(0, "G3", server));
        assertFalse(Utils.checkHand(0, "G4", server));
        assertFalse(Utils.checkHand(0, "O8", server));
        assertFalse(Utils.checkHand(0, "O9", server));
        assertFalse(Utils.checkHand(0, "O10", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("G2", "G3", "G4")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("O8", "O9", "O10")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

    }

    @Test
    //start of turn 2: P1 then plays {G2 R2 O2} from hand
    void grid65(){

        List<String> checkMeld = null;

        Utils.fixHand(0, "G2", server);
        Utils.fixHand(0, "R2", server);
        Utils.fixHand(0, "O2", server);

        server.playAMeld("{G2 R2 O2}", 0);

        assertFalse(Utils.checkHand(0, "G2", server));
        assertFalse(Utils.checkHand(0, "R2", server));
        assertFalse(Utils.checkHand(0, "O2", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("G2", "R2", "O2")
        );
        assertTrue(Utils.checkTable(checkMeld, server));
    }


    @Test
    //start of turn 2: P1 then plays {G2 R2 O2} {O8 R8 B8 G8} from hand
    void grid66(){

        List<String> checkMeld = null;

        Utils.fixHand(0, "G2", server);
        Utils.fixHand(0, "R2", server);
        Utils.fixHand(0, "O2", server);
        Utils.fixHand(0, "O8", server);
        Utils.fixHand(0, "R8", server);
        Utils.fixHand(0, "B8", server);
        Utils.fixHand(0, "G8", server);

        server.playAMeld("{G2 R2 O2} {O8 R8 B8 G8}", 0);

        assertFalse(Utils.checkHand(0, "G2", server));
        assertFalse(Utils.checkHand(0, "R2", server));
        assertFalse(Utils.checkHand(0, "O2", server));
        assertFalse(Utils.checkHand(0, "O8", server));
        assertFalse(Utils.checkHand(0, "R8", server));
        assertFalse(Utils.checkHand(0, "B8", server));
        assertFalse(Utils.checkHand(0, "G8", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("G2", "R2", "O2")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("O8", "R8", "B8", "G8")
        );
        assertTrue(Utils.checkTable(checkMeld, server));
    }


    @Test
    //start of turn 2: P1 then plays {G2 R2 O2} {O8 O9 O10} from hand
    void grid67(){

        List<String> checkMeld = null;

        Utils.fixHand(0, "G2", server);
        Utils.fixHand(0, "R2", server);
        Utils.fixHand(0, "O2", server);
        Utils.fixHand(0, "O8", server);
        Utils.fixHand(0, "O9", server);
        Utils.fixHand(0, "O10", server);

        server.playAMeld("{G2 R2 O2} {O8 O9 O10}", 0);

        assertFalse(Utils.checkHand(0, "G2", server));
        assertFalse(Utils.checkHand(0, "R2", server));
        assertFalse(Utils.checkHand(0, "O2", server));
        assertFalse(Utils.checkHand(0, "O8", server));
        assertFalse(Utils.checkHand(0, "O9", server));
        assertFalse(Utils.checkHand(0, "O10", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("G2", "R2", "O2")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("O8", "O9", "O10")
        );
        assertTrue(Utils.checkTable(checkMeld, server));
    }


    @Test
    //start of turn 2: P1 then plays {G2 R2 O2}  {G3 R3 O3} {G8 G9 G10 G11 G12} from hand
    void grid68(){

        List<String> checkMeld = null;

        Utils.fixHand(0, "G2", server);
        Utils.fixHand(0, "R2", server);
        Utils.fixHand(0, "O2", server);
        Utils.fixHand(0, "G3", server);
        Utils.fixHand(0, "R3", server);
        Utils.fixHand(0, "O3", server);
        Utils.fixHand(0, "G8", server);
        Utils.fixHand(0, "G9", server);
        Utils.fixHand(0, "G10", server);
        Utils.fixHand(0, "G11", server);
        Utils.fixHand(0, "G12", server);

        server.playAMeld("{G2 R2 O2} {G3 R3 O3} {G8 G9 G10 G11 G12}", 0);

        assertFalse(Utils.checkHand(0, "G2", server));
        assertFalse(Utils.checkHand(0, "R2", server));
        assertFalse(Utils.checkHand(0, "O2", server));
        assertFalse(Utils.checkHand(0, "G3", server));
        assertFalse(Utils.checkHand(0, "R3", server));
        assertFalse(Utils.checkHand(0, "O3", server));
        assertFalse(Utils.checkHand(0, "G8", server));
        assertFalse(Utils.checkHand(0, "G9", server));
        assertFalse(Utils.checkHand(0, "G10", server));
        assertFalse(Utils.checkHand(0, "G11", server));
        assertFalse(Utils.checkHand(0, "G12", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("G2", "R2", "O2")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("G3", "R3", "O3")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        checkMeld = new ArrayList<>(
                Arrays.asList("G8", "G9", "G10", "G11", "G12")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

    }

}