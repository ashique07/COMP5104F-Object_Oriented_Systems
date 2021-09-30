package project;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Grid44To48 {

    public void fixHand(int playerNumber, String tile, Server server)
    {

        if(playerNumber == 0) {
            if (!server.player0Hand.contains(tile)) {
                if (server.stock.contains(tile)) {
                    server.player0Hand.add(server.stock.remove(server.stock.indexOf(tile)));
                } else if (server.player1Hand.contains(tile)) {
                    server.player0Hand.add(server.player1Hand.remove(server.player1Hand.indexOf(tile)));
                }
                else {
                    server.player0Hand.add(server.player2Hand.remove(server.player2Hand.indexOf(tile)));
                }
            }
        }


        if(playerNumber == 1) {
            if (!server.player1Hand.contains(tile)) {
                if (server.stock.contains(tile)) {
                    server.player1Hand.add(server.stock.remove(server.stock.indexOf(tile)));
                } else if (server.player0Hand.contains(tile)) {
                    server.player1Hand.add(server.player0Hand.remove(server.player0Hand.indexOf(tile)));
                }
                else{
                    server.player1Hand.add(server.player2Hand.remove(server.player2Hand.indexOf(tile)));
                }
            }
        }

        if(playerNumber == 2) {
            if (!server.player2Hand.contains(tile)) {
                if (server.stock.contains(tile)) {
                    server.player2Hand.add(server.stock.remove(server.stock.indexOf(tile)));
                } else if (server.player0Hand.contains(tile)) {
                    server.player2Hand.add(server.player0Hand.remove(server.player0Hand.indexOf(tile)));
                }
                else{
                    server.player2Hand.add(server.player1Hand.remove(server.player1Hand.indexOf(tile)));
                }
            }
        }

    }

    public boolean checkTable(List<String> checkMeld, Server server)
    {
        for(int i = 0; i < server.table.size(); i++)
        {
            List<String> meld = new ArrayList<>(server.table.get(i));
            if(meld.containsAll(checkMeld))
            {
                return true;
            }
        }
        return false;
    }

    /*
    public boolean checkHand(int playerNumber, String tile, Server server)
    {
        if(playerNumber == 0)
        {
            if(server.player0Hand.contains(tile))
            {
                if(Collections.frequency(server.player0Hand, tile) == 2){
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }
     */


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

        fixHand(1, "R11", server);
        fixHand(1, "R12", server);
        fixHand(1, "R13", server);

        fixHand(2, "R13", server);
        fixHand(2, "B13", server);
        fixHand(2, "G13", server);

        fixHand(2, "G2", server);
        fixHand(2, "R2", server);
        fixHand(2, "O2", server);

        fixHand(0, "R12", server);
        fixHand(0, "B12", server);
        fixHand(0, "O12", server);

        //P1 plays first and draws: all players still see the table empty
        server.takeATile(0);


        //after P1 it is P2 who plays {R11 R12 R13}:
        //this meld is on the table and seen by all players and hand of P2 is updated
        server.playAMeld("{R11 R12 R13}", 1);
        assertFalse(server.player1Hand.contains("R11"));
        assertFalse(server.player1Hand.contains("R12"));
        assertFalse(server.player1Hand.contains("R13"));

        checkMeld = new ArrayList<>(
                Arrays.asList("R11", "R12", "R13")
        );
        assertTrue(checkTable(checkMeld, server));


        //after P2 it is P3 who plays {R13 B13 G13} and {G2 R2 O2}:
        //there are now 3 melds on the table and hand of P3 is updated
        server.playAMeld("{R13 B13 G13} {G2 R2 O2}", 2);
        assertFalse(server.player2Hand.contains("R13"));
        assertFalse(server.player2Hand.contains("B13"));
        assertFalse(server.player2Hand.contains("G13"));
        assertFalse(server.player2Hand.contains("G2"));
        assertFalse(server.player2Hand.contains("R2"));
        assertFalse(server.player2Hand.contains("O2"));

        checkMeld = new ArrayList<>(
                Arrays.asList("R13", "B13", "G13")
        );
        assertTrue(checkTable(checkMeld, server));

        
        checkMeld = new ArrayList<>(
                Arrays.asList("G2", "R2", "O2")
        );
        assertTrue(checkTable(checkMeld, server));

    }

}