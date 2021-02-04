public class Customer {
    private String name;

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

    public String toString() {
        return name;
    }

}
