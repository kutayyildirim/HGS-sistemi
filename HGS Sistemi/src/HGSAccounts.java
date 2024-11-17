public abstract class HGSAccounts {
    protected String idNumber;
    protected String lastName;
    protected String vehicleClass;
    protected double balance;
    protected String firstName;

    public HGSAccounts(String idNumber, String lastName, String firstName, String vehicleClass, double balance) {
        this.idNumber = idNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.vehicleClass = vehicleClass;
        this.balance = balance;
    }

    public abstract void displayAccountInfo();
    public abstract void deductBalance(double amount);
    public abstract void addBalance(double amount);
}