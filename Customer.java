package soft;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Vector;

public class Customer implements Serializable {
    private ShoppingCart cart;
    private String name;
    private Store store;

    {
        cart = new ShoppingCart();
    }

    public Customer()
    {

    }
    public Customer(String name){
        this.name = name;
        store = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return name +" "+ cart.toString() +" "+ store.toString();
    }

    public void addItem(Item i) {
        cart.addItem(i);
    }
    public void showItems(){

        if(cart.getItems().isEmpty())
        {
            System.out.println("There are no any items in your shopping cart");
            return;
        }
        int pos = 0;
        double total = 0;
        for(Item i: cart.getItems()){
            System.out.printf("[%d] - %s %s %s \n", ++pos, i.getId(), i.getName(), i.getPrice());
            total += i.getPrice();
        }

        System.out.println("Total: " + total + " tenge");
    }

}