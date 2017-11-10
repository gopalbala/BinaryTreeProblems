package com.gb.algoproblems.trees;

import java.util.Arrays;

/**
 * Created by gbalasubramanian on 10/11/17.
 */

public class MaximumSumRootToLeafPath {
    static int max =0;
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
        int sum = 0;// max = 0;

        maximumSum(A, 0, new int[100], sum);
        System.out.println(max);
    }

    static void maximumSum(Node root, int index, int[] array, int sum) {
        if (root == null)
            return;
        array[index] = root.data;
        sum += root.data;
        if (root.left == null && root.right == null) {
            if (sum > max) {
                max = sum;
            }
            return;
        }
        maximumSum(root.left, index + 1, array, sum);
        maximumSum(root.right, index + 1, array, sum);
    }
}
