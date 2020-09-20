package com.hashTable;

import com.sun.imageio.plugins.common.I18N;
import org.omg.CORBA.Object;

public class LinearProbingHashST<Key,Value> {

    private int N;//符号表中键值对的总数
    private int M = 16;//线性探测表的大小
    private Key[] keys;//键
    private Value[] values;//值

    public LinearProbingHashST(){
        this(16);
    }

    public LinearProbingHashST(int M){
        keys =(Key[]) new Object[M];
        values =(Value[]) new Object[M];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * 添加键值对
     * @param key
     * @param value
     */
    public void put(Key key,Value value){
        //键的数量大于等于表的一半，扩充表的大小
        if (N >= M/2) resize(2*M);
        int i;
        //如果该键存在于表中，将值更新
        for (i = hash(key);keys[i] != null;i = (i+1) % M){
            if (keys[i].equals(key)) values[i] = value;return;
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    /**
     * 动态修改数组的长度
     * @param cap
     */
    private void resize(int cap){
        LinearProbingHashST<Key,Value> t;
        t = new LinearProbingHashST<Key,Value>(cap);
        for (int i = 0;i < M;i++){
            if (keys[i] != null)
                t.put(keys[i],values[i]);
        }
        keys = t.keys;
        values = t.values;
        M = t.M;
    }

    /**
     * 获得该健对应的数值
     * @param key
     * @return
     */
    public Value get(Key key){
        for (int i = hash(key);keys[i] != null;i = (i+1) % M){
            if (keys[i].equals(key)) return values[i];
        }
        return null;
    }

    /**
     * 是否包含该键值
     * @param key
     * @return
     */
    private boolean contains(Key key){
        for (int i = 0;i < keys.length;i++){
            if (key.equals(keys[i])) return true;
        }
        return false;
    }

    /**
     * 删除键key对应的值
     * @param key
     */
    public void delete(Key key){
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i])){
            i = (i+1) % M;
        }
        keys[i] = null;
        values[i] = null;
        i = (i+1) % M;
        while (keys[i] != null){
            Key keyToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRedo,valueToRedo);
            i = (i+1) % M;
        }
        N--;
        if (N > 0 && N == M/8) resize(M/2);
    }
}
