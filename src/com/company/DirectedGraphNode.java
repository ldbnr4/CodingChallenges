package com.company;

import java.util.ArrayList;

/**
 * Created by boyice on 9/1/2016.
 *
 */
class DirectedGraphNode extends GraphNode{

    private ArrayList<DirectedGraphNode> incomingNodes, outgoingNodes;

    public DirectedGraphNode(int data){
        super(data);
        this.incomingNodes = this.outgoingNodes = new ArrayList<>();
    }

    DirectedGraphNode(String graphString){
        super();
        String[] split = graphString.split(" ");
        Integer x = null, y = null;
        ArrayList<Integer> list = new ArrayList<>();
        for (String aSplit : split) {
            if (x == null) x = Integer.parseInt(aSplit);
            else if (y == null) {
                y = Integer.parseInt(aSplit);
                if(!list.contains(x)) list.add(x);
                if(!list.contains(y)) list.add(y);
                DirectedGraphNode fromNode = new DirectedGraphNode(x);
                DirectedGraphNode toNode = new DirectedGraphNode(y);
            }
        }
    }

    public void addIncoming(DirectedGraphNode node){incomingNodes.add(node);}

    public void addOutgoing(DirectedGraphNode node){outgoingNodes.add(node);}
}
