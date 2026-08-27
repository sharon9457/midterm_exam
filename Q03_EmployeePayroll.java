public class Q03_EmployeePayroll {
public static abstract class Employee {
    private final String id;
    private final String name;
protected Employee(String id, String name){
    this.id = id;
    this.name = name;
    if(id == null||id.trim().isEmpty()){
        throw new IllegalArgumentException("false");
    }
    if(name == null |id.trim().isEmpty()){
        throw new IllegalArgumentException("false");
    }
}
public String getId(){
    return id;
}
public String getName(){
    return name;
}
public abstract int monthlyPay();
public String summary(){
return "員工編號"+this.id+"員工姓名:"+ this.name + "薪水:"+ this.monthlyPay();
}
}
public static class SalariedEmployee extends Employee {
    private final int salary;
public SalariedEmployee(String id, String name, int salary){
    super(id, name);
    this.salary = Math.max(0, salary);
    }
@Override public int monthlyPay(){
    return this.salary;
}
}
public static class HourlyEmployee extends Employee {
    private final int hours;
    private final int hourlyRate;
public HourlyEmployee(String id, String name, int hours, int hourlyRate){
    super(id, name);
    this.hours =Math.max(0, hourlyRate);
    this.hourlyRate = Math.max(0, hourlyRate);
}
@Override public int monthlyPay(){
    if(this.hours <= 160){
        return this.hours*this.hourlyRate;
    }else{
        int Pay = 160*hourlyRate;
        int overtime = this.hours -160;
        int over = (int)(overtime*this.hourlyRate *1.5);
        return Pay + overtime;
    }
}
}
public static int totalPayroll(java.util.List<Employee> employees){
    if(employees == null){
        return 0;
    }
    int total =0;
    for(Employee emp:employees){
        if(emp != null){
            total += emp.monthlyPay();
        }
    }
    return total;
}
public static void main(String[] args){
    var employees = java.util.List.of(
        new Q03_EmployeePayroll.SalariedEmployee("001","Kai",100000),
        new Q03_EmployeePayroll.HourlyEmployee("002", "Chita",200,200 )
    );
    System.out.println(employees.get(0).summary());
    System.out.println(employees.get(1).summary());
    System.out.println(Q03_EmployeePayroll.totalPayroll(employees));
    

}
}
