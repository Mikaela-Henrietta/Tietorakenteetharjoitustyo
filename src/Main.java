import java.util.ArrayList;

/* tira 2018 harjoitustyö kohdat 1-7
 * Mikaela Lindfors 79328
 * mikaela.lindfors@tuni.fi
 * */

public class Main {

   public static void main(String[] args) {
      // 1. Graafi luodaan lukemalla esimerkkitiedostosta pisteet.
      Lukija ht = new Lukija();
      ht.readInput();
      Graph graph = new Graph();

      for(int i = 0; i < ht.getX().length; i++) {
         graph.addNode(ht.getX()[i], ht.getY()[i]);
      }
      // 2. Lisätään graafin jokaiselle solmulle toiseksi lähinnä olevan pisteen sisältämä solmu
      graph.findClosest(2);

      // 3. Kirjoitetaan tiedostoon BFS.txt solmujen koordinaatit leveyshaun antamassa järjestyksessä
      ArrayList<Node> bfs = graph.breadthFirstSearch();
      ht.writeOutput(bfs, "BFS.txt");

      // 4. Kirjoitetaan tiedostoon DFS.txt solmujen koordinaatit syvyyshaun antamassa järjestyksessä
      ArrayList<Node> dfs = graph.depthFirstSearch();
      ht.writeOutput(dfs, "DFS.txt");

      // 5. Kirjoitetaan tiedostoon Degrees.txt solmujen lähtö- ja tuloasteet
      ht.writeStringOutput(graph.inDegrees(), "degrees.txt");

      // 6. Poistetaan annettu solmu graafista ja tulostetaan jäljelle jäänyt graafi tiedostoon DIM.txt
      // leveyshaun mukaisessa järjestyksessä
      graph.removeVertice(graph.getVertice(0));
      ArrayList<Node> dim = graph.depthFirstSearch();
      ht.writeOutput(dim, "DIM.txt");

      // 7. Lisää solmuille lähimpiä naapureita , kunnes graafista tulee yhteinäinen, eli mistä tahansa solmusta
      // voidaan käydä kaikissa graafin muissa solmuissa ja palata takaisin lähtösolmuun. Tulostaa graafin
      // syvyyshaun mukaisessa järjestyksessä tiedostoon COMP.txt
      int j = 0;
      while (!graph.isConnected()) {
         graph.findClosest(j);
         j++;
      }
      System.out.println("is connected " + graph.isConnected() + " with " + j + " closest");
      ArrayList<Node> comp = graph.depthFirstSearch();
      ht.writeOutput(comp,  "COMP.txt");
   }
}
