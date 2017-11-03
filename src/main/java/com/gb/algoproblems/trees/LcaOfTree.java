package com.gb.algoproblems.trees;

/**
 * Created by gbalasubramanian on 25/10/17.
 */
public class LcaOfTree {
    public static void main(String[] args) {
        Lca tree = new Lca();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;

        Node n = tree.LCA(tree.root,10,14);

        System.out.println(n.data);

        n= tree.LCA(tree.root,14,8);
        System.out.println(n.data);


        n = tree.LCA(tree.root,10,22);
        System.out.println(n.data);

    }
    static class Lca{
        Node root;

        Node LCA(Node node, int n1,int n2)
        {
            // Your code here
            if (node == null){
                return null;
            }

            if (node.data == n1 || node.data == n2){
                return node;
            }
            // Your code here
            Node leftLca = LCA(node.left,n1,n2);
            Node rightLca = LCA(node.right,n1,n2);

            if (leftLca!=null && rightLca!=null){
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

/*
1
2
20 8 L 20 22 R 8 L 4 8 R 12 12 L 10 12 R 14
10 22
 */
