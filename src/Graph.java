import java.util.*;

/* tira 2018 harjoitustyö kohdat 1-7
* Mikaela Lindfors 79328
* mikaela.lindfors@tuni.fi
* */
// luokka toteuttaa graafin metodit

public class Graph {
   private List<Node> vertices;

   public Graph() {
      this.vertices = new ArrayList<Node>();
   }
   public void addNode(float x, float y) {
      vertices.add(new Node(x, y));
   }
   public void findClosest(int addClosestToEdges) {

      for (int i = 0; i < vertices.size(); i++) {
         Node item = vertices.get(i);
         item.clearEdges();
         Map<Float, Node> distances = new TreeMap<Float, Node>((o1, o2) -> o1.compareTo(o2));
         for (Node vertice : vertices) {
            if (vertice != vertices.get(i)) {
               distances.put(item.distance(vertice), vertice);
            }
         }
         int k = 0;
         for (Node n: distances.values()) {
            if(k < addClosestToEdges) {
               item.addEdge(n);
               n.addIndegree();
            }
            k++;
         }
      }
   }

   private void clearVisitState() {
      for (Node n : vertices) {
         n.setVisited(false);
      }
   }

   public void removeVertice(Node n) {
      for (Node vertice : vertices) {
         vertice.removeEdge(n);
      }
      this.vertices.remove(n);
   }

   public ArrayList<Node> breadthFirstSearch() {
      ArrayList<Node> iterated = new ArrayList<>();
      clearVisitState();
      Queue<Node> queue = new LinkedList<>();

      for (Node v: vertices) {
         v.setVisited(true);
         queue.add(v);

         while (queue.size() != 0) {
            Node s = queue.poll();
            iterated.add(s);
            Iterator<Node> i = s.getEdges().listIterator();
            while (i.hasNext()) {
               Node n = i.next();
               if (!n.isVisited()) {
                  n.setVisited(true);
                  queue.add(n);
               }
            }
         }
      }
      return iterated;
   }
   /* perform depthFirstSearch starting at node n */
   public ArrayList<Node> depthFirstSearch () {
      clearVisitState();
      ArrayList<Node> iterated = new ArrayList<>();
      for (Node n: vertices) {
         depthFirstSearchRec(n, iterated);
      }
      return iterated;
   }
   //recursive part
   private void depthFirstSearchRec (Node v, ArrayList<Node> iterated) {
      v.setVisited(true);
      iterated.add(v);
      for (int i = 0; i < v.getEdges().size(); i++) {
         Node node = v.getEdges().get(i);
         if (!node.isVisited()) {
            depthFirstSearchRec(node, iterated);
         }
      }
   }

   public ArrayList<String> inDegrees() {
      ArrayList<String> indegrees = new ArrayList<>();
      for (Node n: vertices) {
         indegrees.add("node " + n.toString() + ", indegrees: " + n.getInDegrees() + ", outdegrees: " + n.getOutDegrees());
      }
      return indegrees;
   }

   public boolean isConnected() {
      clearVisitState();
      ArrayList<Node> iterated = new ArrayList<Node>();
      depthFirstSearchRec(this.vertices.get(0), iterated);
      boolean isConnected = true;
      for(Node n : this.vertices) {
         if(!n.isVisited()) {
            isConnected = false;
         }
      }
      return isConnected;
   }

   public Node getVertice(int i) {
      return this.vertices.get(i);
   }
}
