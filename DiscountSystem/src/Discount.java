public class Discount {
    static double servicesDiscount; // 0 , 20%, 15%, 10%
    static double productsDiscount = 0.1; // may be changed later

    public Discount(){

    }

    public static double getServicesDiscount(Customer.Membership membershipType) {
        switch (membershipType) {
            case NOT_MEMBER:
                servicesDiscount = 0;
                break;
            case PREMIUM:
                servicesDiscount = 0.2;
                break;
            case GOLD:
                servicesDiscount = 0.15;
                break;
            case SILVER:
                servicesDiscount = 0.1;
                break;
        }
        return servicesDiscount;
    }

    public static double getProductsDiscount(Customer.Membership membershipType) {
        if (membershipType == Customer.Membership.NOT_MEMBER)
            return 0;
        else
            return productsDiscount;
    }
}
