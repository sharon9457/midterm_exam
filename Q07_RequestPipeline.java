import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
public static boolean isBalanced(String text){
    if(text == null){
        return false;
    }
    Deque<Character> stack = new ArrayDeque<>();
    for(int x =0;x<text.length();x++){
        char y = text.charAt(x);
    
    if(y == '(' || y ==']'|| y =='{'){
        stack.push(y);
    }
    else if(c==')'||c==']'||c=='}'){
        char top = stack.pop();
        if((c==')'&&top !='(') ||(c == ']'&& top != '[')||(c== '}'&&top!= '{')){
            return false;
        }
    }
}return stack.isEmpty();
}
public static java.util.List<String> process(String[] commands){
    
}
