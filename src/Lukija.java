import java.io.*;
import java.util.ArrayList;

public class Lukija {

   private String line;
   private float x[];
   private float y[];

   public void readInput() {

      x = new float[400];
      y = new float[400];
      try {
         BufferedReader br = new BufferedReader(new FileReader("./Tdata.txt"));

         for (int i = 0; i < 400; i++) {
            line = br.readLine();
            String[] values = line.split(",");
            x[i] = Float.parseFloat(values[0]);
            y[i] = Float.parseFloat(values[1]);
            //System.out.print(x[i] + " , " + y[i] + "\n");
         }

      } catch (IOException e) {
         System.out.println("File not found.");
      }
   }

   public float[] getX() {
      return x;
   }

   public float[] getY() {
      return y;
   }

   public void writeOutput(ArrayList<Node> list, String fileName) {

      try {
         BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
         for (Node n : list) {
            bw.write(Float.toString(n.getX()));
            bw.write(",");
            bw.write(Float.toString(n.getY()));
            bw.newLine();
         }
         bw.close();
      } catch (IOException e) {
         System.err.format("IOException: %s%n", e);
      }
      System.out.println("Tiedosto kirjoitettu");
   }
   public void writeStringOutput(ArrayList<String> list, String fileName) {

      try {
         BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
         for (String n : list) {
            bw.write(n);
            bw.newLine();
         }
         bw.close();
      } catch (IOException e) {
         System.err.format("IOException: %s%n", e);
      }
      System.out.println("Tiedosto kirjoitettu");
   }
}
