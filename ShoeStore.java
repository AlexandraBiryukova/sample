package soft;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoeStore extends Store {
    @Override
    public void enter(Customer c) {
        if(c.getCart()!=null) {
            ArrayList<Customer> cust = this.getCustomers();
            cust.add(c);
            this.setCustomers(cust);
        }else{
            super.addObserver((Observer)c);
        }

    }

    @Override
    public void exit(Customer c) {
        if(c.getCart()!=null) {
            ArrayList<Customer> cust = this.getCustomers();
            cust.remove(c);
            this.setCustomers(cust);
            HashMap<Item, Integer> purchase=c.getCart().getItems();
            HashMap<Item, Integer> allItems=super.getItems();

            for (Item i:purchase.keySet()
                 ) {
                allItems.replace(i,allItems.get(i),allItems.get(i)-purchase.get(i));
            }
            setItems(allItems);
            c.setCart(new ShoppingCart());


        }else{
            ArrayList<Observer> o=getObservers();
            o.remove((Observer)c);
            setObservers(o);
        }

    }
}
