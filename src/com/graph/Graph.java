package com.graph;

public class Graph {

    private final int V;//顶点数目
    private int E;//边的数目
    private Bag<Integer>[] adj;//邻接表

    public Graph(int V) {
        this.V = V;
        //创建邻接表
        adj = (Bag<Integer>[]) new Bag[V];
        //将所有链表初始化为空
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
        adj[v].add(w);//将w添加到v的链表中
        adj[w].add(v);//将v添加到w的链表中
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}
