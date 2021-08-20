package com.wzx.leetcode;

public class Leetcode208 {

    // 26 叉树?
    Leetcode208[] tries;
    int count;


    public static void main(String[] args) {
        Leetcode208 trie = new Leetcode208();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }

    /** Initialize your data structure here. */
    public Leetcode208() {
        tries = new Leetcode208[26];
        count = 0;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] words = word.toCharArray();
        Leetcode208 cur = this;
        for (int i = 0; i < words.length; i++) {
            if (cur.tries[words[i]-'a'] == null) {
                cur.tries[words[i]-'a'] = new Leetcode208();
            }
            cur = cur.tries[words[i]-'a'];
        }
        cur.count++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] words = word.toCharArray();
        Leetcode208 cur = this;
        for (int i = 0; i < words.length; i++) {
            cur = cur.tries[words[i]-'a'];
            if (cur == null) {
                return false;
            }
        }
        return cur.count != 0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] words = prefix.toCharArray();
        Leetcode208 cur = this;
        for (int i = 0; i < words.length; i++) {
            cur = cur.tries[words[i]-'a'];
            if (cur == null) {
                return false;
            }
        }
        return true;
    }
}
