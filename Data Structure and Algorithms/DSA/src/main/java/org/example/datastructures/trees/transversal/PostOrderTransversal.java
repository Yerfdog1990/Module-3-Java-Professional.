package org.example.datastructures.trees.transversal;

import org.example.datastructures.trees.binary.BalancedTree;

public class PostOrderTransversal {
  /*
   Post-order Traversal of a Binary Tree:
   Post-order traversal is a type of Depth First Search where each node is visited in the following order:
   1. Left subtree
   2. Right subtree
   3. Root node
   This traversal ensures that children nodes are visited before their parent. Common use cases include:
   - Deleting a tree
   - Evaluating postfix expressions (e.g., expression trees)

   Example:
       Tree:
               A
              / \
             B   C
                / \
               D   E

       Post-order traversal sequence: B, D, E, C, A
  */

  private void postOrderTraversal(BalancedTree node) {
    if (node == null) {
      return;
    }
    // Recursively traverse the left subtree
    postOrderTraversal(node.getLeft());

    // Recursively traverse the right subtree
    postOrderTraversal(node.getRight());

    // Visit and process the root node
    System.out.print(node.getData() + ", ");
  }

  public static void main(String[] args) {

    // Create tree node
    BalancedTree root = new BalancedTree("A");
    root.setLeft(new BalancedTree("B"));
    root.setRight(new BalancedTree("C"));
    root.getLeft().setLeft(new BalancedTree("D"));
    root.getLeft().setRight(new BalancedTree("E"));

    // Perform pre-order traversal and print nodes
    System.out.print("Post-order Traversal: ");
    PostOrderTransversal postOrderTransversal = new PostOrderTransversal();
    postOrderTransversal.postOrderTraversal(root);
  }
}
