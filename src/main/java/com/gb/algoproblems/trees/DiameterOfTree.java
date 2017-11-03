package com.gb.algoproblems.trees;

/**
 * Created by gbalasubramanian on 24/10/17.
 */
public class DiameterOfTree {
    public static void main(String[] args) {
        TreeDiameter tree = new TreeDiameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The diameter of given binary tree is : "
                + tree.diameter(tree.root));

        System.out.println("The optimized diameter of given binary tree is : "
                + tree.diameterOptimized(tree.root, new Height()));
    }

    static class Height {
        int h;
    }

    static class TreeDiameter {
        Node root;

        public int diameter(Node node) {
            if (node == null)
                return 0;
            int lheight = height(node.left);
            int rheight = height(node.right);

            int ldia = diameter(node.left);
            int rdia = diameter(node.right);

            return Math.max(lheight + rheight + 1,
                    Math.max(ldia, rdia));

        }

        public int diameterOptimized(Node node, Height height) {
            Height lh = new Height();
            Height rh = new Height();
            if (node == null) {
                height.h = 0;
                return 0;
            }
            lh.h++;
            rh.h++;
            int ldia = diameterOptimized(node.left, lh);
            int rdia = diameterOptimized(node.right, rh);

            height.h = Math.max(ldia, rdia) + 1;
            return Math.max(lh.h + rh.h + 1, Math.max(ldia, rdia));

        }

        int height(Node node) {
            if (node == null)
                return 0;
            int lheight = height(node.left);
            int rheight = height(node.right);
            return Math.max(lheight, rheight) + 1;
        }
    }
}
