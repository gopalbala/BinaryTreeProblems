package com.gb.algoproblems.trees;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by fax6 on 24/10/17.
 */
@Getter
@Setter
public class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
    }
}
