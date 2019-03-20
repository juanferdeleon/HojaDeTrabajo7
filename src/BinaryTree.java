import javax.naming.NamingEnumeration;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.Comparator;
import java.util.Objects;

/**
 * Generic class of a BinaryTree
 * @param <E>
 */
public class BinaryTree<E> {

    //Atributes
    Object node;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(){
        node = null;
        left = null;
        right = null;
    }

    public BinaryTree(Object node){
        this.node = node;
    }

    public void insert(Object newNode){
        if (this.node == null){//If the tree is empty it creates a new one
            setNode(newNode);
        } else {
            if (node.toString().compareTo(newNode.toString()) == -1){
                left.insert(newNode);
            } else if (node.toString().compareTo(newNode.toString()) == 1){
                right.insert(newNode);
            } else if (node.toString().compareTo(newNode.toString()) == 0){
                BinaryTree newTree = new BinaryTree(newNode);
                right = newTree;
            }
        }
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
