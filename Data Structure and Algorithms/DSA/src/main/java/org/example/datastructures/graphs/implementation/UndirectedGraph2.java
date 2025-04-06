package org.example.datastructures.graphs.implementation;

import java.util.Arrays;

public class UndirectedGraph2 {

  private final int[][] adjMatrix; // Adjacency matrix to represent edges between vertices.
  private final String[]
      vertexData; // Array to store data associated with each vertex (e.g., labels).
  private final int size;

  /**
   * Constructor to initialize a graph with the given number of vertices. Initializes adjacency
   * matrix and vertex data storage.
   */
  public UndirectedGraph2(int size) {
    this.size = size;
    this.adjMatrix = new int[size][size];
    this.vertexData = new String[size];
    Arrays.fill(this.vertexData, ""); // Initialize vertex data to empty strings.
  }

  /**
   * Adds an undirected edge between the given vertices. Updates the adjacency matrix to reflect the
   * connection.
   *
   * @param u The first vertex of the edge.
   * @param v The second vertex of the edge.
   */
  public void addEdge(int u, int v) {
    if (u >= 0 && u < size && v >= 0 && v < size) {
      this.adjMatrix[u][v] = 1; // Create edge u -> v.
      this.adjMatrix[v][u] = 1; // Create edge v -> u (undirected graph).
    }
  }

  /**
   * Associates data with a vertex. Useful for storing labels or additional properties for vertices.
   *
   * @param vertex The vertex index.
   * @param data The data to associate with the vertex.
   */
  public void addVertexData(int vertex, String data) {
    if (vertex >= 0 && vertex < size) {
      this.vertexData[vertex] = data; // Store vertex data.
    }
  }

  /**
   * Prints the adjacency matrix and vertex data of the graph. Useful for debugging or visualizing
   * the graph structure.
   */
  public void printGraph() {
    System.out.println("Adjacency Matrix:");
    for (int[] row : adjMatrix) {
      System.out.println(Arrays.toString(row)); // Print adjacency matrix row.
    }
    System.out.println("\nVertex Data:");
    for (int i = 0; i < size; i++) {
      System.out.println("Vertex " + i + ": " + vertexData[i]); // Print vertex data.
    }
  }

  void printConnections() {
    System.out.println("\nConnections for each vertex:");
    for (int i = 0; i < vertexData.length; i++) {
      System.out.print(vertexData[i] + ": ");
      for (int j = 0; j < vertexData.length; j++) {
        if (adjMatrix[i][j] == 1) {
          System.out.print(vertexData[j] + " ");
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    // Create a graph with 4 vertices.
    UndirectedGraph2 g = new UndirectedGraph2(4);

    // Add labels (data) to each vertex.
    g.addVertexData(0, "A");
    g.addVertexData(1, "B");
    g.addVertexData(2, "C");
    g.addVertexData(3, "D");

    // Add edges to represent connections between vertices.
    g.addEdge(0, 1); // A - B
    g.addEdge(0, 2); // A - C
    g.addEdge(0, 3); // A - D
    g.addEdge(1, 2); // B - C

    // Print the graph to visualize its structure.
    g.printGraph();
    g.printConnections();
  }
}
