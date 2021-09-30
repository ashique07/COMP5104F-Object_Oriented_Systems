package project;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Grid70To74 {

    @Test
    //P1 starts with {G2 R2 O2} {G3 R3 O3} {O8 O9 O10} {R8 R9 R10} G12 R7 in hand
    //and then chooses to draw
    void grid71(){

        Server server = new Server();
        server.distributeTilesToPlayers();

        server.takeATile(0);

        //Check if number of tiles in hand of player 0 is 15
        assertEquals(15, server.player0Hand.size());

    }

    @Test
    //P1 starts with G2 G2 O2 R3 B3 B3 R5 B6 O7 R9 R10 G11 B12 B13 and has to draw
    void grid72(){

        Server server = new Server();
        server.distributeTilesToPlayers();

        server.takeATile(0);

        //Check if number of tiles in hand of player 0 is 15
        assertEquals(15, server.player0Hand.size());

    }

}