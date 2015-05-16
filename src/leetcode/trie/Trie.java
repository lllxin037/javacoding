class TrieNode {
    
    private char c;
    private boolean isLeaf;
    
    public TrieNode() {
    }
    
    public TrieNode(char c) {
        this(c, false);
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
        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
