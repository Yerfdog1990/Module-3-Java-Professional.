package org.example.datastructures.graphs.implementation;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Demo {
  private final List<String> vertexData;
  private final int[][] adjacencyMatrix;

  private static List<String> printVertexData(List<String> nodeData) {
    System.out.println("Vertex Data: " + nodeData);
    return nodeData;
  }

  private static int[][] printAdjacencyMatrix(int[][] array) {
    System.out.println("\nAdjacency Matrix:");
    for (int[] row : array) {
      System.out.println(Arrays.toString(row));
    }
    return array;
  }

  private void printConnections() {
    System.out.println("\nConnections for each vertex:");
    for (int i = 0; i < vertexData.size(); i++) {
      System.out.print(vertexData.get(i) + ": ");
      for (int j = 0; j < vertexData.size(); j++) {
        if (adjacencyMatrix[i][j] == 1) {
          System.out.print(vertexData.get(j) + " ");
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    List<String> nodeData = List.of("A", "B", "C", "D");
    int[][] adjacencyMatrix = new int[][] {{0, 1, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}, {1, 0, 0, 0}};
    Demo demo = new Demo(nodeData, adjacencyMatrix);
    printVertexData(demo.vertexData);
    printAdjacencyMatrix(demo.adjacencyMatrix);
    demo.printConnections();
  }
}
