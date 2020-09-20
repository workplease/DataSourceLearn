package com.graph;

import java.util.Stack;

/**
 * 无环加权有向图的最短路径算法
 */
public class AcyclicSP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph G,int s){
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for (int v = 0;v < G.V();v++){
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
    }
}
