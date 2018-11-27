import java.util.ArrayList;

public class Main {

   public static void main(String[] args) {
      Lukija ht = new Lukija();
      ht.readInput();
      Graph graph = new Graph();

      for(int i = 0; i < ht.getX().length; i++) {
         graph.addNode(ht.getX()[i], ht.getY()[i]);
      }

      graph.findClosest();
      ArrayList<Node> bfs = graph.breadthFirstSearch(3);
      ht.writeOutput(bfs, "BFS.txt");
   //   System.out.println(graph);

      //ht.writeOutput();
   }
}
