package org.example.datastructures.trees.transversal;

import org.example.datastructures.trees.binary.BalancedTree;

public class PreOrderTransversal {
  /*
  Pre-order Traversal is done by visiting the root node first, then recursively performing a pre-order traversal of the left subtree, followed by a pre-order traversal of the right subtree.
  This traversal is "pre" order because the node is visited "before" the recursive traversal of the left and right subtrees.
  It is commonly used for creating a copy of the tree, prefix notation of an expression tree, etc.

  How it works:
  - The first node visited and printed is the root node (R) as the traversal starts at the root.
  - It then recursively traverses the left subtree before moving to the right subtree. For example:
      - After visiting R, it prints node A, then C (left child of A), followed by D (right child of A).
      - Once the left subtree of A is fully traversed, it moves to the right subtree, printing B, E, and F sequentially.
  - The traversal stops and propagates back when a leaf node or a null node (no child) is reached.

  For example, in the given tree:
          R
        /   \
       A     B
      / \   / \
     C   D E   F

  The nodes are visited in this order: R, A, C, D, B, E, F.
  */
  // Method to perform pre-order traversal
  public static void preOrderTraversal(BalancedTree node) {
    if (node == null) {
      return;
    }
    System.out.print(node.getData() + ", "); // Visit the root node
    preOrderTraversal(node.getLeft()); // Traverse the left subtree
    preOrderTraversal(node.getRight()); // Traverse the right subtree
  }

  public static void main(String[] args) {
    // Create tree nodes
    BalancedTree root = new BalancedTree("R");
    root.setLeft(new BalancedTree("A"));
    root.setRight(new BalancedTree("B"));
    root.getLeft().setLeft(new BalancedTree("C"));
    root.getLeft().setRight(new BalancedTree("D"));
    root.getRight().setLeft(new BalancedTree("E"));
    root.getRight().setRight(new BalancedTree("F"));

    // Perform pre-order traversal and print nodes
    System.out.print("Pre-order Traversal: ");
    preOrderTraversal(root);
  }
}
