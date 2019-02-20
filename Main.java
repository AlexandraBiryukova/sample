package soft;

import java.util.Scanner;

public class Main {


    public static void main(String[] args)
    {
        Mall mall = new Mall();
//        Store store1 = new GameStore();
//        Store store2 = new ShoeStore();
//        Store store3 = new BookStore();
//        Store store4 = new BookStore();
//
//        store1.setName("Game Store");
//        store2.setName("Shoe Store");
//        store3.setName("Book Store");
//        store4.setName("Meloman");
//
//        store1.setStoreId("Game Store");
//        store2.setStoreId("Shoe Store");
//        store3.setStoreId("Book Store");
//        store4.setStoreId("Meloman");
//
//
//        store1.addItem(new Item("Game1", "Game1", store1.getStoreId(), 150));
//        store1.addItem(new Item("Game2", "Game2", store1.getStoreId(), 175.8));
//        store1.addItem(new Item("Game3", "Game3", store1.getStoreId(), 800));
//
//        store2.addItem(new Item("Shoe1", "Shoe1", store2.getStoreId(), 890.2));
//        store2.addItem(new Item("Shoe2", "Shoe2", store2.getStoreId(), 740.4));
//        store2.addItem(new Item("Shoe3", "Shoe3", store2.getStoreId(), 123));
//        store2.addItem(new Item("Shoe4", "Shoe4", store2.getStoreId(), 321));
//
//        store3.addItem(new Item("Book1", "Book1", store3.getStoreId(), 1000));
//        store3.addItem(new Item("Book2", "Book2", store3.getStoreId(), 1900));
//        store3.addItem(new Item("Book3", "Book3", store3.getStoreId(), 2500.4243));
//        store3.addItem(new Item("Book4", "Book4", store3.getStoreId(), 1231.4124));
//        store3.addItem(new Item("Book5", "Book1", store3.getStoreId(), 214.4214124));
//
//
//        mall.setName("DOSTYK PLAZA");
//        mall.addStore(store1);
//        mall.addStore(store2);
//        mall.addStore(store3);
//        mall.addStore(store4);
//        mall.save();
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