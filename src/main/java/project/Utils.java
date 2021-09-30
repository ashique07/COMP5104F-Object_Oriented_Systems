package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static void readParagraph(BufferedReader buffIn) throws IOException {

        String line;

        while(true){

            //If there is a line, read it
            if((line = buffIn.readLine()) == null || line.equals("final_string")){
                break;
            }

            System.out.println(line);
        }

    }

    public static void writeParagraph(PrintWriter pw, String message) throws IOException {

        pw.write(message + "\n" + "final_string" + "\n");
        pw.flush();
    }

    public static void fixHand(int playerNumber, String tile, Server server)
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

    public static boolean checkTable(List<String> checkMeld, Server server)
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


    public static boolean checkHand(int playerNumber, String tile, Server server)
    {
        if(playerNumber == 0)
        {
            if(Collections.frequency(server.player0Hand, tile) == 2)
            {
                    return true;
            }
        }

        if(playerNumber == 1)
        {
            if(Collections.frequency(server.player1Hand, tile) == 2)
            {
                return true;
            }
        }

        if(playerNumber == 2)
        {
            if(Collections.frequency(server.player2Hand, tile) == 2)
            {
                return true;
            }
        }

        return false;
    }

}