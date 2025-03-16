package dependency.inversion.good.practice;

public interface Notification {
    void notify(String message);
}
class EmailNotification implements Notification {
    @Override
    public void notify(String message) {
        System.out.println("Email sent: " + message);
    }
}
class Employee{
    private Notification notification;
    public Employee(Notification notification) {
        this.notification = notification;
    }
    public void notifyUser(String message){
        notification.notify(message);
    }
}
class Main {
    public static void main(String[] args) {
       Notification emailNotification = new EmailNotification();
       Employee employee = new Employee(emailNotification);
       employee.notifyUser("Hello World!");
    }
}