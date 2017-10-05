public class TestBinTree {
    public static void main(String[] args) {
        BinTree binTree = new BinTree();

//        binTree.root = new Node(5);
//        binTree.root.left = new Node(2);
//        binTree.root.right = new Node(8);
//        binTree.root.left.right = new Node(3);
//        binTree.root.left.left = new Node(1);
//        binTree.root.right.left = new Node(6);
        binTree.put(5);
        binTree.put(2);
        binTree.put(8);
        binTree.put(3);
        binTree.put(1);
        binTree.put(6);

        System.out.println("Utskrift av trädet...");
        binTree.print();
        System.out.println("\n");

        System.out.println("Finns 6: " + binTree.exist(6));
        System.out.println("Finns 8: " + binTree.exist(8));
        System.out.println("Finns 4: " + binTree.exist(4));

    }
}

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

class BinTree {
    public Node root;

    public BinTree(){
        this.root = null;
    }

    public void put(int data){
//        this.root = this.putHelper(this.root, data);
        if (root == null) root = new Node(data);
        else
            this.putHelper2(this.root, data);
    }

    private void putHelper2(Node node, int data) {
        if (data < node.data){
            if (node.left == null){
                node.left = new Node(data);
            }
            else{
                putHelper2(node.left, data);
            }
        }
        else{
            if (node.right == null){
                node.right = new Node(data);
            }
            else{
                putHelper2(node.right, data);
            }
        }
    }

    private Node putHelper(Node node, int data){

        if (node == null) return new Node(data);
        if (data < node.data){
            node.left = putHelper(node.left, data);
            return node;
        }
        else{
            node.right = putHelper(node.right, data);
            return node;
        }
    }





    public boolean exist(int data){
        boolean result = existHelper(this.root, data);
        return result;
    }

    private boolean existHelper(Node node, int data){
        if (node == null) return false;
        if (node.data == data) return true;
        if (data < node.data){
            return existHelper(node.left, data);
        }
        else{
            return existHelper(node.right, data);
        }

    }

    public void print(){
        printHelper(this.root);
    }

    private void printHelper(Node node){
        if (node == null) return;
        printHelper(node.left);
        System.out.print(node.data + " ");
        printHelper(node.right);

    }

}