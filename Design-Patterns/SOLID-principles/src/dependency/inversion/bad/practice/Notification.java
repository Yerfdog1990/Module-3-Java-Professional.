package dependency.inversion.bad.practice;

/*
Dependency Inversion Principle
In the dependency inversion principle, high-level modules should not depend on low-level modules.
In other words, you must follow abstraction and ensure loose coupling
 */
public interface Notification {
    void sendNotification();
}
class EmailNotification implements Notification {
    @Override
    public void sendNotification() {
        System.out.println("Email sent");
    }
}
class Employee{
    private EmailNotification emailNotification;
    public Employee(EmailNotification emailNotification) {
        this.emailNotification = emailNotification;
    }
    public void notifyUser(){
        emailNotification.sendNotification();
    }
}
class Main {
    public static void main(String[] args) {
        EmailNotification employee = new EmailNotification();
        Employee employeeNotification = new Employee(employee);
        employeeNotification.notifyUser();
    }
    /*
    In the given example, the Employee class depends directly on the EmailNotification class, which is a low-level module.
    This violates the dependency inversion principle.
     */
}
