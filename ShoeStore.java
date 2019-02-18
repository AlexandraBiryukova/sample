package soft;

import java.util.ArrayList;

public class ShoeStore extends Store {
    @Override
    public void enter(Customer c) {
        ArrayList<Customer> cust=this.getCustomers();
        cust.add(c);
        this.setCustomers(cust);

    }

    @Override
    public void exit(Customer c) {
        ArrayList<Customer> cust=this.getCustomers();
        cust.remove(c);
        this.setCustomers(cust);

    }
}
