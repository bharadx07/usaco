/*
ID: bharadw8
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.*;

class ride {
  public static void main (String [] args) throws IOException {
    FileReader basereader = new FileReader("ride.in");
    BufferedReader reader = new BufferedReader(basereader);
    PrintStream writer = new PrintStream(new File("ride.out"));

    String cometName = reader.readLine();
    String groupName  = reader.readLine();

    int cometProduct = 1;
    int groupProduct = 1;

    for (char c : cometName.toCharArray()) {
      cometProduct*= (int)c - (int)'A' + 1;
    }

    for (char c: groupName.toCharArray()) {
      groupProduct*= (int)c - (int)'A' + 1;
    }

    groupProduct%=47;
    cometProduct%=47;

    if(groupProduct == cometProduct) {
      writer.println("GO");
    } else {
      writer.println("STAY");
    }

    reader.close();
    writer.close();
  }
} 