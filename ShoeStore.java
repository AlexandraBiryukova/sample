package soft;

import java.util.ArrayList;

public class ShoeStore extends Store {
    @Override
    public void enter(Customer c) {
        ShoppingCart sh=c.getCart();
        if(sh!=null) {
            ArrayList<Customer> cust = this.getCustomers();
            cust.add(c);
            this.setCustomers(cust);
        }else{
            super.addObserver((Observer)c);
        }

    }

    @Override
    public void exit(Customer c) {
        ArrayList<Customer> cust=this.getCustomers();
        cust.remove(c);
        this.setCustomers(cust);

    }
}
