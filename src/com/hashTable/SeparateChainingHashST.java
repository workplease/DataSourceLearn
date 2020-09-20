package com.hashTable;

import java.sql.SQLClientInfoException;

public class SeparateChainingHashST<Key,Value> {

    private int N;//键值对总数
    private int M;//散列表的大小
    private SeparateChainingHashST<Key,Value>[] st;//存放链表数据对象的数组

    public SeparateChainingHashST(){
        this(997);
    }

    /**
     * 创建M条链表
     * @param M
     */
    public SeparateChainingHashST(int M){
        this.M = M;
        st =(SeparateChainingHashST<Key, Value>[]) new SeparateChainingHashST[M];
        for (int i = 0;i < M;i++) {
            st[i] = new SeparateChainingHashST();
        }
    }

    private int hash(Key key){
        return (key.hashCode() & 0xfffffff) % M;
    }

    public Value get(Key key){
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key,Value value){
        st[hash(key)].put(key,value);
    }
}
