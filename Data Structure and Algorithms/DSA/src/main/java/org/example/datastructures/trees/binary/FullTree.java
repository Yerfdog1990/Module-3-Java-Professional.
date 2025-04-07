package org.example.datastructures.trees.binary;

/*
A full tree is a type of binary tree in which every node has either 0 or 2 children.
It is a specific type of tree that guarantees a highly structured and predictable form.

Key Features:
- All nodes have either 0 or 2 children; no node has only one child.
- The tree is perfectly balanced in this manner but does not guarantee height balancing.

When is it Suitable:
- Useful in scenarios where data needs a structured binary relationship.
- Effective in cases where static and complete tree organization is required for specific processes, like binary heap management.

Strengths:
- Predictable structure makes traversal easier.
- Eliminates scenarios with uneven node distribution, ensuring every data element at a level has equal depth.

Weaknesses:
- May lead to inefficiency in height growth if balance is not enforced.
- Requires more careful structuring during construction to enforce 'fullness.'
 */
public class FullTree {
  FullTree left;
  FullTree right;
  String data;

  FullTree(String data) {
    this.data = data;
    left = null;
    right = null;
  }

  public static void main(String[] args) {
    FullTree root = new FullTree("R");
    root.left = new FullTree("A");
    root.right = new FullTree("B");
    root.left.left = new FullTree("C");
    root.left.right = new FullTree("D");
    root.right.left = new FullTree("E");
    root.right.right = new FullTree("F");

    System.out.println("Root: " + root.data);
    System.out.println("Left child of root: " + root.left.data);
    System.out.println("Right child of root: " + root.right.data);
    System.out.println("Left child of left child of root: " + root.left.left.data);
    System.out.println("Right child of left child of root: " + root.left.right.data);
    System.out.println("Right child of right child of root: " + root.right.right.data);
    System.out.println("Left child of right child of root: " + root.right.left.data);
  }
}
