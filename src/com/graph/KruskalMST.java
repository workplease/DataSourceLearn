package com.graph;

public class KruskalMST {

    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G){
        mst = new Queue<Edge>();
        MinPQ<Edge> pq = new MinPQ<Edge>(G.V());
        for (Edge e:G.edges()) pq.insert(e);
        UF uf = new UF(G.V());

        while (!pq.isEmpty() && mst.size() < G.V()-1){
            Edge e = pq.delMin();//从pq得到权重最小的边和它的顶点
            int v = e.either(),w = e.other(v);
            if (uf.connected(v,w)) continue;//忽略失效的边
            uf.union(v,w);//合并分量
            mst.enqueue(e);//将边添加到最小生成树中
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }
}
