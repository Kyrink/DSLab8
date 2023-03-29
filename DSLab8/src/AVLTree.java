
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

}
