package com.graph;

/**
 * 最小生成树的Prim算法的实现
 */
public class LazyPrimMST {

    private boolean[] marked;//最小生成树的顶点
    private Queue<Edge> mst;//最小生成树的边
    private MinPQ<Edge> pq;//横切边（包括失效的边）

    public LazyPrimMST(EdgeWeightedGraph G){
        pq = new MinPQ<Edge>(G.V());
        marked = new boolean[G.V()];
        mst = new Queue<Edge>();
        //假设G是连通的
        visit(G,0);
        while (!pq.isEmpty()){
            Edge e = pq.delMin();//从pq中得到权重最小的边
            int v = e.either(),w = e.other(v);
            if (marked[v] && marked[w]) continue;//跳过失效的边
            mst.enqueue(e);//将边添加到树中
            if (!marked[v]) visit(G,v);//将顶点（v或w）添加到树中
            if (!marked[w]) visit(G,w);
        }
    }

    /**
     * 标记顶点v并将所有连接v和未被标记顶点的边加入pq
     * @param G
     * @param v
     */
    private void visit(EdgeWeightedGraph G,int v){
        marked[v] = true;
        for (Edge e:G.adj(v)){
            if (!marked[e.other(v)]) pq.insert(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }
}
