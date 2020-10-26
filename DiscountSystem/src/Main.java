import java.util.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static List<Customer> customers = new ArrayList<>();
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1.New Check in\t2.Exit");
            choice = Integer.parseInt(scan.nextLine());
            if (choice == 1) {
                newCheckIn();
            }
        } while (choice != 2);
    }

    public static void newCheckIn() {
        int customerNumber = checkIn();
        Customer customer = customers.get(customerNumber);
        Visit visit = new Visit(customer);
        System.out.printf("This is %s's visit #%d.\n", customer.getName(), customer.getNumberOfVisits());
        int choice;
        do {
            System.out.println("1.Buy products\t2.Get services\t3.Products & Services\n4.Change customer's details\t5.Finish the visit");
            choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter the products cost:");
                    visit.setProducts(Double.parseDouble(scan.nextLine()));
                    System.out.printf("Products cost after discount : %.2f EGP\n", visit.getProductsBill());
                    break;
                case 2:
                    System.out.print("Enter the services cost:");
                    visit.setServices(Double.parseDouble(scan.nextLine()));
                    System.out.printf("Services cost after discount : %.2f EGP\n", visit.getServicesBill());
                    break;
                case 3:
                    System.out.print("Enter the products cost:");
                    visit.setProducts(Double.parseDouble(scan.nextLine()));
                    System.out.print("Enter the services cost:");
                    visit.setServices(Double.parseDouble(scan.nextLine()));
//                    System.out.printf("Products cost after discount : %.2f EGP\n", visit.getProductsBill());
//                    System.out.printf("Services cost after discount : %.2f EGP\n", visit.getServicesBill());
                    System.out.printf("Total Bill : %.2f EGP\n", visit.getTotalBill());
                    break;
                case 4:
                    changeCustomerDetails(customer);
                    break;
            }
        } while (choice != 5);
    }

    public static void changeCustomerDetails(Customer customer) {
        int choice;
        do {
            System.out.println("1.Change name\t2.Change membership type\t3.Exit");
            choice = Integer.parseInt(scan.nextLine());
            if (choice == 1) {
                System.out.println("Enter new name:");
                customer.changeName(scan.nextLine());
                System.out.println("Done!\nCustomer's new name is " + customer.getName());
            } else if (choice == 2) {
                customer.changeMembershipType(determineMembershipType());
            }
        } while (choice != 3);
    }

    public static int checkIn() {
        System.out.println("Enter customer's id:");
        String idToFind = scan.nextLine();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(idToFind)) {
                return i;
            }
        }
        System.out.println("This is the first visit.");
        return newCustomer(idToFind);
    }

    public static int newCustomer(String id) {
        System.out.println("Please enter customer's name:");
        String name = scan.nextLine();
        Customer.Membership membershipType = determineMembershipType();
        Customer customer = new Customer(name, id, membershipType);
        customers.add(customer);
        System.out.println("Registration Completed.");
        return customers.size() - 1;
    }

    public static Customer.Membership determineMembershipType() {
        int choice;
        Customer.Membership membershipType = Customer.Membership.NOT_MEMBER;
        do {
            System.out.println("Please select membership type:");
            System.out.println("1.Premium\t2.Gold\t3.Silver\t4.Not member");
            choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    membershipType = Customer.Membership.PREMIUM;
                    break;
                case 2:
                    membershipType = Customer.Membership.GOLD;
                    break;
                case 3:
                    membershipType = Customer.Membership.SILVER;
                    break;
                case 4:
                    membershipType = Customer.Membership.NOT_MEMBER;
                    break;
            }
        } while (choice > 4 || choice < 1 );
        return membershipType;
    }
}
