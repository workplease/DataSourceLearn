package com.String;

public class RabinKarp {

    private String pat;//模式字符串
    private long patHash;//模式字符串的散列值
    private int M;//模式字符串的长度
    private long Q = 997;//一个很大的素数
    private int R = 256;//字母表的大小
    private long RM;//R^(M-1)%Q

    public RabinKarp(String pat){
        this.pat = pat;//保存模式字符串
        this.M = pat.length();
        RM = 1;
        for (int i = 1;i <= M-1;i++){
            RM = (R*RM) % Q;//计算R^(M-1)%Q,用于减去第一个数时的计算
        }
        patHash = hash(pat,M);
    }

    /**
     * 用于除余数法计算散列值
     * @param key
     * @param M
     * @return
     */
    private long hash(String key,int M){
        long h = 0;
        for (int j = 0;j < M;j++)
            h = (R*h + key.charAt(j)) % Q;
        return h;
    }

    /**
     * 对于拉斯维加斯算法，检查模式与txt(i...i-M+1)的匹配
     * @param j
     * @return
     */
    public boolean check(int j){
        return true;
    }

    /**
     * 在文本中查找相等的散列值
     * @param txt
     * @return
     */
    private int search(String txt){
        int N = txt.length();
        long txtHash = hash(txt,M);
        if (patHash == txtHash && check(0)) return 0;//一开始匹配成功
        //减去第一个数字，加上最后一个数字，再次检查匹配
        for (int i = M;i < N;i++){
            txtHash = (txtHash + Q - RM * txt.charAt(i-M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if (patHash == txtHash){
                if (check(i - M + 1)) return i - M + 1;//找到匹配
            }
        }
        return N;//未找到匹配
    }
}
