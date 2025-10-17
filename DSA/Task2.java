// ==============================
// Task 2: Binary Search Tree
// ==============================

public class Task2 {

    // Node structure for BST
    static class Node {
        int key;
        Node left, right;

        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static class BST {
        Node root;

        // Insert a key into BST
        Node insert(Node root, int key) {
            if (root == null) {
                return new Node(key);
            }
            if (key < root.key) {
                root.left = insert(root.left, key);
            } else if (key > root.key) {
                root.right = insert(root.right, key);
            }
            return root;
        }

        // Search a key in BST
        Node search(Node root, int key) {
            if (root == null || root.key == key)
                return root;
            if (key < root.key)
                return search(root.left, key);
            return search(root.right, key);
        }

        // Inorder Traversal (Left, Root, Right)
        void inorder(Node root) {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.key + " ");
                inorder(root.right);
            }
        }

        // Preorder Traversal (Root, Left, Right)
        void preorder(Node root) {
            if (root != null) {
                System.out.print(root.key + " ");
                preorder(root.left);
                preorder(root.right);
            }
        }

        // Postorder Traversal (Left, Right, Root)
        void postorder(Node root) {
            if (root != null) {
                postorder(root.left);
                postorder(root.right);
                System.out.print(root.key + " ");
            }
        }

        // Bonus: Delete a node
        Node delete(Node root, int key) {
            if (root == null) return root;

            if (key < root.key) {
                root.left = delete(root.left, key);
            } else if (key > root.key) {
                root.right = delete(root.right, key);
            } else {
                // Node with only one child or no child
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;

                // Node with two children: Get inorder successor (smallest in right subtree)
                root.key = minValue(root.right);

                // Delete the inorder successor
                root.right = delete(root.right, root.key);
            }
            return root;
        }

        int minValue(Node root) {
            int minVal = root.key;
            while (root.left != null) {
                minVal = root.left.key;
                root = root.left;
            }
            return minVal;
        }
    }

    // ==== Main to test BST ====
    public static void main(String[] args) {
        BST bst = new BST();
        Node root = null;

        // Insert nodes
        int[] keys = {50, 30, 20, 40, 70, 60, 80};
        for (int k : keys) {
            root = bst.insert(root, k);
            System.out.println("Inserted: " + k);
        }

        // Traversals
        System.out.print("\nInorder Traversal: ");
        bst.inorder(root);
        System.out.print("\nPreorder Traversal: ");
        bst.preorder(root);
        System.out.print("\nPostorder Traversal: ");
        bst.postorder(root);

        // Search
        int searchKey = 40;
        Node found = bst.search(root, searchKey);
        System.out.println("\n\nSearch for " + searchKey + ": " + (found != null ? "Found" : "Not Found"));

        // Delete
        int deleteKey = 50;
        root = bst.delete(root, deleteKey);
        System.out.println("\nDeleted node: " + deleteKey);

        // Traversal after deletion
        System.out.print("Inorder after deletion: ");
        bst.inorder(root);
        System.out.println();
    }
}
