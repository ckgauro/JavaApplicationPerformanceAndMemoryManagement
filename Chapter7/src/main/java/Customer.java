public class Customer implements ReadOnlyCustomer {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(Customer c){
        this.name=c.getName();
    }

    @Override
    public String toString() {
        return name;
    }

}
