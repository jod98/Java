// Initiating Node Class
class Node {
    int value;                                                                        // value to be inserted
    Node left;                                                                        // leftChild node
    Node right;                                                                       // rightChild node

    // Create Node Constructor
    Node (int value) {
        this.value = value;
        right = null;
        left = null;
    }
}

// Initiating Tree Class (BST)
public class Tree {
    private Node root;                                                                // creating root in tree

    // Create Binary Search Tree Constructor - Empty Tree
    Tree(){
        root = null;                                                                  // setting 'root'=null (empty tree)
    }

    // Insert Item
    public void insert(int value) {
        root = insertRec(root, value);                                                // calling recursive method to insert
    }

    // Insert Item (Recursive Method)
    private Node insertRec(Node current, int value) {
        if (current == null) {
            return new Node(value);                                                   // if currVal=null, insert new node with value
        }

        if (value < current.value) {
            current.left = insertRec(current.left, value);                            // if value<currVal, insert new node with value to left

        } else if (value > current.value) {
            current.right = insertRec(current.right, value);                          // if value>currVal, insert new node with value to right

        } else {
            return current;                                                           // else value already exists
        }
        return current;                                                               // return current value
    }

    // Delete Item
    public void delete(int value) {
        root = deleteRec(root, value);                                                // calling recursive method to delete
    }

    // Delete Item (Recursive Method)
    private Node deleteRec(Node current, int value) {
        if (current == null) {
            return null;                                                              // if currVal=null, return null
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;                                                          // no children, replace parent node with null
            }
            if (current.right == null) {
                return current.left;                                                  // one child only, replace parent node with left child
            }
            if (current.left == null) {
                return current.right;                                                 // one child only, replace parent node with right child
            }

            int smallestValue = findSmallestValue(current.right);                     // two children, tree re-organisation initiated
            current.value = smallestValue;                                            // smallest value replaced by soon to be deleted node
            current.right = deleteRec(current.right, smallestValue);                  // delete node from right sub-tree
            return current;
        }

        if (value < current.value) {
            current.left = deleteRec(current.left, value);                            // if val < currVal, delete left node
            return current;
        }
        current.right = deleteRec(current.right, value);                              // if val > currVal, delete right node
        return current;
    }

    // Finding Smallest Node of Node to be Deleted's Right Sub-Tree (Replace node to be deleted with this)
    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    // Find Item
    public boolean containsVal(int value) {
        return containsValRec(root, value);
    }

    // Find Item (Recursive Method)
    private boolean containsValRec(Node current, int value) {
        if (current == null) {
            return false;                                                             // if currVal=null, return false
        }
        if (value == current.value) {
            return true;                                                              // if val = currVal, return true
        }
        // Ternary Operator (?:) = boolean statement ? true result : false result
        return value < current.value
                ? containsValRec(current.left, value)                                 // recursively check leftChild
                : containsValRec(current.right, value);                               // recursively check rightChild
    }

    // Traverse InOrder
    public void traverseInOrder() {
        traverseInOrderRec(root);
    }

    // Traverse InOrder (Recursive Method) (left, root, right)
    private void traverseInOrderRec(Node node) {
        if (node != null) {
            traverseInOrderRec(node.left);                                            // visit leftChild
            System.out.print(" " + node.value);                                       // visit node
            traverseInOrderRec(node.right);                                           // visit rightChild
        }
    }

    // CALLING METHOD: RESULT
    public static void main(String args[]) {
        Tree tree = new Tree();                                                      // creating BST

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);                                                        // inserting '50' at root
        tree.insert(30);                                                        // inserting '30' at root
        tree.insert(20);                                                        // inserting '20' at root
        tree.insert(40);                                                        // inserting '40' at root
        tree.insert(70);                                                        // inserting '70' at root
        tree.insert(60);                                                        // inserting '60' at root
        tree.insert(80);                                                        // inserting '80' at root

        tree.delete(80);                                                        // delete '80'

        tree.traverseInOrder();                                                       // print inorder traversal of the BST (Depth First Search)
    }
}



