package org.example.datastructures.trees.binary;

/*
A perfect tree is a type of binary tree in which all interior nodes have exactly two children
and all leaf nodes are at the same depth or level.

Key Features:
- All interior nodes have exactly 2 children.
- All leaf nodes are at the same level, making the tree completely balanced.

When is it Suitable:
- Optimal for scenarios where a completely balanced structure is required.
- Useful in applications involving static datasets where no insertions or deletions are needed after construction.
- Commonly found in applications like binary heaps and binary decision trees.

Strengths:
- Provides maximum number of nodes for a given height, ensuring efficient use of space.
- Guarantees the shortest possible tree height for the given number of nodes, minimizing search time.

Weaknesses:
- Inflexible structure, requiring all levels to be completely filled.
- Not suitable for dynamic datasets where insertions or deletions are frequent.

 */
public class PerfectTree {
  PerfectTree left;
  PerfectTree right;
  String data;

  PerfectTree(String data) {
    this.data = data;
    left = null;
    right = null;
  }

  public static void main(String[] args) {
    PerfectTree root = new PerfectTree("R");
    root.left = new PerfectTree("A");
    root.right = new PerfectTree("B");
    root.left.left = new PerfectTree("C");
    root.left.right = new PerfectTree("D");
    root.right.left = new PerfectTree("E");
    root.right.right = new PerfectTree("F");

    System.out.println("Root: " + root.data);
    System.out.println("Left child of root: " + root.left.data);
    System.out.println("Right child of root: " + root.right.data);
    System.out.println("Left child of left child of root: " + root.left.left.data);
    System.out.println("Right child of left child of root: " + root.left.right.data);
    System.out.println("Right child of right child of root: " + root.right.right.data);
    System.out.println("Left child of right child of root: " + root.right.left.data);
  }
}
