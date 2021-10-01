package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private String serverHost;
    private int serverPort;

    public Client (String serverHost, int serverPort)
    {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    public static void main(String [] args){

        Client client = new Client(Config.HOST, Config.PORT_NUMBER);
        client.startClient();
    }

    public void startClient(){

        try{

            System.out.println("Connecting to server . . .");

            //Connect to the server's socket
            Socket socket = new Socket(serverHost, serverPort);

            try{
                Thread.sleep(1000); //waiting for network communicating
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            System.out.println("Connected to server");

            //Get the starting information
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Utils.readParagraph(bufferedReader);

            while (socket.isConnected()) {

                //Get the updated table from server
                Utils.readParagraph(bufferedReader);

                //Get the updated hand from server
                Utils.readParagraph(bufferedReader);

                //"Press 1 for playing a meld(s). Press 2 from taking a tile."
                Utils.readParagraph(bufferedReader);
                Scanner sc = new Scanner(System.in);
                String playType = sc.next();

                String melds = "";
                if (playType.equals("1")) {
                    System.out.println("Please enter your melds");
                    Scanner sc1 = new Scanner(System.in);
                    melds = sc1.nextLine();
                }

                //Send melds to server
                Utils.writeParagraph(new PrintWriter(socket.getOutputStream(), true), melds);

                //Get the updated table from server
                Utils.readParagraph(bufferedReader);

                //Get the updated hand from server
                Utils.readParagraph(bufferedReader);

            }

            System.out.println("END OF GAME");
            Utils.readParagraph(bufferedReader);

            //Close socket and buffer reader
            bufferedReader.close();
            socket.close();
            }

            catch (IOException e) {
            e.printStackTrace();
            }

        }

    }