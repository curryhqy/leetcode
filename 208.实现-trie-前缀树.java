/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    private Trie[] chrilden;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        chrilden = new Trie[26];
        isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (cur.chrilden[index] == null) {
                cur.chrilden[index] = new Trie();
            }
            cur = cur.chrilden[index];
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPerfix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPerfix(prefix) != null;
    }

    private Trie searchPerfix(String perfix) {
        Trie node = this;
        for (int i = 0; i < perfix.length(); i++) {
            char ch = perfix.charAt(i);
            int index = ch - 'a';
            if (node.chrilden[index] == null) {
                return null;
            }
            node = node.chrilden[index];
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

