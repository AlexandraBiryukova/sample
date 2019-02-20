package soft;

import java.util.Scanner;

public class Main {


    public static void main(String[] args)
    {

        Mall mall=new Mall();
        mall=mall.get();


        Customer c = new Customer();


        Scanner in = new Scanner(System.in);
        int choice = 0;
        String msg = "";
        do {

            System.out.println(msg);
            System.out.println("[1] - Enter to " + mall.getName());
            System.out.println("[2] - Exit");
            choice = in.nextInt();
            msg = "Wrong input format, try again\n";
        }
        while(choice<1 || choice>2);

        switch (choice)
        {
            case 1:
                String name="";
                do {
                    System.out.println("Please, write your name: ");
                    name = in.next();
                }
                while(name==null);
                c.setName(name);
                int choice_cart = 0;
                msg="";
                do {
                    System.out.println(msg);
                    System.out.println("Would you like to take a cart?");
                    System.out.println("[1] - Yes");
                    System.out.println("[2] - No");
                    choice_cart = in.nextInt();
                    msg="Wrong input format, try again\n";

                }
                while(choice_cart<1 || choice_cart>2);
                switch(choice_cart){
                    case 1:
                        c.setCart(new ShoppingCart());
                        break;
                    case 2:
                        c.setCart(null);
                        break;
                }

                mall.enter(c);
                break;
            case 2:
                break;
        }
    }

}