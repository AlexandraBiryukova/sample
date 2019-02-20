package soft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GameStore extends Store {

    public void enter(Customer c) {
        Scanner in = new Scanner(System.in);
        System.out.println(String.format("You're welcome to %s, %s", getName(), c.getName()));
        boolean bought=false;
        while(true) {
            if (items().isEmpty()) {
                System.out.println(getName() + " is out of stock");
                return;
            }
            int choice = 0;
            int pos = 1;
            String msg = "";
            if (c.getCart() == null) {
                addObserver(c);
                do {
                    pos = 1;
                    System.out.println(msg);
                    for (Item i : items()) {
                        System.out.println(String.format(" %d. - %s _____ %f tenge", pos++, i.getName(), i.getPrice()));
                    }
                    System.out.printf("[%d] - Exit\n", pos);

                    choice = in.nextInt();
                    msg = "Wrong input format, try again\n";
                }
                while (choice != pos);
                return;
            } else {
                do {
                    pos=1;
                    System.out.println(msg);
                    for (Item i : items()) {
                        System.out.println(String.format("[%d] - %s _____ %f tenge", pos++, i.getName(), i.getPrice()));
                    }

                    System.out.printf("[%d] - Shopping cart\n", pos);
                    System.out.printf("[%d] - Exit\n", pos + 1);

                    choice = in.nextInt();
                    msg = "Wrong input format, try again\n";
                }
                while (choice < 1 || choice > pos + 1);

                if (choice == pos) {
                    c.showItems();
                } else if (choice == pos + 1) {
                    if(bought)
                        addCustomer(c);
                    return;
                } else {
                    Item cur = items().get(choice - 1);
                    msg = "";
                    do {
                        System.out.println(msg);
                        System.out.printf("%s, %f tenge\n\n", cur.getName(), cur.getPrice());
                        System.out.println("[1] - Buy");
                        System.out.println("[2] - Back");

                        choice = in.nextInt();
                        msg = "Wrong input format, try again\n";
                    }
                    while (choice < 1 || choice > 2);

                    if (choice == 1) {
                        bought=true;
                        addCustomer(c);
                        c.addItem(cur);
                        items().remove(cur);
                    }
                }
            }
        }
    }

    @Override
    public void exit(Customer c) {
        if(c.getCart()!=null) {
            ArrayList<Customer> cust = this.getCustomers();
            cust.remove(c);
            this.setCustomers(cust);



        }else{
            ArrayList<Customer> o=getObservers();
            o.remove(c);
            setObservers(o);
        }

    }
}