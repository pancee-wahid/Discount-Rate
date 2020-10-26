public class Visit {
    private Customer customer;
    private double services;
    private double products;

    public Visit(Customer customer) {
        this.customer = customer;
        customer.newVisit();
    }

    public void setServices(double services) { this.services = services; }

    public void setProducts(double products) { this.products = products; }

    public double getServicesBill() {
        services -= services * Discount.getServicesDiscount(customer.getMembershipType());
        return services;
    }

    public double getProductsBill() {
        products -= products * Discount.getProductsDiscount(customer.getMembershipType());
        return products;
    }

    public double getTotalBill() {
        services = getServicesBill();
        products = getProductsBill();
        return services + products;
    }


}
