package structural.pattern.composite;

public class Client {
    public static void main(String[] args) {
        Employee CEO = new Employee("John","CEO", 30000);

        Employee headSales = new Employee("Robert","Head Sales", 20000);

        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);
        Employee salesExecutive3 = new Employee("Michel","Sales", 10000);

        // Add CEO subordinates
        CEO.add(headSales);
        CEO.add(headMarketing);

        // Add head of sales subordinates
        headSales.add(clerk1);
        headSales.add(clerk2);

        // Add head of marketing subordinates
        headMarketing.add(salesExecutive1);
        headMarketing.add(salesExecutive2);
        headMarketing.add(salesExecutive3);

    // Print all employees of the organization
    System.out.println(CEO);
    for (Employee headEmployee : CEO.getSubordinates()) {
        System.out.println(headEmployee);
        for (Employee employee : headEmployee.getSubordinates()) {
            System.out.println(employee);
        }
    }
  }
}
