
public class Q08_RecursiveAudit {

    public static int sumValid(int[] data, int index){
        if(data == null||index>=data.length){
            return 0;
        }
        if(index <0){
            index =0;
        }
        int current = data[index];
        if(current >=0 && current <=100){
            return current + sumValid(data, index+1);
        }else{
            return sumValid(data, index+1);
        }}
        
        
public static int countOccurrences(int[] data, int index, int target){
    if(data == null  ||index>=data.length){
        return 0;
    }
    if(index <0){
        index =0;
    }
    if(data[index] == target){
        return 1 + countOccurrences(data, index+1, target);
    }else{
        return countOccurrences(data, index+1, target);
    }

}
public static boolean isPalindrome(String text, int left, int right){
    if(text == null){
        return false;
    }
    if(left >=right){
        return true;
    }
    char leftchar = Character.toLowerCase((text.charAt(left)));
    char rightchar = Character.toLowerCase(text.charAt(right));
    if(leftchar != rightchar){
        return false;
    }
    return isPalindrome(text, left+1, right -1);
}
public static void main(String[] args) {
    int[] data = {10, -1, 20, 101, 20};
System.out.println(Q08_RecursiveAudit.sumValid(data, 0));
System.out.println(Q08_RecursiveAudit.countOccurrences(data, 0, 20));
System.out.println(Q08_RecursiveAudit.isPalindrome("Level", 0, 4));
}
}
