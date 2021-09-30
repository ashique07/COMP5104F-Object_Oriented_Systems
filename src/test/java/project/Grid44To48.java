package project;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Grid44To48 {
    
    @Test
    void grid45() {

        Server server = new Server();
        List<String> checkMeld = null;
        server.distributeTilesToPlayers();
        /*
        server.startServer();

        Client p1 = new Client(Config.HOST, Config.PORT_NUMBER);
        p1.startClient();

        Client p2 = new Client(Config.HOST, Config.PORT_NUMBER);
        p2.startClient();

        Client p3 = new Client(Config.HOST, Config.PORT_NUMBER);
        p3.startClient();
        */

        Utils.fixHand(1, "R11", server);
        Utils.fixHand(1, "R12", server);
        Utils.fixHand(1, "R13", server);

        Utils.fixHand(2, "R13", server);
        Utils.fixHand(2, "B13", server);
        Utils.fixHand(2, "G13", server);

        Utils.fixHand(2, "G2", server);
        Utils.fixHand(2, "R2", server);
        Utils.fixHand(2, "O2", server);

        Utils.fixHand(0, "R12", server);
        Utils.fixHand(0, "B12", server);
        Utils.fixHand(0, "O12", server);

        //P1 plays first and draws: all players still see the table empty
        server.takeATile(0);


        //after P1 it is P2 who plays {R11 R12 R13}:
        //this meld is on the table and seen by all players and hand of P2 is updated
        server.playAMeld("{R11 R12 R13}", 1);

        assertFalse(Utils.checkHand(1, "R11", server));
        assertFalse(Utils.checkHand(1, "R12", server));
        assertFalse(Utils.checkHand(1, "R13", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R11", "R12", "R13")
        );
        assertTrue(Utils.checkTable(checkMeld, server));


        //after P2 it is P3 who plays {R13 B13 G13} and {G2 R2 O2}:
        //there are now 3 melds on the table and hand of P3 is updated
        server.playAMeld("{R13 B13 G13} {G2 R2 O2}", 2);
        assertFalse(Utils.checkHand(2, "R13", server));
        assertFalse(Utils.checkHand(2, "B13", server));
        assertFalse(Utils.checkHand(2, "G13", server));
        assertFalse(Utils.checkHand(2, "G2", server));
        assertFalse(Utils.checkHand(2, "R2", server));
        assertFalse(Utils.checkHand(2, "O2", server));

        checkMeld = new ArrayList<>(
                Arrays.asList("R13", "B13", "G13")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

        
        checkMeld = new ArrayList<>(
                Arrays.asList("G2", "R2", "O2")
        );
        assertTrue(Utils.checkTable(checkMeld, server));

    }

}