package org.example.datastructures.graphs.implementation;

public class DirectWeightedGraph {
  private Integer[][] adjMatrix;
  private int size;
  private String[] vertexData;

  public DirectWeightedGraph(int size) {
    this.size = size;
    this.adjMatrix = new Integer[size][size];
    this.vertexData = new String[size];
  }

  public void printConnections() {
    System.out.println("\nConnections for each vertex:");
    for (int i = 0; i < vertexData.length; i++) {
      System.out.print(vertexData[i] + ": ");
      for (int j = 0; j < vertexData.length; j++) {
        if (adjMatrix[i][j] != null) {
          System.out.print(vertexData[j] + " (" + adjMatrix[i][j] + ") ");
        }
      }
      System.out.println();
    }
  }

  public void addEdge(int u, int v, int weight) {
    if (u >= 0 && u < size && v >= 0 && v < size) {
      adjMatrix[u][v] = weight;
      adjMatrix[v][u] = weight;
    }
  }

  public void addVertexData(int vertex, String data) {
    if (vertex >= 0 && vertex < size) {
      vertexData[vertex] = data;
    }
  }

  public void printGraph() {
    System.out.println("Adjacency Matrix:");
    for (Integer[] row : adjMatrix) {
      for (Integer cell : row) {
        System.out.print((cell != null ? cell : 0) + " ");
      }
      System.out.println();
    }
    System.out.println("\nVertex Data:");
    for (int i = 0; i < vertexData.length; i++) {
      System.out.println("Vertex " + i + ": " + (vertexData[i] != null ? vertexData[i] : ""));
    }
  }

  public static void main(String[] args) {
    DirectWeightedGraph graph = new DirectWeightedGraph(4);
    graph.addVertexData(0, "A");
    graph.addVertexData(1, "B");
    graph.addVertexData(2, "C");
    graph.addVertexData(3, "D");
    graph.addEdge(0, 1, 3); // A -> B with weight 3
    graph.addEdge(0, 2, 2); // A -> C with weight 2
    graph.addEdge(3, 0, 4); // D -> A with weight 4
    graph.addEdge(2, 1, 1); // C -> B with weight 1
    graph.printGraph();
    graph.printConnections();
  }
}
