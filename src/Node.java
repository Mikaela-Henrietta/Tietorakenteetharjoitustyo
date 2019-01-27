import java.util.LinkedList;

/* tira 2018 harjoitustyö kohdat 1-7
 * Mikaela Lindfors 79328
 * mikaela.lindfors@tuni.fi
 * */

public class Node {
   private float x; //Pisteen x-koordinaatti.
   private float y; //Pisteen y-koordinaatti.
   private LinkedList<Node> edges; //Linkit pisteen “naapureihin”
   private boolean visited;
   private int inDegrees;

   public Node(float x, float y) {
      this.x = x;
      this.y = y;
      this.edges = new LinkedList<>();
      this.visited = false;
      this.inDegrees = 0;
   }

   public float getX() {
      return x;
   }

   public void setX(float x) {
      this.x = x;
   }

   public float getY() {
      return y;
   }

   public void setY(float y) {
      this.y = y;
   }

   public LinkedList<Node> getEdges() {
      return edges;
   }

   public void addEdge(Node node) {
      this.edges.add(node);
   }
   public void removeEdge(Node node) {
      if(this.edges.contains(node)) {
         this.edges.remove(node);
      }
   }
   public void clearEdges() {
      this.edges = new LinkedList<>();
   }

   public boolean isVisited() {
      return visited;
   }

   public void setVisited(boolean visited) {
      this.visited = visited;
   }
   public float distance(Node otherNode) {
      return (float) Math.sqrt((this.x - otherNode.x)*(this.x - otherNode.x) + (this.y - otherNode.y)*(this.y - otherNode.y));
   }
   public void addIndegree() {
      this.inDegrees++;
   }
   public int getInDegrees() {
      return this.inDegrees;
   }
   public int getOutDegrees() {
      return this.edges.size();
   }

   @Override
   public String toString() {
      return "Node{" +
            "x=" + x +
            ", y=" + y +
            '}';
   }
}
