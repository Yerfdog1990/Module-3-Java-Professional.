package org.example.datastructures.trees.binary;

/*
A balanced tree is a type of binary tree in which the height difference between the left and right
subtrees of any node is not more than one. This ensures that the tree remains approximately balanced,
providing optimal performance for operations like search, insertion, and deletion.

Key Features:
- The height difference (balance factor) between left and right subtrees of any node is at most 1.
- Provides an efficient structure for operations that depend on tree height.

When is it Suitable:
- Ideal for use cases where the dataset is dynamically updated with frequent insertions or deletions.
- Useful in scenarios requiring consistent log(n) time complexity for search, insertion, and deletion operations.
- Effective for applications involving sorted data, such as databases, search engines, and dictionaries.

Strengths:
- Optimized time complexity for search, insertion, and deletion as O(log n).
- Ensures even distribution of data, avoiding skewness.

Weaknesses:
- Requires additional processing to re-balance the tree after insertions or deletions.
- May consume more memory due to storage of additional information (like height or balance factor).
*/

// Class to represent a node in the binary tree
public class BalancedTree {
  String data;
  BalancedTree left;
  BalancedTree right;

  // Constructor to initialize the node with data
  public BalancedTree(String data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public static void main(String[] args) {
    // Create tree nodes
    BalancedTree root = new BalancedTree("R");
    BalancedTree nodeA = new BalancedTree("A");
    BalancedTree nodeB = new BalancedTree("B");
    BalancedTree nodeC = new BalancedTree("C");
    BalancedTree nodeD = new BalancedTree("D");
    BalancedTree nodeE = new BalancedTree("E");
    BalancedTree nodeF = new BalancedTree("F");
    BalancedTree nodeG = new BalancedTree("G");

    // Build the tree structure
    root.left = nodeA;
    root.right = nodeB;

    nodeA.left = nodeC;
    nodeA.right = nodeD;

    nodeB.left = nodeE;
    nodeB.right = nodeF;

    nodeF.left = nodeG;

    // Test case: Print the data of the left child of the right child of the root
    System.out.println("Root: " + root.data);
    System.out.println("Left child of root: " + root.left.data);
    System.out.println("Right child of root: " + root.right.data);
    System.out.println("Left child of left child of root: " + root.left.left.data);
    System.out.println("Right child of left child of root: " + root.left.right.data);
    System.out.println("Right child of right child of root: " + root.right.right.data);
    System.out.println(
        "Left child of right child of right child of root: " + root.right.right.left.data);
  }
}
