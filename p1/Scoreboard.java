package p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Scoreboard {
    
    int numCases = 0; // TODO set to first num from input


    private static ArrayList<int[]> getLines() {
        ArrayList<int[]> fileByLine  = new ArrayList<int[]>();
        String line;
        StringBuffer oneLineWonder = new StringBuffer();
        try(BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")))) {
           while ((line = br.readLine()) != null) {
              oneLineWonder.append(line);
              oneLineWonder.append(";");
           }
           for(String caseOrLog : oneLineWonder.toString().split(";")) {
              String[] sArray = caseOrLog.split(" ");
              int[] intArray = new int[sArray.length];
              for (int i = 0; i < sArray.length; i++) {
                 intArray[i] = Integer.parseInt(sArray[i]);
              }
              fileByLine.add(intArray);
           }
        } catch (IOException e) {
           e.printStackTrace();
        }
        return fileByLine;
    }
}