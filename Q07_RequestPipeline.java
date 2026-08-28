import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
public class Q07_RequestPipeline {
public static boolean isBalanced(String text){
    if(text == null){
        return false;
    }
    Deque<Character> stack = new ArrayDeque<>();
    for(int x =0;x<text.length();x++){
        char y = text.charAt(x);
    
    if(y == '(' || y =='['|| y =='{'){
        stack.push(y);
    }
    else if(y==')'||y==']'||y=='}'){
        
        if(stack.isEmpty()){
            return false;
        }
        char top = stack.pop();
        if((y ==')'&& top != '(')||(y == ']'&&top !='[') ||(y=='}'&&top !='{')){
            return false;
        }
          }
}
return stack.isEmpty();
}
public static java.util.List<String> process(String[] commands){
    if(commands == null){
        return new ArrayList<>();
    }
    Deque<String>normalQueue = new ArrayDeque<>();
    Deque<String>urgentQueue = new ArrayDeque<>();
    List<String> result = new ArrayList<>();

    for(String cmd :commands){
        if(cmd == null || cmd.trim().isEmpty()){
            continue;
        }
        String[] parts = cmd.trim().split("\\s+");

        if(parts.length ==1 && parts[0].equals("PROCESS")){
            if(!urgentQueue.isEmpty()){
                result.add(urgentQueue.poll());
            }
            else if(!normalQueue.isEmpty()){
               result.add(normalQueue.poll());
            }
            else{
                result.add("EMPTY");
            }}
        else if(parts.length == 2 && parts[0].equals("NORMAL")){

            normalQueue.offer(parts[1]);
        }
        else if(parts.length ==2 &&parts[0].equals("NORMAL")){
            normalQueue.offer(parts[1]);
        }}
        return result;
    }
    public static void main(String[] args){
        String[] commands = {
"NORMAL N1", "URGENT U1", "NORMAL N2", "PROCESS", "PROCESS", "PROCESS"
};
System.out.println(Q07_RequestPipeline.isBalanced("a{b[c](d)}"));
System.out.println(Q07_RequestPipeline.isBalanced("([)]"));
System.out.println(Q07_RequestPipeline.process(commands));
    }}
    

