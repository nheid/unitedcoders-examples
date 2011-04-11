import java.io.*;
import java.util.*;

public class Test {

   public static void main(String[] args) throws IOException {

       BufferedReader reader = new BufferedReader(new
InputStreamReader(new FileInputStream("/home/nheid/tmp/large.in")));

       int testcases = Integer.parseInt(reader.readLine());
       for(int casenr=1; casenr<=testcases; casenr++){

           Map<Integer, Integer> lines = new HashMap<Integer, Integer>();

           int nroflines = Integer.parseInt(reader.readLine());
           for(int data=0; data<nroflines; data++){
               String[] line = reader.readLine().split(" ");
               lines.put(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
           }

           int intersections = 0;

           Vector v = new Vector(lines.keySet());
           Collections.sort(v);
           Iterator i = v.iterator();

           while (i.hasNext()) {

               Integer a = (Integer) i.next();
               Integer b = lines.get(a);

               Iterator j = v.iterator();
               while (j.hasNext()) {
                   Integer n = (Integer) j.next();
                   if (n <= a) {
                       continue;
                   }

                   Integer m = lines.get(n);
                   if (m < b) {
                       intersections++;
                   }
               }
           }

           System.out.println("Case #"+casenr+": "+intersections);
       }
   }


}
