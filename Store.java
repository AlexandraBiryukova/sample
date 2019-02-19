package soft;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Enumeration;

public abstract class Store {
    private String name;
    private HashMap<Item, Integer> items;
    private ArrayList<Customer> customers;
    private ArrayList<Observer> observers;
    private String storeId;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setItems(HashMap<Item, Integer> items) {
        this.items = items;
    }

    public HashMap<Item, Integer> getItems() {
        return items;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreId() {
        return storeId;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }
    public abstract void enter(Customer c);
    public abstract void exit(Customer c);
    public String customers(){
        String res="";
        for (Customer c:
             customers) {
            res+=c.toString()+"/n";

        }
        return res ;
    }
    public String items(){
        return items.toString();
    }
    public void addObserver(Observer o){
        observers.add(o);

    }
}


