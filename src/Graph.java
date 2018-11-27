import java.util.*;

public class Graph {
   private List<Node> vertices;

   public Graph() {
      this.vertices = new ArrayList<>();
   }

   public void addNode(float x, float y) {
      vertices.add(new Node(x, y));
   }

   public void findClosest() {

      //foreach vertices
      for (int i = 0; i < vertices.size() - 1; i++) {
         Node etsittävä = vertices.get(i);
         Node lähin = null;
         Node toiseksiLähin = null;
         float lähinEtäisyys = Float.MAX_VALUE;
         float toiseksiLähinEtäisyys = Float.MAX_VALUE;
         for (int j = 0; j < vertices.size() - 1; j++) {
            if (vertices.get(j) != vertices.get(i)) {
               float vertailtavaEtäisyys = etsittävä.distance(vertices.get(j));
               if (lähin == null || vertailtavaEtäisyys < lähinEtäisyys) {
                  toiseksiLähin = lähin;
                  toiseksiLähinEtäisyys = lähinEtäisyys;
                  lähin = vertices.get(j);
                  lähinEtäisyys = vertailtavaEtäisyys;
               } else if (toiseksiLähin == null || vertailtavaEtäisyys < toiseksiLähinEtäisyys) {
                  toiseksiLähin = vertices.get(j);
                  ;
                  toiseksiLähinEtäisyys = vertailtavaEtäisyys;
               }
            }
         }
         if (lähin != null) {
            etsittävä.addNeighbors(lähin);
         }
         if (toiseksiLähin != null) {
            etsittävä.addNeighbors(toiseksiLähin);
         }

      }

   }

   private void clearVisitState() {
      for (Node n : vertices) {
         n.setVisited(false);
      }
   }

   public ArrayList<Node> breadthFirstSearch(int v) {
      // Mark all the vertices as not visited(By default
      // set as false)
      // Create a queue for BFS
      ArrayList<Node> iterated = new ArrayList<>();
      clearVisitState();
      Queue<Node> queue = new LinkedList<>();

      // Mark the current node as visited and enqueue it
      vertices.get(v).setVisited(true);
      queue.add(vertices.get(v));

      while (queue.size() != 0) {
         // Dequeue a vertex from queue and print it
         Node s = queue.poll();
         iterated.add(s);
         System.out.print(s + " ");

         // Get all adjacent vertices of the dequeued vertex s
         // If a adjacent has not been visited, then mark it
         // visited and enqueue it
         Iterator<Node> i = s.getNeighbors().listIterator();
         while (i.hasNext()) {
            Node n = i.next();
            if (!n.isVisited()) {
               n.setVisited(true);
               queue.add(n);
            }
         }
      }
      return iterated;
   }

}
