package soft;

import java.io.*;
import java.util.*;

public class Mall implements Serializable {
    private String name;
    private ArrayList<Store> stores;
    private ArrayList<Customer> customers;

    {
        stores = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Store> stores() {
        return stores;
    }

    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Customer> customers() {
        return customers;
    }

    public void enter(Customer cs){
        Scanner in = new Scanner(System.in);
        System.out.printf("You're welcome, %s\n", cs.getName());
        while(true)
        {
            int choice = 0;
            int pos=1;
            String msg = "";
            do{
                System.out.println(msg);

                for(Store st: stores())
                {
                    System.out.printf("[%d] - %s : %s\n", pos++, st.getName(), st.getClass().getSimpleName());
                }

                if(cs.getCart()!=null)
                    System.out.printf("[%d] - Shopping cart\n", pos);
                else{
                    System.out.printf("[%d] - Take the shopping cart\n", pos);
                }
                System.out.printf("[%d] - Exit\n", pos+1);

                choice = in.nextInt();
                msg = "Wrong input format, try again\n";
            }
            while(choice<1 || choice>pos+1);


            if(choice == pos){
                if(cs.getCart()!=null)
                    cs.showItems();
                else{
                    cs.setCart(getShoppingCart());
                }
            }
            else if(choice == pos+1){
                exit(cs);
                return;
            }
            else
            {
                if(this.stores.get(choice-1).getItems().isEmpty()){
                    System.out.println(this.stores.get(choice-1).getName() + " is out of stock");
                }
                else
                {
                    this.stores.get(choice-1).enter(cs);
                }
            }
        }
    }

    public void exit(Customer c){
        double sum = 0;
        for (Item i: c.getCart().getItems()
        ) {
            sum+= i.getPrice();
        }
        System.out.println("Goodbye, You Spend: " + sum + " tenge.");
        save();
    }

    public ShoppingCart getShoppingCart(){
        return new ShoppingCart();
    }

    public void addStore(Store s){
        if(this.stores.contains(s)){
            System.out.println("Such store exist");
        }else{
            this.stores.add(s);
        }
    }
    public void save(){
        try {
            FileOutputStream out = new FileOutputStream("Storage.out");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(this);
            oos.flush();
            oos.close();

        }catch (Exception e){

        }
    }
    public Mall get(){
        Mall m = new Mall();
        try{
            FileInputStream in=new FileInputStream("Storage.out");
            ObjectInputStream ois=new ObjectInputStream(in);
            m = (Mall)ois.readObject();
            ois.close();

        }catch(Exception e){

        }
        return m;
    }

}