package com.graph;

/**
 * 加权重的无向图
 */
public class EdgeWeightedGraph {

    private final int V;//顶点总数
    private int E;//边的总数
    private Bag<Edge>[] adj;//邻接表

    public EdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0;v < V;v++){
            adj[v] = new Bag<Edge>();
        }
    }

    public int E(){
        return E;
    }

    public int V(){
        return V;
    }

    public void addEdge(Edge e){
        int v = e.either(),w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        Bag<Edge> b = new Bag<Edge>();
        for (int v = 0;v < V;v++){
            for (Edge e:adj[v]){
                if (e.other(v) > v) b.add(e);
            }
        }
        return b;
    }
}
