package com.stark._401_500._441_450;

/**
 * Created by Stark on 2017/12/8.
 */
public class LintCode_442 {

    DicTree tree;

    public LintCode_442() {
        // do intialization if necessary
        tree = new DicTree(0);
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        if (word == null) return;
        if (word.isEmpty()) {
            tree.end = true;
            return;
        }
        insert(0, word, tree);
    }

    private void insert(int deep, String word, DicTree tree) {
        char c = word.charAt(deep);
        int index = c - 'a';
        DicTree[] trees = tree.trees;
        if (trees[index] == null) trees[index] = new DicTree(deep + 1);
        if (word.length() - 1 == deep) {
            trees[index].end = true;
        } else {
            insert(deep + 1, word, trees[index]);
        }
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        return search(word, tree, true);
    }

    private boolean search(String word, DicTree tree, boolean b) {
        if (word.length() == tree.deep) {
            if (b)
                return b & tree.end;
            else return true;
        }
        int index = word.charAt(tree.deep) - 'a';
        DicTree[] trees = tree.trees;
        if (trees[index] == null) return false;
        else return search(word, trees[index], b);
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        return search(prefix, tree, false);
    }

    class DicTree {
        int deep;
        DicTree[] trees = new DicTree[26];
        boolean end;

        DicTree(int deep) {
            this.deep = deep;
        }
    }
}
