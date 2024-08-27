class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;
    int[] arrayTree;
    int maxSize;
    int currentSize;

    // Constructor สำหรับต้นไม้ที่เก็บข้อมูลแบบ Array และ Linked List
    public BinaryTree(int maxSize) {
        root = null;
        this.maxSize = maxSize;
        arrayTree = new int[maxSize];
        currentSize = 0;
    }

    // Method สำหรับการเพิ่มโหนดในต้นไม้
    void addNode(int data) {
        if (root == null) {
            root = new TreeNode(data);
            arrayTree[currentSize++] = data;
        } else {
            addNodeRecursive(root, data);
        }
    }

    private void addNodeRecursive(TreeNode node, int data) {
        if (data < node.data) {
            if (node.left == null) {
                node.left = new TreeNode(data);
                arrayTree[currentSize++] = data;
            } else {
                addNodeRecursive(node.left, data);
            }
        } else if (data > node.data) {
            if (node.right == null) {
                node.right = new TreeNode(data);
                arrayTree[currentSize++] = data;
            } else {
                addNodeRecursive(node.right, data);
            }
        }
    }

    // Method สำหรับการแสดงต้นไม้ในรูปแบบ Array
    void printArrayTree() {
        for (int i = 0; i < maxSize; i++) {
            if (arrayTree[i] != 0) {
                System.out.print(arrayTree[i] + " ");
            } else {
                System.out.print("- ");
            }
        }
        System.out.println();
    }

    // Method สำหรับการ Traversal แบบ InOrder
    void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(10);

        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);
        tree.addNode(2);
        tree.addNode(4);
        tree.addNode(6);
        tree.addNode(8);

        // แสดงข้อมูลแบบ Array
        System.out.println("Tree in Array form:");
        tree.printArrayTree();

        // Traversal แบบ InOrder
        System.out.println("InOrder Traversal:");
        tree.inOrderTraversal(tree.root);
    }
}
