import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q09_TreeTraversal {
public static class Node {
public int value;
public Node left;
public Node right;
public Node(int value){
this.value = value;
}
}
public static java.util.List<Integer> preorder(Node root){
    List<Integer>result = new ArrayList<>();
    if(root == null) return result;

    result.add(root.value);
    result.addAll(preorder(root.left));
    result.addAll(preorder(root.right));

    return result;
}
public static java.util.List<Integer> inorder(Node root){
    List<Integer>result = new ArrayList<>();
    if(root == null)return result;
    
    result.addAll(inorder(root.left));
    result.add(root.value);
    result.addAll(inorder(root.right));

    return result;
}
public static java.util.List<Integer> postorder(Node root){
    List<Integer> result = new ArrayList<>();
    if(root == null)return result;

    result.addAll(postorder(root.left));
    result.addAll(postorder(root.right));
    result.add(root.value);
    
    return result;
}
public static java.util.List<Integer> levelOrder(Node root){
    List<Integer> result = new ArrayList<>();
    if(root == null){
        return result;
    }
    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(root);

    while(!queue.isEmpty()){
        Node current = queue.poll();
        result.add(current.value);

        if(current.left != null){
            queue.offer(current.left);
        }if(current.right != null){
            queue.offer(current.right);
        }
    }
    return result;
}
public static void main(String[] args) {
    Node root = new Node(8);
    root.left = new Node(4);
    root.right = new Node(12);
    root.left.left = new Node(2);
    root.left.right = new Node(6);
    root.right.right = new Node(14);

    System.out.println("preorder = " + preorder(root));
    System.out.println("inorder ="+inorder(root));
    System.out.println("postorder = "+postorder(root));
    System.out.println("level ="+levelOrder(root));
}}
