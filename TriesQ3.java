public class TriesQ3 {
    static class Node {
        Node[] children = new Node[26];
        boolean eow; // end of word

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // O(n)
        int level = 0;
        int len = word.length();
        int idx = 0;

        Node curr = root;
        for (; level < len; level++) {
            idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key) { // O(n)
        int level = 0;
        int len = key.length();
        int idx = 0;

        Node curr = root;
        for (; level < len; level++) {
            idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    
    public static void buildTrie(String str) {
        //insert all suffixes to Trie
        root = new Node();
        for(int i=0; i<str.length(); i++) {
            insert(str.substring(i));
        }
    }
 
 
    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }
 
 
        int count = 0;
        for(int i=0; i<26; i++) {
            if(root.children[i] != null) {
                count+= countNodes(root.children[i]);
            }
        }
        return 1+count; //extra one for the self node
    }
 
 
    public static String ans = "";
 
    public static void main(String args[]) {
        String str = "ababa"; 
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }
       
        System.out.println(countNodes(root));
    }
}
