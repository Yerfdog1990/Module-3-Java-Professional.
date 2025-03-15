package single.responsibility.good.practice;

public class InformationCenter {
    public static void main(String[] args) {
        System.out.println("Employee profile:");
        sendEmail("<EMAIL>");
        sendSMS("123-456-7890");
        sendNotification("Employee has been hired!");
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
    // The code above shows a good practice since it contains methods specific to defining what happens in the information center.
}
