package soft;

import java.io.Serializable;
import java.util.*;

public abstract class Store implements Serializable {
    private String name;
    private ArrayList<Item> items;
    private ArrayList<Customer> customers;
    private ArrayList<Observer> observers;
    private String storeId;

    {
        items = new ArrayList<>();
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
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
    public ArrayList<Item> items(){
        return items;
    }
    public void addObserver(Observer o){
        observers.add(o);
    }

    public void addItem(Item i){
        if(this.items.contains(i)){
            System.out.println("Item is also exist");
        }else{
            this.items.add(i);
        }
    }

}
