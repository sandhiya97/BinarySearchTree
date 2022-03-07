package BinarySearchTree;

public class BinarySearchTree<K extends Comparable<K>> {

	private BinaryNode<K> root;

    /**
     * add - method to add new values to the tree
     *
     * @param key - value to be added to the tree
     */
    public void add(K key) {
        this.root = this.addRecursively(root, key);
    }

    /**
     *
     * addRecursively - method to call frequently till the new node is placed in our tree
     *
     * @param current - current node to which new nodes are to be added either left or right side
     * @param key - value of the new node to be added to tree
     * @return current node
     */
    private BinaryNode<K> addRecursively(BinaryNode<K> current, K key){
        /*
        current will be null if tree is not having any nodes
        so a new node will be created and considered as root node to the tree
         */
        if(current == null)
            return new BinaryNode<>(key);

        /*
        compareResult will store the comparison between value of new node and current node
        based on the result, new node will be placed to left or right of current node
        if both are same value, it'll return current node directly
         */
        int compareResult = key.compareTo(current.key);
        if(compareResult == 0) return current;
        if(compareResult < 0){
            current.left = addRecursively(current.left, key);
        } else {
            current.right = addRecursively(current.right, key);
        }
        return current;
    }

    /**
     *
     * getSize - method to find the number of nodes in tree
     *
     * @return number of elements in the tree
     */
    public int getSize(){
        return this.getSizeRecursively(root);
    }

    /**
     * getSizeRecursively - method to calculate size of tree recursively
     * @param current - current node
     * @return count of elements
     */
    private int getSizeRecursively(BinaryNode<K> current) {
        return current == null ? 0 : 1 + this.getSizeRecursively(current.left)
                                       + this.getSizeRecursively(current.right);
    }


}
