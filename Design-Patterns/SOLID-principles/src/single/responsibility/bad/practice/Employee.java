package single.responsibility.bad.practice;

// Single Responsibility Principle
//The single responsibility principle states that every class must have a single, focused responsibility, a single reason to change.
public class Employee {
    public static void main(String[] args) {
        System.out.println("Employee profile:");
        getSalary(100000);
        getEmployeeName("John");
        getEmployeeId(1000);
        getEmployeeDesignation("Manager");
        getEmployeeAddress("123 Main St");
        getEmployeePhone("123-456-7890");
        sendEmail("<EMAIL>");
        sendSMS("123-456-7890");
        sendNotification("Employee has been hired!");
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
    public static void sendEmail(String email){
        System.out.println("Employee email is: "+email);
    }
    public static void sendSMS(String sms){
        System.out.println("Employee sms is: "+sms);
    }
    public static void sendNotification(String notification){
        System.out.println("Employee notification is: "+notification);
    }
    // The code above shows a poor practice since it combines methods specific to defining the employee profile with unrelated methods like sendEmail(), sendSMS(), and sendNotification().
    // A good practice would be creating a separate class called "InformationCenter" to render the methods not specific to the employee profile.
}