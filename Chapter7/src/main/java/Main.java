import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        CustomerRecords records = new CustomerRecords();

        records.addCustomer(new Customer("John"));
        records.addCustomer(new Customer("Simon"));

        //records.getCustomers().clear();
//        for (Customer next : records.getCustomers().values())
//        {
//            System.out.println(next);
//        }

        //Implemented Itra
        for(Customer next:records){
            System.out.println(next);
        }

        Iterator<Customer> it=records.iterator();
        it.next();
        it.remove();
        for(Customer next:records){
            System.out.println(next);
        }




    }

}
