package org.example.datastructures.graphs.implementation;

import java.util.Arrays;
import java.util.List;

public class UndirectedGraph {
  private List<String> vertexData; // Store vertex labels
  private int[][] adjacencyMatrix; // Store adjacency relationships

  // Constructor to initialize vertexData and adjacencyMatrix
  public UndirectedGraph() {
    vertexData = Arrays.asList("A", "B", "C", "D");
    adjacencyMatrix =
        new int[][] {
          {0, 1, 1, 1}, // Edges for A
          {1, 0, 1, 0}, // Edges for B
          {1, 1, 0, 0}, // Edges for C
          {1, 0, 0, 0} // Edges for D
        };
  }

  // Method to print the adjacency matrix
  public void printAdjacencyMatrix() {
    System.out.println("\nAdjacency Matrix:");
    for (int[] row : adjacencyMatrix) {
      System.out.println(Arrays.toString(row));
    }
  }

  // Method to print vertex data
  public void printVertexData() {
    System.out.println("Vertex Data: " + vertexData);
  }

  // Main method
  public static void main(String[] args) {
    UndirectedGraph graph = new UndirectedGraph();
    graph.printVertexData();
    graph.printAdjacencyMatrix();
  }
}
