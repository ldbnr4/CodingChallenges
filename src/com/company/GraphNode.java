package com.company;

import java.util.ArrayList;

/**
 * Created by boyice on 9/1/2016.
 *
 */
class GraphNode {
    int data;
    ArrayList<GraphNode> edges;

    GraphNode(){}

    GraphNode(int data){
        this.data = data;
        this.edges = new ArrayList<>();
    }
}
