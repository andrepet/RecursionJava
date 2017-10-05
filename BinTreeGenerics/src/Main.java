public class Main {
    public static void main(String[] args) {
        BinTree<String> binTree = new BinTree<>();
        binTree.put("Kalle");
        binTree.put("Anka");
        binTree.put("Örjan");
        binTree.put("Martin");
        binTree.put("Pelle");
        binTree.put("Alice");

        binTree.print();
        System.out.println();

        System.out.println("Martin: " + binTree.exist("Martin"));
        System.out.println("Kajsa: " + binTree.exist("Kajsa"));
    }
}

class Node <E extends Comparable<E>>{
    private E data;
    private Node<E> left;
    private Node<E> right;

    public Node(E data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public E getData(){
        return data;
    }

    public Node<E> getLeft(){
        return left;
    }

    public void setLeft(Node<E> node){
        left = node;
    }

    public Node<E> getRight(){
        return right;
    }

    public void setRight(Node<E> node){
        right = node;
    }

    public int compareTo(E otherData){
        return getData().compareTo( otherData );
    }
}

class BinTree<E extends Comparable<E>> {
    private Node<E> root;

    public BinTree(){
        this.root = null;
    }

    public void put(E data){
        this.root = this.putHelper(this.root, data);
    }

    public boolean exist(E data){
        boolean result = existHelper(this.root, data);
        return result;
    }

    public void print(){
        printHelper(this.root);
    }

    private Node<E> putHelper(Node<E> node, E data){
        if (node == null)
            return new Node<E>(data);
        if (node.compareTo(data) > 0 ){
            node.setLeft( putHelper(node.getLeft(), data) );
            return node;
        }
        else{
            node.setRight( putHelper(node.getRight(), data) );
            return node;
        }
    }

    private boolean existHelper(Node<E> node, E data){
        if (node == null) return false;
        if (node.compareTo(data) == 0) return true;
        if (node.compareTo(data) > 0){
            return existHelper(node.getLeft(), data);
        }
        else{
            return existHelper(node.getRight(), data);
        }
    }

    private void printHelper(Node<E> node){
        if (node == null) return;
        printHelper(node.getLeft());
        System.out.print(node.getData() + " ");
        printHelper(node.getRight());
    }

}