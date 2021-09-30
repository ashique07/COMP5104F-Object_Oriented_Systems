package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {


    public List<String> stock = new ArrayList<String>(
            Arrays.asList(
                    "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R11", "R12", "R13",
                    "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B11", "B12", "B13",
                    "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10", "G11", "G12", "G13",
                    "O1", "O2", "O3", "O4", "O5", "O6", "O7", "O8", "O9", "O10", "O11", "O12", "O13",
                    "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R11", "R12", "R13",
                    "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B11", "B12", "B13",
                    "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10", "G11", "G12", "G13",
                    "O1", "O2", "O3", "O4", "O5", "O6", "O7", "O8", "O9", "O10", "O11", "O12", "O13"
                    )
    );

    public List<String> player0Hand = new ArrayList<String>();
    public List<String> player1Hand = new ArrayList<String>();
    public List<String> player2Hand = new ArrayList<String>();

    public List<List<String>> table = new ArrayList<>();


    private int serverPort;
    private ArrayList<Socket> clientsNetworkingInfo;
    private ServerSocket serverSocket;

    private ArrayList<String> telephoneHistory = new ArrayList<>();

    public Server(){

        this.serverPort = Config.PORT_NUMBER;
    }

    public static void main(String [] args){

        Server server = new Server();
        System.out.println("Starting Server . . . .");
        server.startServer();

    }


    public void startServer(){

        clientsNetworkingInfo = new ArrayList<>();

        try
        {
            serverSocket = new ServerSocket(serverPort);
        }
        catch (IOException e)
        {
           System.err.println("Could not listen on port: " + serverPort);
           System.exit(1);
        }

        acceptClients();
        sendStartInfoToAllClients();
        startTelephoneGame();
    }

    public void acceptClients() {

        while (clientsNetworkingInfo.size() < Config.NUM_OF_CLIENTS) {

            try {
                //Accept client
                Socket socket = serverSocket.accept();
                System.out.println("accepts : " + socket.getRemoteSocketAddress());

                //Keep clients socket information for latter use
                clientsNetworkingInfo.add(socket);
            }
            catch (IOException ex){
                System.out.println("Accept failed on: " + serverPort);
            }

        }
        System.out.println("Client Limit Reached");
    }

    public void sendStartInfoToAllClients(){

        System.out.println("Sending start info to clients");

        //Create Player List
        String playerList = "";

        for(int i = 0; i < clientsNetworkingInfo.size(); i++)
        {
            playerList += "\nPlayer " + i;
        }

        String startMessage = "Server is starting the game..." + "\n"
                + "Welcome to the game of RummyKube" + "\n"
                + "Player Order List: "
                + playerList + "\n"
                + "Please wait for your turn...";

        for(int i = 0; i < clientsNetworkingInfo.size(); i++){

            if(!clientsNetworkingInfo.get(i).isClosed()){

                try{
                    //Write start information to clients socket
                    //*1*
                    Utils.writeParagraph(new PrintWriter(clientsNetworkingInfo.get(i).getOutputStream(), true), "You are Player: " + i + "\n" + startMessage);
                }
                catch (IOException e){
                    e.printStackTrace();
                }

            }

        }

    }

    public void distributeTilesToPlayers() {

        for(int i = 0; i < 3; i++)
        {
            if(i == 0){
                for(int j = 0; j < 14; j++) {
                    //Get random tile from stock
                    Random r = new Random();
                    int randomInt = r.nextInt(stock.size());
                    player0Hand.add(stock.remove(randomInt));
                }
            }

            if(i == 1){
                for(int j = 0; j < 14; j++) {
                    //Get random tile from stock
                    Random r = new Random();
                    int randomInt = r.nextInt(stock.size());
                    player1Hand.add(stock.remove(randomInt));
                }
            }

            if(i == 2){
                for(int j = 0; j < 14; j++) {
                    //Get random tile from stock
                    Random r = new Random();
                    int randomInt = r.nextInt(stock.size());
                    player2Hand.add(stock.remove(randomInt));
                }
            }

        }

    }

    public void writeHandToClient(int clientNumber){

        String hand = "";

        if(clientNumber == 0)
        {
            for(int i = 0; i < player0Hand.size(); i++)
            {
                hand = hand + player0Hand.get(i) + " ";
            }
        }

        if(clientNumber == 1)
        {
            for(int i = 0; i < player1Hand.size(); i++)
            {
                hand = hand + player1Hand.get(i) + " ";
            }
        }

        if(clientNumber == 2)
        {
            for(int i = 0; i < player2Hand.size(); i++)
            {
                hand = hand + player2Hand.get(i) + " ";
            }
        }

        try {
            Utils.writeParagraph(new PrintWriter(clientsNetworkingInfo.get(clientNumber).getOutputStream(), true), hand + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public void writeTableToClient(int clientNumber)
    {
        String tableString = "";

        for(int i = 0; i < table.size(); i++)
        {
            List<String> meld = new ArrayList<>(table.get(i));

            tableString += "{ ";
            for(String s : meld)
            {
                tableString += s + " ";
            }
            tableString += "}" + "\n";
        }

        try {
            Utils.writeParagraph(new PrintWriter(clientsNetworkingInfo.get(clientNumber).getOutputStream(), true), tableString + "\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public boolean playAMeld(String melds, int clientNumber){

        //{R2 B2 G2 O2} {G3 G4 G5 G6 G7} {O4 O5 O6 O7 O8}

        for(int i = 0; i < melds.length(); i++)
        {
            String meld = "";

            List<String> meldList = new ArrayList<>();

            if(melds.charAt(i) == '{')
            {
                int j = i+1;

                while (melds.charAt(j) != '}')
                {
                    meld += String.valueOf(melds.charAt(j));
                    j++;
                }

                Scanner sc = new Scanner(meld);
                while(sc.hasNext())
                {
                    String tile = sc.next();
                    meldList.add(tile);

                    if(clientNumber == 0)
                    {
                        if(player0Hand.size() == 0)
                            return true;
                        player0Hand.remove(tile);
                    }

                    if(clientNumber == 1)
                    {
                        if(player1Hand.size() == 0)
                            return true;
                        player1Hand.remove(tile);
                    }

                    if(clientNumber == 2)
                    {
                        if(player2Hand.size() == 0)
                            return true;
                        player2Hand.remove(tile);
                    }
                }

                table.add(meldList);
                i = j;
            }
        }

        return false;
    }

    public void takeATile(int clientNumber){

        Random r = new Random();
        int randomInt = r.nextInt(stock.size());

        if(clientNumber == 0)
            player0Hand.add(stock.remove(randomInt));
        if(clientNumber == 1)
            player1Hand.add(stock.remove(randomInt));
        if(clientNumber == 2)
            player2Hand.add(stock.remove(randomInt));

    }


    public void startTelephoneGame()
    {
        System.out.println("Starting RummyKub Game");

        distributeTilesToPlayers();

        for(int i = 0; i < clientsNetworkingInfo.size(); i++)
        {
            //*2*
            writeTableToClient(i);
        }

        for(int i = 0; i < clientsNetworkingInfo.size(); i++)
        {
            //*3*
            writeHandToClient(i);
        }

        for(int i = 0; i < clientsNetworkingInfo.size(); i++){

            if(!clientsNetworkingInfo.get(i).isClosed()){

                try {

                    //"Press 1 for playing a meld(s). Press 2 from taking a tile."
                    String turnMessage = "It is your turn now !" + "\n"  + "Press 1 for playing a meld and Press 2 for taking a tile.";
                    Utils.writeParagraph(new PrintWriter(clientsNetworkingInfo.get(i).getOutputStream(), true), turnMessage + "\n");

                    //"Please enter your melds"
                    //Get melds from clients
                    BufferedReader meldsBr = new BufferedReader(new InputStreamReader(clientsNetworkingInfo.get(i).getInputStream()));
                    String melds = meldsBr.readLine();

                    System.out.println("MELDS RECEIVED IN SERVER ARE: " + melds);

                    if(melds.equals(""))
                    {
                        System.out.println("Inside TAKE A TILE of Server");
                        takeATile(i);
                    }
                    else
                    {
                        if (playAMeld(melds, i))
                        {
                            System.out.println("Player " + i + " is the winner !!");
                            break;
                        }
                    }

                    writeTableToClient(i);
                    writeHandToClient(i);
                }
                catch (IOException e){

                    e.printStackTrace();
                }
            }
        }




        System.out.println("Server shutting down . . . .");
        try {
            serverSocket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}

