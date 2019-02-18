package soft;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;

public class Mall {
    private String name;
    private HashSet<Store> stores;
    private ArrayList<Customer> customers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Store> getStores() {
        return stores;
    }

    public void setStores(HashSet<Store> stores) {
        this.stores = stores;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public void enter(Customer c){

    }
    public void exit(Customer c){

    }
    public ShoppingCart getShoppingCart(){
        return new ShoppingCart();
    }
//    public Enumeration customers(){
//
//    }
//    public Enumeration stores(){
//
//    }
    public void addStore(Store s){

    }
}
