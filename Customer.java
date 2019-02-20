package soft;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
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
        Scanner input =new Scanner(System.in);

        if(cart.getItems().isEmpty())
        {
            System.out.println("There are no any items in your shopping cart");
            return;
        }
        int pos = 1;
        double total = 0;
        for(Item i: cart.getItems()){
            System.out.printf("[%d] - %s %s %s \n", pos++, i.getId(), i.getName(), i.getPrice());
            total += i.getPrice();
        }

        System.out.println("Total: " + total + " tenge");
        System.out.printf("[%d] - Exit\n", pos);
        int  res=-1;
        while(res!=pos){
            res=input.nextInt();
        }
    }

    public void removeItem(Mall m) {
        Scanner input =new Scanner(System.in);

        if(cart.getItems().isEmpty())
        {
            System.out.println("There are no  items in your shopping cart");
            return;
        }
        int res = 0;
        int pos = 0;
        double total = 0;
        do {
            System.out.println("Choose item you want to remove");
            pos=1;
            for (Item i : cart.getItems()) {
                System.out.printf("[%d] - %s %s %s \n", pos++, i.getId(), i.getName(), i.getPrice());
                total += i.getPrice();
            }

            System.out.println("Total: " + total + " tenge");
            System.out.printf("[%d] - Exit\n", pos);
            res=input.nextInt();
        }
        while(res<1||res>pos+1);
        if(res==pos+1){
            return;
        }
        String storeID=cart.getItems().elementAt(res-1).getStoreId();
        for (Store s: m.stores()) {
            String st=s.getStoreId();
            if(st.equals(storeID)){
                s.addItem(cart.getItems().elementAt(res-1));
                cart.removeItem(cart.getItems().elementAt(res-1));
            }

        }





    }
    public void shopping(Mall mall){
        boolean ex=true;

        while(ex) {
            Scanner in=new Scanner(System.in);
            int cart_choice = 0;
            int pos=1;
            String msg = "";
            do {
                System.out.println(msg);
                System.out.printf("[%d] - Show items\n", pos++);
                System.out.printf("[%d] - Remove item\n", pos++);
                System.out.printf("[%d] - Exit\n", pos);

                cart_choice = in.nextInt();
                msg = "Wrong input format, try again\n";
            }
            while (cart_choice < 1 || cart_choice > pos);
            switch (cart_choice) {
                case 1:
                    this.showItems();

                    break;
                case 2:
                    this.removeItem(mall);


                    break;
                case 3:
                    ex=false;
                    break;


            }
        }


    }

}