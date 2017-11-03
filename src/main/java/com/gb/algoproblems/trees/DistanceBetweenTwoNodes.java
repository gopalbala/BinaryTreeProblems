package com.gb.algoproblems.trees;

import java.util.Stack;

/**
 * Created by gbalasubramanian on 25/10/17.
 */
public class DistanceBetweenTwoNodes {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        DistanceBetweenNodes distanceBetweenNodes = new DistanceBetweenNodes();
        distanceBetweenNodes.root = root;

        System.out.println(distanceBetweenNodes.findDist(root, 4, 5));
    }

    static class DistanceBetweenNodes {
        Node root;

        static int h = 0;

        int findDist(Node root, int a, int b) {
            int d1 = distanceOfNode(root, a, 0);
            int d2 = distanceOfNode(root, b, 0);
            Node lca = LCA(root, a, b);
            int d3 = distanceOfNode(root, lca.data, 0);
            int minDist = d1 + d2 - 2 * d3;
            return minDist;
        }

        int distanceOfNode(Node node, int data, int level) {
            if (node == null)
                return -1;
            if (node.data == data)
                return level;

            int lddist = distanceOfNode(node.left, data, level + 1);
            int rdist = distanceOfNode(node.right, data, level + 1);

            if (lddist != -1)
                return lddist;
            else
                return rdist;
        }

        Node LCA(Node node, int n1, int n2) {
            // Your code here
            if (node == null) {
                return null;
            }

            if (node.data == n1 || node.data == n2) {
                return node;
            }
            // Your code here
            Node leftLca = LCA(node.left, n1, n2);
            Node rightLca = LCA(node.right, n1, n2);

            if (leftLca != null && rightLca != null) {
                return node;
            }
            if (leftLca == null) {
                return rightLca;
            } else {
                return leftLca;
            }
        }
    }
}
