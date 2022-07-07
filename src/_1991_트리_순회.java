import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1991_트리_순회 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Map<String, Node> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String val = Character.toString('A' + i);
            nodes.put(val, new Node(val, null, null));
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String currVal = st.nextToken();
            String leftVal = st.nextToken();
            String rightVal = st.nextToken();

            Node currNode = nodes.get(currVal);
            if (!leftVal.equals(".")) {
                currNode.setLeft(nodes.get(leftVal));
            }
            if (!rightVal.equals(".")) {
                currNode.setRight(nodes.get(rightVal));
            }
        }

        Node root = nodes.get("A");
        System.out.println(Node.preorder(root));
        System.out.println(Node.inorder(root));
        System.out.println(Node.postorder(root));
    }
}

class Node {
    private final String val;
    private Node left;
    private Node right;

    Node(String val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    boolean setLeft(Node left) {
        this.left = left;
        return true;
    }

    boolean setRight(Node right) {
        this.right = right;
        return true;
    }

    static String preorder(Node curr) {
        if (curr == null || curr.val.equals("")) {
            return "";
        }

        return curr.val + preorder(curr.left) + preorder(curr.right);
    }

    static String inorder(Node curr) {
        if (curr == null || curr.val.equals("")) {
            return "";
        }

        return inorder(curr.left) + curr.val + inorder(curr.right);
    }

    static String postorder(Node curr) {
        if (curr == null || curr.val.equals("")) {
            return "";
        }

        return postorder(curr.left) + postorder(curr.right) + curr.val;
    }
}
