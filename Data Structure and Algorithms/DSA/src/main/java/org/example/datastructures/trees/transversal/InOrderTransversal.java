package org.example.datastructures.trees.transversal;

import org.example.datastructures.trees.binary.BalancedTree;

public class InOrderTransversal {
  /*
  In-order Traversal of Binary Trees
  In-order Traversal is a type of Depth First Search where each node is visited in a specific sequence:
  1. Recursively traverse the left subtree.
  2. Visit the current (root) node.
  3. Recursively traverse the right subtree.

  This traversal is especially useful in Binary Search Trees (BSTs) as it retrieves data in sorted (ascending) order.

  Explanation:
  - The "in" in In-order Traversal signifies that the node is visited after traversing its left subtree and before traversing its right subtree.
  - For example, consider the following binary tree:

          R
        /   \
       A     B
      / \   / \
     C   D E   F

      - Starting at the root node R:
        - Traverse the left subtree rooted at A:
          - Visit the left child of A (C).
          - Visit A.
          - Visit the right child of A (D).
        - Visit R.
        - Traverse the right subtree rooted at B:
          - Visit the left child of B (E).
          - Visit B.
          - Visit the right child of B (F).
      - Result: C, A, D, R, E, B, F

  Implementation:
  The traversal follows a recursive approach:
  - Start at the root node and call the function recursively on the left child until a leaf node is reached.
  - Visit the current node and print its data.
  - Continue by calling the function recursively on the right child.

  The implementation below prints the nodes in the described sequence.
  */
  // Method to perform in-order traversal
  public static void inOrderTraversal(BalancedTree node) {
    if (node == null) {
      return;
    }
    inOrderTraversal(node.getLeft()); // Traverse the left subtree
    System.out.print(node.getData() + ", "); // Visit the root node
    inOrderTraversal(node.getRight()); // Traverse the right subtree
  }

  public static void main(String[] args) {
    // Create tree nodes and set up the tree
    BalancedTree root = new BalancedTree("R");
    root.setLeft(new BalancedTree("A"));
    root.setRight(new BalancedTree("B"));
    root.getLeft().setLeft(new BalancedTree("C"));
    root.getLeft().setRight(new BalancedTree("D"));
    root.getRight().setLeft(new BalancedTree("E"));
    root.getRight().setRight(new BalancedTree("F"));

    // Perform in-order traversal and print nodes
    System.out.print("In-order Traversal: ");
    inOrderTraversal(root);
  }
}
