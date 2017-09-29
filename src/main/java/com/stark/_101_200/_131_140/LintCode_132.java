package com.stark._101_200._131_140;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Stark on 2017/9/28.
 * 给出一个由小写字母组成的矩阵和一个字典。
 * 找出所有同时在字典和矩阵中出现的单词。
 * 一个单词可以从矩阵中的任意位置开始，可以向左/右/上/下四个相邻方向移动
 */
public class LintCode_132 {
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> res = new ArrayList<>();
        //简历字典树
        TreeDic dic = new TreeDic('0');
        for(String word:words){
            updateTreeDic(dic,word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        TreeDic[] children = dic.children;
        for(TreeDic child : children){
            if(child==null) continue;
            char c = child.var;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]==c){
                        List<String > word = resolv(board,visited,child,m,n,i,j);
                        for (String s :word){
                            if(!res.contains(s)){
                                res.add(s);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private List<String> resolv(char[][] board, boolean[][] visited, TreeDic dic, int m, int n, int i, int j) {
        List<String> res = new ArrayList<>();
        TreeDic[] children = dic.children;
        if(dic.word!=null){
            res.add(dic.word);
        }
        visited[i][j] = true;
        if(i+1<m&&!visited[i+1][j]){
            char right = board[i+1][j];
            if(children[right-'a']!=null){
                res.addAll(resolv(board,visited,children[right-'a'],m,n,i+1,j));
            }
            
        }
        if(i-1>-1&&!visited[i-1][j]){
            char left = board[i-1][j];
            if(children[left-'a']!=null){
                res.addAll(resolv(board,visited,children[left-'a'],m,n,i-1,j));
            }
        }
        if(j+1<n&&!visited[i][j+1]){
            char down = board[i][j+1];
            if(children[down-'a']!=null){
                res.addAll(resolv(board,visited,children[down-'a'],m,n,i,j+1));
            }
        }
        if(j-1>-1&&!visited[i][j-1]){
            char up = board[i][j-1];
            if(children[up-'a']!=null){
                res.addAll(resolv(board,visited,children[up-'a'],m,n,i,j-1));
            }
        }
        visited[i][j] = false;
        return res;
    }

    //更新字典树
    public void updateTreeDic(TreeDic dic,String word) {
        for(char c : word.toCharArray()){
            TreeDic[] arr = dic.children;
            int num = c-'a';
            if(arr[num]==null){
                dic = new TreeDic(c);
                arr[num] = dic;
            }else {
                dic = arr[num];
            }
        }
        dic.word = word;
    }

    class TreeDic {
        private char var;
        private TreeDic[] children = new TreeDic[26];
        private String word;
        TreeDic(char var){
            this.var = var;
        }
    }
    public static void main(String[] args) {
        LintCode_132 test = new LintCode_132();
        List<String> list = new ArrayList<>();
        //"dog", "dad", "dgdg", "can", "again"
        list.add("dog");
        list.add("dad");
        list.add("dgdg");
        list.add("can");
        list.add("again");
        char[][] chars = new char[3][];
        chars[0] = "doaf".toCharArray();
        chars[1] = "agai".toCharArray();
        chars[2] = "dcan".toCharArray();
        List<String> list1 = test.wordSearchII(chars, list);
        System.out.println(list1);
    }
}


