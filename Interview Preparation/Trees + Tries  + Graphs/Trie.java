import java.util.*;                                                               // import dependencies

// Initiating TrieNode Class
class TrieNode {
    boolean isEndOfWord;                                                          // represents end of word
    Map<Character, TrieNode> children;                                            // used to store each character of trie

    // Create TrieNode Constructor
    TrieNode(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;                                           // initialise end of word
        this.children = new HashMap<>();                                          // initialise hashmap
    }
}

// Initiating Trie Class
public class Trie {
    private TrieNode root;                                                         // creating root in tree

    // Create Trie Constructor
    public Trie() {
        root = new TrieNode(true);                                      // creating new node in tree at root
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;                                                               // if string is empty, return nothing
        }
        TrieNode parent = root;                                                   // creating new node in tree (parent)
        for (int i = 0; i < word.length(); i++) {                                 // iterate through chars of word and save to variable 'cur'
            char cur = word.charAt(i);

            TrieNode child = parent.children.get(cur);                            // assigning 'child' node to current char in word
            if (child == null) {
                child = new TrieNode(false);                           // if word (char loop) doesn't exist in tree, create new node
                parent.children.put(cur, child);                                  // insert letter at child node
            }
            parent = child;                                                       // navigate to next level (next node)
        }
        parent.isEndOfWord = true;                                                // current node is now leaf (end of word)
    }

    /** Returns true if the word is in the trie. */
    public boolean search(String word) {
        if (word == null) {                                                       // if string is empty, return false
            return false;
        }
        TrieNode parent = root;                                                   // creating new node in tree (parent)
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);                                            // iterate through chars of word and save to variable 'cur'

            TrieNode child = parent.children.get(cur);                            // assigning 'child' node to current char in word
            if (child == null) {                                                  // if word (char loop) doesn't exist in tree, return false
                return false;
            }
            parent = child;                                                       // navigate to next level (next node)
        }
        return parent.isEndOfWord;                                                // current node is now leaf (end of word)
    }

    /** Returns true if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null) {                                                     // if string is empty, return false
            return false;
        }
        TrieNode parent = root;                                                   // creating new node in tree (parent)
        for (int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);                                          // iterate through chars of word and save to variable 'cur'

            TrieNode child = parent.children.get(cur);                            // assigning 'child' node to current char in word
            if (child == null) {                                                  // if prefix (char loop) doesn't exist in tree, return false
                return false;
            }
            parent = child;                                                       // navigate to next level (next node)
        }
        return true;                                                              // current node is now leaf (end of word)
    }

    /** Deletes a word from the trie if present, and return true if the word is deleted successfully. */
    public boolean delete(String word) {
        if (word == null || word.length() == 0) {                                 // if string is empty, return false
            return false;
        }
        TrieNode deleteBelow = null;                                              // All nodes below 'deleteBelow' and on the path
        char deleteChar = '\0';                                                   // starting with 'deleteChar' (including itself) will be deleted if needed

        TrieNode parent = root;                                                   // creating new node in tree (parent)
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);                                            // iterate through chars of word and save to variable 'cur'

            TrieNode child = parent.children.get(cur);                            // assigning 'child' node to current char in word
            if (child == null) {                                                  // if prefix (char loop) doesn't exist in tree, return false
                return false;
            }

            if (parent.children.size() > 1 || parent.isEndOfWord) {              // update 'deleteBelow' and 'deleteChar'
                deleteBelow = parent;
                deleteChar = cur;
            }

            parent = child;                                                     // navigate to next level (next node)
        }

        if (!parent.isEndOfWord) {
            return false;                                                       // word isn't in trie
        }

        if (parent.children.isEmpty()) {
            deleteBelow.children.remove(deleteChar);                            // remove char of word until word deleted
        }
        else {
            parent.isEndOfWord = false;                                         // delete word by mark it as not the end of a word
        }

        return true;                                                            // current node is now leaf (end of word)
    }

    // CALLING METHOD: RESULT
    public static void main(String args[]) {
        Trie trie = new Trie();                                                 // creating tree

        trie.insert("techie");                                            // insert 'techie' in trie
        trie.insert("techi");                                             // insert 'techi' in trie

        System.out.println(trie.search(("techie")));                           // OUTPUT: true
        System.out.println(trie.search(("techi")));                            // OUTPUT: true

        trie.delete("techie");                                           // delete 'techie' in trie

        System.out.println(trie.search(("techo")));                           // OUTPUT: false: 'techo' not in trie
        System.out.println(trie.startsWith(("tec")));                         // OUTPUT: true: 'tec' is a prefix of word in trie
    }
}