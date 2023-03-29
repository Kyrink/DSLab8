
public class AVLTree {
    private class Node {
        int value, height;
        Node left, right;

        public Node(int value) {
            this.value = value;
            height = 1;
        }
    }

    private Node root;
    
    // Helper methods for balancing the tree
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return y;
    }
    
    private Node rightRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;
        x.left = y;
        y.right = T2;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return y;
    }
    


}
