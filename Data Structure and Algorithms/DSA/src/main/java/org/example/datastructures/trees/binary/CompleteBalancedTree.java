package org.example.datastructures.trees.binary;

/*
A complete tree is a type of binary tree in which every level, except possibly the last, is fully filled,
and all nodes in the last level are positioned as far left as possible.

Key Features:
- All levels except the last are fully filled.
- Nodes at the last level are aligned to the left, creating a well-structured tree.

When is it Suitable:
- Best for scenarios requiring efficient storage and quick access, such as heaps or priority queues.
- Useful in applications where tree traversal is frequent and needs to be predictable.

Strengths:
- Provides efficient indexing and traversal opportunities.
- Operations like insertion and deletion can often be performed in O(log n) due to its structured nature.

Weaknesses:
- May require additional computation to maintain its completeness during dynamic insertions or deletions.
- Can be less memory efficient compared to other tree structures if incompletely populated.

*/
public class CompleteBalancedTree {
  CompleteBalancedTree left;
  CompleteBalancedTree right;
  String data;

  CompleteBalancedTree(String data) {
    this.data = data;
    left = null;
    right = null;
  }

  public static void main(String[] args) {
    CompleteBalancedTree root = new CompleteBalancedTree("R");
    root.left = new CompleteBalancedTree("A");
    root.right = new CompleteBalancedTree("B");
    root.left.left = new CompleteBalancedTree("C");
    root.left.right = new CompleteBalancedTree("D");
    root.right.left = new CompleteBalancedTree("E");
    root.right.right = new CompleteBalancedTree("F");

    System.out.println("Root: " + root.data);
    System.out.println("Left child of root: " + root.left.data);
    System.out.println("Right child of root: " + root.right.data);
    System.out.println("Left child of left child of root: " + root.left.left.data);
    System.out.println("Right child of left child of root: " + root.left.right.data);
    System.out.println("Right child of right child of root: " + root.right.right.data);
    System.out.println("Left child of right child of root: " + root.right.left.data);
  }
}
