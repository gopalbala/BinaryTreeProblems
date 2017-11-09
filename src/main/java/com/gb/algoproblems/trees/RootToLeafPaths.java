package com.gb.algoproblems.trees;

/**
 * Created by fax6 on 09/11/17.
 */
public class RootToLeafPaths {
    public static void main(String[] args) {
        Node A = new Node(100);
        // Level 1
        Node B = new Node(50);
        Node C = new Node(150);
        // Level 2
        Node D = new Node(25);
        Node E = new Node(80);
        Node F = new Node(125);
        Node G = new Node(160);

        // connect Level 0 and 1
        A.left = B;
        A.right = C;
        // connect level 1 and level 2
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        printRootToLeafPath(A, 0, new int[100]);
    }

    static void printRootToLeafPath(Node root, int index, int[] path) {
        if (root == null)
            return;
        path[index] = root.data;
        if (root.left == null && root.right == null) {
            for (int i = 0; i <= index; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
        }
        printRootToLeafPath(root.left, index + 1, path);
        printRootToLeafPath(root.right, index + 1, path);
    }
}
