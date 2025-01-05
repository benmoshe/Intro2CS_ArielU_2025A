/**
 * Author: Avi Rahimov
 * This class contains solutions to various exercises from week 10.
 */
package Tirgul.week10_questions;

public class TreeNode_Before_Solutions {
    int value;
    TreeNode_After_Solutions left, right;

    // Constructor to initialize the node with a value
    public TreeNode_Before_Solutions(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // Method to set the left child
    public void setLeft(TreeNode_After_Solutions left) {
        this.left = left;
    }

    // Method to set the right child
    public void setRight(TreeNode_After_Solutions right) {
        this.right = right;
    }

    // Method to get the left child
    public TreeNode_After_Solutions getLeft() {
        return this.left;
    }

    // Method to get the right child
    public TreeNode_After_Solutions getRight() {
        return this.right;
    }

    // Method to get the value of the node
    public int getValue() {
        return this.value;
    }

    // Method to check if the current node is a leaf (no children)
    public boolean isLeaf() {
        return (this.left == null && this.right == null);
    }

    // Method to print the node (for debugging or visualization)
    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}

