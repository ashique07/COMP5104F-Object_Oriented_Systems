package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

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
}