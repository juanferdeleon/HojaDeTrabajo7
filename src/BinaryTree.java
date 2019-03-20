import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * Generic class of a BinaryTree
 * @param <E>
 * @author Juanfer De Leon
 */
public class BinaryTree<E> {

    //Atributes
    Object node = null;
    BinaryTree left;
    BinaryTree right;

    /**
     * Constructor
     */
    public BinaryTree(){
    }

    /**
     * Constructor
     * @param node
     */
    public BinaryTree(Object node){
        this.node = node;
    }

    /**
     * Method that adds a node to the tree
     * @param newNode
     */
    public void insert(Object newNode){
        if (this.node == null){//If the tree is empty it creates a new one
            setNode(newNode);
        } else {
            if (newNode.toString().compareTo(node.toString()) < 0){
                if (left == null){
                    left = new BinaryTree();
                    left.insert(newNode);
                } else {
                    left.insert(newNode);
                }
            } else if (newNode.toString().compareTo(node.toString()) > 0){
                if (right == null){
                    right = new BinaryTree();
                    right.insert(newNode);
                } else {
                    right.insert(newNode);
                }
            }
// else if (newNode.toString().compareTo(node.toString()) == 0){
//                BinaryTree newTree = new BinaryTree(newNode);
//                right = new BinaryTree();
//                right = newTree;
//            }
        }
    }

    /**
     * Search
     * @param searchNode
     * @return
     */
    public Object search(Object searchNode){//Looks for the node
        if (this.node == searchNode){
            return this.node;
        } else {
            if (node.toString().compareTo(searchNode.toString()) == -1){
                left.search(searchNode);
            } else if (node.toString().compareTo(searchNode.toString()) == 1){
                right.search(searchNode);
            }
        }
        return null;
    }

    /**
     * Node Getter
     * @return node
     */
    public Object getNode() {
        return node;
    }

    /**
     * Node Setter
     * @param node
     */
    public void setNode(Object node) {
        this.node = node;
    }

    /**
     * Left BinaryTree Getter
     * @return Left BinaryTree
     */
    public BinaryTree getLeft() {
        return left;
    }

    /**
     * Left BinaryTree Setter
     * @param left
     */
    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    /**
     * Right BinaryTree Getter
     * @return Right BinaryTree
     */
    public BinaryTree getRight() {
        return right;
    }

    /**
     * Right BinaryTree Setter
     * @param right
     */
    public void setRight(BinaryTree right) {
        this.right = right;
    }
}
