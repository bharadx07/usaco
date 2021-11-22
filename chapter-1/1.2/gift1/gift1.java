/* 
ID: bharadw8
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

class gift1 {
  public static void main (String [] args) throws IOException {
    Scanner reader = new Scanner(new File("gift1.in"));
    PrintStream writer = new PrintStream(new File("gift1.out"));

    Map<String, Integer> people = new HashMap<String, Integer>();
    List<String> names = new ArrayList<String>();

    int peopleCount = Integer.valueOf(reader.next());

    for (int i = 0; i<peopleCount; i++) {
      String name = reader.next();
      people.put(name, 0);
      names.add(name);
    }

    while(reader.hasNext()) {
      String name = reader.next();
      int money = reader.nextInt();
      int splitPeople = reader.nextInt();

         
      int moneyForEachPerson = 0;

      if(splitPeople > 0) {
        moneyForEachPerson = money/splitPeople;
      }
      
      for (int i = 0; i<splitPeople; i++) {
        String personTo = reader.next();
        people.put(personTo, people.get(personTo) + moneyForEachPerson);
      }

      people.put(name, (people.get(name))-(moneyForEachPerson*splitPeople));
     
    }

    for (String name: names) {
      int monetaryValue = people.get(name);
      writer.println(name + " " + Integer.toString(monetaryValue));

    }

    reader.close();
    writer.close();
  }
} 