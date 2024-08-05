// Time Complexity:- O(n)
public class DiameterofTree2 {
    static class Node {
        int data;
        Node left;
        Node right;
 
 
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
 
 
    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]); 
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
            
        }
        
    }
 
    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
 
 
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static int diameter(Node root) {
        if(root == null) {
            return 0;
        }
 
 
        int diam1 = height(root.left) + height(root.right) + 1;
        int diam2 = diameter(root.left);
        int diam3 = diameter(root.right);
 
 
        return Math.max(diam1, Math.max(diam2, diam3));
    }
 static class TreeInfo{
    int ht;
    int diam;
    TreeInfo(int ht, int diam){
        this.ht = ht;
        this.diam = diam;
    }
 }
 public static TreeInfo diameter2(Node root) {
    if(root == null) {
        return new TreeInfo(0, 0);
    }


    TreeInfo left = diameter2(root.left);
    TreeInfo right = diameter2(root.right);


    int myHeight = Math.max(left.ht, right.ht) + 1;


    int diam1 = left.ht + right.ht + 1;
    int diam2 = left.diam;
    int diam3 = right.diam;


    int myDiam = Math.max(diam1, Math.max(diam2, diam3));


    return new TreeInfo(myHeight, myDiam);
}

 
    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
       
        Node root = tree.buildTree(nodes);
        System.out.println(diameter2(root).diam); 
    }
 }
 
 
 