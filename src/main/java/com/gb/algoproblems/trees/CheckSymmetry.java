package com.gb.algoproblems.trees;

/**
 * Created by fax6 on 24/10/17.
 */
public class CheckSymmetry {
    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        symmetricTree.root = new Node(0);
        Node n10 = new Node(1);
        Node n11 = new Node(1);
        Node n30 = new Node(3);
        Node n31 = new Node(3);
        Node n40 = new Node(4);
        Node n41 = new Node(4);
        Node n50 = new Node(5);
        Node n51 = new Node(5);

        symmetricTree.root.left = n10;
        symmetricTree.root.right = n11;

        n10.left = n30;
        n10.right = n40;

        n11.right = n31;
        n11.left = n41;

        n30.left = n50;
        n31.right = n51;

        System.out.println(symmetricTree.checkSymmetry(symmetricTree.root, symmetricTree.root));

    }

    static class SymmetricTree {
        Node root;

        public boolean checkSymmetry(Node node1, Node node2) {
            if (node1 == null && node2 == null)
                return true;
            if (node1 == null || node2 == null)
                return false;
            if (node1.data != node2.data)
                return false;
            return checkSymmetry(node1.left, node2.right) && checkSymmetry(node1.right, node2.left);
        }
    }
}
