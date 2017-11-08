package com.gb.algoproblems.trees;

/**
 * Created by fax6 on 08/11/17.
 */
public class PrintNodesKDistanceFromLeaf {
    public static void main(String[] args) {
        Node A = new Node(100);
        //Level 1
        Node B = new Node(50);
        Node C = new Node(150);
        //Level 2
        Node D = new Node(25);
        Node E = new Node(75);
        Node F = new Node(125);
        Node G = new Node(175);
        //Level 3
        Node H = new Node(120);
        Node I = new Node(140);
        Node J = new Node(160);
        Node K = new Node(190);

        //connect Level 0 and 1
        A.left = B;
        A.right = C;
        //connect level 1 and level 2
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        //Connect level 2 and level 3
        F.left = H;
        F.right = I;
        G.left = J;
        G.right = K;

        int distance = 2;
        int data[]= new int[1024];
        boolean visit[]= new boolean[1024];
        kDistance(A,distance,0,data,visit);
    }

    static void kDistance(Node root,int distance, int index, int[] data, boolean[] visited){
        if (root == null)
            return;
        data[index] = root.data;
        visited[index] = false;
        if (root.left == null && root.right == null & visited[index-distance]== false && distance >= 0){
            System.out.println(data[index-distance]);
            visited[index-distance] =true;
        } else if(distance > 0){
            index++;
            kDistance(root.left,distance,index,data,visited);
            kDistance(root.right,distance,index,data,visited);
        }
        return;
    }
}
