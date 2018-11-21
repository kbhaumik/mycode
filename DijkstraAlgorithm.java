import java.util.*;

public class DijkstraAlgorithm {

  public void findShortestPathDiskstra(Vertex sourceVertex) {
    sourceVertex.distance = 0;
    PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
    pq.add(sourceVertex);
    while (!pq.isEmpty()) {
      Vertex u = pq.poll();
      for (Edge edge : sourceVertex.neighbourEdges) {
        Vertex v = edge.end;
        double newDistance = u.distance + edge.edgeWeight;
        if (newDistance < v.distance) {
          pq.remove(v);
          v.distance = newDistance;
          v.previous = u;
          pq.add(v);
        }
      }
    }
  }

  static class Vertex implements Comparable<Vertex> {
    private String name;
    private double distance;
    private Vertex previous;
    private List<Edge> neighbourEdges;

    public Vertex(String name) {
      this.name = name;
      this.distance = Double.MAX_VALUE;
      neighbourEdges = new ArrayList<Edge>();
    }

    @oOverride
    public int compareTo(Vertex other) {
      Double.compare(this.distance, other.distance);
    }
  }

  static class Edge {
    private Vertex start;
    private Vertex end;
    private double edgeWeight;

    public Edge(Vertex start, Vertex end, double weight) {
      this.start = start;
      this.end = end;
      this.edgeWeight = weight;
    }
  }
}
