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

    public static List<String> sort(List<String> l1)
    {
        List<String> l2 = new ArrayList<>();
        List<String> r = new ArrayList<>();
        List<String> b = new ArrayList<>();
        List<String> g = new ArrayList<>();
        List<String> o = new ArrayList<>();
        int numberI = 0;
        int numberJ = 0;

        for(int i = 0; i < l1.size(); i++)
        {
            if(l1.get(i).charAt(0) == 'R')
            {
                r.add(l1.get(i));
            }
        }

        for(int i = 0; i < r.size(); i++)
        {
            for(int j = i+1; j < r.size(); j++)
            {
                numberI = Integer.parseInt(r.get(i).substring(1));
                numberJ = Integer.parseInt(r.get(j).substring(1));

                if(numberI > numberJ)
                {
                    Collections.swap(r, i, j);
                }
            }
        }
        //////////////////////////////////////

        numberI = 0;
        numberJ = 0;
        for(int i = 0; i < l1.size(); i++)
        {
            if(l1.get(i).charAt(0) == 'B')
            {
                b.add(l1.get(i));
            }
        }

        for(int i = 0; i < b.size(); i++)
        {
            for(int j = i+1; j < b.size(); j++)
            {
                numberI = Integer.parseInt(b.get(i).substring(1));
                numberJ = Integer.parseInt(b.get(j).substring(1));

                if(numberI > numberJ)
                {
                    Collections.swap(b, i, j);
                }
            }
        }

        ///////////////////////////////////////////////////////////

        numberI = 0;
        numberJ = 0;
        for(int i = 0; i < l1.size(); i++)
        {
            if(l1.get(i).charAt(0) == 'G')
            {
                g.add(l1.get(i));
            }
        }

        for(int i = 0; i < g.size(); i++)
        {
            for(int j = i+1; j < g.size(); j++)
            {
                numberI = Integer.parseInt(g.get(i).substring(1));
                numberJ = Integer.parseInt(g.get(j).substring(1));

                if(numberI > numberJ)
                {
                    Collections.swap(g, i, j);
                }
            }
        }
        ////////////////////////////////////////////////

        numberI = 0;
        numberJ = 0;
        for(int i = 0; i < l1.size(); i++)
        {
            if(l1.get(i).charAt(0) == 'O')
            {
                o.add(l1.get(i));
            }
        }

        for(int i = 0; i < o.size(); i++)
        {

            for(int j = i+1; j < o.size(); j++)
            {
                numberI = Integer.parseInt(o.get(i).substring(1));
                numberJ = Integer.parseInt(o.get(j).substring(1));

                if(numberI > numberJ)
                {
                    Collections.swap(o, i, j);
                }
            }
        }

        for(int i = 0; i < r.size(); i++)
        {
            l2.add(r.get(i));
        }
        for(int i = 0; i < b.size(); i++)
        {
            l2.add(b.get(i));
        }
        for(int i = 0; i < g.size(); i++)
        {
            l2.add(g.get(i));
        }
        for(int i = 0; i < o.size(); i++)
        {
            l2.add(o.get(i));
        }

        return l2;
    }

}