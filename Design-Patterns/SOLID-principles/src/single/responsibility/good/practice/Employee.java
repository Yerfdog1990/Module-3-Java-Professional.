package single.responsibility.good.practice;

public class Employee {
    public static void main(String[] args) {
        System.out.println("Employee profile only:");
        getSalary(100000);
        getEmployeeName("John");
        getEmployeeId(1000);
        getEmployeeDesignation("Manager");
        getEmployeeAddress("123 Main St");
        getEmployeePhone("123-456-7890");
    }
    public static void getSalary(int salary){
        System.out.println("Employee's salary is: "+salary);
    }
    public static void getEmployeeName(String name){
        System.out.println("Employee name is: "+name);
    }
    public static void getEmployeeId(int id){
        System.out.println("Employee id is: "+id);
    }
    public static void getEmployeeDesignation(String designation){
        System.out.println("Employee designation is: "+designation);
    }
    public static void getEmployeeAddress(String address){
        System.out.println("Employee address is: "+address);
    }
    public static void getEmployeePhone(String phone){
        System.out.println("Employee phone is: "+phone);
    }
    // The code above shows a good practice since contains only methods specific to defining the employee profile.
}

