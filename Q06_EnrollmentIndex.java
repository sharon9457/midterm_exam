import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

public class Q06_EnrollmentIndex {
    private final Map<String,Set<String>> index;
    public Q06_EnrollmentIndex(){
        this.index = new TreeMap<>();
    }
    
    private boolean isBlank(String str){
        return str == null || str.trim().isEmpty();
        
    }
    
    public boolean enroll(String courseCode, String studentId){
        if(isBlank(courseCode) || isBlank(studentId)){
            return false;}
        

        Set<String> students = index.computeIfAbsent(courseCode, k -> new TreeSet<>());
   return students.add(studentId);
 }
public boolean drop(String courseCode, String studentId){
    if(isBlank(courseCode) || isBlank(studentId)){
        return false;
    }
    Set<String> students = index.get(courseCode);
    if(students == null){
        return false;
    }
    boolean removed = students.remove(studentId);
    if(removed && students.isEmpty()){
        index.remove(courseCode);
    }
    return removed;
}
public int courseSize(String courseCode){
    if(isBlank(courseCode)){
        return 0;
    }
    Set<String> students = index.get(courseCode);
    return(students == null)?0:students.size();
}
public java.util.List<String> studentsOf(String courseCode){
    if(isBlank(courseCode) || !index.containsKey(courseCode)){
        return new ArrayList<>();
    }
    return new ArrayList<>(index.get(courseCode));
}
public java.util.List<String> coursesOf(String studentId){
    List<String> courses = new ArrayList<>();
    if(isBlank(studentId)){
        return courses;
    }
    for(Map.Entry<String,Set<String>> entry:index.entrySet()){
        if(entry.getValue().contains(studentId)){
            courses.add(entry.getKey());
        }
    }
    return courses;
}
public java.util.Map<String, Integer> summary(){
    Map<String,Integer> result = new TreeMap<>();
    for(Map.Entry<String,Set<String>>entry:index.entrySet()){
        result.put(entry.getKey(), entry.getValue().size());
    }
    return result;
}public static void main(String[] args) {
    Q06_EnrollmentIndex index = new Q06_EnrollmentIndex();
    index.enroll("MIS", "001");
    index.enroll("MIS", "001");
    index.enroll("資料結構","001");
    System.out.println(index.studentsOf("MIS"));
    System.out.println(index.coursesOf("001"));
    System.out.println(index.summary());
}
}
