package soft;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

public class ShoppingCart implements Serializable {
    private Vector<Item> items = new Vector<>();

    public void setItems(Vector<Item> items) {
        this.items = items;
    }

    public Vector<Item> getItems() {
        return items;
    }

    public void addItem(Item i){
        if(this.items.contains(i)){
            System.out.println("Such item already exists");
        }else{
            this.items.add(i);
        }
    }

    public void removeItem(Item i){
        items.remove(i);

    }
}