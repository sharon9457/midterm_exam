public class Q03_EmployeePayroll {
public static abstract class Employee {
    private final String id;
    private final String name;
protected Employee(String id, String name){
    this.id = id;
    this.name = name;
}
public String getId(){
    return id;
}
public String getName(){
    return name;
}
public abstract int monthlyPay();
public String summary(){

}
}
public static class SalariedEmployee extends Employee {
    private final String id;
    private final String name;
    private final int salary;
public SalariedEmployee(String id, String name, int salary){
    this.id = id;
    this.name = name;
    this.salary = Math.max(0, salary);
}
@Override public int monthlyPay(){

}
}
public static class HourlyEmployee extends Employee {
public HourlyEmployee(String id, String name, int hours, int hourlyRate){

}
@Override public int monthlyPay(){

}
}
public static int totalPayroll(java.util.List<Employee> employees){
    
}
}
