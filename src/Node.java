import java.util.LinkedList;

public class Node {
   private float x; //Pisteen x-koordinaatti.
   private float y; //Pisteen y-koordinaatti.
   private LinkedList<Node> neighbors; //Linkit pisteen “naapureihin”
   private boolean visited;

   public Node(float x, float y) {
      this.x = x;
      this.y = y;
      this.neighbors = new LinkedList<>();
      this.visited = false;
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

   public LinkedList<Node> getNeighbors() {
      return neighbors;
   }

   public void addNeighbors(Node neighbor) {
      this.neighbors.add(neighbor);
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

   @Override
   public String toString() {
      return "Node{" +
            "x=" + x +
            ", y=" + y +
            '}';
   }
}
