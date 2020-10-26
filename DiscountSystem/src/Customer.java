public class Customer {
    private String name;
    private String id;
    private int numberOfVisits = 0;
    enum Membership {
        NOT_MEMBER,
        PREMIUM,
        GOLD,
        SILVER
    }
    Membership membershipType;

    public Customer(String name, String id, Membership membershipType) {
        this.name = name;
        this.id = id;
        this.membershipType = membershipType;
    }

    public String getName() { return name; }
    public void changeName(String name) { this.name = name; }
    public String getId() { return id; }
    public Membership getMembershipType() {return membershipType; }
    public void changeMembershipType(Membership membershipType) { this.membershipType = membershipType; }
    public int getNumberOfVisits() { return numberOfVisits; }
    public void newVisit() { numberOfVisits++; }
}
