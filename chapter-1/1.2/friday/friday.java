/*
ID: bharadw8
LANG: JAVA
TASK: friday
*/

import java.io.*;

class friday {
  public static void main (String [] args) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("friday.in"));
    PrintStream writer = new PrintStream(new File("friday.out"));
    
    int start = 1900;
    int end = Integer.parseInt(reader.readLine()) - 1;
    
    int[] monthcounts = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int [] weekcounts = {0, 0, 0, 0, 0, 0, 0};

    int day = 2;

    for (int i = start; i<=start+end; i++) {
      boolean leap = false;

      if(i % 400 == 0) {
        leap = true;
      } else if (i % 100 == 0) {
        leap = false;
      } else if (i % 4 == 0) {
        leap = true;
      } else {
        leap = false;
      }

      if (leap) { monthcounts[1] = 29; } else { monthcounts[1] = 28; }

      for (int month: monthcounts) {
        day += 12;
        day %= 7;
        weekcounts[day]++;
        day += month - 12;
      } 
    }

    String out = weekcounts[0]+ " " + weekcounts[1]+ " " + weekcounts[2] + " " + weekcounts[3] + " " + weekcounts[4] + " " + weekcounts[5] + " " + weekcounts[6];

    writer.println(out);

    reader.close();
    writer.close();
   
  }
}  