package soft;

import java.io.Serializable;

public class Item  implements Serializable {
    private String name;
    private String id;
    private String storeId;
    private double price;

    public Item(String name,String id,String storeId, double price){
        this.name = name;
        this.id = id;
        this.storeId = storeId;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
    public String getStoreId() {
        return storeId;
    }

    @Override
    public String toString() {
        return id +" "+ name+" "+price+" "+storeId;
    }
}
