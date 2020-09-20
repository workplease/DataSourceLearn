package com.String;

public class KMP {

    private String pat;
    private int[][] dfa;

    /**
     * 由模式字符串构造DFA
     * @param pat
     */
    public KMP(String pat){
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int x = 0,j = 1;j < M;j++){
            for (int c = 0;c < R;c++){
                //复制匹配失败情况下的值
                dfa[c][j] = dfa[c][x];
            }
            //设置匹配成功情况下的值
            dfa[pat.charAt(j)][j] = j+1;
            //更新重启状态
            x = dfa[pat.charAt(j)][x];
        }
    }

    /**
     *模拟DFA处理文本txt时的操作
     * @param txt
     * @return
     */
    public int search(String txt,String pat){
        int i,j,N = txt.length(),M = pat.length();
        for (i = 0,j = 0;i < N && j < M;i++){
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) return i - M;//找到匹配（到达模式字符串的结尾）
        else return N;//未找到匹配（到达文本字符串的结尾）
    }
}
