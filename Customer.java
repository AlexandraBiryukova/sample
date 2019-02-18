package soft;

public class Customer {
    private ShoppingCart cart;
    private String name;
    private Store store;

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
}
