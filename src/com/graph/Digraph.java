package com.graph;

/**
 * 有向图
 */
public class Digraph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V){
        this.V = V;
        this.E = 0;
        adj =(Bag<Integer>[]) new Bag[V];
        for (int v = 0;v < V;v++){
            adj[v] = new Bag<Integer>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    /**
     * 所有边的方向相反
     * @return
     */
    public Digraph reverse(){
        Digraph R = new Digraph(V);
        for (int v = 0;v < V;v++){
            for (int w : adj(v))
                R.addEdge(w,v);
        }
        return R;
    }
}
