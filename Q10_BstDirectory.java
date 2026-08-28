import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q10_BstDirectory {
    private static class Node{
        int value;
        Node left;
        Node right;
        Node (int value){
            this.value = value;
        }
    }
    private Node root;
    private int sizeCount;

    public Q10_BstDirectory(){
        this.root = null;
        this.sizeCount =0;
    }   
public boolean add(int value){
    if(root == null){
        root = new Node(value);
        sizeCount++;
        return true;
    }
    Node curr = root;
    while(true){
        if(value == curr.value){
            return false;
        }else if(value < curr.value){
            if(curr.left == null){
                curr.left = new Node(value);
                sizeCount++;
                return true;
            }
            curr = curr.left;
        }else {
        if(curr.right == null){
            curr.right = new Node(value);
            sizeCount++;
            return true;
        }
        curr = curr.right;
    }
}}
public boolean contains(int value){
    Node curr = root;
    while(curr != null){
        if(value == curr.value){
            return true;
        }else if(value < curr.value){
            curr = curr.left;
        }else{
            curr = curr.right;
        }
    }
    return false;
}
public int size(){
    return sizeCount;
}
public java.util.List<Integer> searchPath(int target){
    List<Integer> path = new ArrayList<>();
    Node curr = root;

    while(curr != null){
        path.add(curr.value);
        if(target == curr.value){
            break;
        }else if(target < curr.value){
            curr = curr.left;
        }else{
            curr= curr.right;
        }
    }
    return path;
}
public java.util.List<Integer> inorder(){
    List<Integer> result = new ArrayList<>();
    Deque<Node> stack = new ArrayDeque<>();
    Node curr = root;

    while(curr != null || !stack.isEmpty()){
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        result.add(curr.value);

        curr = curr.right;
    }
    return result;
}
public boolean isValid(){
    return isValidBST(root,null,null);    
}
private boolean isValidBST(Node node,Integer min,Integer max){
    if(node == null){
        return true;
    }
    if((min != null && node.value <= min)||(max != null &&node.value >=max)){
        return false;
    }
    return isValidBST(node.left, min, node.value)&&
    isValidBST(node.right,node.value,max);
}

public static void main(String[] args) {
    Q10_BstDirectory tree = new Q10_BstDirectory();
for (int value : new int[]{50, 30, 70, 20, 40, 60, 80}) tree.add(value);
System.out.println(tree.add(40));
System.out.println(tree.searchPath(60));
System.out.println(tree.searchPath(65));
System.out.println(tree.inorder());
System.out.println(tree.isValid());
}}
