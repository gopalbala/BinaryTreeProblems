package com.gb.algoproblems.trees;

/**
 * Created by gbalasubramanian on 24/10/17.
 */
public class CheckBalanced {
    public static void main(String[] args) {

        BalancedTree balancedTree = new BalancedTree();

        balancedTree.root = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        //Node n6 = new Node(6);
        Node n7 = new Node(7);
        //Node n8 = new Node(8);

        balancedTree.root.left = n1;
        balancedTree.root.right = n2;

        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        //n3.right = n6;
        n5.right = n7;
        //n6.right = n8;

//        System.out.println("Left Height: " + balancedTree.height(balancedTree.root.left));
//        System.out.println("Right Height: " + balancedTree.height(balancedTree.root.right));

        System.out.println(balancedTree.checkBalanced(balancedTree.root));

        BalancedTree tree = new BalancedTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        //tree.root.left.left.left = new Node(8);

        System.out.println(balancedTree.checkBalanced(tree.root));

    }

    static class BalancedTree {
        Node root;

        int checkBalanced(Node node) {
            if (node == null)
                return 0;
            int lheight = checkBalanced(node.left);
            if (lheight == -1)
                return -1;
            int rheight = checkBalanced(node.right);
            if (rheight == -1)
                return -1;
            if (Math.abs(lheight - rheight) > 1) {
                return -1;
            }
            return Math.max(lheight, rheight) + 1;
        }

        int height(Node node) {
            if (node == null)
                return 0;
            int lheight = height(node.left);
            int rheight = height(node.right);

            int totalHeight = Math.max(lheight, rheight) + 1;
            return totalHeight;
        }
    }
}
