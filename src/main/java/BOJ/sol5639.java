package BOJ;

import java.io.*;
import java.util.*;

public class sol5639 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()), null, null);
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.isEmpty()) {
                break;
            }
            insert(root, Integer.parseInt(input));
        }
        postOrder(root);

    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key);
    }

    public static void insert(Node root, int n) {
        if (root.key > n) {
            if (root.left == null) {
                root.left = new Node(n, null, null);
            } else {
                insert(root.left, n);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(n, null, null);
            } else {
                insert(root.right, n);
            }
        }
    }

    public static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

}
