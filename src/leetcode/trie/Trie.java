class TrieNode {
    
    private char c;
    private boolean isLeaf;
    private TrieNode[26] children = new TrieNode[26];
    
    public TrieNode() {
    }

    public TrieNode(char c, boolean leaf) {
        this.c = c;
        this.isLeaf = leaf;
    }
}

public class Trie {
    
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.isEmpty())
            return;
            
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            
            char c = word.charAt(i);
            if (cur.children[ c - 'a'] == null)
                cur.children[ c-'a'] = new TrieNode(c, i == word.length() -1 );
            
            cur = cur.children[c-'a'];
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.isEmpty() )
            return false;
            
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            
            char c = word.charAt(i);
            if (cur.children[ c - 'a'] == null)
                return false;
                
            if ( i == word.length() - 1 && cur.children[c-'a'].isLeaf())
                return true;
                
            cur = cur.children[c-'a'];
        }
        
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    
    public boolean startsWith(String prefix) {
        
        if (word == null || word.isEmpty() )
            return false;
            
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            
            char c = word.charAt(i);
            if (cur.children[ c - 'a'] == null)
                return false;
            cur = cur.children[c-'a'];
        }
        
        return true;        
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
