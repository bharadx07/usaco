/* 
ID: bharadw8
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;

class beads {
  public static void main (String [] args) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("beads.in"));
    PrintStream writer = new PrintStream(new File("beads.out"));

    reader.readLine();

    String strbeads = reader.readLine();
    char[] beads = (strbeads + strbeads).toCharArray();

    int[][] left = new int[beads.length + 1][2]; /* 0 is red, 1 is white */
    int[][] right = new int[beads.length + 1][2];

    for (int i = 1; i<beads.length; i++) {
      if (beads[i] == 'r') {
        left[i][0] = left[i-1][0] +1;
        left[i][1] = 0;
      } else if (beads[i] == 'b') {
        left[i][1] = left[i-1][1] +1;
        left[i][0] = 0;
      } else {
        left[i][0] = left[i-1][0] +1;
        left[i][1] = left[i-1][1] +1;
      }
    }

    for (int i = beads.length-1; i>0; i--) {
      if (beads[i] == 'r') {
        right[i][0] = right[i+1][0]+1;
        right[i][1] = 0;
      } else if (beads[i] == 'b') {
        right[i][1] = right[i+1][1]+1;
        left[i][0] = 0;
      } else {
        right[i][0] = right[i+1][0]+1;
        right[i][1] = right[i+1][1]+1;
      }
    }

	int max = 0;
	for (int p = 1; p< beads.length; p++) {
		int maxsides = Math.max(left[p - 1][0], left[p - 1][1])
					+ Math.max(right[p][0], right[p][1]);
		max = Math.max(max, maxsides);
	}
		
	max = Math.min(strbeads.length(), max);
    writer.println(max);

    reader.close();
    writer.close();
  }
}  