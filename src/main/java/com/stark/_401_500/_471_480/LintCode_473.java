package com.stark._401_500._471_480;

/**
 * Created by Stark on 2017/10/2.
 * 设计一个包含下面两个操作的数据结构：addWord(word), search(word)
 * addWord(word)会在数据结构中添加一个单词。
 * 而search(word)则支持普通的单词查询或是只包含.和a-z的简易正则表达式的查询。
 * 一个 . 可以代表一个任何的字母。
 * 你可以假设所有的单词都只包含小写字母 a-z。
 */
public class LintCode_473 {

    private DicTree dicTree = new DicTree();

    public void addWord(String word) {
        // write your code here
        char[] chars = word.toCharArray();
        DicTree dic = this.dicTree;
        for (char c : chars) {
            DicTree[] children = dic.children;
            dic = children[c - 'a'];
            if (dic == null) {
                dic = new DicTree();
                dic.val = c;
                children[c - 'a'] = dic;
            }
        }
        dic.end = true;
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        char[] chars = word.toCharArray();
        for (DicTree dic : this.dicTree.children) {
            if (resolve(dic, chars, 0)) {
                return true;
            }
        }

        return false;
    }

    private boolean resolve(DicTree dic, char[] chars, int i) {
        if (dic == null) return false;
        char cur = chars[i];
        if(cur==dic.val||cur=='.'){
            if(i==chars.length-1){
                return dic.end;
            }else {
                for (DicTree child : dic.children) {
                    if (resolve(child, chars, i+1)) {
                        return true;
                    }
                }
            }
        }else {
            return false;
        }
        return false;
    }

    class DicTree {
        public char val = '0';
        public DicTree[] children = new DicTree[26];
        public boolean end = false;
    }

    public static void main(String[] args) {
        LintCode_473 test = new LintCode_473();
        test.addWord("a");
        test.addWord("avasd");
        test.addWord("abvasdc");
        System.out.println(test.search(".v..d"));

    }
}
