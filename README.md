AVL Tree Implementation in Java

This is a Java implementation of the AVL Tree data structure. The AVL Tree is a self-balancing binary search tree that guarantees a worst-case time complexity of O(log n) for common operations such as search, insertion, and deletion.

Contributors

Abbas Jabor (add method, getHeight)
Seth Tedder (print method, getBalance,)
Kyrin Kalonji (leftRotate, rightRotate, Main method)

AVLTree Class

The AVLTree class defines the AVL tree data structure and provides methods for adding nodes and printing the contents of the tree.

AVLTree.Node Class
This is a nested class used for the AVL tree node. It stores the key value of the node, its height, and the left and right children nodes.

Helper Methods

getHeight(Node node) - Returns the height of the given node. If the node is null, returns 0.
getBalance(Node node) - Returns the balance factor of the given node. If the node is null, returns 0.
leftRotate(Node x) - Performs a left rotation on the given node and its children, and returns the new root node of the subtree.
rightRotate(Node y) - Performs a right rotation on the given node and its children, and returns the new root node of the subtree.

Public Methods

add(int value) - Adds a new node with the given value to the AVL tree by calling the private add(Node node, int value) method.
print() - Returns a string containing all the information in the AVL tree.

Testing

The main method contains four tests of the AVL tree implementation.
Test 1: Right rotation (RR)
Test 2: Left rotation (LL)
Test 3: Left-right rotation (LR)
Test 4: Right-left rotation (RL)
Each test creates a new AVLTree instance, adds some nodes, and prints the contents of the tree.

How to Use

Download the AVLTree.java file and save it in your Java project directory.
Import the AVLTree class into your Java program.
Create a new AVLTree instance: AVLTree tree = new AVLTree();
Add nodes to the tree using the add method: tree.add(5);
Print the contents of the tree using the print method: System.out.println(tree.print());
