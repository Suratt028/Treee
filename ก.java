
class Node {
    char data;
    int left;
    int right;

    Node(char data) {
        this.data = data;
        this.left = -1;
        this.right = -1;
    }
}

public class Main {
    Node[] tree;
    int root;

    public Main(int size) {
        tree = new Node[size];
        root = -1;
    }

    public void setRoot(char key) {
        tree[0] = new Node(key);
        root = 0;
    }

    public void setLeft(int parent, char key) {
        int index = findNextAvailableIndex();
        if (index != -1) {
            tree[index] = new Node(key);
            tree[parent].left = index;
        } else {
            System.out.println("Tree is full. Cannot insert " + key);
        }
    }

    public void setRight(int parent, char key) {
        int index = findNextAvailableIndex();
        if (index != -1) {
            tree[index] = new Node(key);
            tree[parent].right = index;
        } else {
            System.out.println("Tree is full. Cannot insert " + key);
        }
    }

    public int findNextAvailableIndex() {
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == null) {
                return i;
            }
        }
        return -1; // If the tree is full
    }

    public void inorderTraversal(int nodeIndex) {
        if (nodeIndex == -1 || tree[nodeIndex] == null) {
            return;
        }
        inorderTraversal(tree[nodeIndex].left);
        System.out.print(tree[nodeIndex].data + " ");
        inorderTraversal(tree[nodeIndex].right);
    }

    public void preorderTraversal(int nodeIndex) {
        if (nodeIndex == -1 || tree[nodeIndex] == null) {
            return;
        }
        System.out.print(tree[nodeIndex].data + " ");
        preorderTraversal(tree[nodeIndex].left);
        preorderTraversal(tree[nodeIndex].right);
    }

    public void postorderTraversal(int nodeIndex) {
        if (nodeIndex == -1 || tree[nodeIndex] == null) {
            return;
        }
        postorderTraversal(tree[nodeIndex].left);
        postorderTraversal(tree[nodeIndex].right);
        System.out.print(tree[nodeIndex].data + " ");
    }

    public void levelOrderTraversal() {
        for (Node node : tree) {
            if (node != null) {
                System.out.print(node.data + " ");
            }
        }
    }

    public static void main(String[] args) {
        Main tree = new Main(10);
        tree.setRoot('A');
        tree.setLeft(0, 'B');
        tree.setRight(0, 'C');
        tree.setLeft(1, 'D');
        tree.setRight(1, 'E');
        tree.setLeft(2, 'F');
        tree.setRight(2, 'G');
        tree.setLeft(3, 'H');
        tree.setRight(3, 'I');
        tree.setLeft(4, 'J');

        System.out.print("Inorder Traversal: ");
        tree.inorderTraversal(tree.root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        tree.preorderTraversal(tree.root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        tree.postorderTraversal(tree.root);
        System.out.println();

        System.out.print("Level Order Traversal: ");
        tree.levelOrderTraversal();
        System.out.println();
    }
}

